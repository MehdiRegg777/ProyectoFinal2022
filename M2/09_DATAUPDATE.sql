create or replace procedure dataupdate(metal_ in int, deuterium_ in int, tca in int, tcd in int)
as
begin
update planetas set technology_attack = tca, technology_defense = tcd, metal = metal_, deuterium = deuterium_ where id_planetas = 1;
end dataupdate;
