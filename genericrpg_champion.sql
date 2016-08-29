CREATE DATABASE  IF NOT EXISTS `genericrpg` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `genericrpg`;
-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: genericrpg
-- ------------------------------------------------------
-- Server version	5.6.27-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `champion`
--

DROP TABLE IF EXISTS `champion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `champion` (
  `character_id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) NOT NULL,
  `character_name` varchar(20) NOT NULL,
  `char_strength` int(11) NOT NULL,
  `char_accuracy` int(11) NOT NULL,
  `char_speed` int(11) NOT NULL,
  `char_skill` int(11) NOT NULL,
  `char_knowledge` int(11) NOT NULL,
  `char_level` int(11) NOT NULL,
  `char_exp` decimal(10,3) NOT NULL,
  `char_total_exp` decimal(10,3) NOT NULL,
  `char_action_1` varchar(4) NOT NULL,
  `char_action_2` varchar(4) NOT NULL,
  `char_action_3` varchar(4) NOT NULL,
  `char_action_4` varchar(4) NOT NULL,
  `char_portrait` varchar(50) NOT NULL,
  `beginner_wins` int(5) DEFAULT NULL,
  `beginner_losses` int(5) DEFAULT NULL,
  `apprentice_wins` int(5) DEFAULT NULL,
  `apprentice_losses` int(5) DEFAULT NULL,
  `master_wins` int(5) DEFAULT NULL,
  `master_losses` int(5) DEFAULT NULL,
  `boss_wins` int(5) DEFAULT NULL,
  `boss_losses` int(5) DEFAULT NULL,
  PRIMARY KEY (`character_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `champion`
--

LOCK TABLES `champion` WRITE;
/*!40000 ALTER TABLE `champion` DISABLE KEYS */;
INSERT INTO `champion` VALUES (1,1,'Test_Char',5,5,5,5,5,1,4.000,4.000,'A001','B001','C001','D001','Images/CharacterIcons/americanguy.jpg',1,0,1,0,0,0,0,0),(2,1,'Test_Char2',3,4,5,6,7,1,0.000,0.000,'A001','B001','C001','E001','Images/CharacterIcons/discodude.jpg',0,0,0,0,0,0,0,0),(3,1,'Test_Char3',4,5,6,7,3,1,0.000,0.000,'B001','C001','D001','E001','Images/CharacterIcons/inconspicuousflower.jpg',0,0,0,0,0,0,0,0),(4,1,'Test_Char4',5,6,7,3,4,1,0.000,0.000,'A001','B001','D001','E001','Images/CharacterIcons/scarydragon.jpg',0,0,0,0,0,0,0,0),(5,1,'Test_Char5',6,7,3,4,5,1,0.000,0.000,'A001','C001','D001','E001','Images/CharacterIcons/sillysnail.jpg',0,0,0,0,0,0,0,0),(6,1,'Test_Char6',7,3,4,5,6,1,0.000,0.000,'B001','C001','E001','A001','Images/CharacterIcons/spookywitch.jpg',0,0,0,0,0,0,0,0),(7,1,'Test_Char7',7,6,5,4,3,1,0.000,0.000,'C001','D001','E001','B001','Images/CharacterIcons/stupidhorse.jpg',0,0,0,0,0,0,0,0),(8,1,'Test_Char8',3,7,4,6,5,1,0.000,0.000,'D001','E001','A001','B001','Images/CharacterIcons/trickycat.jpg',0,0,0,0,0,0,0,0),(9,1,'Test_Create',5,5,5,5,5,1,0.000,0.000,'A001','B001','C001','D001','Images/CharacterIcons/americanguy.jpg',0,0,0,0,0,0,0,0),(29,2,'Bobby Sue',8,5,4,3,5,1,4.000,4.000,'A001','B001','C001','D001','Images/CharacterIcons/inconspicuousflower.jpg',1,0,0,0,0,0,0,0);
/*!40000 ALTER TABLE `champion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-28 20:20:19
