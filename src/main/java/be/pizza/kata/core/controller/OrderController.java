package be.pizza.kata.core.controller;

import be.pizza.kata.core.controller.dto.request.PizzaOrderRequest;
import be.pizza.kata.core.controller.dto.response.PizzaOrderResponse;
import be.pizza.kata.core.controller.mapper.PizzaOrderMapper;
import be.pizza.kata.core.service.PizzaOrderService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OrderController {

    private final PizzaOrderService pizzaOrderService;

    public OrderController(PizzaOrderService pizzaOrderService) {
        this.pizzaOrderService = pizzaOrderService;
    }

    @PostMapping("/order")
    public PizzaOrderResponse order(@RequestBody @Valid PizzaOrderRequest order) {
        return PizzaOrderMapper.toResponse(pizzaOrderService.createOrder(PizzaOrderMapper.toEntity(order)));
    }
}
