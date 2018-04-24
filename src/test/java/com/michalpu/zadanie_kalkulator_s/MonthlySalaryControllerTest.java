package com.michalpu.zadanie_kalkulator_s;

import org.junit.Assert;
import org.junit.Test;

public class MonthlySalaryControllerTest extends ZadanieKalkulatorSApplicationTests {


    @Test
   public void shouldCalculateMonthlyNetSalaryForPLCountryCodeWhenNoParamsGiven() {
        //when
        SalaryCalculation forObject = restTemplate.getForObject(localUrl("/calculation "), SalaryCalculation.class);

        //then
        Assert.assertEquals(forObject.getCountryCode(), Country.PL.name());
        Assert.assertEquals(forObject.getGrossDailyWageCurrency(), 100d, 0.0d);
        Assert.assertEquals(forObject.getNetMonthlySalaryPLN(), 2010d, 0.0d);

    }

    @Test
    public void shouldCalculateMonthlySalaryForDECountryCode(){
        //given
        stubNBPClient(200, "EUR", 4.198d);

        //when
        SalaryCalculation forObject = restTemplate.getForObject(localUrl("/calculation?countryCode=DE&grossDailyWage=200")
                ,SalaryCalculation.class);

        //then
        Assert.assertEquals(forObject.getCountryCode(), Country.DE.name());
        Assert.assertEquals(forObject.getGrossDailyWageCurrency(), 200d, 0.0d);
        Assert.assertEquals(forObject.getNetMonthlySalaryPLN(), 15448.64d, 0.0d);

    }


}