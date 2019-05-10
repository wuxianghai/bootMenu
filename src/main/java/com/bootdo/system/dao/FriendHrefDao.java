package com.bootdo.system.dao;

import com.bootdo.system.domain.FriendHrefDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 网站友情链接表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-10 16:27:08
 */
@Mapper
public interface FriendHrefDao {

	FriendHrefDO get(Long hrefId);
	
	List<FriendHrefDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(FriendHrefDO friendHref);
	
	int update(FriendHrefDO friendHref);
	
	int remove(Long href_id);
	
	int batchRemove(Long[] hrefIds);
}
