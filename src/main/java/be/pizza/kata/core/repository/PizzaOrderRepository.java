
package be.pizza.kata.core.repository;

import be.pizza.kata.core.domain.PizzaOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PizzaOrderRepository extends JpaRepository<PizzaOrder, UUID> {
}
