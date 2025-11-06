PRAGMA foreign_keys = ON;

CREATE TABLE Medecin (
    adeli CHAR(9) NOT NULL,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    adresse VARCHAR(255) NOT NULL,
    telephone VARCHAR(20) NOT NULL,
    PRIMARY KEY (adeli)
);

CREATE TABLE Patient (
    nir CHAR(9) NOT NULL,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    adresse VARCHAR(255) NOT NULL,
    telephone VARCHAR(20) NOT NULL,
    sexe CHAR(1) NOT NULL CHECK (sexe IN ('H','F')),
    date_naissance DATE(1) NOT NULL,
    PRIMARY KEY (nir)
);

CREATE TABLE Specialite (
    nom_specialite VARCHAR(50),
    PRIMARY KEY (nom_specialite)
);

CREATE TABLE Specialiste (
    adeli CHAR(9) NOT NULL,
    nom_specialite VARCHAR(50) NOT NULL,
    FOREIGN KEY (adeli) REFERENCES Medecin(adeli),
    FOREIGN KEY (nom_specialite) REFERENCES Specialite(non_specialite)
);

CREATE TABLE Suivi (
    adeli CHAR(9) NOT NULL,
    nom_specialite VARCHAR(50) NOT NULL,
    nir CHAR(9) NOT NULL,
    FOREIGN KEY (adeli) REFERENCES Medecin(adeli),
    FOREIGN KEY (nom_specialite) REFERENCES Specialite(nom_specialite),
    FOREIGN KEY (nir) REFERENCES Patient(nir)
);

CREATE TABLE Intervention (
    adeli CHAR(9) NOT NULL,
    nom_specialite VARCHAR(50) NOT NULL,
    nir CHAR(9) NOT NULL,
    date_intervention DATE(1) NOT NULL,
    date_fin DATE(1) NOT NULL,
    tarif VARCHAR(5) NOT NULL,
    PRIMARY KEY (date_intervention),
    FOREIGN KEY (adeli, nom_specialite, nir) REFERENCES Suivi(adeli, nom_specialite, nir) 
);

CREATE TABLE Consultation (
    adeli CHAR(9) NOT NULL,
    nom_specialite VARCHAR(50) NOT NULL,
    nir CHAR(9) NOT NULL,
    date_consultation DATE(1) NOT NULL,
    descriptif VARCHAR(100),
    tarif VARCHAR(5) NOT NULL,
    PRIMARY KEY (date_consultation),
    FOREIGN KEY (adeli, nom_specialite, nir) REFERENCES Suivi(adeli, nom_specialite, nir) 
);

CREATE TABLE Ordonnance (
    adeli CHAR(9) NOT NULL,
    nom_specialite VARCHAR(50) NOT NULL,
    nir CHAR(9) NOT NULL,
    date_ordonnance DATE(1) NOT NULL,
    num_ordonnance CHAR(9) NOT NULL,
    texte VARCHAR(100),
    PRIMARY KEY (date_ordonnance, num_ordonnance),
    FOREIGN KEY (adeli, nom_specialite, nir) REFERENCES Suivi(adeli, nom_specialite, nir) 
);

INSERT INTO Medecin (adeli, nom, prenom, adresse, telephone)
VALUES ('123456789','Dubreuil','Christian','Moulinsart','0254314159');

INSERT INTO Patient (nir, nom, prenom, adresse, telephone, sexe, date_naissance)
VALUES ('214119912345633','Ducitron','Clementine','Paris','0610203040','F','1914-11-25');

INSERT INTO Specialite (nom_specialite)
VALUES ('dermatologie');

INSERT INTO Specialite (nom_specialite)
VALUES ('cardiologie');

INSERT INTO Specialite (nom_specialite)
VALUES ('medecine generale');

CREATE VIEW Acte AS
SELECT nir, adeli, nom_specialite, date, tarif
FROM Intervention
UNION ALL
SELECT nir, adeli, nom_specialite, date, tarif
FROM Consultation;