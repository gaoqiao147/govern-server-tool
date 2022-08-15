package com.freesofts.lowcode.model;

import com.freesofts.lowcode.common.entity.ExtensionBasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author Administrator
 */
@Table(name = "dev_catalog")
@Data
@EqualsAndHashCode(callSuper = true)
public class DevCatalog extends ExtensionBasicEntity {
    /**
     * 目录名称
     */
    @Column(name = "catalog_name")
    private String catalogName;
    /**
     * 目录描述
     */
    @Column(name = "catalog_desc")
    private String catalogDesc;
    /**
     * 父目录标识
     */
    @Column(name = "parent_id")
    private String parentId;
    /**
     * 目录类型
     */
    @Column(name = "catalog_type")
    private Integer catalogType;
    /**
     * 目录层级
     */
    @Column(name = "catalog_level")
    private Integer catalogLevel;
    /**
     * 目录排序
     */
    @Column(name = "catalog_sort")
    private Integer catalogSort;
}