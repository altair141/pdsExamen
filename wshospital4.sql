-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 09-09-2015 a las 19:33:00
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `wshospital4`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actividad`
--

CREATE TABLE IF NOT EXISTS `actividad` (
  `id` int(10) NOT NULL COMMENT 'identificador actividad medica',
  `tipoActividad` varchar(255) NOT NULL COMMENT 'nombre de la actividad medica',
  `idDiagnostico` int(10) NOT NULL COMMENT 'clave foránea diagnostico-actividad',
  PRIMARY KEY (`id`),
  KEY `FKactividad155576` (`idDiagnostico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='actividad médica';

--
-- Volcado de datos para la tabla `actividad`
--

INSERT INTO `actividad` (`id`, `tipoActividad`, `idDiagnostico`) VALUES
(1, 'actividad1DiagnosticoA', 1),
(2, 'actividad2DiagnosticoA', 1),
(3, 'actividad3DiagnosticoA', 1),
(4, 'actividad4DiagnosticoA', 1),
(5, 'actividad1DiagnosticoB', 2),
(6, 'actividad2DiagnosticoB', 2),
(7, 'actividad3DiagnosticoB', 2),
(8, 'actividad4DiagnosticoB', 2),
(9, 'actividad1DiagnosticoC', 3),
(10, 'actividad2DiagnosticoC', 3),
(11, 'actividad3DiagnosticoC', 3),
(12, 'actividad1DiagnosticoD', 4),
(13, 'actividad2DiagnosticoD', 4),
(14, 'actividad1DiagnosticoE', 5),
(15, 'actividad2DiagnosticoE', 5),
(16, 'actividad1DiagnosticoF', 6),
(17, 'actividad2DiagnosticoF', 6),
(18, 'actividad1DiagnosticoG', 7),
(19, 'actividad2DiagnosticoG', 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `box`
--

CREATE TABLE IF NOT EXISTS `box` (
  `idHabitacion` int(10) NOT NULL COMMENT 'identificador del box',
  `nroHabitacion` varchar(30) NOT NULL COMMENT 'número de la habitación',
  PRIMARY KEY (`idHabitacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='habitación del hospital';

--
-- Volcado de datos para la tabla `box`
--

INSERT INTO `box` (`idHabitacion`, `nroHabitacion`) VALUES
(1, '12-4');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `certificado`
--

CREATE TABLE IF NOT EXISTS `certificado` (
  `id` int(10) NOT NULL COMMENT 'identificador del certificado',
  `tipoCertificado` varchar(255) NOT NULL COMMENT 'tipo de certificado',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='certificados';

--
-- Volcado de datos para la tabla `certificado`
--

INSERT INTO `certificado` (`id`, `tipoCertificado`) VALUES
(1, 'si Alcoholemia'),
(2, 'no Alcoholemia'),
(3, 'si V. Intrafamiliar'),
(4, 'no V. Intrafamiliar'),
(5, 'si Drogas'),
(6, 'no Drogas'),
(7, 'si Lesiones'),
(8, 'no Lesiones'),
(9, 'si Suicidio'),
(10, 'no Suicidio'),
(11, 'si Animal'),
(12, 'no Animal'),
(13, 'si Otros ML'),
(14, 'no Otros ML'),
(15, 'si V. Género'),
(16, 'no V. Género'),
(17, 'si Salud Compatible'),
(18, 'no Salud Compatible'),
(19, 'si Atención Diagnóstica'),
(20, 'no Atención Diagnóstica'),
(21, 'si Atención Profesional'),
(22, 'no Atención Profesional'),
(23, 'si Derivación Interna'),
(24, 'no Derivación Interna'),
(25, 'si Citacion a KNT'),
(26, 'no Citacion a KNT'),
(27, 'si Orden Curación'),
(28, 'no Orden Curación'),
(29, 'si Orden Citación'),
(30, 'no Orden Citación');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `diagnostico`
--

CREATE TABLE IF NOT EXISTS `diagnostico` (
  `idDiagnostico` int(10) NOT NULL COMMENT 'identificador del diagnostico',
  `nombre` varchar(255) NOT NULL COMMENT 'nombre del diagnostico',
  PRIMARY KEY (`idDiagnostico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='diagnostico médico';

--
-- Volcado de datos para la tabla `diagnostico`
--

INSERT INTO `diagnostico` (`idDiagnostico`, `nombre`) VALUES
(1, 'diagnosticoA'),
(2, 'diagnosticoB'),
(3, 'diagnosticoC'),
(4, 'diagnosticoD'),
(5, 'diagnosticoE'),
(6, 'diagnosticoF'),
(7, 'diagnosticoG');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `directorhospital`
--

CREATE TABLE IF NOT EXISTS `directorhospital` (
  `id` int(10) NOT NULL COMMENT 'identificador directorhospital',
  `idPersona` int(10) NOT NULL COMMENT 'clave foránea directorHospital-persona',
  PRIMARY KEY (`id`),
  KEY `FKdirectorHo484753` (`idPersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='director del hospital';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialidad`
--

CREATE TABLE IF NOT EXISTS `especialidad` (
  `idEspecialidad` int(10) NOT NULL COMMENT 'identificador especialidad',
  `nombreEspecialidad` varchar(255) NOT NULL COMMENT 'nombre de la especialidad de un médico',
  PRIMARY KEY (`idEspecialidad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='especialidad del médico';

--
-- Volcado de datos para la tabla `especialidad`
--

INSERT INTO `especialidad` (`idEspecialidad`, `nombreEspecialidad`) VALUES
(1, 'medicina general'),
(2, 'pediatra');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hce`
--

CREATE TABLE IF NOT EXISTS `hce` (
  `idHce` int(10) NOT NULL,
  `idPaciente` int(10) NOT NULL,
  PRIMARY KEY (`idHce`),
  KEY `FKhce938722` (`idPaciente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='historial clínico electrónico';

--
-- Volcado de datos para la tabla `hce`
--

INSERT INTO `hce` (`idHce`, `idPaciente`) VALUES
(1, 1),
(2, 2),
(3, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horamedica`
--

CREATE TABLE IF NOT EXISTS `horamedica` (
  `idHora` int(10) NOT NULL COMMENT 'identificador hora medica',
  `idMedico` int(10) NOT NULL COMMENT 'clave foránea horamedica-medico',
  `idBox` int(10) NOT NULL COMMENT 'clave foránea horamedica-box',
  `asp` varchar(5) NOT NULL COMMENT 'hora medica aps o no aps',
  `fecha` datetime NOT NULL COMMENT 'fecha hora medica',
  PRIMARY KEY (`idHora`),
  KEY `FKhoraMedica653351` (`idMedico`),
  KEY `FKhoraMedica451396` (`idBox`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='horas medicas';

--
-- Volcado de datos para la tabla `horamedica`
--

INSERT INTO `horamedica` (`idHora`, `idMedico`, `idBox`, `asp`, `fecha`) VALUES
(1, 1, 1, 'true', '2015-09-04 09:00:00'),
(2, 1, 1, 'false', '2015-09-08 10:00:00'),
(3, 2, 1, 'true', '2015-09-04 09:00:00'),
(4, 2, 1, 'true', '2015-09-06 09:00:00'),
(5, 2, 1, 'false', '2015-09-08 14:00:00'),
(6, 1, 1, 'false', '2015-09-07 16:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medico`
--

CREATE TABLE IF NOT EXISTS `medico` (
  `idMedico` int(10) NOT NULL COMMENT 'identificadorMedico',
  `especialidad` int(10) NOT NULL COMMENT 'clave foránea medico-especialidad',
  `idPersona` int(10) NOT NULL COMMENT 'clave foránea medico-persona',
  PRIMARY KEY (`idMedico`),
  KEY `FKmedico655469` (`especialidad`),
  KEY `FKmedico647483` (`idPersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='médico';

--
-- Volcado de datos para la tabla `medico`
--

INSERT INTO `medico` (`idMedico`, `especialidad`, `idPersona`) VALUES
(1, 1, 2),
(2, 2, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE IF NOT EXISTS `paciente` (
  `idPaciente` int(10) NOT NULL COMMENT 'identificador paciente',
  `nroFichaMedica` varchar(255) NOT NULL COMMENT 'número de ficha medica',
  `idPersona` int(10) NOT NULL COMMENT 'clave foránea persona-paciente',
  PRIMARY KEY (`idPaciente`),
  UNIQUE KEY `nroFichaMedica` (`nroFichaMedica`),
  KEY `FKpaciente532367` (`idPersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='paciente';

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`idPaciente`, `nroFichaMedica`, `idPersona`) VALUES
(1, '141', 1),
(2, '1233', 3),
(3, '345', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE IF NOT EXISTS `persona` (
  `idPersona` int(10) NOT NULL COMMENT 'identificador de la persona',
  `nombre` varchar(30) NOT NULL COMMENT 'nombres de la persona',
  `apellidos` varchar(40) DEFAULT NULL COMMENT 'apellidos de la persona',
  `fechaNacimiento` date DEFAULT NULL COMMENT 'fecha de nacimiento de la persona',
  `direccion` varchar(100) DEFAULT NULL COMMENT 'dirección de la persona',
  `estado` varchar(5) NOT NULL COMMENT 'estado de la persona, activo o no activo',
  `rut` varchar(255) NOT NULL,
  `sexo` varchar(255) NOT NULL,
  PRIMARY KEY (`idPersona`),
  UNIQUE KEY `rut` (`rut`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='persona, ser humano';

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`idPersona`, `nombre`, `apellidos`, `fechaNacimiento`, `direccion`, `estado`, `rut`, `sexo`) VALUES
(1, 'Pablo', 'Salamanca Vera', '1992-12-16', 'Lebu 345', 'true', '181990775', 'M'),
(2, 'walter', 'white', '1973-06-04', 'av.siempre viva 1455', 'true', '091231233', 'M'),
(3, 'altair', 'zakaeb', '1979-09-09', 'av. nunca viva 1234', 'true', '456456456', 'M'),
(4, 'jose', 'villalobos', '1987-09-03', 'av. nunca viva 098', 'true', '123123123', 'M'),
(5, 'john ', 'travolta', '1975-09-12', 'recreo 3455', 'true', '345345345', 'M');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `procedimiento`
--

CREATE TABLE IF NOT EXISTS `procedimiento` (
  `id` int(10) NOT NULL COMMENT 'identificador del proceso medico',
  `tipoProcedimiento` varchar(255) NOT NULL COMMENT 'nombre del procedimiento realizado en el paciente',
  `idDiagnostico` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKprocedimie625288` (`idDiagnostico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='procedimientos médicos';

--
-- Volcado de datos para la tabla `procedimiento`
--

INSERT INTO `procedimiento` (`id`, `tipoProcedimiento`, `idDiagnostico`) VALUES
(1, 'procedimiento1DiagnosticoA', 1),
(2, 'procedimiento2DiagnosticoA', 1),
(3, 'procedimiento3DiagnosticoA', 1),
(4, 'procedimiento4DiagnosticoA', 1),
(5, 'procedimiento1DiagnosticoB', 2),
(6, 'procedimiento2DiagnosticoB', 2),
(7, 'procedimiento3DiagnosticoB', 2),
(8, 'procedimiento4DiagnosticoB', 2),
(9, 'procedimiento1DiagnosticoC', 3),
(10, 'procedimiento2DiagnosticoC', 3),
(11, 'procedimiento3DiagnosticoC', 3),
(12, 'procedimiento4DiagnosticoC', 3),
(13, 'procedimiento1DiagnosticoD', 4),
(14, 'procedimiento2DiagnosticoD', 4),
(15, 'procedimiento3DiagnosticoD', 4),
(16, 'procedimiento4DiagnosticoD', 4),
(17, 'procedimiento1DiagnosticoE', 5),
(18, 'procedimiento2DiagnosticoE', 5),
(19, 'procedimiento1DiagnosticoF', 6),
(20, 'procedimiento2DiagnosticoF', 6),
(21, 'procedimiento3DiagnosticoF', 6),
(22, 'procedimiento1DiagnosticoG', 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rce`
--

CREATE TABLE IF NOT EXISTS `rce` (
  `idRce` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id registro clínico electrónico',
  `tipoEncuentro` varchar(255) NOT NULL COMMENT 'tipo de encuentro',
  `idHce` int(10) NOT NULL COMMENT 'clave foránea hce-rce',
  `idHoraMedica` int(10) NOT NULL COMMENT 'identificar de la hora medica',
  `anamnesis` varchar(255) NOT NULL COMMENT 'anamnesis de del rce, término empleado para referirse a la información proporcionada por el propio paciente\n ',
  `alergia` varchar(255) NOT NULL COMMENT 'alergias que posee el paciente',
  `examenFisico` varchar(255) NOT NULL COMMENT 'datos examen físico del paciente',
  `indicacionMedica` varchar(255) NOT NULL COMMENT 'indicaciones proporcionadas por el médico',
  `indicacionCierreCaso` varchar(255) NOT NULL COMMENT 'indicaciones del médico para cerrar el caso',
  `hipotesisDiagnostico` varchar(255) NOT NULL COMMENT 'hipótesis de cual es la enfermedad que posee el paciente',
  `pacienteGes` varchar(255) NOT NULL COMMENT 'paciente con Garantías Explícitas en Salud',
  `patologiaGes` varchar(255) NOT NULL COMMENT 'enfermedad que garantizada en el AUGE',
  `pacienteCronico` varchar(255) NOT NULL COMMENT 'paciente con enfermedad con un tiempo mayor de seis meses desde que dicha enfermedad fue diagnosticada',
  `tipoCierre` varchar(255) NOT NULL COMMENT 'tipo cierre de caso, representa el estado de la atención recibida por parte del médico',
  `destino` varchar(255) NOT NULL COMMENT 'lugar al cual se derivará el paciente luego de realizar la consulta médica',
  `fechaAtencion` date NOT NULL COMMENT 'fecha de atención médica',
  `horaInicioAtencion` varchar(255) NOT NULL COMMENT 'hora de inicio de la atención medica',
  `fechaCierreClinico` date DEFAULT NULL COMMENT 'fecha de termino del caso clinico',
  `horaCierreClinico` varchar(255) DEFAULT NULL COMMENT 'hora de termino del caso clinico',
  `tiempoControl` varchar(255) NOT NULL COMMENT 'tiempo de seguimiento de controles posteriores',
  PRIMARY KEY (`idRce`),
  KEY `FKrce258372` (`idHce`),
  KEY `FKrce944995` (`idHoraMedica`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='registro clínico electrónico' AUTO_INCREMENT=31 ;

--
-- Volcado de datos para la tabla `rce`
--

INSERT INTO `rce` (`idRce`, `tipoEncuentro`, `idHce`, `idHoraMedica`, `anamnesis`, `alergia`, `examenFisico`, `indicacionMedica`, `indicacionCierreCaso`, `hipotesisDiagnostico`, `pacienteGes`, `patologiaGes`, `pacienteCronico`, `tipoCierre`, `destino`, `fechaAtencion`, `horaInicioAtencion`, `fechaCierreClinico`, `horaCierreClinico`, `tiempoControl`) VALUES
(2, 'CIERRE ADMINISTRATIVO', 1, 1, 'cxzzcxzcx', 'zczxzcxzcx', 'czxczxzcx', 'zcxzcxzcx', 'zcxzcxzcx', 'zcxczxczxczx', 'no', 'si', 'no', 'Con atención', 'Domicilio', '2015-08-12', '12:00', '2015-09-16', '13:00', 'No corresponde'),
(3, 'CIERRE ADMINISTRATIVO', 1, 1, 'dfgdf', 'gdfhfgh', 'dgdfg', 'fghfgh', 'fghfgh', 'fdhfgh', 'no', 'no', 'no', 'Con atención', 'Domicilio', '2015-08-12', '12:00', '2015-09-06', '12:00', 'No corresponde'),
(4, 'CIERRE ADMINISTRATIVO', 1, 1, 'qwetry', 'werwetr', 'sdsdfsd', 'sdfsfdfsd', 'sdfsfdfsd', 'sdfsdfsdsdf', 'si', 'si', 'si', 'Con atención', 'Domicilio', '2015-08-12', '23:00', '2015-09-02', '00:00', 'No corresponde'),
(5, 'CIERRE ADMINISTRATIVO', 1, 1, 'sadasd', 'asdasd', 'asdasd', 'asdasd', 'asdasd', 'asdasd', 'no', 'si', 'no', 'Con atención', 'Domicilio', '2015-08-12', '12:03', '2015-09-07', '23:04', 'No corresponde'),
(6, 'CIERRE ADMINISTRATIVO', 1, 1, 'sdsdf', 'sdfsdf', 'dfsdfsdf', 'sdfsdf', 'sdfsdf', 'sdfsdf', 'no', 'no', 'no', 'Con atención', 'Domicilio', '2015-08-12', '23:04', '2015-09-08', '03:45', 'No corresponde'),
(7, 'CIERRE ADMINISTRATIVO', 1, 1, 'dgdf', 'gdfgdf', 'gdfg', 'fdgdfg', 'fdgdfg', 'dfgdfgdf', 'no', 'no', 'no', 'Con atención', 'Domicilio', '2015-08-12', '04:05', '2015-09-16', '07:05', 'No corresponde'),
(8, 'CIERRE ADMINISTRATIVO', 1, 1, 'dfsdf', 'sfsdf', 'sdf', 'sdfsdf', 'sdfsdf', 'sdfsdfsdf', 'si', 'si', 'si', 'Con atención', 'Domicilio', '2015-08-12', '03:45', '2015-09-15', '05:34', 'No corresponde'),
(9, 'CIERRE ADMINISTRATIVO', 1, 1, 'sdfsdfsd', 'fsdfs', 'fsdf', 'sdfsd', 'sdfsd', 'fsdfsdf', 'no', 'no', 'no', 'Con atención', 'Domicilio', '2015-08-11', '03:04', '2015-09-10', '23:04', 'No corresponde'),
(10, 'CIERRE ADMINISTRATIVO', 1, 1, 'sfsdfs', 'dfsdf', 'sdfsd', 'sdfsdf', 'sdfsdf', 'sdfsdfsdf', 'no', 'no', 'no', 'No se atendio', 'Domicilio', '2015-08-05', '03:45', '2015-09-16', '03:45', 'proxima visita'),
(11, 'CIERRE ADMINISTRATIVO', 1, 1, 'ghjgh', 'jghj', 'ghj', 'ghjgh', 'ghjgh', 'jghjghjg', 'no', 'no', 'no', 'Con atención', 'Domicilio', '2015-08-04', '03:54', '2015-09-08', '04:35', 'No corresponde'),
(12, 'CIERRE ADMINISTRATIVO', 1, 1, 'asdas', 'dasda', 'sdasd', 'dasdas', 'dasdas', 'dasdasd', 'no', 'si', 'no', 'Con atención', 'Domicilio', '2015-08-04', '03:24', '2015-09-08', '03:24', 'No corresponde'),
(13, 'CATEGORIZADO', 1, 1, 'asdasd', 'asdsad', 'sfddsf', 'sdfsdf', 'sdfsdf', 'dsfsdf', 'no', 'si', 'no', 'Con atención', 'Internado', '2015-07-29', '04:35', '2015-09-08', '03:45', 'No corresponde'),
(14, 'CIERRE ADMINISTRATIVO', 1, 1, 'fgdfgdf', 'sddfsd', 'dsfdfsd', 'rdgdfgfd', 'rdgdfgfd', 'dgfd', 'si', 'si', 'si', 'Con atención', 'Domicilio', '2015-08-06', '05:46', '2015-09-15', '04:56', 'No corresponde'),
(15, 'CIERRE ADMINISTRATIVO', 1, 1, 'sdfsdf', 'sdfsdf', 'sdfsdf', 'sfdsfdfsd', 'sfdsfdfsd', 'sfdfsdfsdfsd', 'no', 'no', 'no', 'Con atención', 'Domicilio', '2015-08-05', '03:45', '2015-09-09', '03:45', 'No corresponde'),
(16, 'CIERRE ADMINISTRATIVO', 1, 1, 'sadasd', 'asdasd', 'sdasd', 'asdas', 'asdas', 'dasdasd', 'no', 'no', 'no', 'Con atención', 'Domicilio', '2015-08-06', '06:57', '2015-09-24', '03:45', 'No corresponde'),
(17, 'CIERRE ADMINISTRATIVO', 1, 1, 'dsfsdf', 'sfdsdfsdf', 'sdfsdf', 'dfsdfsdf', 'dfsdfsdf', 'sdfsdfsfd', 'no', 'no', 'no', 'No se atendio', 'Domicilio', '2015-08-05', '03:04', '2015-09-23', '03:45', 'proxima visita'),
(18, 'CIERRE ADMINISTRATIVO', 1, 1, 'dfdfgdfg', 'dfgdfgd', 'fgdfg', 'dfgdfg', 'dfgdfg', 'dfgdfg', 'no', 'si', 'no', 'Con atención', 'Domicilio', '2015-08-09', '06:08', '2015-09-06', '04:56', 'No corresponde'),
(19, 'CIERRE ADMINISTRATIVO', 1, 1, 'weqeqweqwe', 'qweqweqweqw', 'eqweqwe', 'dasdasdas', 'dasdasdas', 'daqweqweqwe', 'no', 'no', 'no', 'No se atendio', 'Domicilio', '2015-08-01', '12:00', '2015-09-07', '12:00', 'No corresponde'),
(20, 'CIERRE ADMINISTRATIVO', 1, 1, 'asdas', 'asdasdas', 'dasdasd', 'adsas', 'adsas', 'asdadsasd', 'no', 'no', 'no', 'Con atención', 'Domicilio', '2015-07-26', '12:00', '2015-09-24', '13:00', 'No corresponde'),
(21, 'CIERRE ADMINISTRATIVO', 2, 2, 'gdfgfdfdg', 'fdgfgdgfd', 'fdggfd', 'fdgfgdfdg', 'fdgfgdfdg', 'gfdfgdfgdfd', 'no', 'si', 'no', 'Con atención', 'Domicilio', '2015-08-12', '12:00', '2015-09-09', '12:00', 'No corresponde'),
(22, 'CIERRE ADMINISTRATIVO', 2, 2, 'sdfsdfsdf', 'sfdsdf', 'sdfsdf', 'sfdsdfsdf', 'sfdsdfsdf', 'sfdsfdsdf', 'no', 'si', 'no', 'Con atención', 'Domicilio', '2015-08-12', '03:04', '2015-09-11', '03:45', 'No corresponde'),
(23, 'CIERRE ADMINISTRATIVO', 2, 2, 'asdasd', 'asdasd', 'asd', 'asdasdasd', 'asdasdasd', 'asdasdasd', 'no', 'no', 'no', 'Con atención', 'Domicilio', '2015-08-12', '23:04', '2015-09-10', '23:04', 'No corresponde'),
(24, 'CIERRE ADMINISTRATIVO', 2, 2, 'sdfsdf', 'sdfsfd', 'fsdfsd', 'sfdsfd', 'sfdsfd', 'fdssfdsfd', 'no', 'si', 'no', 'No se atendio', 'Domicilio', '2015-05-31', '03:04', '2015-09-10', '05:34', 'No corresponde'),
(25, 'CIERRE ADMINISTRATIVO', 2, 2, 'fdgdf', 'gdfg', 'dfg', 'dfgdfg', 'dfgdfg', 'dfgdf', 'no', 'no', 'no', 'Con atención', 'Domicilio', '2015-08-01', '04:05', '2015-09-17', '04:56', 'No corresponde'),
(26, 'CIERRE ADMINISTRATIVO', 2, 2, 'sdfsfdsdf', 'fdsdsf', 'sfd', 'dfsdfsd', 'dfsdfsd', 'fsddsf', 'no', 'no', 'no', 'Con atención', 'Domicilio', '2015-07-30', '03:45', '2015-09-17', '03:45', 'No corresponde'),
(27, 'CATEGORIZADO', 2, 2, 'asassd', 'fsddfdf', 'fdgfgd', 'gfdgfdgfd', 'gfdgfdgfd', 'gfdgfdgfdfd', 'no', 'si', 'no', 'Con atención', 'Domicilio', '2015-08-12', '04:46', '2015-09-16', '04:05', 'No corresponde'),
(28, 'CATEGORIZADO', 2, 2, 'scxvbvcb', 'cvbghjhj', 'jkljklui', 'kyutyjh', 'kyutyjh', 'hjkjht', 'si', 'no', 'si', 'No se atendio', 'Internado', '2015-08-11', '21:45', '2015-09-09', '12:58', 'proxima visita'),
(29, 'CATEGORIZADO', 2, 2, 'xcgvjhbkjnl', 'txcyvb', 'txcygvjhbkjn', 'xtcgvb', 'xtcgvb', 'xtcyvbjn', 'no', 'si', 'no', 'No se atendio', 'Domicilio', '2015-08-01', '04:57', '2015-09-04', '05:57', 'No corresponde'),
(30, 'CIERRE ADMINISTRATIVO', 2, 2, 'sdfdssfd', 'fdsfdsfds', 'fsdsfd', 'dsfdsffds', 'dsfdsffds', 'fdsfsddfs', 'si', 'no', 'no', 'Con atención', 'Internado', '2015-08-11', '03:42', '2015-09-02', '08:08', 'No corresponde');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rce_actividad`
--

CREATE TABLE IF NOT EXISTS `rce_actividad` (
  `rceidRce` int(10) NOT NULL,
  `actividadid` int(10) NOT NULL,
  PRIMARY KEY (`rceidRce`,`actividadid`),
  KEY `FKrce_activi476582` (`rceidRce`),
  KEY `FKrce_activi147203` (`actividadid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `rce_actividad`
--

INSERT INTO `rce_actividad` (`rceidRce`, `actividadid`) VALUES
(2, 1),
(3, 1),
(4, 5),
(5, 1),
(6, 1),
(7, 6),
(8, 2),
(9, 1),
(9, 2),
(9, 3),
(10, 6),
(11, 1),
(12, 1),
(13, 5),
(14, 1),
(15, 1),
(16, 1),
(17, 2),
(18, 5),
(19, 1),
(19, 7),
(19, 9),
(19, 12),
(19, 15),
(19, 16),
(19, 18),
(20, 1),
(20, 7),
(20, 12),
(21, 1),
(22, 6),
(23, 2),
(24, 10),
(25, 2),
(26, 6),
(27, 1),
(28, 5),
(29, 5),
(30, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rce_certificado`
--

CREATE TABLE IF NOT EXISTS `rce_certificado` (
  `rceidRce` int(10) NOT NULL,
  `certificadoid` int(10) NOT NULL,
  PRIMARY KEY (`rceidRce`,`certificadoid`),
  KEY `FKrce_certif127026` (`rceidRce`),
  KEY `FKrce_certif380835` (`certificadoid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `rce_certificado`
--

INSERT INTO `rce_certificado` (`rceidRce`, `certificadoid`) VALUES
(2, 2),
(2, 4),
(2, 6),
(2, 8),
(2, 10),
(2, 12),
(2, 14),
(2, 16),
(2, 18),
(2, 20),
(2, 22),
(2, 24),
(2, 26),
(2, 28),
(2, 30),
(3, 2),
(3, 4),
(3, 6),
(3, 8),
(3, 10),
(3, 12),
(3, 14),
(3, 16),
(3, 18),
(3, 20),
(3, 22),
(3, 24),
(3, 26),
(3, 28),
(3, 30),
(4, 2),
(4, 4),
(4, 6),
(4, 8),
(4, 10),
(4, 12),
(4, 14),
(4, 16),
(4, 18),
(4, 20),
(4, 22),
(4, 24),
(4, 26),
(4, 28),
(4, 30),
(5, 2),
(5, 4),
(5, 6),
(5, 8),
(5, 10),
(5, 12),
(5, 14),
(5, 16),
(5, 18),
(5, 20),
(5, 22),
(5, 24),
(5, 26),
(5, 28),
(5, 30),
(6, 2),
(6, 4),
(6, 6),
(6, 8),
(6, 10),
(6, 12),
(6, 14),
(6, 16),
(6, 18),
(6, 20),
(6, 22),
(6, 24),
(6, 26),
(6, 28),
(6, 30),
(7, 2),
(7, 4),
(7, 6),
(7, 8),
(7, 10),
(7, 12),
(7, 14),
(7, 16),
(7, 18),
(7, 20),
(7, 22),
(7, 24),
(7, 26),
(7, 28),
(7, 30),
(8, 2),
(8, 4),
(8, 6),
(8, 8),
(8, 10),
(8, 12),
(8, 14),
(8, 16),
(8, 18),
(8, 20),
(8, 22),
(8, 24),
(8, 26),
(8, 28),
(8, 30),
(9, 2),
(9, 4),
(9, 6),
(9, 8),
(9, 10),
(9, 12),
(9, 14),
(9, 16),
(9, 18),
(9, 20),
(9, 22),
(9, 24),
(9, 26),
(9, 28),
(9, 30),
(10, 2),
(10, 4),
(10, 6),
(10, 8),
(10, 10),
(10, 12),
(10, 14),
(10, 16),
(10, 18),
(10, 20),
(10, 22),
(10, 24),
(10, 26),
(10, 28),
(10, 30),
(11, 2),
(11, 4),
(11, 6),
(11, 8),
(11, 10),
(11, 12),
(11, 14),
(11, 16),
(11, 18),
(11, 20),
(11, 22),
(11, 24),
(11, 26),
(11, 28),
(11, 30),
(12, 2),
(12, 4),
(12, 6),
(12, 8),
(12, 10),
(12, 12),
(12, 14),
(12, 16),
(12, 18),
(12, 20),
(12, 22),
(12, 24),
(12, 26),
(12, 28),
(12, 30),
(13, 2),
(13, 4),
(13, 6),
(13, 8),
(13, 10),
(13, 12),
(13, 14),
(13, 16),
(13, 18),
(13, 20),
(13, 22),
(13, 24),
(13, 26),
(13, 28),
(13, 30),
(14, 2),
(14, 4),
(14, 6),
(14, 8),
(14, 10),
(14, 12),
(14, 14),
(14, 16),
(14, 18),
(14, 20),
(14, 22),
(14, 24),
(14, 26),
(14, 28),
(14, 30),
(15, 2),
(15, 4),
(15, 6),
(15, 8),
(15, 10),
(15, 12),
(15, 14),
(15, 16),
(15, 18),
(15, 20),
(15, 22),
(15, 24),
(15, 26),
(15, 28),
(15, 30),
(16, 2),
(16, 4),
(16, 6),
(16, 8),
(16, 10),
(16, 12),
(16, 14),
(16, 16),
(16, 18),
(16, 20),
(16, 22),
(16, 24),
(16, 26),
(16, 28),
(16, 30),
(17, 2),
(17, 4),
(17, 6),
(17, 8),
(17, 10),
(17, 12),
(17, 14),
(17, 16),
(17, 18),
(17, 20),
(17, 22),
(17, 24),
(17, 26),
(17, 28),
(17, 30),
(18, 2),
(18, 4),
(18, 6),
(18, 8),
(18, 9),
(18, 12),
(18, 13),
(18, 16),
(18, 18),
(18, 20),
(18, 21),
(18, 23),
(18, 26),
(18, 28),
(18, 30),
(19, 2),
(19, 4),
(19, 6),
(19, 8),
(19, 10),
(19, 12),
(19, 14),
(19, 16),
(19, 18),
(19, 20),
(19, 22),
(19, 24),
(19, 26),
(19, 28),
(19, 30),
(20, 2),
(20, 4),
(20, 6),
(20, 8),
(20, 10),
(20, 12),
(20, 14),
(20, 16),
(20, 18),
(20, 20),
(20, 22),
(20, 24),
(20, 26),
(20, 28),
(20, 30),
(21, 2),
(21, 4),
(21, 6),
(21, 8),
(21, 10),
(21, 12),
(21, 14),
(21, 16),
(21, 18),
(21, 20),
(21, 22),
(21, 24),
(21, 26),
(21, 28),
(21, 30),
(22, 2),
(22, 4),
(22, 6),
(22, 8),
(22, 10),
(22, 12),
(22, 14),
(22, 16),
(22, 18),
(22, 20),
(22, 22),
(22, 24),
(22, 26),
(22, 28),
(22, 30),
(23, 2),
(23, 4),
(23, 6),
(23, 8),
(23, 10),
(23, 12),
(23, 14),
(23, 16),
(23, 18),
(23, 20),
(23, 22),
(23, 24),
(23, 26),
(23, 28),
(23, 30),
(24, 2),
(24, 4),
(24, 6),
(24, 8),
(24, 10),
(24, 12),
(24, 14),
(24, 16),
(24, 18),
(24, 20),
(24, 22),
(24, 24),
(24, 26),
(24, 28),
(24, 30),
(25, 2),
(25, 4),
(25, 6),
(25, 8),
(25, 10),
(25, 12),
(25, 14),
(25, 16),
(25, 18),
(25, 20),
(25, 22),
(25, 24),
(25, 26),
(25, 28),
(25, 30),
(26, 2),
(26, 4),
(26, 6),
(26, 8),
(26, 10),
(26, 12),
(26, 14),
(26, 16),
(26, 18),
(26, 20),
(26, 22),
(26, 24),
(26, 26),
(26, 28),
(26, 30),
(27, 2),
(27, 4),
(27, 6),
(27, 8),
(27, 10),
(27, 12),
(27, 14),
(27, 16),
(27, 18),
(27, 20),
(27, 22),
(27, 24),
(27, 26),
(27, 28),
(27, 30),
(28, 1),
(28, 3),
(28, 5),
(28, 7),
(28, 9),
(28, 11),
(28, 13),
(28, 15),
(28, 17),
(28, 19),
(28, 21),
(28, 23),
(28, 25),
(28, 27),
(28, 29),
(29, 2),
(29, 4),
(29, 6),
(29, 8),
(29, 10),
(29, 12),
(29, 14),
(29, 16),
(29, 18),
(29, 20),
(29, 22),
(29, 24),
(29, 26),
(29, 28),
(29, 30),
(30, 2),
(30, 4),
(30, 6),
(30, 8),
(30, 10),
(30, 12),
(30, 14),
(30, 16),
(30, 18),
(30, 20),
(30, 22),
(30, 24),
(30, 26),
(30, 28),
(30, 30);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rce_diagnostico`
--

CREATE TABLE IF NOT EXISTS `rce_diagnostico` (
  `rceidRce` int(10) NOT NULL,
  `diagnosticoidDiagnostico` int(10) NOT NULL,
  PRIMARY KEY (`rceidRce`,`diagnosticoidDiagnostico`),
  KEY `FKrce_diagno661339` (`rceidRce`),
  KEY `FKrce_diagno60291` (`diagnosticoidDiagnostico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `rce_diagnostico`
--

INSERT INTO `rce_diagnostico` (`rceidRce`, `diagnosticoidDiagnostico`) VALUES
(2, 1),
(3, 1),
(4, 2),
(5, 1),
(6, 1),
(7, 2),
(8, 1),
(9, 1),
(10, 2),
(11, 1),
(12, 1),
(13, 2),
(14, 1),
(15, 1),
(16, 1),
(17, 1),
(18, 2),
(19, 1),
(19, 2),
(19, 3),
(19, 4),
(19, 5),
(19, 6),
(19, 7),
(20, 1),
(20, 2),
(20, 4),
(21, 1),
(22, 2),
(23, 1),
(24, 3),
(25, 1),
(26, 2),
(27, 1),
(28, 2),
(29, 2),
(30, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rce_procedimiento`
--

CREATE TABLE IF NOT EXISTS `rce_procedimiento` (
  `rceidRce` int(10) NOT NULL,
  `procedimientoid` int(10) NOT NULL,
  PRIMARY KEY (`rceidRce`,`procedimientoid`),
  KEY `FKrce_proced236269` (`rceidRce`),
  KEY `FKrce_proced287571` (`procedimientoid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `rce_procedimiento`
--

INSERT INTO `rce_procedimiento` (`rceidRce`, `procedimientoid`) VALUES
(2, 1),
(3, 1),
(4, 5),
(5, 1),
(6, 1),
(7, 8),
(8, 2),
(9, 1),
(9, 2),
(9, 3),
(10, 6),
(11, 1),
(12, 2),
(13, 6),
(14, 1),
(15, 2),
(16, 1),
(17, 2),
(18, 7),
(19, 1),
(19, 8),
(19, 9),
(19, 14),
(19, 18),
(19, 19),
(19, 22),
(20, 2),
(20, 5),
(20, 14),
(21, 1),
(22, 5),
(23, 2),
(24, 9),
(25, 4),
(26, 6),
(27, 2),
(28, 6),
(29, 6),
(30, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `receta`
--

CREATE TABLE IF NOT EXISTS `receta` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'identificador receta',
  `contenido` varchar(255) NOT NULL COMMENT 'contenido de la receta',
  `idRce` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKreceta744854` (`idRce`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=19 ;

--
-- Volcado de datos para la tabla `receta`
--

INSERT INTO `receta` (`id`, `contenido`, `idRce`) VALUES
(1, 'sdfsdfsdf', 8),
(2, 'sdfsdfsdf', 10),
(3, '', 13),
(4, 'asdasdads', 16),
(5, 'sdfsdfsdfsfd', 17),
(6, 'dfgdfgdfgdf receta', 18),
(7, '', 19),
(8, 'asdasdasd', 20),
(9, 'fsfsdfdsdfs', 21),
(10, 'fdfsdsdf', 22),
(11, 'adasd', 23),
(12, 'sdffdsfsd', 24),
(13, 'gdfgdfg', 25),
(14, 'sdfsdfsdffdsfdssfddsf', 26),
(15, 'dgffgdgdfdgfgfddf', 27),
(16, 'dfggyuut6', 28),
(17, 'dfgfgf', 29),
(18, 'esfdsfsds', 30);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reporte`
--

CREATE TABLE IF NOT EXISTS `reporte` (
  `id` int(10) NOT NULL,
  `idDirectorHospital` int(10) NOT NULL COMMENT 'clave foránea reporte-directorhospital',
  `fecha` date NOT NULL COMMENT 'fecha del reporte realizado',
  `resultado` varchar(255) NOT NULL COMMENT 'resultado del reporte realizado',
  `idTipoReporte` int(10) NOT NULL COMMENT 'clave foránea reporte-tiporeporte',
  PRIMARY KEY (`id`),
  KEY `FKreporte633664` (`idDirectorHospital`),
  KEY `FKreporte208370` (`idTipoReporte`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='reporte clínico';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE IF NOT EXISTS `reserva` (
  `idReserva` int(10) NOT NULL COMMENT 'identificador reserva',
  `idPaciente` int(10) NOT NULL COMMENT 'clave foránea paciente-reserva',
  `idHoraMedica` int(10) NOT NULL COMMENT 'clave foránea horamedica-paciente',
  `idPersonaRegistra` int(10) NOT NULL COMMENT 'clave foránea personaRegistra-reserva',
  PRIMARY KEY (`idReserva`),
  KEY `FKreserva759021` (`idPersonaRegistra`),
  KEY `FKreserva35156` (`idPaciente`),
  KEY `FKreserva909264` (`idHoraMedica`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='reservación de horas médicas';

--
-- Volcado de datos para la tabla `reserva`
--

INSERT INTO `reserva` (`idReserva`, `idPaciente`, `idHoraMedica`, `idPersonaRegistra`) VALUES
(1, 1, 1, 1),
(2, 2, 2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tiporeporte`
--

CREATE TABLE IF NOT EXISTS `tiporeporte` (
  `id` int(10) NOT NULL COMMENT 'identificador del tipo de reporte',
  `tipo` varchar(50) NOT NULL COMMENT 'nombre del tipo de reporte',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='tipo de reporte';

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `actividad`
--
ALTER TABLE `actividad`
  ADD CONSTRAINT `FKactividad155576` FOREIGN KEY (`idDiagnostico`) REFERENCES `diagnostico` (`idDiagnostico`);

--
-- Filtros para la tabla `directorhospital`
--
ALTER TABLE `directorhospital`
  ADD CONSTRAINT `FKdirectorHo484753` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`);

--
-- Filtros para la tabla `hce`
--
ALTER TABLE `hce`
  ADD CONSTRAINT `FKhce938722` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`idPaciente`);

--
-- Filtros para la tabla `horamedica`
--
ALTER TABLE `horamedica`
  ADD CONSTRAINT `FKhoraMedica451396` FOREIGN KEY (`idBox`) REFERENCES `box` (`idHabitacion`),
  ADD CONSTRAINT `FKhoraMedica653351` FOREIGN KEY (`idMedico`) REFERENCES `medico` (`idMedico`);

--
-- Filtros para la tabla `medico`
--
ALTER TABLE `medico`
  ADD CONSTRAINT `FKmedico647483` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`),
  ADD CONSTRAINT `FKmedico655469` FOREIGN KEY (`especialidad`) REFERENCES `especialidad` (`idEspecialidad`);

--
-- Filtros para la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD CONSTRAINT `FKpaciente532367` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`);

--
-- Filtros para la tabla `procedimiento`
--
ALTER TABLE `procedimiento`
  ADD CONSTRAINT `FKprocedimie625288` FOREIGN KEY (`idDiagnostico`) REFERENCES `diagnostico` (`idDiagnostico`);

--
-- Filtros para la tabla `rce`
--
ALTER TABLE `rce`
  ADD CONSTRAINT `FKrce258372` FOREIGN KEY (`idHce`) REFERENCES `hce` (`idHce`),
  ADD CONSTRAINT `FKrce944995` FOREIGN KEY (`idHoraMedica`) REFERENCES `horamedica` (`idHora`);

--
-- Filtros para la tabla `rce_actividad`
--
ALTER TABLE `rce_actividad`
  ADD CONSTRAINT `FKrce_activi147203` FOREIGN KEY (`actividadid`) REFERENCES `actividad` (`id`),
  ADD CONSTRAINT `FKrce_activi476582` FOREIGN KEY (`rceidRce`) REFERENCES `rce` (`idRce`);

--
-- Filtros para la tabla `rce_certificado`
--
ALTER TABLE `rce_certificado`
  ADD CONSTRAINT `FKrce_certif127026` FOREIGN KEY (`rceidRce`) REFERENCES `rce` (`idRce`),
  ADD CONSTRAINT `FKrce_certif380835` FOREIGN KEY (`certificadoid`) REFERENCES `certificado` (`id`);

--
-- Filtros para la tabla `rce_diagnostico`
--
ALTER TABLE `rce_diagnostico`
  ADD CONSTRAINT `FKrce_diagno60291` FOREIGN KEY (`diagnosticoidDiagnostico`) REFERENCES `diagnostico` (`idDiagnostico`),
  ADD CONSTRAINT `FKrce_diagno661339` FOREIGN KEY (`rceidRce`) REFERENCES `rce` (`idRce`);

--
-- Filtros para la tabla `rce_procedimiento`
--
ALTER TABLE `rce_procedimiento`
  ADD CONSTRAINT `FKrce_proced236269` FOREIGN KEY (`rceidRce`) REFERENCES `rce` (`idRce`),
  ADD CONSTRAINT `FKrce_proced287571` FOREIGN KEY (`procedimientoid`) REFERENCES `procedimiento` (`id`);

--
-- Filtros para la tabla `receta`
--
ALTER TABLE `receta`
  ADD CONSTRAINT `FKreceta744854` FOREIGN KEY (`idRce`) REFERENCES `rce` (`idRce`);

--
-- Filtros para la tabla `reporte`
--
ALTER TABLE `reporte`
  ADD CONSTRAINT `FKreporte208370` FOREIGN KEY (`idTipoReporte`) REFERENCES `tiporeporte` (`id`),
  ADD CONSTRAINT `FKreporte633664` FOREIGN KEY (`idDirectorHospital`) REFERENCES `directorhospital` (`id`);

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `FKreserva35156` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`idPaciente`),
  ADD CONSTRAINT `FKreserva759021` FOREIGN KEY (`idPersonaRegistra`) REFERENCES `persona` (`idPersona`),
  ADD CONSTRAINT `FKreserva909264` FOREIGN KEY (`idHoraMedica`) REFERENCES `horamedica` (`idHora`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
