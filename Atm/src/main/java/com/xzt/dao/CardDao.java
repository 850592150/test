package com.xzt.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.xzt.pojo.Card;
import com.xzt.pojo.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Mapper
public interface CardDao {
	/**
	 * 银行卡号查找银行卡信息
	 * @param cardId
	 * @return
	 */
	Card findCardByCardId(String cardId);

	/**
	 * 插入银行卡信息
	 * @param card
	 * @param card
	 */
	void insertCard(Card card);

	/**
	 * 存钱
	 * @param cardId
	 * @param transMoney
	 */
	void addBalanceByCardId(String cardId,BigDecimal transMoney);

	/**
	 * 取钱
	 * @param cardId
	 * @param transMoney
	 */
	void reduceBalanceByCardId(String cardId,BigDecimal transMoney);

	/**
	 * 转账
	 * @param myCardId
	 * @param transMoney
	 * @param otherCardId
	 */
	void transBalanceByCardId(String myCardId,BigDecimal transMoney,String otherCardId);

	/**
	 * 根据利率更新余额
	 * @param rate
	 */
	void updateBalanceByRate(BigDecimal rate);

	/**
	 * 查找所有银行卡
	 */
	ArrayList<Card> findCardList();
}
