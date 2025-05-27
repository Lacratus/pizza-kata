package be.pizza.kata.core.controller;

import be.pizza.kata.core.controller.dto.request.PizzaOrderRequest;
import be.pizza.kata.core.controller.dto.response.PizzaOrderResponse;
import be.pizza.kata.core.controller.mapper.PizzaOrderMapper;
import be.pizza.kata.core.service.PizzaOrderService;
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
    public Map<String, String> order(@RequestBody PizzaOrderRequest order) {
        PizzaOrderResponse responseObject = PizzaOrderMapper.toResponse(pizzaOrderService.createOrder(PizzaOrderMapper.toEntity(order)));

        String estimatedTime = "20 minutes";

        Map<String, String> response = new HashMap<>();
        response.put("orderId", responseObject.orderId().toString());
        response.put("estimatedTime", estimatedTime);
        return response;
    }
}
