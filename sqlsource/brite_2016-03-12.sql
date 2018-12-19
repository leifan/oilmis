# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.6.26)
# Database: brite
# Generation Time: 2016-10-15 14:18:15 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table tb_department_type
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tb_department_type`;

CREATE TABLE `tb_department_type` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `department_id` varchar(50) NOT NULL DEFAULT '""' COMMENT '部门id',
  `department_name` varchar(100) NOT NULL DEFAULT '' COMMENT '部门名称',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `creator` varchar(100) NOT NULL DEFAULT '' COMMENT '创建人',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `updater` varchar(100) NOT NULL DEFAULT '' COMMENT '更新人',
  `timestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ix_department` (`department_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `tb_department_type` WRITE;
/*!40000 ALTER TABLE `tb_department_type` DISABLE KEYS */;

INSERT INTO `tb_department_type` (`id`, `department_id`, `department_name`, `create_time`, `creator`, `update_time`, `updater`, `timestamp`)
VALUES
	(1,'2','总监组','2016-01-02 20:28:25','127.0.0.1','2016-01-24 16:32:54','127.0.0.1','2016-01-24 16:32:54'),
	(2,'3','高级总监','2016-04-04 11:42:25','127.0.0.1','2016-04-04 11:42:25','127.0.0.1','0000-00-00 00:00:00'),
	(3,'10001010','西南二区','2016-04-10 12:08:15','0:0:0:0:0:0:0:1','2016-04-10 12:08:15','0:0:0:0:0:0:0:1','0000-00-00 00:00:00');

/*!40000 ALTER TABLE `tb_department_type` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table tb_district_type
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tb_district_type`;

CREATE TABLE `tb_district_type` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `district_id` varchar(50) NOT NULL DEFAULT '""' COMMENT '区域id',
  `district_name` varchar(100) NOT NULL DEFAULT '' COMMENT '区域名称',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `creator` varchar(100) NOT NULL DEFAULT '' COMMENT '创建人',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `updater` varchar(100) NOT NULL DEFAULT '' COMMENT '更新人',
  `timestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_district_id` (`district_id`),
  UNIQUE KEY `ux_district_name` (`district_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `tb_district_type` WRITE;
/*!40000 ALTER TABLE `tb_district_type` DISABLE KEYS */;

INSERT INTO `tb_district_type` (`id`, `district_id`, `district_name`, `create_time`, `creator`, `update_time`, `updater`, `timestamp`)
VALUES
	(2,'5','华北区','2016-01-02 19:45:00','127.0.0.1','2016-01-02 19:45:00','127.0.0.1','0000-00-00 00:00:00'),
	(4,'6','东北区','2016-01-10 18:03:59','127.0.0.1','2016-01-10 18:03:59','127.0.0.1','0000-00-00 00:00:00'),
	(6,'009','上海区域','2016-01-21 20:09:38','127.0.0.1','2016-01-21 20:09:38','127.0.0.1','0000-00-00 00:00:00'),
	(7,'1010','西北二区','2016-01-21 21:22:53','127.0.0.1','2016-01-24 16:28:27','127.0.0.1','2016-01-24 16:28:27'),
	(8,'111','西南区','2016-01-21 21:23:44','127.0.0.1','2016-01-21 21:23:44','127.0.0.1','0000-00-00 00:00:00'),
	(9,'10001','西北区','2016-04-04 11:43:01','127.0.0.1','2016-04-04 11:43:01','127.0.0.1','0000-00-00 00:00:00'),
	(10,'100000111','西南二区','2016-04-10 12:08:53','0:0:0:0:0:0:0:1','2016-04-10 12:08:53','0:0:0:0:0:0:0:1','0000-00-00 00:00:00');

/*!40000 ALTER TABLE `tb_district_type` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table tb_gts_oil_can_alarm
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tb_gts_oil_can_alarm`;

CREATE TABLE `tb_gts_oil_can_alarm` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `alarm_date` varchar(10) NOT NULL DEFAULT '' COMMENT '报警日期 yyyy-MM-dd',
  `alarm_time` varchar(10) NOT NULL DEFAULT '' COMMENT '报警时间 hh:mm:ss',
  `oil_can_name` varchar(100) NOT NULL DEFAULT '' COMMENT '罐号',
  `alarm_name` varchar(100) NOT NULL DEFAULT '' COMMENT '报警编码',
  `confirm_time` varchar(100) NOT NULL DEFAULT '' COMMENT '报警确认日期yyyy-MM-dd hh:mm:ss',
  `confirm_user` varchar(100) NOT NULL DEFAULT '' COMMENT '报警确认用户',
  `creator` varchar(100) NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updater` varchar(100) NOT NULL DEFAULT '' COMMENT '更新人',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `timestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `alarm_type` int(10) NOT NULL DEFAULT '0' COMMENT '报警类型，如：油高报警，水高报警，温度报警，流速报警，泄露报警，盗油报警，通信报警，以二进制性质描述，每一位标识一个报警类型',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_alarmTime_alarmDate` (`alarm_date`,`alarm_time`),
  KEY `ix_alarmTime` (`alarm_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='报警管理';

LOCK TABLES `tb_gts_oil_can_alarm` WRITE;
/*!40000 ALTER TABLE `tb_gts_oil_can_alarm` DISABLE KEYS */;

INSERT INTO `tb_gts_oil_can_alarm` (`id`, `alarm_date`, `alarm_time`, `oil_can_name`, `alarm_name`, `confirm_time`, `confirm_user`, `creator`, `create_time`, `updater`, `update_time`, `timestamp`, `alarm_type`)
VALUES
	(1,'2016-07-24','12:01:10','#1','液位高爆','2016-07-24 12:10:00','wwk','wwk','2016-07-24 12:01:10','wwk','2016-07-24 12:10:00','2016-07-31 14:52:09',1),
	(2,'2016-07-24','12:20:10','#1','液位高爆','2016-08-07 15:14:12','待实现','wwk','2016-07-24 12:20:10','wwk','2016-07-24 12:30:10','2016-08-07 15:14:52',0);

