package com.freesofts.lowcode.vo.query;

import lombok.Data;

/**
 * Description: </br>
 * <p>版权所有：</p>
 * 未经本公司许可，不得以任何方式复制或使用本程序任何部分
 * <p>
 * 杭州孚立计算机软件有限公司
 *
 * @author LargerBear</ br>
 * date: 2022/6/24 14:19</br>
 * @since JDK 1.8
 */
@Data
public class CatalogQueryVO {


	/**
	 * 目录名称
	 */
	private String catalogName;


	/**
	 * 父目录标识
	 */
	private String parentId;

	/**
	 * 目录类型
	 */
	private Integer catalogType;

}
