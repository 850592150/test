package com.xzt.pojo;

import lombok.Data;

import java.math.BigDecimal;
/**
 * @author xzt85
 */
@Data
public class Rate {
    /**
     * 主键
     */
    private int rateId;
    /**
     * 利率
     */
    private BigDecimal moneyRate;
}
