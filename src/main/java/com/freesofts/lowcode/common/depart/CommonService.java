package com.freesofts.lowcode.common.depart;

import com.freesofts.lowcode.common.feign.SupportFeignService;
import com.freesofts.support.model.Tasktmpost;
import com.freesofts.threader.LoginAppUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Set;

/**
 * Description: </br>
 * <p>版权所有：</p>
 * 未经本公司许可，不得以任何方式复制或使用本程序任何部分
 * <p>
 * 杭州孚立计算机软件有限公司
 *
 * @author LargerBear</ br>
 * date: 2020/9/14 14:20</br>
 * @since JDK 1.8
 */
@Component
@Slf4j
public class CommonService {

    @Resource
    private SupportFeignService organizationFeignService;

    /**
     * 本类
     */
    private static CommonService commonService;

    @PostConstruct
    public void init(){
        commonService = this;
        commonService.organizationFeignService = this.organizationFeignService;
    }

    /**
     * 根据用户id查询用户详情接口
     */
    public static LoginAppUser getUserDetail(){
        LoginAppUser user = (LoginAppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (null == user){
            throw new RuntimeException("用户不存在或者已删除");
        }
        return user;
    }

    /**
     * 根据用户id查询用户组织部门信息
     */
    public static Organization getUserDepartDetail(String organizationId){
        Organization organization;
        //如果组织id为空，则通过当前登录用户查询
        if (StringUtils.isEmpty(organizationId)){
            organizationId = getOrganizationId();
        }
        if (StringUtils.isEmpty(organizationId)){
            throw new RuntimeException("组织信息不能为空");
        }
        try {
            organization = commonService.organizationFeignService.getOrganizationById(organizationId);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("获取组织信息失败");
        }
        return organization;
    }

    /**
     * 获取当前登录用户组织id
     * @return
     */
    private static String getOrganizationId(){
        String organizationId = null;
        Set<Tasktmpost> tasktmposts = getUserDetail().getTasktmposts();
        //取列表中的第一个
        if (tasktmposts.iterator().hasNext()){
            Tasktmpost tasktmpost = tasktmposts.iterator().next();
            organizationId = tasktmpost.getOrganizationId();
        }
        return organizationId;
    }


    /**
     * @param userDepartDetail
     * @return
     */
    private static Organization getCode(Organization userDepartDetail) {
        //获取行政区划编码
        if (!StringUtils.isEmpty(userDepartDetail.getAdministrativeCode())) {
            return userDepartDetail;
        } else {
            Organization userDepartDetailParent = CommonService.getUserDepartDetail(userDepartDetail.getParentId());
            return getCode(userDepartDetailParent);
        }
    }

    /**
     * 获取最终有行政区划存在的父级
     * @param organizationId
     * @return
     */
    public static Organization getDepartCode(String organizationId) {
        Organization userDepartDetail = CommonService.getUserDepartDetail(organizationId);
        if (null == userDepartDetail) {
            throw new RuntimeException("组织信息不能为空");
        }
        //获取最终有行政区划存在的父级
        //获取行政区划编码
        return CommonService.getCode(userDepartDetail);
    }


}
