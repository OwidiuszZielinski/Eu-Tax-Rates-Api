package com.example.eutaxratesapi.app;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RateControllerTest {



    @LocalServerPort
    private int port;


    @Test
    public void testGetRatesHttpCode() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/rates", String.class);
        System.out.println(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }
    @Test
    public void testHttpStatusCode404WithRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        try {
            restTemplate.getForEntity("http://localhost:" + port + "/non-existent-endpoint", String.class);
        } catch (HttpClientErrorException ex) {
            assertEquals(HttpStatus.NOT_FOUND, ex.getStatusCode());
        }
    }


    @Test
   public void getEuRateForCountryShortName() {
    }
}