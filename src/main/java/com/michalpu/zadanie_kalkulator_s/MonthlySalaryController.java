package com.michalpu.zadanie_kalkulator_s;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonthlySalaryController {
    private final CalculatorService calculatorService;
    private final CurrencyClient currencyClient;

    public MonthlySalaryController(CalculatorService calculatorService, CurrencyClient currencyClient) {
        this.calculatorService = calculatorService;
        this.currencyClient = currencyClient;
    }
    @GetMapping("/calculation")
    public SalaryCalculation getSalaryCalculation (
            @RequestParam(value = "grossDailyWageCurrency", required = false, defaultValue = "100") double grossDailyWage,
            @RequestParam(value = "countryCode", required = false, defaultValue = "PL") String countryCode) {

        final Country country = Country.valueOf(countryCode.toUpperCase());

        double exRate = currencyClient.getRate(country);

        return calculatorService.calculateMonthlySalary(grossDailyWage, country, exRate);
    }
}
