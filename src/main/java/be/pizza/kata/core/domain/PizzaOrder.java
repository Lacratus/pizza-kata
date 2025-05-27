
package be.pizza.kata.core.domain;

import be.pizza.kata.core.domain.enums.PizzaSize;
import be.pizza.kata.core.domain.enums.PizzaTopping;
import be.pizza.kata.core.domain.enums.PizzaType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class PizzaOrder {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @NotNull(message = "Pizza type must not be null")
    @Column(name = "pizza_type", nullable = false)
    private PizzaType pizzaType;

    @NotNull(message = "Pizza size must not be null")
    @Column(name = "size", nullable = false)
    private PizzaSize size;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "pizza_order_toppings",
            joinColumns = @JoinColumn(name = "order_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "topping")
    private List<PizzaTopping> toppings;

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
