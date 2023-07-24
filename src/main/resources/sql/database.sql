-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: tk3consulting
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `table_clients`
--

DROP TABLE IF EXISTS `table_clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `table_clients` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `pass` varchar(8) NOT NULL,
  `data_base` varchar(100) NOT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `table_clients`
--

LOCK TABLES `table_clients` WRITE;
/*!40000 ALTER TABLE `table_clients` DISABLE KEYS */;
INSERT INTO `table_clients` VALUES (1,'fran','123456','sakila'),(2,'ascension','678912','world');
/*!40000 ALTER TABLE `table_clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `table_employees`
--

DROP TABLE IF EXISTS `table_employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `table_employees` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `employee_name` varchar(100) NOT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `table_employees`
--

LOCK TABLES `table_employees` WRITE;
/*!40000 ALTER TABLE `table_employees` DISABLE KEYS */;
INSERT INTO `table_employees` VALUES (1,'Ascension Hernandez Martinez'),(4,'Francisco Tortillol Molina');
/*!40000 ALTER TABLE `table_employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `table_employees_tasks`
--

DROP TABLE IF EXISTS `table_employees_tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `table_employees_tasks` (
  `id` int NOT NULL AUTO_INCREMENT,
  `task_id` int NOT NULL,
  `employee_id` int NOT NULL,
  `date_at` timestamp NOT NULL,
  PRIMARY KEY (`id`),
  KEY `task_id` (`task_id`),
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `table_employees_tasks_ibfk_1` FOREIGN KEY (`task_id`) REFERENCES `table_tasks` (`task_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `table_employees_tasks_ibfk_2` FOREIGN KEY (`employee_id`) REFERENCES `table_employees` (`employee_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `table_employees_tasks`
--

LOCK TABLES `table_employees_tasks` WRITE;
/*!40000 ALTER TABLE `table_employees_tasks` DISABLE KEYS */;
INSERT INTO `table_employees_tasks` VALUES (1,1,1,'2022-11-01 13:30:00'),(2,2,1,'2022-11-02 13:30:00'),(3,3,1,'2022-11-03 13:30:00'),(4,1,1,'2022-11-04 13:30:00'),(5,2,1,'2022-11-07 06:30:00'),(6,3,1,'2022-11-08 06:30:00'),(7,1,1,'2022-11-09 06:30:00'),(8,3,1,'2022-11-11 13:30:00'),(9,1,1,'2022-11-12 13:30:00'),(10,2,1,'2022-11-13 13:30:00'),(11,1,1,'2022-11-16 06:30:00'),(12,2,1,'2022-11-20 13:30:00'),(13,3,1,'2022-11-18 06:30:00'),(14,1,1,'2022-11-21 13:30:00'),(15,2,1,'2022-11-22 13:30:00'),(16,3,1,'2022-11-23 13:30:00'),(17,1,1,'2022-11-28 06:30:00'),(18,3,1,'2022-11-30 13:30:00');
/*!40000 ALTER TABLE `table_employees_tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `table_sections`
--

DROP TABLE IF EXISTS `table_sections`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `table_sections` (
  `section_id` int NOT NULL AUTO_INCREMENT,
  `section_name` varchar(80) NOT NULL,
  PRIMARY KEY (`section_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `table_sections`
--

LOCK TABLES `table_sections` WRITE;
/*!40000 ALTER TABLE `table_sections` DISABLE KEYS */;
INSERT INTO `table_sections` VALUES (1,'Cocina'),(2,'cuidados personales');
/*!40000 ALTER TABLE `table_sections` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `table_tasks`
--

DROP TABLE IF EXISTS `table_tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `table_tasks` (
  `task_id` int NOT NULL AUTO_INCREMENT,
  `task_name` varchar(45) NOT NULL,
  `section_id` int NOT NULL,
  PRIMARY KEY (`task_id`),
  KEY `section_id` (`section_id`),
  KEY `section_id_2` (`section_id`),
  CONSTRAINT `table_tasks_ibfk_1` FOREIGN KEY (`section_id`) REFERENCES `table_sections` (`section_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `table_tasks`
--

LOCK TABLES `table_tasks` WRITE;
/*!40000 ALTER TABLE `table_tasks` DISABLE KEYS */;
INSERT INTO `table_tasks` VALUES (1,'Cocinar',1),(2,'Dietas',1),(3,'Preelaboraciones',1);
/*!40000 ALTER TABLE `table_tasks` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-24 17:22:15
