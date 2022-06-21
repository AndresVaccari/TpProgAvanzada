-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-06-2022 a las 03:41:19
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tpfinal`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensaje`
--

CREATE TABLE `mensaje` (
  `Destinario` varchar(50) NOT NULL,
  `Asunto` varchar(100) NOT NULL,
  `Remitente` varchar(50) NOT NULL,
  `Mensaje` varchar(500) NOT NULL,
  `Estado` varchar(50) NOT NULL,
  `TipoMensaje` varchar(50) NOT NULL,
  `ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `mensaje`
--

INSERT INTO `mensaje` (`Destinario`, `Asunto`, `Remitente`, `Mensaje`, `Estado`, `TipoMensaje`, `ID`) VALUES
('andres', 'hola', 'admin', 'gjklasnkjgpanbsdjkbnfkjad', 'Leido', 'Enviado', 0),
('test', 'hola', 'admin', 'gjklasnkjgpanbsdjkbnfkjad', 'NoLeido', 'Enviado', 1),
('test', 'hola', 'admin', 'gjklasnkjgpanbsdjkbnfkjad', 'NoLeido', 'Recibido', 1),
('test2', 'hola', 'admin', 'gjklasnkjgpanbsdjkbnfkjad', 'Leido', 'Recibido', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `Usuario` varchar(50) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Apellido` varchar(50) NOT NULL,
  `Documento` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`Usuario`, `Nombre`, `Apellido`, `Documento`, `Email`, `Password`, `Estado`) VALUES
('admin', 'admin', 'admin', 'admin', 'admin', 'admin', 1),
('andres', 'Andres', 'Vaccari', '42769029', 'andresvaccari34@gmail.com', '1234', 1),
('test', 'test', 'test', 'test', 'test', 'test', 1),
('test2', 'test2', 'test2', 'test2', 'test2', 'test2', 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
