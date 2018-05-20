package com.controller;

import com.pojo.RangeThreshold;
import com.service.RangeThresholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("view")
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
    /*返回所有时间阈值数据*/
    @RequestMapping(value="test")
    public String  getAllRangeThreshold(){
        System.out.print("123");
        return "he";
    }
}
