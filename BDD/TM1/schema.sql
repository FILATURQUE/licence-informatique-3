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
    FOREIGN KEY (nom_specialite) REFERENCES Specialite(nom_specialite)
);

CREATE TABLE Suivi (
    adeli CHAR(9) NOT NULL,
    nom_specialite VARCHAR(50) NOT NULL,
    nir CHAR(9) NOT NULL,
    PRIMARY KEY (adeli, nom_specialite, nir),  -- Ajout de la clé primaire composée
    FOREIGN KEY (adeli) REFERENCES Medecin(adeli),
    FOREIGN KEY (nom_specialite) REFERENCES Specialite(nom_specialite),
    FOREIGN KEY (nir) REFERENCES Patient(nir)
);

CREATE TABLE Intervention (
    adeli CHAR(9) NOT NULL,      -- Réorganisé pour correspondre à Suivi
    nom_specialite VARCHAR(50) NOT NULL,
    nir CHAR(9) NOT NULL,
    date_intervention DATE(1) NOT NULL,
    date_fin DATE(1) NOT NULL,
    tarif VARCHAR(5) NOT NULL,
    PRIMARY KEY (date_intervention),
    FOREIGN KEY (adeli, nom_specialite, nir) REFERENCES Suivi(adeli, nom_specialite, nir)
);

CREATE TABLE Consultation (
    adeli CHAR(9) NOT NULL,      -- Réorganisé pour correspondre à Suivi
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
VALUES ('dermatologue');

INSERT INTO Specialite (nom_specialite)
VALUES ('cardiologue');

INSERT INTO Specialite (nom_specialite)
VALUES ('medecine generale');

INSERT INTO Specialite (nom_specialite)
VALUES ('radiologue');

INSERT INTO Specialiste (adeli, nom_specialite)
VALUES ('123456789','cardiologue');

INSERT INTO Specialiste (adeli, nom_specialite)
VALUES ('123456789','radiologue');

INSERT INTO Suivi (adeli, nom_specialite, nir)
VALUES ('123456789','cardiologue','214119912345633');

CREATE VIEW Acte AS
SELECT nir, adeli, nom_specialite, date_intervention, tarif
FROM Intervention
UNION ALL
SELECT nir, adeli, nom_specialite, date_consultation, tarif
FROM Consultation;

CREATE VIEW Personne AS
SELECT 
    'med-' || adeli as id,
    nom, 
    prenom, 
    adresse, 
    telephone
FROM Medecin
UNION ALL 
SELECT 
    'pat-' || nir as id,
    nom, 
    prenom, 
    adresse, 
    telephone
FROM Patient;

-- SELECT * from Personne;

-- SELECT 1 pour une optimisation du code (convention)
CREATE TRIGGER intervention_check_trigger
    BEFORE INSERT ON Intervention
    WHEN EXISTS (
        SELECT 1 
        FROM Intervention 
        WHERE date_intervention = NEW.date_intervention
    )
BEGIN
    SELECT RAISE(ABORT, 'Une intervention existe déjà à cette date');
END;

INSERT INTO Consultation (adeli, nom_specialite, nir, date_consultation, descriptif, tarif)
VALUES ('123456789', 'cardiologue', '214119912345633', '2025-03-10 09:00:00', 'Suivi post-opératoire', '90.00');

INSERT INTO Intervention (adeli, nom_specialite, nir, date_intervention, date_fin, tarif)
VALUES ('123456789', 'cardiologue', '214119912345633', '2025-03-10 09:00:00', '2025-03-10 11:30:00', '250.00');


CREATE TRIGGER consultation_check_trigger
    BEFORE INSERT ON Consultation
    WHEN EXISTS (
        SELECT 1
        FROM Consultation
        WHERE date_consultation = NEW.date_consultation
    )
BEGIN 
    SELECT RAISE(ABORT,'Une consultation existe deja a cette date');
END;
-- Verification des triggers.

/* INSERT INTO Consultation (adeli, nom_specialite, nir, date_consultation, descriptif, tarif)
VALUES ('123456789', 'radiologue', '214119912345633', '2025-03-10 09:00:00', 'Suivi post-opératoire', '90.00');

INSERT INTO Intervention (adeli, nom_specialite, nir, date_intervention, date_fin, tarif)
VALUES ('123456789', 'radiologue', '214119912345633', '2025-03-10 09:00:00', '2025-03-10 11:30:00', '250.00'); */

CREATE TRIGGER medecin_check_specialite_trigger
    AFTER INSERT ON Medecin
    WHEN EXISTS (
        SELECT 1 
        FROM Specialiste
        WHERE NEW.adeli = adeli
    ) = false
BEGIN 
    SELECT RAISE (ABORT,'Il faut au moins une specialite pour etre un medecin.');
END;

INSERT INTO Medecin (adeli, nom, prenom, adresse, telephone)
VALUES ('987654321','FAIRA','Thoe','Champigny','0241356611');

INSERT INTO Specialiste (adeli, nom_specialite)
VALUES ('987654321','dermatologue');