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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `accountID` int(11) NOT NULL AUTO_INCREMENT,
  `accountName` varchar(15) NOT NULL,
  `accountPassword` varchar(10) NOT NULL,
  `accountEmail` varchar(25) NOT NULL,
  `accountActiveChampID` int(11) NOT NULL,
  `accountPrivileges` int(11) NOT NULL,
  `accountOnline` bit(1) NOT NULL,
  `accountExp` decimal(10,2) NOT NULL,
  `accountTotalExp` decimal(13,2) NOT NULL,
  `accountLevel` int(3) NOT NULL,
  PRIMARY KEY (`accountID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'Admin','doge','newaddress@gmail.com',0,0,'\0',546.78,1046.78,1),(2,'Alyssa','sesame','ak@bb.com',0,1,'\0',0.00,0.00,1),(3,'Red','pikachu','red@mail.com',31,1,'',3.33,3.33,1),(10,'new','1234','',0,0,'\0',0.00,0.00,1),(11,'NewAccount','7777','none',0,0,'\0',0.00,0.00,1);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `actions`
--

DROP TABLE IF EXISTS `actions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `actions` (
  `action_id` int(11) NOT NULL AUTO_INCREMENT,
  `action_name` varchar(255) DEFAULT NULL,
  `action_acc` int(11) DEFAULT NULL,
  `action_know` int(11) DEFAULT NULL,
  `action_skill` int(11) DEFAULT NULL,
  `action_spd` int(11) DEFAULT NULL,
  `action_str` int(11) DEFAULT NULL,
  `action_dmg` int(11) DEFAULT NULL,
  `action_heal` int(11) DEFAULT NULL,
  `action_hitchance` double DEFAULT NULL,
  PRIMARY KEY (`action_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actions`
--

LOCK TABLES `actions` WRITE;
/*!40000 ALTER TABLE `actions` DISABLE KEYS */;
/*!40000 ALTER TABLE `actions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `battle`
--

DROP TABLE IF EXISTS `battle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `battle` (
  `turnID` int(11) NOT NULL AUTO_INCREMENT,
  `battleID` int(11) NOT NULL,
  `accountID` int(11) NOT NULL,
  `opponentID` int(11) NOT NULL,
  `championID` int(11) NOT NULL,
  `playerMove` int(11) NOT NULL,
  `compMove` int(11) NOT NULL,
  `playerHP` int(11) NOT NULL,
  `compHP` int(11) NOT NULL,
  `playerDMG` int(11) NOT NULL,
  `compDMG` int(11) NOT NULL,
  `playerHeal` int(11) NOT NULL,
  `compHeal` int(11) NOT NULL,
  `playerHit` varchar(1) NOT NULL,
  `compHit` varchar(1) NOT NULL,
  `playerCrit` varchar(1) NOT NULL,
  `compCrit` varchar(1) NOT NULL,
  `difficultyLevel` varchar(45) NOT NULL,
  PRIMARY KEY (`turnID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `battle`
--

LOCK TABLES `battle` WRITE;
/*!40000 ALTER TABLE `battle` DISABLE KEYS */;
INSERT INTO `battle` VALUES (1,1,1,18,2,0,0,0,0,0,0,0,0,'0','0','0','0','beginner'),(2,1,1,28,38,0,0,0,0,0,0,0,0,'0','0','0','0','beginner'),(3,1,1,36,34,0,0,0,0,0,0,0,0,'0','0','0','0','beginner'),(4,1,1,31,38,0,0,0,0,0,0,0,0,'0','0','0','0','beginner'),(5,2,1,5,38,0,0,0,0,0,0,0,0,'0','0','0','0','beginner'),(6,3,1,14,6,0,0,0,0,0,0,0,0,'0','0','0','0','beginner'),(7,4,1,11,37,0,0,0,0,0,0,0,0,'0','0','0','0','beginner'),(8,5,1,2,35,0,0,0,0,0,0,0,0,'0','0','0','0','beginner'),(9,6,1,18,35,0,0,325,295,0,0,0,0,'0','0','0','0','beginner'),(10,7,1,24,35,0,0,325,315,0,0,0,0,'0','0','0','0','beginner'),(11,8,1,21,35,0,0,325,315,0,0,0,0,'0','0','0','0','beginner');
/*!40000 ALTER TABLE `battle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `champion`
--

DROP TABLE IF EXISTS `champion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `champion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accountID` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `strength` int(11) NOT NULL,
  `accuracy` int(11) NOT NULL,
  `speed` int(11) NOT NULL,
  `skill` int(11) NOT NULL,
  `knowledge` int(11) NOT NULL,
  `levelz` int(11) NOT NULL,
  `exp` decimal(10,3) NOT NULL,
  `totalExp` decimal(10,3) NOT NULL,
  `moveID1` int(11) NOT NULL,
  `moveID2` int(11) NOT NULL,
  `moveID3` int(11) NOT NULL,
  `moveID4` int(11) NOT NULL,
  `portrait` varchar(50) NOT NULL,
  `beginner_wins` int(5) NOT NULL,
  `beginner_losses` int(5) NOT NULL,
  `apprentice_wins` int(5) NOT NULL,
  `apprentice_losses` int(5) NOT NULL,
  `master_wins` int(5) NOT NULL,
  `master_losses` int(5) NOT NULL,
  `boss_wins` int(5) NOT NULL,
  `boss_losses` int(5) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_accID_idx` (`accountID`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `champion`
--

LOCK TABLES `champion` WRITE;
/*!40000 ALTER TABLE `champion` DISABLE KEYS */;
INSERT INTO `champion` VALUES (1,1,'Test_Char',218,24,85,36,37,5,177.675,372.675,1,16,15,2,'images/icons/americanguy.jpg',23,0,1,0,0,0,2,0),(2,1,'Test_Char2',130,74,205,56,12,4,18.600,108.600,2,15,14,16,'images/icons/discodude.jpg',10,0,4,0,1,0,0,0),(3,1,'Test_Char3',84,35,56,37,3,2,24.275,24.275,3,14,13,1,'images/icons/inconspicuousflower.jpg',2,0,0,0,1,1,0,0),(4,1,'Test_Char4',15,6,17,3,4,2,9.400,9.400,4,13,12,3,'images/icons/scarydragon.jpg',1,0,0,1,0,1,0,0),(5,1,'Test_Char5',26,17,3,4,5,2,1.680,1.680,5,12,11,4,'images/icons/sillysnail.jpg',0,0,1,0,0,0,0,0),(6,1,'Test_Char6',17,13,24,15,6,2,1.680,1.680,6,11,9,5,'images/icons/spookywitch.jpg',0,0,1,0,0,0,0,0),(7,1,'Test_Char7',19,12,5,34,3,2,24.505,24.505,7,10,8,6,'images/icons/stupidhorse.jpg',0,0,1,1,0,0,1,1),(8,1,'Test_Char8',100,7,24,6,5,3,46.345,46.345,8,9,10,7,'images/icons/trickycat.jpg',3,0,3,0,0,0,0,0),(9,1,'Test_Create',5,5,5,5,5,1,0.000,0.000,9,8,7,10,'images/icons/americanguy.jpg',0,0,0,0,0,0,0,0),(29,2,'Bobby Sue',8,5,4,3,5,1,4.000,4.000,10,7,6,8,'images/icons/inconspicuousflower.jpg',1,0,0,0,0,0,0,0),(30,1,'Dogbone',101,29,21,13,10,4,24.885,24.885,11,6,5,9,'images/icons/scarydragon.jpg',5,0,0,0,1,0,0,0),(31,3,'Pikachu',15,15,15,5,5,3,1.515,1.515,12,5,4,11,'images/icons/trickycat.jpg',1,0,0,0,0,0,0,0),(32,1,'New Guy',30,13,4,4,4,3,4.210,4.210,13,4,3,12,'images/icons/americanguy.jpg',2,0,0,0,0,0,0,0),(33,1,'TestCharv.13',17,13,15,14,16,3,14.385,139.385,14,3,2,13,'images/icons/scarydragon.jpg',4,0,0,3,0,4,0,11),(34,1,'Yellow',27,15,30,15,5,1,1.680,1.680,15,2,1,14,'images/icons/sillysnail.jpg',0,0,0,1,0,0,0,0),(35,1,'treyt',5,5,5,5,5,1,0.000,0.000,1,2,3,4,'images/icons/americanguy.jpg',0,0,0,0,0,0,0,0),(36,1,'new guy',5,5,5,5,5,1,0.000,0.000,1,2,3,4,'images/icons/discodude.jpg',0,0,0,0,0,0,0,0),(37,1,'Bobert',5,5,5,5,5,1,0.000,0.000,1,2,3,4,'images/icons/scarydragon.jpg',0,0,0,0,0,0,0,0),(38,1,'Flower',5,5,5,5,5,1,0.000,0.000,1,2,3,4,'images/icons/inconspicuousflower.jpg',0,0,0,0,0,0,0,0);
/*!40000 ALTER TABLE `champion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `levelxptable`
--

DROP TABLE IF EXISTS `levelxptable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `levelxptable` (
  `theLevel` int(11) NOT NULL,
  `accountTotalXP` bigint(20) DEFAULT NULL,
  `accountXP2Next` bigint(20) DEFAULT NULL,
  `apprentice` double DEFAULT NULL,
  `beginner` double DEFAULT NULL,
  `boss` double DEFAULT NULL,
  `champTotalXP` bigint(20) DEFAULT NULL,
  `champXP2Next` bigint(20) DEFAULT NULL,
  `master` double DEFAULT NULL,
  PRIMARY KEY (`theLevel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `levelxptable`
--

LOCK TABLES `levelxptable` WRITE;
/*!40000 ALTER TABLE `levelxptable` DISABLE KEYS */;
/*!40000 ALTER TABLE `levelxptable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `move`
--

DROP TABLE IF EXISTS `move`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `move` (
  `id` int(11) NOT NULL,
  `name` varchar(32) NOT NULL,
  `strength` int(11) NOT NULL,
  `accuracy` int(11) NOT NULL,
  `speed` int(11) NOT NULL,
  `skill` int(11) NOT NULL,
  `knowledge` int(11) NOT NULL,
  `damage` int(11) NOT NULL,
  `hitChance` decimal(5,2) NOT NULL,
  `healz` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `move`
--

LOCK TABLES `move` WRITE;
/*!40000 ALTER TABLE `move` DISABLE KEYS */;
INSERT INTO `move` VALUES (1,'Rush',0,0,5,0,0,120,75.00,0),(2,'Blitz',1,0,5,0,0,150,65.00,0),(3,'Pummel',0,0,0,0,0,70,100.00,0),(4,'Lightning Strikes',5,0,5,0,0,90,85.00,0),(5,'Bunker Down',5,0,-1,0,5,0,100.00,70),(6,'Battle Stations',1,1,-5,5,5,0,90.00,40),(7,'Massive Blow',1,0,0,0,0,170,65.00,0),(8,'Bombardment',5,-1,-5,0,0,240,75.00,0),(9,'Meditate',0,5,0,1,1,0,100.00,100),(10,'Lock-On',1,10,1,1,5,0,100.00,0),(11,'Steal Life',0,0,0,0,0,60,85.00,60),(12,'Steal Soul',0,0,0,0,0,140,65.00,140),(13,'Power Up',5,5,5,5,5,0,100.00,0),(14,'Lucky Chance',10,10,10,10,10,0,50.00,0),(15,'Heal',0,0,0,0,0,0,90.00,150),(16,'Greater Heal',0,0,0,0,0,0,85.00,270);
/*!40000 ALTER TABLE `move` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opponent`
--

DROP TABLE IF EXISTS `opponent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `opponent` (
  `id` int(11) NOT NULL,
  `name` varchar(15) NOT NULL,
  `strength` int(11) NOT NULL,
  `accuracy` int(11) NOT NULL,
  `speed` int(11) NOT NULL,
  `skill` int(11) NOT NULL,
  `knowledge` int(11) NOT NULL,
  `actionID1` varchar(4) NOT NULL,
  `actionID2` varchar(4) NOT NULL,
  `actionID3` varchar(4) NOT NULL,
  `actionID4` varchar(4) NOT NULL,
  `difficulty` varchar(13) NOT NULL,
  `portrait` varchar(45) NOT NULL,
  `levelz` int(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opponent`
--

LOCK TABLES `opponent` WRITE;
/*!40000 ALTER TABLE `opponent` DISABLE KEYS */;
INSERT INTO `opponent` VALUES (1,'Beg_55555',5,5,5,5,5,'1','2','3','4','1','images/icons/discodude.jpg',1),(2,'Beg_66544',6,6,5,4,4,'8','7','6','5','1','images/icons/scarydragon.jpg',1),(3,'Beg_44566',4,4,5,6,6,'9','10','11','12','1','images/icons/spookywitch.jpg',1),(4,'Beg_56644',5,6,6,4,4,'16','15','14','13','1','images/icons/inconspicuousflower.jpg',1),(5,'Beg_65644',6,5,6,4,4,'10','9','7','8','1','images/icons/sillysnail.jpg',1),(6,'Beg_66454',6,6,4,5,4,'6','7','8','9','1','images/icons/stupidhorse.jpg',1),(7,'Beg_46564',4,6,5,6,4,'2','3','4','5','1','images/icons/trickycat.jpg',1),(8,'Beg_64546',6,4,5,4,6,'4','6','9','3','1','images/icons/discodude.jpg',1),(9,'Beg_54645',5,4,6,4,6,'5','11','16','7','1','images/icons/scarydragon.jpg',1),(10,'Beg_56464',5,6,4,6,4,'8','13','14','10','1','images/icons/stupidhorse.jpg',1),(11,'Beg_54466',5,4,4,6,6,'9','7','1','2','1','images/icons/sillysnail.jpg',1),(12,'Beg_45646',4,5,6,4,6,'11','8','4','5','1','images/icons/inconspicuousflower.jpg',1),(13,'Beg_46654',4,6,6,5,4,'13','7','11','12','1','images/icons/trickycat.jpg',1),(14,'Beg_46456',4,6,4,5,6,'15','13','2','1','1','images/icons/spookywitch.jpg',1),(15,'Beg_56446',5,6,4,4,6,'14','3','11','9','1','images/icons/stupidhorse.jpg',1),(16,'Beg_65446',6,5,4,4,6,'7','4','14','10','1','images/icons/americanguy.jpg',1),(17,'Beg_73537',7,3,5,3,7,'3','5','15','7','1','images/icons/scarydragon.jpg',1),(18,'Beg_37573',3,7,5,7,3,'1','6','4','13','1','images/icons/trickycat.jpg',1),(19,'Beg_57733',5,7,7,3,3,'16','7','2','12','1','images/icons/spookywitch.jpg',1),(20,'Beg_53377',5,3,3,7,7,'15','8','1','10','1','images/icons/stupidhorse.jpg',1),(21,'Beg_57373',5,7,3,7,3,'14','9','16','3','1','images/icons/discodude.jpg',1),(22,'Beg_53737',5,3,7,3,7,'13','10','7','4','1','images/icons/trickycat.jpg',1),(23,'Beg_57337',5,7,3,3,7,'12','11','6','5','1','images/icons/inconspicuousflower.jpg',1),(24,'Beg_53773',5,3,7,7,3,'11','12','4','6','1','images/icons/discodude.jpg',1),(25,'Beg_77533',7,7,5,3,3,'10','13','5','7','1','images/icons/spookywitch.jpg',1),(26,'Beg_75733',7,5,7,3,3,'9','14','1','8','1','images/icons/spookywitch.jpg',1),(27,'Beg_77353',7,7,3,5,3,'8','15','2','9','1','images/icons/discodude.jpg',1),(28,'Beg_77335',7,7,3,3,5,'7','16','3','10','1','images/icons/scarydragon.jpg',1),(29,'Beg_73573',7,3,5,7,3,'6','15','9','11','1','images/icons/trickycat.jpg',1),(30,'Beg_73375',7,3,3,7,5,'5','14','11','12','1','images/icons/inconspicuousflower.jpg',1),(31,'Beg_73357',7,3,3,5,7,'4','13','7','14','1','images/icons/sillysnail.jpg',1),(32,'Beg_33775',3,3,7,7,5,'3','12','16','13','1','images/icons/americanguy.jpg',1),(33,'Beg_33757',3,3,7,5,7,'2','11','1','15','1','images/icons/stupidhorse.jpg',1),(34,'Beg_33577',3,3,5,7,7,'1','10','2','16','1','images/icons/inconspicuousflower.jpg',1),(35,'Beg_35377',3,5,3,7,7,'11','9','3','15','1','images/icons/spookywitch.jpg',1),(36,'Beg_35737',3,5,7,3,7,'15','8','4','14','1','images/icons/americanguy.jpg',1),(37,'Beg_35773',3,5,7,7,3,'14','7','6','13','1','images/icons/sillysnail.jpg',1),(38,'Beg_37753',3,7,7,5,3,'13','6','5','12','1','images/icons/sillysnail.jpg',1),(39,'Beg_37735',3,7,7,3,5,'9','5','7','11','1','images/icons/discodude.jpg',1),(40,'Beg_37375',3,7,3,7,5,'6','4','8','10','1','images/icons/scarydragon.jpg',1),(41,'Beg_37537',3,7,5,3,7,'3','2','9','8','1','images/icons/americanguy.jpg',1);
/*!40000 ALTER TABLE `opponent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accountID` int(11) NOT NULL,
  `accountName` varchar(45) NOT NULL,
  `postDate` date NOT NULL,
  `text` varchar(2048) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_accID_idx` (`accountID`),
  KEY `FK_postAccID_idx` (`accountID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (1,1,'Admin','2015-12-26','Most the major bugs have been worked out and most of \nall operations are running as intended. This project\nimplements HTML, SQL, CSS, Javascript, and \nJava Servlets & JSP. There is also use of JSTL and \nExpression Language. For this next semester I will\nbe adding Struts & Hibernate as needed to streamline\nthe code for this project. To be used in Web Development I \nand Java Struts & Hibernate for the Fall Semester at \nSTLCC - Forest Park.'),(2,1,'Admin','2015-12-26','I\'ve finished the better part of Servlet and Class structure\nfor this website. The databases are created, and the user can\nlogin by querying the database for a account name and password.\nThey can view all of their characters and statistics.\nCreate New Characters.\nA New Account can be created and added to the database.\nAnd the servlet to load the battle into the Battle class object is built, not tested yet.\nNot yet tested for bad data entry, but safeguards have been built.\nAdjustments were made to the html (now jsp) pages to display data\nfrom the request objects sent by the servlets, and css was edited\nfor minor differences in tags.\nMy new computer has a larger monitor, so I adjusted some of the css\nand built a new display shell for the page design at 1990 resolution.'),(3,1,'Admin','2015-05-15','I\'ve finished building most the design aspects, except for the battle screen. I\'m not quite sure what else to create external links to so I\'ll use this update as a shout-out to a few of the sites that I go to a lot for help with debugging & coding.</p>\n<ol>\n<li><a href=\"http://www.w3schools.com/\" target=\"_blank\">W3 Schools</a>    &nbsp;-&nbsp;Go to reference for tag and attribute names.</li>                          <li><a href=\"http://stackoverflow.com/\" target=\"_blank\">Stack Overflow</a>         &nbsp;-&nbsp;Good community of programmers with tons of threads on bugs and errors others have encountered and how they were solved.</li>                            <li><a href=\"http://www.ffiles.com/\" target=\"_blank\">FFiles</a>                             &nbsp;-&nbsp;Collection of mostly free flash files uploaded by members.</li>           <li><a href=\"https://www.youtube.com/\" target=\"_blank\">YouTube</a>                 &nbsp;-&nbsp;Other then the silly cat video I added. There are some good tutorials I\'ve used on there before to do certain code.</li>\n</ol>'),(4,1,'Admin','2015-05-10','<span class=\"update_highlight\">I got the first 6 char_icons finished!</span>\n<ul id=\"image_list\">\n<li>American Guy:<br>\n<img width=\"100px\" height=\"100px\" src=\"images/icons/americanguy.jpg\" /></li>\n<li>Disco Dude:<br>\n<img width=\"100px\" height=\"100px\" src=\"images/icons/discodude.jpg\" /></li>\n<li>Inconspicuous Flower:<br>\n<img width=\"100px\" height=\"100px\" src=\"images/icons/inconspicuousflower.jpg\" /></li>\n<li>Scary Dragon:<br>\n<img width=\"100px\" height=\"100px\" src=\"images/icons/scarydragon.jpg\" /></li>\n<li>Silly Snail:<br>\n<img width=\"100px\" height=\"100px\" src=\"images/icons/sillysnail.jpg\" /></li>\n<li>Tricky Cat:<br>\n<img width=\"100px\" height=\"100px\" src=\"images/icons/trickycat.jpg\" /></li>\n</ul>'),(5,1,'Admin','2015-05-06','Successfully did the things I said I finished in yesterday\'s (8 hours ago) update.\n<br>\n<span class=\"update_highlight\">\nHere\'s a cat video\n<br>\nThere will be no Cat Boss... ; )\n</span>\r<iframe width=\"350\" height=\"209\" src=\"https://www.youtube.com/embed/_ifYax8Smoc\" frameborder=\"0\" allowfullscreen></iframe>'),(6,1,'Admin','2015-05-05','Talked with Professor Kahan today, and decided to not include the back-end\ncode with this project. This will focus on aesthetic aspects of the site. So..\n<br>\n<span class=\"update_highlight\">Here\'s what I accomplished today:</span>\n<ul>\n<li><span style=\"top:-5px; position:relative;\">Built Table Design for View Stats & View Characters</span></li>\n<li><span style=\"top:-5px; position:relative;\">Restructured ScrollView & Title Area of General Frame</span></li>\n<li><span style=\"top:-5px; position:relative;\">Built Battle Menu & Battle Screen Layout</span></li>\n<li><span style=\"top:-5px; position:relative;\">Moved to Eclipse...useless for the time being though...</span></li>\n</ul>'),(7,1,'Admin','2015-05-05','Got a good general layout for the main page, and it should be\neasy to transfer it to the support pages. I have the general layout\nin mind, and the structure building in NetBeans. Tomorrow, I\'m\nplanning more work in the morning, then run it past Prof. Kahan.'),(8,1,'Admin','2015-05-04','The Battle Screen is Finished! (At least as far as the first design iteration,\ngiven background coding in the future, won\'t make me have to rethink the display.)\nI added a @media only screen attribute to help with layout distortion for screens\nless then 1440 pixel width. (That\'s what mine is.) \nSo it should handle 1280 pixel width adequately. \nAs suggested by my mother, I redid the anchor jump sword,\nso hopefully it looks less like a syringe now. \nIt has also been added to the view character/stats pages\ngiven live a player account could have well over the 4\nsample characters I put in.'),(9,1,'Admin','2016-10-07','Test'),(10,1,'Admin','2017-02-25','new post');
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posts`
--

DROP TABLE IF EXISTS `posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `posts` (
  `post_ID` int(11) NOT NULL AUTO_INCREMENT,
  `post_accountID` int(11) DEFAULT NULL,
  `post_accountName` varchar(255) DEFAULT NULL,
  `post_date` date DEFAULT NULL,
  `post_text` varchar(255) DEFAULT NULL,
  `account_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`post_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posts`
--

LOCK TABLES `posts` WRITE;
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xpchart`
--

DROP TABLE IF EXISTS `xpchart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `xpchart` (
  `theLevel` int(11) NOT NULL,
  `accountXP2Next` bigint(17) NOT NULL,
  `champXP2Next` bigint(17) NOT NULL,
  `beginner` decimal(10,2) NOT NULL,
  `apprentice` decimal(10,2) NOT NULL,
  `master` decimal(10,2) NOT NULL,
  `boss` decimal(10,2) NOT NULL,
  `champTotalXP` bigint(12) NOT NULL,
  `accountTotalXP` bigint(12) NOT NULL,
  PRIMARY KEY (`theLevel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xpchart`
--

LOCK TABLES `xpchart` WRITE;
/*!40000 ALTER TABLE `xpchart` DISABLE KEYS */;
INSERT INTO `xpchart` VALUES (1,500,55,1.01,1.68,2.52,5.03,55,500),(2,750,70,1.07,1.83,2.57,4.28,125,1250),(3,1000,90,1.17,2.06,2.75,4.13,215,2250),(4,1500,125,1.27,2.29,3.26,4.58,340,3750),(5,2000,180,1.49,2.74,4.12,5.49,520,5750),(6,3000,270,1.76,3.08,4.93,6.17,790,8750),(7,5000,415,2.22,3.79,6.31,7.58,1205,13750),(8,7000,650,2.82,4.56,7.90,9.11,1675,20750),(9,10000,1030,3.75,5.87,10.43,11.74,2705,30750),(10,15000,1645,4.99,7.49,13.62,14.99,4350,45750),(11,20000,2640,6.86,10.01,18.49,20.03,6990,65750),(12,30000,4250,9.20,13.34,24.17,26.68,11240,95750),(13,50000,6855,12.72,18.34,32.82,36.69,18095,145750),(14,100000,11070,17.36,25.17,43.78,50.35,29165,245750),(15,150000,17890,24.28,35.37,60.26,70.75,47055,395750),(16,200000,28925,33.72,49.63,82.20,99.26,75980,595750),(17,300000,46780,47.79,70.89,114.96,141.79,122760,895750),(18,500000,75670,67.45,101.18,160.00,202.36,198430,1395750),(19,700000,122415,96.78,146.44,227.14,292.89,320845,2095750),(20,1000000,198050,138.50,209.37,318.69,418.75,518895,3095750),(21,1500000,302575,189.71,286.54,429.82,573.09,821470,4595750),(22,2000000,435990,247.73,373.93,554.37,747.87,1257460,6595750),(23,3000000,598295,310.81,468.90,688.51,937.80,1855755,9595750),(24,5000000,789490,377.75,569.63,829.76,1139.27,2645245,14595750),(25,10000000,1009575,0.00,0.00,0.00,0.00,3654820,24595750);
/*!40000 ALTER TABLE `xpchart` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-26 14:22:31
