package com.bootdo.system.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.system.domain.MenuReviewDO;
import com.bootdo.system.service.MenuReviewService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 菜谱评论接表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-10 16:27:08
 */
 
@Controller
@RequestMapping("/system/menuReview")
public class MenuReviewController {
	@Autowired
	private MenuReviewService menuReviewService;
	
	@GetMapping()
	@RequiresPermissions("system:menuReview:menuReview")
	String MenuReview(){
	    return "system/menuReview/menuReview";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:menuReview:menuReview")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<MenuReviewDO> menuReviewList = menuReviewService.list(query);
		int total = menuReviewService.count(query);
		PageUtils pageUtils = new PageUtils(menuReviewList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:menuReview:add")
	String add(){
	    return "system/menuReview/add";
	}

	@GetMapping("/edit/{reviewId}")
	@RequiresPermissions("system:menuReview:edit")
	String edit(@PathVariable("reviewId") Long reviewId,Model model){
		MenuReviewDO menuReview = menuReviewService.get(reviewId);
		model.addAttribute("menuReview", menuReview);
	    return "system/menuReview/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:menuReview:add")
	public R save( MenuReviewDO menuReview){
		if(menuReviewService.save(menuReview)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:menuReview:edit")
	public R update( MenuReviewDO menuReview){
		menuReviewService.update(menuReview);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:menuReview:remove")
	public R remove( Long reviewId){
		if(menuReviewService.remove(reviewId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:menuReview:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] reviewIds){
		menuReviewService.batchRemove(reviewIds);
		return R.ok();
	}
	
}
