package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.FriendHrefDao;
import com.bootdo.system.domain.FriendHrefDO;
import com.bootdo.system.service.FriendHrefService;



@Service
public class FriendHrefServiceImpl implements FriendHrefService {
	@Autowired
	private FriendHrefDao friendHrefDao;
	
	@Override
	public FriendHrefDO get(Long hrefId){
		return friendHrefDao.get(hrefId);
	}
	
	@Override
	public List<FriendHrefDO> list(Map<String, Object> map){
		return friendHrefDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return friendHrefDao.count(map);
	}
	
	@Override
	public int save(FriendHrefDO friendHref){
		return friendHrefDao.save(friendHref);
	}
	
	@Override
	public int update(FriendHrefDO friendHref){
		return friendHrefDao.update(friendHref);
	}
	
	@Override
	public int remove(Long hrefId){
		return friendHrefDao.remove(hrefId);
	}
	
	@Override
	public int batchRemove(Long[] hrefIds){
		return friendHrefDao.batchRemove(hrefIds);
	}
	
}
