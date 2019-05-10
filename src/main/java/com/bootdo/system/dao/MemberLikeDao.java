package com.bootdo.system.dao;

import com.bootdo.system.domain.MemberLikeDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 用户收藏表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-10 16:27:08
 */
@Mapper
public interface MemberLikeDao {

	MemberLikeDO get(Long likeId);
	
	List<MemberLikeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MemberLikeDO memberLike);
	
	int update(MemberLikeDO memberLike);
	
	int remove(Long like_id);
	
	int batchRemove(Long[] likeIds);
}
