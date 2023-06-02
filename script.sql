-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema library
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema library
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `library` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `library` ;

-- -----------------------------------------------------
-- Table `library`.`books`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library`.`books` (
  `id` INT NOT NULL,
  `title` VARCHAR(100) NULL DEFAULT NULL,
  `genre` VARCHAR(100) NULL DEFAULT NULL,
  `author` VARCHAR(100) NULL DEFAULT NULL,
  `copies` INT NULL DEFAULT NULL,
  `novelty` TINYINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `library`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library`.`users` (
  `username` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100) NULL DEFAULT NULL,
  `name` VARCHAR(100) NULL DEFAULT NULL,
  `lastname` VARCHAR(100) NULL DEFAULT NULL,
  `email` VARCHAR(100) NULL DEFAULT NULL,
  `balance` DOUBLE(22,2) NULL DEFAULT NULL,
  `premium` TINYINT NULL DEFAULT NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `library`.`rent`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library`.`rent` (
  `id` INT NOT NULL,
  `username` VARCHAR(100) NOT NULL,
  `rentaldate` DATETIME NOT NULL,
  PRIMARY KEY USING BTREE (`id`, `username`, `rentaldate`),
  INDEX `FK__usuarios` (`username` ASC) VISIBLE,
  CONSTRAINT `FK__books`
    FOREIGN KEY (`id`)
    REFERENCES `library`.`books` (`id`),
  CONSTRAINT `FK__users`
    FOREIGN KEY (`username`)
    REFERENCES `library`.`users` (`username`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
