package com.freesofts.lowcode.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 请求参数信息表
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-26
 */
@Table(name = "api_parameter")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ApiParameter implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
    @Id
    @Column(name = "id")
    private String id;
    /**
     * 通过接口id查询请求头
     * 接口id
     */
    @Column(name = "api_id")
    @NotNull(message = "接口id不能为空")
    private String apiId;
    /**
     * 参数名
     */
    @Column(name = "key")
    private String key;
    /**
     * 参数默认值
     */
    @Column(name = "default_value")
    private String defaultValue;
    /**
     * 参数描述
     */
    @Column(name = "description")
    private String description;
    /**
     * 是否必填 0 必填 1 非必填
     */
    @Column(name = "required")
    private String required;
    /**
     * 数据类型
     */
    @Column(name = "data_type")
    private String dataType;
    /**
     * 验证类型 0 不验证 1 表达式验证 2 正则验证
     */
    @Column(name = "validate_type")
    private String validateType;
    /**
     * 验证不通过说明
     */
    @Column(name = "error")
    private String error;
    /**
     * 验证表达式
     */
    @Column(name = "expression")
    private String expression;
    /**
     * 排序
     */
    @Column(name = "sort")
    private Integer sort;
}
