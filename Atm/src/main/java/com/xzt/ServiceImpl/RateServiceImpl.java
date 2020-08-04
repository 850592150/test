package com.xzt.ServiceImpl;

import com.xzt.dao.RateDao;
import com.xzt.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public class RateServiceImpl implements RateService {
    @Autowired
    private RateDao rateDao;

    @Override
    public BigDecimal findRate() {
        BigDecimal rate =  rateDao.findRate();
        return rate;
    }
}
