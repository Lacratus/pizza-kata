package be.pizza.kata.controller.mapper;

import be.pizza.kata.controller.dto.request.PizzaOrderRequest;
import be.pizza.kata.controller.dto.response.PizzaOrderResponse;
import be.pizza.kata.domain.PizzaOrder;

public class PizzaOrderMapper {

    public static PizzaOrder toEntity(PizzaOrderRequest request) {
        PizzaOrder order = new PizzaOrder();
        order.setPizza(request.pizza());
        order.setSize(request.size());
        return order;
    }

    public static PizzaOrderResponse toResponse(PizzaOrder order) {
        return new PizzaOrderResponse(order.getId(), order.getPizza(), order.getSize());
    }
}