/*!40000 ALTER TABLE `tb_gts_oil_can_alarm` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table tb_gts_oil_can_feeding
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tb_gts_oil_can_feeding`;

CREATE TABLE `tb_gts_oil_can_feeding` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `feeding_type` varchar(100) NOT NULL DEFAULT '' COMMENT '前尺或后尺',
  `oil_can_name` varchar(100) NOT NULL DEFAULT '' COMMENT '油罐名称',
  `oil_product_name` varchar(100) NOT NULL DEFAULT '' COMMENT '油品类型',
  `oil_height` varchar(100) NOT NULL DEFAULT '' COMMENT '油高',
  `water_height` varchar(100) NOT NULL DEFAULT '' COMMENT '水高',
  `averge_temperate` varchar(100) NOT NULL DEFAULT '' COMMENT '平均温度',
  `shi_temperate` varchar(100) NOT NULL DEFAULT '' COMMENT '视温度',
  `shi_density` varchar(100) NOT NULL DEFAULT '' COMMENT '视密度',
  `standard_density` varchar(100) NOT NULL DEFAULT '' COMMENT '标准密度',
  `standard_capacity` varchar(100) NOT NULL DEFAULT '' COMMENT '标准体积',
  `net_oil_capacity` varchar(100) NOT NULL DEFAULT '' COMMENT '净油体积',
  `water_capacity` varchar(100) NOT NULL DEFAULT '' COMMENT '水体积',
  `net_oil_quality` varchar(100) NOT NULL DEFAULT '' COMMENT '净油质量',
  `check_time` varchar(100) NOT NULL DEFAULT '' COMMENT '检测时间yyyy-mm-dd HH:mm:ss',
  `alarm_status` varchar(100) NOT NULL DEFAULT '' COMMENT '报警状态',
  `creator` varchar(100) NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updater` varchar(100) NOT NULL DEFAULT '' COMMENT '更新人',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `timestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='进油记录表';

LOCK TABLES `tb_gts_oil_can_feeding` WRITE;
/*!40000 ALTER TABLE `tb_gts_oil_can_feeding` DISABLE KEYS */;

INSERT INTO `tb_gts_oil_can_feeding` (`id`, `feeding_type`, `oil_can_name`, `oil_product_name`, `oil_height`, `water_height`, `averge_temperate`, `shi_temperate`, `shi_density`, `standard_density`, `standard_capacity`, `net_oil_capacity`, `water_capacity`, `net_oil_quality`, `check_time`, `alarm_status`, `creator`, `create_time`, `updater`, `update_time`, `timestamp`)
VALUES
	(4,'后尺','#1','90#汽油','1000','10','10','20','1','1','100','200','200','100','2015-12-01 10:00:00','正常','admin','2015-12-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-05 10:37:22'),
	(5,'后尺','#1','90#汽油','1000','10','10','20','1','1','100','200','200','100','2015-12-01 10:00:00','正常','admin','2015-12-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-05 10:37:22'),
	(6,'后尺','#1','90#汽油','1000','10','10','20','1','1','100','200','200','100','2015-12-01 10:00:00','正常','admin','2015-12-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-05 10:37:22'),
	(7,'后尺','#1','90#汽油','1000','10','10','20','1','1','100','200','200','100','2015-12-01 10:00:00','正常','admin','2015-12-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-05 10:37:22'),
	(8,'后尺','#1','90#汽油','1000','10','10','20','1','1','100','200','200','100','2015-12-01 10:00:00','正常','admin','2015-12-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-05 10:37:22'),
	(9,'后尺','#1','90#汽油','1000','10','10','20','1','1','100','200','200','100','2015-12-01 10:00:00','正常','admin','2015-12-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-05 10:37:22'),
	(10,'后尺','#1','90#汽油','1000','10','10','20','1','1','100','200','200','100','2015-12-01 10:00:00','正常','admin','2015-12-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-05 10:37:22'),
	(11,'后尺','#1','90#汽油','1000','10','10','20','1','1','100','200','200','100','2015-12-01 10:00:00','正常','admin','2015-12-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-05 10:37:22'),
	(12,'后尺','#2','90#汽油','1000','10','10','20','1','1','100','200','200','100','2016-03-01 10:00:00','正常','admin','2016-03-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-10 21:58:33'),
	(13,'后尺','#2','90#汽油','1000','10','10','20','1','1','100','200','200','100','2016-03-01 10:00:00','正常','admin','2016-03-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-10 21:58:33'),
	(14,'后尺','#2','90#汽油','1000','10','10','20','1','1','100','200','200','100','2016-03-01 10:00:00','正常','admin','2016-03-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-10 21:58:33'),
	(15,'后尺','#2','90#汽油','1000','10','10','20','1','1','100','200','200','100','2016-03-01 10:00:00','正常','admin','2016-03-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-10 21:58:33'),
	(16,'后尺','#2','90#汽油','1000','10','10','20','1','1','100','200','200','100','2016-03-01 10:00:00','正常','admin','2016-03-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-10 21:58:33'),
	(17,'后尺','#2','90#汽油','1000','10','10','20','1','1','100','200','200','100','2016-03-01 10:00:00','正常','admin','2016-03-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-10 21:58:33'),
	(18,'后尺','#2','90#汽油','1000','10','10','20','1','1','100','200','200','100','2016-03-01 10:00:00','正常','admin','2016-03-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-10 21:58:33'),
	(19,'后尺','#2','90#汽油','1000','10','10','20','1','1','100','200','200','100','2016-03-01 10:00:00','正常','admin','2016-03-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-10 21:58:33'),
	(20,'后尺','#2','90#汽油','1000','10','10','20','1','1','100','200','200','100','2016-03-01 10:00:00','正常','admin','2016-03-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-10 21:58:33'),
	(21,'后尺','#2','90#汽油','1000','10','10','20','1','1','100','200','200','100','2016-03-01 10:00:00','正常','admin','2016-03-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-10 21:58:33'),
	(22,'后尺','#2','90#汽油','1000','10','10','20','1','1','100','200','200','100','2016-03-01 10:00:00','正常','admin','2016-03-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-10 21:58:33'),
	(23,'后尺','#2','90#汽油','1000','10','10','20','1','1','100','200','200','100','2016-03-01 10:00:00','正常','admin','2016-03-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-10 21:58:33'),
	(24,'后尺','#2','90#汽油','1000','10','10','20','1','1','100','200','200','100','2016-03-01 10:00:00','正常','admin','2016-03-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-10 21:58:33'),
	(25,'后尺','#2','90#汽油','1000','10','10','20','1','1','100','200','200','100','2016-03-01 10:00:00','正常','admin','2016-03-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-10 21:58:33'),
	(26,'后尺','#2','90#汽油','1000','10','10','20','1','1','100','200','200','100','2016-03-01 10:00:00','正常','admin','2016-03-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-10 21:58:33');

