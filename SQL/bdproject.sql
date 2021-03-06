CREATE DATABASE IF NOT EXISTS bdproject1
USE bdproject;

DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) NOT NULL DEFAULT 'promin',
  `password` varchar(45) NOT NULL DEFAULT 'promin',
  PRIMARY KEY (`id`)
);

CREATE TABLE `tiempo` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `tiempo` varchar(5) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `accesorios` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  `fabricante` varchar(25),
  `precio` double,
  PRIMARY KEY (`id`)
);

CREATE TABLE `ope_accesorios` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fecha` date,
  `proyecto` varchar(25),
  `area` varchar(30),
  `zona` varchar(25),
  `maquina` varchar(25),
  `turno` varchar(25),
  `sondaje` varchar(25),
  `accesorios` varchar(25),
  `cantidad` double,
  PRIMARY KEY (`id`)
);

CREATE TABLE `ope_aditivos` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `aditivos` varchar(25),
  `precio` varchar(25),
  `cantidad` varchar(25),
  PRIMARY KEY (`id`)
);

CREATE TABLE `actividades` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `actividad` varchar(45) NOT NULL,
  `tipo` varchar(45) not null,
  `cobrable` varchar(15) NOT NULL,
  `observaciones` varchar(35),
   PRIMARY KEY (`id`)
);

CREATE TABLE `aditivos` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `producto` varchar(45) NOT NULL,
  `envase` varchar(20) NOT NULL,  
  `contenido` varchar(15) NOT NULL,
  `precio` double,
  `fabricante` varchar(25),
  PRIMARY KEY (`id`)
);

CREATE TABLE `vehiculos` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tipo_equipo` varchar(45),
  `numero_placa` varchar(20),
  `marca` varchar(35),
  `fabricante` varchar(35),
  `a�oFabricacion` varchar(5),
  PRIMARY KEY (`id`)
);

CREATE TABLE `cliente` (
`id` int(10) NOT NULL AUTO_INCREMENT,
`nomCliente` varchar(45) not null,
PRIMARY KEY (`id`));

CREATE TABLE `herramientas` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `fecha_ingreso` varchar(10),
  `gr_ingreso` double,
  `descripcion` varchar(25),
  `diametro` varchar(10),
  `numero` int(45),
  `tipo` varchar(20),
  `matriz` varchar(25),
  `marca` varchar(25),
  `precio` double,
  `estadoLlegada` varchar(25),
  `condicionRetorno` varchar(25),
  `fechaRetorno` varchar(10),
  `GR_retorno` double,
  `tipDesgaste` varchar(25),
  `area` varchar(30),
  PRIMARY KEY (`id`)
);

CREATE TABLE `ope_herramientas` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `fecha` varchar(10),
  `proyecto` varchar(25),
  `area` varchar(30),
  `zona` varchar(10),
  `maquina` varchar(25),
  `turno` varchar(6),
  `sondaje` varchar(25),
  `descripcion` varchar(45),
  `diam` varchar(5),
  `numBroca_Tricono` double,
  `tipo` varchar(25),
  `serie` varchar(10),
  `marca` varchar(25),
  `de` double,
  `hasta` double,
  `avance` double,
  `acumBroca` double,
  `estadoBroca` varchar(25),
  `perforista` varchar(45),
    PRIMARY KEY (`id`)
);

CREATE TABLE `ope_valorizaciones`(
`id` int(10) unsigned NOT NULL AUTO_INCREMENT,
`codigo` varchar(30),
`sondaje` varchar(30),
`maquina` varchar(30),
`fin` varchar(20),
`profundidad` double,
`avance` double,
`metrosCo` double,
`horasCo` double,
`materiales` double,
`descuentos` double,
`valor` double,
`fechaEntrega` date,
`fechaAprobacion` date,
`inicioSondaje` date,
`horasCo2` varchar(20),
PRIMARY KEY (`id`)
);

