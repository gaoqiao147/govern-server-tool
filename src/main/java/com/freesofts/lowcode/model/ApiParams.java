package com.freesofts.lowcode.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author zhouwei
 */
@Table(name = "api_params")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ApiParams {
    /**
     * 用户要输入的参数id
     */
    @Column(name = "id")
    private String id;

    @Column(name = "api_id")
    private String apiId;

    /**
     * 参数名称
     */
    @Column(name = "key")
    private String key;

    /**
     * 参数类型
     */
    @Column(name = "data_type")
    private String dataType;
}
