package com.freesofts.lowcode.controller;

import com.freesofts.common.response.BizResponseData;
import com.freesofts.common.response.result.types.IntegerBizResult;
import com.freesofts.common.response.result.types.ListBizResult;
import com.freesofts.logs.model.LogAnnotation;
import com.freesofts.lowcode.model.ApiGroup;
import com.freesofts.lowcode.service.ApiGroupService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 分组信息表 前端控制器
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-26
 */
@RestController
@RequestMapping("/api-group")
public class ApiGroupController {
    @Resource
    ApiGroupService apiGroupService;

    @PostMapping("/save-a-data")
    @LogAnnotation(module = "新增")
    @ApiOperation(value = "新增一条数据源信息", httpMethod = "POST")
    public BizResponseData<?> saveGroup(@ApiParam(value = "apiGroup") @RequestBody ApiGroup apiGroup) {
        int result = apiGroupService.saveGroup(apiGroup);
        return IntegerBizResult.builder().value(result).build().beEqualTo(1);
    }

    @PostMapping("/save-data-list")
    @LogAnnotation(module = "新增")
    @ApiOperation(value = "新增多条数据", httpMethod = "POST")
    public BizResponseData<?> saveGroup(@ApiParam(value = "List<ApiGroup>") @RequestBody List<ApiGroup> list) {
        int result = apiGroupService.saveGroups(list);
        return IntegerBizResult.builder().value(result).build().greaterThan(1);
    }

    @GetMapping("/get-data")
    @LogAnnotation(module = "查询")
    @ApiOperation(value = "查询所有数据", httpMethod = "GET")
    public BizResponseData<?> getAllData() {
        List list = apiGroupService.getAll();
        return ListBizResult.builder().list(list).build().isNotEmpty();
    }

    @PutMapping("update")
    @LogAnnotation(module = "修改")
    @ApiOperation(value = "修改一条数据", httpMethod = "GET")
    public BizResponseData<?> updateData(
            @ApiParam(value = "数据id") @PathVariable("id") String id,
            @ApiParam(value = "数据对象") @RequestBody @Validated ApiGroup apiGroup
    ) {
        int result = apiGroupService.updateById(id, apiGroup);
        return IntegerBizResult.builder().value(result).build().beEqualTo(1);
    }

    @DeleteMapping("/del-a-data")
    @LogAnnotation(module = "删除")
    @ApiOperation(value = "删除一条数据", httpMethod = "DELETE")
    public BizResponseData<?> deleteDataById(@ApiParam(value = "参数信息") String id) {
        int result = apiGroupService.deleteById(id);
        return IntegerBizResult.builder().value(result).build().greaterThan(-1);
    }

    @DeleteMapping("/delete-data-list")
    @LogAnnotation(module = "删除")
    @ApiOperation(value = "删除多条数据", httpMethod = "DELETE")
    public BizResponseData<?> deleteDataByIds(@ApiParam("参数信息") List<String> ids) {
        int result = apiGroupService.deleteByIds(ids);
        return IntegerBizResult.builder().value(result).build().greaterThan(-1);
    }
}

