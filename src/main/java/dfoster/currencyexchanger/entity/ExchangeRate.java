package dfoster.currencyexchanger.entity;

import java.math.BigInteger;
import java.util.Objects;

public class ExchangeRate {
    private int id;
    private int BaseCurrencyId;
    private int TargetCurrencyId;
    private BigInteger Rate;

    public ExchangeRate() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBaseCurrencyId() {
        return BaseCurrencyId;
    }

    public void setBaseCurrencyId(int baseCurrencyId) {
        BaseCurrencyId = baseCurrencyId;
    }

    public int getTargetCurrencyId() {
        return TargetCurrencyId;
    }

    public void setTargetCurrencyId(int targetCurrencyId) {
        TargetCurrencyId = targetCurrencyId;
    }

    public BigInteger getRate() {
        return Rate;
    }

    public void setRate(BigInteger rate) {
        Rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ExchangeRate that = (ExchangeRate) o;
        return id == that.id && BaseCurrencyId == that.BaseCurrencyId && TargetCurrencyId == that.TargetCurrencyId && Objects.equals(Rate, that.Rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, BaseCurrencyId, TargetCurrencyId, Rate);
    }

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "id=" + id +
                ", BaseCurrencyId=" + BaseCurrencyId +
                ", TargetCurrencyId=" + TargetCurrencyId +
                ", Rate=" + Rate +
                '}';
    }
}
