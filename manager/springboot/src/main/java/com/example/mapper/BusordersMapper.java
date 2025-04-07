package com.example.mapper;

import com.example.entity.Busorders;

import java.util.List;

/**
 * 操作busorders相关数据接口
*/
public interface BusordersMapper {

    /**
      * 新增
    */
    int insert(Busorders busorders);

    /**
      * 删除
    */
    int deleteById(Integer id);

    /**
      * 修改
    */
    int updateById(Busorders busorders);

    /**
      * 根据ID查询
    */
    Busorders selectById(Integer id);

    /**
      * 查询所有
    */
    List<Busorders> selectAll(Busorders busorders);

}