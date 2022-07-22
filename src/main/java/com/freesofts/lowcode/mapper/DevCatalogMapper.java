package com.freesofts.lowcode.mapper;

import com.freesofts.lowcode.common.mybatis.MyMapper;
import com.freesofts.lowcode.model.DevCatalog;
import com.freesofts.lowcode.vo.query.CatalogQueryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author Administrator
 */
@Mapper
public interface DevCatalogMapper extends MyMapper<DevCatalog> {

	/**
	 * 统计
	 * @param queryVO
	 * @return
	 */
	Long selectTotalCount(@Param("queryVO") CatalogQueryVO queryVO);

	/**
	 * 查询列表
	 * @param pageStart
	 * @param pageSize
	 * @param queryVO
	 * @return
	 */
	List<HashMap> selectPageList(
			@Param("pageStart") int pageStart,
			@Param("pageSize") int pageSize,
			@Param("queryVO") CatalogQueryVO queryVO
	);

	/**
	 * 查询不分页
	 * @param queryVO
	 * @return
	 */
	List<HashMap> listNoPage(@Param("queryVO") CatalogQueryVO queryVO);

	/**
	 * 根据父id和类型查询
	 * @param catalogType
	 * @return
	 */
	List<DevCatalog> selectType(@Param("catalogType")String catalogType);
}