-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 29, 2017 at 02:24 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `makeawish`
--

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `name` text NOT NULL,
  `email` text NOT NULL,
  `password` text NOT NULL,
  `age` int(11) NOT NULL,
  `phone` int(11) NOT NULL,
  `altphone` int(11) NOT NULL,
  `gender` text NOT NULL,
  `approvedstatus` int(11) NOT NULL,
  `DOB` date NOT NULL,
  `hospital_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `donor`
--

CREATE TABLE `donor` (
  `did` int(11) NOT NULL,
  `name` text NOT NULL,
  `email` text NOT NULL,
  `password` int(11) NOT NULL,
  `date` date NOT NULL,
  `phone` int(11) NOT NULL,
  `location` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hospital`
--

CREATE TABLE `hospital` (
  `name` text NOT NULL,
  `location` text NOT NULL,
  `h_no` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `mawstaff`
--

CREATE TABLE `mawstaff` (
  `staffid` int(11) NOT NULL,
  `name` text NOT NULL,
  `email` text NOT NULL,
  `password` text NOT NULL,
  `gender` int(11) NOT NULL,
  `location` text NOT NULL,
  `DOB` date NOT NULL,
  `phone` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `pid` int(11) NOT NULL,
  `name` text NOT NULL,
  `age` int(11) NOT NULL,
  `DOB` date NOT NULL,
  `mothertongue` text NOT NULL,
  `fathername` text NOT NULL,
  `mothername` text NOT NULL,
  `guardianname` text NOT NULL,
  `hospital` text NOT NULL,
  `consent` text NOT NULL,
  `education` text NOT NULL,
  `gender` text NOT NULL,
  `address` text NOT NULL,
  `siblings` int(11) NOT NULL,
  `doc_id` int(11) NOT NULL,
  `vol_id` int(11) NOT NULL,
  `wish_id` int(11) NOT NULL,
  `disease` text NOT NULL,
  `phone` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `volunteers`
--

CREATE TABLE `volunteers` (
  `vid` int(11) NOT NULL,
  `email` text NOT NULL,
  `password` text NOT NULL,
  `gender` text NOT NULL,
  `location` text NOT NULL,
  `DOB` date NOT NULL,
  `type` int(11) NOT NULL,
  `free` int(11) NOT NULL,
  `phone` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `wishrecord`
--

CREATE TABLE `wishrecord` (
  `referreddetails` text NOT NULL,
  `w_id` int(11) NOT NULL,
  `pat_id` int(11) NOT NULL,
  `special_notes` text NOT NULL,
  `dateofadmission` date NOT NULL,
  `dateidentified` date NOT NULL,
  `wish1` text NOT NULL,
  `wish2` text NOT NULL,
  `wish3` text NOT NULL,
  `proposeddate` date NOT NULL,
  `rushwish` int(11) NOT NULL,
  `dateofsubmission` date NOT NULL,
  `daysrequired` int(11) NOT NULL,
  `approvedwish` int(11) NOT NULL,
  `v_id` int(11) NOT NULL,
  `D1` int(11) NOT NULL,
  `D2` int(11) NOT NULL,
  `D3` int(11) NOT NULL,
  `approvedbystaff` text NOT NULL,
  `approvaldate` date NOT NULL,
  `dateofwish` date NOT NULL,
  `infoaboutfamily` text NOT NULL,
  `infoaboutfriend` text NOT NULL,
  `govtidtaken` text NOT NULL,
  `favcolor` text NOT NULL,
  `favbook` text NOT NULL,
  `favgame` text NOT NULL,
  `favfood` text NOT NULL,
  `favmusic` text NOT NULL,
  `favhobby` text NOT NULL,
  `favshow` text NOT NULL,
  `favactor` text NOT NULL,
  `schooltrip` text NOT NULL,
  `futurewish` text NOT NULL,
  `input1` text NOT NULL,
  `input2` text NOT NULL,
  `input3` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
