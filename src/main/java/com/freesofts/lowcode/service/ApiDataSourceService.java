package com.freesofts.lowcode.service;

import com.freesofts.common.response.result.types.ListBizResult;
import com.freesofts.lowcode.model.ApiDataSource;
import com.freesofts.lowcode.vo.params.ColumnNameVO;
import com.freesofts.lowcode.vo.params.GenerateVO;
import com.freesofts.lowcode.vo.params.TableNameVO;

import java.util.List;

/**
 * <p>
 * 数据源配置表 服务类
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-26
 */
public interface ApiDataSourceService {
    /**
     * 增加一条参数记录
     * @param apiDataSource
     * @return
     */
    int saveDataSource(ApiDataSource apiDataSource);
    /**
     * 增加多条参数记录
     * @param apiDataSources
     * @return
     */
    int saveDataSources(List<ApiDataSource> apiDataSources);
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
     * @param apiDataSource
     * @return
     */
    int updateById(String id,ApiDataSource apiDataSource);

    /**
     *获取所有数据
     * @return
     */
    List<ApiDataSource> getAll();

    /**
     *展示所有表
     * @return
     */
    List<TableNameVO> getTableName();

    /**
     * 获取列信息
     * @param tableName
     * @return
     */
    ListBizResult<ColumnNameVO> getColumnName(String tableName);

    /**
     * 保存并注册接口
     * @param generateVO
     * @return
     */
    int saveAndRegister(GenerateVO generateVO);

}
