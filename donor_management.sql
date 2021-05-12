-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 12, 2021 at 09:05 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 7.4.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `donor_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `available_organs`
--

CREATE TABLE `available_organs` (
  `Organ_id` int(5) NOT NULL,
  `Donor_name` varchar(20) NOT NULL,
  `Blood_group` varchar(5) NOT NULL,
  `Organ_Type` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `available_organs`
--

INSERT INTO `available_organs` (`Organ_id`, `Donor_name`, `Blood_group`, `Organ_Type`) VALUES
(1, 'Nithin', 'B+', 'Eyes'),
(2, 'Vanaja', 'O+', 'Heart'),
(3, 'Prajwal', 'A+', 'Lungs');

-- --------------------------------------------------------

--
-- Table structure for table `eyes`
--

CREATE TABLE `eyes` (
  `P_id` int(5) NOT NULL,
  `P_name` varchar(20) NOT NULL,
  `Blood_group` varchar(10) NOT NULL,
  `H_id` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `eyes`
--

INSERT INTO `eyes` (`P_id`, `P_name`, `Blood_group`, `H_id`) VALUES
(1, 'Patient_1', 'B-', 3),
(2, 'Patient_2', 'A-', 1);

-- --------------------------------------------------------

--
-- Table structure for table `heart`
--

CREATE TABLE `heart` (
  `P_id` int(5) NOT NULL,
  `P_name` varchar(20) NOT NULL,
  `Blood_group` varchar(10) NOT NULL,
  `H_id` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `heart`
--

INSERT INTO `heart` (`P_id`, `P_name`, `Blood_group`, `H_id`) VALUES
(1, 'Patient_1', 'O+', 2),
(2, 'Patient_2', 'O-', 2);

-- --------------------------------------------------------

--
-- Table structure for table `hospital`
--

CREATE TABLE `hospital` (
  `H_id` int(5) NOT NULL,
  `H_name` varchar(20) NOT NULL,
  `H_address` varchar(30) NOT NULL,
  `Phone` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hospital`
--

INSERT INTO `hospital` (`H_id`, `H_name`, `H_address`, `Phone`) VALUES
(1, 'Columbia Asia', 'Mysore', '9988778899'),
(2, 'KMC ', 'Manipal', '8877887788'),
(3, 'Fortis', 'rajajinagar', '7788997788');

-- --------------------------------------------------------

--
-- Table structure for table `kidney`
--

CREATE TABLE `kidney` (
  `P_id` int(5) NOT NULL,
  `P_name` varchar(20) NOT NULL,
  `Blood_group` varchar(10) NOT NULL,
  `H_id` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kidney`
--

INSERT INTO `kidney` (`P_id`, `P_name`, `Blood_group`, `H_id`) VALUES
(1, 'Patient_1', 'A+', 1),
(2, 'Patient_2', 'B+', 2);

-- --------------------------------------------------------

--
-- Table structure for table `liver`
--

CREATE TABLE `liver` (
  `P_id` int(5) NOT NULL,
  `P_name` varchar(20) NOT NULL,
  `Blood_group` varchar(10) NOT NULL,
  `H_id` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `liver`
--

INSERT INTO `liver` (`P_id`, `P_name`, `Blood_group`, `H_id`) VALUES
(1, 'Patient_1', 'AB+', 1),
(2, 'Patient_2', 'AB-', 3);

-- --------------------------------------------------------

--
-- Table structure for table `lungs`
--

CREATE TABLE `lungs` (
  `P_id` int(5) NOT NULL,
  `P_name` varchar(20) NOT NULL,
  `Blood_group` varchar(10) NOT NULL,
  `H_id` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `lungs`
--

INSERT INTO `lungs` (`P_id`, `P_name`, `Blood_group`, `H_id`) VALUES
(1, 'Patient_1', 'A+', 3),
(2, 'Patient_2', 'AB-', 2);

-- --------------------------------------------------------

--
-- Table structure for table `registered_donor`
--

CREATE TABLE `registered_donor` (
  `id` int(5) NOT NULL,
  `name` varchar(20) NOT NULL,
  `f_name` varchar(20) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Age` varchar(3) NOT NULL,
  `Live_Status` varchar(10) NOT NULL,
  `Blood_group` varchar(5) NOT NULL,
  `Organ_Type` varchar(10) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `email` varchar(20) NOT NULL,
  `address` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `registered_donor`
--

INSERT INTO `registered_donor` (`id`, `name`, `f_name`, `Gender`, `Age`, `Live_Status`, `Blood_group`, `Organ_Type`, `phone`, `email`, `address`) VALUES
(2, 'Nithin', 'Blah', 'MALE', '28', 'Alive', 'B+', 'Eyes', '9988778877', 'nithin@gmail.com', 'Bangalore');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `available_organs`
--
ALTER TABLE `available_organs`
  ADD PRIMARY KEY (`Organ_id`);

--
-- Indexes for table `eyes`
--
ALTER TABLE `eyes`
  ADD PRIMARY KEY (`P_id`),
  ADD KEY `H_id` (`H_id`);

--
-- Indexes for table `heart`
--
ALTER TABLE `heart`
  ADD PRIMARY KEY (`P_id`),
  ADD KEY `H_id` (`H_id`);

--
-- Indexes for table `hospital`
--
ALTER TABLE `hospital`
  ADD PRIMARY KEY (`H_id`);

--
-- Indexes for table `kidney`
--
ALTER TABLE `kidney`
  ADD PRIMARY KEY (`P_id`),
  ADD KEY `H_id` (`H_id`);

--
-- Indexes for table `liver`
--
ALTER TABLE `liver`
  ADD PRIMARY KEY (`P_id`),
  ADD KEY `H_id` (`H_id`);

--
-- Indexes for table `lungs`
--
ALTER TABLE `lungs`
  ADD PRIMARY KEY (`P_id`),
  ADD KEY `H_id` (`H_id`);

--
-- Indexes for table `registered_donor`
--
ALTER TABLE `registered_donor`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
