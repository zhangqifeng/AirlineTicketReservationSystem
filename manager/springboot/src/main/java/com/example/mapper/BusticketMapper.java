package com.example.mapper;

import com.example.entity.Busticket;

import java.util.List;

/**
 * 操作busticket相关数据接口
*/
public interface BusticketMapper {

    /**
      * 新增
    */
    int insert(Busticket busticket);

    /**
      * 删除
    */
    int deleteById(Integer id);

    /**
      * 修改
    */
    int updateById(Busticket busticket);

    /**
      * 根据ID查询
    */
    Busticket selectById(Integer id);

    /**
      * 查询所有
    */
    List<Busticket> selectAll(Busticket busticket);

}