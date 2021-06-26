package com.example.amaris.controller;

import com.example.amaris.application.Application;
import com.example.amaris.model.PricesResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = {PricesController.class, Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PricesControllerTest{

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();


    @Test
    public void test_1(){

        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<PricesResponse> response = restTemplate.exchange(
                createURLWithPort("/price/1/35455/2020-06-14-10.00.00"),
                HttpMethod.GET, entity, PricesResponse.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().getBrandId());
        assertEquals(35455, response.getBody().getProductId());
        assertEquals(1, response.getBody().getPriceList());
        assertEquals(35.50, response.getBody().getPrice());
        assertEquals(Timestamp.valueOf("2020-06-14 00:00:00"), response.getBody().getStartDate());
        assertEquals(Timestamp.valueOf("2020-12-31 23:59:59"), response.getBody().getEndDate());

    }

    @Test
    public void test_2(){

        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<PricesResponse> response = restTemplate.exchange(
                createURLWithPort("/price/1/35455/2020-06-14-16.00.00"),
                HttpMethod.GET, entity, PricesResponse.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().getBrandId());
        assertEquals(35455, response.getBody().getProductId());
        assertEquals(2, response.getBody().getPriceList());
        assertEquals(25.45, response.getBody().getPrice());
        assertEquals(Timestamp.valueOf("2020-06-14 15:00:00"), response.getBody().getStartDate());
        assertEquals(Timestamp.valueOf("2020-06-14 18:30:00"), response.getBody().getEndDate());

    }

    @Test
    public void test_3(){

        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<PricesResponse> response = restTemplate.exchange(
                createURLWithPort("/price/1/35455/2020-06-14-21.00.00"),
                HttpMethod.GET, entity, PricesResponse.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().getBrandId());
        assertEquals(35455, response.getBody().getProductId());
        assertEquals(1, response.getBody().getPriceList());
        assertEquals(35.50, response.getBody().getPrice());
        assertEquals(Timestamp.valueOf("2020-06-14 00:00:00"), response.getBody().getStartDate());
        assertEquals(Timestamp.valueOf("2020-12-31 23:59:59"), response.getBody().getEndDate());

    }

    @Test
    public void test_4(){

        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<PricesResponse> response = restTemplate.exchange(
                createURLWithPort("/price/1/35455/2020-06-15-10.00.00"),
                HttpMethod.GET, entity, PricesResponse.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().getBrandId());
        assertEquals(35455, response.getBody().getProductId());
        assertEquals(3, response.getBody().getPriceList());
        assertEquals(30.50, response.getBody().getPrice());
        assertEquals(Timestamp.valueOf("2020-06-15 00:00:00"), response.getBody().getStartDate());
        assertEquals(Timestamp.valueOf("2020-06-15 11:00:00"), response.getBody().getEndDate());

    }

    @Test
    public void test_5(){

        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<PricesResponse> response = restTemplate.exchange(
                createURLWithPort("/price/1/35455/2020-06-16-21.00.00"),
                HttpMethod.GET, entity, PricesResponse.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().getBrandId());
        assertEquals(35455, response.getBody().getProductId());
        assertEquals(4, response.getBody().getPriceList());
        assertEquals(38.95, response.getBody().getPrice());
        assertEquals(Timestamp.valueOf("2020-06-15 16:00:00"), response.getBody().getStartDate());
        assertEquals(Timestamp.valueOf("2020-12-31 23:59:59"), response.getBody().getEndDate());

    }


    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}