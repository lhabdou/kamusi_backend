﻿CREATE TABLE ROLE (
  ID INTEGER NOT NULL,
  NOM_ROLE VARCHAR(20) NOT NULL,
  PRIMARY KEY(ID)
);

CREATE TABLE UTILISATEUR (
  ID_UTILISATEUR VARCHAR(100) NOT NULL,
  NOM VARCHAR(50) NOT NULL,
  PRENOM VARCHAR(50) NULL,
  PSEUDO VARCHAR(50) NULL,
  TEL VARCHAR(30) NULL,
  EMAIL VARCHAR(100) NOT NULL,
  GOOGLE_CONNECT BOOLEAN NULL DEFAULT false,
  ID_ROLE INTEGER NOT NULL, 
  CONSTRAINT pk_utilisateur PRIMARY KEY(ID_UTILISATEUR),
  CONSTRAINT fk_role FOREIGN KEY (id_role) 
  REFERENCES public.role (id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);
ALTER TABLE public.UTILISATEUR OWNER TO postgres;
CREATE INDEX UTILISATEUR_FKIndex1 on ROLE using btree (ID);

CREATE TABLE STATUT (
  ID_STATUT INTEGER NOT NULL,
  STATUT VARCHAR(50) NOT NULL,
  CONSTRAINT pk_statut PRIMARY KEY(ID_STATUT)
);


CREATE TABLE DICTIONNAIRE (
  MOT_FR VARCHAR(100) NOT NULL,
  MOT_NGZ VARCHAR(100) NOT NULL DEFAULT 'shingazidja',
  MOT_NDZ VARCHAR(100) NULL DEFAULT 'shindzuwani',
  MOT_MWA VARCHAR(100) NULL DEFAULT 'shimwali',
  MOT_MAO VARCHAR(100) NULL DEFAULT 'shimaore',
  MOT_ANG VARCHAR(100) NULL,
  ID_UTILISATEUR VARCHAR(100) NULL,
  ID_STATUT INTEGER NOT NULL,
  SUGGESTION VARCHAR(100) NULL,
  DEFINITION_FR VARCHAR(1000) NULL,
  DEFINITION_COM VARCHAR(1000) NULL,
  CONSTRAINT pk_dictionnaire PRIMARY KEY(MOT_FR, MOT_NGZ),
  CONSTRAINT fk_utilisateur FOREIGN KEY (id_utilisateur) 
  REFERENCES public.utilisateur (id_utilisateur) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_statut FOREIGN KEY (id_statut) 
  REFERENCES public.statut (id_statut) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT);

ALTER TABLE public.DICTIONNAIRE OWNER TO postgres;
CREATE INDEX DICTIONNAIRE_FKIndex1 on DICTIONNAIRE using btree (ID_UTILISATEUR);
CREATE INDEX DICTIONNAIRE_FKIndex2 on DICTIONNAIRE using btree (ID_STATUT); 


CREATE TABLE DICTIONNAIRE_TEMP (
  MOT_FR VARCHAR(100) NOT NULL,
  MOT_NGZ VARCHAR(100) NOT NULL DEFAULT 'shingazidja',
  MOT_NDZ VARCHAR(100) NULL DEFAULT 'shindzuwani',
  MOT_MWA VARCHAR(100) NULL DEFAULT 'shimwali',
  MOT_MAO VARCHAR(100) NULL DEFAULT 'shimaore',
  MOT_ANG VARCHAR(100) NULL,
  ID_UTILISATEUR VARCHAR(100) NULL,
  ID_STATUT INTEGER NOT NULL,
  SUGGESTION VARCHAR(100) NULL,
  DEFINITION_FR VARCHAR(1000) NULL,
  DEFINITION_COM VARCHAR(1000) NULL,
  CONSTRAINT pk_dictionnaire_temp PRIMARY KEY(MOT_FR, MOT_NGZ),
  CONSTRAINT fk_utilisateur FOREIGN KEY (id_utilisateur) 
  REFERENCES public.utilisateur (id_utilisateur) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_statut FOREIGN KEY (id_statut) 
  REFERENCES public.statut (id_statut) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT);

ALTER TABLE public.DICTIONNAIRE_TEMP OWNER TO postgres;
CREATE INDEX DICTIONNAIRE_TEMP_FKIndex1 on DICTIONNAIRE_TEMP using btree (ID_UTILISATEUR);
CREATE INDEX DICTIONNAIRE_TEMP_FKIndex2 on DICTIONNAIRE_TEMP using btree (ID_STATUT); 