package com.xzt.dao;

import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
/**
 * @author xzt85
 */
@Mapper
public interface RateDao {
    /**
     * 查找利率
     * @return
     */
    BigDecimal findRate();
}
