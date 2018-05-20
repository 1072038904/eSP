package com.pojoPolicy;

import com.pojo.Hot;
import com.pojo.RangeThreshold;

import java.util.List;
import java.util.Map;

public interface RangeThresholdPolicy {
    /*根据序列差值划分点集合*/
    //List <List <RangeThreshold>> divideHotsByTiemthreshold(List <RangeThreshold> rangeThresholds,int timeThreshold);
    List <List <RangeThreshold>> divideHotsByTiemthreshold(List<Hot> hots, int timeThreshold);
    /*计算簇的序列差值*/
    int CalculateSequenceDifference(List<RangeThreshold> rangeThresholds, int difference);
    /*initialize the 12 cluseters by using Map (the key is the rangeName)*/
    Map<String,Hot> initializeClusters();
    /*对按序列差值划分后的集合进行差值计算，并进行标记*/
    List<List<Hot>> mainAnalysis(List<Hot> hotList);
}
