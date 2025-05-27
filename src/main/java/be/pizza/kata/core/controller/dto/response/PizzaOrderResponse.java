package be.pizza.kata.core.controller.dto.response;

import be.pizza.kata.infrastructure.constants.PizzaSize;
import be.pizza.kata.infrastructure.constants.PizzaType;

import java.util.UUID;

public record PizzaOrderResponse(UUID orderId, PizzaType pizzaType, PizzaSize size, int estimatedTime) {

    public PizzaOrderResponse(UUID orderId, PizzaType pizzaType, PizzaSize size) {
        this(orderId, pizzaType, size, size.getEstimatedMinutes());
    }
}
