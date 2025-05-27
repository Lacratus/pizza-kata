package be.pizza.kata.core.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum PizzaType {

    MARGHERITA,
    PEPPERONI,
    VIER_KAZEN,
    DIABOLIQUE;

    @JsonCreator
    public static PizzaType from(String value) {
        return PizzaType.valueOf(value.toUpperCase());
    }
}
