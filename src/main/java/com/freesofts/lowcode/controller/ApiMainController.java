package com.freesofts.lowcode.controller;

import com.freesofts.common.response.BizResponseData;
import com.freesofts.common.response.result.plugins.DatagridBizResult;
import com.freesofts.common.response.result.types.IntegerBizResult;
import com.freesofts.common.response.result.types.ObjectBizResult;
import com.freesofts.common.utils.Datagrid;
import com.freesofts.lowcode.common.enums.MethodEnums;
import com.freesofts.lowcode.method.RequestMethods;
import com.freesofts.lowcode.model.ApiMain;
import com.freesofts.lowcode.service.ApiMainService;
import com.freesofts.lowcode.vo.params.ParamsVO;
import com.freesofts.lowcode.vo.params.RequestUriVO;
import com.freesofts.lowcode.vo.params.RequestVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 接口信息主类 前端控制器
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-26
 */
@Api(tags = "数据发起请求列表操作")
@RestController
@RequestMapping("/api-main")
public class ApiMainController {

    @Resource
    RequestMethods requestMethod;
    @Resource
    ApiMainService apiMainService;


    @GetMapping("/url")
    @ApiOperation(value = "发起请求", httpMethod = "GET")
    public BizResponseData<?> RequestResult(@RequestBody @Validated RequestVO requestVO) {
        String method = requestVO.getMethod();
        String path = requestVO.getPath();
        String token = requestVO.getToken();
        List<ParamsVO> list = requestVO.getParams();
        //判断参数是否正确,isValidEnumIgnoreCase是判断定义的枚举中是否存在method的字符
        if (!EnumUtils.isValidEnumIgnoreCase(MethodEnums.class, method)) {
            return ObjectBizResult.builder().message("method错误").build().isNull();
        }
        Map<String, Object> map = new HashMap<>();
        if ("GET".equals(method)) {
            map.put("data", requestMethod.methodUseGet(token, method, path).toString());
        }
        if ("POST".equals(method)) {
            map.put("data", requestMethod.methodUsePost(token, method, path, list).toString());
        }
        return ObjectBizResult.builder().object(map).build().nonNull();
    }

    @PostMapping("save-api")
    @ApiOperation(value = "保存接口", httpMethod = "POST")
    public BizResponseData<?> saveApi(@RequestBody @Validated ApiMain apiMainDO) {
        //判断参数是否正确,isValidEnumIgnoreCase是判断定义的枚举中是否存在method的字符
        if (!EnumUtils.isValidEnumIgnoreCase(MethodEnums.class, apiMainDO.getMethod())) {
            return ObjectBizResult.builder().message("method错误").build().isNull();
        }
        int result = apiMainService.saveApi(apiMainDO);
        return IntegerBizResult.builder().value(result).build().beEqualTo(1);
    }

    @GetMapping("get-all-api")
    @ApiOperation(value = "获取所有接口", httpMethod = "GET")
    public BizResponseData<Datagrid<RequestUriVO>> getAllApi() {
        List<RequestUriVO> list = apiMainService.getAllApi();
        return new DatagridBizResult<>(CollectionUtils.isEmpty(list) ? 0 : list.size(), list).getResponseData();
    }
}

