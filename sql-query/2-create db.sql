CREATE DATABASE  IF NOT EXISTS `springcv1` ;

ALTER SCHEMA `springcv1`  DEFAULT CHARACTER SET utf8 ;

USE `springcv1`;

CREATE TABLE `user` (
  `email` varchar(255) NOT NULL,
  `password` char(68) NOT NULL,
  `full_name` nvarchar(1000) DEFAULT NULL,
  `address` nvarchar(1000)  DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `image` varchar(1000) DEFAULT NULL,
  `about` nvarchar(1000) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `company` (
  `username` varchar(255) NOT NULL,
  `company_name` nvarchar(1000) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `address` nvarchar(1000) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `about` nvarchar(1000) DEFAULT NULL,
  `company_size` int DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`username`),
  KEY `company_ibfk_1` (`username`),
  CONSTRAINT `company_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` nvarchar(200) DEFAULT NULL,
  `description` nvarchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `location` (
  `id` int NOT NULL AUTO_INCREMENT,
  `city` nvarchar(1000)  DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` nvarchar(500)  DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `job_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` nvarchar(255)  DEFAULT NULL,
  `description` nvarchar(1000)  DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `recruitment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `job_title` nvarchar(1000) DEFAULT NULL,
  `job_description` nvarchar(1000) DEFAULT NULL,
  `job_requirement` nvarchar(1000) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `expired_date` datetime DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `recruitment_ibfk_1` (`username`),
  CONSTRAINT `recruitment_ibfk_1` FOREIGN KEY (`username`) REFERENCES `company` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `authorities` (
  `username` varchar(255) NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY `authorities_idx_1` (`username`,`role_id`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`email`),
  CONSTRAINT `authorities_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `company_location` (
  `username` varchar(255) NOT NULL,
  `location_id` int NOT NULL,
  PRIMARY KEY `company_location_idx_1` (`username`,`location_id`),
  CONSTRAINT `company_location_ibfk_1` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`),
  CONSTRAINT `company_location_ibfk_2` FOREIGN KEY (`username`) REFERENCES `company` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cv` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` nvarchar(255)  NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `file_name` varchar(1000) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cv_ibfk_1` (`username`),
  CONSTRAINT `cv_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `follow_candidate` (
  `company` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY `follow_candidate_idx_1` (`company`,`username`),
  CONSTRAINT `follow_candidate_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`email`),
  CONSTRAINT `follow_candidate_ibfk_2` FOREIGN KEY (`company`) REFERENCES `company` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `follow_company` (
  `username` varchar(255) NOT NULL,
  `company` varchar(255) NOT NULL,
  PRIMARY KEY `follow_company_idx_1` (`username`,`company`),
  CONSTRAINT `follow_company_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`email`),
  CONSTRAINT `follow_company_ibfk_2` FOREIGN KEY (`company`) REFERENCES `company` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `online_cv` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `online_cv_ibfk_1` (`username`),
  CONSTRAINT `online_cv_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `recruitment_location` (
  `recruitment_id` int NOT NULL,
  `location_id` int NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`recruitment_id`,`location_id`),
  KEY `recruitment_location_ibfk_2` (`location_id`),
  CONSTRAINT `recruitment_location_ibfk_1` FOREIGN KEY (`recruitment_id`) REFERENCES `recruitment` (`id`),
  CONSTRAINT `recruitment_location_ibfk_2` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `recruitment_type` (
  `recruitment_id` int NOT NULL,
  `job_type_id` int NOT NULL,
  UNIQUE KEY `recruitment_type_idx_1` (`recruitment_id`,`job_type_id`),
  KEY `recruitment_type_ibfk_2` (`job_type_id`),
  CONSTRAINT `recruitment_type_ibfk_1` FOREIGN KEY (`recruitment_id`) REFERENCES `recruitment` (`id`),
  CONSTRAINT `recruitment_type_ibfk_2` FOREIGN KEY (`job_type_id`) REFERENCES `job_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `job_education` (
  `id` int NOT NULL AUTO_INCREMENT,
  `online_cv_id` int DEFAULT NULL,
  `major` nvarchar(255)  DEFAULT NULL,
  `school_name` nvarchar(1000)  DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `description` nvarchar(1000)  DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `job_education_ibfk_1` (`online_cv_id`),
  CONSTRAINT `job_education_ibfk_1` FOREIGN KEY (`online_cv_id`) REFERENCES `online_cv` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `job_experience` (
  `id` int NOT NULL AUTO_INCREMENT,
  `online_cv_id` int DEFAULT NULL,
  `title` nvarchar(1000)  DEFAULT NULL,
  `company_name` nvarchar(1000)  DEFAULT NULL,
  `salary` nvarchar(30)  DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `still_work` tinyint DEFAULT NULL,
  `leave_reason` nvarchar(1000)  DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `job_experience_ibfk_1` (`online_cv_id`),
  CONSTRAINT `job_experience_ibfk_1` FOREIGN KEY (`online_cv_id`) REFERENCES `online_cv` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `job_portfolio` (
  `id` int NOT NULL AUTO_INCREMENT,
  `online_cv_id` int DEFAULT NULL,
  `project_name` nvarchar(1000)  DEFAULT NULL,
  `project_size` int DEFAULT NULL,
  `description` nvarchar(1000) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `job_portfolio_ibfk_1` (`online_cv_id`),
  CONSTRAINT `job_portfolio_ibfk_1` FOREIGN KEY (`online_cv_id`) REFERENCES `online_cv` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `job_skill` (
  `id` int NOT NULL AUTO_INCREMENT,
  `online_cv_id` int DEFAULT NULL,
  `technical_skill` nvarchar(1000)  DEFAULT NULL,
  `soft_skill` nvarchar(1000)  DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `job_skill_ibfk_1` (`online_cv_id`),
  CONSTRAINT `job_skill_ibfk_1` FOREIGN KEY (`online_cv_id`) REFERENCES `online_cv` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;





























































