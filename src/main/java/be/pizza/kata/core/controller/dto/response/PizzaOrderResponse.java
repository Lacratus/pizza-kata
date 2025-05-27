package be.pizza.kata.core.controller.dto.response;

import be.pizza.kata.infrastructure.constants.PizzaSize;

import java.util.UUID;

public record PizzaOrderResponse(UUID orderId, String pizzaName, PizzaSize size) {
}
