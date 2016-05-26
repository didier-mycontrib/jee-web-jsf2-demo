
CREATE DATABASE IF NOT EXISTS boutique_db_ex1;
USE boutique_db_ex1;

DROP TABLE IF EXISTS Produit;
DROP TABLE IF EXISTS Categorie;
DROP TABLE IF EXISTS Compte;
DROP TABLE IF EXISTS Client;
DROP TABLE IF EXISTS Adresse;



######################## CREATE  TABLE ########################################

CREATE TABLE Client(
	nom VARCHAR(64),
	prenom VARCHAR(64),
	numClient integer auto_increment,
	dateNaissance DATE,
	telephone VARCHAR(16),
	email VARCHAR(64),
	ref_adressePrincipale integer,
	password VARCHAR(64),
	PRIMARY KEY(numClient));	 

CREATE TABLE Adresse(
	codePostal VARCHAR(64),
	ville VARCHAR(64),
	rue VARCHAR(64),
	idAdr integer auto_increment,
	
	PRIMARY KEY(idAdr));	 


CREATE TABLE Categorie(
	label VARCHAR(64),
	numero integer auto_increment,
	ref_parent integer,
	PRIMARY KEY(numero));	 

CREATE TABLE Produit(
	label VARCHAR(64),
	caracteristiques VARCHAR(512),
	prix double,
	numProd integer auto_increment,
	ref_categorie integer,
	PRIMARY KEY(numProd));	 
	



#######################   FOREIGN KEY       ####################################

ALTER TABLE Client ADD CONSTRAINT Client_avec_adressePrincipale_valide 
FOREIGN KEY (ref_adressePrincipale) REFERENCES Adresse(idAdr);


ALTER TABLE Produit ADD CONSTRAINT Produit_avec_categorie_valide 
FOREIGN KEY (ref_categorie) REFERENCES Categorie(numero);

#temporairement desactive pour eviter bug test/dbunit 
#ALTER TABLE Categorie ADD CONSTRAINT Categorie_avec_categorieParente_valide 
#FOREIGN KEY (ref_parent) REFERENCES Categorie(numero);



