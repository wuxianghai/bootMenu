package com.bootdo.system.controller;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.system.domain.WebMenuDO;
import com.bootdo.system.service.WebMenuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//	@RequiresPermissions("system:webMenu:webMenu")
	String WebMenu(){
	    return "system/webMenu/webMenu";
	}
	
	@ResponseBody
	@GetMapping("/list")
//	@RequiresPermissions("system:webMenu:webMenu")
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
	@ResponseBody
	@GetMapping("/detail/{menuId}")
	Map detail(@PathVariable("menuId") Long menuId,Model model){
		Map map = new HashMap<Object, Object>();
		WebMenuDO webMenu = webMenuService.get(menuId);
		map.put("code", 0);
		map.put("msg", "操作成功");
		map.put("data", webMenu);
		return map;
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@GetMapping("/save")
//	@RequiresPermissions("system:webMenu:add")
	public R save( WebMenuDO webMenu){
        webMenu.setCreateDate(String.valueOf(System.currentTimeMillis()/1000));
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
//	@RequiresPermissions("system:webMenu:edit")
	public R update( WebMenuDO webMenu){
		webMenuService.update(webMenu);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@GetMapping( "/remove")
	@ResponseBody
//	@RequiresPermissions("system:webMenu:remove")
	public R remove( Long menuId){
		if(webMenuService.remove(menuId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@GetMapping( "/batchRemove")
	@ResponseBody
//	@RequiresPermissions("system:webMenu:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] menuIds){
		webMenuService.batchRemove(menuIds);
		return R.ok();
	}
	
}
