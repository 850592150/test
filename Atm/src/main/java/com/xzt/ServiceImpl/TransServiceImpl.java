package com.xzt.ServiceImpl;

import com.xzt.pojo.Card;
import com.xzt.pojo.Trans;
import com.xzt.utils.RandomCardId;
import com.xzt.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xzt.dao.TransDao;
import com.xzt.service.TransService;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TransServiceImpl implements TransService {
	@Autowired
	private TransDao transDao;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveMoney(BigDecimal transMoney, String remark, String cardId) throws Exception {
		Trans trans = new Trans();
		String transId = RandomCardId.getBrankNumber("6");
		Date date = new Date();
		/**
		 * 格式化java系统当前时间
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		/**
		 * 转换为本地系统当前时间
		 */
		String mytime = sdf.format(date);
		/**
		 * 时间类型格式转换+8小时
		 */
		String nowtime = TimeUtil.formatTimeEight(mytime);
		Date transDate = sdf.parse(nowtime);
		trans.setTransId(transId);
		trans.setTransDate(transDate);
		trans.setRemark(remark);
		trans.setCardId(cardId);
		trans.setOtherCardId(null);
		trans.setTransMoney(transMoney);
		trans.setTransType("存入");
		transDao.insertTrans(trans);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void reduceMoney(BigDecimal transMoney, String remark, String cardId) throws Exception {
		Trans trans = new Trans();
		String transId = RandomCardId.getBrankNumber("6");
		Date date = new Date();
		/**
		 * 格式化java系统当前时间
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		/**
		 * 转换为本地系统当前时间
		 */
		String mytime = sdf.format(date);
		/**
		 * 时间类型格式转换+8小时
		 */
		String nowtime = TimeUtil.formatTimeEight(mytime);
		Date transDate = sdf.parse(nowtime);
		trans.setTransId(transId);
		trans.setTransDate(transDate);
		trans.setRemark(remark);
		trans.setCardId(cardId);
		trans.setTransMoney(transMoney);
		trans.setOtherCardId(null);
		trans.setTransType("取出");
		transDao.insertTrans(trans);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void transMoney(BigDecimal transMoney, String remark, String myCardId,String otherCardId) throws Exception {
		Trans trans = new Trans();
		String transId = RandomCardId.getBrankNumber("6");
		Date date = new Date();
		/**
		 * 格式化java系统当前时间
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		/**
		 * 转换为本地系统当前时间
		 */
		String mytime = sdf.format(date);
		/**
		 * 时间类型格式转换+8小时
		 */
		String nowtime = TimeUtil.formatTimeEight(mytime);
		Date transDate = sdf.parse(nowtime);
		trans.setTransId(transId);
		trans.setTransDate(transDate);
		trans.setRemark(remark);
		trans.setCardId(myCardId);
		trans.setOtherCardId(otherCardId);
		trans.setTransMoney(transMoney);
		trans.setTransType("转账");
		transDao.insertTrans(trans);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void interestIncome(BigDecimal transMoney, String remark, String cardId,BigDecimal rate) throws Exception {
		Trans trans = new Trans();
		String transId = RandomCardId.getBrankNumber("6");
		Date date = new Date();
		/**
		 * 格式化java系统当前时间
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		/**
		 * 转换为本地系统当前时间
		 */
		String mytime = sdf.format(date);
		/**
		 * 时间类型格式转换+8小时
		 */
		String nowtime = TimeUtil.formatTimeEight(mytime);
		Date transDate = sdf.parse(nowtime);
		trans.setTransId(transId);
		trans.setTransDate(transDate);
		trans.setRemark(remark);
		trans.setCardId(cardId);
		trans.setOtherCardId(null);
		trans.setTransMoney(transMoney);
		trans.setTransType("利息");
		transDao.insertTransByRate(trans,rate);
	}

}