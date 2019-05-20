-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 20, 2019 at 04:20 PM
-- Server version: 5.7.26
-- PHP Version: 7.2.18-1+0~20190503103213.21+stretch~1.gbp101320

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `apps`
--

-- --------------------------------------------------------

--
-- Table structure for table `rendimientos`
--

CREATE TABLE `rendimientos` (
  `id` int(10) UNSIGNED NOT NULL,
  `puerto_buque` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `puerto_muelle` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `puerto_producto` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `puerto_tonelaje` double NOT NULL,
  `puerto_arribo` date NOT NULL,
  `puerto_arribo_hora` double NOT NULL,
  `puerto_desatraque` date NOT NULL,
  `puerto_desatraque_hora` double NOT NULL,
  `puerto_zarpe` double NOT NULL,
  `muelle_atraque` date NOT NULL,
  `muelle_atraque_hora` double NOT NULL,
  `operacion_inicio` date NOT NULL,
  `operacion_inicio_hora` double NOT NULL,
  `operacion_termino` date NOT NULL,
  `operacion_termino_hora` double NOT NULL,
  `operacion_demoras` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `rendimientos`
--

INSERT INTO `rendimientos` (`id`, `puerto_buque`, `puerto_muelle`, `puerto_producto`, `puerto_tonelaje`, `puerto_arribo`, `puerto_arribo_hora`, `puerto_desatraque`, `puerto_desatraque_hora`, `puerto_zarpe`, `muelle_atraque`, `muelle_atraque_hora`, `operacion_inicio`, `operacion_inicio_hora`, `operacion_termino`, `operacion_termino_hora`, `operacion_demoras`) VALUES
(1, 'RUNA', '6', 'UNIDADES', 132, '2019-03-31', 17.3, '2019-04-04', 14.15, 1, '2019-04-03', 14.03, '2019-04-03', 15.35, '2019-04-04', 13.3, 1),
(2, 'OLMECA', '8', 'MEACA', 3996, '2019-03-30', 11, '2019-04-03', 21.4, 1, '2019-04-02', 16.45, '2019-04-02', 19, '2019-04-03', 17.5, 0),
(3, 'IVER BLESSING', '7', 'ASFALTO LIQUIDO', 5568, '2019-04-01', 5.42, '2019-04-04', 23.26, 1, '2019-04-03', 18, '2019-04-03', 22, '2019-04-04', 21, 0),
(4, 'CHEMICAL ATLANTIK', '8', 'PRODUCTOS QUIMICOS', 13547, '2019-04-01', 21, '2019-04-06', 14.4, 1, '2019-04-03', 23.25, '2019-04-04', 11, '2019-04-06', 11.5, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `rendimientos`
--
ALTER TABLE `rendimientos`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `rendimientos`
--
ALTER TABLE `rendimientos`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
