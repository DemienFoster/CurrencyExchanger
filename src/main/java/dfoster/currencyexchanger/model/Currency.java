package dfoster.currencyexchanger.model;

public class Currency {


    private static Long id = 0L;
    private String code;
    private String name;
    private String sign;

    public Long getId() {
        return ++id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", fullName='" + name + '\'' +
                ", Sign='" + sign + '\'' +
                '}';
    }
}
