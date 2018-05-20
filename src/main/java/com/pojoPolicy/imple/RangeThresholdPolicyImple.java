package com.pojoPolicy.imple;

import com.pojo.Hot;
import com.pojo.RangeThreshold;
import com.pojoPolicy.RangeThresholdPolicy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RangeThresholdPolicyImple implements RangeThresholdPolicy {


    @Override
    public List<List<RangeThreshold>> divideHotsByTiemthreshold(List<Hot> hots, int timeThreshold) {
       //初始化12个clusters
        return null;
    }

    @Override
    public int CalculateSequenceDifference(List<RangeThreshold> rangeThresholds, int difference) {
        int size = rangeThresholds.size();
        int result = difference * size;
        return 0;
    }

    @Override
    public Map<String, Hot> initializeClusters() {

        return null;
    }

    @Override
    public List<List<Hot>> mainAnalysis(List<Hot> hotList) {
        List<List<Hot>> resultList = new ArrayList<>();
        List<Hot> init = new ArrayList<>();
        resultList.add(init);
        for(int i = 1;i<hotList.size();i++){
            int value = hotList.get(i).getTimeId()-hotList.get(i-1).getTimeId();
            if(value!=1) {
                List<Hot> tempList = new ArrayList<>();
                resultList.add(tempList);
            }
        }
            int j=0;
            resultList.get(j).add(hotList.get(0));
            for(int i = 1;i<hotList.size();i++){
                int value = hotList.get(i).getTimeId()-hotList.get(i-1).getTimeId();
                if(value==1){
                    resultList.get(j).add(hotList.get(i));
                }
                else {
                    resultList.get(j+1).add(hotList.get(i));
                    j=j+1;
                }
        }
        return resultList;
    }
}
