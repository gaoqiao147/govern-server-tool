package com.freesofts.lowcode.common.entity;

import com.freesofts.lowcode.common.depart.CommonService;
import com.freesofts.lowcode.common.depart.Organization;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;

/**
 * Description: </br>
 * date: 2020/6/29 14:04</br>
 *
 * @author: Administrator</       br>
 * @since JDK 1.8
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DepartBasicEntity extends ExtensionBasicEntity {


    /**
     * 行政区划编码
     */
    private String departCode;

    /**
     * 行政区划名称
     */
    private String departName;


    /**
     * 初始化插入参数
     */
    @Override
    public void paramForInsert() {
        super.paramForInsert();
        //如果组织编码为空，则获取当前登录用户的行政区划编码
        if (StringUtils.isEmpty(this.getDepartCode())) {
            Organization organization = CommonService.getDepartCode(null);
            if (StringUtils.isEmpty(this.getDepartCode())) {

                this.setDepartCode(organization.getAdministrativeCode());
            }
            if (StringUtils.isEmpty(this.getDepartName())) {

                this.setDepartName(organization.getShortName());
            }

        }
//        this.setDepartCode("1");
//        this.setDepartName("root");
    }


}
