package be.pizza.kata.core.controller.mapper;

import be.pizza.kata.core.controller.dto.request.PizzaOrderRequest;
import be.pizza.kata.core.controller.dto.response.PizzaOrderResponse;
import be.pizza.kata.core.domain.PizzaOrder;

public class PizzaOrderMapper {

    public static PizzaOrder toEntity(PizzaOrderRequest request) {
        PizzaOrder order = new PizzaOrder();
        order.setPizzaType(request.pizzaType());
        order.setSize(request.size());
        return order;
    }

    public static PizzaOrderResponse toResponse(PizzaOrder order) {
        return new PizzaOrderResponse(order.getId(), order.getPizzaType(), order.getSize());
    }
}
