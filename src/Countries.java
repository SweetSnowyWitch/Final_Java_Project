import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Countries {
    private static ArrayList<Country> countries;

    Countries(String path) {
        countries = new ArrayList<>();
        try {
            var data = Files.readAllLines(Paths.get(path), Charset.defaultCharset());
            data.remove(0);
            data.stream()
                    .map(s -> s.split(","))
                    .forEach(s -> countries.add(new Country(s[0], s[1], Integer.parseInt(s[2]),
                            Float.parseFloat(s[3]), Float.parseFloat(s[4]), Float.parseFloat(s[5]),
                            Float.parseFloat(s[6]), Float.parseFloat(s[7]), Float.parseFloat(s[8]),
                            Float.parseFloat(s[9]), Float.parseFloat(s[10]), Float.parseFloat(s[11]))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Country> getCountries() {
        return countries;
    }
}
