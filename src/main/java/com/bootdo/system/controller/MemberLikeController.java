package com.bootdo.system.controller;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.system.domain.MemberLikeDO;
import com.bootdo.system.service.MemberLikeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 用户收藏表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-10 16:27:08
 */
 
@Controller
@RequestMapping("/system/memberLike")
public class MemberLikeController {
	@Autowired
	private MemberLikeService memberLikeService;
	
	@GetMapping()
//	@RequiresPermissions("system:memberLike:memberLike")
	String MemberLike(){
	    return "system/memberLike/memberLike";
	}
	
	@ResponseBody
	@GetMapping("/list")
//	@RequiresPermissions("system:memberLike:memberLike")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<MemberLikeDO> memberLikeList = memberLikeService.list(query);
		int total = memberLikeService.count(query);
		PageUtils pageUtils = new PageUtils(memberLikeList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:memberLike:add")
	String add(){
	    return "system/memberLike/add";
	}

	@GetMapping("/edit/{likeId}")
	@RequiresPermissions("system:memberLike:edit")
	String edit(@PathVariable("likeId") Long likeId,Model model){
		MemberLikeDO memberLike = memberLikeService.get(likeId);
		model.addAttribute("memberLike", memberLike);
	    return "system/memberLike/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@GetMapping("/save")
//	@RequiresPermissions("system:memberLike:add")
	public R save( MemberLikeDO memberLike){
		if(memberLikeService.save(memberLike)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:memberLike:edit")
	public R update( MemberLikeDO memberLike){
		memberLikeService.update(memberLike);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@GetMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:memberLike:remove")
	public R remove( Long likeId){
		if(memberLikeService.remove(likeId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@GetMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:memberLike:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] likeIds){
		memberLikeService.batchRemove(likeIds);
		return R.ok();
	}
	
}
