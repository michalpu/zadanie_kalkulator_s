package com.michalpu.zadanie_kalkulator_s;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Rate {

    private String no;
    private double mid;

    public Rate() {
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public double getMid() {
        return mid;
    }

    public void setMid(double mid) {
        this.mid = mid;
    }

    @Override
    public String toString() {
        return "calculator.domain.Rate [no=" + no + ", mid=" + mid + "]";
    }






}
