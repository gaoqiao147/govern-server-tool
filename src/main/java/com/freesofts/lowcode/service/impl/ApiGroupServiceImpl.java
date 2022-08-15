package com.freesofts.lowcode.service.impl;

import com.freesofts.lowcode.mapper.ApiGroupMapper;
import com.freesofts.lowcode.mapper.ApiMainGroupMapper;
import com.freesofts.lowcode.model.ApiGroup;
import com.freesofts.lowcode.service.ApiGroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 分组信息表 服务实现类
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-26
 */
@Service
public class ApiGroupServiceImpl implements ApiGroupService {
    @Resource
    ApiGroupMapper apiGroupMapper;

    @Override
    public int saveGroup(ApiGroup apiGroup) {
        return apiGroupMapper.insert(apiGroup);
    }

    @Override
    public int saveGroups(List<ApiGroup> apiGroups) {
        return apiGroupMapper.insertListUseAllCols(apiGroups);
    }

    @Override
    public int deleteById(String id) {
        return apiGroupMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByIds(List<String> ids) {
        return apiGroupMapper.deleteByIds(ids);
    }

    @Override
    public int updateById(String id, ApiGroup apiGroup) {
        apiGroup.setId(id);
        apiGroup.paramForUpdate();
        return apiGroupMapper.updateByPrimaryKeySelective(apiGroup);
    }

    @Override
    public List<ApiGroup> getAll() {
        return apiGroupMapper.selectAll();
    }
}
