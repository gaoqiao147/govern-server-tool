package com.freesofts.lowcode.mapper;

import com.freesofts.lowcode.common.mybatis.MyMapper;
import com.freesofts.lowcode.model.ApiMain;
import com.freesofts.lowcode.vo.params.RequestParamsVO;

import java.util.List;

/**
 * <p>
 * 接口信息主类 Mapper 接口
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-26
 */
public interface ApiMainMapper extends MyMapper<ApiMain> {
    /**
     * 新增接口
     *
     * @param apiMain
     * @return int
     * @author mingHang
     * @date 2022/2/24 20:30
     */
    int insertInterface(ApiMain apiMain);

    /**
     * 得到所有接口信息（参数）
     *
     * @return
     */
    List<RequestParamsVO> getAllApi();

    /**
     * 通过id查询一条接口信息
     *
     * @param id
     * @return
     */
    RequestParamsVO getAllApiById(Integer id);

    /**
     * 根据请求地址查询数据
     * @param path
     * @return
     */
    ApiMain getOneByPath(String path);

    /**
     * 查询所有接口
     *
     * @return java.util.List<com.freesofts.framework.api.model.ApiMain>
     * @author mingHang
     * @date 2022/3/2 17:00
     */
    List<ApiMain> getAll();
}
