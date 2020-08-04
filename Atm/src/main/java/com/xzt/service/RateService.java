package com.xzt.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public interface RateService {
    /**
     * 查找利率
     * @return
     */
    BigDecimal findRate();
}