/*!40000 ALTER TABLE `tb_gts_oil_can_feeding` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table tb_gts_shift_work
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tb_gts_shift_work`;

CREATE TABLE `tb_gts_shift_work` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `class_name` varchar(100) NOT NULL DEFAULT '' COMMENT '交接班组名称',
  `shift_time` varchar(100) NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '交班时间',
  `creator` varchar(100) NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updater` varchar(100) NOT NULL DEFAULT '' COMMENT '更新人',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `timestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `ix_oil_can_code` (`class_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='gts交班管理表格';



# Dump of table tb_oil_can
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tb_oil_can`;

CREATE TABLE `tb_oil_can` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `oil_can_code` varchar(10) NOT NULL DEFAULT '' COMMENT '油罐编码',
  `oil_can_name` varchar(100) NOT NULL DEFAULT '' COMMENT '油罐名称',
  `oil_can_type` varchar(100) NOT NULL DEFAULT '' COMMENT '油罐类型',
  `oil_product_name` varchar(100) NOT NULL DEFAULT '' COMMENT '油品类型',
  `district_name` varchar(100) NOT NULL DEFAULT '' COMMENT '所在区域',
  `station_code` varchar(50) NOT NULL DEFAULT '' COMMENT '油站编码',
  `station_name` varchar(100) NOT NULL DEFAULT '' COMMENT '油站名称',
  `station_real_code` varchar(100) NOT NULL DEFAULT '' COMMENT '油站实际编码',
  `oil_can_height` varchar(100) NOT NULL DEFAULT '' COMMENT '油罐高度',
  `oil_can_volumn` varchar(100) NOT NULL DEFAULT '' COMMENT '油罐容量',
  `liquid_level` varchar(100) NOT NULL DEFAULT '' COMMENT '液位',
  `water_level` varchar(100) NOT NULL DEFAULT '' COMMENT '水位',
  `averge_temperate` varchar(100) NOT NULL DEFAULT '' COMMENT '平均温度',
  `shi_temperate` varchar(100) NOT NULL DEFAULT '' COMMENT '视温度',
  `shi_density` varchar(100) NOT NULL DEFAULT '' COMMENT '视密度',
  `stardard_density` varchar(100) NOT NULL DEFAULT '' COMMENT '标准密度',
  `stardard_capacity` varchar(100) NOT NULL DEFAULT '' COMMENT '标准体积',
  `net_oil_capacity` varchar(100) NOT NULL DEFAULT '' COMMENT '净油体积',
  `water_capacity` varchar(100) NOT NULL DEFAULT '' COMMENT '水体积',
  `empty_capacity` varchar(100) NOT NULL DEFAULT '' COMMENT '空容积',
  `net_oil_quality` varchar(100) NOT NULL DEFAULT '' COMMENT '净油质量',
  `oil_can_status` varchar(100) NOT NULL DEFAULT '' COMMENT '储罐状态',
  `check_time` varchar(100) NOT NULL DEFAULT '' COMMENT '检测时间yyyy-mm-dd HH:mm:ss',
  `alarm_status` varchar(100) NOT NULL DEFAULT '' COMMENT '报警状态',
  `creator` varchar(100) NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updater` varchar(100) NOT NULL DEFAULT '' COMMENT '更新人',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `timestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_iol_can` (`oil_can_code`,`oil_can_name`,`station_name`,`station_real_code`),
  KEY `ix_oil_can_code` (`oil_can_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='油罐管理表，此表中包含每个油罐的编号、油罐中的油品类型、以及所在油站信息。';

LOCK TABLES `tb_oil_can` WRITE;
/*!40000 ALTER TABLE `tb_oil_can` DISABLE KEYS */;

INSERT INTO `tb_oil_can` (`id`, `oil_can_code`, `oil_can_name`, `oil_can_type`, `oil_product_name`, `district_name`, `station_code`, `station_name`, `station_real_code`, `oil_can_height`, `oil_can_volumn`, `liquid_level`, `water_level`, `averge_temperate`, `shi_temperate`, `shi_density`, `stardard_density`, `stardard_capacity`, `net_oil_capacity`, `water_capacity`, `empty_capacity`, `net_oil_quality`, `oil_can_status`, `check_time`, `alarm_status`, `creator`, `create_time`, `updater`, `update_time`, `timestamp`)
VALUES
	(1,'#1','#1','竖罐','汽油','东北区','1001','北京西站','1001','2000','3000','500','10','40','40','30','40','1500','500','400','100','600','正常','2016-02-26 10:00:00','正常','','2016-02-06 12:00:00','wwk','2016-02-06 12:00:00','2016-02-28 17:11:25'),
	(2,'#2','#2','竖罐','90#柴油','上海区域','1001','北京西站','1001','2000','3000','2000','10','40','40','30','40','1500','500','400','100','600','正常','2016-02-26 10:00:00','正常','','2016-02-06 12:00:00','127.0.0.1','2016-03-04 21:46:48','2016-03-04 21:46:48'),
	(3,'#3','#3','竖罐','90#柴油','西北二区','1001','北京西站','1001','2000','3000','2000','10','40','40','30','40','1500','500','400','100','600','正常','2016-02-26 10:00:00','正常','','2016-02-06 12:00:00','127.0.0.1','2016-03-04 21:43:45','2016-03-04 21:43:45'),
	(6,'#4','#4','竖罐','90#柴油','西南区','1001','北京西站','1001','2000','3000','2000','10','40','40','30','40','1500','500','400','100','600','正常','2016-02-26 10:00:00','正常','','2016-02-06 12:00:00','127.0.0.1','2016-03-04 21:46:43','2016-03-04 21:46:43');

