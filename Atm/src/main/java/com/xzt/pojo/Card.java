package com.xzt.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
public class Card implements Serializable{

	/**
	 * 银行卡号
	 */
	private String cardId;
	/**
	 * 开户时间
	 */
	private Date openDate;
	/**
	 * 余额
	 */
	private BigDecimal balance;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 用户ID
	 */
	private String identityCard;

}
