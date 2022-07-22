package com.freesofts.lowcode.common.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.mapperhelper.SqlHelper;

import java.util.Set;

/**
 * Description: </br>
 * <p>版权所有：</p>
 * 未经本公司许可，不得以任何方式复制或使用本程序任何部分
 * <p>
 * 杭州孚立计算机软件有限公司
 *
 * @author LargerBear</ br>
 * date: 2020/11/5 16:34</br>
 * @since JDK 1.8
 */
@Slf4j
public class SpecialBatchProvider extends MapperTemplate {

    public SpecialBatchProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    public String insertListUseAllCols(MappedStatement ms) {
        Class<?> entityClass = getEntityClass(ms);
        //开始拼sql
        StringBuilder sql = new StringBuilder();
        sql.append(" insert ignore into ");
        sql.append(SqlHelper.getDynamicTableName(entityClass, tableName(entityClass)));
        sql.append(" ");
        sql.append(SqlHelper.insertColumns(entityClass, false, false, false));
        sql.append(" VALUES ");
        sql.append("<foreach collection=\"list\" item=\"record\" separator=\",\" >");
        sql.append("<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">");
        //获取全部列
        Set<EntityColumn> columnList = EntityHelper.getColumns(entityClass);
        //当某个列有主键策略时，不需要考虑他的属性是否为空，因为如果为空，一定会根据主键策略给他生成一个值
        for (EntityColumn column : columnList) {
            if (column.isInsertable()) {
                sql.append(column.getColumnHolder("record")).append(",");
            }
        }
        sql.append("</trim>");
        sql.append("</foreach>");
        return sql.toString();
    }


    public String deleteByIds(MappedStatement ms) {
        Class<?> entityClass = getEntityClass(ms);
        //开始拼sql
        StringBuilder sql = new StringBuilder();
        sql.append(" delete from ");
        sql.append(SqlHelper.getDynamicTableName(entityClass, tableName(entityClass)));
        sql.append(" ");
        sql.append(" where id in ");
        sql.append("<foreach collection=\"list\" item=\"record\" open=\"(\" close=\")\" separator=\",\" >");
        log.info("");
        sql.append("<trim> ");
        sql.append("  #{record}  ");
        sql.append("</trim>");
        sql.append("</foreach>");
        return sql.toString();
    }


    public String deleteByIdsForLogic(MappedStatement ms) {
        Class<?> entityClass = getEntityClass(ms);
        //开始拼sql
        StringBuilder sql = new StringBuilder();
        sql.append(" update ");
        sql.append(SqlHelper.getDynamicTableName(entityClass, tableName(entityClass)));
        sql.append(" ");
        sql.append(" set del_flag = '1' ");
        sql.append(" where id in ");
        sql.append("<foreach collection=\"list\" item=\"record\" open=\"(\" close=\")\" separator=\",\" >");
        sql.append("<trim> ");
        sql.append("  #{record}  ");
        sql.append("</trim>");
        sql.append("</foreach>");
        return sql.toString();
    }

}
