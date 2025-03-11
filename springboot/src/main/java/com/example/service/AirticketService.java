package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.example.entity.Account;
import com.example.entity.Airticket;
import com.example.mapper.AirticketMapper;
import com.example.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 机票信息表业务处理
 **/
@Service
public class AirticketService {

    @Resource
    private AirticketMapper airticketMapper;

    /**
     * 新增
     */
    public void add(Airticket airticket) {
        airticket.setTime(DateUtil.today());
        Account currentUser = TokenUtils.getCurrentUser();

        airticketMapper.insert(airticket);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        airticketMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            airticketMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(Airticket airticket) {
        airticketMapper.updateById(airticket);
    }

    /**
     * 根据ID查询
     */
    public Airticket selectById(Integer id) {
        return airticketMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    public List<Airticket> selectAll(Airticket airticket) {
        List<Airticket> airtickets = airticketMapper.selectAll(airticket);
        for (Airticket dbAirticket : airtickets) {
            String name = dbAirticket.getName();
            String left = name.split(" ")[0];
            String right = name.split(" ")[1];
            dbAirticket.setLeft(left);
            dbAirticket.setRight(right);

        }
        return airtickets;
    }

    /**
     * 分页查询
     */
    public PageInfo<Airticket> selectPage(Airticket airticket, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Airticket> list = airticketMapper.selectAll(airticket);
        return PageInfo.of(list);
    }

}