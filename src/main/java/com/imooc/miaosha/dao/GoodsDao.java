package com.imooc.miaosha.dao;

import com.imooc.miaosha.domain.MiaoshaGoods;
import com.imooc.miaosha.vo.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
/**
 * @author Bob Simon
 * @desc 商品数据持久层
 */
public interface GoodsDao {

    /**
     * 列举商品信息
     * @return
     */
    @Select("select g.*,mg.miaosha_price,mg.stock_count,mg.start_date,mg.end_date from miaosha_goods mg left join goods g on mg.goods_id=g.id")
    public List<GoodsVo> listGoodsVo();

    /**
     * 通过id获取 goodsvo
     * @param goodsId
     * @return
     */
    @Select("select g.*,mg.miaosha_price,mg.stock_count,mg.start_date,mg.end_date from miaosha_goods mg left join goods g on mg.goods_id=g.id where g.id = #{goodsId}")
    public GoodsVo getGoodsVoGetById(@Param("goodsId")long goodsId);

    /**
     * 库存减一
     * @param g
     * @return
     */
    @Update("update miaosha_goods set stock_count = stock_count-1 where goods_id = #{goodsId} and stock_count>0 ")
    public int reduceStock(MiaoshaGoods g);
}
