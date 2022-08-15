package com.freesofts.lowcode.mapper;

import com.freesofts.lowcode.common.mybatis.MyMapper;
import com.freesofts.lowcode.model.ApiLog;

import java.util.List;

/**
 * <p>
 * 接口调用日志表 Mapper 接口
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-26
 */
public interface ApiLogMapper extends MyMapper<ApiLog> {
    /**
     * 新增接口调用日志
     *
     * @param apiLog
     * @return int
     */
    int save(ApiLog apiLog);

}
