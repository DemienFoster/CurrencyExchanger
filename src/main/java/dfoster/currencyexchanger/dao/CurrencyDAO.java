package dfoster.currencyexchanger.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import dfoster.currencyexchanger.model.Currency;

public class CurrencyDAO {

    private static final String urlConnection = "jdbc:sqlite:C:/Users/demf/Desktop/CurrencyExchanger/currency_exchange.db";
    private static Connection connection;
    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection(urlConnection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public List<Currency> getCurrencies() {
        List<Currency> currencies = new ArrayList<Currency>();


        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Currencies");
            while (resultSet.next()) {
                Currency currency = new Currency();
                currencies.add(currency);
                currency.setCode(resultSet.getString("Code"));
                currency.setName(resultSet.getString("FullName"));
                currency.setSign(resultSet.getString("Sign"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return currencies;
    }

    public void addCurrencies(Currency currency) {

        try {
            Statement statement = connection.createStatement();
            String query = "insert into Currencies values (" + Long.toString(currency.getId()) + ", "
                    + "\'" + currency.getCode() + "\'" +  ", "
                    + "\'" + currency.getName() + "\'"+ ", "
                    + "\'" + currency.getSign() + "\'"+ ")";
            statement.executeUpdate(query);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

     /*
        try {



        while (resultSet.next()) {
            out.print("<h2>" + resultSet.getString("ID") + "\t" +
                    resultSet.getString("Code") + "\t" +
                    resultSet.getString("FullName") + "\t" +
                    resultSet.getString("Sign") + "</h2>\t\n");
        }
        statement.close();
    } catch (
    SQLException e) {
        throw new RuntimeException(e);
    }*/
}
