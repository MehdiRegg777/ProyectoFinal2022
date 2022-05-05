DROP TABLE usuario;
DROP TABLE planetas;
DROP TABLE batallas;
DROP TABLE naves;
DROP TABLE defensas;
DROP TABLE planetas_has_naves;
DROP TABLE planetas_has_defensas;

CREATE PROCEDURE dbo.CrearTabla usuario
AS

DECLARE @sql nvarchar(300);

IF OBJECT_ID(@tabla, 'U') IS NOT NULL
BEGIN
    SET @sql = N'DROP TABLE ' + QUOTENAME(@Tabla);
    EXECUTE sp_executesql @sql;
END