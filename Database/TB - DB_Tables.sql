-- Database: TB

-- DROP DATABASE IF EXISTS "TB";

DROP TABLE IF EXISTS Client CASCADE;	
CREATE TABLE Client(
	id  SMALLSERIAL,
	nom VARCHAR(15) NOT NULL,
	nomRue VARCHAR(50) NOT NULL,
	numRue INTEGER NOT NULL,
	codePostal INTEGER NOT NULL,
	localite VARCHAR(50) NOT NULL,
	
	CONSTRAINT PK_Client PRIMARY KEY (id)
);

DROP TYPE IF EXISTS roleUtilisateur CASCADE;
CREATE TYPE roleUtilisateur AS ENUM('admin', 'employe');
DROP TABLE IF EXISTS Utilisateur CASCADE;
CREATE TABLE Utilisateur(
	id SMALLSERIAL,
	nom VARCHAR(50) NOT NULL,
	uuid VARCHAR(50) NOT NULL,
	current_roleUtilisateur roleUtilisateur NOT NULL,
	
	CONSTRAINT PK_Utilisateur PRIMARY KEY (id)
);

DROP TABLE IF EXISTS Livraison CASCADE;
CREATE TABLE Livraison(
	id SERIAL,
	idClient SMALLSERIAL,
	idUtilisateur SMALLSERIAL,
	dateLivraison DATE NOT NULL,
	detailLivraison VARCHAR(50),
	
	CONSTRAINT PK_Livraison PRIMARY KEY (id)
	
);


DROP TYPE IF EXISTS typePlat CASCADE;
CREATE TYPE typePlat AS ENUM('av', 'sv', 'vg');
DROP TYPE IF EXISTS taille CASCADE;
CREATE TYPE taille AS ENUM('fit', 'gain');
DROP TABLE IF EXISTS Plat CASCADE;
CREATE TABLE Plat(
	id SERIAL,
	nom VARCHAR(50) NOT NULL,
	description VARCHAR(100),
	current_typePlat typePlat NOT NULL,
	current_taille taille NOT NULL,
	prixDeVente NUMERIC(10, 2) NOT NULL,
	disponibilite BOOLEAN NOT NULL,
	calorie INTEGER NOT NULL,
	graisseTotale NUMERIC(10, 2),
	grasSature NUMERIC(10, 2),
	sodium NUMERIC(10, 2),
	glucide NUMERIC(10, 2),
	fibreAlimentaire NUMERIC(10, 2),
	sucre NUMERIC(10, 2),
	proteine NUMERIC(10, 2),
	calcium NUMERIC(10, 2),
	fer NUMERIC(10, 2),
	potassium NUMERIC(10, 2),
	
	CONSTRAINT PK_Plat PRIMARY KEY (id)
);

DROP TABLE IF EXISTS Livraison_Plat CASCADE;
CREATE TABLE Livraison_Plat(
	idLivraison SERIAL,
	idPlat SERIAL,
	quantiteRestante INTEGER NOT NULL,
	quantiteLivre INTEGER NOT NULL,
	
	CONSTRAINT PK_Livraison_Plat PRIMARY KEY (idLivraison,idPlat)
);

DROP TYPE IF EXISTS typeIngredient CASCADE;
CREATE TYPE typeIngredient AS ENUM ('epice', 'viande', 'poisson', 'feculent', 'legume', 'fruit', 'autre');
DROP TABLE IF EXISTS Ingredient CASCADE;
CREATE TABLE Ingredient(
	id SERIAL,
	nom VARCHAR(50) NOT NULL,
	current_type typeIngredient NOT NULL,
	description VARCHAR(100),
	fournisseur VARCHAR(50),
	
	CONSTRAINT PK_Ingredient PRIMARY KEY (id)
	
);



DROP TABLE IF EXISTS Plat_Ingredient CASCADE;
CREATE TABLE Plat_Ingredient(
	idPlat SERIAL,
	idIngredient SERIAL,
	poids NUMERIC(10, 2),
	
	CONSTRAINT PK_Plat_Ingredient PRIMARY KEY (IdPlat, idIngredient)
);

ALTER TABLE Livraison ADD CONSTRAINT FK_Livraison_idClient FOREIGN KEY(idClient) REFERENCES Client(id)
	ON UPDATE CASCADE;
ALTER TABLE Livraison ADD CONSTRAINT FK_Livraison_idUtilisateur FOREIGN KEY(idUtilisateur) REFERENCES Utilisateur(id)
	ON UPDATE CASCADE;
ALTER TABLE Livraison_Plat ADD CONSTRAINT FK_Livraison_idLivraison FOREIGN KEY(idLivraison) REFERENCES Livraison(id)
	ON UPDATE CASCADE;
ALTER TABLE	Livraison_Plat ADD CONSTRAINT FK_Livraison_idPlat FOREIGN KEY(idPlat) REFERENCES Plat(id)
	ON UPDATE CASCADE;
ALTER TABLE Plat_Ingredient ADD CONSTRAINT FK_Plat_Ingredient_idPlat FOREIGN KEY(idPlat) REFERENCES Plat(id)
	ON UPDATE CASCADE;
ALTER TABLE Plat_Ingredient ADD CONSTRAINT FK_Plat_Ingredient_idIngredient FOREIGN KEY(idIngredient) REFERENCES Ingredient(id)








