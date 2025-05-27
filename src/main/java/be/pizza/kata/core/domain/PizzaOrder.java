
package be.pizza.kata.core.domain;

import be.pizza.kata.infrastructure.constants.PizzaSize;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
public class PizzaOrder {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "pizza", nullable = false)
    private String pizzaName;

    @Column(name = "size", nullable = false)
    private PizzaSize size;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PizzaOrder other)) return false;
        if (this.id == null || other.id == null) {
            return false;
        }
        return this.id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return (id != null ? id.hashCode() : 0);
    }
}
