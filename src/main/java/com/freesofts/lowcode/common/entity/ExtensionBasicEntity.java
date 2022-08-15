package com.freesofts.lowcode.common.entity;

import com.freesofts.lowcode.common.depart.CommonService;
import com.freesofts.lowcode.common.enums.CommonFlagEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.UUID;

/**
 * Description: </br>
 * date: 2020/6/29 14:04</br>
 *
 * @author: Administrator</ br>
 * @since JDK 1.8
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ExtensionBasicEntity extends BasicEntity {
//
//    /**
//     * 是否删除
//     */
//    private Integer delFlag;
//
//    /**
//     * 是否作废
//     */
//    private Integer disableFlag;



    public void paramForInsert(){
        //32位随机数
        if (null != this.getId()){
            this.setId(UUID.randomUUID().toString().replace("-",""));
        }
        if (null == this.getCreatedBy()){
            this.setCreatedBy(CommonService.getUserDetail().getId());
//            this.setCreatedBy("1");
        }
        if (null == this.getCreatedName()){
            this.setCreatedName(CommonService.getUserDetail().getUsername());
//            this.setCreatedName("admin");
        }
        if (null == this.getCreatedDate()){
            this.setCreatedDate(new Date());
        }
        if (null == this.getLastModifiedBy()){
            this.setLastModifiedBy(CommonService.getUserDetail().getId());
//            this.setLastModifiedBy("1");
        }
        if (null == this.getLastModifiedName()){
            this.setLastModifiedName(CommonService.getUserDetail().getUsername());
//            this.setLastModifiedName("admin");
        }
        if (null == this.getLastModifiedDate()){
            this.setLastModifiedDate(new Date());
        }
//        this.setDelFlag(CommonFlagEnum.NO.getFlag());
//        this.setDisableFlag(CommonFlagEnum.NO.getFlag());
    }

    /**
     * 初始化修改参数
     * @param
     */
    public void paramForUpdate(){
        this.setLastModifiedBy(CommonService.getUserDetail().getId());
        this.setLastModifiedName(CommonService.getUserDetail().getUsername());
//        this.setLastModifiedBy("1");
//        this.setLastModifiedName("admin");
        this.setLastModifiedDate(new Date());
    }

    /**
     * 初始化逻辑删除参数
     */
    public void paramForDelete(){
        this.setLastModifiedBy(CommonService.getUserDetail().getId());
        this.setLastModifiedName(CommonService.getUserDetail().getUsername());
//        this.setLastModifiedBy("1");
//        this.setLastModifiedName("admin");
//        this.setLastModifiedDate(new Date());
//        this.setDelFlag(CommonFlagEnum.YES.getFlag());
    }
}
