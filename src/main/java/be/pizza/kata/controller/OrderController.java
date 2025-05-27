package be.pizza.kata.controller;

import be.pizza.kata.controller.dto.request.PizzaOrderRequest;
import be.pizza.kata.controller.dto.response.PizzaOrderResponse;
import be.pizza.kata.controller.mapper.PizzaOrderMapper;
import be.pizza.kata.domain.PizzaOrder;
import be.pizza.kata.service.PizzaOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OrderController {

    private final PizzaOrderService pizzaOrderService;

    @Autowired
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
