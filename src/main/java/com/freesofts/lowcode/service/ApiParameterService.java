package com.freesofts.lowcode.service;

import com.freesofts.lowcode.model.ApiGroup;
import com.freesofts.lowcode.model.ApiParameter;
import io.swagger.annotations.ApiParam;

import java.util.List;

/**
 * <p>
 * 请求参数信息表 服务类
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-26
 */
public interface ApiParameterService {
    /**
     * 增加一条参数记录
     * @param apiParam
     * @return
     */
    int saveAParam(ApiParameter apiParam);
    /**
     * 增加多条参数记录
     * @param apiParams
     * @return
     */
    int saveParams(List<ApiParameter> apiParams);
    /**
     * 删除一条参数记录
     * @param id
     * @return
     */
    int deleteById(String id);
    /**
     * 删除多条参数记录
     * @param ids
     * @return
     */
    int deleteByIds(List<String> ids);
    /**
     * 修改一条参数记录
     * @param id
     * @param apiParam
     * @return
     */
    int updateById(String id,ApiParameter apiParam);

    /**
     *获取所有数据
     * @return
     */
    List<ApiParameter> getAll();
}
