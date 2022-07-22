package com.freesofts.lowcode.controller;

import com.freesofts.common.response.BizResponseData;
import com.freesofts.common.response.result.plugins.DatagridBizResult;
import com.freesofts.common.response.result.types.IntegerBizResult;
import com.freesofts.common.response.result.types.ObjectBizResult;
import com.freesofts.common.utils.Datagrid;
import com.freesofts.logs.model.LogAnnotation;
import com.freesofts.lowcode.model.DevCatalog;
import com.freesofts.lowcode.service.DevCatalogService;
import com.freesofts.lowcode.vo.query.CatalogQueryVO;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Description: </br>
 * <p>版权所有：</p>
 * 未经本公司许可，不得以任何方式复制或使用本程序任何部分
 * <p>
 * 杭州孚立计算机软件有限公司
 *
 * @author LargerBear</ br>
 * date: 2022/6/24 14:15</br>
 * @since JDK 1.8
 */
@Api(tags = "dev-catalog-controller")
@ApiSupport(author = "熊振")
@RestController
@RequestMapping("/catalog")
public class DevCatalogController {
	
	@Resource
	private DevCatalogService catalogService;


	@PostMapping
//	@PreAuthorize("hasAuthority('developer:flow:flow_button:insert')")
	@LogAnnotation(module = "新增")
	@ApiOperation(value = "新增", httpMethod = "POST")
	public BizResponseData<?> insert(
			@ApiParam(value = "数据对象", required = true) @RequestBody @Validated DevCatalog catalog
	) {
		int result = catalogService.insert(catalog);
		return IntegerBizResult.builder().value(result).build().beEqualTo(1);
	}


	@PutMapping("/{id}")
//	@PreAuthorize("hasAuthority('developer:flow:flow_button:update')")
	@LogAnnotation(module = "修改")
	@ApiOperation(value = "修改", httpMethod = "PUT")
	public BizResponseData<?> update(
			@ApiParam(value = "数据ID", required = true) @PathVariable String id,
			@ApiParam(value = "数据对象", required = true) @RequestBody @Validated DevCatalog catalog
	) {

		int result = catalogService.update(id, catalog);
		return IntegerBizResult.builder().value(result).build().beEqualTo(1);
	}


	@DeleteMapping
//	@PreAuthorize("hasAuthority('developer:flow:flow_button:delete')")
	@LogAnnotation(module = "删除")
	@ApiOperation(value = "删除", httpMethod = "DELETE")
	public BizResponseData<?> deleteByIds(@ApiParam(value = "数据ID集合", required = true) @RequestBody List<String> ids) {
		int result = catalogService.deleteByIds(ids);
		return IntegerBizResult.builder().value(result).build().greaterThan(-1);
	}


	@GetMapping("/list/{pageSize}/{pageNum}")
//	@PreAuthorize("hasAuthority('developer:flow:flow_button:access')")
	@ApiOperation(value = "数据分页列表", httpMethod = "GET")
	public BizResponseData<Datagrid<HashMap>> list(
			@ApiParam(value = "数据页码", required = true) @PathVariable int pageNum,
			@ApiParam(value = "每页记录数", required = true) @PathVariable int pageSize,
			@ApiParam(value = "查询参数", required = true) CatalogQueryVO queryVO
	) {

		List<HashMap> list = catalogService.list(pageNum, pageSize, queryVO);
		Long total = catalogService.totalCount(queryVO);
		return new DatagridBizResult<>(total, list).getResponseData();
	}


	@GetMapping("/list")
	@PreAuthorize("hasAuthority('developer:flow:flow_button:access')")
	@ApiOperation(value = "数据列表", httpMethod = "GET")
	public BizResponseData<Datagrid<HashMap>> listNoPage(
			@ApiParam(value = "查询参数", required = true) CatalogQueryVO queryVO
	) {

		List<HashMap> list = catalogService.listNoPage(queryVO);
		return new DatagridBizResult<>(CollectionUtils.isEmpty(list) ? 0 : list.size(), list).getResponseData();
	}

	@GetMapping("/{id}")
//	@PreAuthorize("hasAuthority('developer:flow:flow_button:access')")
	@ApiOperation(value = "详情", httpMethod = "GET")
	public BizResponseData<?> detail(
			@ApiParam(value = "数据id", required = true) @PathVariable String id
	) {

		DevCatalog result = catalogService.detail(id);
		return ObjectBizResult.builder().object(result).build().nonNull();
	}

	@GetMapping("/tree/data/{catalogType}")
//	@PreAuthorize("hasAuthority('developer:flow:flow_button:access')")
	@ApiOperation(value = "目录树", httpMethod = "GET")
	public BizResponseData<?> selectTreeByType(
			@ApiParam(value = "catalogType", required = true) @PathVariable String catalogType
	) {

		return ObjectBizResult.builder().object(catalogService.selectTreeByType(catalogType)).build().nonNull();
	}
	
	
}
