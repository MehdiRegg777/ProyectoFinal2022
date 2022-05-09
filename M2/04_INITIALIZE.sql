set serveroutput on
create or replace procedure INITIALIZE(reset in numeric)
as
existe int;
begin

select count(*) into existe from sys.catalog where TNAME IN ('PLANETAS','USUARIO','BATALLAS','NAVES','DEFENSAS','PLANETAS_HAS_NAVES','PLANETAS_HAS_DEFENSAS');

if existe != 7 or reset = 1 then
    DropTable();
    CREAR_TABLA();

else
    DBMS_OUTPUT.PUT_LINE('Las tablas ya han sido creadas');
end if;
end INITIALIZE;

set SERVEROUTPUT on
CALL INITIALIZE(1);

