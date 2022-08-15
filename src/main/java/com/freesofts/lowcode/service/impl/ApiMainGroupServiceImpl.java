package com.freesofts.lowcode.service.impl;

import com.freesofts.lowcode.mapper.ApiMainGroupMapper;
import com.freesofts.lowcode.model.ApiGroup;
import com.freesofts.lowcode.model.ApiMainGroup;
import com.freesofts.lowcode.service.ApiMainGroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 接口与分组关联信息表 服务实现类
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-26
 */
@Service
public class ApiMainGroupServiceImpl implements ApiMainGroupService {
    @Resource
    ApiMainGroupMapper apiMainGroupMapper;

    @Override
    public int saveMainGroup(ApiMainGroup apiMainGroup) {
        return apiMainGroupMapper.insert(apiMainGroup);
    }

    @Override
    public int saveMainGroups(List<ApiMainGroup> apiMainGroups) {
        return apiMainGroupMapper.insertListUseAllCols(apiMainGroups);
    }

    @Override
    public int deleteById(String apiId) {
        return apiMainGroupMapper.deleteByPrimaryKey(apiId);
    }

    @Override
    public int deleteByIds(List<String> apiIds) {
        return apiMainGroupMapper.deleteByIds(apiIds);
    }

    @Override
    public int updateById(String apiId, ApiMainGroup apiMainGroup) {
        apiMainGroup.setApiId(apiId);
        return apiMainGroupMapper.updateByPrimaryKeySelective(apiMainGroup);
    }

    @Override
    public List<ApiMainGroup> getAll() {
        return null;
    }
}
