package com.bootdo.system.dao;

import com.bootdo.system.domain.MemberDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 网站会员表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-10 16:27:08
 */
@Mapper
public interface MemberDao {

	MemberDO get(Long memberId);
	
	List<MemberDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MemberDO member);
	
	int update(MemberDO member);
	
	int remove(Long member_id);
	
	int batchRemove(Long[] memberIds);
}
