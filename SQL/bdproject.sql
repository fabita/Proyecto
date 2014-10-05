CREATE DATABASE IF NOT EXISTS bdproject;
USE bdproject;

DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) NOT NULL DEFAULT 'promin',
  `password` varchar(45) NOT NULL DEFAULT 'promin',
  PRIMARY KEY (`id`)
);

CREATE TABLE `vehiculos` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tipo_equipo` varchar(45) NOT NULL,
  `numero_placa` varchar(20) NOT NULL,
  `marca` varchar(35) NOT NULL,
  `fabricante` varchar(35) NOT NULL,
  `ano_fabricacion` int(4) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `aditivos` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `producto` varchar(45) NOT NULL,
  `fabricante` varchar(25),
  `envase` varchar(20) NOT NULL,
  `contenido` varchar(15) NOT NULL,
  `precio` double,
  PRIMARY KEY (`id`)
);

CREATE TABLE `accesorios` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  `fabricante` varchar(25),
  `precio` double,
  PRIMARY KEY (`id`)
);

CREATE TABLE `personal` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `codigo_empresa` int(15) NOT NULL,
  `DNI` int(8) NOT NULL,
  `nombres` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `Cargo_Proyecto` varchar(45) NOT NULL,
  `brevete` varchar(15),
  `fotocheck_minero` varchar(45),
  `vencimiento_fotocheck` varchar(45),
  `IPSS` varchar(45) NOT NULL,
  `tip_Sangre` varchar(45),
  `fecha_nacimiento` varchar(45),
  `dpto_nacimiento` varchar(45),
  `dpto_residencia` varchar(45),
  `direccion` varchar(45),
  `tel_fijo` int(45),
  `celular` int(45),
  `email` varchar(45),
  `tel_emergencia` int(45),
  `persona_contact` varchar(45),
  `relacion_contact` varchar(45),
  PRIMARY KEY (`id`)
);
INSERT INTO `login` (`id`,`usuario`,`password`) VALUES
 (1,'promin','promin');





