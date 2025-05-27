package be.pizza.kata.core.controller.dto.request;

import be.pizza.kata.core.domain.enums.PizzaSize;
import be.pizza.kata.core.domain.enums.PizzaTopping;
import be.pizza.kata.core.domain.enums.PizzaType;

import java.util.List;

public record PizzaOrderRequest(PizzaType pizzaType, PizzaSize size, List<PizzaTopping> pizzaToppings) {
}
