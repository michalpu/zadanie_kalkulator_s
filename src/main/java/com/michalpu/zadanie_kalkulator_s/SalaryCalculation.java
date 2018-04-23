package com.michalpu.zadanie_kalkulator_s;

public class SalaryCalculation {
    private final String countryCode;
    private final double grossDailyWageCurrency;
    private final double netMonthlyWagePLN;

    public SalaryCalculation(String countryCode, double grossDailyWAgeCurrency, double netMonthlyWagePLN) {
        this.countryCode = countryCode;
        this.grossDailyWageCurrency = grossDailyWAgeCurrency;
        this.netMonthlyWagePLN = netMonthlyWagePLN;
    }

    @Override
    public String toString() {
        return "calculator.domain.CalculationResult [countryCode=" + countryCode + ", grossDailyWAgeCurrency=" + grossDailyWageCurrency
                + ", netMonthlyWagePLN=" + netMonthlyWagePLN + "]";
    }

    public String getCountryCode() {
        return countryCode;
    }

    public double getGrossDailyWageCurrency() {
        return grossDailyWageCurrency;
    }

    public double getNetMonthlyWagePLN() {
        return netMonthlyWagePLN;
    }


}
