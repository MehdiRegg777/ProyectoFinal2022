/***
     Creacion de tablas.
***/
set SERVEROUTPUT on
CREATE OR REPLACE PROCEDURE CREAR_TABLA
AS
uSQL1 VARCHAR(4000);
uSQL2 VARCHAR(4000);
uSQL3 VARCHAR(4000);
uSQL4 VARCHAR(4000);
uSQL5 VARCHAR(4000);
uSQL6 VARCHAR(4000);
uSQL7 VARCHAR(4000);
BEGIN
    uSQL1 := 'CREATE TABLE usuario (
    id_user INT NOT NULL,
    username VARCHAR(45) NULL,
    birth_date DATE NULL,
    password VARCHAR(45) NULL,
    PRIMARY KEY (id_user))';
    EXECUTE IMMEDIATE uSQL1;
    DBMS_OUTPUT.PUT_LINE ('Table usuario ha sido creada.');
    
    uSQL2 := 'CREATE TABLE planetas (
      id_planetas INT NOT NULL,
      nombre VARCHAR(45) NULL,
      technology_attack VARCHAR(45) NULL,
      technology_defense VARCHAR(45) NULL,
      cristal VARCHAR(45) NULL,
      metal VARCHAR(45) NULL,
      deuterium VARCHAR(45) NULL,
      usuario_id_user INT NOT NULL,
      PRIMARY KEY (id_planetas),
      CONSTRAINT planetas_usuario_fk FOREIGN KEY (usuario_id_user) REFERENCES usuario(id_user))';
    EXECUTE IMMEDIATE uSQL2;
    DBMS_OUTPUT.PUT_LINE ('Table planetas ha sido creada.');
    
    uSQL3 := 'CREATE TABLE batallas (
      id_battle INT NOT NULL,
      inicial_unidad_usu int,
      finalizar_unidades_usu int,
      inicial_unidad_ene int,
      finalizar_unidades_ene int,
      usuario_id_user INT NOT NULL,
      PRIMARY KEY (id_battle, usuario_id_user),
      CONSTRAINT battle_usuario_fk FOREIGN KEY (usuario_id_user) REFERENCES usuario (id_user))';
    EXECUTE IMMEDIATE uSQL3;
    DBMS_OUTPUT.PUT_LINE ('Table batallas ha sido creada.');
    
    uSQL4 := 'CREATE TABLE naves (
      id_ship INT NOT NULL,
      nombre VARCHAR(450) NULL,
      Metal_Cost INT NULL,
      Crystal_Cost INT NULL,
      Deuterium_Cost INT NULL,
      InitialArmor INT NULL,
      Armor INT NULL,
      BaseDamage  INT NULL,
      Speed INT NULL,
      Generate_Wastings INT NULL,
      PRIMARY KEY (id_ship))';
        EXECUTE IMMEDIATE uSQL4;
        DBMS_OUTPUT.PUT_LINE ('Table naves ha sido creada.');
        
     uSQL5 := 'CREATE TABLE defensas (
      id_defense INT NOT NULL,
      nombre VARCHAR(45) NULL,
      Metal_Cost INT NULL,
      Crystal_Cost INT NULL,
      Deuterium_Cost INT NULL,
      InitialArmor INT NULL,
      Armor INT NULL,
      BaseDamage  INT NULL,
      Speed INT NULL,
      Generate_Wastings INT NULL,
      PRIMARY KEY (id_defense))';
        EXECUTE IMMEDIATE uSQL5;
        DBMS_OUTPUT.PUT_LINE ('Table defensas ha sido creada.');
        
    uSQL6 := 'CREATE TABLE planetas_has_naves (
      planetas_id_planetas INT NOT NULL,
      naves_id_ship INT NOT NULL,
      cantidad INT NULL,
      PRIMARY KEY (planetas_id_planetas, naves_id_ship),
      CONSTRAINT planetas_has_naves1_fk FOREIGN KEY (planetas_id_planetas) REFERENCES planetas(id_planetas),
      CONSTRAINT planetas_has_naves2_fk FOREIGN KEY (naves_id_ship) REFERENCES naves(id_ship))';
        EXECUTE IMMEDIATE uSQL6;
        DBMS_OUTPUT.PUT_LINE ('Table planetas_has_naves ha sido creada.');
        
    uSQL7 := 'CREATE TABLE planetas_has_defensas (
      planetas_id_planetas INT NOT NULL,
      defensas_id_defense INT NOT NULL,
      cantidad INT NULL,
      PRIMARY KEY (planetas_id_planetas, defensas_id_defense),
      CONSTRAINT planetas_has_defensas1 FOREIGN KEY (planetas_id_planetas) REFERENCES planetas(id_planetas),
      CONSTRAINT planetas_has_defensas2 FOREIGN KEY (defensas_id_defense) REFERENCES defensas(id_defense))';
        EXECUTE IMMEDIATE uSQL7;
        DBMS_OUTPUT.PUT_LINE ('Table planetas_has_defensas ha sido creada.');
    exception
    when others then
    DBMS_OUTPUT.PUT_LINE ('Tabla de las tablas ya existe.');
END CREAR_TABLA;

set SERVEROUTPUT on
CALL CREAR_TABLA();
