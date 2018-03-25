CREATE DATABASE IF NOT EXISTS petclinic;

ALTER DATABASE petclinic
DEFAULT CHARACTER SET utf8
DEFAULT COLLATE utf8_general_ci;

GRANT ALL PRIVILEGES ON petclinic.* TO root@localhost
IDENTIFIED BY 'mysql!';

USE petclinic;

CREATE TABLE IF NOT EXISTS vet (
  id         INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(30),
  last_name  VARCHAR(30),
  INDEX (last_name)
)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS specialty (
  id   INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(80),
  INDEX (name)
)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS vet_specialty (
  vet_id       INT(4) UNSIGNED NOT NULL,
  specialty_id INT(4) UNSIGNED NOT NULL,
  FOREIGN KEY (vet_id) REFERENCES vet (id),
  FOREIGN KEY (specialty_id) REFERENCES specialty (id),
  UNIQUE (vet_id, specialty_id)
)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS type (
  id   INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(80),
  INDEX (name)
)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS owner (
  id         INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(30),
  last_name  VARCHAR(30),
  address    VARCHAR(255),
  city       VARCHAR(80),
  telephone  VARCHAR(20),
  date_of_birth  BIGINT(20),
  INDEX (last_name)
)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS pet (
  id         INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name       VARCHAR(30),
  birth_date DATE,
  type_id    INT(4) UNSIGNED NOT NULL,
  owner_id   INT(4) UNSIGNED NOT NULL,
  INDEX (name),
  FOREIGN KEY (owner_id) REFERENCES owner (id),
  FOREIGN KEY (type_id) REFERENCES type (id)
)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS visit (
  id          INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  pet_id      INT(4) UNSIGNED NOT NULL,
  visit_date  DATE,
  description VARCHAR(255),
  FOREIGN KEY (pet_id) REFERENCES pet (id)
)
  ENGINE = InnoDB;