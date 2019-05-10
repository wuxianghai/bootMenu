package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.MemberLikeDao;
import com.bootdo.system.domain.MemberLikeDO;
import com.bootdo.system.service.MemberLikeService;



@Service
public class MemberLikeServiceImpl implements MemberLikeService {
	@Autowired
	private MemberLikeDao memberLikeDao;
	
	@Override
	public MemberLikeDO get(Long likeId){
		return memberLikeDao.get(likeId);
	}
	
	@Override
	public List<MemberLikeDO> list(Map<String, Object> map){
		return memberLikeDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return memberLikeDao.count(map);
	}
	
	@Override
	public int save(MemberLikeDO memberLike){
		return memberLikeDao.save(memberLike);
	}
	
	@Override
	public int update(MemberLikeDO memberLike){
		return memberLikeDao.update(memberLike);
	}
	
	@Override
	public int remove(Long likeId){
		return memberLikeDao.remove(likeId);
	}
	
	@Override
	public int batchRemove(Long[] likeIds){
		return memberLikeDao.batchRemove(likeIds);
	}
	
}
