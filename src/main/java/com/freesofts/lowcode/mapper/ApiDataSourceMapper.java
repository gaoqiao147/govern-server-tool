package com.freesofts.lowcode.mapper;

import com.freesofts.lowcode.common.mybatis.MyMapper;
import com.freesofts.lowcode.model.ApiDataSource;
import com.freesofts.lowcode.vo.params.ColumnNameVO;
import com.freesofts.lowcode.vo.params.TableNameVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 数据源配置表 Mapper 接口
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-26
 */
@Mapper
public interface ApiDataSourceMapper extends MyMapper<ApiDataSource> {
    /**
     *展示所有表
     * @return
     */
    List<TableNameVO> getTableName();

    /**
     * 展示所有列
     * @param tableName
     * @return
     */
    List<ColumnNameVO> getColumnName(String tableName);
}
