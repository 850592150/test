package com.xzt.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xzt85
 */
@Service
public interface TransService {
    /**
     * 存钱
     * @param transMoney
     * @param remark
     * @param cardId
     * @throws Exception
     */
    void saveMoney(BigDecimal transMoney, String remark, String cardId) throws Exception;

    /**
     * 取钱
     * @param transMoney
     * @param remark
     * @param cardId
     * @throws Exception
     */
    void reduceMoney(BigDecimal transMoney, String remark, String cardId) throws Exception;

    /**
     * 转账
     * @param transMoney
     * @param remark
     * @param myCardId
     * @param otherCardId
     * @throws Exception
     */
    void transMoney(BigDecimal transMoney, String remark, String myCardId,String otherCardId) throws Exception;

    /**
     * 查找所有银行卡号
     * @return
     */

    /**
     * 利息收入
     */
    void interestIncome(BigDecimal transMoney, String remark, String cardId,BigDecimal rate) throws Exception;
}
