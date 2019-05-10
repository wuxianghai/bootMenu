package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.WebMenuDao;
import com.bootdo.system.domain.WebMenuDO;
import com.bootdo.system.service.WebMenuService;



@Service
public class WebMenuServiceImpl implements WebMenuService {
	@Autowired
	private WebMenuDao webMenuDao;
	
	@Override
	public WebMenuDO get(Long menuId){
		return webMenuDao.get(menuId);
	}
	
	@Override
	public List<WebMenuDO> list(Map<String, Object> map){
		return webMenuDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return webMenuDao.count(map);
	}
	
	@Override
	public int save(WebMenuDO webMenu){
		return webMenuDao.save(webMenu);
	}
	
	@Override
	public int update(WebMenuDO webMenu){
		return webMenuDao.update(webMenu);
	}
	
	@Override
	public int remove(Long menuId){
		return webMenuDao.remove(menuId);
	}
	
	@Override
	public int batchRemove(Long[] menuIds){
		return webMenuDao.batchRemove(menuIds);
	}
	
}
