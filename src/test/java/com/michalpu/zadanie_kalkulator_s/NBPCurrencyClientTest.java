package com.michalpu.zadanie_kalkulator_s;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class NBPCurrencyClientTest extends ZadanieKalkulatorSApplicationTests {

    @Autowired
    CurrencyClient currencyClient;

    @Test
    public void shouldReturnCurrencyRateForSpecifiedCurrencyCode() {
        //given
        stubNBPClient(200, "EUR", 4.198d);

        //when
        double rate = currencyClient.getRate(Country.DE);

        //then
        assertEquals(rate, 4.198d, 0.0d);
    }

}