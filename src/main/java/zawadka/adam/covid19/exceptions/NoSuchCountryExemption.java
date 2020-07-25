package zawadka.adam.covid19.exceptions;

public class NoSuchCountryExemption extends RuntimeException {

    private static final long serialVersionUID = 2L;
    private String msg;

    public NoSuchCountryExemption(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return "NoSuchCountryExemption: value=" + msg;
    }
}
