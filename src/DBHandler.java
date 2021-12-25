import org.sqlite.JDBC;

import java.sql.*;
import java.util.*;

public class DBHandler {
    private static final String CON_STR = "jdbc:sqlite:Countries.db";
    private static DBHandler instance = null;

    public static synchronized DBHandler getInstance() throws SQLException {
        if (instance == null)
            instance = new DBHandler();

        return instance;
    }

    private Connection connection;

    private DBHandler() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(CON_STR);
        var stmt = this.connection.createStatement();
        stmt.executeUpdate("DROP TABLE Countries");
        stmt.executeUpdate("CREATE TABLE Countries(id INTEGER NOT NULL PRIMARY KEY," +
                "Country TEXT, Region TEXT, HappinessRank INTEGER, HappinessScore FLOAT, " +
                "StandardError FLOAT, Economy FLOAT, Family FLOAT, Health FLOAT, Freedom FLOAT, " +
                "Trust FLOAT, Generosity FLOAT, DystopiaResidual FLOAT)");
        stmt.close();
    }

    public List<Country> getAllCountries() {
        try (var statement = this.connection.createStatement()) {
            var countries = new ArrayList<Country>();
            var resultSet = statement.executeQuery("SELECT Country, Region, HappinessRank, HappinessScore, " +
                    "StandardError, Economy, Family, Health, Freedom, Trust, Generosity, DystopiaResidual FROM Countries");
            while (resultSet.next()) {
                countries.add(new Country(resultSet.getString("Country"),
                        resultSet.getString("Region"),
                        resultSet.getInt("HappinessRank"),
                        resultSet.getFloat("HappinessScore"),
                        resultSet.getFloat("StandardError"),
                        resultSet.getFloat("Economy"),
                        resultSet.getFloat("Family"),
                        resultSet.getFloat("Health"),
                        resultSet.getFloat("Freedom"),
                        resultSet.getFloat("Trust"),
                        resultSet.getFloat("Generosity"),
                        resultSet.getFloat("DystopiaResidual")));
            }
            return countries;

        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public void addCountry(Country country) {
        try (var statement = this.connection.prepareStatement(
                "INSERT INTO Countries(Country, Region, HappinessRank, HappinessScore, StandardError, " +
                        "Economy, Family, Health, Freedom, Trust, Generosity, DystopiaResidual) " +
                        "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            statement.setObject(1, country.country);
            statement.setObject(2, country.region);
            statement.setObject(3, country.happinessRank);
            statement.setObject(4, country.happinessScore);
            statement.setObject(5, country.standardError);
            statement.setObject(6, country.economy);
            statement.setObject(7, country.family);
            statement.setObject(8, country.health);
            statement.setObject(9, country.freedom);
            statement.setObject(10, country.trust);
            statement.setObject(11, country.generosity);
            statement.setObject(12, country.dystopiaResidual);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCountry(int id) {
        try (var statement = this.connection.prepareStatement(
                "DELETE FROM Countries WHERE id = ?")) {
            statement.setObject(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}