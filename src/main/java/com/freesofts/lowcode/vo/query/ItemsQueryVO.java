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
 * date: 2022/6/24 15:15</br>
 * @since JDK 1.8
 */
@Data
public class ItemsQueryVO {


	/**
	 * 资产归属域
	 */
	private Integer itemCata;

	/**
	 * 数据源标识
	 */
	private String sourceId;

	/**
	 * 资产类型
	 */
	private Integer itemType;

	/**
	 * 资产名称
	 */
	private String itemName;

	/**
	 * 目录标识
	 */
	private String catalogId;

}
