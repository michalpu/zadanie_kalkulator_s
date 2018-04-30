package com.michalpu.zadanie_kalkulator_s;

public class SalaryCalculation {
    private String countryCode;
    private double grossDailyWageCurrency;
    private double netMonthlySalaryPLN;

    public SalaryCalculation() {
    }

    public SalaryCalculation(String countryCode, double grossDailyWAgeCurrency, double netMonthlySalaryPLN) {
        this.countryCode = countryCode;
        this.grossDailyWageCurrency = grossDailyWAgeCurrency;
        this.netMonthlySalaryPLN = netMonthlySalaryPLN;
    }

    @Override
    public String toString() {
        return "calculator.domain.CalculationResult [countryCode=" + countryCode + ", grossDailyWAgeCurrency=" + grossDailyWageCurrency
                + ", netMonthlySalaryPLN=" + netMonthlySalaryPLN + "]";
    }

    public String getCountryCode() {
        return countryCode;
    }

    public double getGrossDailyWageCurrency() {
        return grossDailyWageCurrency;
    }

    public double getNetMonthlySalaryPLN() {
        return netMonthlySalaryPLN;
    }


}
