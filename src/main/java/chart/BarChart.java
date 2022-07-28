package chart;

import model.Policy;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.IOException;
import java.util.HashMap;

public class BarChart extends Chart{
    public void barchart(HashMap<Policy,Double> policyAmounts) throws IOException {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        for (Policy p: policyAmounts.keySet()){
            dataset.addValue(policyAmounts.get(p),p.getName(),"Amount");
        }


        JFreeChart barChart = ChartFactory.createBarChart(
                "Total Insurance Amounts By Policy Type - ("+getReprtingDate()+")",
                "Types", "Amount",
                dataset, PlotOrientation.VERTICAL,
                true, true, false);

        //saving chart as image
        String pathName="Total Policy Amount BarChart.jpeg";
        saveAsImage(pathName,barChart);
        //showing chart on Jframe
        showFrame(barChart);


    }
}
