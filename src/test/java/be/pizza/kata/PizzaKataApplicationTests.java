package be.pizza.kata;

import be.pizza.kata.infrastructure.PizzaTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@PizzaTest
class PizzaKataApplicationTests {

    @Test
    void contextLoads() {
    }

}
