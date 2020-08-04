package com.xzt.controller;

import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.xzt.ServiceImpl.CardServiceImpl;
import com.xzt.pojo.Card;
import com.xzt.pojo.User;
import com.xzt.service.CardService;
import com.xzt.service.UserService;
import com.xzt.utils.MD5Util;

/**
 * @author xzt85
 */
@Controller
public class LoginController {
	/**
	 * 登录错误信息常量
	 */
	public static final String msg = "用户名或者密码错误!";

	@Autowired
	private CardService cardService;

	@Autowired
	private UserService userService;
	
	@RequestMapping("/index")
	public String hello() {
		return "HelloWorld";
	}

	/**
	 * 登录功能
	 * @param cardId
	 * @param password
	 * @param model
	 * @return
	 */
	@PostMapping("login")
	public String login(@RequestParam String cardId,@RequestParam String password,Model model) {

		if (!StringUtils.isEmpty(password)) {
			Card card = cardService.findCardByCardId(cardId);
			String Md5password = MD5Util.MD5Encode(password, "UTF-8");

			if (Md5password.equals(card.getPassword())) {
				User user = userService.findUserByIdentityCard(card.getIdentityCard());
				model.addAttribute("card", card);
				model.addAttribute("user", user);
				return "loginSuccess";
			}
		}
		model.addAttribute("msg", msg);
		return "login";
	}
	
	@GetMapping("/")
	public String index() {
		return "login";
		
	}

}
