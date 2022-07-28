package chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.LinkedHashMap;

public class LineChart extends Chart{

    public void lineChart( LinkedHashMap<String,Double> policyPayments) throws Exception {
        DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();

        for (String p:policyPayments.keySet()){
            line_chart_dataset.addValue(policyPayments.get(p),"Amount",p);
        }

        JFreeChart lineChartObject = ChartFactory.createLineChart(
                "Total Payments By Years - ("+getReprtingDate()+")","Year",
                "Payment Amount",
                line_chart_dataset, PlotOrientation.VERTICAL,
                true,true,false);

        //saving chart as image
        String pathName="Total Payments By Year LineChart.jpeg";
        saveAsImage(pathName,lineChartObject);

        //showing chart on Jframe
        showFrame(lineChartObject);
    }
}
