-- Database: TB

-- DROP DATABASE IF EXISTS "TB";

DROP TABLE IF EXISTS Client CASCADE;	
CREATE TABLE Client(
	id  BIGSERIAL,
	"name" VARCHAR(50) NOT NULL UNIQUE,
	addressName VARCHAR(50) NOT NULL,
	addressNumber INTEGER NOT NULL,
	zipCode INTEGER NOT NULL,
	city VARCHAR(50) NOT NULL,
	
	CONSTRAINT PK_Client PRIMARY KEY (id)
);

DROP TYPE IF EXISTS roleUtilisateur CASCADE;
CREATE TYPE roleUtilisateur AS ENUM('ADMIN', 'EMPLOYE');
DROP TABLE IF EXISTS "user" CASCADE;
CREATE TABLE "user"(
	id BIGSERIAL,
	email VARCHAR(50) NOT NULL,
	password VARCHAR(50) NOT NULL,
	name VARCHAR(50) NOT NULL,
	uuid VARCHAR(50) NOT NULL,
	currentRole roleUtilisateur NOT NULL,
	
	CONSTRAINT PK_User PRIMARY KEY (id)
);

DROP TABLE IF EXISTS Delivery CASCADE;
CREATE TABLE Delivery(
	id BIGSERIAL,
	idClient BIGSERIAL,
	idUser BIGSERIAL,
	deliveryDate DATE NOT NULL,
	details VARCHAR(50),
	
	CONSTRAINT PK_Delivery PRIMARY KEY (id)
	
);


DROP TYPE IF EXISTS typePlat CASCADE;
CREATE TYPE typePlat AS ENUM('MEAT', 'VEGETARIAN', 'VEGAN');
DROP TYPE IF EXISTS taille CASCADE;
CREATE TYPE taille AS ENUM('FIT', 'GAIN');
DROP TABLE IF EXISTS Dish CASCADE;
CREATE TABLE Dish(
	id BIGSERIAL,
	name VARCHAR(50) NOT NULL,
	description VARCHAR(100),
	currentType typePlat NOT NULL,
	currentSize taille NOT NULL,
	price NUMERIC(10, 2) NOT NULL,
	isAvailable BOOLEAN NOT NULL,
	calories INTEGER NOT NULL,
	fats NUMERIC(10, 2),
	saturatedFats NUMERIC(10, 2),
	sodium NUMERIC(10, 2),
	carbohydrates NUMERIC(10, 2),
	fibers NUMERIC(10, 2),
	sugars NUMERIC(10, 2),
	proteins NUMERIC(10, 2),
	calcium NUMERIC(10, 2),
	iron NUMERIC(10, 2),
	potassium NUMERIC(10, 2),
	
	CONSTRAINT PK_Dish PRIMARY KEY (id)
);

DROP TABLE IF EXISTS Delivery_Dish CASCADE;
CREATE TABLE Delivery_Dish(
	idDelivery BIGSERIAL,
	idDish BIGSERIAL,
	quantityRemained INTEGER NOT NULL,
	quantityDelivered INTEGER NOT NULL,
	
	CONSTRAINT PK_Delivery_Dish PRIMARY KEY (idDelivery,idDish)
);

DROP TYPE IF EXISTS typeIngredient CASCADE;
CREATE TYPE typeIngredient AS ENUM ('MEAT', 'FISH', 'STARCH', 'VEGETABLE', 'FRUIT', 'GRAIN', 'SPICE', 'SAUCE', 'OTHER');
DROP TABLE IF EXISTS Ingredient CASCADE;
CREATE TABLE Ingredient(
	id BIGSERIAL,
	name VARCHAR(50) NOT NULL,
	currentType typeIngredient NOT NULL,
	description VARCHAR(255),
	supplier VARCHAR(50),
	
	CONSTRAINT PK_Ingredient PRIMARY KEY (id)
	
);



DROP TABLE IF EXISTS Dish_Ingredient CASCADE;
CREATE TABLE Dish_Ingredient(
	idDish BIGSERIAL,
	idIngredient BIGSERIAL,
	weight NUMERIC(10, 2),
	
	CONSTRAINT PK_Dish_Ingredient PRIMARY KEY (IdDish, idIngredient)
);


ALTER TABLE Delivery ADD CONSTRAINT FK_Delivery_idClient FOREIGN KEY(idClient) REFERENCES Client(id)
	ON UPDATE CASCADE;
ALTER TABLE Delivery ADD CONSTRAINT FK_Delivery_idUser FOREIGN KEY(idUser) REFERENCES "user"(id)
	ON UPDATE CASCADE;
ALTER TABLE Delivery_Dish ADD CONSTRAINT FK_Delivery_idDelivery FOREIGN KEY(idDelivery) REFERENCES Delivery(id)
	ON UPDATE CASCADE;
ALTER TABLE	Delivery_Dish ADD CONSTRAINT FK_Delivery_idDish FOREIGN KEY(idDish) REFERENCES Dish(id)
	ON UPDATE CASCADE;
ALTER TABLE Dish_Ingredient ADD CONSTRAINT FK_Dish_Ingredient_idDish FOREIGN KEY(idDish) REFERENCES Dish(id)
	ON UPDATE CASCADE;
ALTER TABLE Dish_Ingredient ADD CONSTRAINT FK_Dish_Ingredient_idIngredient FOREIGN KEY(idIngredient) REFERENCES Ingredient(id)










