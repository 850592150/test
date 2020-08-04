package com.xzt.ServiceImpl;

import com.xzt.utils.MD5Util;
import com.xzt.utils.RandomCardId;
import com.xzt.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xzt.dao.CardDao;
import com.xzt.pojo.Card;
import com.xzt.pojo.User;
import com.xzt.service.CardService;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CardServiceImpl implements CardService{
	@Autowired
	private CardDao cardDao;


	/**
	 * 通过银行卡号查找银行卡信息
	 * @param cardId
	 * @return
	 */
	@Override
	public Card findCardByCardId(String cardId) {
		Card card = cardDao.findCardByCardId(cardId);
		if(card!=null) {
			
			return card;
		}
		return null;
	}

	/**
	 * 存钱
	 * @param cardId
	 * @param transMoney
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addBalanceByCardId(String cardId, BigDecimal transMoney) {

		cardDao.addBalanceByCardId(cardId,transMoney);
	}

	/**
	 * 取钱
	 * @param cardId
	 * @param transMoney
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void reduceBalanceByCardId(String cardId, BigDecimal transMoney)
	{
		cardDao.reduceBalanceByCardId(cardId,transMoney);
	}

	/**
	 * 转账
	 * @param myCardId
	 * @param transMoney
	 * @param otherCardId
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void transBalanceByCardId(String myCardId, BigDecimal transMoney,String otherCardId) {
		cardDao.transBalanceByCardId(myCardId,transMoney,otherCardId);
	}

	/**
	 * 利息功能
	 * @param rate
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateBalanceByRate(BigDecimal rate) {

		cardDao.updateBalanceByRate(rate);
	}

	/**
	 * 查找所有银行卡
	 *
	 * @return
	 */
	@Override
	public ArrayList<Card> findCardList() {
		ArrayList cardList = cardDao.findCardList();
		return cardList;
	}

	/**
	 * 插入银行卡信息
	 * @param password
	 * @param identityCard
	 * @throws Exception
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertCard(String password,String identityCard,String cardId) throws Exception {
		Card card = new Card();
		//String cardId = RandomCardId.getBrankNumber("6");
		card.setCardId(cardId);
		//创建date类对象
		Date date = new Date();
		//格式化java系统当前时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
		//转换为本地系统当前时间
		String mytime =sdf.format(date);
		//时间类型格式转换+8小时
		String nowtime = TimeUtil.formatTimeEight(mytime);
		Date openDate = sdf.parse(nowtime);
		card.setOpenDate(openDate);
		String md5password= MD5Util.MD5Encode(password, "UTF-8");
		System.err.println(md5password);
		card.setPassword(md5password);
		card.setIdentityCard(identityCard);
		card.setBalance(BigDecimal.ZERO);
		cardDao.insertCard(card);
		
	}
}
