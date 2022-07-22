package com.freesofts.lowcode.common.mybatis;

import com.freesofts.mybatis.ProcAboutTree;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;


/**
 * @author Administrator
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T>, ProcAboutTree, SpecialBatchMapper<T> {

}
