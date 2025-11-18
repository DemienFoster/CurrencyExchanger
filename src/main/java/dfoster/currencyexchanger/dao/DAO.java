package dfoster.currencyexchanger.dao;

import dfoster.currencyexchanger.entity.Currency;

import java.util.List;
import java.util.Optional;

public interface DAO<K, T> {
    List<T> findAll();
    Optional<T> findById(K id);
    boolean delete(K id);
    void update(T entity);

    void save(T entity);
}
