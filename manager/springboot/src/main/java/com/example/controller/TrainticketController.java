package com.example.controller;

import com.example.common.Result;
import com.example.entity.Trainticket;
import com.example.service.TrainticketService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 管理员前端操作接口
 **/
@RestController
@RequestMapping("/trainticket")
public class TrainticketController {

    @Resource
    private TrainticketService trainticketService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Trainticket trainticket) {
        trainticketService.add(trainticket);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        trainticketService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        trainticketService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Trainticket trainticket) {
        trainticketService.updateById(trainticket);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Trainticket trainticket = trainticketService.selectById(id);
        return Result.success(trainticket);
    }


}