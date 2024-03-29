DROP DATABASE IF EXISTS DB_ProyectoHospital;
CREATE DATABASE DB_ProyectoHospital;
USE DB_ProyectoHospital;

CREATE TABLE Administrador(
	idAdministrador INT(4) NOT NULL,
    nombreAdmin VARCHAR(32),
    apellidoAdmin VARCHAR(32),
    contraseñaAdmin VARCHAR(32),
    codigoLogin INT(4),
    PRIMARY KEY PK_idAdministrador (idAdministrador)
)ENGINE InnoDB;

CREATE TABLE Medicina(
	idMedicina INT(4),
    nombreMedicina VARCHAR(32),
    cantidad INT(4),descripcion VARCHAR(255),
    precio DECIMAL(10,2),
    PRIMARY KEY PK_idMedicina (idMedicina)
)ENGINE InnoDB;

CREATE TABLE Doctor(
	idDoctor INT(4) NOT NULL,
    nombreDoctor VARCHAR(32),
    apellidoDoctor VARCHAR(32),
    especialidad VARCHAR(32),
    contraseña VARCHAR(32),
    sexo CHAR,
    edad INT(2),
    telefono INT(8),
    PRIMARY KEY PK_idDoctor (idDoctor)
)ENGINE InnoDB;

CREATE TABLE Citas(
	idCita INT(4),
    motivo VARCHAR(255),
    especialidadRequerida VARCHAR(32),
    doctorRequerido VARCHAR(32),
    fecha date,
    hora time,
    estado VARCHAR(32),
    PRIMARY KEY PK_idCita (idCita)    
)ENGINE InnoDB;

CREATE TABLE Pacientes(
	idPaciente INT(4) NOT NULL,
    nombrePaciente  VARCHAR(32),
    apellidoPaciente VARCHAR(32),
    edad INT(2),
    sexo CHAR,
    contraseña VARCHAR(32),
    idCita INT(4),
    PRIMARY KEY PK_idPaciente (idPaciente),
    CONSTRAINT FK_idCita FOREIGN KEY (idCita) 
		REFERENCES Citas (idCita)
)ENGINE InnoDB;

