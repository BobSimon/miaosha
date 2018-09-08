package com.imooc.miaosha.vo;

import com.imooc.miaosha.domain.OrderInfo;

/**
 * @author Bob Simon
 * @desc 订单详情实体类
 */
public class OrderDetailVo {

	private GoodsVo goods;

	private OrderInfo order;

	public GoodsVo getGoods() {
		return goods;
	}

	public void setGoods(GoodsVo goods) {
		this.goods = goods;
	}

	public OrderInfo getOrder() {
		return order;
	}

	public void setOrder(OrderInfo order) {
		this.order = order;
	}

}
