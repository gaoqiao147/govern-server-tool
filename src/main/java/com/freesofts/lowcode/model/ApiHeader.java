package com.freesofts.lowcode.model;

import com.freesofts.lowcode.common.entity.ExtensionBasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <p>
 * 请求头信息表
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "api_header")
@Accessors(chain = true)
public class ApiHeader implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
    @Id
    @Column(name = "id")
    private String id;
    /**
     * 接口id
     */
    @Column(name = "api_id")
    private String apiId;
    /**
     * 参数名
     */
    @Column(name = "key")
    @NotBlank(message = "参数名不能为空！")
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
     * 排序
     */
    @Column(name = "sort")
    private Integer sort;
}
