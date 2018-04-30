package com.michalpu.zadanie_kalkulator_s;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class NBPCurrencyClient implements CurrencyClient {
    private RestTemplate restTemplate;
    private final String nbpApiUrl;


    public NBPCurrencyClient(RestTemplate nbRestTemplate,
                             @Value("${nbp.client.host}") String nbpHostUrl,
                             @Value("${nbp.client.getRate.uri}") String nbpGetRateUri) {
        this.restTemplate = nbRestTemplate;
        this.nbpApiUrl = nbpHostUrl + nbpGetRateUri;
    }


    @Override
    public double getRate(Country country) {
        String currencyCode = country.getCurrencyCode();
        if (currencyCode.equals("PLN")) {
            return 1;
        }
        String nbpRequestUrl = nbpApiUrl + currencyCode;
        ExchangeRate exchangeRate = restTemplate.getForObject(nbpRequestUrl, ExchangeRate.class);
        double rate = exchangeRate.getRates().get(0).getMid();
        return rate;
    }
}
