package com.bootdo.system.service;

import com.bootdo.system.domain.FriendHrefDO;

import java.util.List;
import java.util.Map;

/**
 * 网站友情链接表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-10 16:27:08
 */
public interface FriendHrefService {
	
	FriendHrefDO get(Long hrefId);
	
	List<FriendHrefDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(FriendHrefDO friendHref);
	
	int update(FriendHrefDO friendHref);
	
	int remove(Long hrefId);
	
	int batchRemove(Long[] hrefIds);
}
