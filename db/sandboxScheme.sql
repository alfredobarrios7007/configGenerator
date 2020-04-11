-- Wed Feb 6 2020
-- Model: sandboxScheme Version: 1.0
-- Designed by: Alfredo Barrios

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema db_abc_CRM_base
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `sandboxScheme` ;

-- -----------------------------------------------------
-- Schema db_abc_CRM_base
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sandboxScheme` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
USE `sandboxScheme` ;

-- -----------------------------------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS `backend_settings`;
CREATE TABLE `backend_settings` (
  `ref_param` varchar(50) NOT NULL,
  `label_param` varchar(100) NOT NULL,
  `cond_param` varchar(50) NOT NULL,
  `value_param` varchar(200) DEFAULT NULL,
  `comment_param` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ref_param`,`label_param`,`cond_param`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `change_events`
--

DROP TABLE IF EXISTS `change_events`;
CREATE TABLE `change_events` (
  `smtransaction_id` int(11) NOT NULL AUTO_INCREMENT,
  `transaction_id` varchar(100) NOT NULL,
  `user_reference_id` varchar(50) NOT NULL,
  `reception_date` datetime NOT NULL,
  `response_date` datetime DEFAULT NULL,
  `effective_date` datetime DEFAULT NULL,
  `transaction_status` varchar(2) DEFAULT NULL,
  `change_status` varchar(20) DEFAULT NULL,
  `offer_id` varchar(50) DEFAULT NULL,
  `change_type` varchar(20) DEFAULT NULL,
  `correlator_id` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`smtransaction_id`),
  KEY `transaction_id` (`transaction_id`)
) ENGINE=InnoDB AUTO_INCREMENT=82426 DEFAULT CHARSET=utf8;

--
-- Table structure for table `change_sms_queue`
--

DROP TABLE IF EXISTS `change_sms_queue`;
CREATE TABLE `change_sms_queue` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message_id` varchar(50) NOT NULL,
  `user_reference_id` varchar(50) NOT NULL,
  `unique_user_service_id` varchar(50) NOT NULL,
  `transaction_id` varchar(50) NOT NULL,
  `sms_reception_date` datetime NOT NULL,
  `sms_transaction_status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Table structure for table `charge_events`
--

DROP TABLE IF EXISTS `charge_events`;
CREATE TABLE `charge_events` (
  `smtransaction_id` double NOT NULL AUTO_INCREMENT,
  `transaction_id` varchar(1024) NOT NULL,
  `user_reference_id` varchar(50) NOT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  `currency` varchar(50) DEFAULT NULL,
  `paidtroughdate` datetime DEFAULT NULL,
  `plan_type` varchar(50) DEFAULT NULL,
  `reception_date` datetime NOT NULL,
  `response_date` datetime DEFAULT NULL,
  `transaction_status` varchar(50) DEFAULT NULL,
  `provider_status` varchar(1) DEFAULT NULL,
  `unique_transaction` varchar(1024) NOT NULL,
  PRIMARY KEY (`smtransaction_id`),
  KEY `idx_unique_transaction` (`unique_transaction`)
) ENGINE=InnoDB AUTO_INCREMENT=36927 DEFAULT CHARSET=utf8;

--
-- Table structure for table `charge_queue`
--

