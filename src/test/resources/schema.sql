CREATE TABLE IF NOT EXISTS pizza_order (
    id UUID PRIMARY KEY,
    pizza_type VARCHAR(255),
    size VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS pizza_order_toppings (
    order_id UUID REFERENCES pizza_order(id),
    topping VARCHAR(255)
    );
