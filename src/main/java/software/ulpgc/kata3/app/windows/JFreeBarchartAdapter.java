package software.ulpgc.kata3.app.windows;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import software.ulpgc.kata3.arquitecture.model.Barchart;

public class JFreeBarchartAdapter {
    public static JFreeChart adapt(Barchart barchart) {
        return ChartFactory.createBarChart(barchart.getTitle(),
                barchart.getxAxis(),
                barchart.getyAxis(),
                datasetOf(barchart));
    }

    private static DefaultCategoryDataset datasetOf(Barchart barchart) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (String key: barchart.keySet())
            dataset.addValue(barchart.get(key), "", key);
        return dataset;
    }
}
