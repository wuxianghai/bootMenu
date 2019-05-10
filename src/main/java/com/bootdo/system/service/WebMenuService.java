package com.bootdo.system.service;

import com.bootdo.system.domain.WebMenuDO;

import java.util.List;
import java.util.Map;

/**
 * 网站菜谱表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-10 16:27:08
 */
public interface WebMenuService {
	
	WebMenuDO get(Long menuId);
	
	List<WebMenuDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(WebMenuDO webMenu);
	
	int update(WebMenuDO webMenu);
	
	int remove(Long menuId);
	
	int batchRemove(Long[] menuIds);
}
