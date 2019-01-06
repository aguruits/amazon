DROP TABLE user IF EXISTS;
CREATE TABLE user (
	userId VARCHAR(255)  NOT NULL, 
	loginId VARCHAR(100),
	userName VARCHAR(250),
	password VARCHAR(255),
	userType VARCHAR(1),
    	address  VARCHAR(255),
    	contactNumber VARCHAR(10),
    	email VARCHAR(55)
);