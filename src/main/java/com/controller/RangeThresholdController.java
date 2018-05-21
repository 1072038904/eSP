package com.controller;

import com.pojo.RangeThreshold;
import com.service.RangeThresholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("range")
public class    RangeThresholdController {
    @Autowired
    private RangeThresholdService rangeThresholdService;

    // 查询是否存在点 不存在就插入 返回1 成功  返回0不成功
    @RequestMapping("/insertPoint")
    @ResponseBody
    public int isExisted(RangeThreshold rangeThreshold) {
        // 0 表示存在 执行插入
        if (rangeThresholdService.isExisted(rangeThreshold) == 0) {
            int res = rangeThresholdService.insertPoint(rangeThreshold);
            return res;
        }
        return 0;
    }

    //根据rangeName返回所有的点
    @RequestMapping("/getAllPointByRangeName")
    @ResponseBody
    public List<RangeThreshold> getAllPointByRangeName(String rangeName) {
        List<RangeThreshold> list = rangeThresholdService.allPointByRangeName(rangeName);
        if (list == null)
            System.out.print("list为空");
        else
            return list;
        return null;
    }

    //删除点
    @RequestMapping("/deletePoint")
    @ResponseBody
    public int deletePoint(RangeThreshold rangeThreshold) {
        int res = rangeThresholdService.deletePoint(rangeThreshold);

        return res;
    }
    /*分页显示所有时间阈值数据*/
    @RequestMapping("/getRangeByPage")
    public  String getRangePage(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage,Model model){
        System.out.print(currentPage);
        if(currentPage>=1)
            model.addAttribute("rangePage",rangeThresholdService.findByPage(currentPage));
        else model.addAttribute("rangePage",rangeThresholdService.findByPage(1));
        return "thresholdManagement";
    }
    /*分页显示所有时间阈值数据*/
    @RequestMapping("/editRange")
    public  String editRange(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage,Model model){
        if(currentPage>=1)
            model.addAttribute("rangePage",rangeThresholdService.findByPage(currentPage));
        else model.addAttribute("rangePage",rangeThresholdService.findByPage(1));
        return "editThre";
    }
}
