package com.freesofts.lowcode.service;

import cn.hutool.core.lang.tree.Tree;
import com.freesofts.lowcode.model.DevCatalog;
import com.freesofts.lowcode.vo.query.CatalogQueryVO;

import java.util.HashMap;
import java.util.List;

/**
 * Description: </br>
 * <p>版权所有：</p>
 * 未经本公司许可，不得以任何方式复制或使用本程序任何部分
 * <p>
 * 杭州孚立计算机软件有限公司
 *
 * @author LargerBear</ br>
 * date: 2022/6/24 14:20</br>
 * @since JDK 1.8
 */
public interface DevCatalogService {

	/**
	 * 新增
	 *
	 * @param catalog
	 * @return
	 */
	int insert( DevCatalog catalog);

	/**
	 * 修改
	 *
	 * @param id
	 * @param catalog
	 * @return
	 */
	int update(String id, DevCatalog catalog);

	/**
	 * 删除
	 * @param ids
	 * @return
	 */
	int deleteByIds(List<String> ids);

	/**
	 * 列表
	 * @param pageNum
	 * @param pageSize
	 * @param queryVO
	 * @return
	 */
	List<HashMap> list(int pageNum, int pageSize, CatalogQueryVO queryVO);

	/**
	 * 查询总数
	 * @param queryVO
	 * @return
	 */
	Long totalCount(CatalogQueryVO queryVO);

	/**
	 * 详情
	 * @param id
	 * @return
	 */
	DevCatalog detail(String id);

	/**
	 * 查询不分页
	 * @param queryVO
	 * @return
	 */
	List<HashMap> listNoPage(CatalogQueryVO queryVO);

	/**
	 * 根据父id查询
	 *
	 * @param catalogType
	 * @return
	 */
	List<Tree<String>> selectTreeByType(String catalogType);
}
