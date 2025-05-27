package be.pizza.kata.core.controller;

import be.pizza.kata.core.controller.dto.request.PizzaOrderRequest;
import be.pizza.kata.core.controller.dto.response.PizzaOrderResponse;
import be.pizza.kata.core.mapper.PizzaOrderMapper;
import be.pizza.kata.core.service.PizzaOrderService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
public class PizzaOrderController {

    private final PizzaOrderService pizzaOrderService;
    private final PizzaOrderMapper pizzaOrderMapper;

    public PizzaOrderController(PizzaOrderService pizzaOrderService, PizzaOrderMapper pizzaOrderMapper) {
        this.pizzaOrderService = pizzaOrderService;
        this.pizzaOrderMapper = pizzaOrderMapper;
    }

    @PostMapping("/order")
    public PizzaOrderResponse order(@RequestBody @Valid PizzaOrderRequest order) {
        return pizzaOrderMapper.toResponse(pizzaOrderService.createOrder(pizzaOrderMapper.toEntity(order)));
    }
}
