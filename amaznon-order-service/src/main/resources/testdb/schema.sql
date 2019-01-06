DROP TABLE user_product_order IF EXISTS;

CREATE TABLE user_product_order (
    orderId VARCHAR(255) NOT NULL, 
    productCode  VARCHAR(255),
    userId  VARCHAR(255),
    quantity INTEGER,
    unitPrice DECIMAL(7,2)
);
