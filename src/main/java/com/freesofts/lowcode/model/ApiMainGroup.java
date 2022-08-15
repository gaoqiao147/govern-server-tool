package com.freesofts.lowcode.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * <p>
 * 接口与分组关联信息表
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-26
 */
@Table(name = "api_main_group")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ApiMainGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 接口主表id
     */
    @Id
    @Column(name = "api_id")
    private String apiId;
    /**
     * 分组id
     */
    @Id
    @Column(name = "group_id")
    private String groupId;
    /**
     * 0 创建分组 1 引用分组
     */
    @Column(name = "quote")
    private String quote;
}
