package com.michalpu.zadanie_kalkulator_s;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class NBPCurrencyClient implements CurrencyClient {
    private RestTemplate restTemplate = new RestTemplate();
    private final String nbpApiUrl;

    public NBPCurrencyClient(final Environment environment) {
        this.nbpApiUrl = environment.getProperty("nbp.client.host") + environment.getProperty("nbp.clien.getRate.uri");

    }


    @Override
    public double getRate(Country country){
        String currencyCode = country.getCurrencyCode();
        if(currencyCode.equals("PLN")){
            return 1;
        }
        String nbpRequestUrl = nbpApiUrl + currencyCode;
        ExchangeRate exchangeRate = restTemplate.getForObject(nbpRequestUrl, ExchangeRate.class);
        double rate = exchangeRate.getRates().get(0).getMid();
        return rate;
    }
}
