
SET NAMES utf8 ;


use cardvalidator;
CREATE TABLE cardvalidator.teste(id_teste int(5),descr varchar(50));

CREATE TABLE cardvalidator.brand (
  id_brand bigint(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  brand varchar(10) ,
  description varchar(50) ,
  created_at datetime ,
  UNIQUE KEY brand_UNIQUE (brand)
);

CREATE TABLE cardvalidator.bin (
  id_bin bigint(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  id_brand bigint(10),
  bin bigint(10),
  country varchar(10),
  status varchar(10),
  created_at datetime,
  updated_at datetime,
  UNIQUE KEY bin_UNIQUE (bin)
);

CREATE TABLE cardvalidator.bin_type (
  id_type bigint(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  description varchar(50) ,
  created_at datetime ,
  UNIQUE KEY bin_UNIQUE (description)
);

ALTER TABLE cardvalidator.bin
ADD INDEX fk_brand_idx (id_brand ASC);

ALTER TABLE cardvalidator.bin
ADD CONSTRAINT fk_brand
  FOREIGN KEY (id_brand)
  REFERENCES brand (id_brand)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


CREATE TABLE cardvalidator.bin_bin_type (
  binid_bin bigint(10) NOT NULL,
  bin_typeid_type bigint(10) NOT NULL,
  PRIMARY KEY (binid_bin,bin_typeid_type),
  constraint FK_bin_bin_type foreign key (binid_bin) references bin(id_bin),
  constraint FK_bin_bin_type2 foreign key (bin_typeid_type) references bin_type(id_type)
  );

