package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.example.entity.Busticket;
import com.example.entity.Busorders;
import com.example.exception.CustomException;
import com.example.mapper.BusticketMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.time.DateUtils;


/**
 * 管理员业务处理
 **/
@Service
public class BusticketService {

    @Resource
    private BusticketMapper busticketMapper;

    /**
     * 新增
     */
    public void add(Busticket busticket) {busticketMapper.insert(busticket);}

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        busticketMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            busticketMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(Busticket busticket) {
        busticketMapper.updateById(busticket);
    }

    /**
     * 根据ID查询
     */
    public Busticket selectById(Integer id) {
        return busticketMapper.selectById(id);
    }

    public PageInfo<Busticket> selectPage(Busticket busticket, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);  // 设置分页参数
        List<Busticket> list = busticketMapper.selectAll(busticket);  // 查询所有符合条件的巴士票信息
        return PageInfo.of(list);  // 将查询结果封装为PageInfo对象并返回
    }
    public List<Busticket> getChange(Busorders busorders) throws ParseException {
        // 1. 检查航班时间是否有效
        String now = DateUtil.now();  // 获取当前时间
        String flyTime = busorders.getFlyTime();  // 获取订单中的航班时间
//        if (!TimeUtils.compareDate(flyTime, now, "yyyy-MM-dd HH:mm:ss")) {
//            throw new CustomException("-1", "..", "...");  // 如果航班时间无效，抛出异常
//        }

        // 2. 根据订单中的票ID查询巴士票信息
        Integer ticketId = busorders.getTicketId();  // 获取订单中的票ID
        Busticket busticket = busticketMapper.selectById(ticketId);  // 根据票ID查询巴士票信息

        // 3. 查询所有巴士票信息
        List<Busticket> bustickets = busticketMapper.selectAll(new Busticket());  // 查询所有巴士票

        // 4. 过滤符合条件的巴士票并返回
        return bustickets.stream()
                .filter(x -> x.getStartCity().equals(busticket.getStartCity())  // 出发城市匹配
                        && x.getEndCity().equals(busticket.getEndCity())  // 到达城市匹配
                        && x.getNum() >= busorders.getNum()  // 票数足够
                        && !x.getId().equals(ticketId))  // 排除当前票
                .collect(Collectors.toList());  // 将过滤后的结果收集为列表
    }
}