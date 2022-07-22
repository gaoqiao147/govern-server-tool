package com.freesofts.lowcode.service.impl;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeUtil;
import com.freesofts.lowcode.mapper.DevCatalogMapper;
import com.freesofts.lowcode.model.DevCatalog;
import com.freesofts.lowcode.service.DevCatalogService;
import com.freesofts.lowcode.vo.query.CatalogQueryVO;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
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
 * date: 2022/6/24 14:23</br>
 * @since JDK 1.8
 */
@Service
public class DevCatalogServiceImpl implements DevCatalogService {
	
	
	@Resource
	private DevCatalogMapper catalogMapper;
	
	
	@Override
	public int insert(DevCatalog catalog) {
		catalog.paramForInsert();
		//如果没有选择目录分类，则归类于系统目录
		if (StringUtils.isEmpty(catalog.getCatalogType())){
			catalog.setCatalogType(1);
		}
		if (StringUtils.isEmpty(catalog.getParentId())){
			catalog.setParentId("root");
		}
		//目录层级
		String parentId = catalog.getParentId();
		if ("root".equals(parentId)){
			catalog.setCatalogLevel(1);
		}else{
			DevCatalog devCatalog = catalogMapper.selectByPrimaryKey(parentId);
			catalog.setCatalogLevel(devCatalog.getCatalogLevel()+1);
		}
		return catalogMapper.insert(catalog);
	}

	@Override
	public int update(String id, DevCatalog catalog) {
		catalog.setId(id);
		catalog.paramForUpdate();
		return catalogMapper.updateByPrimaryKeySelective(catalog);
	}

	@Override
	public int deleteByIds(List<String> ids) {
		return catalogMapper.deleteByIds(ids);
	}

	@Override
	public List<HashMap> list(int pageNum, int pageSize, CatalogQueryVO queryVO) {

		return catalogMapper.selectPageList((pageNum - 1) * pageSize, pageSize, queryVO);
	}

	@Override
	public Long totalCount(CatalogQueryVO queryVO) {
		return catalogMapper.selectTotalCount(queryVO);
	}

	@Override
	public DevCatalog detail(String id) {
		return catalogMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<HashMap> listNoPage(CatalogQueryVO queryVO) {
		return catalogMapper.listNoPage(queryVO);
	}

	@Override
	public List<Tree<String>> selectTreeByType(String catalogType) {
		return TreeUtil.build(catalogMapper.selectType(catalogType), "root", null,
				(treeNode, tree) -> {
			tree.setId(treeNode.getId());
			tree.setParentId(treeNode.getParentId());
			tree.setName(treeNode.getCatalogName());
			tree.putExtra("key", treeNode.getId());
			tree.putExtra("title", treeNode.getCatalogName());
		});
	}
}
