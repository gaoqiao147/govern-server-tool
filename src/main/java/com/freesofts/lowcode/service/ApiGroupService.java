package com.freesofts.lowcode.service;

import com.freesofts.lowcode.model.ApiGroup;

import java.util.List;

/**
 * <p>
 * 分组信息表 服务类
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-26
 */
public interface ApiGroupService {
    /**
     * 增加一条参数记录
     * @param apiGroup
     * @return
     */
    int saveGroup(ApiGroup apiGroup);
    /**
     * 增加多条参数记录
     * @param apiGroups
     * @return
     */
    int saveGroups(List<ApiGroup> apiGroups);
    /**
     * 删除一条参数记录
     * @param id
     * @return
     */
    int deleteById(String id);
    /**
     * 删除多条参数记录
     * @param ids
     * @return
     */
    int deleteByIds(List<String> ids);
    /**
     * 修改一条参数记录
     * @param id
     * @param apiGroup
     * @return
     */
    int updateById(String id,ApiGroup apiGroup);

    /**
     *获取所有数据
     * @return
     */
    List<ApiGroup> getAll();
}
