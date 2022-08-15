package com.freesofts.lowcode.controller;

import com.freesofts.common.response.BizResponseData;
import com.freesofts.common.response.result.types.IntegerBizResult;
import com.freesofts.common.response.result.types.ListBizResult;
import com.freesofts.logs.model.LogAnnotation;
import com.freesofts.lowcode.model.ApiDataSource;
import com.freesofts.lowcode.service.ApiDataSourceService;
import com.freesofts.lowcode.vo.params.GenerateVO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 数据源配置表 前端控制器
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-26
 */
@RestController
@RequestMapping("/api-data-source")
public class ApiDataSourceController {
    @Resource
    ApiDataSourceService apiDataSourceService;

    @PostMapping("/save-a-data")
    @LogAnnotation(module = "新增一条数据源")
    @ApiOperation(value = "新增一条数据源信息", httpMethod = "POST")
    public BizResponseData<?> saveDataSource(@ApiParam(value = "apiDataSource") @RequestBody ApiDataSource apiDataSource) {
        int result = apiDataSourceService.saveDataSource(apiDataSource);
        return IntegerBizResult.builder().value(result).build().beEqualTo(1);
    }

    @PostMapping("/save-data-list")
    @LogAnnotation(module = "新增多条数据源")
    @ApiOperation(value = "新增多条数据", httpMethod = "POST")
    public BizResponseData<?> saveDataSource(@ApiParam(value = "List<ApiDataSource>") @RequestBody List<ApiDataSource> list) {
        int result = apiDataSourceService.saveDataSources(list);
        return IntegerBizResult.builder().value(result).build().greaterThan(1);
    }

    @GetMapping("/get-data")
    @LogAnnotation(module = "查询所有数据源")
    @ApiOperation(value = "查询所有数据", httpMethod = "GET")
    public BizResponseData<?> getAllData() {
        List list = apiDataSourceService.getAll();
        return ListBizResult.builder().list(list).build().isNotEmpty();
    }

    @PutMapping("update")
    @LogAnnotation(module = "修改一条数据源")
    @ApiOperation(value = "修改一条数据", httpMethod = "GET")
    public BizResponseData<?> updateData(
            @ApiParam(value = "数据id") @PathVariable("id") String id,
            @ApiParam(value = "数据对象") @RequestBody @Validated ApiDataSource apiDataSource
    ) {
        int result = apiDataSourceService.updateById(id, apiDataSource);
        return IntegerBizResult.builder().value(result).build().beEqualTo(1);
    }

    @DeleteMapping("/del-a-data")
    @LogAnnotation(module = "删除一条数据源")
    @ApiOperation(value = "删除一条数据", httpMethod = "DELETE")
    public BizResponseData<?> deleteDataById(@ApiParam(value = "参数信息") String id) {
        int result = apiDataSourceService.deleteById(id);
        return IntegerBizResult.builder().value(result).build().greaterThan(-1);
    }

    @DeleteMapping("/delete-data-list")
    @LogAnnotation(module = "删除多条数据源")
    @ApiOperation(value = "删除多条数据", httpMethod = "DELETE")
    public BizResponseData<?> deleteDataByIds(@ApiParam("参数信息") List<String> ids) {
        int result = apiDataSourceService.deleteByIds(ids);
        return IntegerBizResult.builder().value(result).build().greaterThan(-1);
    }

    @GetMapping("/get-table-name")
    @LogAnnotation(module = "获取数据源下所有表")
    @ApiOperation(value = "获取表名")
    public BizResponseData<?> getTableName() {
        List list = apiDataSourceService.getTableName();
        return ListBizResult.builder().list(list).build().isNotEmpty();
    }

    @GetMapping("/get-column-name")
    @LogAnnotation(module = "获取表下所有列名")
    @ApiOperation(value = "获取列名")
    public BizResponseData<?> getColumnName(@ApiParam(value = "表名") @RequestParam String tableName) {
//        List list = apiDataSourceService.getColumnName(tableName);
//        return ListBizResult.builder().list(list).build().isNotEmpty();
        return apiDataSourceService.getColumnName(tableName).isNotEmpty();
    }

    @PostMapping("/gen-api")
    @LogAnnotation(module = "自动生成接口")
    @ApiOperation(value = "自动生成接口")
    public BizResponseData<?> genApi(@ApiParam(value = "自动生成接口类") @RequestBody GenerateVO generateVO) {
        int res = apiDataSourceService.saveAndRegister(generateVO);
        return IntegerBizResult.builder().value(res).build().beEqualTo(1);
    }
}

