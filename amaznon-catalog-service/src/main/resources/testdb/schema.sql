DROP TABLE catalog IF EXISTS;
CREATE TABLE catalog (catalogId VARCHAR(255) primary key, 
	catalogName VARCHAR(255),
	catalogDesc VARCHAR(255)
);

DROP TABLE product IF EXISTS;
CREATE TABLE product (catalogId VARCHAR(255) NOT NULL, 
    productCode  VARCHAR(255),
    productDesc  VARCHAR(255),
    productColor VARCHAR(255),
    name         VARCHAR(30) ,
    unitsInStock VARCHAR(30) ,
    price        DECIMAL(7,2),
    supplierId   VARCHAR(255)
);