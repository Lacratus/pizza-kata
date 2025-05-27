package be.pizza.kata.core.controller.dto.request;

import be.pizza.kata.infrastructure.constants.PizzaSize;

public record PizzaOrderRequest(String pizzaName, PizzaSize size) {
}
