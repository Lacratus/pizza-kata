package be.pizza.kata.infrastructure.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum PizzaType {

    MARGHERITA,
    PEPERONI,
    VIER_KAZEN,
    DIABOLIQUE;

    @JsonCreator
    public static PizzaType from(String value) {
        return PizzaType.valueOf(value.toUpperCase());
    }
}
