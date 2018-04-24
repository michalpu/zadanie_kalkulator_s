package com.michalpu.zadanie_kalkulator_s;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorServiceTest {

    @Test
    public void calculateMonthlySalary() {
        //when
        CalculatorService calculatorService = new CalculatorService();
        double grossDailyWage = 100d;
        Country country = Country.PL;
        double exRate = 1d;
        SalaryCalculation salaryCalculation = calculatorService.calculateMonthlySalary(grossDailyWage, country, exRate);

        //then
        assertEquals(salaryCalculation.getGrossDailyWageCurrency(), 100d, 0.0d);
        assertEquals(salaryCalculation.getNetMonthlySalaryPLN(), 2010d, 0.0d);

    }
}