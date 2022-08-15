package com.freesofts.lowcode.model;

import com.freesofts.lowcode.common.entity.ExtensionBasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * <p>
 * 数据源配置表
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-26
 */
@Table(name = "api_data_source")
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class ApiDataSource extends ExtensionBasicEntity implements Serializable {

    private static final long serialVersionUID=1L;
    /**
     * 驱动类型 1 mysql 2 oracle
     */
    @Column(name = "type")
    private String type;

    /**
     * 数据源名称
     */
    @Column(name ="name")
    private String name;

    /**
     * 数据源url
     */
    @Column(name = "url")
    private String url;

    /**
     * 数据源ip
     */
    @Column(name = "host")
    private String host;

    /**
     * 数据源端口
     */
    @Column(name = "port")
    private String port;

    /**
     * 数据库名称
     */
    @Column(name = "data_base")
    private String dataBase;

    /**
     * 用户名
     */
    @Column(name = "username")
    private String username;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 数据源描述
     */
    @Column(name = "description")
    private String description;
}
