package be.pizza.kata.core.controller.dto.request;

import be.pizza.kata.infrastructure.constants.PizzaSize;
import be.pizza.kata.infrastructure.constants.PizzaType;

public record PizzaOrderRequest(PizzaType pizzaType, PizzaSize size) {
}
