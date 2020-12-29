SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id8665065_android`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_comments_messages`
--
CREATE DATABASE IF NOT EXISTS `id8665065_android`;
USE  `id8665065_android`;

CREATE TABLE `tbl_comments_messages` (
  `id` int(11) NOT NULL,
  `userName` varchar(15) NOT NULL,
  `message` text NOT NULL,
  `comment` text NOT NULL,
  `companyName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_useraccess`
--

CREATE TABLE `tbl_useraccess` (
  `id` int(11) NOT NULL,
  `userName` varchar(15) NOT NULL,
  `passWord` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_useraccess`
--

INSERT INTO `tbl_useraccess` (`id`, `userName`, `passWord`) VALUES
(1, 'a', '0cc175b9c0f1b6a831c399e269772661'),
(2, 'mel', '0ef174fc614c8d61e2d63329ef7f46c0');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_useraccount`
--

CREATE TABLE `tbl_useraccount` (
  `id` int(11) NOT NULL,
  `firstName` varchar(30) NOT NULL,
  `middleName` varchar(30) NOT NULL,
  `lastName` varchar(30) NOT NULL,
  `userName` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_useraccount`
--

INSERT INTO `tbl_useraccount` (`id`, `firstName`, `middleName`, `lastName`, `userName`) VALUES
(1, 'A', 'A', 'A', 'a'),
(2, 'Roms', 'Mels', 'Lags', 'mel');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_userinformation`
--

CREATE TABLE `tbl_userinformation` (
  `id` int(11) NOT NULL,
  `userName` varchar(15) NOT NULL,
  `companyName` varchar(50) NOT NULL,
  `companyAddress` varchar(100) NOT NULL,
  `contact` int(10) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_userinformation`
--

INSERT INTO `tbl_userinformation` (`id`, `userName`, `companyName`, `companyAddress`, `contact`, `email`) VALUES
(1, 'a', 'A', 'A', 4, 'a'),
(2, 'mel', 'Info', 'North', 6642, 'mel@mel.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_comments_messages`
--
ALTER TABLE `tbl_comments_messages`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_useraccess`
--
ALTER TABLE `tbl_useraccess`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_useraccount`
--
ALTER TABLE `tbl_useraccount`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_userinformation`
--
ALTER TABLE `tbl_userinformation`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_comments_messages`
--
ALTER TABLE `tbl_comments_messages`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_useraccess`
--
ALTER TABLE `tbl_useraccess`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_useraccount`
--
ALTER TABLE `tbl_useraccount`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_userinformation`
--
ALTER TABLE `tbl_userinformation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
