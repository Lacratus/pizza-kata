package be.pizza.kata;

import be.pizza.kata.core.domain.PizzaOrder;
import be.pizza.kata.infrastructure.PizzaTest;
import be.pizza.kata.core.repository.PizzaOrderRepository;
import be.pizza.kata.infrastructure.constants.PizzaSize;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@PizzaTest
public class OrderControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PizzaOrderRepository repository;

    @Test
    @Order(1)
    void order_shouldReturnOrderIdAndEstimatedTime() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        PizzaOrder order = new PizzaOrder();
        order.setPizzaName("MARGHERITA");
        order.setSize(PizzaSize.MEDIUM);

        HttpEntity<PizzaOrder> entity = new HttpEntity<>(order, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity("/order", entity, Map.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).containsKeys("orderId", "estimatedTime");
        assertThat(response.getBody().get("estimatedTime")).isEqualTo("20 minutes");
        assertThat(response.getBody().get("orderId")).isNotNull();
    }

    @Test
    @Order(2)
    void order_shouldBePersistedInDatabase() {
        long countBefore = repository.count();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        PizzaOrder order = new PizzaOrder();
        order.setPizzaName("PEPPERONI");
        order.setSize(PizzaSize.LARGE);

        HttpEntity<PizzaOrder> entity = new HttpEntity<>(order, headers);

        restTemplate.postForEntity("/order", entity, Map.class);

        long countAfter = repository.count();
        assertThat(countAfter).isEqualTo(countBefore + 1);
    }
}
