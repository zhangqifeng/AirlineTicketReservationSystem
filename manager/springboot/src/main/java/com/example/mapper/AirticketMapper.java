package com.example.mapper;

import com.example.entity.Airticket;

import java.util.List;

/**
 * 操作airticket相关数据接口
 */
public interface AirticketMapper {

    /**
     * 新增
     */
    int insert(Airticket airticket);

    /**
     * 删除
     */
    int deleteById(Integer id);

    /**
     * 修改
     */
    int updateById(Airticket airticket);

    /**
     * 根据ID查询
     */
    Airticket selectById(Integer id);

    /**
     * 查询所有
     */
    List<Airticket> selectAll(Airticket airticket);

}