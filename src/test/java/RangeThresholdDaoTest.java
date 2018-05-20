import com.dao.RangeThresholdDao;
import com.pojo.RangeThreshold;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class RangeThresholdDaoTest {
    @Autowired
    private RangeThresholdDao rangeThresholdDao;

    // 点是否存在
    @Test
    public void testIsHotExisted() {
        RangeThreshold rangeThreshold = new RangeThreshold();
        rangeThreshold.setRangeId(1);
        rangeThreshold.setX(1);
        rangeThreshold.setY(1);
        rangeThreshold.setRangeName("test");
        Integer res = rangeThresholdDao.isExisted(rangeThreshold);
        System.out.print(res);
    }

    // 根据rangeName返回所有的点
    @Test
    public void testAllPointByRangeName() {
        String rangeName = "qwe";
        List<RangeThreshold> rangeThresholdList = rangeThresholdDao.allPointByRangeName(rangeName);
        System.out.print(rangeThresholdList.size());
    }

    // 删除点
    @Test
    public void testDeletePint() {
        RangeThreshold rangeThreshold = new RangeThreshold();
        rangeThreshold.setX(1);
        rangeThreshold.setY(1);
        int res = rangeThresholdDao.deletePoint(rangeThreshold);
        System.out.print("res" + res);
    }

    //插入点
    @Test
    public void testInsertNewPoint() {
        RangeThreshold rangeThreshold = new RangeThreshold();
        rangeThreshold.setX(5);
        rangeThreshold.setX(5);
        rangeThreshold.setRangeName("insert");
        int res = rangeThresholdDao.insertNewPoint(rangeThreshold);
        System.out.print("res:" + res);
    }

    //    查询点
    @Test
    public void testQueryRangeThreshold() {
        RangeThreshold rangeThreshold1 = new RangeThreshold();
        rangeThreshold1.setX(2);
        rangeThreshold1.setY(2);
        RangeThreshold res = rangeThresholdDao.queryRangeThreshold(rangeThreshold1);
        System.out.print(res.getRangeId());
    }
    /*查询所有的范围阈值*/
    @Test
    public  void testGetAllRange(){
        List<RangeThreshold> rangeThresholds =rangeThresholdDao.getAllRangeThre();
        for(Iterator<RangeThreshold> it = rangeThresholds.iterator();it.hasNext();){
            RangeThreshold rangeThreshold = it.next();
            System.out.println(rangeThreshold.toString());
        }
    }
}
