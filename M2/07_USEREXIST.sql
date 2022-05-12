create or replace procedure USEREXIST(username in VARCHAR, password in varchar,id out integer)
as
begin
select id_user into id from usuario where username = username and password = password;
exception
when others then
id :=0;
end USEREXIST;

declare
elpepe int;
begin
userexist('losreyes','P@sasas', elpepe);
DBMS_OUTPUT.PUT_LINE(elpepe);
end;