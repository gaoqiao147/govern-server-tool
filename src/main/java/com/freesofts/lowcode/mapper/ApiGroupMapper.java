package com.freesofts.lowcode.mapper;

import com.freesofts.lowcode.common.mybatis.MyMapper;
import com.freesofts.lowcode.model.ApiGroup;

/**
 * <p>
 * 分组信息表 Mapper 接口
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-26
 */
public interface ApiGroupMapper extends MyMapper<ApiGroup> {
    /**
     * 通过分组id查询数据源
     * @param groupId
     * @return
     */
    ApiGroup selectByGroupId(String groupId);

    /**
     * 保存分组信息
     * @param apiGroup
     * @return
     */
    int saveGroup(ApiGroup apiGroup);
}
