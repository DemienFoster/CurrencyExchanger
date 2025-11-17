package dfoster.currencyexchanger.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import dfoster.currencyexchanger.entity.Currency;
import dfoster.currencyexchanger.utils.DBConnection;

public class CurrencyDAO {


    public List<Currency> getCurrencies() {
        List<Currency> currencies = new ArrayList<Currency>();


        try {
            Statement statement = DBConnection.getConnection().createStatement();
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
            String querry = "insert into Currencies (code, fullname, sign) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(querry)) {
                preparedStatement.setString(1, currency.getCode());
                preparedStatement.setString(2, currency.getName());
                preparedStatement.setString(3, currency.getSign());

                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


}
