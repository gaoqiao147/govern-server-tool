package com.freesofts.lowcode.common.enums;

/**
 * Description:标记 ’是否‘ 枚举类 </br>
 * date: 2020/6/29 11:10</br>
 *
 * @author: Administrator</ br>
 * @since JDK 1.8
 */
public enum CommonFlagEnum {

    /**
     * 是
     */
    YES(1,"是"),

    /**
     * 否
     */
    NO(0,"否");

    private Integer flag;

    private String description;

    CommonFlagEnum(Integer flag, String description){
        this.flag = flag;
        this.description = description;
    }

    public Integer getFlag() {
        return flag;
    }

    public String getDescription(){return description;}
}
