package com.freesofts.lowcode.service.impl;

import com.freesofts.lowcode.mapper.ApiLogMapper;
import com.freesofts.lowcode.model.ApiLog;
import com.freesofts.lowcode.service.ApiLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 接口调用日志表 服务实现类
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-26
 */
@Service
public class ApiLogServiceImpl implements ApiLogService {
    @Resource
    ApiLogMapper apiLogMapper;

    @Override
    public int insertApiLog(ApiLog apiLogDO) {
        return apiLogMapper.save(apiLogDO);
    }

    @Override
    public List<ApiLog> getAllLog() {
        return apiLogMapper.selectAll();
    }

    @Override
    public ApiLog getLogById(String id) {
        return apiLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteLogById(String id) {
        return apiLogMapper.deleteByPrimaryKey(id);
    }
}
