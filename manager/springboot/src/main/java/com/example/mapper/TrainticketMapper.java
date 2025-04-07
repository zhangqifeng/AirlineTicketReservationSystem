package com.example.mapper;

import com.example.entity.Trainticket;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 操作trainticket相关数据接口
*/
public interface TrainticketMapper {

    /**
      * 新增
    */
    int insert(Trainticket trainticket);

    /**
      * 删除
    */
    int deleteById(Integer id);

    /**
      * 修改
    */
    int updateById(Trainticket trainticket);

    /**
      * 根据ID查询
    */
    Trainticket selectById(Integer id);

    /**
      * 查询所有
    */
    List<Trainticket> selectAll(Trainticket trainticket);

}