package com.xzt.ServiceImpl;

import com.xzt.dao.CardDao;
import com.xzt.pojo.Card;
import com.xzt.utils.MD5Util;
import com.xzt.utils.RandomCardId;
import com.xzt.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xzt.dao.UserDao;
import com.xzt.pojo.User;
import com.xzt.service.UserService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xzt85
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public boolean insertUser(String telephone, String userName, String identityCard, String address) throws Exception {
		boolean insertFlag = false;
		User user = new User();
		user.setUserName(userName);
		user.setIdentityCard(identityCard);
		user.setTelephone(telephone);
		user.setAddress(address);
		insertFlag = userDao.insertUser(user);
		System.out.println(insertFlag);

		return insertFlag;
	}

		//通过用户Id查询用户信息
		@Override
		public User findUserByIdentityCard(String identityCardId) {
			User user = userDao.findUserByIdentityCard(identityCardId);
			return user;
		}
}
