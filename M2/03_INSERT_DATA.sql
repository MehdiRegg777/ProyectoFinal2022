/***
     elimina la tabla 
***/

CREATE OR REPLACE PROCEDURE INSERT_DATA /* el nombre del procedure */
AS
uSQL1 VARCHAR(100);
uSQL2 VARCHAR(100);


BEGIN
    execute immediate  'INSERT INTO naves  VALUES (1,''Light Hunter'', 3000, 0, 50,400,null,80,3,20)';
    execute immediate 'INSERT INTO naves  VALUES (2,''Heavy Hunter'', 6500, 0, 50,1000,null,150,7,30)';
    execute immediate 'INSERT INTO naves  VALUES (3,''Battle Ship'', 45000, 0, 7000,6000,null,1000,45,60)';
    execute immediate 'INSERT INTO naves  VALUES (4,''Armored Ship'', 30000, 0, 15000,8000,null,700,70,75)';
    DBMS_OUTPUT.PUT_LINE('Los datos de la tabla nave han sido insertados');
    execute immediate 'INSERT INTO defensas  VALUES (1,''Missile Launcher'', 2000, 0, 0,200,null,80,5,10)';
    execute immediate 'INSERT INTO defensas  VALUES (2,''Ion Cannon'', 4000, 0, 500,1200,null,250,12,25)';
    execute immediate 'INSERT INTO defensas  VALUES (3,''PLasma Cannon'', 50000, 0, 5000,7000,null,2000,30,50)';
    DBMS_OUTPUT.PUT_LINE('Los datos de la tabla defensas han sido insertados');
END INSERT_DATA;

set SERVEROUTPUT on
CALL INSERT_DATA();