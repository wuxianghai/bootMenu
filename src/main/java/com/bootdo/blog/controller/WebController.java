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

}
