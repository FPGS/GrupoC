-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-05-2017 a las 17:10:27
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 7.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `registros`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registros`
--

CREATE TABLE `registros` (
  `idEvento` int(11) NOT NULL,
  `fechaRegistro` varchar(35) COLLATE utf8mb4_unicode_ci NOT NULL,
  `direccionIP` varchar(15) CHARACTER SET latin1 NOT NULL,
  `mascaraRed` varchar(15) CHARACTER SET latin1 NOT NULL,
  `nombreHost` varchar(35) CHARACTER SET latin1 DEFAULT NULL,
  `comentarios` varchar(100) CHARACTER SET latin1 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=COMPACT;

--
-- Volcado de datos para la tabla `registros`
--

INSERT INTO `registros` (`idEvento`, `fechaRegistro`, `direccionIP`, `mascaraRed`, `nombreHost`, `comentarios`) VALUES
(1, '2017-05-15 02:11:20', '212.255.36.36', '255.255.255.0', NULL, 'prueba1'),
(2, '2017-05-02 10:00:08', '192.0.0.1', '255.0.0.0', 'PepePC', 'prueba2'),
(3, '17:07:41 27/05/2017', '192.168.56.1', 'JaviDesktopWin', '255.0.0.0', NULL),
(4, '17:08:52 27/05/2017', '192.168.56.1', 'JaviDesktopWin', '255.0.0.0', NULL),
(5, '17:09:17 27/05/2017', '192.168.56.1', 'JaviDesktopWin', '255.0.0.0', NULL),
(6, '17:09:54 27/05/2017', '192.168.56.1', 'JaviDesktopWin', '255.0.0.0', NULL),
(7, '17:09:54 27/05/2017', '192.168.56.1', 'JaviDesktopWin', '255.0.0.0', 'existo');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `registros`
--
ALTER TABLE `registros`
  ADD PRIMARY KEY (`idEvento`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `registros`
--
ALTER TABLE `registros`
  MODIFY `idEvento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
