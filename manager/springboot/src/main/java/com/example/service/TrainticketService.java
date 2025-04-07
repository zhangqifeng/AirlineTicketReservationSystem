package com.example.service;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.Constants;
import com.example.common.enums.ResultCodeEnum;
import com.example.common.enums.RoleEnum;
import com.example.entity.Account;
import com.example.entity.Trainticket;
import com.example.exception.CustomException;
import com.example.mapper.TrainticketMapper;
import com.example.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 管理员业务处理
 **/
@Service
public class TrainticketService {

    @Resource
    private TrainticketMapper trainticketMapper;

    /**
     * 新增
     */
    public void add(Trainticket trainticket) {trainticketMapper.insert(trainticket);}

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        trainticketMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            trainticketMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(Trainticket trainticket) {
        trainticketMapper.updateById(trainticket);
    }

    /**
     * 根据ID查询
     */
    public Trainticket selectById(Integer id) {
        return trainticketMapper.selectById(id);
    }


}