/*!40000 ALTER TABLE `tb_oil_can` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table tb_oil_can_com
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tb_oil_can_com`;

CREATE TABLE `tb_oil_can_com` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `channel_id` varchar(10) NOT NULL DEFAULT '' COMMENT '通道号',
  `port` varchar(100) NOT NULL DEFAULT '' COMMENT '端口号，枚举值',
  `protocol` varchar(100) NOT NULL DEFAULT '' COMMENT '协议版本，枚举值',
  `com_period` varchar(100) NOT NULL DEFAULT '' COMMENT '通信周期，单位ms',
  `creator` varchar(100) NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updater` varchar(100) NOT NULL DEFAULT '' COMMENT '更新人',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `timestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_channel_id` (`channel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='油罐通道管理';

LOCK TABLES `tb_oil_can_com` WRITE;
/*!40000 ALTER TABLE `tb_oil_can_com` DISABLE KEYS */;

INSERT INTO `tb_oil_can_com` (`id`, `channel_id`, `port`, `protocol`, `com_period`, `creator`, `create_time`, `updater`, `update_time`, `timestamp`)
VALUES
	(2,'#2','COM1','液位计','200','www','2016-09-03 19:07:58','www','2016-09-03 19:07:58','0000-00-00 00:00:00');

/*!40000 ALTER TABLE `tb_oil_can_com` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table tb_oil_can_feeding
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tb_oil_can_feeding`;

CREATE TABLE `tb_oil_can_feeding` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `feeding_type` varchar(100) NOT NULL DEFAULT '' COMMENT '前尺或后尺',
  `oil_can_name` varchar(100) NOT NULL DEFAULT '' COMMENT '油罐名称',
  `oil_product_name` varchar(100) NOT NULL DEFAULT '' COMMENT '油品类型',
  `station_name` varchar(100) NOT NULL DEFAULT '' COMMENT '油站名称',
  `oil_height` varchar(100) NOT NULL DEFAULT '' COMMENT '油高',
  `water_height` varchar(100) NOT NULL DEFAULT '' COMMENT '水高',
  `averge_temperate` varchar(100) NOT NULL DEFAULT '' COMMENT '平均温度',
  `shi_temperate` varchar(100) NOT NULL DEFAULT '' COMMENT '视温度',
  `shi_density` varchar(100) NOT NULL DEFAULT '' COMMENT '视密度',
  `standard_density` varchar(100) NOT NULL DEFAULT '' COMMENT '标准密度',
  `standard_capacity` varchar(100) NOT NULL DEFAULT '' COMMENT '标准体积',
  `net_oil_capacity` varchar(100) NOT NULL DEFAULT '' COMMENT '净油体积',
  `water_capacity` varchar(100) NOT NULL DEFAULT '' COMMENT '水体积',
  `net_oil_quality` varchar(100) NOT NULL DEFAULT '' COMMENT '净油质量',
  `check_time` varchar(100) NOT NULL DEFAULT '' COMMENT '检测时间yyyy-mm-dd HH:mm:ss',
  `alarm_status` varchar(100) NOT NULL DEFAULT '' COMMENT '报警状态',
  `creator` varchar(100) NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updater` varchar(100) NOT NULL DEFAULT '' COMMENT '更新人',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `timestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `ix_oil_can_code` (`station_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='进油记录表';

LOCK TABLES `tb_oil_can_feeding` WRITE;
/*!40000 ALTER TABLE `tb_oil_can_feeding` DISABLE KEYS */;

