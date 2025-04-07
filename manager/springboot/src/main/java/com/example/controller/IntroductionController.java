package com.example.controller;

import com.example.common.Result;
import com.example.entity.Introduction;
import com.example.service.IntroductionService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 信息表前端操作接口
 **/
@RestController
@RequestMapping("/introduction")
public class IntroductionController {

    @Resource
    private IntroductionService introductionService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Introduction introduction) {
        introductionService.add(introduction);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        introductionService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        introductionService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Introduction introduction) {
        introductionService.updateById(introduction);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Introduction introduction = introductionService.selectById(id);
        return Result.success(introduction);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(Introduction introduction ) {
        List<Introduction> list = introductionService.selectAll(introduction);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(Introduction introduction,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Introduction> page = introductionService.selectPage(introduction, pageNum, pageSize);
        return Result.success(page);
    }

}