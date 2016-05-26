

USE boutique_db_ex1;


#########################  INSERT INTO   #####################################

INSERT INTO Adresse (codePostal,idAdr,rue,ville)  VALUES ('75000',1,'2 rue elle','Paris');
INSERT INTO Client (numClient,nom,prenom,dateNaissance,ref_adressePrincipale,password,telephone,email)
              VALUES (1,'Defrance','Didier','1969-07-11',1,'mypwd','0102030405','didier@ici_ou_la');

INSERT INTO Categorie (label,numero,ref_parent) VALUES ('CD',1,null);
INSERT INTO Categorie (label,numero,ref_parent) VALUES ('DVD',2,null);               
INSERT INTO Categorie (label,numero,ref_parent) VALUES ('CD_classique',3,1);
INSERT INTO Categorie (label,numero,ref_parent) VALUES ('CD_varietes',4,1);
INSERT INTO Categorie (label,numero,ref_parent) VALUES ('DVD_Film',5,2);
INSERT INTO Categorie (label,numero,ref_parent) VALUES ('DVD_SerieTV',6,2);
INSERT INTO Produit (label,prix,numProd,ref_categorie,caracteristiques)  VALUES ('CD1',12.0,1,3,'Mozart , flute enchantee');
INSERT INTO Produit (label,prix,numProd,ref_categorie,caracteristiques)  VALUES ('CD2',10.0,2,3,'Vilvaldi , 4 saisons');
INSERT INTO Produit (label,prix,numProd,ref_categorie,caracteristiques)  VALUES ('DVD1',18.0,3,5,'Pirate des caraibes');

###################### VERIFICATIONS ###########################################
show tables;
SELECT * FROM Client;
SELECT * FROM Adresse;
SELECT * FROM Categorie;
SELECT * FROM Produit;


