-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 18, 2017 at 09:52 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `websystique`
--
CREATE DATABASE IF NOT EXISTS `websystique` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `websystique`;

-- --------------------------------------------------------

--
-- Table structure for table `app_user`
--

DROP TABLE IF EXISTS `app_user`;
CREATE TABLE `app_user` (
  `id` bigint(20) NOT NULL,
  `sso_id` varchar(30) COLLATE utf8_bin NOT NULL,
  `password` varchar(100) COLLATE utf8_bin NOT NULL,
  `first_name` varchar(30) COLLATE utf8_bin NOT NULL,
  `last_name` varchar(30) COLLATE utf8_bin NOT NULL,
  `email` varchar(30) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `app_user_user_profile`
--

DROP TABLE IF EXISTS `app_user_user_profile`;
CREATE TABLE `app_user_user_profile` (
  `user_id` bigint(20) NOT NULL,
  `user_profile_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `artikli`
--

DROP TABLE IF EXISTS `artikli`;
CREATE TABLE `artikli` (
  `id` bigint(20) NOT NULL,
  `akcija` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `aktivan` bit(1) DEFAULT NULL,
  `code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `code1` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `code2` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `slika` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  `video` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `vrste_artikala_naziv` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `zvuk` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `jedinice_mera_id` bigint(20) DEFAULT NULL,
  `klasifikacije_id` bigint(20) DEFAULT NULL,
  `poreske_grupe_id` bigint(20) DEFAULT NULL,
  `vrste_artikala_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `artikli`
--

INSERT INTO `artikli` (`id`, `akcija`, `aktivan`, `code`, `code1`, `code2`, `name`, `remark`, `slika`, `timestamp`, `video`, `vrste_artikala_naziv`, `zvuk`, `jedinice_mera_id`, `klasifikacije_id`, `poreske_grupe_id`, `vrste_artikala_id`) VALUES
(6, NULL, b'1111111111111111111111111111111', '2', NULL, NULL, 'Coca cola', '', NULL, '2017-12-10 16:52:05', NULL, NULL, NULL, 1, 2, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `drzave`
--

DROP TABLE IF EXISTS `drzave`;
CREATE TABLE `drzave` (
  `id` bigint(20) NOT NULL,
  `akcija` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `aktivan` bit(1) NOT NULL,
  `code` varchar(255) COLLATE utf8_bin NOT NULL,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  `slike` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `video` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `zvuk` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `slika` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `drzave`
--

INSERT INTO `drzave` (`id`, `akcija`, `aktivan`, `code`, `name`, `remark`, `timestamp`, `slike`, `video`, `zvuk`, `slika`) VALUES
(1, NULL, b'1111111111111111111111111111111', '1', 'Serbia', '', '2017-12-14 12:25:35', NULL, NULL, NULL, NULL),
(3, NULL, b'1111111111111111111111111111111', '0', '-', '***', '2017-12-14 13:28:47', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `hellolog`
--

DROP TABLE IF EXISTS `hellolog`;
CREATE TABLE `hellolog` (
  `uid` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `timestamp` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `jedinice_mera`
--

DROP TABLE IF EXISTS `jedinice_mera`;
CREATE TABLE `jedinice_mera` (
  `id` bigint(20) NOT NULL,
  `akcija` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `aktivan` bit(1) NOT NULL,
  `code` varchar(255) COLLATE utf8_bin NOT NULL,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `jedinice_mera`
--

INSERT INTO `jedinice_mera` (`id`, `akcija`, `aktivan`, `code`, `name`, `remark`, `timestamp`) VALUES
(1, NULL, b'1111111111111111111111111111111', '1', 'kg', 'k', '2017-12-05 10:32:24'),
(2, NULL, b'1111111111111111111111111111111', '2', 'm', '', '2017-12-05 12:14:19'),
(3, NULL, b'1111111111111111111111111111111', '3', 'l', '', '2017-12-05 12:16:00'),
(4, NULL, b'1111111111111111111111111111111', '4', 'm2', 'm21', '2017-12-05 12:20:13'),
(5, NULL, b'1111111111111111111111111111111', '5', 't', '85', '2017-12-05 12:20:47'),
(6, NULL, b'1111111111111111111111111111111', '0', '-', '', '2017-12-10 17:36:07');

-- --------------------------------------------------------

--
-- Table structure for table `klasifikacije`
--

DROP TABLE IF EXISTS `klasifikacije`;
CREATE TABLE `klasifikacije` (
  `id` bigint(20) NOT NULL,
  `akcija` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `aktivan` bit(1) NOT NULL,
  `code` varchar(255) COLLATE utf8_bin NOT NULL,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `klasifikacije`
--

INSERT INTO `klasifikacije` (`id`, `akcija`, `aktivan`, `code`, `name`, `remark`, `timestamp`) VALUES
(2, NULL, b'1111111111111111111111111111111', '1', 'Hrana', '', '2017-12-05 15:15:19'),
(5, NULL, b'1111111111111111111111111111111', '0', '-', '', '2017-12-10 17:35:27');

-- --------------------------------------------------------

--
-- Table structure for table `magacini`
--

DROP TABLE IF EXISTS `magacini`;
CREATE TABLE `magacini` (
  `id` int(11) NOT NULL,
  `aktivan` bit(1) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `vrste_magacina_id` int(11) DEFAULT NULL,
  `akcija` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  `slika` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `video` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `zvuk` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `vrste_magacina_naziv` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `magacini`
--

INSERT INTO `magacini` (`id`, `aktivan`, `name`, `vrste_magacina_id`, `akcija`, `code`, `remark`, `timestamp`, `slika`, `video`, `zvuk`, `vrste_magacina_naziv`) VALUES
(15, b'1111111111111111111111111111111', 'Magacin 1', 5, NULL, '1', '', NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `persistent_logins`
--

DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `series` varchar(64) COLLATE utf8_bin NOT NULL,
  `token` varchar(64) COLLATE utf8_bin NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `poreske_grupe`
--

DROP TABLE IF EXISTS `poreske_grupe`;
CREATE TABLE `poreske_grupe` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `akcija` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `aktivan` bit(1) NOT NULL,
  `code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `poreske_grupe`
--

INSERT INTO `poreske_grupe` (`id`, `name`, `akcija`, `aktivan`, `code`, `remark`, `timestamp`) VALUES
(1, '20 %', NULL, b'1111111111111111111111111111111', '1', '20 %', '2017-12-06 11:39:12'),
(2, '-', NULL, b'1111111111111111111111111111111', '0', '', '2017-12-10 17:35:55');

-- --------------------------------------------------------

--
-- Table structure for table `prijemnica`
--

DROP TABLE IF EXISTS `prijemnica`;
CREATE TABLE `prijemnica` (
  `id` int(11) NOT NULL,
  `akcija` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `aktivan` bit(1) DEFAULT NULL,
  `broj_prijemnice` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `datum` date DEFAULT NULL,
  `datum_vreme` datetime DEFAULT NULL,
  `host` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `id_komitent` int(11) DEFAULT NULL,
  `id_magacin` int(11) DEFAULT NULL,
  `napomena` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user` varchar(45) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `prijemnica_stavke`
--

DROP TABLE IF EXISTS `prijemnica_stavke`;
CREATE TABLE `prijemnica_stavke` (
  `id` int(11) NOT NULL,
  `akcija` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `aktivan` bit(1) DEFAULT NULL,
  `cena` decimal(19,2) DEFAULT NULL,
  `datum` date DEFAULT NULL,
  `datumvreme` datetime DEFAULT NULL,
  `host` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `id_roba` int(11) DEFAULT NULL,
  `izlaz` decimal(19,2) DEFAULT NULL,
  `iznos` decimal(19,2) DEFAULT NULL,
  `kolicina` decimal(19,2) DEFAULT NULL,
  `napomena` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `prijemnica_stavkecol` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `roba_naziv` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `ulaz` decimal(19,2) DEFAULT NULL,
  `id_prijemnica` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `company_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `ptt_brojevi`
--

DROP TABLE IF EXISTS `ptt_brojevi`;
CREATE TABLE `ptt_brojevi` (
  `id` bigint(20) NOT NULL,
  `akcija` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `aktivan` bit(1) DEFAULT NULL,
  `code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `drzava_naziv` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `slika` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  `video` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `zvuk` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ptt_brojevi_id` bigint(20) DEFAULT NULL,
  `drzava_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `password`, `username`) VALUES
(1, '$2a$10$8hn2khFGTjBjU45Ssi8zdu/Zg1PoRjxFPh/hFDLt.V3BhNWRdwlQq', 'user'),
(2, '$2a$10$yTZQLBwc8MJdFkh9mDpwpeFrTDnvsuOZcrkLATbz7hanhI9rGkIBO', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `user_profile`
--

DROP TABLE IF EXISTS `user_profile`;
CREATE TABLE `user_profile` (
  `id` bigint(20) NOT NULL,
  `type` varchar(30) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `vrste_artikala`
--

DROP TABLE IF EXISTS `vrste_artikala`;
CREATE TABLE `vrste_artikala` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `akcija` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `aktivan` bit(1) NOT NULL,
  `code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `vrste_artikala`
--

INSERT INTO `vrste_artikala` (`id`, `name`, `akcija`, `aktivan`, `code`, `remark`, `timestamp`) VALUES
(1, 'Elektromaterijal', NULL, b'1111111111111111111111111111111', '1', '11', NULL),
(10, '-', NULL, b'1111111111111111111111111111111', '0', '', '2017-12-10 17:35:43');

-- --------------------------------------------------------

--
-- Table structure for table `vrste_magacina`
--

DROP TABLE IF EXISTS `vrste_magacina`;
CREATE TABLE `vrste_magacina` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `aktivan` bit(1) NOT NULL,
  `timestamp` datetime DEFAULT NULL,
  `akcija` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `vrste_magacina`
--

INSERT INTO `vrste_magacina` (`id`, `name`, `aktivan`, `timestamp`, `akcija`, `code`, `remark`) VALUES
(5, 'Veleprodaja', b'1111111111111111111111111111111', '2017-12-08 19:30:40', NULL, '1', '');

-- --------------------------------------------------------

--
-- Table structure for table `vrste_paleta`
--

DROP TABLE IF EXISTS `vrste_paleta`;
CREATE TABLE `vrste_paleta` (
  `uid` bigint(20) NOT NULL,
  `akcija` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `aktivan` tinyint(1) DEFAULT '1',
  `code` varchar(255) COLLATE utf8_bin NOT NULL,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `vrste_paleta_old`
--

DROP TABLE IF EXISTS `vrste_paleta_old`;
CREATE TABLE `vrste_paleta_old` (
  `id` bigint(20) NOT NULL,
  `aktivan` tinyint(1) DEFAULT '1',
  `code` varchar(255) COLLATE utf8_bin NOT NULL,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `akcija` varchar(45) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `app_user`
--
ALTER TABLE `app_user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `sso_id` (`sso_id`);

--
-- Indexes for table `app_user_user_profile`
--
ALTER TABLE `app_user_user_profile`
  ADD PRIMARY KEY (`user_id`,`user_profile_id`),
  ADD KEY `FK_USER_PROFILE` (`user_profile_id`);

--
-- Indexes for table `artikli`
--
ALTER TABLE `artikli`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_hx9k3ibbioo4m5s479s00cbk` (`jedinice_mera_id`),
  ADD KEY `FK_8mh3tpfyftgsnquy9hnmqh1k5` (`klasifikacije_id`),
  ADD KEY `FK_jiwsomivwprpfpnhe14jsw3c` (`poreske_grupe_id`),
  ADD KEY `FK_ptdpcc74ldpm54pf3liua6brt` (`vrste_artikala_id`);

--
-- Indexes for table `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `drzave`
--
ALTER TABLE `drzave`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `hellolog`
--
ALTER TABLE `hellolog`
  ADD PRIMARY KEY (`uid`);

--
-- Indexes for table `jedinice_mera`
--
ALTER TABLE `jedinice_mera`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `klasifikacije`
--
ALTER TABLE `klasifikacije`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `magacini`
--
ALTER TABLE `magacini`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_66uqm8qh2v9whhyc62s5mbu52` (`vrste_magacina_id`);

--
-- Indexes for table `persistent_logins`
--
ALTER TABLE `persistent_logins`
  ADD PRIMARY KEY (`series`);

--
-- Indexes for table `poreske_grupe`
--
ALTER TABLE `poreske_grupe`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `prijemnica`
--
ALTER TABLE `prijemnica`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `prijemnica_stavke`
--
ALTER TABLE `prijemnica_stavke`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_5hfntdhgrswoxkm7ev13t0utl` (`id_prijemnica`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_45g3a4rexapplpirj3jor716p` (`company_id`);

--
-- Indexes for table `ptt_brojevi`
--
ALTER TABLE `ptt_brojevi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_299429h6eh3yovmkodsy1necx` (`ptt_brojevi_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_profile`
--
ALTER TABLE `user_profile`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `type` (`type`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `FK_it77eq964jhfqtu54081ebtio` (`role_id`);

--
-- Indexes for table `vrste_artikala`
--
ALTER TABLE `vrste_artikala`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `vrste_magacina`
--
ALTER TABLE `vrste_magacina`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `vrste_paleta`
--
ALTER TABLE `vrste_paleta`
  ADD PRIMARY KEY (`uid`);

--
-- Indexes for table `vrste_paleta_old`
--
ALTER TABLE `vrste_paleta_old`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `app_user`
--
ALTER TABLE `app_user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `artikli`
--
ALTER TABLE `artikli`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `company`
--
ALTER TABLE `company`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `drzave`
--
ALTER TABLE `drzave`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `hellolog`
--
ALTER TABLE `hellolog`
  MODIFY `uid` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `jedinice_mera`
--
ALTER TABLE `jedinice_mera`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `klasifikacije`
--
ALTER TABLE `klasifikacije`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `magacini`
--
ALTER TABLE `magacini`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `poreske_grupe`
--
ALTER TABLE `poreske_grupe`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `prijemnica`
--
ALTER TABLE `prijemnica`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `prijemnica_stavke`
--
ALTER TABLE `prijemnica_stavke`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ptt_brojevi`
--
ALTER TABLE `ptt_brojevi`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user_profile`
--
ALTER TABLE `user_profile`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `vrste_artikala`
--
ALTER TABLE `vrste_artikala`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `vrste_magacina`
--
ALTER TABLE `vrste_magacina`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `vrste_paleta`
--
ALTER TABLE `vrste_paleta`
  MODIFY `uid` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `vrste_paleta_old`
--
ALTER TABLE `vrste_paleta_old`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `app_user_user_profile`
--
ALTER TABLE `app_user_user_profile`
  ADD CONSTRAINT `FK_APP_USER` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`id`),
  ADD CONSTRAINT `FK_USER_PROFILE` FOREIGN KEY (`user_profile_id`) REFERENCES `user_profile` (`id`);

--
-- Constraints for table `artikli`
--
ALTER TABLE `artikli`
  ADD CONSTRAINT `FK_8mh3tpfyftgsnquy9hnmqh1k5` FOREIGN KEY (`klasifikacije_id`) REFERENCES `klasifikacije` (`id`),
  ADD CONSTRAINT `FK_hx9k3ibbioo4m5s479s00cbk` FOREIGN KEY (`jedinice_mera_id`) REFERENCES `jedinice_mera` (`id`),
  ADD CONSTRAINT `FK_jiwsomivwprpfpnhe14jsw3c` FOREIGN KEY (`poreske_grupe_id`) REFERENCES `poreske_grupe` (`id`),
  ADD CONSTRAINT `FK_ptdpcc74ldpm54pf3liua6brt` FOREIGN KEY (`vrste_artikala_id`) REFERENCES `vrste_artikala` (`id`);

--
-- Constraints for table `magacini`
--
ALTER TABLE `magacini`
  ADD CONSTRAINT `FK_66uqm8qh2v9whhyc62s5mbu52` FOREIGN KEY (`vrste_magacina_id`) REFERENCES `vrste_magacina` (`id`);

--
-- Constraints for table `prijemnica_stavke`
--
ALTER TABLE `prijemnica_stavke`
  ADD CONSTRAINT `FK_5hfntdhgrswoxkm7ev13t0utl` FOREIGN KEY (`id_prijemnica`) REFERENCES `prijemnica` (`id`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `FK_45g3a4rexapplpirj3jor716p` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`);

--
-- Constraints for table `ptt_brojevi`
--
ALTER TABLE `ptt_brojevi`
  ADD CONSTRAINT `FK_299429h6eh3yovmkodsy1necx` FOREIGN KEY (`ptt_brojevi_id`) REFERENCES `drzave` (`id`);

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FK_apcc8lxk2xnug8377fatvbn04` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK_it77eq964jhfqtu54081ebtio` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
