package be.pizza.kata.core.controller.dto.response;

import be.pizza.kata.core.domain.enums.PizzaSize;
import be.pizza.kata.core.domain.enums.PizzaTopping;
import be.pizza.kata.core.domain.enums.PizzaType;

import java.util.List;
import java.util.UUID;

import static be.pizza.kata.infrastructure.constants.PizzaKataConstants.EXTRA_TIME_PER_TOPPING;

public record PizzaOrderResponse(UUID orderId, PizzaType pizzaType, PizzaSize size, List<PizzaTopping> pizzaToppings, int estimatedTime) {

    public PizzaOrderResponse(UUID orderId, PizzaType pizzaType, PizzaSize size, List<PizzaTopping> pizzaToppings) {
        this(orderId, pizzaType, size, pizzaToppings, size.getEstimatedMinutes() + ((pizzaToppings != null ? pizzaToppings.size() : 0) * EXTRA_TIME_PER_TOPPING));
    }
}
