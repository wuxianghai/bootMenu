package com.bootdo.system.dao;

import com.bootdo.system.domain.WebMenuDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 网站菜谱表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-11 13:47:43
 */
@Mapper
public interface WebMenuDao {

	WebMenuDO get(Long menuId);
	
	List<WebMenuDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(WebMenuDO webMenu);
	
	int update(WebMenuDO webMenu);
	
	int remove(Long menu_id);
	
	int batchRemove(Long[] menuIds);
}
