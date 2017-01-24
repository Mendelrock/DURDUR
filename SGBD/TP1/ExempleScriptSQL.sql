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


DROP TABLE depart CASCADE CONSTRAINTS PURGE
/
DROP TABLE avion CASCADE CONSTRAINTS PURGE
/
DROP TABLE pilote CASCADE CONSTRAINTS PURGE
/


PROMPT CREATION DES TABLES

CREATE TABLE avion
(
Numav INTEGER CONSTRAINT pk_avion PRIMARY KEY,
Capacite INTEGER,
type VARCHAR2(10),
Entrepot VARCHAR2(30)
)
/

CREATE TABLE pilote
(
Matricule INTEGER CONSTRAINT pk_pilote PRIMARY KEY,
Nom VARCHAR2(25) NOT NULL,
Ville VARCHAR2(30),
Age INTEGER,
Salaire INTEGER
)
/



CREATE TABLE depart
(
Numvol VARCHAR2(10),
DateDepart DATE,
numav INTEGER,
Matricule INTEGER,
CONSTRAINT pk_depart PRIMARY KEY (numvol, DateDepart)
)
/

ALTER TABLE depart
ADD CONSTRAINT fk_depart_avion
	FOREIGN KEY(numav)
	REFERENCES Avion(numav)
	ON DELETE CASCADE
ADD CONSTRAINT fk_depart_pilote
	FOREIGN KEY(matricule)
	REFERENCES Pilote(matricule)
	ON DELETE CASCADE
/


REM ** Ordres SQL de création de Séquences  **

PROMPT CREATION DES SEQUENCES

DROP SEQUENCE seq_avion
/
DROP SEQUENCE seq_pilote
/
DROP SEQUENCE seq_passager
/

CREATE SEQUENCE seq_avion start with 0 Minvalue 0
/
CREATE SEQUENCE seq_pilote start with 0 Minvalue 0 INCREMENT BY 10
/
CREATE SEQUENCE seq_passager start with 0 Minvalue 0 INCREMENT BY 100
/


REM ** Les Requêtes d'insertion de données

PROMPT INSERTION D'AVIONS

insert into avion (Numav, Capacite, Type, Entrepot)
values(seq_avion.nextval,2,'COUCOU','Marolles-en-Hurepoix');
insert into avion (Numav, Capacite, Type, Entrepot)
values(seq_avion.nextval,600,'ICBM','New-York');


PROMPT INSERTION DE PILOTES

insert into pilote (Matricule, Nom, Ville, Age, Salaire)
values(seq_pilote.nextval,'Amandier','Cherbourg',24,4000);
insert into pilote (Matricule, Nom, Ville, Age, Salaire)
values(seq_pilote.nextval,'Dupond','Coutance',35,2600);
insert into pilote (Matricule, Nom, Ville, Age, Salaire)
values(seq_pilote.nextval,'Citrae','Coutance',44,3300);


PROMPT INSERTION DE DEPARTS

insert into depart (Numvol, DateDepart, Numav, Matricule)
values('AF421','19-12-2011',1,10);
insert into depart (Numvol, DateDepart, Numav, Matricule)
values('AF422','19-12-2011',1,10);

PROMPT --> SCRIPT COMPLETEMENT TERMINE

commit;

SET FEEDBACK ON
