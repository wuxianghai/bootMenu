package com.bootdo.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author bootdo 1992lcg@163.com
 */
@RequestMapping("/web")
@Controller
public class WebController {


	@GetMapping("/customer-login")
	String login() {
		return "blog/index/customer-login";
	}

	@GetMapping("/customer-sign")
	String sign() {
		return "blog/index/customer-sign";
	}

	@GetMapping("/add")
	String add() {
		return "blog/bContent/add";
	}

	@GetMapping("/my-center")
	String myCenter() {
		return "blog/index/my-center.html";
	}

	@GetMapping("/menu-detail")
	String menu_detail() {
		return "blog/index/menu-detail.html";
	}

	@GetMapping("/chef-characte")
	String characte() {
		return "blog/index/chef-characte.html";
	}
}
