package com.liuqiqi.record.study.controller;

import com.liuqiqi.record.common.utils.PageUtils;
import com.liuqiqi.record.common.utils.R;
import com.liuqiqi.record.study.entity.ViewLogEntity;
import com.liuqiqi.record.study.service.ViewLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 学习-用户学习浏览记录表
 *
 * @author liuqiqi
 * @email liu677688@163.com
 * @date 2021-03-06 10:09:24
 */
@RestController
@RequestMapping("study/viewlog")
public class ViewLogController {
    @Autowired
    private ViewLogService viewLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = viewLogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		ViewLogEntity viewLog = viewLogService.getById(id);

        return R.ok().put("viewLog", viewLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ViewLogEntity viewLog){
		viewLogService.save(viewLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ViewLogEntity viewLog){
		viewLogService.updateById(viewLog);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		viewLogService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
