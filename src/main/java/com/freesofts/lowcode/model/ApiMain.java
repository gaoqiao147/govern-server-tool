package com.freesofts.lowcode.model;

import com.freesofts.lowcode.common.entity.ExtensionBasicEntity;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 接口信息主类
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-26
 */
@Table(name = "api_main")
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class ApiMain extends ExtensionBasicEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 接口名称
     */
    @Column(name = "name")
    @NotBlank(message = "接口不能为空")
    private String name;
    /**
     * 请求方式
     */
    @Column(name = "method")
    @NotBlank(message = "请求方式不能为空")
    private String method;
    /**
     * 请求路径（去掉前缀）
     */
    @Column(name = "path")
    @NotBlank(message = "请求路径不能为空")
    private String path;
    /**
     * 接口描述
     */
    @Column(name = "description")
    @NotBlank(message = "接口描述不能为空")
    private String description;
    /**
     * 接口状态 0 正常 1 注销
     */
    @Column(name = "state")
    private String state;
    /**
     * 是否启用数据源  0 启用  1 不启用
     */
    @Column(name = "enable")
    private String enable;
    /**
     * 执行语句
     */
    @Column(name = "execute_sql")
    private String executeSql;
    /**
     * 请求参数列表
     */
    @Transient
    @ApiModelProperty(notes = "请求参数")
    private List<ApiParameter> parameters = Lists.newArrayList();

    /**
     * 请求参数列表
     */
    @ApiModelProperty(notes = "输入参数,用户选择的要输入的参数")
    private List<ApiParams> parametersOut =  Lists.newArrayList();
}
