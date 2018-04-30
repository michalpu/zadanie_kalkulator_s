package com.michalpu.zadanie_kalkulator_s;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

@ActiveProfiles(profiles = {"integration"})
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ZadanieKalkulatorSApplicationTests {

    RestTemplate restTemplate = new RestTemplate();


    @Rule
    public WireMockRule nbpClientRule = new WireMockRule(8089);


    public void stubNBPClient(int statusCode, String currencyCode, double exRate) {
        nbpClientRule.stubFor(get(urlEqualTo("/api/exchangerates/rates/a/" + currencyCode))
                .willReturn(aResponse()
                        .withStatus(statusCode)
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString())
                        .withBody(
                                "{\n" +
                                        "  \"table\": \"A\",\n" +
                                        "  \"currency\": \"euro\",\n" +
                                        "  \"code\": \"EUR\",\n" +
                                        "  \"rates\": [\n" +
                                        "    {\n" +
                                        "      \"no\": \"080/A/NBP/2018\",\n" +
                                        "      \"effectiveDate\": \"2018-04-24\",\n" +
                                        "      \"mid\":" + exRate + "\n" +
                                        "    }\n" +
                                        "  ]\n" +
                                        "}\n"
                        )));

    }

    @LocalServerPort
    int port;

    @Test
    public void contextLoads() {

    }

    String localUrl(String path) {
        return "http://localhost:" + port + path;
    }

}
