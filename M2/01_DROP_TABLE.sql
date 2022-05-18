/***
     elimina la tabla.
***/

CREATE OR REPLACE PROCEDURE DropTable /* el nombre del procedure */
AS
uSQL1 VARCHAR(100);
uSQL2 VARCHAR(100);
uSQL3 VARCHAR(100);
uSQL4 VARCHAR(100);
uSQL5 VARCHAR(100);
uSQL6 VARCHAR(100);
uSQL7 VARCHAR(100);

BEGIN
    uSQL1 := 'DROP TABLE batallas';
    uSQL2 := 'DROP TABLE planetas_has_naves';
    uSQL3 := 'DROP TABLE planetas_has_defensas';
    uSQL4 := 'DROP TABLE planetas';
    uSQL5 := 'DROP TABLE naves';
    uSQL6 := 'DROP TABLE defensas';
    uSQL7 := 'DROP TABLE usuario';

  EXECUTE IMMEDIATE uSQL1;
    DBMS_OUTPUT.PUT_LINE ('Table batallas ha sido eliminado.');
  EXECUTE IMMEDIATE uSQL2;
    DBMS_OUTPUT.PUT_LINE ('Table planetas_has_naves ha sido eliminado.');
  EXECUTE IMMEDIATE uSQL3;
    DBMS_OUTPUT.PUT_LINE ('Table planetas_has_defensas ha sido eliminado.');
  EXECUTE IMMEDIATE uSQL4;
    DBMS_OUTPUT.PUT_LINE ('Table planetas ha sido eliminado.');
  EXECUTE IMMEDIATE uSQL5;
    DBMS_OUTPUT.PUT_LINE ('Table naves ha sido eliminado.');
  EXECUTE IMMEDIATE uSQL6;
    DBMS_OUTPUT.PUT_LINE ('Table defensas ha sido eliminado.');
  EXECUTE IMMEDIATE uSQL7;
    DBMS_OUTPUT.PUT_LINE ('Table usuario ha sido eliminado.');
  exception
    when others then
    DBMS_OUTPUT.PUT_LINE ('Tabla de las tablas no existe.');
END DropTable;