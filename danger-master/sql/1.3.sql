/*
SQLyog Ultimate v8.32 
MySQL - 5.7.10-log : Database - danger
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `danger` */

CREATE TABLE `danger` (
  `dangerId` int(11) NOT NULL AUTO_INCREMENT,
  `findTime` datetime DEFAULT NULL,
  `classType` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `findPerson` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `checkUnit` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `content` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  `dangerGrade` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `type` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `unit` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `manager` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `dangerStatusNum` varchar(2) COLLATE utf8_bin DEFAULT NULL COMMENT '����״̬��λ����һλ����״̬���ڶ�λ�������������:\n            10  ����  ��һ�����Ķ�\n            11  ����ڶ������Ķ�',
  `dangerStatus` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `dangerReport` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`dangerId`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='������';

/*Data for the table `danger` */

insert  into `danger`(`dangerId`,`findTime`,`classType`,`findPerson`,`checkUnit`,`address`,`content`,`dangerGrade`,`type`,`unit`,`manager`,`dangerStatusNum`,`dangerStatus`,`dangerReport`) values (88,'2017-09-12 10:45:52','乙班','ww','安全小分组','ww','ww','C','运输','机构1',NULL,'10','已四定','');
insert  into `danger`(`dangerId`,`findTime`,`classType`,`findPerson`,`checkUnit`,`address`,`content`,`dangerGrade`,`type`,`unit`,`manager`,`dangerStatusNum`,`dangerStatus`,`dangerReport`) values (89,NULL,NULL,NULL,'其他',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `delay` */

CREATE TABLE `delay` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sidingId` int(11) DEFAULT NULL,
  `delaySeq` int(11) DEFAULT NULL,
  `deleayReason` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `delayTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_7` (`sidingId`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`sidingId`) REFERENCES `sidingbiao` (`sidingId`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='����ÿ���Ķ�������';

/*Data for the table `delay` */

insert  into `delay`(`id`,`sidingId`,`delaySeq`,`deleayReason`,`delayTime`) values (51,45,0,NULL,'2017-09-12 10:46:26');

/*Table structure for table `department` */

CREATE TABLE `department` (
  `departmentId` varchar(40) NOT NULL,
  `upDepartmentId` varchar(40) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  `manager` varchar(40) DEFAULT NULL,
  `phone` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`departmentId`),
  KEY `FK_Reference_3` (`upDepartmentId`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`upDepartmentId`) REFERENCES `department` (`departmentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `department` */

insert  into `department`(`departmentId`,`upDepartmentId`,`name`,`manager`,`phone`) values ('10',NULL,'机构列表','周杰伦','10086');
insert  into `department`(`departmentId`,`upDepartmentId`,`name`,`manager`,`phone`) values ('10001','10','机构1','李易峰','10086');
insert  into `department`(`departmentId`,`upDepartmentId`,`name`,`manager`,`phone`) values ('10002','10','机构2','王凯','10086');
insert  into `department`(`departmentId`,`upDepartmentId`,`name`,`manager`,`phone`) values ('10003','10','机构3','宋仲基','10086');

/*Table structure for table `dictionary` */

CREATE TABLE `dictionary` (
  `dictionaryId` varchar(40) NOT NULL,
  `name` varchar(40) DEFAULT NULL,
  `upDictionaryId` varchar(40) DEFAULT NULL,
  `isUse` bit(1) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`dictionaryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='?ֵ??';

/*Data for the table `dictionary` */

insert  into `dictionary`(`dictionaryId`,`name`,`upDictionaryId`,`isUse`,`description`) values ('1','字典列表',NULL,'',NULL);
insert  into `dictionary`(`dictionaryId`,`name`,`upDictionaryId`,`isUse`,`description`) values ('100','隐患类型','1','',NULL);
insert  into `dictionary`(`dictionaryId`,`name`,`upDictionaryId`,`isUse`,`description`) values ('100001','采煤','100',NULL,NULL);
insert  into `dictionary`(`dictionaryId`,`name`,`upDictionaryId`,`isUse`,`description`) values ('100002','开掘','100',NULL,NULL);
insert  into `dictionary`(`dictionaryId`,`name`,`upDictionaryId`,`isUse`,`description`) values ('100003','机电','100',NULL,NULL);
insert  into `dictionary`(`dictionaryId`,`name`,`upDictionaryId`,`isUse`,`description`) values ('100004','运输','100',NULL,NULL);
insert  into `dictionary`(`dictionaryId`,`name`,`upDictionaryId`,`isUse`,`description`) values ('100005','通风','100',NULL,NULL);
insert  into `dictionary`(`dictionaryId`,`name`,`upDictionaryId`,`isUse`,`description`) values ('100006','地测','100',NULL,NULL);
insert  into `dictionary`(`dictionaryId`,`name`,`upDictionaryId`,`isUse`,`description`) values ('100007','其他','100',NULL,NULL);
insert  into `dictionary`(`dictionaryId`,`name`,`upDictionaryId`,`isUse`,`description`) values ('200','隐患状态','1',NULL,NULL);
insert  into `dictionary`(`dictionaryId`,`name`,`upDictionaryId`,`isUse`,`description`) values ('200001','未四定','200',NULL,NULL);
insert  into `dictionary`(`dictionaryId`,`name`,`upDictionaryId`,`isUse`,`description`) values ('200002','已四定','200',NULL,NULL);
insert  into `dictionary`(`dictionaryId`,`name`,`upDictionaryId`,`isUse`,`description`) values ('200003','已整改','200',NULL,NULL);
insert  into `dictionary`(`dictionaryId`,`name`,`upDictionaryId`,`isUse`,`description`) values ('200004','已复查','200',NULL,NULL);
insert  into `dictionary`(`dictionaryId`,`name`,`upDictionaryId`,`isUse`,`description`) values ('200005','已现场处理','200',NULL,NULL);
insert  into `dictionary`(`dictionaryId`,`name`,`upDictionaryId`,`isUse`,`description`) values ('300','隐患级别','1',NULL,NULL);
insert  into `dictionary`(`dictionaryId`,`name`,`upDictionaryId`,`isUse`,`description`) values ('300001','无','300',NULL,NULL);
insert  into `dictionary`(`dictionaryId`,`name`,`upDictionaryId`,`isUse`,`description`) values ('300002','A','300',NULL,NULL);
insert  into `dictionary`(`dictionaryId`,`name`,`upDictionaryId`,`isUse`,`description`) values ('300003','B','300',NULL,NULL);
insert  into `dictionary`(`dictionaryId`,`name`,`upDictionaryId`,`isUse`,`description`) values ('300004','C','300',NULL,NULL);
insert  into `dictionary`(`dictionaryId`,`name`,`upDictionaryId`,`isUse`,`description`) values ('400','检查单位','1',NULL,NULL);
insert  into `dictionary`(`dictionaryId`,`name`,`upDictionaryId`,`isUse`,`description`) values ('400001','安全小分组','400',NULL,NULL);
insert  into `dictionary`(`dictionaryId`,`name`,`upDictionaryId`,`isUse`,`description`) values ('400002','矿领导','400',NULL,NULL);
insert  into `dictionary`(`dictionaryId`,`name`,`upDictionaryId`,`isUse`,`description`) values ('400003','科领导','400',NULL,NULL);
insert  into `dictionary`(`dictionaryId`,`name`,`upDictionaryId`,`isUse`,`description`) values ('400004','屯兰安监处','400',NULL,NULL);
insert  into `dictionary`(`dictionaryId`,`name`,`upDictionaryId`,`isUse`,`description`) values ('400005','五人小组','400',NULL,NULL);
insert  into `dictionary`(`dictionaryId`,`name`,`upDictionaryId`,`isUse`,`description`) values ('400006','省厅','400',NULL,NULL);
insert  into `dictionary`(`dictionaryId`,`name`,`upDictionaryId`,`isUse`,`description`) values ('400007','山西焦煤','400',NULL,NULL);
insert  into `dictionary`(`dictionaryId`,`name`,`upDictionaryId`,`isUse`,`description`) values ('400008','西山煤电','400',NULL,NULL);
insert  into `dictionary`(`dictionaryId`,`name`,`upDictionaryId`,`isUse`,`description`) values ('400009','西山煤电安监局','400',NULL,NULL);
insert  into `dictionary`(`dictionaryId`,`name`,`upDictionaryId`,`isUse`,`description`) values ('500','哈哈哈哈','1','\0','爱爱爱');
insert  into `dictionary`(`dictionaryId`,`name`,`upDictionaryId`,`isUse`,`description`) values ('500001','哈哈哈哈','500','\0','发发发');

/*Table structure for table `follow` */

CREATE TABLE `follow` (
  `followId` int(11) NOT NULL AUTO_INCREMENT,
  `sidingId` int(11) DEFAULT NULL,
  `dangerId` int(11) DEFAULT NULL,
  `hasSecurity` varchar(2) COLLATE utf8_bin DEFAULT NULL,
  `safetyTechnician` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `managerName` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `recheckTime` datetime DEFAULT NULL,
  PRIMARY KEY (`followId`),
  KEY `FK_Reference_4` (`sidingId`),
  KEY `FK_Reference_8` (`dangerId`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`sidingId`) REFERENCES `sidingbiao` (`sidingId`),
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`dangerId`) REFERENCES `danger` (`dangerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='�������ٱ�';

/*Data for the table `follow` */

/*Table structure for table `rechecktable` */

CREATE TABLE `rechecktable` (
  `recheckid` int(11) NOT NULL AUTO_INCREMENT,
  `followId` int(11) DEFAULT NULL,
  `dangerId` int(11) DEFAULT NULL,
  `recheckMan` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `recheckdate` datetime DEFAULT NULL,
  `recheckresult` varchar(2) COLLATE utf8_bin DEFAULT NULL,
  `comment` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`recheckid`),
  KEY `FK_Reference_5` (`followId`),
  KEY `FK_Reference_9` (`dangerId`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`followId`) REFERENCES `follow` (`followId`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`dangerId`) REFERENCES `danger` (`dangerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `rechecktable` */

/*Table structure for table `sidingbiao` */

CREATE TABLE `sidingbiao` (
  `sidingId` int(11) NOT NULL AUTO_INCREMENT,
  `dangerId` int(11) DEFAULT NULL,
  `sidingTime` datetime DEFAULT NULL,
  `supervisor` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `rectificationTime` datetime DEFAULT NULL,
  `rectificationMeasure` varchar(600) COLLATE utf8_bin DEFAULT NULL,
  `dutyPerson` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`sidingId`),
  KEY `FK_Reference_1` (`dangerId`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`dangerId`) REFERENCES `danger` (`dangerId`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `sidingbiao` */

insert  into `sidingbiao`(`sidingId`,`dangerId`,`sidingTime`,`supervisor`,`rectificationTime`,`rectificationMeasure`,`dutyPerson`) values (45,88,'2017-09-12 10:46:28','ww','2017-09-12 10:46:26','ww','ww');

/*Table structure for table `spotdispose` */

CREATE TABLE `spotdispose` (
  `disposeId` int(11) NOT NULL AUTO_INCREMENT,
  `dangerId` int(11) DEFAULT NULL,
  `hasSafeMeasure` varchar(2) COLLATE utf8_bin DEFAULT NULL,
  `disposeMeasure` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `disposeDate` datetime DEFAULT NULL,
  `disposePerson` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`disposeId`),
  KEY `FK_Reference_6` (`dangerId`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`dangerId`) REFERENCES `danger` (`dangerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `spotdispose` */

/*Table structure for table `user` */

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `role` int(11) DEFAULT NULL COMMENT '��1��2��3.�����������ͬ��Ȩ�ޣ���ʾ��ͬ�Ĳ˵�',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `user` */

/*Table structure for table `danger_siding` */

DROP TABLE IF EXISTS `danger_siding`;

/*!50001 CREATE TABLE  `danger_siding`(
 `dangerId` int(11) ,
 `findtime` datetime ,
 `classtype` varchar(40) ,
 `findperson` varchar(40) ,
 `checkunit` varchar(40) ,
 `address` varchar(40) ,
 `content` varchar(1000) ,
 `dangerGrade` varchar(10) ,
 `type` varchar(20) ,
 `unit` varchar(40) ,
 `manager` varchar(40) ,
 `dangerStatusNum` varchar(2) ,
 `dangerStatus` varchar(40) ,
 `dangerReport` varchar(1000) ,
 `sidingid` int(11) ,
 `sidingTime` datetime ,
 `supervisor` varchar(40) ,
 `rectificationTime` datetime ,
 `rectificationMeasure` varchar(600) ,
 `dutyPerson` varchar(40) 
)*/;

/*Table structure for table `danger_siding_follow` */

DROP TABLE IF EXISTS `danger_siding_follow`;

/*!50001 CREATE TABLE  `danger_siding_follow`(
 `dangerId` int(11) ,
 `findtime` datetime ,
 `classtype` varchar(40) ,
 `findperson` varchar(40) ,
 `checkunit` varchar(40) ,
 `address` varchar(40) ,
 `content` varchar(1000) ,
 `dangerGrade` varchar(10) ,
 `type` varchar(20) ,
 `unit` varchar(40) ,
 `manager` varchar(40) ,
 `dangerStatusNum` varchar(2) ,
 `dangerStatus` varchar(40) ,
 `dangerReport` varchar(1000) ,
 `sidingId` int(11) ,
 `sidingTime` datetime ,
 `supervisor` varchar(40) ,
 `rectificationTime` datetime ,
 `rectificationMeasure` varchar(600) ,
 `dutyPerson` varchar(40) ,
 `followId` int(11) ,
 `hasSecurity` varchar(2) ,
 `safetyTechnician` varchar(40) ,
 `managerName` varchar(40) ,
 `recheckTime` datetime 
)*/;

/*Table structure for table `danger_siding_follow_recheck` */

DROP TABLE IF EXISTS `danger_siding_follow_recheck`;

/*!50001 CREATE TABLE  `danger_siding_follow_recheck`(
 `dangerId` int(11) ,
 `findtime` datetime ,
 `classtype` varchar(40) ,
 `findperson` varchar(40) ,
 `checkunit` varchar(40) ,
 `address` varchar(40) ,
 `content` varchar(1000) ,
 `dangerGrade` varchar(10) ,
 `type` varchar(20) ,
 `unit` varchar(40) ,
 `manager` varchar(40) ,
 `dangerStatusNum` varchar(2) ,
 `dangerStatus` varchar(40) ,
 `dangerReport` varchar(1000) ,
 `sidingId` int(11) ,
 `sidingTime` datetime ,
 `supervisor` varchar(40) ,
 `rectificationTime` datetime ,
 `rectificationMeasure` varchar(600) ,
 `dutyPerson` varchar(40) ,
 `followId` int(11) ,
 `hasSecurity` varchar(2) ,
 `safetyTechnician` varchar(40) ,
 `managerName` varchar(40) ,
 `recheckTime` datetime ,
 `recheckid` int(11) ,
 `recheckMan` varchar(40) ,
 `recheckdate` datetime ,
 `recheckresult` varchar(2) ,
 `comment` varchar(200) 
)*/;

/*Table structure for table `danger_spot` */

DROP TABLE IF EXISTS `danger_spot`;

/*!50001 CREATE TABLE  `danger_spot`(
 `dangerId` int(11) ,
 `findtime` datetime ,
 `classtype` varchar(40) ,
 `findperson` varchar(40) ,
 `checkunit` varchar(40) ,
 `address` varchar(40) ,
 `content` varchar(1000) ,
 `dangerGrade` varchar(10) ,
 `type` varchar(20) ,
 `unit` varchar(40) ,
 `manager` varchar(40) ,
 `dangerStatusNum` varchar(2) ,
 `dangerStatus` varchar(40) ,
 `dangerReport` varchar(1000) ,
 `hasSafeMeasure` varchar(2) ,
 `disposeMeasure` varchar(500) ,
 `disposeDate` datetime ,
 `disposePerson` varchar(40) 
)*/;

/*View structure for view danger_siding */

/*!50001 DROP TABLE IF EXISTS `danger_siding` */;
/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `danger_siding` AS select `d`.`dangerId` AS `dangerId`,`d`.`findTime` AS `findtime`,`d`.`classType` AS `classtype`,`d`.`findPerson` AS `findperson`,`d`.`checkUnit` AS `checkunit`,`d`.`address` AS `address`,`d`.`content` AS `content`,`d`.`dangerGrade` AS `dangerGrade`,`d`.`type` AS `type`,`d`.`unit` AS `unit`,`d`.`manager` AS `manager`,`d`.`dangerStatusNum` AS `dangerStatusNum`,`d`.`dangerStatus` AS `dangerStatus`,`d`.`dangerReport` AS `dangerReport`,`s`.`sidingId` AS `sidingid`,`s`.`sidingTime` AS `sidingTime`,`s`.`supervisor` AS `supervisor`,`s`.`rectificationTime` AS `rectificationTime`,`s`.`rectificationMeasure` AS `rectificationMeasure`,`s`.`dutyPerson` AS `dutyPerson` from (`danger` `d` join `sidingbiao` `s`) where (`d`.`dangerId` = `s`.`dangerId`) */;

/*View structure for view danger_siding_follow */

/*!50001 DROP TABLE IF EXISTS `danger_siding_follow` */;
/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `danger_siding_follow` AS select `d`.`dangerId` AS `dangerId`,`d`.`findTime` AS `findtime`,`d`.`classType` AS `classtype`,`d`.`findPerson` AS `findperson`,`d`.`checkUnit` AS `checkunit`,`d`.`address` AS `address`,`d`.`content` AS `content`,`d`.`dangerGrade` AS `dangerGrade`,`d`.`type` AS `type`,`d`.`unit` AS `unit`,`d`.`manager` AS `manager`,`d`.`dangerStatusNum` AS `dangerStatusNum`,`d`.`dangerStatus` AS `dangerStatus`,`d`.`dangerReport` AS `dangerReport`,`s`.`sidingId` AS `sidingId`,`s`.`sidingTime` AS `sidingTime`,`s`.`supervisor` AS `supervisor`,`s`.`rectificationTime` AS `rectificationTime`,`s`.`rectificationMeasure` AS `rectificationMeasure`,`s`.`dutyPerson` AS `dutyPerson`,`f`.`followId` AS `followId`,`f`.`hasSecurity` AS `hasSecurity`,`f`.`safetyTechnician` AS `safetyTechnician`,`f`.`managerName` AS `managerName`,`f`.`recheckTime` AS `recheckTime` from ((`danger` `d` join `sidingbiao` `s`) join `follow` `f`) where ((`d`.`dangerId` = `s`.`dangerId`) and (`s`.`dangerId` = `f`.`dangerId`) and (`s`.`sidingId` = `f`.`sidingId`)) */;

/*View structure for view danger_siding_follow_recheck */

/*!50001 DROP TABLE IF EXISTS `danger_siding_follow_recheck` */;
/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `danger_siding_follow_recheck` AS select `d`.`dangerId` AS `dangerId`,`d`.`findTime` AS `findtime`,`d`.`classType` AS `classtype`,`d`.`findPerson` AS `findperson`,`d`.`checkUnit` AS `checkunit`,`d`.`address` AS `address`,`d`.`content` AS `content`,`d`.`dangerGrade` AS `dangerGrade`,`d`.`type` AS `type`,`d`.`unit` AS `unit`,`d`.`manager` AS `manager`,`d`.`dangerStatusNum` AS `dangerStatusNum`,`d`.`dangerStatus` AS `dangerStatus`,`d`.`dangerReport` AS `dangerReport`,`s`.`sidingId` AS `sidingId`,`s`.`sidingTime` AS `sidingTime`,`s`.`supervisor` AS `supervisor`,`s`.`rectificationTime` AS `rectificationTime`,`s`.`rectificationMeasure` AS `rectificationMeasure`,`s`.`dutyPerson` AS `dutyPerson`,`f`.`followId` AS `followId`,`f`.`hasSecurity` AS `hasSecurity`,`f`.`safetyTechnician` AS `safetyTechnician`,`f`.`managerName` AS `managerName`,`f`.`recheckTime` AS `recheckTime`,`r`.`recheckid` AS `recheckid`,`r`.`recheckMan` AS `recheckMan`,`r`.`recheckdate` AS `recheckdate`,`r`.`recheckresult` AS `recheckresult`,`r`.`comment` AS `comment` from (((`danger` `d` join `sidingbiao` `s`) join `follow` `f`) join `rechecktable` `r`) where ((`d`.`dangerId` = `s`.`dangerId`) and (`s`.`dangerId` = `f`.`dangerId`) and (`s`.`sidingId` = `f`.`sidingId`) and (`r`.`followId` = `f`.`followId`)) */;

/*View structure for view danger_spot */

/*!50001 DROP TABLE IF EXISTS `danger_spot` */;
/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `danger_spot` AS select `d`.`dangerId` AS `dangerId`,`d`.`findTime` AS `findtime`,`d`.`classType` AS `classtype`,`d`.`findPerson` AS `findperson`,`d`.`checkUnit` AS `checkunit`,`d`.`address` AS `address`,`d`.`content` AS `content`,`d`.`dangerGrade` AS `dangerGrade`,`d`.`type` AS `type`,`d`.`unit` AS `unit`,`d`.`manager` AS `manager`,`d`.`dangerStatusNum` AS `dangerStatusNum`,`d`.`dangerStatus` AS `dangerStatus`,`d`.`dangerReport` AS `dangerReport`,`s`.`hasSafeMeasure` AS `hasSafeMeasure`,`s`.`disposeMeasure` AS `disposeMeasure`,`s`.`disposeDate` AS `disposeDate`,`s`.`disposePerson` AS `disposePerson` from (`danger` `d` join `spotdispose` `s`) where (`d`.`dangerId` = `s`.`dangerId`) */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
