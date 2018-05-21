package com.service.impl;

import com.dao.RangeThresholdDao;
import com.pojo.Hot;
import com.pojo.RangeThreshold;
import com.pojoPolicy.RangeThresholdPolicy;
import com.pojoPolicy.imple.RangeThresholdPolicyImple;
import com.service.RangeThresholdService;
import com.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RangeThresholdServiceImpl implements RangeThresholdService {
    @Autowired
    private RangeThresholdDao rangeThresholdDao;
    private RangeThresholdPolicy rangeThresholdPolicy = new RangeThresholdPolicyImple();

    @Override
    public List<RangeThreshold> allPointByRangeName(String rangeName) {
        return rangeThresholdDao.allPointByRangeName(rangeName);
    }

    @Override
    public int isExisted(RangeThreshold rangeThreshold) {
        // 不存在返回非0  存在返回0
        int res=rangeThresholdDao.isExisted(rangeThreshold);
        return res;
    }

    @Override
    public RangeThreshold queryRangeThreshold(RangeThreshold threshold) {

        return null;
    }

    @Override
    public int insertPoint(RangeThreshold rangeThreshold) {
        int res=rangeThresholdDao.insertNewPoint(rangeThreshold);
        return res;
    }

    @Override
    public int deletePoint(RangeThreshold rangeThreshold) {
        int res=rangeThresholdDao.deletePoint(rangeThreshold);
        return res;
    }

    @Override
    public Map<String ,List<Hot>> divideHotsByRange(List<Hot> hots, int timeThreshold) {
        Map<String,List<Hot>> hotMap = new HashMap<>();
        //initialize the 12 clusters
        List<String> rangeNameList = rangeThresholdDao.queryAllRangeName();
        for(Iterator<String> rangeName = rangeNameList.iterator();rangeName.hasNext();){
            List<Hot> list = new ArrayList<>();
            hotMap.put(rangeName.next(),list);
        }
        for(Iterator<Hot> it = hots.iterator(); it.hasNext();){
            Hot hot = it.next();
            RangeThreshold rangeThreshold = new RangeThreshold();
            rangeThreshold.initializeRnageTHresholdByHot(hot);
            int judgeKey = isExisted(rangeThreshold);
            //Map to save the cluseters divided
            if(judgeKey==0){
                RangeThreshold threshold = queryRangeThreshold(rangeThreshold);
                hotMap.get(threshold.getRangeName()).add(hot);
            }
        }
        for(Iterator<String> rangeName = rangeNameList.iterator();rangeName.hasNext();){
            List<Hot> hotList = hotMap.get(rangeName.next());
            List<List<Hot>> listList = rangeThresholdPolicy.mainAnalysis(hotList);//即区域内划分好的簇
        }
        return hotMap;
    }

    @Override
    public List<RangeThreshold> getAllRangeThre() {
        List<RangeThreshold> rangeThresholds = rangeThresholdDao.getAllRangeThre();
        return rangeThresholds;
    }

    @Override
    public PageBean<RangeThreshold> findByPage(int currentPage) {
        HashMap<String,Object> map = new HashMap<>();
        PageBean<RangeThreshold> pageBean = new PageBean<>();
        //封装当前页数
        pageBean.setCurrPage(currentPage);

        //每页显示页数
        int pageSize = 2;
        pageBean.setPageSize(pageSize);

        //封装总记录数
        int totalCount = rangeThresholdDao.getCount();
        pageBean.setTotalCount(totalCount);

        //封装总页数
        double tc =totalCount;
        Double num = Math.ceil(tc);
        pageBean.setTotalPage(num.intValue());

        map.put("start",(currentPage-1)*pageSize);
        map.put("size",pageBean.getPageSize());
        //封装每页显示的数据
        List<RangeThreshold> rangeThresholdList = rangeThresholdDao.getRangeByPage(map);
        pageBean.setLists(rangeThresholdList);

        return pageBean;
    }

    public static void main(String args[]){
//        List<Hot> hotList = new ArrayList<>();
        List<List<Hot>> resultList = new ArrayList<>();
        for(int i = 0;i<3;i++){
            List<Hot> tempList = new ArrayList<>();
            resultList.add(tempList);
        }
        /*
        for(int i = 1;i<hotList.size();i++){
            int value = hotList.get(i).getTimeId()-hotList.get(i-1).getTimeId();
            if(value!=1) {
                List<Hot> tempList = new ArrayList<>();
                resultList.add(tempList);
            }
        }*/
        System.out.println(resultList.size());
        /*
    Map<String,List<String>> mapList = new HashMap<>();
    List<String> list= new ArrayList<>();
    mapList.put("acm",list);
    String a = "1";
    String b = "2";
    String c = "3";
    mapList.get("acm").add(a);
    mapList.get("acm").add(b);
    mapList.get("acm").add(c);
    System.out.println(mapList.get("acm"));*/
   // mapList.add(map);
   // map.
    //System.out.println(mapList.);

    //System.out.println(intmap.get("1"));
    }
}
