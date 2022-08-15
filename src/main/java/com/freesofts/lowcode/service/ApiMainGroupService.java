package com.freesofts.lowcode.service;

import com.freesofts.lowcode.model.ApiGroup;
import com.freesofts.lowcode.model.ApiMain;
import com.freesofts.lowcode.model.ApiMainGroup;

import java.util.List;

/**
 * <p>
 * 接口与分组关联信息表 服务类
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-26
 */
public interface ApiMainGroupService {
    /**
     * 增加一条参数记录
     *
     * @param apiMainGroup
     * @return
     */
    int saveMainGroup(ApiMainGroup apiMainGroup);

    /**
     * 增加多条参数记录
     *
     * @param apiMainGroups
     * @return
     */
    int saveMainGroups(List<ApiMainGroup> apiMainGroups);

    /**
     * 删除一条参数记录
     *
     * @param apiId
     * @return
     */
    int deleteById(String apiId);

    /**
     * 删除多条参数记录
     *
     * @param apiIds
     * @return
     */
    int deleteByIds(List<String> apiIds);

    /**
     * 修改一条参数记录
     *
     * @param apiId
     * @param apiMainGroup
     * @return
     */
    int updateById(String apiId, ApiMainGroup apiMainGroup);

    /**
     * 获取所有数据
     *
     * @return
     */
    List<ApiMainGroup> getAll();
}
