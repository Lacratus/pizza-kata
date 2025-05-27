package be.pizza.kata.core.service;

import be.pizza.kata.core.domain.PizzaOrder;
import be.pizza.kata.core.repository.PizzaOrderRepository;
import be.pizza.kata.infrastructure.factory.PizzaOrderMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static be.pizza.kata.core.domain.enums.PizzaSize.LARGE;
import static be.pizza.kata.core.domain.enums.PizzaType.MARGHERITA;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PizzaOrderServiceTest {

    private PizzaOrderRepository pizzaOrderRepository;
    private PizzaOrderService pizzaOrderService;

    @BeforeEach
    void beforeAll() {
        pizzaOrderRepository = mock(PizzaOrderRepository.class); // Assuming a mock or in-memory repository
        pizzaOrderService = new PizzaOrderService(pizzaOrderRepository);
    }

    @Test
    void createOrder_SavePizzaOrderAndReturn() {
        PizzaOrder pizzaOrder = PizzaOrderMother.pizzaOrder().build();
        PizzaOrder savedPizzaOrder = PizzaOrderMother.pizzaOrder().id(UUID.randomUUID()).build();

        when(pizzaOrderRepository.save(pizzaOrder)).thenReturn(savedPizzaOrder);

        PizzaOrder result = pizzaOrderService.createOrder(pizzaOrder);

        assertNotNull(result);
        assertEquals(MARGHERITA, result.getPizzaType());
        assertEquals(LARGE, result.getSize());
    }
}
