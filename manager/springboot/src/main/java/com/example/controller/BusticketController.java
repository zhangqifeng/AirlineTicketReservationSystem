package com.example.controller;

import com.example.common.Result;
import com.example.entity.Busorders;
import com.example.entity.Busticket;
import com.example.service.BusticketService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;

/**
 * 管理员前端操作接口
 **/
@RestController
@RequestMapping("/busticket")
public class BusticketController {

    @Resource
    private BusticketService busticketService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Busticket busticket) {
        busticketService.add(busticket);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        busticketService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        busticketService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Busticket busticket) {
        busticketService.updateById(busticket);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Busticket busticket = busticketService.selectById(id);
        return Result.success(busticket);
    }
    @PostMapping("/getChange")
    public Result getChange(@RequestBody Busorders busorders) throws ParseException {
        List<Busticket> list = busticketService.getChange(busorders);
        return Result.success(list);
    }
    @GetMapping("/selectPage")
    public Result selectPage(Busticket busticket,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Busticket> page = busticketService.selectPage(busticket, pageNum, pageSize);
        return Result.success(page);
    }
}