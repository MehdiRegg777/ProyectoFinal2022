create or replace procedure USEREXIST1(username_ in VARCHAR, password_ in varchar,id out integer)
as
begin
select id_user into id from usuario where username = username_ and password = password_;

exception
when others then
id :=0;
end USEREXIST1;