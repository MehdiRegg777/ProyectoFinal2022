-- -----------------------------------------------------
-- Table `mydb`.`usuario`
-- -----------------------------------------------------

CREATE TABLE usuario (
  id_user INT NOT NULL,
  username VARCHAR(45) NULL,
  birth_date VARCHAR(45) NULL,
  password VARCHAR(45) NULL,
  PRIMARY KEY (id_user));

-- -----------------------------------------------------
-- Table `mydb`.`planetas`
-- -----------------------------------------------------

CREATE TABLE planetas (
  id_planetas INT NOT NULL,
  nombre VARCHAR(45) NULL,
  technology_attack VARCHAR(45) NULL,
  technology_defense VARCHAR(45) NULL,
  cristal VARCHAR(45) NULL,
  metal VARCHAR(45) NULL,
  deuterium VARCHAR(45) NULL,
  usuario_id_user INT NOT NULL,
  PRIMARY KEY (id_planetas),
  CONSTRAINT planetas_usuario_fk FOREIGN KEY (usuario_id_user) REFERENCES usuario(id_user));


-- -----------------------------------------------------
-- Table `mydb`.`batallas`
-- -----------------------------------------------------

CREATE TABLE batallas (
  id_battle INT NOT NULL,
  unidades VARCHAR(45) NULL,
  usuario_id_user INT NOT NULL,
  PRIMARY KEY (id_battle, usuario_id_user),
  CONSTRAINT battle_usuario_fk FOREIGN KEY (usuario_id_user) REFERENCES usuario (id_user));


-- -----------------------------------------------------
-- Table `mydb`.`naves`
-- -----------------------------------------------------

CREATE TABLE naves (
  id_ship INT NOT NULL,
  nombre VARCHAR(45) NULL,
  Metal_Cost INT NULL,
  Crystal_Cost INT NULL,
  Deuterium_Cost INT NULL,
  navescol INT NULL,
  PRIMARY KEY (id_ship));


-- -----------------------------------------------------
-- Table `mydb`.`defensas`
-- -----------------------------------------------------

CREATE TABLE defensas (
  id_defense INT NOT NULL,
  nombre VARCHAR(45) NULL,
  Metal_Cost INT NULL,
  Crystal_Cost INT NULL,
  Deuterium_Cost INT NULL,
  navescol INT NULL,
  PRIMARY KEY (id_defense));


-- -----------------------------------------------------
-- Table `mydb`.`planetas_has_naves`
-- -----------------------------------------------------
CREATE TABLE planetas_has_naves (
  planetas_id_planetas INT NOT NULL,
  naves_id_ship INT NOT NULL,
  cantidad VARCHAR(45) NULL,
  PRIMARY KEY (planetas_id_planetas, naves_id_ship),
  CONSTRAINT planetas_has_naves1_fk FOREIGN KEY (planetas_id_planetas) REFERENCES planetas(id_planetas),
  CONSTRAINT planetas_has_naves2_fk FOREIGN KEY (naves_id_ship) REFERENCES naves(id_ship));



-- -----------------------------------------------------
-- Table `mydb`.`planetas_has_defensas`
-- -----------------------------------------------------

CREATE TABLE planetas_has_defensas (
  planetas_id_planetas INT NOT NULL,
  defensas_id_defense INT NOT NULL,
  cantidad INT NULL,
  PRIMARY KEY (planetas_id_planetas, defensas_id_defense),
  CONSTRAINT planetas_has_defensas1 FOREIGN KEY (planetas_id_planetas) REFERENCES planetas(id_planetas),
  CONSTRAINT planetas_has_defensas2 FOREIGN KEY (defensas_id_defense) REFERENCES defensas(id_defense));