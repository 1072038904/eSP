package com.pojo;

import java.util.ArrayList;
import java.util.List;

public class Cluster extends RangeThreshold {
    private String rangeNmae;
    private List<Hot> hots;

    public static void main(String args[]) {
        List<Cluster> clusters = new ArrayList<>(12);
        System.out.println(clusters.size());
        for (int i = 0; i < 12; i++) {
            Cluster cluster = new Cluster();
            cluster.setRangeNmae(Integer.toString(i));
            clusters.add(cluster);
        }
        for (int i = 0; i < 12; i++) {
            System.out.println(clusters.get(i).getRangeNmae());
        }
    }

    public List<Cluster> intialCluster(List<Cluster> clusters) {
        clusters = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            Cluster cluster = new Cluster();
            cluster.setRangeNmae(Integer.toString(i));
            clusters.add(cluster);
        }
        return null;
    }

    public String getRangeNmae() {
        return rangeNmae;
    }

    public void setRangeNmae(String rangeNmae) {
        this.rangeNmae = rangeNmae;
    }

    public List<Hot> getHots() {
        return hots;
    }

    public void setHots(List<Hot> hots) {
        this.hots = hots;
    }
}