INSERT INTO `tb_oil_can_feeding` (`id`, `feeding_type`, `oil_can_name`, `oil_product_name`, `station_name`, `oil_height`, `water_height`, `averge_temperate`, `shi_temperate`, `shi_density`, `standard_density`, `standard_capacity`, `net_oil_capacity`, `water_capacity`, `net_oil_quality`, `check_time`, `alarm_status`, `creator`, `create_time`, `updater`, `update_time`, `timestamp`)
VALUES
	(4,'后尺','#1','90#汽油','北京西站','1000','10','10','20','1','1','100','200','200','100','2015-12-01 10:00:00','正常','admin','2015-12-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-05 10:37:22'),
	(5,'后尺','#1','90#汽油','北京西站','1000','10','10','20','1','1','100','200','200','100','2015-12-01 10:00:00','正常','admin','2015-12-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-05 10:37:22'),
	(6,'后尺','#1','90#汽油','北京西站','1000','10','10','20','1','1','100','200','200','100','2015-12-01 10:00:00','正常','admin','2015-12-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-05 10:37:22'),
	(7,'后尺','#1','90#汽油','北京西站','1000','10','10','20','1','1','100','200','200','100','2015-12-01 10:00:00','正常','admin','2015-12-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-05 10:37:22'),
	(8,'后尺','#1','90#汽油','北京西站','1000','10','10','20','1','1','100','200','200','100','2015-12-01 10:00:00','正常','admin','2015-12-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-05 10:37:22'),
	(9,'后尺','#1','90#汽油','北京西站','1000','10','10','20','1','1','100','200','200','100','2015-12-01 10:00:00','正常','admin','2015-12-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-05 10:37:22'),
	(10,'后尺','#1','90#汽油','北京西站','1000','10','10','20','1','1','100','200','200','100','2015-12-01 10:00:00','正常','admin','2015-12-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-05 10:37:22'),
	(11,'后尺','#1','90#汽油','北京西站','1000','10','10','20','1','1','100','200','200','100','2015-12-01 10:00:00','正常','admin','2015-12-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-05 10:37:22'),
	(12,'后尺','#2','90#汽油','北京西站','1000','10','10','20','1','1','100','200','200','100','2016-03-01 10:00:00','正常','admin','2016-03-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-10 21:58:33'),
	(13,'后尺','#2','90#汽油','北京西站','1000','10','10','20','1','1','100','200','200','100','2016-03-01 10:00:00','正常','admin','2016-03-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-10 21:58:33'),
	(14,'后尺','#2','90#汽油','北京西站','1000','10','10','20','1','1','100','200','200','100','2016-03-01 10:00:00','正常','admin','2016-03-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-10 21:58:33'),
	(15,'后尺','#2','90#汽油','北京西站','1000','10','10','20','1','1','100','200','200','100','2016-03-01 10:00:00','正常','admin','2016-03-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-10 21:58:33'),
	(16,'后尺','#2','90#汽油','北京西站','1000','10','10','20','1','1','100','200','200','100','2016-03-01 10:00:00','正常','admin','2016-03-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-10 21:58:33'),
	(17,'后尺','#2','90#汽油','北京西站','1000','10','10','20','1','1','100','200','200','100','2016-03-01 10:00:00','正常','admin','2016-03-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-10 21:58:33'),
	(18,'后尺','#2','90#汽油','北京西站','1000','10','10','20','1','1','100','200','200','100','2016-03-01 10:00:00','正常','admin','2016-03-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-10 21:58:33'),
	(19,'后尺','#2','90#汽油','北京西站','1000','10','10','20','1','1','100','200','200','100','2016-03-01 10:00:00','正常','admin','2016-03-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-10 21:58:33'),
	(20,'后尺','#2','90#汽油','北京西站','1000','10','10','20','1','1','100','200','200','100','2016-03-01 10:00:00','正常','admin','2016-03-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-10 21:58:33'),
	(21,'后尺','#2','90#汽油','北京西站','1000','10','10','20','1','1','100','200','200','100','2016-03-01 10:00:00','正常','admin','2016-03-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-10 21:58:33'),
	(22,'后尺','#2','90#汽油','北京西站','1000','10','10','20','1','1','100','200','200','100','2016-03-01 10:00:00','正常','admin','2016-03-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-10 21:58:33'),
	(23,'后尺','#2','90#汽油','北京西站','1000','10','10','20','1','1','100','200','200','100','2016-03-01 10:00:00','正常','admin','2016-03-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-10 21:58:33'),
	(24,'后尺','#2','90#汽油','北京西站','1000','10','10','20','1','1','100','200','200','100','2016-03-01 10:00:00','正常','admin','2016-03-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-10 21:58:33'),
	(25,'后尺','#2','90#汽油','北京西站','1000','10','10','20','1','1','100','200','200','100','2016-03-01 10:00:00','正常','admin','2016-03-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-10 21:58:33'),
	(26,'后尺','#2','90#汽油','北京西站','1000','10','10','20','1','1','100','200','200','100','2016-03-01 10:00:00','正常','admin','2016-03-01 10:00:00','admin','2015-12-01 10:00:00','2016-03-10 21:58:33');

/*!40000 ALTER TABLE `tb_oil_can_feeding` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table tb_oil_product
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tb_oil_product`;

CREATE TABLE `tb_oil_product` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `oil_product_code` varchar(10) NOT NULL DEFAULT '' COMMENT '油品类型编码',
  `oil_product_name` varchar(100) NOT NULL DEFAULT '' COMMENT '油品类型名称',
  `oil_type_name` varchar(100) NOT NULL DEFAULT '' COMMENT '油料类型名称',
  `oil_color` varchar(100) NOT NULL DEFAULT '' COMMENT '油品颜色',
  `oil_product_name_for_outer` varchar(100) NOT NULL DEFAULT '' COMMENT '油品对外名称',
  `creator` varchar(100) NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updater` varchar(100) NOT NULL DEFAULT '' COMMENT '更新人',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `timestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `density` varchar(10) NOT NULL DEFAULT '' COMMENT '标准密度',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_oil_product_code` (`oil_product_code`),
  UNIQUE KEY `ux_oil_product_name` (`oil_product_name`),
  KEY `ix_oil_product_name` (`oil_product_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='油罐类型管理表-枚举值';

LOCK TABLES `tb_oil_product` WRITE;
/*!40000 ALTER TABLE `tb_oil_product` DISABLE KEYS */;

INSERT INTO `tb_oil_product` (`id`, `oil_product_code`, `oil_product_name`, `oil_type_name`, `oil_color`, `oil_product_name_for_outer`, `creator`, `create_time`, `updater`, `update_time`, `timestamp`, `density`)
VALUES
	(6,'6000298','90#柴油','汽油','#FFFFF66','90#低稀箐汽油','127.0.0.1','2016-01-03 11:39:50','127.0.0.1','2016-08-13 17:14:40','2016-08-13 17:14:40','892'),
	(7,'sss','sss','sss','#00FFFF','sss','127.0.0.1','2016-04-04 17:51:59','0:0:0:0:0:0:0:1','2016-08-22 22:29:32','2016-08-22 22:29:32','102');

/*!40000 ALTER TABLE `tb_oil_product` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table tb_oil_station
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tb_oil_station`;

CREATE TABLE `tb_oil_station` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `district_name` varchar(100) NOT NULL DEFAULT '' COMMENT '区域名称',
  `station_code` varchar(100) NOT NULL DEFAULT '' COMMENT '油站编码',
  `station_name` varchar(100) NOT NULL DEFAULT '' COMMENT '油站名称',
  `station_real_code` varchar(100) NOT NULL DEFAULT '' COMMENT '油站实际编码',
  `creator` varchar(100) NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updater` varchar(100) NOT NULL DEFAULT '' COMMENT '更新人',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `timestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_station_name` (`station_name`,`station_code`,`district_name`,`station_real_code`),
  KEY `ix_station_name` (`station_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='油站管理表，包含所有的油站信息';

LOCK TABLES `tb_oil_station` WRITE;
/*!40000 ALTER TABLE `tb_oil_station` DISABLE KEYS */;

INSERT INTO `tb_oil_station` (`id`, `district_name`, `station_code`, `station_name`, `station_real_code`, `creator`, `create_time`, `updater`, `update_time`, `timestamp`)
VALUES
	(1,'华北区','1001','北京西站','200','127.0.0.1','2016-01-02 18:25:46','127.0.0.1','2016-01-02 18:25:46','0000-00-00 00:00:00'),
	(2,'东北区','1002','东京站','200','127.0.0.1','2016-01-02 18:26:18','127.0.0.1','2016-01-02 18:26:18','2016-02-04 15:52:08');

