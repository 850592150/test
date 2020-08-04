package com.xzt.pojo;

import lombok.Data;

/**
 * @author xzt85
 *
 */
@Data
public class User {

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
}
