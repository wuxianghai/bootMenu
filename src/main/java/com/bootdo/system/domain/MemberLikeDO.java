package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 用户收藏表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-10 16:27:08
 */
public class MemberLikeDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long likeId;
	//菜谱ID
	private String menuId;
	//菜谱名字
	private String title;
	//用户ID
	private String memberId;

	private String username;

	//创建时间
	private String createDate;
	//修改时间
	private String updateDate;


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 设置：
	 */
	public void setLikeId(Long likeId) {
		this.likeId = likeId;
	}
	/**
	 * 获取：
	 */
	public Long getLikeId() {
		return likeId;
	}
	/**
	 * 设置：菜谱ID
	 */
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	/**
	 * 获取：菜谱ID
	 */
	public String getMenuId() {
		return menuId;
	}
	/**
	 * 设置：用户ID
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	/**
	 * 获取：用户ID
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
