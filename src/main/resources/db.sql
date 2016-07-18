-- MySQL Script generated by MySQL Workbench
-- 06/27/16 16:39:27
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema cust_auto
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cust_auto
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cust_auto` DEFAULT CHARACTER SET utf8 ;
USE `cust_auto` ;

-- -----------------------------------------------------
-- Table `cust_auto`.`customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cust_auto`.`customer` ;

CREATE TABLE IF NOT EXISTS `cust_auto`.`customer` (
  `customer_id` INT NOT NULL AUTO_INCREMENT,
  `customer_name` VARCHAR(45) NULL,
  `customer_address` VARCHAR(45) NULL,
  PRIMARY KEY (`customer_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cust_auto`.`vehicle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cust_auto`.`vehicle` ;

CREATE TABLE IF NOT EXISTS `cust_auto`.`vehicle` (
  `vehicle_rego` VARCHAR(7) NOT NULL,
  `vehicle_model` VARCHAR(45) NULL,
  `color` VARCHAR(45) NULL,
  `customer_customer_id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`vehicle_rego`),
  INDEX `fk_vehicle_customer_idx` (`customer_customer_id` ASC),
  CONSTRAINT `fk_vehicle_customer`
    FOREIGN KEY (`customer_customer_id`)
    REFERENCES `cust_auto`.`customer` (`customer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
