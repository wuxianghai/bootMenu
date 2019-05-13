package com.bootdo.system.controller;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.common.utils.StringUtils;
import com.bootdo.system.domain.MemberDO;
import com.bootdo.system.service.MemberService;
import org.jsoup.helper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 网站会员表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-10 16:27:08
 */
 
@Controller
@RequestMapping("/system/member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping()
//	@RequiresPermissions("system:member:member")
	String Member(){
	    return "system/member/member";
	}
	
	@ResponseBody
	@GetMapping("/list")
//	@RequiresPermissions("system:member:member")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<MemberDO> memberList = memberService.list(query);
		int total = memberService.count(query);
		PageUtils pageUtils = new PageUtils(memberList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
//	@RequiresPermissions("system:member:add")
	String add(){
	    return "system/member/add";
	}

	@GetMapping("/edit/{memberId}")
//	@RequiresPermissions("system:member:edit")
	String edit(@PathVariable("memberId") Long memberId,Model model){
		MemberDO member = memberService.get(memberId);
		model.addAttribute("member", member);
	    return "system/member/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@GetMapping("/save")
//	@RequiresPermissions("system:member:add")
	public R save( MemberDO member){
		member.setCreateDate(String.valueOf(System.currentTimeMillis()/1000));
		Map<String, Object> params = new HashMap<>();
		if (StringUtils.isNotBlank(member.getUsername()) || StringUtils.isNotBlank(member.getPassword())){
			return R.error(-1, "用户名密码不能为空！");
		}
		params.put("userName", member.getUsername());
		params.put("password", member.getPassword());
		Query query = new Query(params);
		int total = memberService.count(query);
		if (total > 0){
			return R.error();
		}
		if(memberService.save(member)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
//	@RequiresPermissions("system:member:edit")
	public R update( MemberDO member){
		member.setUpdateDate(String.valueOf(System.currentTimeMillis()));
		memberService.update(member);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@GetMapping( "/remove")
	@ResponseBody
//	@RequiresPermissions("system:member:remove")
	public R remove( Long memberId){
		if(memberService.remove(memberId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@GetMapping( "/batchRemove")
	@ResponseBody
//	@RequiresPermissions("system:member:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] memberIds){
		memberService.batchRemove(memberIds);
		return R.ok();
	}
	
}
