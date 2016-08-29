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
-- Table structure for table `opponent`
--

DROP TABLE IF EXISTS `opponent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `opponent` (
  `opponent_id` int(11) NOT NULL,
  `opponent_name` varchar(15) DEFAULT NULL,
  `opp_strength` int(11) DEFAULT NULL,
  `opp_accuracy` int(11) DEFAULT NULL,
  `opp_speed` int(11) DEFAULT NULL,
  `opp_skill` int(11) DEFAULT NULL,
  `opp_knowledge` int(11) DEFAULT NULL,
  `opp_action_1` varchar(4) DEFAULT NULL,
  `opp_action_2` varchar(4) DEFAULT NULL,
  `opp_action_3` varchar(4) DEFAULT NULL,
  `opp_action_4` varchar(4) DEFAULT NULL,
  `opp_difficulty_level` varchar(13) DEFAULT NULL,
  `opp_portrait` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`opponent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opponent`
--

LOCK TABLES `opponent` WRITE;
/*!40000 ALTER TABLE `opponent` DISABLE KEYS */;
INSERT INTO `opponent` VALUES (1,'Beg_55555',5,5,5,5,5,'A001','B001','E001','C001','1','Images/CharacterIcons/discodude.jpg'),(2,'Beg_66544',6,6,5,4,4,'C001','D001','B001','E001','1','Images/CharacterIcons/scarydragon.jpg'),(3,'Beg_44566',4,4,5,6,6,'A001','C001','E001','B001','1','Images/CharacterIcons/spookywitch.jpg'),(4,'Beg_56644',5,6,6,4,4,'B001','E001','D001','A001','1','Images/CharacterIcons/inconspicuousflower.jpg'),(5,'Beg_65644',6,5,6,4,4,'D001','A001','C001','E001','1','Images/CharacterIcons/sillysnail.jpg'),(6,'Beg_66454',6,6,4,5,4,'C001','E001','B001','D001','1','Images/CharacterIcons/stupidhorse.jpg'),(7,'Beg_46564',4,6,5,6,4,'D001','B001','E001','C001','1','Images/CharacterIcons/trickycat.jpg'),(8,'Beg_64546',6,4,5,4,6,'A001','E001','D001','B001','1','Images/CharacterIcons/discodude.jpg'),(9,'Beg_54645',5,4,6,4,6,'D001','C001','E001','A001','1','Images/CharacterIcons/scarydragon.jpg'),(10,'Beg_56464',5,6,4,6,4,'E001','B001','C001','D001','1','Images/CharacterIcons/stupidhorse.jpg'),(11,'Beg_54466',5,4,4,6,6,'A001','D001','E001','B001','1','Images/CharacterIcons/sillysnail.jpg'),(12,'Beg_45646',4,5,6,4,6,'E001','C001','D001','A001','1','Images/CharacterIcons/inconspicuousflower.jpg'),(13,'Beg_46654',4,6,6,5,4,'C001','D001','B001','E001','1','Images/CharacterIcons/trickycat.jpg'),(14,'Beg_46456',4,6,4,5,6,'B001','E001','D001','A001','1','Images/CharacterIcons/spookywitch.jpg'),(15,'Beg_56446',5,6,4,4,6,'D001','A001','E001','C001','1','Images/CharacterIcons/stupidhorse.jpg'),(16,'Beg_65446',6,5,4,4,6,'C001','E001','D001','B001','1','Images/CharacterIcons/americanguy.jpg'),(17,'Beg_73537',7,3,5,3,7,'E001','D001','A001','C001','1','Images/CharacterIcons/scarydragon.jpg'),(18,'Beg_37573',3,7,5,7,3,'A001','B001','D001','E001','1','Images/CharacterIcons/trickycat.jpg'),(19,'Beg_57733',5,7,7,3,3,'E001','A001','E001','C001','1','Images/CharacterIcons/spookywitch.jpg'),(20,'Beg_53377',5,3,3,7,7,'C001','E001','A001','B001','1','Images/CharacterIcons/stupidhorse.jpg'),(21,'Beg_57373',5,7,3,7,3,'A001','E001','C001','E001','1','Images/CharacterIcons/discodude.jpg'),(22,'Beg_53737',5,3,7,3,7,'B001','E001','D001','A001','1','Images/CharacterIcons/trickycat.jpg'),(23,'Beg_57337',5,7,3,3,7,'E001','A001','B001','D001','1','Images/CharacterIcons/inconspicuousflower.jpg'),(24,'Beg_53773',5,3,7,7,3,'A001','C001','E001','B001','1','Images/CharacterIcons/discodude.jpg'),(25,'Beg_77533',7,7,5,3,3,'D001','A001','E001','C001','1','Images/CharacterIcons/spookywitch.jpg'),(26,'Beg_75733',7,5,7,3,3,'B001','E001','A001','D001','1','Images/CharacterIcons/spookywitch.jpg'),(27,'Beg_77353',7,7,3,5,3,'C001','D001','B001','E001','1','Images/CharacterIcons/discodude.jpg'),(28,'Beg_77335',7,7,3,3,5,'E001','B001','D001','A001','1','Images/CharacterIcons/scarydragon.jpg'),(29,'Beg_73573',7,3,5,7,3,'D001','E001','B001','C001','1','Images/CharacterIcons/trickycat.jpg'),(30,'Beg_73375',7,3,3,7,5,'B001','E001','C001','D001','1','Images/CharacterIcons/inconspicuousflower.jpg'),(31,'Beg_73357',7,3,3,5,7,'B001','D001','E001','A001','1','Images/CharacterIcons/sillysnail.jpg'),(32,'Beg_33775',3,3,7,7,5,'C001','E001','B001','D001','1','Images/CharacterIcons/americanguy.jpg'),(33,'Beg_33757',3,3,7,5,7,'D001','E001','A001','C001','1','Images/CharacterIcons/stupidhorse.jpg'),(34,'Beg_33577',3,3,5,7,7,'A001','B001','E001','D001','1','Images/CharacterIcons/inconspicuousflower.jpg'),(35,'Beg_35377',3,5,3,7,7,'D001','C001','B001','E001','1','Images/CharacterIcons/spookywitch.jpg'),(36,'Beg_35737',3,5,7,3,7,'B001','D001','A001','C001','1','Images/CharacterIcons/americanguy.jpg'),(37,'Beg_35773',3,5,7,7,3,'A001','E001','B001','D001','1','Images/CharacterIcons/sillysnail.jpg'),(38,'Beg_37753',3,7,7,5,3,'D001','B001','A001','E001','1','Images/CharacterIcons/sillysnail.jpg'),(39,'Beg_37735',3,7,7,3,5,'B001','A001','D001','E001','1','Images/CharacterIcons/discodude.jpg'),(40,'Beg_37375',3,7,3,7,5,'E001','D001','B001','A001','1','Images/CharacterIcons/scarydragon.jpg'),(41,'Beg_37537',3,7,5,3,7,'A001','E001','C001','B001','1','Images/CharacterIcons/americanguy.jpg');
/*!40000 ALTER TABLE `opponent` ENABLE KEYS */;
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
