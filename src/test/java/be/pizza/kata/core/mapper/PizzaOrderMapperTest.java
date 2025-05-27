package be.pizza.kata.core.mapper;

import be.pizza.kata.core.controller.dto.request.PizzaOrderRequest;
import be.pizza.kata.core.controller.dto.response.PizzaOrderResponse;
import be.pizza.kata.core.domain.PizzaOrder;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static be.pizza.kata.core.domain.enums.PizzaSize.LARGE;
import static be.pizza.kata.core.domain.enums.PizzaType.MARGHERITA;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PizzaOrderMapperTest {

    private final PizzaOrderMapper pizzaOrderMapper = new PizzaOrderMapper();

    @Test
    void toEntity_mapRequestToEntity() {
        PizzaOrderRequest request = new PizzaOrderRequest(MARGHERITA, LARGE, Collections.emptyList());

        PizzaOrder entity = pizzaOrderMapper.toEntity(request);

        assertNotNull(entity);
        assertEquals(MARGHERITA, entity.getPizzaType());
        assertEquals(LARGE, entity.getSize());
    }

    @Test
    void toResponse_mapEntityToResponse() {
        PizzaOrder entity = new PizzaOrder();
        entity.setPizzaType(MARGHERITA);
        entity.setSize(LARGE);

        PizzaOrderResponse response = pizzaOrderMapper.toResponse(entity);

        assertNotNull(response);
        assertEquals(MARGHERITA, response.pizzaType());
        assertEquals(LARGE, response.size());
    }
}