CREATE TABLE `ope_corridasPerf`(
`id` int(10) unsigned NOT NULL AUTO_INCREMENT,
`fecha` date,
`proyecto` varchar(30),
`area` varchar(30),
`zona` varchar(30),
`maquina` varchar(30),
`turno` varchar(30),
`sondaje` double,
`profInicial` double,
`profFinal` double,
`longPerf` double,
`longRecup` double,
`recup` double,
`retorno` double,
`compacto` varchar(2),
`semiCompacto` varchar(2),
`fracturado` varchar(2),
`muyFracturado` varchar(2),
`vacios` varchar(2),
    PRIMARY KEY (`id`)
);


CREATE TABLE `ope_combustibles` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fecha` date,
  `tipoEquipo` varchar(30),
  `codigo` varchar(45),
  `tipCombustible` varchar(25),
  `proveedor` varchar(20),
  `docIngreso` varchar(15),
  `cantidadIngreso` double,
  `HorKilIni` double,
  `HorKilFin` double,
  `consumo` varchar(20),
  `observaciones` varchar(45),
  `area` varchar(30),
   PRIMARY KEY (`id`)
);

CREATE TABLE `ope_avances` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `fecha` varchar(10),
  `proyecto` varchar(25),
  `area` varchar(30),
  `zona` varchar(10),
  `maquina` varchar(25),
  `turno` varchar(6),
  `sondaje` varchar(25),
  `diametro` varchar(5),
  `perforista` varchar(25),
  `perfBroca` double,
  `perfTricono` double,
  `avanceTotal` double,
  `recuperacion` double,
  `preCollar` double,
  `profundidad` double,
  `casing` double,
  `hPerf` double,
  `estado` varchar(25),
    PRIMARY KEY (`id`)
);

CREATE TABLE `ope_fluidos` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `fecha` varchar(10),
  `proyecto` varchar(25),
  `area` varchar(30),
  `zona` varchar(10),
  `maquina` varchar(25),
  `turno` varchar(6),
  `sondaje` varchar(25),
  `aditivo` varchar(5),
  `cantidad` double,
    PRIMARY KEY (`id`)
);

CREATE TABLE `ope_tiempos` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `fecha` varchar(10),
  `proyecto` varchar(25),
  `area` varchar(30),
  `zona` varchar(10),
  `maquina` varchar(25),
  `turno` varchar(6),
  `sondaje` varchar(25),
  `actividad` varchar(45),
  `horas` double,
    PRIMARY KEY (`id`)
);

CREATE TABLE `ope_ConsumoAgua` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `fecha` date,
  `proyecto` varchar(25),
  `area` varchar(20),
  `zona` varchar(20),
  `maquina` varchar(25),
  `turno` varchar(6),
  `sondaje` varchar(25),
  `puntoCarguioBombeo` varchar(45),
  `volumenGls` double,
    PRIMARY KEY (`id`)
);

CREATE TABLE `maquinaria` (
`id` int(10) NOT NULL AUTO_INCREMENT,
`modelo` varchar(45),
`num_maquina` varchar(45),
`marca` varchar(45),
`fabricante` varchar(45),
`a�o_fabricacion` varchar(45) NOT NULL,
`hp_motor` double,
`rpm_motor` double,
`capacidad_pq` double,
`capacidad_hq` double,
`capacidad_nq` double,
`capacidad_bq` double,
`montado_sobre` varchar(45) NOT NULL,
`peso_maquina` double,
`largo_maquina` double,
`ancho_maquina` double,
`altura_maquina` double,
PRIMARY KEY (`id`));

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
  `fecha_nacimiento` varchar(10),
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

CREATE TABLE `proyectos` (
`id` int(10) NOT NULL AUTO_INCREMENT,
`nomProyecto` varchar(35),
`areaPerforacion` varchar(35),
`zonaPerforacion` varchar(35),
PRIMARY KEY (`id`));

CREATE TABLE `sondajes` (
`id` int(10) NOT NULL AUTO_INCREMENT,
`proyecto` varchar(45),
`codigoSondaje` varchar(45),
`zona` varchar(45),
`inclinacion` varchar(45),
`azimuth` double,
`profProgr` double,
`fechaInicio` varchar(10),
`fechaTermino` varchar(10),
`tipoPerforacion` varchar(35) NOT NULL,
PRIMARY KEY (`id`));


INSERT INTO `tiempo`(`Tiempo`) values ('Dia');
INSERT INTO `tiempo`(`Tiempo`) values ('Tarde');
INSERT INTO `tiempo`(`Tiempo`) values ('Noche');

INSERT INTO `login` (`id`,`usuario`,`password`) VALUES
 (1,'promin','promin');

//****************************Aditivos*****************************

INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Aceite Vegetal            ', 'BALDE', '5 glns. ', '0', '        ');		
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('AquaClear PFD             ', 'LATA ', '5 glns. ', '233.5', 'Baroid  ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('AquaSopht                 ', 'SACO ', '15 kls. ', '39',	'Baroid  ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Aus Gel Xtra              ', 'BOLSA', '25 kg.  ', '13.23',	'AMC     ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Black Fury                ', 'BALDE', '5 glns. ', '122.45',	'MI SWACO');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Baritina                  ', 'SACO ', '100 lbs.', '13.2',	'        ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Barolift                  ', 'SACO ', '15 lbs. ', '41.5',	'Baroid  ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Baroseal                  ', 'SACO ', '40 lbs. ', '33', 'Baroid  ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Bentogel Ll               ', 'SACO ', '100 lbs.', '6.6',	'Baroid  ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Bore Gel                  ', 'SACO ', '50 lbs. ', '17.25',	'Baroid  ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Boretex                   ', 'SACO ', '50 lbs. ', '96.8', 'MI SWACO');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Cemento                   ', 'SACO ', '        ', '0', '        ');			
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Clear Mud L               ', 'BIDON', '5 glns. ', '91.7',	'MDF     ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Clear Mud P               ', 'SACO ', '20 kls. ', '170',	'MDF     ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Con Det                   ', 'LATA ', '5 glns. ', '70',	'Baroid  ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Corelube                  ', 'BALDE', '25 lbs. ', '63.25',	'Baroid  ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Cotton Seed               ', 'SACO ', '40 lbs. ', '13.2',	'MI SWACO');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('CPH                       ', 'LATA ', '15 kls. ', '43',	'Baroid  ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Dinomul                   ', 'LATA ', '5 glns. ', '149',	'Baroid  ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Drill Grease              ', 'BIDON', '5 glns. ', '140',	'MDF     ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Drilling Detergent        ', 'BALDE', '5 glns. ', '66.7',	'MI SWACO');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Drilling Paper            ', 'SACO ', '30 lbs. ', '46.25',	'MI SWACO');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Drillplex HDD             ', 'SACO ', '25 lbs. ', '112.7',	'MI SWACO');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Drispac Liquido           ', 'BALDE', '5 glns. ', '195.5',	'MI SWACO');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('EZ Mud DP                 ', 'LATA ', '20 lbs. ', '115',	'Baroid  ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('EZ Mud DP (saco)          ', 'SACO ', '50 lbs. ', '215',	'Baroid  ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Ez Mud Plus               ', 'LATA ', '5 glns. ', '107',	'Baroid  ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('EZ Seal                   ', 'LATA ', '50 lbs. ', '14',	'Baroid  ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Gel 3/8                   ', 'SACO ', '50 lbs. ', '17',	'Baroid  ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Geo Gel Xtra              ', 'BOLSA', '50 lbs.', '15', 'MDF      ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Hibtrol                   ', 'BALDE', '15 kls.', '151.8', 'MI SWACO ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Hole Plug 3/8             ', 'BOLSA', '	  ', '17', '         ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('IDP-214                   ', 'LATA ', '35 lbs.', '94', 'Baroid   ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('IDP-387                   ', 'LATA ', '50 lbs.', '9', 'Baroid   ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Jabon Potasico            ', 'BALDE', '	  ', '76.2', 'MDF      ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Kla-Gard                  ', 'BALDE', '5 glns.', '124.4', 'MI SWACO ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Kwik Plug 3/8             ', 'SACO ', '50 lbs.', '15.8', 'MI SWACO ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Kwik Plug Chips Medium 3/8', 'SACO ', '50 lbs.', '24.2', 'MI SWACO ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Liquid Pac                ', 'BALDE', '5 glns.', '160.77', 'MI SWACO ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Liquid Pac-Trol           ', 'BALDE', '5 glns.', '156', 'MDF      ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Liquitrol                 ', 'LATA ', '5 glns.', '176', 'Baroid   ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Magic Seal                ', 'SACO ', '12 kls.', '11', 'MDF      ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Magma Fiber Fine          ', 'SACO ', '25 lbs.', '69.6', 'MDF      ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Magma Fiber Fine MI       ', 'SACO ', '25 lbs.', '74.75', 'MI SWACO ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Magma Fiber Reg MI        ', 'SACO ', '30 lbs.', '74.75', 'MI SWACO ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Magma Fiber Regular       ', 'SACO ', '30 lbs.', '65.7', 'MDF      ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Max Gel                   ', 'SACO ', '50 lbs.', '13.2', 'MI SWACO ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('MDF Aqua Guar             ', 'BALDE', '5 glns.', '127.8', 'MDF      ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('MDF Detergent             ', 'BIDON', '5 glns.', '79.9', 'MDF      ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('MDF Disper-Thin           ', 'BALDE', '5 glns.', '113.3', 'MDF      ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('MDF M-Lube                ', 'BALDE', '5 glns.', '106.85', 'MDF      ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('MDF PH Plus               ', 'BALDE', '20 kls.', '46', 'MDF      ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('M-I Seal                  ', 'SACO ', '40 lbs.', '48.85', 'MI SWACO ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Mica                      ', 'SACO ', '50 lbs.', '45.4', 'MI SWACO ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Mine Gel                  ', 'SACO ', '50 lbs.', '10.3', 'MI SWACO ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('New Drill                 ', 'BIDON', '5 glns.', '91.7', 'MDF      ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('No Sag                    ', 'CAJA ', '20 lbs.', '66', 'Baroid   ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('N-Seal                    ', 'SACO ', '30 lbs.', '74.75', 'Baroid   ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Pac Trol RD               ', 'BOLSA', '15 kls.', '165', 'MDF      ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Penetrol                  ', 'LATA ', '5 glns.', '86.5', 'Baroid   ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('PH Control                ', 'BALDE', '5 glns.', '51.75', 'MI SWACO ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Platinum Pac              ', 'BALDE', '15 kls.', '163.3', 'MI SWACO ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Poly Pac UL               ', 'BALDE', '15 kls.', '166.65', 'MI SWACO ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Poly Plus 2000            ', 'BALDE', '5 glns.', '173', 'MI SWACO ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Poly Plus L               ', 'BALDE', '5 glns.', '95.45', 'MI SWACO ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Poly Plus RD              ', 'BALDE', '15 kls.', '155.25', 'MI SWACO ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Poly Swell                ', 'BALDE', '5 glns.', '195.5', 'MI SWACO ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Poly-Bore                 ', 'BALDE', '14 lbs.', '69',	'Baroid  ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Potassium Chloride        ', 'BOLSA', '       ', '36',	'MDF     ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Power Clean               ', 'BALDE', '5 glns.', '74.75',	'MI SWACO');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Quik Foam                 ', 'LATA ', '5 glns.', '101',	'Baroid  ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Quik Gel                  ', 'SACO ', '50 lbs.', '15',	'Baroid  ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Quik Gel Gold             ', 'SACO ', '50 lbs.', '15.1',	'Baroid  ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Quik Trol                 ', 'LATA ', '20 lbs.', '103.5',	'Baroid  ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Quik Trol Gold            ', 'BALDE', '20 lbs.', '117.3',	'Baroid  ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Ring Free                 ', 'BALDE', '5 glns.', '125.9',	'MI SWACO');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Rod Coat B 700            ', 'BALDE', '5 glns.', '143.75',	'MI SWACO');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Rod Lube N                ', 'BALDE', '5 glns.', '113.25',	'MI SWACO');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Sika                      ', '     ', '       ', '0',	'        ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Super Foam                ', 'BALDE', '5 glns.', '109.8',	'MI SWACO');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Super Seal 3/8"           ', 'BOLSA', '50 lbs.', '18.28',	'MDF     ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Threadtex                 ', 'BALDE', '40 lbs.', '265.45',	'TEXACO  ');
INSERT INTO `aditivos` (`producto`, `envase`, `contenido`, `precio`, `fabricante`) VALUES ('Tricaliper II             ', 'SACO ', '50 lbs.', '95.5',	'Baroid  ');