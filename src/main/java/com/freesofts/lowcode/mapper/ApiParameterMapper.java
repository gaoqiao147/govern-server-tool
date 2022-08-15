package com.freesofts.lowcode.mapper;

import com.freesofts.lowcode.common.mybatis.MyMapper;
import com.freesofts.lowcode.model.ApiParameter;
import com.freesofts.lowcode.model.ApiParams;
import com.freesofts.lowcode.vo.params.DataTypeVO;
import com.freesofts.lowcode.vo.params.ParamsVO;

import java.util.List;

/**
 * <p>
 * 请求参数信息表 Mapper 接口
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-26
 */
public interface ApiParameterMapper extends MyMapper<ApiParameter> {
    /**
     * 保存接口参数信息(批量新增，参数不止一个)
     * @param list
     * @return
     */
    int saveApiParams(List<ApiParameter> list);
    /**
     * 保存接口参数信息(输入参数)
     *
     * @param list
     * @return
     */
    int saveApiParamsOut(List<ApiParams> list);
    /**
     * 根据apiId查询参数名(用户要填的参数信息)
     * @param apiId
     * @return
     */
    List<ParamsVO> paramsList(String apiId);

    /**
     * 根据apiId查询参数名(用户选择要输出的参数)
     * @param apiId
     * @return
     */
    List<ParamsVO> paramsList2(String apiId);
    /**
     * 根据apiId查询参数类型
     * @param apiId
     * @return
     */
    List<DataTypeVO> paramsDataTypeList(String apiId);
}
