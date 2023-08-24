CREATE DATABASE  IF NOT EXISTS `springcv` ;

ALTER SCHEMA `springcv`  DEFAULT CHARACTER SET utf8 ;

USE `springcv`;

-- 1
CREATE TABLE `role` (
	`id` INT(18) PRIMARY KEY NOT NULL AUTO_INCREMENT ,
    `name` NVARCHAR(50) NOT NULL,
    `description` NVARCHAR(500) DEFAULT NULL
);

-- 2
CREATE TABLE `user` (
	`username` VARCHAR(255) PRIMARY KEY NOT NULL,
    `password` CHAR(68) NOT NULL,
    `role_id` INT(18) NOT NULL,
    `email` VARCHAR(255) UNIQUE NOT NULL,
    `full_name` nvarchar(1000) DEFAULT NULL,
	`address` nvarchar(1000)  DEFAULT NULL,
	`phone_number` varchar(20) DEFAULT NULL,
	`image` varchar(1000) DEFAULT NULL,
	`about` nvarchar(1000) DEFAULT NULL,
	`create_date` datetime DEFAULT NULL,
	`status` int DEFAULT NULL
);

-- 3 
CREATE TABLE `company` (
	`id` INT(18) PRIMARY KEY NOT NULL AUTO_INCREMENT ,
    `username` VARCHAR(255) NOT NULL,
    `name` NVARCHAR(1000)  NOT NULL,
	`logo` varchar(255) DEFAULT NULL,
	`address`  NVARCHAR(1000)  DEFAULT NULL,
	`phone_number` varchar(20) DEFAULT NULL,
	`email` varchar(255) DEFAULT NULL,
	`about`  NVARCHAR(1000)  DEFAULT NULL,
	`company_size` INT(18) DEFAULT NULL,
	`created_date` datetime DEFAULT NULL,
	`status` INT(18) DEFAULT NULL
);

-- 4
CREATE TABLE `status` (
	`id` INT(18) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	`description` NVARCHAR(1000)  NOT NULL
);

