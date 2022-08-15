package com.freesofts.lowcode.mapper;

import com.freesofts.lowcode.common.mybatis.MyMapper;
import com.freesofts.lowcode.model.ApiMain;
import com.freesofts.lowcode.model.ApiMainGroup;

/**
 * <p>
 * 接口与分组关联信息表 Mapper 接口
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-26
 */
public interface ApiMainGroupMapper extends MyMapper<ApiMainGroup> {
    /**
     * 查询api分组
     * @param id
     * @return
     */
    ApiMainGroup selectById(String id);

    int saveMainGroup(ApiMainGroup apiMainGroup);
}
