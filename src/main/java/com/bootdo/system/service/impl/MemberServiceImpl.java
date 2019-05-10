package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.MemberDao;
import com.bootdo.system.domain.MemberDO;
import com.bootdo.system.service.MemberService;



@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public MemberDO get(Long memberId){
		return memberDao.get(memberId);
	}
	
	@Override
	public List<MemberDO> list(Map<String, Object> map){
		return memberDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return memberDao.count(map);
	}
	
	@Override
	public int save(MemberDO member){
		return memberDao.save(member);
	}
	
	@Override
	public int update(MemberDO member){
		return memberDao.update(member);
	}
	
	@Override
	public int remove(Long memberId){
		return memberDao.remove(memberId);
	}
	
	@Override
	public int batchRemove(Long[] memberIds){
		return memberDao.batchRemove(memberIds);
	}
	
}
