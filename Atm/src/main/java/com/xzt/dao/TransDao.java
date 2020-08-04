package com.xzt.dao;

import com.xzt.pojo.Trans;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.ArrayList;

@Mapper
public interface TransDao {
      /**
       * 插入交易明细
       * @param trans
       * @return
       */
      int insertTrans(Trans trans);

      /**
       * 根据利率插入交易明细表
       * @param trans
       * @param rate
       */
      void insertTransByRate(@Param("trans") Trans trans, @Param("rate") BigDecimal rate);
}
