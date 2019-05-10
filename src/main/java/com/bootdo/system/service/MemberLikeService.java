package com.bootdo.system.service;

import com.bootdo.system.domain.MemberLikeDO;

import java.util.List;
import java.util.Map;

/**
 * 用户收藏表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-10 16:27:08
 */
public interface MemberLikeService {
	
	MemberLikeDO get(Long likeId);
	
	List<MemberLikeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MemberLikeDO memberLike);
	
	int update(MemberLikeDO memberLike);
	
	int remove(Long likeId);
	
	int batchRemove(Long[] likeIds);
}
