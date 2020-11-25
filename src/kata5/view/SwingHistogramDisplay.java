package kata5.view;

import kata5.model.Histogram;
import java.awt.Container;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.ui.ApplicationFrame;

public class SwingHistogramDisplay extends ApplicationFrame implements HistogramDisplay {

    private final Histogram<String> histogram;

    public SwingHistogramDisplay(String title, Histogram histogram) {
        super(title);
        this.histogram = histogram;
        this.setContentPane(createPanel());
        this.pack();
    }
    private JPanel createPanel() {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        
        return chartPanel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart("Histogram", 
                "email domains", 
                "nº emails", 
                dataset, 
                PlotOrientation.VERTICAL, 
                false, 
                false, 
                rootPaneCheckingEnabled);
        return chart;
    }
    
    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int others = 0;
        
        for (String key : histogram.keySet()) {
            if (histogram.get(key) == 1) others++;
            else dataset.addValue(histogram.get(key), "", key);
        }
        dataset.addValue(others, "", "Others");

        return dataset;
    }
    
    @Override
    public void execute() {
        setVisible(true);
    }
}