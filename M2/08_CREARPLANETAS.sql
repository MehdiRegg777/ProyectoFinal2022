create or replace procedure crearplaneta(nombre1 in varchar, before_ta out int, before_td out int,before_m out int,before_d out int,inicialmetal in int, iniciarDeuterium in int)
as
cantidad int;
begin
select count(*)into cantidad from planetas;
if cantidad = 1 then
select technology_attack, technology_defense,metal, deuterium into before_ta , before_td, before_m,before_d from planetas where id_planetas = 1;
else
insert into planetas values (1,nombre1,0,0,0,inicialmetal,iniciarDeuterium,1);
end if;

end crearplaneta;

