package be.pizza.kata.core.service;

import be.pizza.kata.core.domain.PizzaOrder;
import be.pizza.kata.core.repository.PizzaOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PizzaOrderService {

    private final PizzaOrderRepository repository;

    public PizzaOrderService(PizzaOrderRepository repository) {
        this.repository = repository;
    }

    public PizzaOrder createOrder(PizzaOrder order) {
        log.info("Ordering pizza: {}, size: {}", order.getPizzaType(), order.getSize());
        return repository.save(order);
    }
}
