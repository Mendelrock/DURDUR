SET FEEDBACK OFF;

DROP TABLE avion CASCADE CONSTRAINTS PURGE;

DROP Sequence seq_avion;

CREATE SEQUENCE seq_avion;

CREATE TABLE avion
(
Numav INTEGER CONSTRAINT pk_avion PRIMARY KEY,
Capacite INTEGER,
type VARCHAR2(10),
Entrepot VARCHAR2(30)
);

insert into avion (Numav, Capacite, Type, Entrepot)
values(seq_avion.nextval,2,'COUCOU','Marolles-en-Hurepoix');
insert into avion (Numav, Capacite, Type, Entrepot)
values(seq_avion.nextval,600,'ICBM','New-York');
insert into avion (Numav, Capacite, Type, Entrepot)
values(seq_avion.nextval,100,'B907','Tarascon');
insert into avion (Numav, Capacite, Type, Entrepot)
values(seq_avion.nextval,500,'A320','Tarascon');
insert into avion (Numav, Capacite, Type, Entrepot)
values(seq_avion.nextval,50,'A220','Pogo Togo');
insert into avion (Numav, Capacite, Type, Entrepot)
values(seq_avion.nextval,500,'A320','Tarascon');
insert into avion (Numav, Capacite, Type, Entrepot)
values(seq_avion.nextval,600,'ICBM','New-York');
insert into avion (Numav, Capacite, Type, Entrepot)
values(seq_avion.nextval,600,'ICBM','New-York');
insert into avion (Numav, Capacite, Type, Entrepot)
values(666,100,'B907','Pogo Togo');

commit;

PROMPT *****************************************************
PROMPT Table Avion creee et alimentee par des donees de test
PROMPT *****************************************************

SET FEEDBACK ON
