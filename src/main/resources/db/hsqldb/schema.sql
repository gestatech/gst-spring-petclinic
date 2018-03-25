DROP TABLE vet_specialty
IF EXISTS;
DROP TABLE vet
IF EXISTS;
DROP TABLE specialty
IF EXISTS;
DROP TABLE visit
IF EXISTS;
DROP TABLE pet
IF EXISTS;
DROP TABLE type
IF EXISTS;
DROP TABLE owner
IF EXISTS;


CREATE TABLE vet (
  id         INTEGER IDENTITY PRIMARY KEY,
  first_name VARCHAR(30),
  last_name  VARCHAR(30)
);
CREATE INDEX vet_last_name
  ON vet (last_name);

CREATE TABLE specialty (
  id   INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(80)
);
CREATE INDEX specialties_name
  ON specialties (name);

CREATE TABLE vet_specialty (
  vet_id       INTEGER NOT NULL,
  specialty_id INTEGER NOT NULL
);
ALTER TABLE vet_specialty
  ADD CONSTRAINT fk_vet_specialty_vet FOREIGN KEY (vet_id) REFERENCES vet (id);
ALTER TABLE vet_specialty
  ADD CONSTRAINT fk_vet_specialty_specialty FOREIGN KEY (specialty_id) REFERENCES specialty (id);

CREATE TABLE type (
  id   INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(80)
);
CREATE INDEX type_name
  ON types (name);

CREATE TABLE owner (
  id         INTEGER IDENTITY PRIMARY KEY,
  first_name VARCHAR(30),
  last_name  VARCHAR_IGNORECASE(30),
  address    VARCHAR(255),
  city       VARCHAR(80),
  telephone  VARCHAR(20)
);
CREATE INDEX owner_last_name
  ON owner (last_name);

CREATE TABLE pet (
  id         INTEGER IDENTITY PRIMARY KEY,
  name       VARCHAR(30),
  birth_date DATE,
  type_id    INTEGER NOT NULL,
  owner_id   INTEGER NOT NULL
);
ALTER TABLE pet
  ADD CONSTRAINT fk_pet_owner FOREIGN KEY (owner_id) REFERENCES owner (id);
ALTER TABLE pet
  ADD CONSTRAINT fk_pet_type FOREIGN KEY (type_id) REFERENCES type (id);
CREATE INDEX pet_name
  ON pet (name);

CREATE TABLE visit (
  id          INTEGER IDENTITY PRIMARY KEY,
  pet_id      INTEGER NOT NULL,
  visit_date  DATE,
  description VARCHAR(255)
);
ALTER TABLE visit
  ADD CONSTRAINT fk_visit_pets FOREIGN KEY (pet_id) REFERENCES pet (id);
CREATE INDEX visit_pet_id
  ON visit (pet_id);