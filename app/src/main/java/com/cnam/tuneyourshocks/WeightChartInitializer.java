package com.cnam.tuneyourshocks;

import java.util.HashMap;
import java.util.Map;

public class WeightChartInitializer {


    /*
     * This map will contain Keys and Values
     * Key = rider's weight entered in the APP
     * Value = recommended air pressure in PSI
     */
    public static Map<Integer, Integer> initChart() {

        Map<Integer, Integer> chart = new HashMap<>();
        chart.put(50, 110);
        chart.put(60, 130);
        chart.put(70, 150);
        chart.put(80, 175);
        chart.put(90, 195);
        chart.put(100, 215);
        chart.put(110, 215);
        chart.put(120, 235);
        chart.put(130, 235);
        chart.put(140, 255);
        chart.put(150, 255);
        chart.put(160, 275);

        return chart;
    }


}
