package com.bootdo.system.service;

import com.bootdo.system.domain.MenuReviewDO;

import java.util.List;
import java.util.Map;

/**
 * 菜谱评论接表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-10 16:27:08
 */
public interface MenuReviewService {
	
	MenuReviewDO get(Long reviewId);
	
	List<MenuReviewDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MenuReviewDO menuReview);
	
	int update(MenuReviewDO menuReview);
	
	int remove(Long reviewId);
	
	int batchRemove(Long[] reviewIds);
}
