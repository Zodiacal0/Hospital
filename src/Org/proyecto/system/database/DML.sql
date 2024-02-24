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


/* 	PROCEDIMIENTO PARA LA VALIDADCION DE LA ELIMINACIÓN DE DOCTOR*/

DELIMITER $$
CREATE PROCEDURE sp_validacionD(IN pass VARCHAR (32))
BEGIN
	SELECT COUNT(*)
    FROM Administrador
	WHERE contraseñaAdmin = pass;
END$$
DELIMITER ;

-- FIN DEL CRUD


DELIMITER $$
CREATE PROCEDURE sp_validacion(IN userAdmin VARCHAR(32), IN pass VARCHAR (32))
BEGIN
	SELECT COUNT(*)
    FROM Administrador
	WHERE nombreAdmin = userAdmin AND contraseñaAdmin = pass;
END$$
DELIMITER ;

CALL sp_validacion('admin','pass123');

DELIMITER $$
CREATE PROCEDURE sp_validacionAdminPass(IN pass VARCHAR (32))
BEGIN
	SELECT COUNT(*)
    FROM Administrador
	WHERE contraseñaAdmin = pass;
END$$
DELIMITER ;

DELIMITER $$
	CREATE TRIGGER tr_Administrador_After_Update
	AFTER UPDATE ON Administrador
	FOR EACH ROW
		BEGIN
			UPDATE Administrador
			SET codigoLogin = FLOOR(((9999 - 0001) * RAND() + 1))
			WHERE idAdministrador = idAdministradorCodigo;
		END $$
delimiter ; 


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
DELIMITER $$
CREATE PROCEDURE sp_agregarDoctor(IN idDoctor INT (4), IN nombreDoctor VARCHAR(32),IN apellidoDoctor VARCHAR(32),IN especialidad VARCHAR(32), IN sexo CHAR,IN edad INT(2),IN telefono INT(8),IN contraseña VARCHAR(32))
BEGIN
	INSERT INTO Doctor(idDoctor,nombreDoctor,apellidoDoctor,especialidad,edad,telefono,sexo,contraseña)
		VALUES(idDoctor,nombreDoctor,apellidoDoctor,especialidad,edad,telefono,sexo,contraseña);
END$$
DELIMITER ;

CALL sp_agregarDoctor(0002,'Rafael','Córdoba','Urología','M','24',12345678,'pass123');

CREATE VIEW vw_listarDoctores AS
SELECT nombreDoctor,apellidoDoctor,especialidad,telefono,edad,sexo,contraseña
FROM Doctor;	

SELECT * FROM vw_listarDoctores;
select * from Doctor;
DELIMITER $$
CREATE PROCEDURE sp_actualizarDoctores(IN idDoctorBusqueda INT (4), IN newNombreDoctor VARCHAR(32),IN newApellidoDoctor VARCHAR(32),IN newEspecialidad VARCHAR(32),IN newEdad INT(2),IN newTelefono INT(8),IN newContraseña VARCHAR(32))
BEGIN
	UPDATE Doctor
    SET nombreDoctor = newNombreDoctor, apellidoDoctor = newApellidoDoctor, especialidad = newEspecialidad, edad = newEdad, telefono = newTelefono, contraseña = newContraseña
    WHERE idDoctor = idDoctorBusqueda;
END$$
DELIMITER ;

CALL sp_actualizarDoctores(0001,'Javier','Córdoba','Neurología','27',23456789,'dispo');

-- !!!DUDA

DELIMITER $$
CREATE PROCEDURE sp_eliminarDoctor(IN idDoctorEliminar INT(4), IN nombreDoctor VARCHAR(32))
BEGIN
	DELETE FROM Doctor
	WHERE idDoctor = idDoctorEliminar AND nombreDoctor = nombreDoctor;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE sp_buscarDoctor(IN idDoctorBusqueda INT(4))
BEGIN
	SELECT nombreDoctor,apellidoDoctor,especialidad,contraseña,sexo,edad,telefono
    FROM Doctor
	WHERE idDoctor = idDoctorBusqueda;
END$$
DELIMITER ;


--  CRUD completo pacientes

DELIMITER $$
CREATE PROCEDURE sp_crearPaciente(IN idPaciente INT(4), IN nombrePaciente VARCHAR(32), IN apellidoPaciente VARCHAR(32), IN edad INT(2),IN sexo CHAR,IN contraseña VARCHAR(32))
BEGIN
	INSERT INTO Pacientes(idPaciente,nombrePaciente,apellidoPaciente,edad,sexo,contraseña)
		VALUES(idPaciente,nombrePaciente,apellidoPaciente,edad,sexo,contraseña);
END$$
DELIMITER ;
 
 CALL sp_crearPaciente(0001,'Erick','Toyom',26,'M','wbos');
 
 DELIMITER $$
 CREATE PROCEDURE sp_listarPaciente()
 BEGIN
	SELECT idPaciente,nombrePaciente,apellidoPaciente,edad,sexo,contraseña
    FROM Pacientes;
 END$$
 DELIMITER ;
 
 CALL sp_listarPaciente();
 
 DELIMITER $$
 CREATE PROCEDURE sp_actualizarPaciente(IN idPacienteActualizar INT(4), IN newNombrePaciente VARCHAR(32), IN newApellidoPaciente VARCHAR(32), IN newEdad INT(2),IN newContraseña VARCHAR(32))
 BEGIN
	UPDATE Pacientes
    SET nombrePaciente = newNombrePaciente, apellidoPaciente = newApellidoPaciente, edad = newEdad, contraseña = newContraseña
    WHERE idPaciente = idPacienteActualizar;
 END$$ 
 DELIMITER ;
 
 CALL sp_actualizarPaciente(0001,'ERICK','CAMBIÓ',36,'wbosNEW');
 
 DELIMITER $$
 CREATE PROCEDURE sp_buscarPaciente(IN idPaciente INT(4))
 BEGIN
	SELECT idPaciente,nombrePaciente,apellidoPaciente,edad,sexo,contraseña
    FROM Pacientes
    WHERE idPaciente = idPaciente;
 END$$
 DELIMITER ;
 
 CALL sp_buscarPaciente(0001);
 
 DELIMITER $$
 CREATE PROCEDURE sp_eliminarPaciente(IN idPaciente INT(4))
 BEGIN
	DELETE FROM Pacientes
	WHERE idPaciente = idPaciente;
 END$$
 DELIMITER ;
 
 CALL sp_eliminarPaciente(0001);
 
