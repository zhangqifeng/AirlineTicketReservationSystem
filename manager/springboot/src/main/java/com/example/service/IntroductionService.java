package com.example.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.HtmlUtil;
import com.example.entity.Account;
import com.example.entity.Introduction;
import com.example.entity.User;
import com.example.mapper.IntroductionMapper;
import com.example.mapper.UserMapper;
import com.example.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * gonglue信息表业务处理
 **/
@Service
public class IntroductionService {

    @Resource
    private IntroductionMapper introductionMapper;

    @Resource
    private UserMapper userMapper;
    /**
     * 新增
     */
    public void add(Introduction introduction) {
        introductionMapper.insert(introduction);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        introductionMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            introductionMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(Introduction introduction) {
        introductionMapper.updateById(introduction);
    }

    /**
     * 根据ID查询
     */
    public Introduction selectById(Integer id) {

        Introduction introduction = introductionMapper.selectById(id);
        User user = userMapper.selectById(introduction.getUserId());
        if (ObjectUtil.isNotEmpty(user)){
            introduction.setUserName(user.getName());
        }
        return introduction;
    }

    /**
     * 查询所有
     */
    public List<Introduction> selectAll(Introduction introduction) {
        return introductionMapper.selectAll(introduction);
    }

    /**
     * 分页查询
     */
    public PageInfo<Introduction> selectPage(Introduction introduction, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Introduction> list = introductionMapper.selectAll(introduction);
        for (Introduction dbIntroduction : list){
            dbIntroduction.setDescription(HtmlUtil.cleanHtmlTag(dbIntroduction.getContent()));
        }
        return PageInfo.of(list);
    }

}