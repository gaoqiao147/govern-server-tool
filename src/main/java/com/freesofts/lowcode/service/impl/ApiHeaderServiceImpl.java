package com.freesofts.lowcode.service.impl;

import com.freesofts.lowcode.mapper.ApiHeaderMapper;
import com.freesofts.lowcode.model.ApiHeader;
import com.freesofts.lowcode.service.ApiHeaderService;
import com.freesofts.lowcode.vo.params.NewVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 请求头信息表 服务实现类
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-26
 */
@Service
public class ApiHeaderServiceImpl implements ApiHeaderService {
    @Resource
    ApiHeaderMapper apiHeaderMapper;

    @Override
    public List<NewVO> getApi() {
        return apiHeaderMapper.getAllByApiIdNewVos();
    }

    @Override
    public int saveHeader(ApiHeader apiHeader) {
        return apiHeaderMapper.insert(apiHeader);
    }

    @Override
    public int saveHeaders(List<ApiHeader> apiHeaders) {
        return apiHeaderMapper.insertList(apiHeaders);
    }

    @Override
    public int deleteById(String id) {
        return apiHeaderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByIds(List<String> ids) {
        return apiHeaderMapper.deleteByIds(ids);
    }

    @Override
    public int updateById(String id, ApiHeader apiHeader) {
        apiHeader.setId(id);
        return apiHeaderMapper.updateByPrimaryKeySelective(apiHeader);
    }

    @Override
    public List<ApiHeader> getAll() {
        return apiHeaderMapper.selectAll();
    }
}