/*!40000 ALTER TABLE `tb_oil_station` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table tb_oil_station_staff
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tb_oil_station_staff`;

CREATE TABLE `tb_oil_station_staff` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `district_name` varchar(10) NOT NULL DEFAULT '' COMMENT '区域名称',
  `oil_station_name` varchar(100) NOT NULL DEFAULT '' COMMENT '油站名称',
  `staff_id` varchar(10) NOT NULL DEFAULT '' COMMENT '员工编号',
  `staff_name` varchar(100) NOT NULL DEFAULT '' COMMENT '员工姓名',
  `staff_type` varchar(50) NOT NULL DEFAULT '' COMMENT '员工类型-自定义：如主任、普通、经理',
  `tel` varchar(50) NOT NULL DEFAULT '' COMMENT '工作人员座机电话',
  `phone` varchar(13) NOT NULL DEFAULT '' COMMENT '工作人员手机号码',
  `creator` varchar(100) NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updater` varchar(100) NOT NULL DEFAULT '' COMMENT '更新人',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `timestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_iol_can` (`staff_name`,`district_name`,`oil_station_name`,`staff_id`),
  KEY `ix_staff_id` (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='油站员工管理表-每个油站中所有工作人员以及工作人员职位身份手机电话信息管理表';

LOCK TABLES `tb_oil_station_staff` WRITE;
/*!40000 ALTER TABLE `tb_oil_station_staff` DISABLE KEYS */;

INSERT INTO `tb_oil_station_staff` (`id`, `district_name`, `oil_station_name`, `staff_id`, `staff_name`, `staff_type`, `tel`, `phone`, `creator`, `create_time`, `updater`, `update_time`, `timestamp`)
VALUES
	(3,'华北区','北京西站','A02','王天伏','后勤','010-1234567','19912345678','127.0.0.1','2016-01-02 19:10:08','127.0.0.1','2016-01-02 19:10:08','2016-02-01 23:06:13'),
	(5,'华北区','北京西站','A01','王天赐','后勤','010-1234567','19912345678','127.0.0.1','2016-01-02 19:16:27','127.0.0.1','2016-01-02 19:16:27','2016-02-01 23:06:15'),
	(6,'华北区','北京站','A01','王天赐','后勤','010-1234567','19912345678','127.0.0.1','2016-01-02 19:16:27','127.0.0.1','2016-01-02 19:16:27','2016-02-01 23:06:17'),
	(7,'华北区','东京站','11','中','中','010-12345678','13812345678','127.0.0.1','2016-01-09 22:47:07','127.0.0.1','2016-01-09 22:47:07','2016-02-05 00:50:56'),
	(8,'华北区','中','112','中','中','010-12345678','13812345678','127.0.0.1','2016-01-09 22:47:44','127.0.0.1','2016-01-09 22:47:44','2016-02-01 23:06:20'),
	(9,'东北区','中','113','中','中','010-12345678','13812345678','127.0.0.1','2016-01-09 22:48:41','127.0.0.1','2016-01-09 22:48:41','2016-02-01 23:06:32'),
	(10,'东北区','北京北站','114','小蚊子','经理','010-12345678','12312345678','127.0.0.1','2016-01-09 22:49:41','127.0.0.1','2016-01-09 22:49:41','2016-02-01 23:06:29'),
	(11,'东北区','北京西站','115','小蚊子','经理','010-12345678','12312345678','127.0.0.1','2016-01-09 22:51:27','127.0.0.1','2016-01-09 22:51:27','2016-02-01 23:06:35'),
	(12,'东北区','北京南站','117','打蚊子','经理','010-12345678','12312345678','127.0.0.1','2016-01-09 22:54:23','127.0.0.1','2016-01-09 22:54:23','2016-02-01 23:06:35'),
	(13,'西南区','中','1111','中','鸿','201','11','127.0.0.1','2016-01-09 22:55:55','127.0.0.1','2016-01-09 22:55:55','2016-02-01 23:06:55'),
	(14,'西南区','中','111','中','中','11','11','127.0.0.1','2016-01-10 07:43:39','127.0.0.1','2016-01-10 07:43:39','2016-02-01 23:06:57'),
	(17,'西北二区','北京西站','1014','王中王','经理','010-12345678','13712345678','127.0.0.1','2016-01-10 12:51:40','127.0.0.1','2016-01-10 12:51:40','2016-02-01 23:07:05'),
	(18,'undefined','undefined','0101101','撒贝宁','加油人员','010-10212121','18700001111','127.0.0.1','2016-04-04 18:22:14','127.0.0.1','2016-04-04 18:22:14','0000-00-00 00:00:00'),
	(19,'undefined','undefined','1001012','朱军','打扫卫生','010-12345678','12345678901','127.0.0.1','2016-04-04 18:24:07','127.0.0.1','2016-04-04 18:24:07','0000-00-00 00:00:00'),
	(20,'华北区','北京西站','1001022','冬青','传话员','010-12345678','13412345678','127.0.0.1','2016-04-04 18:27:52','127.0.0.1','2016-04-04 18:27:52','0000-00-00 00:00:00');

/*!40000 ALTER TABLE `tb_oil_station_staff` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table tb_oil_type
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tb_oil_type`;

CREATE TABLE `tb_oil_type` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `oil_type_code` varchar(10) NOT NULL DEFAULT '' COMMENT '油品类型编码',
  `oil_type_name` varchar(100) NOT NULL DEFAULT '' COMMENT '油品类型名称',
  `creator` varchar(100) NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updater` varchar(100) NOT NULL DEFAULT '' COMMENT '更新人',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `timestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_oil_type_code` (`oil_type_code`,`oil_type_name`),
  KEY `ix_oil_type_name` (`oil_type_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='油罐类型管理表-枚举值';

LOCK TABLES `tb_oil_type` WRITE;
/*!40000 ALTER TABLE `tb_oil_type` DISABLE KEYS */;

