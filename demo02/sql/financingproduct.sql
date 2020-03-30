/*
SQLyog Ultimate v8.32 
MySQL - 5.7.28 : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test`;

/*Table structure for table `financingproduct` */

DROP TABLE IF EXISTS `financingproduct`;

CREATE TABLE `financingproduct` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `risk` int(11) NOT NULL COMMENT '风险评级 R1:1,R2:2,R3:3',
  `income` varchar(20) NOT NULL COMMENT '预期收益',
  `saleStarting` datetime NOT NULL COMMENT '发售起始日',
  `saleEnd` datetime NOT NULL COMMENT '发售截止日',
  `end` datetime NOT NULL COMMENT '产品到期日',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `financingproduct` */

insert  into `financingproduct`(`id`,`risk`,`income`,`saleStarting`,`saleEnd`,`end`) values ('31076',2,'5.80%','2014-07-10 00:00:00','2014-07-14 00:00:00','2014-08-12 00:00:00'),('31869',2,'5.70%','2014-07-09 00:00:00','2014-07-13 00:00:00','2014-10-14 00:00:00'),('31898',2,'5.60%','2014-07-12 00:00:00','2014-07-15 00:00:00','2014-09-10 00:00:00');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
