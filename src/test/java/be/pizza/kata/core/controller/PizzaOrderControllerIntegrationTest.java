package be.pizza.kata.core.controller;

import be.pizza.kata.core.controller.dto.request.PizzaOrderRequest;
import be.pizza.kata.core.controller.dto.response.PizzaOrderResponse;
import be.pizza.kata.infrastructure.PizzaTest;
import be.pizza.kata.core.repository.PizzaOrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static be.pizza.kata.infrastructure.constants.PizzaSize.LARGE;
import static be.pizza.kata.infrastructure.constants.PizzaSize.MEDIUM;
import static be.pizza.kata.infrastructure.constants.PizzaType.*;
import static org.junit.jupiter.api.Assertions.*;

@PizzaTest
public class PizzaOrderControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PizzaOrderRepository repository;

    @Test
    void order_shouldReturnOrderIdAndEstimatedTime() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        PizzaOrderRequest order = new PizzaOrderRequest(MARGHERITA, MEDIUM);

        HttpEntity<PizzaOrderRequest> entity = new HttpEntity<>(order, headers);

        ResponseEntity<PizzaOrderResponse> response = restTemplate.postForEntity("/order", entity, PizzaOrderResponse.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(MEDIUM.getEstimatedMinutes(), response.getBody().estimatedTime());
        assertNotNull(response.getBody().orderId());

    }

    @Test
    void order_shouldBePersistedInDatabase() {
        long countBefore = repository.count();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        PizzaOrderRequest order = new PizzaOrderRequest(PEPERONI, LARGE);

        HttpEntity<PizzaOrderRequest> entity = new HttpEntity<>(order, headers);

        restTemplate.postForEntity("/order", entity, PizzaOrderResponse.class);

        long countAfter = repository.count();
        assertEquals(countBefore + 1, countAfter);
    }

    @Test
    void order_pizzaNameIsEmpty_ThrowError() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        PizzaOrderRequest order = new PizzaOrderRequest(null, LARGE);

        HttpEntity<PizzaOrderRequest> entity = new HttpEntity<>(order, headers);

        ResponseEntity<String> response = restTemplate.postForEntity("/order", entity, String.class);

        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().contains("Pizza type must not be null"));
    }

    @Test
    void order_pizzaSizeIsNull_ThrowError() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        PizzaOrderRequest order = new PizzaOrderRequest(DIABOLIQUE, null);

        HttpEntity<PizzaOrderRequest> entity = new HttpEntity<>(order, headers);

        ResponseEntity<String> response = restTemplate.postForEntity("/order", entity, String.class);

        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().contains("Pizza size must not be null"));
    }
}
