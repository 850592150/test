package com.xzt.pojo;

import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;
/**
 * @author xzt85
 */
@Data
public class Trans {
	/**
	 * 交易流水
	 */
	@Getter
	private String transId;
	/**
	 * 交易日期
	 */
	private Date transDate;
	/**
	 * 本人银行卡号
	 */
	private String cardId;
	/**
	 * 交易类型 存入、取出
	 */
	private String transType;
	/**
	 * 交易金额
	 */
	private BigDecimal transMoney;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 对方银行卡号
	 */
	private String otherCardId;

}
