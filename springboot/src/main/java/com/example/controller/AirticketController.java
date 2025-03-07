package com.example.controller;

import com.example.common.Result;
import com.example.entity.Airticket;
import com.example.service.AirticketService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 机票信息表前端操作接口
 **/
@RestController
@RequestMapping("/airticket")
public class AirticketController {

    @Resource
    private AirticketService airticketService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Airticket airticket) {
        airticketService.add(airticket);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        airticketService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        airticketService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Airticket airticket) {
        airticketService.updateById(airticket);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Airticket airticket = airticketService.selectById(id);
        return Result.success(airticket);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(Airticket airticket ) {
        List<Airticket> list = airticketService.selectAll(airticket);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(Airticket airticket,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Airticket> page = airticketService.selectPage(airticket, pageNum, pageSize);
        return Result.success(page);
    }

}