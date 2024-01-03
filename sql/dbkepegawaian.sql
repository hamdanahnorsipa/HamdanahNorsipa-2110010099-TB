-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 03, 2024 at 06:49 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.3.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbkepegawaian`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_absensi`
--

CREATE TABLE `tb_absensi` (
  `id_absensi` int(11) NOT NULL,
  `id_pegawai` int(11) NOT NULL,
  `tanggal` varchar(20) NOT NULL,
  `jam_masuk` varchar(30) NOT NULL,
  `jam_keluar` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_absensi`
--

INSERT INTO `tb_absensi` (`id_absensi`, `id_pegawai`, `tanggal`, `jam_masuk`, `jam_keluar`) VALUES
(2020, 223, '11/12/23', '08.00', '16.00'),
(2225, 225, '11/12/23', '08.00', '16.00');

-- --------------------------------------------------------

--
-- Table structure for table `tb_dapartemen`
--

CREATE TABLE `tb_dapartemen` (
  `id_dapartemen` int(11) NOT NULL,
  `nama_dapartemen` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_dapartemen`
--

INSERT INTO `tb_dapartemen` (`id_dapartemen`, `nama_dapartemen`) VALUES
(1013, 'Manajemen Sumber Daya Manusia'),
(1015, 'Administrator Personalia'),
(1104, 'Manajemen Data Magang'),
(1111, 'Manager'),
(1201, 'Manajemen Data Pegawai');

-- --------------------------------------------------------

--
-- Table structure for table `tb_gaji`
--

CREATE TABLE `tb_gaji` (
  `id_gaji` int(11) NOT NULL,
  `id_pegawai` int(11) NOT NULL,
  `jumlah_gaji` varchar(50) NOT NULL,
  `tanggal_pembayaran` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_gaji`
--

INSERT INTO `tb_gaji` (`id_gaji`, `id_pegawai`, `jumlah_gaji`, `tanggal_pembayaran`) VALUES
(2828, 225, '5.000.000', '01/12/23'),
(4848, 223, '6.000.00', '01/12/23');

-- --------------------------------------------------------

--
-- Table structure for table `tb_pegawai`
--

CREATE TABLE `tb_pegawai` (
  `id_pegawai` int(11) NOT NULL,
  `id_dapartemen` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `tanggal_lahir` varchar(20) NOT NULL,
  `jenis_kelamin` varchar(20) NOT NULL,
  `alamat` varchar(30) NOT NULL,
  `nomor_telepon` varchar(15) NOT NULL,
  `email` varchar(20) NOT NULL,
  `posisi` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_pegawai`
--

INSERT INTO `tb_pegawai` (`id_pegawai`, `id_dapartemen`, `nama`, `tanggal_lahir`, `jenis_kelamin`, `alamat`, `nomor_telepon`, `email`, `posisi`) VALUES
(123, 1104, 'Daffa Adijaya', '21/09/95', 'Laki-Laki', 'Jl. Banua Indah', '081928763567', 'daf@gmail.com', 'Pengelola Data Magang'),
(223, 1201, 'SalsaBila', '10/10/99', 'Perempuan', 'Jl Basirih Utara', '088938273656', 'sasa@gmail.com', 'Pengelola Pegawai Kontrak'),
(225, 1015, 'Kanaya', '05/02/96', 'Perempuan', 'Jl Tembus Mantuil', '081984536192', 'naya@gmail.com', 'Manajemen Absensi');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_absensi`
--
ALTER TABLE `tb_absensi`
  ADD PRIMARY KEY (`id_absensi`),
  ADD KEY `id_pegawai` (`id_pegawai`);

--
-- Indexes for table `tb_dapartemen`
--
ALTER TABLE `tb_dapartemen`
  ADD PRIMARY KEY (`id_dapartemen`);

--
-- Indexes for table `tb_gaji`
--
ALTER TABLE `tb_gaji`
  ADD PRIMARY KEY (`id_gaji`),
  ADD KEY `id_pegawai` (`id_pegawai`);

--
-- Indexes for table `tb_pegawai`
--
ALTER TABLE `tb_pegawai`
  ADD PRIMARY KEY (`id_pegawai`),
  ADD KEY `id_dapartemen` (`id_dapartemen`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_absensi`
--
ALTER TABLE `tb_absensi`
  MODIFY `id_absensi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9991;

--
-- AUTO_INCREMENT for table `tb_dapartemen`
--
ALTER TABLE `tb_dapartemen`
  MODIFY `id_dapartemen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1803;

--
-- AUTO_INCREMENT for table `tb_gaji`
--
ALTER TABLE `tb_gaji`
  MODIFY `id_gaji` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4849;

--
-- AUTO_INCREMENT for table `tb_pegawai`
--
ALTER TABLE `tb_pegawai`
  MODIFY `id_pegawai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=422;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_absensi`
--
ALTER TABLE `tb_absensi`
  ADD CONSTRAINT `tb_absensi_ibfk_1` FOREIGN KEY (`id_pegawai`) REFERENCES `tb_pegawai` (`id_pegawai`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tb_gaji`
--
ALTER TABLE `tb_gaji`
  ADD CONSTRAINT `tb_gaji_ibfk_1` FOREIGN KEY (`id_pegawai`) REFERENCES `tb_pegawai` (`id_pegawai`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tb_pegawai`
--
ALTER TABLE `tb_pegawai`
  ADD CONSTRAINT `tb_pegawai_ibfk_1` FOREIGN KEY (`id_dapartemen`) REFERENCES `tb_dapartemen` (`id_dapartemen`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
