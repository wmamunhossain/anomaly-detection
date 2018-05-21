/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anomalydetection;

import java.awt.Color; 
import java.awt.BasicStroke; 
import java.awt.event.WindowEvent;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.data.xy.XYDataset; 
import org.jfree.data.xy.XYSeries; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 
import org.jfree.chart.plot.XYPlot; 
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.xy.XYSeriesCollection; 
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

/**
 *
 * @author w_mam
 */
public class PlotGraph extends ApplicationFrame {
    
    double mean,varience;
    int dimension;

    public PlotGraph(double mean, double varience,int dimension) {
      
        super("Probability Density Graph");
        
        this.mean = mean;
        this.varience = varience;
        this.dimension = dimension;
        
        JFreeChart xylineChart = ChartFactory.createXYLineChart(
                "Probability Density Graph",
                "Mean",
                "Probability",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(xylineChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(600, 600));
        final XYPlot plot = xylineChart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(.5f));
        plot.setRenderer(renderer);
        setContentPane(chartPanel);
    }

    private double calculateProbability(double value){
        return Math.exp(-((Math.pow(value-mean, 2))/(2*varience)))/(Math.sqrt(2*Math.PI*varience));
    }
    
    public void windowClosing(final WindowEvent evt) {
        if (evt.getWindow() == this) {
            dispose();
        }
    }

    private XYDataset createDataset() {
        
        String rnk;
        
        if(dimension==0)rnk = "st";
        else if(dimension==1)rnk = "nd";
        else if(dimension==3)rnk = "rd";
        else rnk = "th";
        
        final XYSeries pdg = new XYSeries("Probability Density Graph of " +(dimension+1)+rnk+ " dimension");

        for (double i = mean-5; i <= mean+5; i+=.10) {
            pdg.add(i, calculateProbability(i));
        }

        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(pdg);
        return dataset;
    }
}
