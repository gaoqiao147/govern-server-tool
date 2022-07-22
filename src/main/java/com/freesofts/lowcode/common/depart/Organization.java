package com.freesofts.lowcode.common.depart;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Description: </br>
 * <p>版权所有：</p>
 * 未经本公司许可，不得以任何方式复制或使用本程序任何部分
 * <p>
 * 杭州孚立计算机软件有限公司
 *
 * @author LargerBear</ br>
 * date: 2021/10/13 14:55</br>
 * @since JDK 1.8
 */
@Data
@Getter
@Setter
public class Organization implements Serializable {

	private static final long serialVersionUID = -3062066094065662631L;

	/* 组织类型：区域，单位，部门/科室，下属单位，虚拟组织，乡镇街道，村、社区，网格 */
	public enum Type {
		UNKOWN, DOMAIN, UNIT, DEPARTMENT, SUBORDINATE_UNIT, VIRTUAL_ORGANIZATION, TOWNSHIP_STREETS, VILLAGE_COMMUNITY, GRID
	}

	/* 行政等级：省级，市级，县级，乡镇街道，村/社区，网格 */
	public enum AdministrativeLevel {
		UNKOWN, PROVINCIAL, MUNICIPAL, COUNTY, TOWNSHIP_STREETS, VILLAGE_COMMUNITY, GRID
	}

	private String id;

	private String parentId;

	private String levelCode;

	private String name;

	private String shortName;

	private Type type;

	private String managerId;

	private String managerName;

	private String telephone;

	private String zipcode;

	private String address;

	private AdministrativeLevel administrativeLevel;

	private String administrativeCode;

	private Boolean state;

	private Long sort;

	private String description;

	private String createdBy;

	private String creatorName;

	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date createdDate;

	private String lastModifiedBy;

	private String lastModifiedName;

	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date lastModifiedDate;
}
