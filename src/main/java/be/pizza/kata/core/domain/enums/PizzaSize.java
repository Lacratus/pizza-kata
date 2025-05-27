package be.pizza.kata.core.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum PizzaSize {

    SMALL(15),
    MEDIUM(20),
    LARGE(25);

    private final  int estimatedMinutes;

    PizzaSize(int estimatedMinutes) {
        this.estimatedMinutes = estimatedMinutes;
    }

    @JsonCreator
    public static PizzaSize from(String value) {
        return PizzaSize.valueOf(value.toUpperCase());
    }
}