-- 5
CREATE TABLE `category` (
	`id` INT(18) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name` NVARCHAR(1000)  NOT NULL,
    `description` NVARCHAR(500) DEFAULT NULL
    
);

-- 6
CREATE TABLE `recruitment` (	
	`id` INT(18) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `company_id` INT(18) NOT NULL,
    `job_title`  NVARCHAR(1000) NOT NULL,
	`job_description` NVARCHAR(1000) DEFAULT NULL,
	`job_requirement` NVARCHAR(1000) DEFAULT NULL,
	`created_date` datetime DEFAULT NULL,
	`modified_date` datetime DEFAULT NULL,
	`expired_date` datetime DEFAULT NULL,
	`status` INT(18) DEFAULT NULL
);

-- 7
CREATE TABLE `location` (
	`id` INT(18) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `city`  NVARCHAR(1000) NOT NULL
);

-- 8
CREATE TABLE `job_type` (
	`id` INT(18) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	`name` NVARCHAR(1000) NOT NULL,
	`description` NVARCHAR(1000)  DEFAULT NULL
);

-- 9
CREATE TABLE `follow` (
	`id` INT(18) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(255) NOT NULL,
    `company_id` INT(18) NOT NULL,
    `is_user_follow` INT
);

-- 10 
CREATE TABLE `company_location` (
	`company_id` INT(18) NOT NULL,
	`location_id` INT(18) NOT NULL,  
	PRIMARY KEY (`company_id`,  `location_id`)
);

-- 11 
CREATE TABLE `recruitment_location` (
	`recruitment_id`  INT(18) NOT NULL,
	`location_id`  INT(18) NOT NULL,  
	PRIMARY KEY (`recruitment_id`,  `location_id`)
);

-- 12 
CREATE TABLE `recruitment_type` (
	`recruitment_id`  INT(18) NOT NULL,
	`job_type_id`  INT(18) NOT NULL,  
	PRIMARY KEY (`recruitment_id`,  `job_type_id`)
);

-- 13
CREATE TABLE `recruitment_category` (
	`recruitment_id`  INT(18) NOT NULL,
	`category_id`  INT(18) NOT NULL,  
	PRIMARY KEY (`recruitment_id`,  `category_id`)
);

-- 14
CREATE TABLE `job_apply` (
	`id` INT(18) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	`username` VARCHAR(255) NOT NULL,
	`recruitment_id`  INT(18) NOT NULL,
    `cover_letter` NVARCHAR(1000) NOT NULL

);

-- 15
CREATE TABLE `cv` (
	`id` INT(18) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	`title` NVARCHAR(1000) NOT NULL,
	`username` VARCHAR(255) NOT NULL,
	`file_name` NVARCHAR(1000) NOT NULL,
	`created_date` datetime DEFAULT NULL,
	`modified_date` datetime DEFAULT NULL,
	`status` INT(18) DEFAULT NULL
);

-- 16
CREATE TABLE `online_cv` (
	`id` INT(18) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	`title` NVARCHAR(1000) NOT NULL,
	`username` VARCHAR(255) NOT NULL,
	`created_date` datetime DEFAULT NULL,
	`modified_date` datetime DEFAULT NULL,
	`status` INT(18) DEFAULT NULL

);

-- 17
CREATE TABLE `job_education` (
	`id` INT(18) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `online_cv_id` INT(18) NOT NULL,
	`major` NVARCHAR(1000) NOT NULL,
	`school_name` NVARCHAR(1000) NOT NULL,
	`start_date` date DEFAULT NULL,
	`end_date` date DEFAULT NULL,
	`description` NVARCHAR(1000) DEFAULT NULL
);

-- 18
CREATE TABLE `job_experience` (
	`id` INT(18) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `online_cv_id` INT(18) NOT NULL,
	`title` NVARCHAR(1000) NOT NULL,
	`company_name` NVARCHAR(1000) NOT NULL,
	`salary` NVARCHAR(1000) NOT NULL,
	`start_date` date DEFAULT NULL,
	`end_date` date DEFAULT NULL,
	`still_work` tinyint DEFAULT NULL,
	`leave_reason` NVARCHAR(1000) DEFAULT NULL
);

-- 19
CREATE TABLE `job_portfolio` (
	`id` INT(18) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `online_cv_id` INT(18) NOT NULL,
	`project_name` NVARCHAR(1000) NOT NULL,
	`project_size` INT(18) DEFAULT NULL,
	`description` NVARCHAR(1000) DEFAULT NULL,
	`image` varchar(255) DEFAULT NULL
);

-- 20
CREATE TABLE `job_skill` (
	`id` INT(18) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `online_cv_id` INT(18) NOT NULL,
	`technical_skill`  NVARCHAR(1000) DEFAULT NULL,
	`soft_skill`  NVARCHAR(1000) DEFAULT NULL

);

ALTER TABLE `user`
ADD CONSTRAINT `fk_user_role`
FOREIGN KEY (`role_id`) REFERENCES `role`(`id`);

ALTER TABLE `company`
ADD CONSTRAINT `fk_company_user`
FOREIGN KEY (`username`) REFERENCES `user`(`username`);

ALTER TABLE `follow`
ADD CONSTRAINT `fk_follow_user`
FOREIGN KEY (`username`) REFERENCES `user`(`username`);

ALTER TABLE `follow`
ADD CONSTRAINT `fk_follow_company`
FOREIGN KEY (`company_id`) REFERENCES `company`(`id`);

ALTER TABLE `job_apply`
ADD CONSTRAINT `fk_job_apply_user`
FOREIGN KEY (`username`) REFERENCES `user`(`username`);

ALTER TABLE `job_apply`
ADD CONSTRAINT `fk_job_apply_recruitment`
FOREIGN KEY (`recruitment_id`) REFERENCES `recruitment`(`id`);

ALTER TABLE `recruitment`
ADD CONSTRAINT `fk_recruitment_company`
FOREIGN KEY (`company_id`) REFERENCES `company`(`id`);

ALTER TABLE `company_location`
ADD CONSTRAINT `fk_company_location_company`
FOREIGN KEY (`company_id`) REFERENCES `company`(`id`);

ALTER TABLE `company_location`
ADD CONSTRAINT `fk_company_location_location`
FOREIGN KEY (`location_id`) REFERENCES `location`(`id`);

ALTER TABLE `recruitment_location`
ADD CONSTRAINT `fk_recruitment_location_recruitment`
FOREIGN KEY (`recruitment_id`) REFERENCES `recruitment`(`id`);

ALTER TABLE `recruitment_location`
ADD CONSTRAINT `fk_recruitment_location_location`
FOREIGN KEY (`location_id`) REFERENCES `location`(`id`);

ALTER TABLE `recruitment_type`
ADD CONSTRAINT `fk_recruitment_type_recruitment`
FOREIGN KEY (`recruitment_id`) REFERENCES `recruitment`(`id`);

ALTER TABLE `recruitment_type`
ADD CONSTRAINT `fk_recruitment_type_job_type`
FOREIGN KEY (`job_type_id`) REFERENCES `job_type`(`id`);

ALTER TABLE `recruitment_category`
ADD CONSTRAINT `fk_recruitment_category_recruitment`
FOREIGN KEY (`recruitment_id`) REFERENCES `recruitment`(`id`);

ALTER TABLE `recruitment_category`
ADD CONSTRAINT `fk_recruitment_category_category`
FOREIGN KEY (`category_id`) REFERENCES `category`(`id`);

ALTER TABLE `cv`
ADD CONSTRAINT `fk_cv_user`
FOREIGN KEY (`username`) REFERENCES `user`(`username`);

ALTER TABLE `online_cv`
ADD CONSTRAINT `fk_online_cv_user`
FOREIGN KEY (`username`) REFERENCES `user`(`username`);

ALTER TABLE `job_education`
ADD CONSTRAINT `fk_job_education_online_cv`
FOREIGN KEY (`online_cv_id`) REFERENCES `online_cv`(`id`);

ALTER TABLE `job_experience`
ADD CONSTRAINT `fk_job_experience_online_cv`
FOREIGN KEY (`online_cv_id`) REFERENCES `online_cv`(`id`);

ALTER TABLE `job_portfolio`
ADD CONSTRAINT `fk_job_portfolio_online_cv`
FOREIGN KEY (`online_cv_id`) REFERENCES `online_cv`(`id`);

ALTER TABLE `job_skill`
ADD CONSTRAINT `fk_job_skill_online_cv`
FOREIGN KEY (`online_cv_id`) REFERENCES `online_cv`(`id`);
  


-- INSERT SAMPLE DATAS
INSERT INTO `role`(`NAME`, `description`) 
VALUES 
('Candidate', 'Ứng viên'),
('Company', 'Công ty'),
('Admin', 'Quản trị viên');

INSERT INTO `category`(`NAME`, `description`) 
VALUES 
('JAVA', 'JAVA DEV'),
('PHP', 'PHP'),
('NODEJS', 'NODEJS'),
('ANGULAR', 'ANGULAR'),
('ASP.NET', 'ASP.NET'),
('PYTHON', 'PYTHON');

INSERT INTO `job_type`(`NAME`, `description`) 
VALUES 
('FULL TIME', 'Toàn thời gian'),
('PART TIME', 'Bán thời gian'),
('HIBRID', 'HIBRID'),
('ONSITE', 'ONSITE'),
('REMOTE', 'REMOTE');












