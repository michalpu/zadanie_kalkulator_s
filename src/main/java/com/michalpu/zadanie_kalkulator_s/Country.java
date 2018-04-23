package com.michalpu.zadanie_kalkulator_s;

public enum Country {
    PL("PLN", 0.19, 1200d),
    DE("EUR", 0.20, 800d),
    UK("GBP", 0.25, 600d);

    private final String currencyCode;
    private final double taxRate;
    private final double livingCost;

    Country(String currencyCode, double taxRate, double livingCost) {
        this.currencyCode = currencyCode;
        this.taxRate = taxRate;
        this.livingCost = livingCost;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public double getLivingCost() {
        return livingCost;
    }



    //        this.currencies = new HashMap<>();
//        this.taxRates = new HashMap<>();
//        this.costs = new HashMap<>();
//
//        this.currencies.put("PL", "PLN");
//        this.currencies.put("DE", "EUR");
//        this.currencies.put("UK", "GBP");
//
//        this.taxRates.put("PL", 0.19);
//        this.taxRates.put("UK", 0.25);
//        this.taxRates.put("DE", 0.20);
//
//        this.costs.put("PL", 1200d);
//        this.costs.put("UK", 600d);
//        this.costs.put("DE", 800d);


}
