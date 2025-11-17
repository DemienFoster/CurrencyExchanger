package dfoster.currencyexchanger.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String urlConnection = "jdbc:sqlite:C:/Users/demf/Desktop/CurrencyExchanger/currency_exchange.db";

    static public Connection getConnection() {

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(urlConnection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }
}