DROP TABLE IF EXISTS `charge_queue`;
CREATE TABLE `charge_queue` (
  `user_reference_id` varchar(50) NOT NULL,
  `transaction_id` varchar(1024) DEFAULT NULL,
  `reception_date` datetime DEFAULT NULL,
  `last_date_sent` datetime DEFAULT NULL,
  `collected` tinyint(1) DEFAULT '0',
  `second_cycle` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`user_reference_id`),
  KEY `idx_transaction_id` (`transaction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `countries`
--

DROP TABLE IF EXISTS `countries`;
CREATE TABLE `countries` (
  `country_id` varchar(50) NOT NULL,
  `country_code` varchar(20) DEFAULT NULL,
  `country_description` varchar(50) DEFAULT NULL,
  `country_iso_3166_2` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`country_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `eligibility_response_codes`
--

DROP TABLE IF EXISTS `eligibility_response_codes`;
CREATE TABLE `eligibility_response_codes` (
  `response_code` int(11) NOT NULL,
  `profile` varchar(50) NOT NULL,
  `description` varchar(100) NOT NULL,
  `eligible_status` varchar(50) NOT NULL,
  PRIMARY KEY (`response_code`,`profile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `last_execution`
--

DROP TABLE IF EXISTS `last_execution`;
CREATE TABLE `last_execution` (
  `id` int(1) NOT NULL,
  `reception_date` datetime NOT NULL,
  `statusMail` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `provider_services_by_country`
--

DROP TABLE IF EXISTS `provider_services_by_country`;
CREATE TABLE `provider_services_by_country` (
  `service_reference_id` double NOT NULL,
  `message_id` varchar(50) DEFAULT NULL,
  `sequence_id` decimal(15,0) DEFAULT NULL,
  `cero_charge` int(4) DEFAULT '0',
  `serviceprovider_id` varchar(50) NOT NULL,
  `country_id` varchar(50) NOT NULL,
  `service_id` int(4) NOT NULL,
  `serviceprovider` varchar(20) NOT NULL,
  `service_provider_desc` varchar(100) NOT NULL,
  `idProvisioning` varchar(15) NOT NULL,
  `typeServiceIdProvisioning` varchar(15) NOT NULL,
  `rate_type` char(1) NOT NULL,
  PRIMARY KEY (`service_reference_id`),
  UNIQUE KEY `idx_provider_services_by_country_unique_service` (`country_id`,`service_id`,`serviceprovider_id`),
  KEY `fk_provider_services_by_country_providers_idx` (`serviceprovider_id`),
  KEY `fk_provider_services_by_country_countries1_idx` (`country_id`),
  KEY `fk_provider_services_by_country_services_idx` (`service_id`),
  CONSTRAINT `fk_provider_services_by_country_countries1` FOREIGN KEY (`country_id`) REFERENCES `countries` (`country_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_provider_services_by_country_providers` FOREIGN KEY (`serviceprovider_id`) REFERENCES `providers` (`serviceprovider_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_provider_services_by_country_services` FOREIGN KEY (`service_id`) REFERENCES `services` (`service_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `providers`
--

DROP TABLE IF EXISTS `providers`;
CREATE TABLE `providers` (
  `serviceprovider_id` varchar(50) NOT NULL,
  `Description` varchar(50) NOT NULL,
  PRIMARY KEY (`serviceprovider_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `services`
--

DROP TABLE IF EXISTS `services`;
CREATE TABLE `services` (
  `service_id` int(4) NOT NULL AUTO_INCREMENT,
  `service_description` varchar(50) DEFAULT NULL,
  `hubServiceProvider` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`service_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Table structure for table `services_bundle`
--

DROP TABLE IF EXISTS `services_bundle`;
CREATE TABLE `services_bundle` (
  `service_bundle_id` int(11) NOT NULL COMMENT 'ID del servicio (HUB), PK para la tabla',
  `service_bundle_offer_id` varchar(100) NOT NULL COMMENT 'Clave del producto (NETFLIX).',
  `service_bundle_product_id` varchar(100) NOT NULL COMMENT 'ID del servicio (OPERADOR)',
  `service_bundle_description` varchar(100) NOT NULL COMMENT 'Descripción del servicio (OPERADOR).',
  `service_bundle_type` varchar(50) NOT NULL COMMENT 'Tipo de servicio (OPERADOR):\nPLAN\nPAQUETE',
  `service_bundle_profile` varchar(50) NOT NULL COMMENT 'Perfil del servicio (OPERADOR):\nMASIVO\nMASIVOMIX',
  `service_bundle_country` varchar(2) NOT NULL COMMENT 'País del servicio (OPERADOR):\nMX',
  `service_bundle_provider` varchar(50) NOT NULL COMMENT 'Proveedor del servicio:\nTELCEL\nTELMEX\nNETFLIX',
  PRIMARY KEY (`service_bundle_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabla que contendrá el catálogo de Paquetes / Productos disponibles para Netflix Bundle';

--
-- Table structure for table `services_bundle_change_type`
--

DROP TABLE IF EXISTS `services_bundle_change_type`;
CREATE TABLE `services_bundle_change_type` (
  `service_bundle_plan_id_from` varchar(100) NOT NULL,
  `service_bundle_product_id_from` varchar(100) NOT NULL,
  `service_bundle_product_id_to` varchar(100) NOT NULL,
  `service_bundle_offer_id_from` int(11) DEFAULT NULL,
  `service_bundle_offer_id_to` int(11) DEFAULT NULL,
  `service_bundle_change_type` varchar(50) DEFAULT NULL,
  `id_service_bundle_change_type_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_service_bundle_change_type_id`),
  UNIQUE KEY `constraint_name` (`service_bundle_plan_id_from`,`service_bundle_product_id_from`,`service_bundle_product_id_to`,`service_bundle_offer_id_from`,`service_bundle_offer_id_to`,`service_bundle_change_type`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

--
-- Table structure for table `services_details`
--

DROP TABLE IF EXISTS `services_details`;
CREATE TABLE `services_details` (
  `service_detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `content_id` varchar(50) DEFAULT NULL,
  `content_description` varchar(50) DEFAULT NULL,
  `service_reference_id` double NOT NULL,
  `service_type` varchar(50) NOT NULL,
  PRIMARY KEY (`service_detail_id`),
  KEY `fk_services_details_provider_services_by_country1_idx` (`service_reference_id`),
  CONSTRAINT `fk_services_details_provider_services_by_country1` FOREIGN KEY (`service_reference_id`) REFERENCES `provider_services_by_country` (`service_reference_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Table structure for table `services_details_by_price`
--

DROP TABLE IF EXISTS `services_details_by_price`;
CREATE TABLE `services_details_by_price` (
  `service_detail_by_price_id` int(11) NOT NULL AUTO_INCREMENT,
  `content_id` varchar(50) DEFAULT NULL,
  `content_description` varchar(50) DEFAULT NULL,
  `price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `service_reference_id` int(11) NOT NULL,
  `service_type` varchar(50) NOT NULL,
  `plan_type` varchar(255) NOT NULL,
  PRIMARY KEY (`service_detail_by_price_id`,`plan_type`),
  KEY `fk_services_details_by_price_provider_services_by_country1_idx` (`service_reference_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Temporary table structure for view `user_details_by_events`
--

DROP TABLE IF EXISTS `user_details_by_events`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `user_services`
--

DROP TABLE IF EXISTS `user_services`;
CREATE TABLE `user_services` (
  `user_services_id` int(11) NOT NULL AUTO_INCREMENT,
  `last_transaction_id` varchar(1024) DEFAULT NULL,
  `sales_channel` varchar(50) DEFAULT NULL,
  `service_status` varchar(50) DEFAULT NULL,
  `last_transaction_date` datetime DEFAULT NULL,
  `paid_trough_date` datetime DEFAULT NULL,
  `unique_user_service_id` varchar(50) NOT NULL,
  `operator_triggered` tinyint(1) NOT NULL DEFAULT '0',
  `change_status_date` datetime DEFAULT NULL,
  PRIMARY KEY (`user_services_id`),
  KEY `fk_user_services_users_registered1_idx` (`unique_user_service_id`),
  CONSTRAINT `fk_user_services_users_registered1` FOREIGN KEY (`unique_user_service_id`) REFERENCES `users_registered` (`unique_user_service_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5975 DEFAULT CHARSET=utf8;

--
-- Table structure for table `user_services_bundle`
--

DROP TABLE IF EXISTS `user_services_bundle`;
CREATE TABLE `user_services_bundle` (
  `user_services_bundle_id` int(11) NOT NULL AUTO_INCREMENT,
  `plan_id` varchar(50) DEFAULT NULL,
  `plan_start_date` datetime DEFAULT NULL,
  `plan_end_date` datetime DEFAULT NULL,
  `product_id` varchar(50) DEFAULT NULL,
  `product_start_date` datetime DEFAULT NULL,
  `product_end_date` datetime DEFAULT NULL,
  `service_bundle_status` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `unique_user_service_id` varchar(50) NOT NULL,
  PRIMARY KEY (`user_services_bundle_id`),
  KEY `fk_user_services_bundle_users_registered1_idx` (`unique_user_service_id`),
  CONSTRAINT `fk_user_services_bundle_users_registered1` FOREIGN KEY (`unique_user_service_id`) REFERENCES `users_registered` (`unique_user_service_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=392693 DEFAULT CHARSET=utf8;

--
-- Table structure for table `user_services_devices`
--

DROP TABLE IF EXISTS `user_services_devices`;
CREATE TABLE `user_services_devices` (
  `deviceserialnumber` varchar(255) NOT NULL,
  `device_description` varchar(50) DEFAULT NULL,
  `unique_user_service_id` varchar(50) NOT NULL,
  PRIMARY KEY (`deviceserialnumber`),
  KEY `fk_user_services_devices_users_registered1_idx` (`unique_user_service_id`),
  CONSTRAINT `fk_user_services_devices_users_registered1` FOREIGN KEY (`unique_user_service_id`) REFERENCES `users_registered` (`unique_user_service_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `users_registered`
--

DROP TABLE IF EXISTS `users_registered`;
CREATE TABLE `users_registered` (
  `unique_user_service_id` varchar(50) NOT NULL,
  `user_reference_id` varchar(50) DEFAULT NULL,
  `user_reference_type` varchar(50) DEFAULT NULL,
  `service_reference_id` double NOT NULL,
  PRIMARY KEY (`unique_user_service_id`),
  UNIQUE KEY `index_user_service` (`user_reference_id`,`service_reference_id`),
  KEY `fk_users_registered_provider_services_by_country1_idx` (`service_reference_id`),
  CONSTRAINT `fk_users_registered_provider_services_by_country1` FOREIGN KEY (`service_reference_id`) REFERENCES `provider_services_by_country` (`service_reference_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Final view structure for view `user_details_by_events`
--


-- Dump completed on 2020-03-17 10:33:38
