public class Main {
    public static void main(String[] args) {
        try {
            var dbHandler = DBHandler.getInstance();
            var csvCountries = new Countries("Показатель счастья по странам 2015.csv");
            for (var country : csvCountries.getCountries()) {
                dbHandler.addCountry(country);
            }

            var dbCountries = dbHandler.getAllCountries();
            for (var country : dbCountries) {
                System.out.println(country.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}