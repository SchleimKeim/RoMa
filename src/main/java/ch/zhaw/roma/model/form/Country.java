package ch.zhaw.roma.model.form;

import java.util.ArrayList;
import java.util.List;

public class Country {

    private String CountryString;

    public static List<String> getCOUNTRIES() {
        return COUNTRIES;
    }

    public static final List<String> COUNTRIES = new ArrayList<String>() {{
        add("Oceania");
        add("Eurasien");
        add("Eastasia");
        add("Schweiz");
        add("Deutschland");
        add("Taka-Tuka-Land");
    }};

    public Country() {
    }

    public Country(String countryString) {
        CountryString = countryString;
    }

    public String getCountryString() {
        return CountryString;
    }

    public void setCountryString(String countryString) {
        CountryString = countryString;
    }


}
