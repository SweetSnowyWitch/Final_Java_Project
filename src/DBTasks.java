import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class DBTasks {
    private final List<Country> dbCountries;

    public DBTasks(List<Country> dbCountries) {
        this.dbCountries = dbCountries;
    }

    public void ZeroTask() {
        dbCountries.forEach(c -> System.out.println(c.toString()));
        System.out.println("\n");
    }

    public void FirstTask() {
        var series = new XYSeries("Задание 1");
        var count = 0;
        for (var country : dbCountries) {
            series.add(count, country.economy);
            count += 1;
        }

        var dataset = new XYSeriesCollection(series);
        var chart = ChartFactory.createXYLineChart("Задание 1",
                "Country", "Economy", dataset);
        var frame = new JFrame();
        frame.getContentPane().add(new ChartPanel(chart));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.show();
    }

    public void SecondTask() {
        var result = dbCountries.stream().filter(c ->
                        Objects.equals(c.region, "Latin America and Caribbean")
                                || Objects.equals(c.region, "Eastern Asia"))
                .max(Comparator.comparing(c -> c.economy));
        System.out.println("Ответ на задание 2: " + result.get() + "\n");
    }

    public void ThirdTask() {
        var result = dbCountries.stream().filter(c ->
                        Objects.equals(c.region, "Western Europe")
                                || Objects.equals(c.region, "North America"))
                .sorted(Comparator.comparing(c -> c.economy)).toArray();
        System.out.println("Ответ на задание 3: " + result[(int) Math.floor(result.length / 2)] + "\n");
    }
}
