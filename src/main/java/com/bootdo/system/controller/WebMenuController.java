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

import com.bootdo.system.domain.WebMenuDO;
import com.bootdo.system.service.WebMenuService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 网站菜谱表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-11 13:47:43
 */
 
@Controller
@RequestMapping("/system/webMenu")
public class WebMenuController {
	@Autowired
	private WebMenuService webMenuService;
	
	@GetMapping()
	@RequiresPermissions("system:webMenu:webMenu")
	String WebMenu(){
	    return "system/webMenu/webMenu";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:webMenu:webMenu")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<WebMenuDO> webMenuList = webMenuService.list(query);
		int total = webMenuService.count(query);
		PageUtils pageUtils = new PageUtils(webMenuList, total);
		return pageUtils;
	}
	@ResponseBody
	@GetMapping("/webList")
	public PageUtils webList(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);
		List<WebMenuDO> webMenuList = webMenuService.list(query);
		int total = webMenuService.count(query);
		PageUtils pageUtils = new PageUtils(webMenuList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:webMenu:add")
	String add(){
	    return "system/webMenu/add";
	}

	@GetMapping("/edit/{menuId}")
	@RequiresPermissions("system:webMenu:edit")
	String edit(@PathVariable("menuId") Long menuId,Model model){
		WebMenuDO webMenu = webMenuService.get(menuId);
		model.addAttribute("webMenu", webMenu);
	    return "system/webMenu/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:webMenu:add")
	public R save( WebMenuDO webMenu){
		if(webMenuService.save(webMenu)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:webMenu:edit")
	public R update( WebMenuDO webMenu){
		webMenuService.update(webMenu);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:webMenu:remove")
	public R remove( Long menuId){
		if(webMenuService.remove(menuId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:webMenu:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] menuIds){
		webMenuService.batchRemove(menuIds);
		return R.ok();
	}
	
}
