USE DB_ProyectoHospital;

-- CRUD ADMINISTRADOR

DELIMITER $$
CREATE PROCEDURE sp_agregarAdministrasdor(IN idAdministrador INT, IN nombreAdmin VARCHAR(32), IN apellidoAdmin VARCHAR(32), IN contraseñaAdmin VARCHAR(32))
BEGIN
	INSERT INTO Administrador(idAdministrador,nombreAdmin,apellidoAdmin,contraseñaAdmin)
		values(idAdministrador,nombreAdmin,apellidoAdmin,contraseñaAdmin);
END$$
DELIMITER ;

CALL sp_agregarAdministrasdor(0001,'admin','admin','pass123');


CREATE VIEW vw_listarAdministradores AS
SELECT idAdministrador,nombreAdmin,apellidoAdmin,contraseñaAdmin
FROM Administrador;

SELECT * FROM vw_listarAdministradores;

DELIMITER $$
CREATE PROCEDURE sp_actualizarAdministrador(IN idAdministradorBusqueda INT, IN nuevoNombreAdmin VARCHAR(32), IN nuevoApellidoAdmin VARCHAR(32), IN nuevaContraseñaAdmin VARCHAR(32))
BEGIN
	UPDATE Administrador
	SET nombreAdmin = nuevoNombreAdmin, apellidoAdmin = nuevoApellidoAdmin, contraseñaAdmin = nuevaContraseñaAdmin
	WHERE idAdministrador = idAdministradorBusqueda;
END$$
DELIMITER ;

CALL sp_actualizarAdministrador(0001,'admin1','admin1','passNew');

DELIMITER $$
CREATE PROCEDURE sp_eliminarAdministrador(IN idAdministradorBorrar INT(4))
BEGIN
	DELETE FROM Administrador
    WHERE idAdministrador = idAdministradorBorrar;
END$$
DELIMITER ;

CALL sp_eliminarAdministrador(0001);

DELIMITER $$
CREATE PROCEDURE sp_buscarAdministrador(IN idAdministradorBuscar INT(4))
BEGIN
	SELECT idAdministrador,nombreAdmin,apellidoAdmin,contraseñaAdmin FROM Administrador
    WHERE idAdministrador = idAdministradorBuscar;
END$$
DELIMITER ;

CALL sp_buscarAdministrador(0001);

-- FIN DEL CRUD

-- PROCEDIMIENTO QUE ACTUALIZA EL "ID DE LOGIN" DE ADMINISTRADOR
DELIMITER $$
CREATE PROCEDURE sp_actualizarAdministradorCodigo(IN idAdministradorCodigo INT(4))
BEGIN
	UPDATE Administrador
	SET codigoLogin = FLOOR(((9999 - 0001) * RAND() + 1))
	WHERE idAdministrador = idAdministradorCodigo;
END$$
DELIMITER ;

CALL sp_actualizarAdministradorCodigo(0001);

-- SELECT * FROM Administrador;

-- CRUD de Doctores
