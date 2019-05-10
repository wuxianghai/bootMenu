package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.MenuReviewDao;
import com.bootdo.system.domain.MenuReviewDO;
import com.bootdo.system.service.MenuReviewService;



@Service
public class MenuReviewServiceImpl implements MenuReviewService {
	@Autowired
	private MenuReviewDao menuReviewDao;
	
	@Override
	public MenuReviewDO get(Long reviewId){
		return menuReviewDao.get(reviewId);
	}
	
	@Override
	public List<MenuReviewDO> list(Map<String, Object> map){
		return menuReviewDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return menuReviewDao.count(map);
	}
	
	@Override
	public int save(MenuReviewDO menuReview){
		return menuReviewDao.save(menuReview);
	}
	
	@Override
	public int update(MenuReviewDO menuReview){
		return menuReviewDao.update(menuReview);
	}
	
	@Override
	public int remove(Long reviewId){
		return menuReviewDao.remove(reviewId);
	}
	
	@Override
	public int batchRemove(Long[] reviewIds){
		return menuReviewDao.batchRemove(reviewIds);
	}
	
}
