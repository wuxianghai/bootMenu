package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 菜谱评论接表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-10 16:27:08
 */
public class MenuReviewDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long reviewId;
	//评论内容
	private String content;
	//菜谱ID
	private String menuId;
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

	/**
	 * 设置：
	 */
	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}
	/**
	 * 获取：
	 */
	public Long getReviewId() {
		return reviewId;
	}
	/**
	 * 设置：评论内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：评论内容
	 */
	public String getContent() {
		return content;
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
