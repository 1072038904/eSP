package com.dao;

import com.pojo.RangeThreshold;

import java.util.List;

public interface RangeThresholdDao {
    //判断该实体是否在在数据库中  return 0表示不存在  return 非0 表示存在
    Integer isExisted(RangeThreshold rangeThreshold);

    // 根据rangeName查询所有的点
    List<RangeThreshold> allPointByRangeName(String rangeName);

    //插入点
    int insertNewPoint(RangeThreshold rangeThreshold);

    //更新点
    int updatePoint(RangeThreshold rangeThreshold);

    //删除点
    int deletePoint(RangeThreshold rangeThreshold);

    //查询出点
    RangeThreshold queryRangeThreshold(RangeThreshold threshold);

    //查询出所有的rangeName并去重（即获取所有分类的rangeName）
    List<String> queryAllRangeName();
    /*查询出所有的范围阈值数据*/
    List<RangeThreshold> getAllRangeThre();
}
