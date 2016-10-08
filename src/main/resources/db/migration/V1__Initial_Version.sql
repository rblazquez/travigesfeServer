USE `apartamentos`;

--
-- Table structure for table `amenitie`
--

DROP TABLE IF EXISTS `amenitie`;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `amenitie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

--
-- Table structure for table `attachment`
--

DROP TABLE IF EXISTS `attachment`;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attachment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `property` tinyblob,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

--
-- Table structure for table `booking_event`
--

DROP TABLE IF EXISTS `booking_event`;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `booking_event` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `booking` tinyblob,
  `event_time` datetime DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


--
-- Table structure for table `guest`
--

DROP TABLE IF EXISTS `guest`;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guest` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone_no` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


--
-- Table structure for table `property`
--

DROP TABLE IF EXISTS `property`;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `property` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) DEFAULT NULL,
  `amount_of_bed` int(11) DEFAULT NULL,
  `bath_rooms` int(11) DEFAULT NULL,
  `bed_rooms` int(11) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `cleaning_fee` decimal(19,2) DEFAULT NULL,
  `deposit` decimal(19,2) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `lat` varchar(255) DEFAULT NULL,
  `lng` varchar(255) DEFAULT NULL,
  `max_guest` int(11) DEFAULT NULL,
  `maximum_stay` int(11) DEFAULT NULL,
  `minimum_stay` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `postal_code` varchar(255) DEFAULT NULL,
  `price_per_night` decimal(19,2) DEFAULT NULL,
  `state_province` varchar(255) DEFAULT NULL,
  `street_address` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_hgo2avysvdf8312u6ivgyc1lp` (`name`)
);

--
-- Table structure for table `property_amenities`
--

DROP TABLE IF EXISTS `property_amenities`;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `property_amenities` (
  `property_id` bigint(20) NOT NULL,
  `amenitie_id` bigint(20) NOT NULL,
  KEY `FK_mq78ce1dtsdykbjrjaq41m0ca` (`amenitie_id`),
  KEY `FK_f4l2em2bl6ucokt1s3w4nky9q` (`property_id`),
  CONSTRAINT `FK_f4l2em2bl6ucokt1s3w4nky9q` FOREIGN KEY (`property_id`) REFERENCES `property` (`id`),
  CONSTRAINT `FK_mq78ce1dtsdykbjrjaq41m0ca` FOREIGN KEY (`amenitie_id`) REFERENCES `amenitie` (`id`)
);

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `booking` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cleaning_fee` decimal(19,2) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `deposit` decimal(19,2) DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `guest_no` int(11) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `price_per_night` decimal(19,2) DEFAULT NULL,
  `special_requests` varchar(255) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `guest_id` bigint(20) DEFAULT NULL,
  `property_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY (`code`),
  KEY `FK_5vhaw57mc33w1wspoxtkkd3vw` (`guest_id`),
  KEY `FK_gltwih8kqqk8hpa5it6vcets0` (`property_id`),
  CONSTRAINT `FK_5vhaw57mc33w1wspoxtkkd3vw` FOREIGN KEY (`guest_id`) REFERENCES `guest` (`id`),
  CONSTRAINT `FK_gltwih8kqqk8hpa5it6vcets0` FOREIGN KEY (`property_id`) REFERENCES `property` (`id`)
);
