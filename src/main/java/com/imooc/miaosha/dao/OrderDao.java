package com.imooc.miaosha.dao;

import com.imooc.miaosha.domain.MiaoshaOrder;
import com.imooc.miaosha.domain.OrderInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper

/**
 * @author Bob Simon
 * @desc 订单数据持久层
 */
public interface OrderDao {

    @Select("select * from miaosha_order where user_id=#{userId} and goods_id = #{goodsId}")
    public MiaoshaOrder getOrderByUserIdGoodsId(@Param("userId")long userId,@Param("goodsId")long goodsId);
    @Insert("insert into order_info(user_id, goods_id, goods_name, goods_count, goods_price, order_channel, status, create_date)values("
            + "#{userId}, #{goodsId}, #{goodsName}, #{goodsCount}, #{goodsPrice}, #{orderChannel},#{status},#{createDate} )")


    @SelectKey(keyColumn = "id",keyProperty = "id",resultType = long.class,before = false,statement = "select last_insert_id()")
    public long insert(OrderInfo orderInfo);

    @Insert("insert into miaosha_order(id,user_id,goods_id,order_id)values(#{id},#{userId},#{goodsId},#{orderId})")
    public int insertMiaoshaOrder(MiaoshaOrder miaoshaOrder);

    @Select("select * from order_info where id = #{orderId}")
    public OrderInfo getOrderById(@Param("orderId")long orderId);
}
