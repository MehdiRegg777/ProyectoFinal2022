create or replace procedure GET_DEFENSE (
s_id in defensas.id_defense%TYPE, 
s_nombre out defensas.nombre%TYPE,
s_metal out defensas.metal_cost%TYPE, 
s_crystal out defensas.crystal_cost%TYPE, 
s_deuterium out defensas.deuterium_cost%TYPE,
s_initial out defensas.InitialArmor%TYPE, 
s_armor out defensas.armor%TYPE, 
s_base out defensas.BaseDamage%TYPE,
s_speed out defensas.speed%TYPE, 
s_generate out defensas.Generate_Wastings%TYPE)
as

begin

   select nombre, metal_cost, crystal_cost, deuterium_cost, InitialArmor, armor, BaseDamage,speed, generate_wastings
   into s_nombre, s_metal, s_crystal, s_deuterium, s_initial, s_armor, s_base, s_speed, s_generate from defensas
   where id_defense = s_id;
   
END GET_DEFENSE;

set SERVEROUTPUT on
declare
s_nombre VARCHAR(40);
s_metal int;
s_crystal int;
s_deuterium int;
s_initial int;
s_armor INT;
s_base int;
s_speed int;
s_generate int;
BEGIN
GET_DEFENSE(1,s_nombre,s_metal,s_crystal,s_deuterium,s_initial,s_armor,s_base,s_speed,s_generate);
DBMS_OUTPUT.PUT_LINE(s_nombre ||' '|| s_metal ||' ' || s_crystal ||' ' || s_deuterium ||' ' || s_initial ||' ' || s_armor ||' ' || s_base ||' ' || s_speed ||' ' || s_generate);
end;