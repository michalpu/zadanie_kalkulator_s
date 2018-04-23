package com.michalpu.zadanie_kalkulator_s;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRate {
    private String code;
    private List<Rate> rates = new ArrayList<>();

    public ExchangeRate() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRate(ArrayList<Rate> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "calculator.domain.ExchangeRate [code=" + code + ", rate=" + rates + "]";
    }


}
