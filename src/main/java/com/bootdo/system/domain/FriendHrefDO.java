package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 网站友情链接表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-10 16:27:08
 */
public class FriendHrefDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long hrefId;
	//名字
	private String name;
	//图片
	private String picture;
	//创建时间
	private String createDate;
	//修改时间
	private String updateDate;

	/**
	 * 设置：
	 */
	public void setHrefId(Long hrefId) {
		this.hrefId = hrefId;
	}
	/**
	 * 获取：
	 */
	public Long getHrefId() {
		return hrefId;
	}
	/**
	 * 设置：名字
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：名字
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：图片
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}
	/**
	 * 获取：图片
	 */
	public String getPicture() {
		return picture;
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
