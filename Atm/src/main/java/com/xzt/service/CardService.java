package com.xzt.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.xzt.pojo.Card;
import com.xzt.pojo.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Service
public interface CardService {
	/**
	 * 插入银行卡信息
	 * @param password
	 * @param identityCard
	 * @throws Exception
	 */
	void insertCard(String password,String identityCard,String cardId) throws Exception;

	/**
	 * 通过银行卡号查询银行卡信息
	 * @param cardId
	 * @return
	 */
	Card findCardByCardId(String cardId);

	/**
	 * 存钱
	 * @param cardId
	 * @param balance
	 */
	void addBalanceByCardId(@Param("cardId") String cardId, @Param("balance") BigDecimal balance);

	/**
	 * 取钱
	 * @param cardId
	 * @param balance
	 */
	void reduceBalanceByCardId(@Param("cardId") String cardId, @Param("balance") BigDecimal balance);

	/**
	 * 转账
	 * @param myCardId
	 * @param transMoney
	 * @param otherCardId
	 */
	void transBalanceByCardId(@Param("myCardId") String myCardId,@Param("transMoney") BigDecimal transMoney,@Param("otherCardId") String otherCardId);

	/**
	 * 按日结息功能
	 * @param rate
	 */
	void updateBalanceByRate(BigDecimal rate);

	/**
	 * 查找所有银行卡
	 * @return
	 */
	ArrayList<Card> findCardList();
}
