package com.xzt.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.xzt.pojo.Trans;
import com.xzt.service.RateService;
import com.xzt.service.TransService;
import com.xzt.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.xzt.pojo.Card;
import com.xzt.pojo.User;
import com.xzt.service.CardService;
import com.xzt.service.UserService;
import com.xzt.utils.RandomCardId;

@Controller
@Component
public class CardController {
	@Autowired
	private CardService cardService;
	@Autowired
	private RateService rateService;
	@Autowired
	private TransService transService;

	/**
	 * 根据银行卡号查询银行卡信息
	 * @param cardId
	 * @param model
	 * @return
	 */
	@GetMapping("/findCardByCardId/{cardId}")
	public String findCardByCardId(@PathVariable String cardId,Model model){
		Card card = cardService.findCardByCardId(cardId);
		model.addAttribute("card",card);
		return "cardInfo";
	}

	/**
	 * 每五秒触发一次 @Scheduled(cron = "0/5 * * * * ?")
	 * 定时任务，按利息更新余额,每天中午十二点触发
	 */
	@Scheduled(cron = "0 0 12 * * ?")
	@Transactional(rollbackFor = Exception.class)
	public void updateBalanceByRate() throws Exception {
		BigDecimal rate = rateService.findRate();
		cardService.updateBalanceByRate(rate);
		ArrayList<Card> cardList = cardService.findCardList();
		for (int i = 0; i<cardList.size();i++){
			transService.interestIncome(cardList.get(i).getBalance(),"日利息收入",cardList.get(i).getCardId(),rate);
		}

	}

}
