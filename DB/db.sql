-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 16, 2022 at 08:06 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ex4`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `id` bigint(20) NOT NULL,
  `book_name` varchar(255) DEFAULT NULL,
  `discount` double NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`id`, `book_name`, `discount`, `image`, `price`, `quantity`) VALUES
(158, 'Harry Potter and the Sorcerer\'s Stone', 10, '//cdn.shopify.com/s/files/1/2181/2535/products/76813c8d0218cab5137b190541dce431_x700.gif?v=1514210268', 120, 15),
(159, 'A Game of Thrones - A Song of Ice and Fire', 5, 'https://www.whitcoulls.co.nz/content/products/65/72/5547265_MAIN.jpg?width=416&height=620&fit=bounds&enable=upscale&bg-color=ffffff&canvas=416%2C620', 120, 19),
(160, 'The lord of the ring', 7, 'https://d1w7fb2mkkr3kw.cloudfront.net/assets/images/book/lrg/9780/2611/9780261103252.jpg', 93, 21),
(161, 'Adventures of Robin Hood', 9, 'https://d1w7fb2mkkr3kw.cloudfront.net/assets/images/book/lrg/9781/4095/9781409522324.jpg', 78, 23),
(162, 'Wizard of Oz', 15, 'https://d1w7fb2mkkr3kw.cloudfront.net/assets/images/book/lrg/9781/4095/9781409555957.jpg', 99, 15),
(163, 'The Cat In The Hat', 20, 'https://i.harperapps.com/hcanz/covers/9780008201517/x293.jpg', 150, 0),
(164, 'alice in wonderland', 21, 'https://d1w7fb2mkkr3kw.cloudfront.net/assets/images/book/lrg/9781/4472/9781447279990.jpg', 101, 11),
(165, 'Charlie and the Chocolate Factory book', 25, 'https://d1w7fb2mkkr3kw.cloudfront.net/assets/images/book/lrg/9780/5933/9780593349663.jpg', 89.9, 21),
(166, 'Three men in a boat', 0, '//cdn.shopify.com/s/files/1/2181/2535/products/a3ea2940537b46aeb50778b03a3b6fea_x700.jpg?v=1514211035', 55, 30),
(167, 'The Adventures of Tom Sawyer', 0, 'https://images-na.ssl-images-amazon.com/images/I/51JGDWc-gBL._SX363_BO1,204,203,200_.jpg', 70, 40);

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(176);

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `id` bigint(20) NOT NULL,
  `amount` double NOT NULL,
  `date` datetime(6) DEFAULT NULL,
  `user` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`id`, `amount`, `date`, `user`) VALUES
(150, 57, '2022-06-16 16:08:31.000000', 'user1'),
(168, 204.15, '2022-06-16 17:22:28.000000', 'user3'),
(169, 214.64000000000001, '2022-06-16 17:23:35.000000', 'user2'),
(171, 214.64000000000001, '2022-06-16 18:01:46.000000', 'user1'),
(172, 108, '2022-06-16 18:03:15.000000', 'user3'),
(174, 108, '2022-06-16 18:04:06.000000', 'user2');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