INSERT INTO `tb_oil_type` (`id`, `oil_type_code`, `oil_type_name`, `creator`, `create_time`, `updater`, `update_time`, `timestamp`)
VALUES
	(2,'003','汽油','127.0.0.1','2015-12-11 12:12:12','127.0.0.1','2016-01-24 18:26:14','2016-01-24 18:26:14');

/*!40000 ALTER TABLE `tb_oil_type` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table tb_shift_work
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tb_shift_work`;

CREATE TABLE `tb_shift_work` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `class_name` varchar(100) NOT NULL DEFAULT '' COMMENT '交接班组名称',
  `oil_can_name` varchar(100) NOT NULL DEFAULT '' COMMENT '油罐名称',
  `oil_product_name` varchar(100) NOT NULL DEFAULT '' COMMENT '油品类型',
  `district_name` varchar(100) NOT NULL DEFAULT '' COMMENT '区域名称',
  `station_name` varchar(100) NOT NULL DEFAULT '' COMMENT '油站名称',
  `shift_time` varchar(100) NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '交班时间',
  `oil_height` varchar(100) NOT NULL DEFAULT '' COMMENT '油高',
  `water_height` varchar(100) NOT NULL DEFAULT '' COMMENT '水高',
  `averge_temperate` varchar(100) NOT NULL DEFAULT '' COMMENT '平均温度',
  `shi_temperate` varchar(100) NOT NULL DEFAULT '' COMMENT '视温度',
  `shi_density` varchar(100) NOT NULL DEFAULT '' COMMENT '视密度',
  `standard_density` varchar(100) NOT NULL DEFAULT '' COMMENT '标准密度',
  `standard_capacity` varchar(100) NOT NULL DEFAULT '' COMMENT '标准体积',
  `net_oil_capacity` varchar(100) NOT NULL DEFAULT '' COMMENT '净油体积',
  `water_capacity` varchar(100) NOT NULL DEFAULT '' COMMENT '水体积',
  `net_oil_quality` varchar(100) NOT NULL DEFAULT '' COMMENT '净油质量',
  `creator` varchar(100) NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updater` varchar(100) NOT NULL DEFAULT '' COMMENT '更新人',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `timestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `ix_oil_can_code` (`station_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='交班管理表格';

LOCK TABLES `tb_shift_work` WRITE;
/*!40000 ALTER TABLE `tb_shift_work` DISABLE KEYS */;

INSERT INTO `tb_shift_work` (`id`, `class_name`, `oil_can_name`, `oil_product_name`, `district_name`, `station_name`, `shift_time`, `oil_height`, `water_height`, `averge_temperate`, `shi_temperate`, `shi_density`, `standard_density`, `standard_capacity`, `net_oil_capacity`, `water_capacity`, `net_oil_quality`, `creator`, `create_time`, `updater`, `update_time`, `timestamp`)
VALUES
	(1,'#1','#1','90#汽油','华北区','东京站','2016-10-10 10:10:00','1000','10','10','10','10.0','10.0','2000','2000','100','1000','我是谁','2016-10-10 10:10:00','我是谁','2016-10-10 10:10:00','2016-03-12 09:47:51'),
	(27,'#1','#1','90#汽油','华北区','东京站','2016-10-10 10:10:00','1000','10','10','10','10.0','10.0','2000','2000','100','1000','我是谁','2016-10-10 10:10:00','我是谁','2016-10-10 10:10:00','2016-03-12 09:47:51'),
	(28,'#1','#1','90#汽油','华北区','东京站','2016-10-10 10:10:00','1000','10','10','10','10.0','10.0','2000','2000','100','1000','我是谁','2016-10-10 10:10:00','我是谁','2016-10-10 10:10:00','2016-03-12 09:47:51'),
	(29,'#1','#1','90#汽油','华北区','东京站','2016-10-10 10:10:00','1000','10','10','10','10.0','10.0','2000','2000','100','1000','我是谁','2016-10-10 10:10:00','我是谁','2016-10-10 10:10:00','2016-03-12 09:47:51'),
	(30,'#1','#1','90#汽油','华北区','东京站','2016-10-10 10:10:00','1000','10','10','10','10.0','10.0','2000','2000','100','1000','我是谁','2016-10-10 10:10:00','我是谁','2016-10-10 10:10:00','2016-03-12 09:47:51'),
	(31,'#1','#1','90#汽油','华北区','北京西站','2016-10-10 10:10:00','1000','10','10','10','10.0','10.0','2000','2000','100','1000','我是谁','2016-10-10 10:10:00','我是谁','2016-10-10 10:10:00','2016-03-12 09:48:14'),
	(32,'#1','#1','90#汽油','华北区','北京西站','2016-10-10 10:10:00','1000','10','10','10','10.0','10.0','2000','2000','100','1000','我是谁','2016-10-10 10:10:00','我是谁','2016-10-10 10:10:00','2016-03-12 09:48:14'),
	(33,'#2','#1','90#汽油','华北区','北京西站','2016-10-10 10:10:00','1000','10','10','10','10.0','10.0','2000','2000','100','1000','我是谁','2016-10-10 10:10:00','我是谁','2016-10-10 10:10:00','2016-03-12 09:48:46'),
	(34,'#2','#1','90#汽油','东北区','东京站','2016-10-10 10:10:00','1000','10','10','10','10.0','10.0','2000','2000','100','1000','我是谁','2016-10-10 10:10:00','我是谁','2016-10-10 10:10:00','2016-03-12 09:48:48'),
	(35,'#2','#1','90#汽油','东北区','东京站','2016-10-10 10:10:00','1000','10','10','10','10.0','10.0','2000','2000','100','1000','我是谁','2016-10-10 10:10:00','我是谁','2016-10-10 10:10:00','2016-03-12 09:48:50'),
	(36,'#3','#1','90#汽油','东北区','东京站','2016-10-10 10:10:00','1000','10','10','10','10.0','10.0','2000','2000','100','1000','我是谁','2016-10-10 10:10:00','我是谁','2016-10-10 10:10:00','2016-03-12 09:48:50'),
	(37,'#2','#2','90#柴油','华北区','北京西站','2016-03-02 10:50:48','1000','1000','1000','1000','10','10','10','10','10','10','127.0.0.1','2016-03-12 22:31:20','127.0.0.1','2016-03-12 22:31:20','0000-00-00 00:00:00');

