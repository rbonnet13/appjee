/*------------------------------------------------------------
*        Script SQLSERVER 
------------------------------------------------------------*/


/*------------------------------------------------------------
-- Table: ETUDIANT
------------------------------------------------------------*/
CREATE TABLE ETUDIANT(
	id_etudiant   INT IDENTITY (1,1) NOT NULL ,
	nom           VARCHAR (25) NOT NULL ,
	prenom        VARCHAR (25) NOT NULL ,
	etablissement VARCHAR (25) NOT NULL ,
	promotion     VARCHAR (25) NOT NULL ,
	CONSTRAINT prk_constraint_ETUDIANT PRIMARY KEY NONCLUSTERED (id_etudiant)
);


/*------------------------------------------------------------
-- Table: DIRECTEUR
------------------------------------------------------------*/
CREATE TABLE DIRECTEUR(
	id_directeur        INT IDENTITY (1,1) NOT NULL ,
	type_directeur      VARCHAR (25) NOT NULL ,
	nom_directeur       VARCHAR (25) NOT NULL ,
	etudiants_rattaches VARCHAR (25) NOT NULL ,
	CONSTRAINT prk_constraint_DIRECTEUR PRIMARY KEY NONCLUSTERED (id_directeur)
);


/*------------------------------------------------------------
-- Table: PROBLEMES
------------------------------------------------------------*/
CREATE TABLE PROBLEMES(
	id_probleme        INT IDENTITY (1,1) NOT NULL ,
	nom_auteur         VARCHAR (25)  ,
	prenom_auteur      VARCHAR (25)  ,
	texte_probleme     TEXT   ,
	nbr_votes_probleme INT   ,
	id_directeur       INT   ,
	CONSTRAINT prk_constraint_PROBLEMES PRIMARY KEY NONCLUSTERED (id_probleme)
);


/*------------------------------------------------------------
-- Table: INFORMATION
------------------------------------------------------------*/
CREATE TABLE INFORMATION(
	id_information                  INT IDENTITY (1,1) NOT NULL ,
	promotion_destinataire          VARCHAR (25) NOT NULL ,
	auteur_info                     VARCHAR (25) NOT NULL ,
	texte_info                      TEXT  NOT NULL ,
	promotion_destinataire_Informer VARCHAR (25) NOT NULL ,
	id_directeur                    INT   ,
	CONSTRAINT prk_constraint_INFORMATION PRIMARY KEY NONCLUSTERED (id_information)
);


/*------------------------------------------------------------
-- Table: Supprimer Information
------------------------------------------------------------*/
CREATE TABLE Supprimer_Information(
	id_directeur               INT  NOT NULL ,
	id_information             INT  NOT NULL ,
	id_information_INFORMATION INT  NOT NULL ,
	CONSTRAINT prk_constraint_Supprimer_Information PRIMARY KEY NONCLUSTERED (id_directeur,id_information,id_information_INFORMATION)
);


/*------------------------------------------------------------
-- Table: Signaler Problème
------------------------------------------------------------*/
CREATE TABLE Signaler_Probleme(
	id_etudiant INT  NOT NULL ,
	id_probleme INT  NOT NULL ,
	CONSTRAINT prk_constraint_Signaler_Probleme PRIMARY KEY NONCLUSTERED (id_etudiant,id_probleme)
);


/*------------------------------------------------------------
-- Table: Consulter
------------------------------------------------------------*/
CREATE TABLE Consulter(
	id_etudiant    INT  NOT NULL ,
	id_information INT  NOT NULL ,
	CONSTRAINT prk_constraint_Consulter PRIMARY KEY NONCLUSTERED (id_etudiant,id_information)
);


/*------------------------------------------------------------
-- Table: Consulter Probleme
------------------------------------------------------------*/
CREATE TABLE Consulter_Probleme(
	votes        INT IDENTITY (1,1) NOT NULL ,
	id_etudiant  INT  NOT NULL ,
	id_probleme  INT  NOT NULL ,
	id_directeur INT  NOT NULL ,
	CONSTRAINT prk_constraint_Consulter_Probleme PRIMARY KEY NONCLUSTERED (id_etudiant,id_probleme,id_directeur)
);



ALTER TABLE PROBLEMES ADD CONSTRAINT FK_PROBLEMES_id_directeur FOREIGN KEY (id_directeur) REFERENCES DIRECTEUR(id_directeur);
ALTER TABLE INFORMATION ADD CONSTRAINT FK_INFORMATION_id_directeur FOREIGN KEY (id_directeur) REFERENCES DIRECTEUR(id_directeur);
ALTER TABLE Supprimer_Information ADD CONSTRAINT FK_Supprimer_Information_id_directeur FOREIGN KEY (id_directeur) REFERENCES DIRECTEUR(id_directeur);
ALTER TABLE Supprimer_Information ADD CONSTRAINT FK_Supprimer_Information_id_information FOREIGN KEY (id_information) REFERENCES INFORMATION(id_information);
ALTER TABLE Supprimer_Information ADD CONSTRAINT FK_Supprimer_Information_id_information_INFORMATION FOREIGN KEY (id_information_INFORMATION) REFERENCES INFORMATION(id_information);
ALTER TABLE Signaler_Probleme ADD CONSTRAINT FK_Signaler_Probleme_id_etudiant FOREIGN KEY (id_etudiant) REFERENCES ETUDIANT(id_etudiant);
ALTER TABLE Signaler_Probleme ADD CONSTRAINT FK_Signaler_Probleme_id_probleme FOREIGN KEY (id_probleme) REFERENCES PROBLEMES(id_probleme);
ALTER TABLE Consulter ADD CONSTRAINT FK_Consulter_id_etudiant FOREIGN KEY (id_etudiant) REFERENCES ETUDIANT(id_etudiant);
ALTER TABLE Consulter ADD CONSTRAINT FK_Consulter_id_information FOREIGN KEY (id_information) REFERENCES INFORMATION(id_information);
ALTER TABLE Consulter_Probleme ADD CONSTRAINT FK_Consulter_Probleme_id_etudiant FOREIGN KEY (id_etudiant) REFERENCES ETUDIANT(id_etudiant);
ALTER TABLE Consulter_Probleme ADD CONSTRAINT FK_Consulter_Probleme_id_probleme FOREIGN KEY (id_probleme) REFERENCES PROBLEMES(id_probleme);
ALTER TABLE Consulter_Probleme ADD CONSTRAINT FK_Consulter_Probleme_id_directeur FOREIGN KEY (id_directeur) REFERENCES DIRECTEUR(id_directeur);

