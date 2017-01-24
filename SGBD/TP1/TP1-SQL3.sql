SET FEEDBACK OFF
SET LINESIZE 150
SET PAGESIZE 40

REM **************************************************************************
REM BASE AERO
REM Auteur : Jerome FESSY
REM Date de Mise à Jour : 29/09/2012
REM ***************************************************************************

ALTER SESSION SET NLS_DATE_FORMAT = 'dd/mm/yyyy';

PROMPT --> DEBUT DU SCRIPT

REM ** Requête SQL de création des tables **


DROP TABLE Operations CASCADE CONSTRAINTS PURGE
/
DROP TABLE Compte CASCADE CONSTRAINTS PURGE
/
DROP TABLE TypeCompte CASCADE CONSTRAINTS PURGE
/


PROMPT CREATION DES TABLES

CREATE TABLE Operations
(
IdOperation INTEGER CONSTRAINT pk_operation PRIMARY KEY,
MontantOperation INTEGER,
IdCompte INTEGER
)
/

CREATE TABLE Compte
(
IdCompte INTEGER CONSTRAINT pk_compte PRIMARY KEY,
LibelleCompte VARCHAR(100),
IdTypeCompte INTEGER
)
/

CREATE TABLE TypeCompte
(
IdTypeCompte INTEGER CONSTRAINT pk_type PRIMARY KEY,
LibelleTypeCompte VARCHAR(100)
)
/

ALTER TABLE Operations
ADD CONSTRAINT fk_idcompte
	FOREIGN KEY(IdCompte)
	REFERENCES Compte(IdCompte)
	ON DELETE CASCADE
/
ALTER TABLE Compte
ADD CONSTRAINT fk_idtype
	FOREIGN KEY(IdTypeCompte)
	REFERENCES TypeCompte(IdTypeCompte)
	ON DELETE CASCADE
/

REM ** Ordres SQL de création de Séquences  **

PROMPT CREATION DES SEQUENCES

DROP SEQUENCE seq_typecompte
/
DROP SEQUENCE seq_compte
/
DROP SEQUENCE seq_op
/

CREATE SEQUENCE seq_typecompte start with 0 Minvalue 0
/
CREATE SEQUENCE seq_compte start with 0 Minvalue 0 INCREMENT BY 100
/
CREATE SEQUENCE seq_op start with 0 Minvalue 0
/

REM ** Les Requêtes d'insertion de données

PROMPT INSERTION DE TYPES DE COMPTE

insert into TypeCompte (IdTypeCompte, LibelleTypeCompte)
values(seq_typecompte.nextval,'LivretA');
insert into TypeCompte (IdTypeCompte, LibelleTypeCompte)
values(seq_typecompte.nextval,'CEL');
insert into TypeCompte (IdTypeCompte, LibelleTypeCompte)
values(seq_typecompte.nextval,'PEL');

PROMPT INSERTION DE COMPTES

insert into Compte (IdCompte, LibelleCompte, IdTypeCompte)
values(seq_compte.nextval,'C01BNP',2);
insert into Compte (IdCompte, LibelleCompte, IdTypeCompte)
values(seq_compte.nextval,'C02BNP',1);
insert into Compte (IdCompte, LibelleCompte, IdTypeCompte)
values(seq_compte.nextval,'C01CA',1);

PROMPT INSERTION D'OPERATIONS

insert into Operations (IdOperation, MontantOperation, IdCompte)
values(seq_op.nextval,100,100);
insert into Operations (IdOperation, MontantOperation, IdCompte)
values(seq_op.nextval,-200,100);
insert into Operations (IdOperation, MontantOperation, IdCompte)
values(seq_op.nextval,-45,200);
insert into Operations (IdOperation, MontantOperation, IdCompte)
values(seq_op.nextval,250,200);
insert into Operations (IdOperation, MontantOperation, IdCompte)
values(seq_op.nextval,-76,300);


PROMPT --> SCRIPT COMPLETEMENT TERMINE

commit;

SET FEEDBACK ON
