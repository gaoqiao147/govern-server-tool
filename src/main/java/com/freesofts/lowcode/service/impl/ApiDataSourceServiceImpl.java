package com.freesofts.lowcode.service.impl;

import com.freesofts.common.response.result.types.ListBizResult;
import com.freesofts.common.utils.UUIdGenId;
import com.freesofts.lowcode.mapper.ApiDataSourceMapper;
import com.freesofts.lowcode.mapper.ApiGroupMapper;
import com.freesofts.lowcode.mapper.ApiMainGroupMapper;
import com.freesofts.lowcode.method.GenPathMethods;
import com.freesofts.lowcode.method.SplicingSqlMethods;
import com.freesofts.lowcode.model.*;
import com.freesofts.lowcode.service.ApiDataSourceService;
import com.freesofts.lowcode.service.ApiMainService;
import com.freesofts.lowcode.utils.ApiUtil;
import com.freesofts.lowcode.vo.params.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * <p>
 * 数据源配置表 服务实现类
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-26
 */
@Service
public class ApiDataSourceServiceImpl implements ApiDataSourceService {
    @Resource
    ApiDataSourceMapper apiDataSourceMapper;
    @Resource
    ApiMainService apiMainService;
    @Resource
    SplicingSqlMethods splicingSqlMethods;
    @Resource
    GenPathMethods genPathMethods;
    @Lazy
    @Resource
    ApiUtil apiUtil;
    @Resource
    ApiMainGroupMapper apiMainGroupMapper;
    @Resource
    ApiGroupMapper apiGroupMapper;

    @Override
    public int saveDataSource(ApiDataSource apiDataSource) {
        return apiDataSourceMapper.insert(apiDataSource);
    }

    @Override
    public int saveDataSources(List<ApiDataSource> apiDataSources) {
        return apiDataSourceMapper.insertListUseAllCols(apiDataSources);
    }

    @Override
    public int deleteById(String id) {
        return apiDataSourceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByIds(List<String> ids) {
        return apiDataSourceMapper.deleteByIds(ids);
    }

    @Override
    public int updateById(String id, ApiDataSource apiDataSource) {
        apiDataSource.setId(id);
        apiDataSource.paramForUpdate();
        return apiDataSourceMapper.updateByPrimaryKeySelective(apiDataSource);
    }

    @Override
    public List<ApiDataSource> getAll() {
        return apiDataSourceMapper.selectAll();
    }

    @Override
    public List<TableNameVO> getTableName() {
        return apiDataSourceMapper.getTableName();
    }

    @Override
    public ListBizResult<ColumnNameVO> getColumnName(String tableName) {
//        return apiDataSourceMapper.getColumnName(tableName);
        return ListBizResult.<ColumnNameVO>builder()
                .list(apiDataSourceMapper.getColumnName(tableName))
                .build();
    }

    @Override
    public int saveAndRegister(GenerateVO generateVO) {
        //接口信息保存入库
        String uuid = UUIdGenId.genId();
        //随机生成id
        String path = genPathMethods.genPath(generateVO.getTableName(), String.valueOf(new Random(10000).nextInt())).toString();
        //获取参数名
        List<ParamsVO> paramsVOListIn = generateVO.getInputParamsList();
        //获取参数类型
        List<DataTypeVO> dataTypeListIn = generateVO.getInputDataType();
        //获取参数名
        List<ParamsVO> paramsVOListOut = generateVO.getOutputParamsList();
        //获取参数类型
        List<DataTypeVO> dataTypeListOut = generateVO.getOutputDataType();
        //判断参数是否为空
        //循环添加参数入listIn数组
        List<ApiParameter> listIn = new ArrayList<>();
        if (!dataTypeListIn.isEmpty() && !paramsVOListIn.isEmpty()) {
            for (int i = 0; i < paramsVOListIn.size(); i++) {

                ApiParameter apiParameterDO = new ApiParameter()
                        .setKey(paramsVOListIn.get(i).getParams())
                        .setDataType(dataTypeListIn.get(i).getParamsDataType());
                listIn.add(apiParameterDO);
            }
        }
        //循环添加参数入list数组
        List<ApiParams> listOut = new ArrayList<>();
        if (!dataTypeListOut.isEmpty() && !paramsVOListOut.isEmpty()) {
            for (int i = 0; i < paramsVOListOut.size(); i++) {
                ApiParams apiParams = new ApiParams()
                        .setKey(paramsVOListOut.get(i).getParams())
                        .setDataType(dataTypeListOut.get(i).getParamsDataType());
                listOut.add(apiParams);
            }
        }
        //添加api_main_group表，新建关联表数据
        //随机生成groupId
        String groupId = UUIdGenId.genId();
        ApiMainGroup apiMainGroup = new ApiMainGroup()
                .setApiId(uuid)
                .setGroupId(groupId)
                //0创建，1引用
                .setQuote("0");
        apiMainGroupMapper.saveMainGroup(apiMainGroup);
        //添加api_group表
        //获取数据源信息(由前端传入数据源id)
        ApiGroup apiGroup = new ApiGroup();
        apiGroup.setId(groupId);
        apiGroup.setDataSourceId(generateVO.getDataSourceId());
        apiGroupMapper.saveGroup(apiGroup);
        //保存接口信息，并接口上架
        ApiMain apiMain = new ApiMain()
                .setExecuteSql(splicingSqlMethods.splicingSql(generateVO).toString())
                .setMethod(generateVO.getMethod())
                .setPath(path)
                .setParameters(listIn)
                //设置该接口可用
                .setEnable("0")
                .setState("0")
                .setParametersOut(listOut);
        apiMain.setId(uuid);
        int res = apiMainService.saveApi(apiMain);
        //注册接口
        apiUtil.registerApi(apiMain);
        return res;
    }
}
