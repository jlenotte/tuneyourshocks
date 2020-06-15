package com.cnam.tuneyourshocks;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void chart_isCorrect() {

        Map<Integer, Integer> chart = WeightChartInitializer.initChart();


        for (Integer integer : chart.keySet()) {

            System.out.println(String.valueOf(integer) + " :: " + String.valueOf(chart.get(integer)));
        }


    }




}



