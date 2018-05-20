package com.pojo;

public class RangeThreshold {
    // 唯一标识ID
    private Integer rangeId;
    //  坐标x
    private int x;
    //  坐标y
    private int y;
    //范围名称
    private String rangeName;

    //Use Hot initialize the rangeThreshold
    public void initializeRnageTHresholdByHot(Hot hot) {
        this.setX(hot.getX());
        this.setY(hot.getY());
    }

    @Override
    public String toString() {
        String re = this.rangeId+" "+this.y+" "+this.rangeName;
        return re;
    }

    public Integer getRangeId() {
        return rangeId;
    }

    public void setRangeId(Integer rangeId) {
        this.rangeId = rangeId;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getRangeName() {
        return rangeName;
    }

    public void setRangeName(String rangeName) {
        this.rangeName = rangeName;
    }
}
