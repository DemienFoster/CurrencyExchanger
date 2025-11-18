package dfoster.currencyexchanger.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dfoster.currencyexchanger.entity.Currency;
import dfoster.currencyexchanger.utils.DBConnection;

public class CurrencyDAO<Long, Currency> implements DAO{
    Currency currency;
    @Override
    public List<Currency> findAll() {
        List<Currency> currencies = new ArrayList<Currency>();


        try {
            ResultSet resultSet;
            try (Statement statement = DBConnection.getConnection().createStatement()) {
                resultSet = statement.executeQuery("SELECT * FROM Currencies");
            }
            while (resultSet.next()) {
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

    @Override
    public Optional findById(Long id) {
        return Optional.empty();
    }

    /*@Override
    public boolean deleteById(Object id) {
        return false;
    }*/

    @Override
    public void save(Currency currency) {

    }
    @Override
    public void update(Currency currency) {

        try {
            String query = "insert into Currencies (code, fullname, sign) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query)) {
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
