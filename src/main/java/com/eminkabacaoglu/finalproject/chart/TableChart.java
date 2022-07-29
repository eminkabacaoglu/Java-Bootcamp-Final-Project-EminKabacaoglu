package com.eminkabacaoglu.finalproject.chart;

import com.eminkabacaoglu.finalproject.model.AgencyPerformance;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class TableChart {
    public void tableChart(List<AgencyPerformance> agencyPerformanceInfo) throws IOException {
        int reportColumnNumber = 5;
        JFrame f = new JFrame("Agency Performance Table");
        Object[][] graph = new Object[agencyPerformanceInfo.size()][reportColumnNumber];
        int count = 0;
        for (AgencyPerformance aPerformance : agencyPerformanceInfo) {
            graph[count][0] = aPerformance.getAgency().getAgency_name();
            graph[count][1] = aPerformance.getQuantityOfPolicies();
            graph[count][2] = aPerformance.getPolicyAmount();
            graph[count][3] = aPerformance.getPolicyPaymentAmount();
            graph[count][4] = aPerformance.getRatioOfPaymentsByAmount();
            count++;
        }

        String column[] = {"Agency", "Total Quantity of Policies", "Total Amount Of Policies", "Total Payment Of Policies", "Ratio Of Payment By Amount"};


        final JTable jt = new JTable(graph, column);

        JScrollPane sp = new JScrollPane(jt);
        f.add(sp);
        f.setSize(900, 500);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setAlwaysOnTop(true);

        // save table as image
        BufferedImage image = new BufferedImage(f.getWidth(), f.getHeight(), BufferedImage.TYPE_INT_RGB);
        f.paint(image.getGraphics());
        ImageIO.write(image, "jpeg", new File("Table of Agency Performance.jpeg"));


    }

}
