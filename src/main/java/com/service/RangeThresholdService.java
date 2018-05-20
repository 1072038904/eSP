package com.service;

import com.pojo.Hot;
import com.pojo.RangeThreshold;

import java.util.List;
import java.util.Map;

public interface RangeThresholdService {
    // 判断是否存在记录
    int isExisted(RangeThreshold rangeThreshold);
    //查询出点
    RangeThreshold queryRangeThreshold(RangeThreshold threshold);
    // 根据rangeName返回对应的所有的点
    List<RangeThreshold> allPointByRangeName(String rangeName);
    // 插入点
    int insertPoint(RangeThreshold rangeThreshold);
    // 删除点
    int deletePoint(RangeThreshold rangeThreshold);
    //用固定的12簇来划分所有的点
    Map<String ,List<Hot>> divideHotsByRange(List<Hot> hots, int timeThreshold);
    /*得到所有的范围阈值数据*/
    List<RangeThreshold> getAllRangeThre();
}
