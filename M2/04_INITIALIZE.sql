/***
     Este script, se ejecutará cuando arranque la aplicación, para inicializar los los procedures 1...2...3.
***/
set serveroutput on
create or replace procedure INITIALIZE(reset in numeric)
as
existe int;
begin

select count(*) into existe from all_tables where table_name IN ('PLANETAS','USUARIO','BATALLAS','NAVES','DEFENSAS','PLANETAS_HAS_NAVES','PLANETAS_HAS_DEFENSAS');
if  existe !=7 or reset = 1 then
    DropTable();
    CREAR_TABLA();
    INSERT_DATA();
    DBMS_OUTPUT.PUT_LINE('');
    DBMS_OUTPUT.PUT_LINE('Las tablas han sido creadas o actualizadas correctamente...');
end if;
end INITIALIZE;

