package com.eminkabacaoglu.finalproject.util;

import com.eminkabacaoglu.finalproject.chart.BarChart;
import com.eminkabacaoglu.finalproject.chart.LineChart;
import com.eminkabacaoglu.finalproject.chart.PieChart;
import com.eminkabacaoglu.finalproject.chart.TableChart;
import com.eminkabacaoglu.finalproject.model.AgencyPerformance;
import com.eminkabacaoglu.finalproject.model.Policy;
import com.eminkabacaoglu.finalproject.service.CustomerPolicyService;

import java.util.LinkedHashMap;
import java.util.List;

public class Show {

    CustomerPolicyService customerPolicyService = new CustomerPolicyService();
    public void showPolicyTypeTotalAmount(LinkedHashMap<Policy, Double> policyAmounts){

        BarChart barChart = new BarChart();
        try {
            barChart.barchart(policyAmounts);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void showPaymentsByYear(LinkedHashMap<String,Double> policyPayments){

        LineChart lineChart = new LineChart();
        try {
            lineChart.lineChart(policyPayments);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void showQuantityOfPoliciesByCity(LinkedHashMap<String,Integer> quantityOfPoliciesByCity){

        PieChart pieChart = new PieChart();
        try {
            pieChart.pieChart(quantityOfPoliciesByCity);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void showAgencyPerformanceTable(List<AgencyPerformance> agencyPerformanceInfos){

        TableChart tableChart = new TableChart();
        try {
            tableChart.tableChart(agencyPerformanceInfos);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}
