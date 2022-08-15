package com.freesofts.lowcode.service.impl;

import com.freesofts.lowcode.mapper.ApiParameterMapper;
import com.freesofts.lowcode.model.ApiParameter;
import com.freesofts.lowcode.service.ApiParameterService;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 请求参数信息表 服务实现类
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-26
 */
@Service
public class ApiParameterServiceImpl implements ApiParameterService {
    @Resource
    ApiParameterMapper apiParameterMapper;

    @Override
    public int saveAParam(ApiParameter apiParameter) {
        return apiParameterMapper.insert(apiParameter);
    }

    @Override
    public int saveParams(List<ApiParameter> apiParams) {
        return apiParameterMapper.saveApiParams(apiParams);
    }

    @Override
    public int deleteById(String id) {
        return apiParameterMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByIds(List<String> ids) {
        return apiParameterMapper.deleteByIds(ids);
    }

    @Override
    public int updateById(String id, ApiParameter apiParam) {
        apiParam.setId(id);
        return apiParameterMapper.updateByPrimaryKeySelective(apiParam);
    }

    @Override
    public List<ApiParameter> getAll() {
        return apiParameterMapper.selectAll();
    }
}
