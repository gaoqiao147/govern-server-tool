package com.freesofts.lowcode.service;

import com.freesofts.lowcode.model.ApiHeader;
import com.freesofts.lowcode.vo.params.NewVO;

import java.util.List;

/**
 * <p>
 * 请求头信息表 服务类
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-26
 */
public interface ApiHeaderService{
    /**
Api  * 查询所有接口
     * @return
     */
    List<NewVO> getApi();
    /**
     * 增加一条参数记录
     * @param apiHeader
     * @return
     */
    int saveHeader(ApiHeader apiHeader);
    /**
     * 增加多条参数记录
     * @param apiHeaders
     * @return
     */
    int saveHeaders(List<ApiHeader> apiHeaders);
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
     * @param apiHeader
     * @return
     */
    int updateById(String id,ApiHeader apiHeader);

    /**
     * 查询所有数据
     * @return
     */
    List<ApiHeader> getAll();
}
