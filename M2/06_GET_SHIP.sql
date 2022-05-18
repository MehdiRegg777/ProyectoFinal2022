/***
     Este scripts contendrán los procedures necesarios para cargar los datos de las naves.
***/
create or replace procedure GET_SHIP (
s_id in naves.id_ship%TYPE, 
s_nombre out naves.nombre%TYPE,
s_metal out naves.metal_cost%TYPE, 
s_crystal out naves.crystal_cost%TYPE, 
s_deuterium out naves.deuterium_cost%TYPE,
s_initial out naves.InitialArmor%TYPE, 
s_armor out naves.armor%TYPE, 
s_base out naves.BaseDamage%TYPE,
s_speed out naves.speed%TYPE, 
s_generate out naves.Generate_Wastings%TYPE)
as

begin

   select nombre, metal_cost, crystal_cost, deuterium_cost, InitialArmor, armor, BaseDamage,speed, generate_wastings
   into s_nombre, s_metal, s_crystal, s_deuterium, s_initial, s_armor, s_base, s_speed, s_generate from naves
   where id_ship = s_id;
   
END GET_SHIP;

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
GET_SHIP(1,s_nombre,s_metal,s_crystal,s_deuterium,s_initial,s_armor,s_base,s_speed,s_generate);
DBMS_OUTPUT.PUT_LINE(s_nombre ||' '|| s_metal ||' ' || s_crystal ||' ' || s_deuterium ||' ' || s_initial ||' ' || s_armor ||' ' || s_base ||' ' || s_speed ||' ' || s_generate);
end;