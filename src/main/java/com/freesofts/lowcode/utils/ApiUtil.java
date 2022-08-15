package com.freesofts.lowcode.utils;

import com.freesofts.lowcode.controller.RequestHandler;
import com.freesofts.lowcode.model.ApiMain;
import com.freesofts.lowcode.service.ApiMainService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Map;

/**
 * 接口处理工具类
 *
 * @author mingHang
 * @date 2022-02-24 17:27
 */
@Configuration
public class ApiUtil {

    /**
     * 请求到达时处理的方法
     */
    private Method method;

    {
        try {
            method = RequestHandler.class.getDeclaredMethod("invoke", HttpServletRequest.class, HttpServletResponse.class, Map.class, Map.class, Map.class, Map.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    @Resource
    RequestMappingHandlerMapping requestMappingHandlerMapping;

    @Resource
    ApiMainService apiService;

    private PatternsRequestCondition patternsRequestCondition;

    private RequestMethodsRequestCondition requestMethodsRequestCondition;

    /**
     * 注册接口
     *
     * @param apiMain
     * @author mingHang
     * @date 2022/2/24 17:28
     */
    public void registerApi(ApiMain apiMain) {
        requestMappingHandlerMapping.registerMapping(getRequestMapping(apiMain), new RequestHandler(apiService), method);
    }

    /**
     * 注销接口
     *
     * @param apiMain
     * @author mingHang
     * @date 2022/3/1 9:25
     */
    public void unregisterApi(ApiMain apiMain) {
        requestMappingHandlerMapping.unregisterMapping(getRequestMapping(apiMain));
    }

    /**
     * 根据接口信息构建 RequestMappingInfo
     *
     * @return org.springframework.web.servlet.mvc.method.RequestMappingInfo
     * @author mingHang
     * @date 2022/3/1 9:56
     */
    private RequestMappingInfo getRequestMapping(ApiMain apiMain) {
        patternsRequestCondition = new PatternsRequestCondition("/open" + apiMain.getPath());
        requestMethodsRequestCondition = new RequestMethodsRequestCondition(RequestMethod.valueOf(apiMain.getMethod().toUpperCase(Locale.ROOT)));
        return new RequestMappingInfo(patternsRequestCondition,
                requestMethodsRequestCondition, null, null, null, null, null);
    }
}
