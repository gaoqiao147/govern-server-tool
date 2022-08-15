package com.freesofts.lowcode.controller;

import com.freesofts.common.response.BizResponseData;
import com.freesofts.common.response.result.plugins.DatagridBizResult;
import com.freesofts.common.response.result.types.IntegerBizResult;
import com.freesofts.common.response.result.types.ObjectBizResult;
import com.freesofts.common.utils.Datagrid;
import com.freesofts.lowcode.model.ApiLog;
import com.freesofts.lowcode.service.ApiLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 接口调用日志表 前端控制器
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-26
 */
@Api(tags = "接口日志管理")
@RestController
@RequestMapping("/api-log")
public class ApiLogController {
    @Resource
    ApiLogService apiLogService;

    @GetMapping("/get-all-log")
    @ApiOperation(value = "获取所有日志信息", notes = "得到日志数组")
    public BizResponseData<Datagrid<ApiLog>> getLog(){
        List list = apiLogService.getAllLog();
        return new DatagridBizResult<ApiLog>(CollectionUtils.isEmpty(list) ? 0 : list.size(), list).getResponseData();
    }

    @GetMapping("/get-log-id")
    @ApiOperation(value = "根据id查询日志")
    public BizResponseData<?> getLogById(@ApiParam(value = "日志id") @PathVariable String id){
        ApiLog result = apiLogService.getLogById(id);
        return ObjectBizResult.builder().object(result).build().nonNull();
    }

    @DeleteMapping("/del-log-id")
    @ApiOperation(value = "根据id删除日志" , httpMethod = "DELETE")
    public BizResponseData<?> delLogById(@ApiParam(value = "日志id") @PathVariable String id){
        int result = apiLogService.deleteLogById(id);
        return IntegerBizResult.builder().value(result).build().greaterThan(-1);
    }
}

