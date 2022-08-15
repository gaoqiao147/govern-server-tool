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
 * 接口调用日志表
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "api_log")
@Accessors(chain = true)
public class ApiLog extends ExtensionBasicEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 访问ip
     */
    @Column(name = "visit_ip")
    private String visitIp;
    /**
     * 厂商名称id
     */
    @Column(name = "mri_id")
    private String mfrId;
    /**
     * 厂商名称
     */
    @Column(name = "mfr_name")
    private String mfrName;
    /**
     * 请求方式
     */
    @Column(name = "method")
    private String method;
    /**
     * 接口id
     */
    @Column(name = "api_id")
    private String apiId;
    /**
     * 接口名称
     */
    @Column(name = "api_name")
    private String apiName;
    /**
     * 调用是否通过
     */
    @Column(name = "is_pass")
    private String isPass;
    /**
     * 入参请求头
     */
    @Column(name = "enter_header")
    private String enterHeader;
    /**
     * 入参请求体
     */
    @Column(name = "enter_param")
    private String enterParam;
    /**
     * 返回结果
     */
    @Column(name = "result_body")
    private String resultBody;
}
