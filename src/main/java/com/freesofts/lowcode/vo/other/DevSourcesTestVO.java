package com.freesofts.lowcode.vo.other;

import lombok.Data;


/**
 * Description: </br>
 * <p>版权所有：</p>
 * 未经本公司许可，不得以任何方式复制或使用本程序任何部分
 * <p>
 * 杭州孚立计算机软件有限公司
 *
 * @author LargerBear</ br>
 * date: 2022/6/24 16:40</br>
 * @since JDK 1.8
 */
@Data
public class DevSourcesTestVO {

	private String id;

	/**
	 * 数据源名称
	 */
	private String sourceName;

	/**
	 * 数据源类型
	 */
	private Integer sourceType;

	/**
	 * 数据源详细信息
	 */
	private String sourceDetail;

}
