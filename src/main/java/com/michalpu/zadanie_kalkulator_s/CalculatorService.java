package com.michalpu.zadanie_kalkulator_s;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public SalaryCalculation calculateMonthlySalary(double grossDailyWage, Country country, double exRate) {
        double cost = country.getLivingCost();
        double taxRate = country.getTaxRate();
        double grossMonthlySalary = grossDailyWage * 22;
        double tax = (grossMonthlySalary - cost) * taxRate;
        double netMonthlySalary = grossMonthlySalary - tax;
        double netMonthlySalaryPLN = netMonthlySalary * exRate;
        netMonthlySalaryPLN = Math.round(netMonthlySalaryPLN*100.0)/100.0;

        return new SalaryCalculation(country.name(), grossDailyWage, netMonthlySalaryPLN);

    }
}


