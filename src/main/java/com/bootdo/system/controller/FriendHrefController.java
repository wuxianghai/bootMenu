package com.bootdo.system.controller;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.system.domain.FriendHrefDO;
import com.bootdo.system.service.FriendHrefService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 网站友情链接表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-10 16:27:08
 */
 
@Controller
@RequestMapping("/system/friendHref")
public class FriendHrefController {
	@Autowired
	private FriendHrefService friendHrefService;
	
	@GetMapping()
	@RequiresPermissions("system:friendHref:friendHref")
	String FriendHref(){
	    return "system/friendHref/friendHref";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:friendHref:friendHref")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<FriendHrefDO> friendHrefList = friendHrefService.list(query);
		int total = friendHrefService.count(query);
		PageUtils pageUtils = new PageUtils(friendHrefList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:friendHref:add")
	String add(){
	    return "system/friendHref/add";
	}

	@GetMapping("/edit/{hrefId}")
	@RequiresPermissions("system:friendHref:edit")
	String edit(@PathVariable("hrefId") Long hrefId,Model model){
		FriendHrefDO friendHref = friendHrefService.get(hrefId);
		model.addAttribute("friendHref", friendHref);
	    return "system/friendHref/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:friendHref:add")
	public R save( FriendHrefDO friendHref){
		if(friendHrefService.save(friendHref)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:friendHref:edit")
	public R update( FriendHrefDO friendHref){
		friendHrefService.update(friendHref);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:friendHref:remove")
	public R remove( Long hrefId){
		if(friendHrefService.remove(hrefId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:friendHref:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] hrefIds){
		friendHrefService.batchRemove(hrefIds);
		return R.ok();
	}
	
}
