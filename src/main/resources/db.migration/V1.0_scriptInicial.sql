
SET NAMES utf8 ;

/* ------
 Schema
------ */
/* CREATE SCHEMA cardvalidator DEFAULT CHARACTER SET latin1 COLLATE latin1_bin;

/*
------
Tabelas
-------
-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  */
create table cardvalidator.teste(id_teste int(5),descr varchar(50));

/*
CREATE TABLE brand (
  id_brand int(11) NOT NULL,
  brand varchar(10) DEFAULT NULL,
  description varchar(50) DEFAULT NULL,
  created_at datetime NOT NULL);


CREATE TABLE bin (
  id_bin int(11) NOT NULL,
  id_brand int(11) NOT NULL,
  bin int(11) DEFAULT NULL,
  country varchar(10) DEFAULT NULL,
  status varchar(10) NOT NULL,
  created_at datetime NOT NULL,
  updated_at datetime DEFAULT NULL);


CREATE TABLE bin_type (
  id_type int(11) NOT NULL,
  description varchar(50) DEFAULT NULL,
  created_at datetime NOT NULL);


CREATE TABLE bin_bin_type (
  binid_bin int(11) NOT NULL,
  bin_typeid_type int(11) NOT NULL);

/*
------
Dados
-----*/
/**
INSERT INTO brand (id_brand, brand, description, created_at) VALUES(1, '506722', 'elo', '2020-07-02 00:00:00');
INSERT INTO brand (id_brand, brand, description, created_at) VALUES(2, '485464', 'visa', '2020-07-02 00:00:00');


INSERT INTO bin (id_bin, id_brand, bin, country, status, created_at, updated_at)
VALUES (1, 1, 506744, 'brasil', 'ativo', '2020-07-02', null);
INSERT INTO bin (id_bin, id_brand, bin, country, status, created_at, updated_at)
VALUES (2, 1, 548799, 'brasil', 'ativo', '2020-07-02 00:00:00', '2020-07-03 00:00:00');
INSERT INTO bin (id_bin, id_brand, bin, country, status, created_at, updated_at)
VALUES (3, 2, 548966, 'brasil', 'inativo', '2020-07-02 00:00:00', '');


INSERT INTO bin_type (id_type, description, created_at) VALUES (1,'debito','2020-07-02 00:00:00');
INSERT INTO bin_type (id_type, description, created_at) VALUES (2,'credito','2020-07-02 00:00:00');
INSERT INTO bin_type (id_type, description, created_at) VALUES (3,'refeicao','2020-07-02 00:00:00');


INSERT INTO bin_bin_type (binid_bin, bin_typeid_type) VALUES (1, 1);
INSERT INTO bin_bin_type (binid_bin, bin_typeid_type) VALUES (2, 2);

*/