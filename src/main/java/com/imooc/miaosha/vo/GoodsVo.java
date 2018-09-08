package com.imooc.miaosha.vo;

import com.imooc.miaosha.domain.Goods;

import java.util.Date;

/**
 * @author Bob Simon
 * @desc 商品类
 */
public class GoodsVo extends Goods {

    private Double miaoshaPrice;

    private Integer stockCount;

    private Date startDate;

    private Date endDate;

    public Double getMiaoshaPrice() {
        return miaoshaPrice;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setMiaoshaPrice(Double miaoshaPrice) {
        this.miaoshaPrice = miaoshaPrice;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
