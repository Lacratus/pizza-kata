package be.pizza.kata.core.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum PizzaTopping {

    EXTRA_CHEESE,
    EXTRA_PEPPERONI,
    OLIVES,
    MUSHROOMS,
    BBQ_SWIRL;

    @JsonCreator
    public static PizzaTopping from(String value) {
        return PizzaTopping.valueOf(value.toUpperCase());
    }
}
