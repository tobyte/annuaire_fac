create schema annuaire;
CREATE TABLE annuaire.personne (
id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY
nom VARCHAR(50) NOT NULL,
prenom VARCHAR(50) NOT NULL,
telephone VARCHAR(10) NOT NULL,
email VARCHAR(50) Primary key NOT NULL
);