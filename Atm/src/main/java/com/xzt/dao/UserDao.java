package com.xzt.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import com.xzt.pojo.User;
@Mapper

public interface UserDao {
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	boolean insertUser(User user);

	/**
	 * 通过身份证号码查找用户
	 * @param identityCard
	 * @return
	 */
	User findUserByIdentityCard(String identityCard);

}
