package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 网站菜谱表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-11 13:47:43
 */
public class WebMenuDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long menuId;
	//菜名
	private String title;
	//描述
	private String des;
	//分类
	private String type;
	//内容
	private String content;
	//网站用户ID
	private String memberId;
	//创建时间
	private String createDate;
	//修改时间
	private String updateDate;

	/**
	 * 设置：
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	/**
	 * 获取：
	 */
	public Long getMenuId() {
		return menuId;
	}
	/**
	 * 设置：菜名
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：菜名
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：描述
	 */
	public void setDes(String des) {
		this.des = des;
	}
	/**
	 * 获取：描述
	 */
	public String getDes() {
		return des;
	}
	/**
	 * 设置：分类
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：分类
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：网站用户ID
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	/**
	 * 获取：网站用户ID
	 */
	public String getMemberId() {
		return memberId;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建时间
	 */
	public String getCreateDate() {
		return createDate;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * 获取：修改时间
	 */
	public String getUpdateDate() {
		return updateDate;
	}
}
