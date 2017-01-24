REM Exercice 2

SET LINESIZE 180
SET PAGESIZE 40
CLEAR SCREEN

REM Implantation ascendante

drop table ordinateurbis cascade constraint purge;

create table ordinateurbis
(
	noserie integer not null,
	typeordi varchar(10),
	dateachat date not  null,
	adrIp varchar(30),
	masque varchar(30),
	nomserveur varchar(30),
	typedisque varchar(30),
	primary key (noserie)
);

PROMPT Mise à jour de la table ordinateurbis
insert into ordinateurbis(noserie, dateachat) select noserie, dateachat from ordinateur;

update ordinateurbis 
set typeordi = 'Client', adrIp = (select adrIp from posteclient where ordinateurbis.noserie = posteclient.noserie), masque = (select masque from posteclient where ordinateurbis.noserie = posteclient.noserie)
where ordinateurbis.noserie in (select noserie from posteclient);

update ordinateurbis 
set (nomserveur, typedisque, typeordi) = (select nomserveur, typedisque, 'Serveur' from posteserveur where ordinateurbis.noserie = posteserveur.noserie)
where ordinateurbis.noserie in (select noserie from posteserveur);

CREATE OR REPLACE VIEW V_Ordinateur AS
select * from ordinateurbis;

CREATE OR REPLACE VIEW V_PosteClient AS
select * from ordinateurbis
where typeordi = 'Client';

CREATE OR REPLACE VIEW V_PosteServeur AS
select * from ordinateurbis
where typeordi = 'Serveur';