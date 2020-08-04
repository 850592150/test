package com.xzt.service;

import org.springframework.stereotype.Service;

import com.xzt.pojo.User;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public interface UserService {
	
	boolean insertUser(String telephone,String userName,String identityCard, String address) throws Exception;

	/**
	 *用户Id查询用户信息
	 * @param userId
	 * @return
	 */
	User findUserByIdentityCard(String userId);
}
