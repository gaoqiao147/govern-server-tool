package com.freesofts.lowcode.model;

import com.freesofts.lowcode.common.entity.ExtensionBasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * <p>
 * 分组信息表
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "api_group")
@Accessors(chain = true)
public class ApiGroup extends ExtensionBasicEntity implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 分组名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 分组父级id
     */
    @Column(name = "p_id")
    private String pId;

    /**
     * 分组描述
     */
    @Column(name = "description")
    private String description;

    /**
     * 数据源id
     */
    @Column(name = "data_source_id")
    private String dataSourceId;

}
