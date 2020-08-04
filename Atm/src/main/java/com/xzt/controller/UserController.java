package com.xzt.controller;

import java.math.BigDecimal;

import com.xzt.pojo.Card;
import com.xzt.pojo.User;
import com.xzt.service.CardService;
import com.xzt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private CardService cardService;


	/**
	 * 跳注册页面
	 * @return
	 */
	@GetMapping("/toRegister")
	public String register() {

		return "register";
	}

	/**
	 * 退出
	 * @param httpSession
	 * @return
	 */
	@GetMapping("/logout")
	public String logout(HttpSession httpSession) {
		httpSession.invalidate();
		 return "login";
	}

	/**
	 * 开户
	 * @param telephone
	 * @param userName
	 * @param identityCard
	 * @param address
	 * @param password
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/register")
	@Transactional(rollbackFor = Exception.class)
	public String register(@RequestParam String telephone, @RequestParam String userName, @RequestParam String identityCard,
						   @RequestParam String address, @RequestParam String password, @RequestParam String cardId, Model model) throws Exception {

		User user = userService.findUserByIdentityCard(identityCard);
		if (user != null && identityCard.equals(user.getIdentityCard())){
			cardService.insertCard(password,identityCard,cardId);
			model.addAttribute("cardId",cardId);
			return "registerSuccess";
		}

		boolean flag = userService.insertUser(telephone, userName, identityCard, address);
		if(flag){
			cardService.insertCard(password,identityCard,cardId);
			model.addAttribute("cardId",cardId);
			return "registerSuccess";
		}else{
			return "toRegister";
		}
	}

	/**
	 * 查找用户信息与银行卡信息
	 * @param cardId
	 * @param model
	 * @return
	 */
	@GetMapping("/findAll/{cardId}")
	public String findAll(@PathVariable String cardId, Model model){
		Card card = cardService.findCardByCardId(cardId);
		User user = userService.findUserByIdentityCard(card.getIdentityCard());
		model.addAttribute("card",card);
		model.addAttribute("user",user);
		return "loginSuccess";
	}

}
