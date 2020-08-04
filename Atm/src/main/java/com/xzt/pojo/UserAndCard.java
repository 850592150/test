package com.xzt.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xzt85
 */
@Data
public class UserAndCard implements Serializable{

	/**
	 * 用户ID
	 */
	private int userId;
	/**
	 * 用户姓名
	 */
	private String userName;
	/**
	 * 身份证号码
	 */
	private String identityCard;
	/**
	 * 手机号
	 */
	private String telephone;
	/**
	 * 地址
	 */
	private String address;
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

		

}
