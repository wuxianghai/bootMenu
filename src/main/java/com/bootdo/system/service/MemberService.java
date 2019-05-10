package com.bootdo.system.service;

import com.bootdo.system.domain.MemberDO;

import java.util.List;
import java.util.Map;

/**
 * 网站会员表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-10 16:27:08
 */
public interface MemberService {
	
	MemberDO get(Long memberId);
	
	List<MemberDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MemberDO member);
	
	int update(MemberDO member);
	
	int remove(Long memberId);
	
	int batchRemove(Long[] memberIds);
}