/*!40000 ALTER TABLE `tb_shift_work` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table tb_simple_user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tb_simple_user`;

CREATE TABLE `tb_simple_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(50) NOT NULL DEFAULT '' COMMENT '密码',
  `last_log_in_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后一次登录时间',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `timestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `permission` varchar(50) DEFAULT '' COMMENT '用户权限角色',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='GTS用户管理';

LOCK TABLES `tb_simple_user` WRITE;
/*!40000 ALTER TABLE `tb_simple_user` DISABLE KEYS */;

INSERT INTO `tb_simple_user` (`id`, `user_name`, `password`, `last_log_in_time`, `create_time`, `timestamp`, `permission`)
VALUES
	(1,'wwk','wwk','2016-01-01 10:10:10','2016-01-01 10:10:10','2016-06-28 00:00:55','[\"普通权限\",\"管理权限\"]'),
	(2,'wwk2','wwk','2016-01-01 10:10:10','2016-01-01 10:10:10','2016-07-04 22:45:15','[\"计量权限\",\"管理权限\"]'),
	(3,'ssssss','ssss','2016-01-01 10:10:10','2016-01-01 10:10:10','2016-07-04 23:32:54','[\"计量权限\",\"管理权限\"]'),
	(4,'wwk4','wwk','2016-01-01 10:10:10','2016-01-01 10:10:10','2016-07-04 23:33:50','[\"计量权限\",\"管理权限\",\"超级权限\"]');

/*!40000 ALTER TABLE `tb_simple_user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table tb_user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(50) NOT NULL DEFAULT '' COMMENT '密码',
  `district_name` varchar(100) NOT NULL DEFAULT '' COMMENT '地区',
  `department_name` varchar(100) NOT NULL DEFAULT '' COMMENT '地区',
  `group_name` varchar(100) NOT NULL DEFAULT '' COMMENT '组',
  `user_info` varchar(100) NOT NULL DEFAULT '' COMMENT '用户身份标识',
  `last_log_in_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后一次登录时间',
  `last_log_in_ip` varchar(50) NOT NULL DEFAULT '' COMMENT '最后一次登录IP',
  `on_line` int(11) NOT NULL DEFAULT '0' COMMENT '1登录0非登录状态',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `timestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `role` varchar(50) DEFAULT '' COMMENT '用户权限角色',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;

INSERT INTO `tb_user` (`id`, `user_name`, `password`, `district_name`, `department_name`, `group_name`, `user_info`, `last_log_in_time`, `last_log_in_ip`, `on_line`, `create_time`, `timestamp`, `role`)
VALUES
	(13,'登峰造极','1234567','上海区域','运营部','后端开发组','运营总监','2015-12-20 10:54:01','127.0.0.1',0,'2015-12-20 10:23:13','2016-04-02 13:12:33','admin'),
	(14,'www','www','华北区','总监组','总监组','小王子','0000-00-00 00:00:00','',0,'2016-02-28 12:40:19','2016-04-02 13:12:36','user'),
	(16,'www2','www','华北区','总监组','总监组','小王子2','0000-00-00 00:00:00','',0,'2016-02-28 12:40:52','2016-04-02 13:12:38','user'),
	(17,'sss','ssssss','华北区','总监组','总监组','小王子2','2016-07-21 07:56:19','127.0.0.1',0,'2016-03-22 23:26:30','2016-07-21 07:56:19','user');

/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table tb_user_group
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tb_user_group`;

CREATE TABLE `tb_user_group` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `group_id` varchar(50) NOT NULL DEFAULT '""' COMMENT '部门id',
  `group_name` varchar(100) NOT NULL DEFAULT '' COMMENT '部门名称',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `creator` varchar(100) NOT NULL DEFAULT '' COMMENT '创建人',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `updater` varchar(100) NOT NULL DEFAULT '' COMMENT '更新人',
  `timestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ix_group_name` (`group_name`),
  UNIQUE KEY `ix_group_id` (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `tb_user_group` WRITE;
/*!40000 ALTER TABLE `tb_user_group` DISABLE KEYS */;

INSERT INTO `tb_user_group` (`id`, `group_id`, `group_name`, `create_time`, `creator`, `update_time`, `updater`, `timestamp`)
VALUES
	(1,'1','总监组','2016-02-11 10:00:00','wwk','2016-02-11 10:00:00','wwk','2016-02-28 12:27:57'),
	(2,'2','后端开发组','2016-02-11 10:00:00','wwk','2016-02-11 10:00:00','wwk','2016-02-28 12:28:33');

/*!40000 ALTER TABLE `tb_user_group` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table tb_user_permission
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tb_user_permission`;

CREATE TABLE `tb_user_permission` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(50) NOT NULL DEFAULT '' COMMENT '权限名',
  `role_name` varchar(50) NOT NULL DEFAULT '' COMMENT '用户角色',
  PRIMARY KEY (`id`),
  UNIQUE KEY `permission_name` (`permission_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `tb_user_permission` WRITE;
/*!40000 ALTER TABLE `tb_user_permission` DISABLE KEYS */;

INSERT INTO `tb_user_permission` (`id`, `permission_name`, `role_name`)
VALUES
	(1,'[\"add\",\"delete\",\"update\"]','admin'),
	(2,'[\"delete\"]','user'),
	(3,'[\"update\"]','super');

/*!40000 ALTER TABLE `tb_user_permission` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table tb_user_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tb_user_role`;

CREATE TABLE `tb_user_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL DEFAULT '' COMMENT '用户名',
  `role_name` varchar(50) NOT NULL DEFAULT '' COMMENT '用户权限',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `tb_user_role` WRITE;
/*!40000 ALTER TABLE `tb_user_role` DISABLE KEYS */;

INSERT INTO `tb_user_role` (`id`, `user_name`, `role_name`)
VALUES
	(1,'sss','admin'),
	(2,'general','user');

/*!40000 ALTER TABLE `tb_user_role` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
