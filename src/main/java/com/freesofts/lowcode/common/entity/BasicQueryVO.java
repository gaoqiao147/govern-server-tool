package com.freesofts.lowcode.common.entity;

import com.freesofts.lowcode.common.depart.CommonService;
import com.freesofts.lowcode.common.depart.Organization;
import lombok.Data;

/**
 * Description: </br>
 * <p>版权所有：</p>
 * 未经本公司许可，不得以任何方式复制或使用本程序任何部分
 * <p>
 * 杭州孚立计算机软件有限公司
 *
 * @author LargerBear</ br>
 * date: 2020/10/15 20:17</br>
 * @since JDK 1.8
 */
@Data
public class BasicQueryVO {

    /**
     * 行政区划编码
     */
    private String departCode;


    public BasicQueryVO() {
        Organization organization = CommonService.getDepartCode(null);
        //获取行政区划级别
        this.getSubCode(organization);
        String root = "000000000000";
        //如果是超级管理员用户，则放开所有R
        if (root.equals(organization.getAdministrativeCode())) {
            this.setDepartCode(null);
        } else {
            this.setDepartCode(this.departCode);
        }
        //        this.setDepartCode("1");
        //        this.setDepartName("root");
    }

    /**
     * 获取切割后的行政区划编码
     *
     * @param organization
     */
    private void getSubCode(Organization organization) {
        //获取级别所在索引值
        int ordinal = organization.getAdministrativeLevel().ordinal();
        departCode = organization.getAdministrativeCode().substring(0, ordinal * 2);
    }
}
