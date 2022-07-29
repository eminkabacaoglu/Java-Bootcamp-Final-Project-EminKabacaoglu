package com.eminkabacaoglu.finalproject.chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import java.util.LinkedHashMap;

public class PieChart extends Chart{
    public void pieChart( LinkedHashMap<String,Integer> quantityOfPoliciesByCities ) throws Exception {
        DefaultPieDataset pie_char_dataset = new DefaultPieDataset( );
        for (String p:quantityOfPoliciesByCities.keySet()){
            pie_char_dataset.setValue(p,quantityOfPoliciesByCities.get(p));
        }

        JFreeChart pChart = ChartFactory.createPieChart(
                "Total Policiy Quantity By City ("+getReprtingDate()+")",   // com.eminkabacaoglu.finalproject.chart title
                pie_char_dataset,          // data
                true,             // include legend
                true,
                false);

        //saving com.eminkabacaoglu.finalproject.chart as image
        String pathName="Total Quantity Of Policies By City PieChart.jpeg";
        saveAsImage(pathName,pChart);

        //showing com.eminkabacaoglu.finalproject.chart on Jframe
        showFrame(pChart);

    }
}
