package be.pizza.kata.service;

import be.pizza.kata.domain.PizzaOrder;
import be.pizza.kata.repository.PizzaOrderRepository;
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
        log.info("Ordering pizza: {}, size: {}", order.getPizza(), order.getSize());
        return repository.save(order);
    }
}
