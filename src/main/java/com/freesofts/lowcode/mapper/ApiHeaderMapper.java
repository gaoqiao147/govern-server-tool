package com.freesofts.lowcode.mapper;

import com.freesofts.lowcode.common.mybatis.MyMapper;
import com.freesofts.lowcode.model.ApiHeader;
import com.freesofts.lowcode.vo.params.NewVO;

import java.util.List;

/**
 * <p>
 * 请求头信息表 Mapper 接口
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-26
 */
public interface ApiHeaderMapper extends MyMapper<ApiHeader> {
    /**
     * 查询所有接口
     * @return
     */
    List<NewVO> getAllByApiIdNewVos();
}
