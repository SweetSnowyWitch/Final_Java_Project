import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.data.xy.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            var dbHandler = DBHandler.getInstance();
            var csvCountries = new Countries("Показатель счастья по странам 2015.csv");
            for (var country : csvCountries.getCountries()) {
                dbHandler.addCountry(country);
            }
            var dbCountries = dbHandler.getAllCountries();
            var newTasks = new DBTasks(dbCountries);
            newTasks.ZeroTask();
            newTasks.FirstTask();
            newTasks.SecondTask();
            newTasks.ThirdTask();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}