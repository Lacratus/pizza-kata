package be.pizza.kata.infrastructure.factory;

import be.pizza.kata.core.domain.PizzaOrder;
import be.pizza.kata.infrastructure.constants.PizzaSize;
import be.pizza.kata.infrastructure.constants.PizzaType;

import java.util.UUID;

import static be.pizza.kata.infrastructure.constants.PizzaSize.LARGE;
import static be.pizza.kata.infrastructure.constants.PizzaType.MARGHERITA;

public class PizzaOrderMother {

    private PizzaOrderMother() {
    }

    public static Builder pizzaOrder() {
        return new Builder();
    }

    public static final class Builder {
        private UUID id;

        private PizzaType pizzaType = MARGHERITA;

        private PizzaSize pizzaSize = LARGE;

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder pizzaType(PizzaType pizzaType) {
            this.pizzaType = pizzaType;
            return this;
        }

        public Builder pizzaSize(PizzaSize pizzaSize) {
            this.pizzaSize = pizzaSize;
            return this;
        }

        public PizzaOrder build() {
            PizzaOrder pizzaOrder = new PizzaOrder();
            pizzaOrder.setId(id);
            pizzaOrder.setPizzaType(pizzaType);
            pizzaOrder.setSize(pizzaSize);
            return pizzaOrder;
        }


    }
}
