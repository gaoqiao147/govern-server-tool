package com.freesofts.lowcode.common.mybatis;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import tk.mybatis.mapper.annotation.RegisterMapper;

import java.util.List;

/**
 * Description: </br>
 * <p>版权所有：</p>
 * 未经本公司许可，不得以任何方式复制或使用本程序任何部分
 * <p>
 * 杭州孚立计算机软件有限公司
 *
 * @author LargerBear</   br>
 * date: 2020/11/5 16:33</br>
 * @since JDK 1.8
 */
@RegisterMapper
public interface SpecialBatchMapper<T> {

    /**
     * 批量插入数据库，所有字段都插入，包括主键
     * @param recordList
     *
     * @return
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @InsertProvider(type = SpecialBatchProvider.class, method = "insertListUseAllCols")
    int insertListUseAllCols(List<T> recordList);


    /**
     * 批量根据主键删除
     * @param ids
     *
     * @return
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @InsertProvider(type = SpecialBatchProvider.class, method = "deleteByIds")
    int deleteByIds(List<String> ids);


    /**
     * 批量根据主键逻辑删除
     * @param ids
     *
     * @return
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @InsertProvider(type = SpecialBatchProvider.class, method = "deleteByIdsForLogic")
    int deleteByIdsForLogic(List<String> ids);
}
