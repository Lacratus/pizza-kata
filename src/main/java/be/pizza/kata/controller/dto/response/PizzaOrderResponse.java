package be.pizza.kata.controller.dto.response;

import java.util.UUID;

public record PizzaOrderResponse(UUID orderId, String pizza, String size) {
}
