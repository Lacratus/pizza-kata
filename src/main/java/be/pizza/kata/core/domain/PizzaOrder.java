
package be.pizza.kata.core.domain;

import be.pizza.kata.infrastructure.constants.PizzaSize;
import be.pizza.kata.infrastructure.constants.PizzaType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class PizzaOrder {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "pizza_type", nullable = false)
    @NotNull(message = "Pizza type must not be null")
    private PizzaType pizzaType;

    @Column(name = "size", nullable = false)
    @NotNull(message = "Pizza size must not be null")
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
