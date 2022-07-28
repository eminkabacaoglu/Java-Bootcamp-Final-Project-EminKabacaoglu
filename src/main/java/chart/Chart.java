package chart;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Chart {

    public void showFrame(JFreeChart chart){
        ChartPanel cp = new ChartPanel(chart);
        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(cp);
        frame.setSize(850, 500);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);
    }

    public String getReprtingDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public void saveAsImage(String pathName,JFreeChart chart){
        int width = 800;   /* Width of the image */
        int height = 500;  /* Height of the image */
        File pieChart = new File( pathName);
        try {
            ChartUtilities.saveChartAsJPEG( pieChart , chart , width , height );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
