package be.pizza.kata.core.mapper;

import be.pizza.kata.core.controller.dto.request.PizzaOrderRequest;
import be.pizza.kata.core.controller.dto.response.PizzaOrderResponse;
import be.pizza.kata.core.domain.PizzaOrder;
import org.springframework.stereotype.Component;

@Component
public class PizzaOrderMapper {

    public PizzaOrder toEntity(PizzaOrderRequest request) {
        PizzaOrder order = new PizzaOrder();
        order.setPizzaType(request.pizzaType());
        order.setSize(request.size());
        order.setToppings(request.pizzaToppings());
        return order;
    }

    public PizzaOrderResponse toResponse(PizzaOrder order) {
        return new PizzaOrderResponse(order.getId(), order.getPizzaType(), order.getSize(), order.getToppings());
    }
}
