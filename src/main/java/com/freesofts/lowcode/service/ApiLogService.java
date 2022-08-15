package com.freesofts.lowcode.service;

import com.freesofts.lowcode.model.ApiLog;
import io.swagger.annotations.Api;

import java.util.List;

/**
 * <p>
 * 接口调用日志表 服务类
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-26
 */
public interface ApiLogService {
    /**
     * 新建api接口日志
     *
     * @param apiLogDO
     * @return
     */
    int insertApiLog(ApiLog apiLogDO);

    /**
     * 查询所有日志信息
     *
     * @return 所有日志信息
     */
    List<ApiLog> getAllLog();

    /**
     *根据id查询日志
     * @param id
     * @return
     */
    ApiLog getLogById(String id);

    /**
     * 根据id删除日志
     * @param id
     * @return
     */
    int deleteLogById(String id);

}
