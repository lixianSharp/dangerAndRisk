/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.40 : Database - danger
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `danger` */

DROP TABLE IF EXISTS `danger`;

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
  `dangerStatusNum` varchar(2) COLLATE utf8_bin DEFAULT NULL COMMENT 'ï¿½ï¿½ï¿½ï¿½×´Ì¬ï¿½ï¿½Î»ï¿½ï¿½ï¿½ï¿½Ò»Î»ï¿½ï¿½ï¿½ï¿½×´Ì¬ï¿½ï¿½ï¿½Ú¶ï¿½Î»ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½:\n            10  ï¿½ï¿½ï¿½ï¿½  ï¿½ï¿½Ò»ï¿½ï¿½ï¿½ï¿½ï¿½Ä¶ï¿½\n            11  ï¿½ï¿½ï¿½ï¿½Ú¶ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ä¶ï¿½',
  `dangerStatus` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `dangerReport` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`dangerId`)
) ENGINE=InnoDB AUTO_INCREMENT=156 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½';

/*Data for the table `danger` */

LOCK TABLES `danger` WRITE;

insert  into `danger`(`dangerId`,`findTime`,`classType`,`findPerson`,`checkUnit`,`address`,`content`,`dangerGrade`,`type`,`unit`,`manager`,`dangerStatusNum`,`dangerStatus`,`dangerReport`) values (90,'2017-12-10 00:10:47','零点班','和志军、申继刚、景建立、陈晋东','县煤炭局','副立井','副立井井筒有结冰现象','C','其他','地面运输队','王向卫','00','已现场处理',''),(91,'2017-12-10 00:10:34','零点班','和志军、申继刚、陈晋东、景建立','县煤炭局','副立井','副立井井底平台与罐笼间隙 ...','C','其他','井下运输队','王文芳','00','已现场处理',''),(92,'2017-12-10 00:09:58','零点班','和志军、申继刚、陈晋东、景建立','县煤炭局','3113综采工作面','3113综采工作面部分支 ...','C','采煤','综采队','宋志令','00','已现场处理',''),(93,'2017-12-10 00:13:09','零点班','和志军、申继刚、陈晋东、景建立','县煤炭局','3113综采工作面','3113回风顺槽有一台QBZ80开关上风侧无甲烷断电仪','C','机电','机电科','程林忠','00','已现场处理',''),(94,'2017-12-10 00:15:02','零点班','和志军、申继刚、陈晋东、景建立','县煤炭局','3113综采工作面','3113综采工作面顶板破碎，护顶不及时。','C','采煤','综采队','宋志令','00','已现场处理',''),(95,'2017-12-14 09:23:53','捌点班','李小平、李东兴、曹波、冯鹏飞、景建立、辛光明、丁超','县煤炭局','3113综采工作面','3113综采工作面29—40#支架段顶板漏矸','C','采煤','综采队','宋志令','00','已现场处理',''),(96,'2017-12-14 09:27:57','捌点班','李小平、李东兴、曹波、冯鹏飞、景建立、辛光明、丁超','县煤炭局','3113综采工作面','3113综采工作面28#支架戗柱打设角度偏向行人侧，且无防倒措施。','C','采煤','综采队','宋志令','00','已现场处理',''),(97,'2017-12-14 09:30:06','捌点班','李小平、李东兴、曹波、冯鹏飞、景建立、辛光明、丁超','县煤炭局','副立井','副立井井底信号硐室应增设照明','C','机电','机电科','程林忠','00','已现场处理',''),(98,'2017-12-14 09:32:06','捌点班','李小平、李东兴、曹波、冯鹏飞、景建立、辛光明、丁超','县煤炭局','3113综采工作面','3113综采工作面回风顺槽超前支护外一处钢梁棚腿折断续及时更换。','C','采煤','综采队','宋志令','00','已现场处理',''),(99,'2017-12-14 09:33:50','捌点班','李小平、李东兴、曹波、冯鹏飞、景建立、辛光明、丁超','县煤炭局','3113综采工作面','3113综采工作面上隅角 ...','C','其他','通风科','李强','00','已现场处理',''),(101,'2017-12-14 09:49:05','捌点班','李小平、李东兴、曹波、冯鹏飞、景建立、辛光明、丁超','县煤炭局','3113综采工作面','3113综采工作面进风顺槽超前支护单体柱编号乱。','C','采煤','综采队','宋志令','00','已现场处理',''),(102,'2017-12-20 16:33:40','肆点班','李小平、梁秀前、李东兴、冯鹏飞、辛光明、丁超','县煤炭局','3113综采工作面','3113综采工作面架间浮煤多，煤质松软，部分地段有活矸、落煤。','C','采煤','综采队','宋志令','00','已现场处理',''),(103,'2017-12-20 16:37:04','肆点班','李小平、梁秀前、李东兴、冯鹏飞、辛光明、丁超','县煤炭局','总回风巷、西轨道巷','总回风巷与西轨道巷联络风门无语音报警装置，风门内放有风筒布等杂物。','C','通风','通风科','张伟炳','00','已现场处理',''),(104,'2017-12-20 16:57:37','肆点班','李小平、梁秀前、李东兴、冯鹏飞、辛光明、丁超','县煤炭局','西皮带运输巷','西皮带运输巷一处密闭未挂管理排版，设置栅栏。','C','通风','通风科','张伟炳','00','已现场处理',''),(105,'2017-12-02 11:04:33','捌点班','矿长、各分管矿长及科队长','矿级领导','3113综采工作面','3113综采工作面煤溜机头搭接短，需整改。','C','采煤','综采队','宋志令','00','已现场处理',''),(106,'2017-12-02 09:38:16','捌点班','矿长、各分管矿长及科队长','矿级领导','3113综采工作面','3113综采工作面机头排钢梁打设不规范，需整改。','C','采煤','综采队','宋志令','10','已五定',''),(107,'2017-12-02 09:39:59','捌点班','矿长、各分管矿长及科队长','矿级领导','3113综采工作面','3113综采工作面机尾煤帮连网质量差，及时处理。','C','采煤','综采队','宋志令','00','已现场处理',''),(108,'2017-12-02 09:41:15','捌点班','矿长、各分管矿长及科队长','矿级领导','3113综采工作面','3113综采工作面回风巷 ...','C','采煤','综采队','宋志令','00','已现场处理',''),(109,'2017-12-02 09:44:20','捌点班','矿长、各分管矿长及科队长','矿级领导','轨道巷','轨道大巷大绞车处钢梁变形，电缆受力。','C','机电','机电队','宋其林','10','已五定',''),(110,'2017-12-02 09:45:30','捌点班','矿长、各分管矿长及科队长','矿级领导','3113','3113皮带转载机头积煤 ...','C','其他','搬运队','焦保珍','00','已现场处理',''),(111,'2017-12-02 09:48:18','捌点班','矿长、各分管矿长及科队长','矿级领导','轨道巷','轨道巷3113绕道有废旧 ...','C','其他','搬运队','焦保珍','10','已五定',''),(112,'2017-12-02 09:49:41','捌点班','矿长、各分管矿长及科队长','矿级领导','总回风巷','总回风大巷上坡处地滚不转，尽快处理。','C','其他','搬运队','焦保珍','00','已现场处理',''),(113,'2017-12-09 08:58:52','捌点班','矿长、各分管矿长及科、队长','矿级领导','3113综采面','3113综采工作面机头三角区联网质量差。','C','采煤','综采队','宋志令','00','已现场处理',''),(114,'2017-12-09 09:01:02','捌点班','矿长、各分管矿长及科、队长','矿级领导','3113综采面','3113综采工作面45#支架液管漏液，需及时更换。','C','采煤','综采队','宋志令','00','已现场处理',''),(115,'2017-12-09 09:03:00','捌点班','矿长、各分管矿长及科、队长','矿级领导','3113综采面','3113综采工作面回风巷卫生材料清理，煤尘大，需洒水降尘','C','采煤','综采队','宋志令','00','已现场处理',''),(116,'2017-12-09 09:09:19','捌点班','矿长、各分管矿长及科、队长','矿级领导','轨道巷','轨道巷避难硐室门口垃圾应及时清理','C','其他','搬运队','焦保珍','10','已五定',''),(117,'2017-12-09 09:15:56','捌点班','矿长、各分管矿长及科、队长','矿级领导','轨道巷','轨道巷3113绕道刮板及 ...','C','其他','搬运队','焦保珍','10','已整改',''),(118,'2017-12-09 09:40:12','捌点班','矿长、各分管矿长及科、队长','矿级领导','轨道巷','轨道巷3113口11.4 ...','C','机电','机电队','宋其林','10','已五定',''),(119,'2017-12-09 10:30:29','捌点班','矿长、各分管矿长及科、队长','矿级领导','3113泵站','3113 泵站前后10米范围电缆吊挂比较乱','C','机电','机电队','宋其林','10','已五定',''),(120,'2017-12-09 11:12:35','捌点班','矿长、各分管矿长及科、队长','矿级领导','总回风巷','总回风巷静压水管漏水（梯子处）需更换','C','运输','井下运输队','王文芳','10','已五定',''),(121,'2017-12-16 11:25:01','捌点班','矿长、各分管矿长及科、队长','矿级领导','3113皮带巷','3113皮带巷二部皮带机 ...','C','运输','井下运输队','王文芳','10','已五定',''),(122,'2017-12-09 11:20:07','捌点班','矿长、各分管矿长及科、队长','矿级领导','3113皮带巷','3113皮带巷二部皮带机头积煤多，清理不及时','C','运输','井下运输队','王文芳','00','已现场处理',''),(123,'2017-12-16 08:13:37','捌点班','矿长、各分管矿长及科、队长','矿级领导','3113运输顺槽','3113运输顺槽煤溜机尾 ...','C','采煤','综采队','宋志令','00','已现场处理',''),(124,'2017-12-16 08:15:59','捌点班','矿长、各分管矿长及科、队长','矿级领导','3113综采工作面','3113综采工作面部分架间浮煤多，应及时清理','C','采煤','综采队','宋志令','00','已现场处理',''),(125,'2017-12-16 08:30:34','捌点班','矿长、各分管矿长及科、队长','矿级领导','3113综采工作面','3113综采工作面前煤溜弯度大，应尽快调整','C','采煤','综采队','宋志令','10','已五定',''),(126,'2017-12-16 09:12:48','捌点班','矿长、各分管矿长及科、队长','矿级领导','3113综采工作面','3113综采工作面回风巷超前段有2根漏液柱，需更换。','C','采煤','综采队','宋志令','00','已现场处理',''),(127,'2017-12-16 09:31:08','捌点班','矿长、各分管矿长及科、队长','矿级领导','3113皮带巷','3113皮带巷机头打点信号不清，需及时更换','C','机电','机电队','宋其林','00','已现场处理',''),(128,'2017-12-16 10:16:44','捌点班','矿长、各分管矿长及科、队长','矿级领导','西大巷','西大巷一部皮带上坡处有2个托辊不转，及时更换','C','运输','井下运输队','王文芳','10','已五定',''),(129,'2017-12-16 10:36:04','捌点班','矿长、各分管矿长及科、队长','矿级领导','3113二部皮带','3113二部皮带里帮积煤多，应每班清理','C','运输','井下运输队','王文芳','10','已五定',''),(130,'2017-12-16 11:20:28','捌点班','矿长、各分管矿长及科、队长','矿级领导','斜井井底','斜井井底11.4绞车副钢丝绳绳头绳卡被抽动','C','其他','搬运队','焦保珍','10','已五定',''),(131,'2017-12-16 11:33:45','捌点班','矿长、各分管矿长及科、队长','矿级领导','3113回风巷','3113回风巷的废旧材料，应回收升井','C','其他','搬运队','焦保珍','10','已五定',''),(132,'2017-12-16 11:48:15','捌点班','矿长、各分管矿长及科、队长','矿级领导','总回风巷','总回风巷双速绞车12月15日运行记录未填写','C','其他','搬运队','焦保珍','10','已五定',''),(133,'2017-12-23 07:59:42','捌点班','矿长、各分管矿长及科、队长','矿级领导','3113综采工作面','3113综采工作面顺槽超前支护打设不规范，应整改。','C','采煤','综采队','宋志令','10','已五定',''),(134,'2017-12-23 08:05:37','捌点班','矿长、各分管矿长及科、队长','矿级领导','3113 综采工作面','3113综采工作面煤质松软，应加强煤帮管理','C','采煤','综采队','宋志令','00','已现场处理',''),(135,'2017-12-23 08:07:33','捌点班','矿长、各分管矿长及科、队长','矿级领导','3113综采工作面','3113综采工作面回风超前有3根漏液柱，需更换。','C','采煤','综采队','宋志令','00','已现场处理',''),(136,'2017-12-23 08:58:47','捌点班','矿长、各分管矿长及科、队长','矿级领导','3113皮带巷','3113皮带巷二部机头洒 ...','C','运输','井下运输队','宋志令','00','已现场处理',''),(137,'2017-12-23 09:32:11','捌点班','矿长、各分管矿长及科、队长','矿级领导','西运巷','西运巷一部皮带中间积煤多，需及时清理','C','其他','井下运输队','王文芳','00','已现场处理',''),(138,'2017-12-23 10:38:44','捌点班','矿长、各分管矿长及科、队长','矿级领导','井底车场','井底车场11.4绞车压柱松，应重新整改','C','其他','搬运队','焦保珍','00','已现场处理',''),(139,'2017-12-23 11:03:09','捌点班','矿长、各分管矿长及科、队长','矿级领导','3113综采工作面','3113综采工作面机头有 ...','C','其他','机电队','宋其林','00','已现场处理',''),(140,'2017-12-23 11:45:41','捌点班','矿长、各分管矿长及科、队长','矿级领导','3113皮带巷','3113皮带巷一部皮带跑 ...','C','其他','机电队','宋其林','10','已五定',''),(141,'2018-01-06 08:40:05','捌点班','矿长、各分管矿长及科、队长','矿级领导','3113运巷','3113运巷皮带机护网应固定，里帮皮带下的矸石、积煤需清理','C','采煤','综采队','宋志令','10','已五定',''),(142,'2018-01-06 09:21:35','捌点班','矿长、各分管矿长及科、队长','矿级领导','3113顺槽','3113顺槽转载刮板机更换弯刮板','C','采煤','综采队','宋志令','10','已五定',''),(143,'2018-01-06 09:32:52','捌点班','矿长、各分管矿长及科、队长','矿级领导','3113综采工作面','3113综采工作面采煤机外喷雾固定不牢，方向不对，采煤机缺少载齿','C','采煤','综采队','宋志令','10','已五定',''),(144,'2018-01-06 09:56:52','捌点班','矿长、各分管矿长及科、队长','矿级领导','3113进风巷','3113进风巷超前支护北帮单体柱不足，应补全','C','采煤','综采队','宋志令','10','已五定',''),(145,'2018-01-06 10:46:21','捌点班','矿长、各分管矿长及科、队长','矿级领导','起吊室外','起吊室坡下小水泵处，池内煤泥需清理','C','其他','搬运队','焦保珍','10','已五定',''),(146,'2018-01-06 10:59:51','捌点班','矿长、各分管矿长及科、队长','矿级领导','轨道巷','轨道巷与西运巷联络巷卫生洒水，材料应整理','C','其他','搬运队','焦保珍','10','已五定',''),(147,'2018-01-06 11:23:07','捌点班','矿长、各分管矿长及科、队长','矿级领导','轨道巷','轨道巷台阶半坡处一个木柱失效，需更换','C','其他','搬运队','焦保珍','10','已五定',''),(148,'2018-01-06 12:50:29','捌点班','矿长、各分管矿长及科、队长','矿级领导','轨道巷车场','轨道巷车场小绞车记录填写 ...','C','其他','搬运队','焦保珍','10','已五定',''),(149,'2018-01-06 13:58:44','捌点班','矿长、各分管矿长及科、队长','矿级领导','中央变电所外','中央变电所外压风自救装置无风，供水施救装置无水，需处理','C','其他','井下运输队','王文芳','10','已五定',''),(150,'2018-01-08 08:41:35','捌点班','梁秀前、李东兴、辛光明、景建立、丁超','乡煤管站','3113综采工作面','3113综采工作面支护示 ...','C','其他','生产技术科','宋志令','10','已五定',''),(151,'2018-01-08 08:55:12','捌点班','梁秀前、李东兴、辛光明、景建立、丁超','乡煤管站','3113综采工作面','3113综采工作面20# ...','C','采煤','综采队','宋志令','10','已五定',''),(152,'2018-01-08 09:22:12','捌点班','梁秀前、李东兴、辛光明、景建立、丁超','乡煤管站','3113综采工作面','3113综采工作面进风端头切顶柱里侧应增设护网','C','采煤','综采队','宋志令','10','已五定',''),(153,'2018-01-08 09:48:12','捌点班','梁秀前、李东兴、辛光明、景建立、丁超','乡煤管站','3113综采工作面','3113综采工作面30—40#支架段支架前探梁漏顶','C','采煤','综采队','宋志令','10','已五定',''),(154,'2018-01-08 10:32:29','捌点班','梁秀前、李东兴、辛光明、景建立、丁超','乡煤管站','3113综采工作面','3113综采工作面进风端 ...','C','采煤','综采队','宋志令','10','已五定',''),(155,'2018-01-15 13:14:35','捌点班','发现人1','省厅','地点1','隐患内容','B','采煤','地面运输队','王向卫','10','已复查','尊敬的上级领导：有妖气');

UNLOCK TABLES;

/*Table structure for table `delay` */

DROP TABLE IF EXISTS `delay`;

CREATE TABLE `delay` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sidingId` int(11) DEFAULT NULL,
  `delaySeq` int(11) DEFAULT NULL,
  `deleayReason` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `delayTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_7` (`sidingId`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`sidingId`) REFERENCES `sidingbiao` (`sidingId`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='ï¿½ï¿½ï¿½ï¿½Ã¿ï¿½ï¿½ï¿½Ä¶ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½';

/*Data for the table `delay` */

LOCK TABLES `delay` WRITE;

insert  into `delay`(`id`,`sidingId`,`delaySeq`,`deleayReason`,`delayTime`) values (74,68,0,NULL,'2017-12-03 09:37:05'),(75,69,0,NULL,'2017-12-03 09:41:38'),(76,70,0,NULL,'2017-12-03 07:43:41'),(77,71,0,NULL,'2017-12-10 09:49:24'),(78,72,0,NULL,'2017-12-10 07:51:23'),(79,73,0,NULL,'2017-12-10 08:53:12'),(80,74,0,NULL,'2018-12-10 08:55:36'),(81,75,0,NULL,'2017-12-10 08:57:17'),(82,76,0,NULL,'2017-12-10 09:00:50'),(83,77,0,NULL,'2017-12-18 07:45:23'),(84,78,0,NULL,'2017-12-17 08:47:43'),(85,79,0,NULL,'2017-12-17 08:16:14'),(86,80,0,NULL,'2017-12-17 08:54:56'),(87,81,0,NULL,'2017-12-17 07:56:15'),(88,82,0,NULL,'2017-12-17 08:05:32'),(89,83,0,NULL,'2017-12-24 08:38:06'),(90,84,0,NULL,'2017-12-24 08:39:15'),(91,85,0,NULL,'2018-01-07 10:00:31'),(92,86,0,NULL,'2018-01-07 06:02:28'),(93,87,0,NULL,'2018-01-07 08:03:20'),(94,88,0,NULL,'2018-01-07 07:04:08'),(95,89,0,NULL,'2018-01-07 04:04:55'),(96,90,0,NULL,'2018-01-07 07:22:41'),(97,91,0,NULL,'2018-01-07 08:08:55'),(98,92,0,NULL,'2018-01-07 06:10:05'),(99,93,0,NULL,'2018-01-07 04:10:47'),(100,94,0,NULL,'2018-01-09 08:09:30'),(101,95,0,NULL,'2018-01-09 08:11:11'),(102,96,0,NULL,'2018-01-10 07:12:09'),(103,97,0,NULL,'2018-01-09 04:12:51'),(104,98,0,NULL,'2018-01-13 08:13:38'),(105,99,0,NULL,'2018-01-14 13:16:22');

UNLOCK TABLES;

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

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

LOCK TABLES `department` WRITE;

insert  into `department`(`departmentId`,`upDepartmentId`,`name`,`manager`,`phone`) values ('10',NULL,'隐患排查小组','原志鹏','13934302138'),('100','10','监控室','李强','18636556010'),('1000','10','掘一队','王文山','13935554141'),('1100','10','掘二队','郭全伟','15603457693'),('1200','10','地面运输队','王向卫','13593291062'),('1300','10','供变电组','王新山','18535519821'),('1400','10','水暖电组','王俊兵','18534111018'),('1500','10','机电队','宋其林','13563656352'),('200','10','调度室','郭书红','13152951222'),('300','10','安全科','王海英','13994638087'),('400','10','生产技术科','郜国权','13835554648'),('500','10','通风科','张伟炳','13453548565'),('600','10','机电科','程林忠','13097665238'),('700','10','综采队','宋志令','13008070701'),('800','10','井下运输队','王文芳','15934051021'),('900','10','搬运队','焦保珍','15635552942');

UNLOCK TABLES;

/*Table structure for table `dictionary` */

DROP TABLE IF EXISTS `dictionary`;

CREATE TABLE `dictionary` (
  `dictionaryId` varchar(40) NOT NULL,
  `name` varchar(40) DEFAULT NULL,
  `upDictionaryId` varchar(40) DEFAULT NULL,
  `isUse` bit(1) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`dictionaryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='?Öµ??';

/*Data for the table `dictionary` */

LOCK TABLES `dictionary` WRITE;

insert  into `dictionary`(`dictionaryId`,`name`,`upDictionaryId`,`isUse`,`description`) values ('10','隐患系统字典',NULL,'','隐患系统字典'),('10001','检查单位','10','','1'),('10001004','市煤炭局','10001','','市煤炭局描述'),('10001005','县煤炭局','10001','','县煤炭局字典描述'),('10001006','省厅','10001','','省厅'),('10001007','安全科','10001','','安全科'),('10001008','矿级领导','10001','\0','矿级领导'),('10001009','科队长','10001','\0','科队长'),('10001010','国家煤监局长治分局','10001','','国家煤监局长治分局'),('10001011','乡煤管站','10001','','乡煤管站'),('10101','隐患类型','10','','隐患类型描述'),('10101001','采煤','10101','',''),('10101002','开掘','10101','\0',''),('10101003','机电','10101','\0',''),('10101004','运输','10101','\0',''),('10101005','通风','10101','\0',''),('10101006','地测','10101','\0',''),('10101007','其他','10101','\0',''),('10201','隐患状态','10','\0','隐患状态描述'),('10201001','未五定','10201','\0','d'),('10201002','已五定','10201','','d'),('10201003','已整改','10201','\0','s'),('10201004','已复查','10201','\0','d'),('10201005','已现场处理','10201','\0','sd'),('10301','班次','10','','班次描述'),('10301004','零点班','10301','\0','零点班'),('10301005','捌点班','10301','\0','捌点班'),('10301006','肆点班','10301','\0','肆点班'),('10401','风险等级','10','','这是风险等级'),('10401001','极其危险,不能继续作业','10401','\0','s'),('10401002','一般危险,需要注意','10401','\0','a'),('10401003','高度危险,需立即整改','10401','\0','aa'),('10401004','稍有危险,可以接受','10401','\0','c'),('10401005','显著危险,需要整改','10401','','d'),('10501','风险辨识范围类型','10','\0','这是风险辨识范围类型'),('10501001','综采','10501','\0','这是综采'),('10501002','综掘','10501','\0','这是综掘'),('10601','风险类型','10','\0','这是风险类型'),('10601001','人','10601','\0','r'),('10601002','机','10601','\0','的'),('10601003','环','10601','','h'),('10601004','管','10601','\0','d'),('10701','灾害类型','10','\0','这是灾害类型'),('10701001','水','10701','\0','s'),('10701002','火','10701','\0','h'),('10701003','瓦斯','10701','\0','ws'),('10701004','顶板','10701','\0','db'),('10701005','煤尘','10701','\0','mc'),('10701006','冲击地压','10701','\0','cjdy'),('10701007','提升运输','10701','\0','tsys'),('10801','可能导致事故','10','\0','这是可能导致事故'),('10801001','人身伤害','10801','\0','rssh'),('10801002','触电','10801','','sd'),('10801003','爆炸','10801','\0','d'),('10901','可能性(L)','10','','史蒂芬'),('10901001','完全可以预料','10901','','10'),('10901002','相当可能','10901','\0','6'),('10901003','可能，但不经常','10901','\0','3'),('10901004','可能性小，完全意外','10901','\0','1'),('10901005','很不可能，可以设想','10901','\0','0.5'),('10901006','既不可能','10901','\0','0.2'),('10901007','实际不可能','10901','\0','0.1'),('11001','人员暴露频繁程度(E)','10','','dsfsd'),('11001001','继续暴露','11001','\0','10'),('11001002','每天工作时间内暴露','11001','\0','6'),('11001003','每周一次，或偶然暴露','11001','\0','3'),('11001004','每月一次暴露','11001','\0','2'),('11001005','每年几次暴露','11001','\0','1'),('11001006','非常罕见的暴露','11001','\0','0.5'),('11101','损失后果(C)','10','','sd'),('11101001','大灾难，许多人死亡','11101','\0','100'),('11101002','灾难，数人死亡','11101','\0','40'),('11101003','非常严重，一人死亡','11101','\0','15'),('11101004','严重，重伤','11101','\0','7'),('11101005','重大，致残','11101','\0','3'),('11101006','引人关注，不利于基本的安全卫生要求','11101','\0','1');

UNLOCK TABLES;

/*Table structure for table `follow` */

DROP TABLE IF EXISTS `follow`;

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ù±ï¿½';

/*Data for the table `follow` */

LOCK TABLES `follow` WRITE;

insert  into `follow`(`followId`,`sidingId`,`dangerId`,`hasSecurity`,`safetyTechnician`,`managerName`,`recheckTime`) values (1,74,117,'1','现场安全员','现场领导','2018-01-15 13:17:17'),(2,99,155,'1','现场安全员','现场领导','2018-01-15 13:19:23');

UNLOCK TABLES;

/*Table structure for table `rechecktable` */

DROP TABLE IF EXISTS `rechecktable`;

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `rechecktable` */

LOCK TABLES `rechecktable` WRITE;

insert  into `rechecktable`(`recheckid`,`followId`,`dangerId`,`recheckMan`,`recheckdate`,`recheckresult`,`comment`) values (1,2,155,'复查人','2018-01-15 13:19:37','0','备注');

UNLOCK TABLES;

/*Table structure for table `riassessment` */

DROP TABLE IF EXISTS `riassessment`;

CREATE TABLE `riassessment` (
  `assessmentId` varchar(50) NOT NULL,
  `riskMsgId` varchar(50) DEFAULT NULL,
  `possibility` varchar(50) DEFAULT NULL,
  `personDegreeOfExposure` varchar(50) DEFAULT NULL,
  `lossOfCconsequences` varchar(50) DEFAULT NULL,
  `riskValue` double DEFAULT NULL,
  `riskGrade` varchar(20) DEFAULT NULL,
  `evaluateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`assessmentId`),
  KEY `FK_Reference_12` (`riskMsgId`),
  CONSTRAINT `FK_Reference_12` FOREIGN KEY (`riskMsgId`) REFERENCES `riidentificationrriskmsg` (`riskMsgId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='?????';

/*Data for the table `riassessment` */

LOCK TABLES `riassessment` WRITE;

insert  into `riassessment`(`assessmentId`,`riskMsgId`,`possibility`,`personDegreeOfExposure`,`lossOfCconsequences`,`riskValue`,`riskGrade`,`evaluateTime`) values ('0bfe9ea890694c199a2ec56e2485d376','1564c6c847aa4af496ada1e68f10b7c2','很有可能','正常','轻微',12,'四级','2018-03-16 15:40:13'),('1206ac5c6b1644ab8e3ef7f95c041e60','7d77f099dc864a19b60359e711e62781','既不可能','每天工作时间内暴露','非常严重，一人死亡',18.000000000000004,'稍有危险,可以接受','2018-03-20 22:38:52'),('303696d97a4c4f5d946c032655557800','b2d2581ea5434fc0b80aa945b769ce80','可能性小，完全意外','每月一次暴露','非常严重，一人死亡',30,'一般危险,需要注意','2018-03-21 18:01:05'),('6cddb780be9c4a17a97477fd873c41f0','53f7e58842d54309a102dc1ff91ff7df','完全可以预料','每周一次，或偶然暴露','重大，致残',90,'显著危险,需要整改','2018-03-20 19:51:02'),('7870c7f47a2b46199929d3a1ff074526','b6d016cde08f4068a4010a4fb05c6c40','完全可以预料','每天工作时间内暴露','灾难，数人死亡',2400,'极其危险,不能继续作业','2018-03-20 11:50:51'),('86afbfd5df904b429a816079971b6ca7','a8bae022d4ac499f9bdf0222642a9000','完全可以预料','继续暴露','大灾难，许多人死亡',10000,'极其危险,不能继续作业','2018-03-21 18:00:24'),('a0c00489f575497085f1da58a132a4ad','83eb71d692244037840ad994bd5d92b9','完全可以预料','每天工作时间内暴露','重大，致残',180,'高度危险,需立即整改','2018-03-21 09:50:07'),('e16f2ab62e2d4dbfb79387876bee5b6b','aa6f141f1d5c4f33a6e069d334f9246e','实际不可能','非常罕见的暴露','引人关注，不利于基本的安全卫生要求',0.05,'稍有危险,可以接受','2018-03-21 18:00:44');

UNLOCK TABLES;

/*Table structure for table `ricontrolplan` */

DROP TABLE IF EXISTS `ricontrolplan`;

CREATE TABLE `ricontrolplan` (
  `riCtrlPlanId` varchar(50) NOT NULL,
  `year` char(4) DEFAULT NULL,
  `monthOrWeek` varchar(10) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `specialty` varchar(100) DEFAULT NULL,
  `leader` varchar(20) DEFAULT NULL,
  `riskCtrlPlanMark` varchar(2) DEFAULT NULL,
  `reportStatus` varchar(2) DEFAULT NULL,
  `checkStatus` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`riCtrlPlanId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�������';

/*Data for the table `ricontrolplan` */

LOCK TABLES `ricontrolplan` WRITE;

UNLOCK TABLES;

/*Table structure for table `ridetailedofriskctrlplan` */

DROP TABLE IF EXISTS `ridetailedofriskctrlplan`;

CREATE TABLE `ridetailedofriskctrlplan` (
  `detailedOfRiskCtrlPlanId` varchar(50) NOT NULL,
  `riCtrlPlanId` varchar(50) DEFAULT NULL,
  `riskMsgId` varchar(50) DEFAULT NULL,
  `dutyDepartment` varchar(20) DEFAULT NULL,
  `implementationOfMeasures` varchar(200) DEFAULT NULL,
  `measureIsValid` varchar(20) DEFAULT NULL,
  `inspectionSituation` varchar(20) DEFAULT NULL,
  `analysisTime` datetime DEFAULT NULL,
  PRIMARY KEY (`detailedOfRiskCtrlPlanId`),
  KEY `FK_Reference_15` (`riCtrlPlanId`),
  KEY `FK_Reference_16` (`riskMsgId`),
  CONSTRAINT `FK_Reference_15` FOREIGN KEY (`riCtrlPlanId`) REFERENCES `ricontrolplan` (`riCtrlPlanId`),
  CONSTRAINT `FK_Reference_16` FOREIGN KEY (`riskMsgId`) REFERENCES `riidentificationrriskmsg` (`riskMsgId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='���������';

/*Data for the table `ridetailedofriskctrlplan` */

LOCK TABLES `ridetailedofriskctrlplan` WRITE;

UNLOCK TABLES;

/*Table structure for table `riidentificationmaintable` */

DROP TABLE IF EXISTS `riidentificationmaintable`;

CREATE TABLE `riidentificationmaintable` (
  `identiryId` varchar(50) NOT NULL,
  `year` datetime DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  `meetingAddress` varchar(100) DEFAULT NULL,
  `compere` varchar(50) DEFAULT NULL,
  `recorder` varchar(50) DEFAULT NULL,
  `participants` varchar(100) DEFAULT NULL,
  `meetingContent` varchar(500) DEFAULT NULL,
  `identifyMark` varchar(2) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`identiryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='������';

/*Data for the table `riidentificationmaintable` */

LOCK TABLES `riidentificationmaintable` WRITE;

insert  into `riidentificationmaintable`(`identiryId`,`year`,`name`,`meetingAddress`,`compere`,`recorder`,`participants`,`meetingContent`,`identifyMark`,`createTime`) values ('0246a2f173f243408b9c5fc30bd60752','2013-01-01 00:00:00','专项辨识风险','S地点','S主持人','S记录人','S参会人员','S会议内容','S','2018-03-19 11:31:15'),('1f7855adf830480fa29651e48c4dec7a','1999-01-01 00:00:00','年度辨识','e','e','ew','we','we','Y','2018-03-12 20:25:55'),('2db860befb3d489082049e5316e9752d','2011-01-01 00:00:00','年度辨识','f2011','张飞','刘备','关羽','操场','Y','2018-03-12 20:47:03'),('314f0cc58008407e8c026f8bd515acde','2014-01-01 00:00:00','年度辨识','f','f','f','f','f','Y','2018-03-12 20:46:53'),('4db947fba1a546ebaecff2ac5d1116ea','2018-03-12 19:53:15','年度辨识','sdf地点','sdf主持人','sdf记录人','sdf参会人员','sdf会议内容','Y','2018-03-12 19:53:15'),('9a08b9776fe84948b41b040201c16c4b','1999-01-01 00:00:00','专项辨识风险','asdfasd','asdfasd','asdfasdf','asdfsadf','asdfasd','S','2018-03-19 11:31:48'),('9ec058bcdb73422eb81aa03be7541afe','2017-01-01 00:00:00','年度辨识','s','s','s','s','s','Y','2018-03-12 19:51:13'),('ade2093170564d8c919b01b923eb6cdc','2005-01-01 00:00:00','2016年年度专项辨识','会议地址','主持人','记录人','参会人员','会议内容','Y','2018-03-12 18:40:58'),('e131fe79df654c348ad9d5ebd42a7fe2','2012-01-01 00:00:00','年度辨识风险','sdfN主持人','sdfN','N记录人新','N参会人员 王跃跃','会议内容','Y','2018-03-19 10:52:16'),('f52a75c928c24cf693db6589003230fa','2013-01-01 00:00:00','年度辨识','ds','sd','sd','sd','sd','Y','2018-03-12 20:58:48');

UNLOCK TABLES;

/*Table structure for table `riidentificationrange` */

DROP TABLE IF EXISTS `riidentificationrange`;

CREATE TABLE `riidentificationrange` (
  `idenRanId` varchar(50) NOT NULL,
  `faceName` varchar(20) DEFAULT NULL,
  `survey` varchar(100) DEFAULT NULL,
  `rIRType` varchar(20) DEFAULT NULL,
  `startTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  PRIMARY KEY (`idenRanId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�������';

/*Data for the table `riidentificationrange` */

LOCK TABLES `riidentificationrange` WRITE;

insert  into `riidentificationrange`(`idenRanId`,`faceName`,`survey`,`rIRType`,`startTime`,`endTime`) values ('03aa85154aae4ee79887a8c8d628611b','s工作面','d概况','综掘','2018-03-08 00:00:00','2018-03-20 00:00:00'),('10378eccbd9841f9b658d9e93435f7a4','511工作面','511概况','综掘','2018-03-01 00:00:00','2018-03-12 00:00:00'),('15c5d925abbf4152bb3c9b5c681066fb','sdf1','sdf1','综掘','2018-04-06 00:00:00','2018-04-07 00:00:00'),('1c4c4eef70be4fc1bf4dd37d94b2a6ab','2','2','综掘','2018-03-11 00:00:00','2018-03-12 00:00:00'),('2312daffcb2d43928199d2a7f6155215','1234','1234','综采','2018-03-03 00:00:00','2018-03-04 00:00:00'),('256288c93693443bb105e7dfd3989776','工作面9','概况9','综掘','2018-03-07 00:00:00','2018-03-30 00:00:00'),('556ee98af74842c79012bb8d07f8ad8a','ds工作面','fgh概况','综采','2018-03-14 00:00:00','2018-03-23 00:00:00'),('561534639b8a44a9a6ea629f9b860947','1234工作面qw','概况1234qw','综掘','2018-03-02 00:00:00','2018-03-03 00:00:00'),('6148c38496f84a6097c95f46ec1d431f','waer','er','综采','2018-02-28 00:00:00','2018-03-08 00:00:00'),('707c2e45a3094ff3b5019dfd3195b883','5','5','综掘','2018-03-09 00:00:00','2018-03-16 00:00:00'),('7534ae86c97740e98c17cf488a91a94b','士大夫','发大水','综掘','2018-03-14 00:00:00','2018-03-14 00:00:00'),('830f522c77314ddb8f8b5a0f5647755f','工作面10','概况10','综采','2018-03-08 00:00:00','2018-03-09 00:00:00'),('9036bb800baf4d1182c3ba5998a7b8a0','工作面1','概况1','综采','2018-03-06 00:00:00','2018-03-12 00:00:00'),('a2d09b7a34a14c41b8a741c76b5ee220','er','sdf','综采','2018-03-12 00:00:00','2018-03-22 00:00:00'),('a385d0fd315c4ee492fda5660d9ab7cb','7','7','综掘','2018-03-06 00:00:00','2018-03-23 00:00:00'),('a5a6a50e237d47f88851f3354737819f','sfd','asdf','综采','2018-03-01 00:00:00','2018-03-09 00:00:00'),('db8014e098d54073bcf8f1fa70edc1c0','dsaf工作面','asdf','综采','2018-03-01 00:00:00','2018-03-02 00:00:00'),('e6c1017eb6744d8d872ee2eb6c8b7d5b','aaaazzz','aaaazzz','综采','2018-03-02 00:00:00','2018-03-09 00:00:00'),('fc4406ca839047c2b3ceb0c5251d3fd3','名称工作面','asdf','综采','2018-02-02 00:00:00','2018-02-23 00:00:00');

UNLOCK TABLES;

/*Table structure for table `riidentificationrriskmsg` */

DROP TABLE IF EXISTS `riidentificationrriskmsg`;

CREATE TABLE `riidentificationrriskmsg` (
  `riskMsgId` varchar(50) NOT NULL,
  `identiryId` varchar(50) DEFAULT NULL,
  `riskAddress` varchar(200) DEFAULT NULL,
  `riskDescribe` varchar(500) DEFAULT NULL,
  `riskType` varchar(20) DEFAULT NULL,
  `professionalTypes` varchar(20) DEFAULT NULL,
  `disasterTypes` varchar(20) DEFAULT NULL,
  `canCauseAccidents` varchar(100) DEFAULT NULL,
  `ctrlMeasure` varchar(500) DEFAULT NULL,
  `principal` varchar(20) DEFAULT NULL,
  `superintendent` varchar(20) DEFAULT NULL,
  `monitoringPeriod` varchar(50) DEFAULT NULL,
  `evaluationStatus` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`riskMsgId`),
  KEY `FK_Reference_11` (`identiryId`),
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`identiryId`) REFERENCES `riidentificationmaintable` (`identiryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�������';

/*Data for the table `riidentificationrriskmsg` */

LOCK TABLES `riidentificationrriskmsg` WRITE;

insert  into `riidentificationrriskmsg`(`riskMsgId`,`identiryId`,`riskAddress`,`riskDescribe`,`riskType`,`professionalTypes`,`disasterTypes`,`canCauseAccidents`,`ctrlMeasure`,`principal`,`superintendent`,`monitoringPeriod`,`evaluationStatus`) values ('1564c6c847aa4af496ada1e68f10b7c2','4db947fba1a546ebaecff2ac5d1116ea','1234工作面qw,waer','豆腐干','管','运输','冲击地压','触电','地方该','豆腐干','豆腐干','地方g','Y'),('53f7e58842d54309a102dc1ff91ff7df','9a08b9776fe84948b41b040201c16c4b','511工作面,1234工作面qw','sadf','机','运输','煤尘','人身伤害','sadfasd','sadsdf','sadsdfa','sdasdf','Y'),('7d77f099dc864a19b60359e711e62781','4db947fba1a546ebaecff2ac5d1116ea','1234工作面qw,2','史蒂芬','环','机电','顶板','爆炸','史蒂芬','史蒂芬','史蒂芬','史蒂芬','Y'),('83eb71d692244037840ad994bd5d92b9','4db947fba1a546ebaecff2ac5d1116ea','1234工作面qw','豆腐干','机','机电','顶板','爆炸','豆腐干','豆腐干','豆腐干','一天一次','Y'),('a8bae022d4ac499f9bdf0222642a9000','4db947fba1a546ebaecff2ac5d1116ea','1234工作面qw','豆腐干','管','运输','顶板','爆炸','豆腐干分该','豆腐干','大染缸热','豆腐干','Y'),('aa6f141f1d5c4f33a6e069d334f9246e','4db947fba1a546ebaecff2ac5d1116ea','1234工作面qw,511工作面','轻微','环','机电','顶板','爆炸','三范式','豆腐干','豆腐干','豆腐干','Y'),('b2d2581ea5434fc0b80aa945b769ce80','4db947fba1a546ebaecff2ac5d1116ea','综掘,综采','描述','环','采煤','火','人身伤害','管控措施1','负责人211','监管人','一年一次','Y'),('b6d016cde08f4068a4010a4fb05c6c40','4db947fba1a546ebaecff2ac5d1116ea','1234工作面qw,sdf1','阿三地方','环','开掘','顶板','爆炸','史蒂芬史蒂芬','史蒂芬史蒂芬','史蒂芬史蒂芬','史蒂芬史蒂芬','Y'),('b8a97921244e4783988f0154fad749c1','4db947fba1a546ebaecff2ac5d1116ea','工作面10,waer','豆腐干','机','采煤','火','触电','撒地方','史蒂芬','豆腐干','一周一次','N'),('c62a9c3c20e74a26885ff49307bb162c','4db947fba1a546ebaecff2ac5d1116ea','511工作面,sdf1','轻微','人','开掘','瓦斯','爆炸','士大夫大师傅','史蒂芬','史蒂芬','史蒂芬11111111111111111','N'),('d57a9e01a3ed4fd690926da53b4abe16','4db947fba1a546ebaecff2ac5d1116ea','1234工作面qw','豆腐干','环','运输','瓦斯','触电','豆腐干','豆腐干','豆腐干','风格和电话','N'),('d7981358af0345f9b3523acb82c75dd0','4db947fba1a546ebaecff2ac5d1116ea','1234工作面qw','豆腐干风格','环','机电','煤尘','触电','豆腐干f\'g','豆腐干','豆腐干而','通过','N'),('d801b25ea8eb44f79c09732a6a8ab96a','4db947fba1a546ebaecff2ac5d1116ea','工作面9','豆腐干','环','机电','水','爆炸','豆腐干','豆腐干','豆腐干','豆腐干1','N'),('e4141f7995054386a27a7f6f30e79a2f','4db947fba1a546ebaecff2ac5d1116ea','1234工作面qw,2','豆腐干','环','通风','顶板','爆炸','豆腐干','豆腐干','豆腐干','豆腐干','N');

UNLOCK TABLES;

/*Table structure for table `riresponsibility` */

DROP TABLE IF EXISTS `riresponsibility`;

CREATE TABLE `riresponsibility` (
  `respId` varchar(50) NOT NULL,
  `quarters` varchar(20) DEFAULT NULL,
  `duty` varchar(40) DEFAULT NULL,
  `ctrlContent` varchar(200) DEFAULT NULL,
  `ctrlFrequency` varchar(20) DEFAULT NULL,
  `analysisFrequency` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`respId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�������';

/*Data for the table `riresponsibility` */

LOCK TABLES `riresponsibility` WRITE;

insert  into `riresponsibility`(`respId`,`quarters`,`duty`,`ctrlContent`,`ctrlFrequency`,`analysisFrequency`) values ('04e4063210704f20b176a3f2c83b91cb','d','d','d','d','d'),('128a8102f24045ac94e17f6dd1439fd0','dfg','dfg','dfg','dfg','dfg'),('15066b2933334947ba7f2deab59125e5','dsf','sdf','sdf','sdf','sdf'),('26233549eee840b88be5773a7f733140','e','e','e','e','e'),('4fdd28b5911f4b928ce5faee44afca56','f22','f22','f22','f22','f22'),('60cf2ead51be4af2870865ff9c898a12','岗位1','职责1','管控内容1','一周一次','一周一次'),('62227e4071d3407890190a1e2ca38c33','运输货物1','开车1','把货送到1','一周一次1','分析频率1'),('a40e0ddc0c5b4da8a88456977a8057b2','t岗位1','t职责1','t管控内容1','t管控频率1','t风险分析频率1'),('a6cfe4f75f514bb2b2e039a4750502d5','4','4','4','4','4'),('a778a6833f9c4f65b48c0e52ca169fd2','w','w','w','w','w'),('ba381c794b9244ba9af259c874987de2','qwer','sdrf','sdf','sdf','sdf'),('c328890276c0476c8dbc2d3fba187443','fg11','f11','f11','f11','f11'),('cc17c33295dc42a295ce019ac9646480','sdf1','sdf1','sdf1','ddd1','dsf1');

UNLOCK TABLES;

/*Table structure for table `ririskplanaudit` */

DROP TABLE IF EXISTS `ririskplanaudit`;

CREATE TABLE `ririskplanaudit` (
  `riskPlanAuditId` varchar(50) NOT NULL,
  `riCtrlPlanId` varchar(50) DEFAULT NULL,
  `auditMsg` varchar(200) DEFAULT NULL,
  `auditStatus` varchar(20) DEFAULT NULL,
  `auditTime` datetime DEFAULT NULL,
  `auditPerson` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`riskPlanAuditId`),
  KEY `FK_Reference_14` (`riCtrlPlanId`),
  CONSTRAINT `FK_Reference_14` FOREIGN KEY (`riCtrlPlanId`) REFERENCES `ricontrolplan` (`riCtrlPlanId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�������';

/*Data for the table `ririskplanaudit` */

LOCK TABLES `ririskplanaudit` WRITE;

UNLOCK TABLES;

/*Table structure for table `sidingbiao` */

DROP TABLE IF EXISTS `sidingbiao`;

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
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `sidingbiao` */

LOCK TABLES `sidingbiao` WRITE;

insert  into `sidingbiao`(`sidingId`,`dangerId`,`sidingTime`,`supervisor`,`rectificationTime`,`rectificationMeasure`,`dutyPerson`) values (68,109,'2017-12-04 09:20:05','李旭亮','2017-12-03 09:37:05','已整改','王苗红'),(69,106,'2017-12-04 09:02:38','李旭亮','2017-12-03 09:41:38','钢梁按照规范已从新打设。','王苗红'),(70,111,'2017-12-03 17:43:41','原小龙','2017-12-03 07:43:41','搬运队已把废旧材料回收。','焦保珍'),(71,120,'2017-12-01 17:49:24','王义彪','2017-12-10 09:49:24','井下运输队安排人员更换了静压水管','王文芳'),(72,119,'2017-12-10 18:51:23','冯旭亮','2017-12-10 07:51:23','机电队从新整理了3113泵站前后10米范围内的电缆','宋其林'),(73,118,'2017-12-10 20:53:12','冯旭亮','2017-12-10 08:53:12','机电更换了新的接电线','宋其林'),(74,117,'2017-12-10 17:55:36','原小龙','2018-12-10 08:55:36','搬运队及时对废旧材料和刮板进行了回收','焦保珍'),(75,116,'2017-12-10 18:11:17','原小龙','2017-12-10 08:57:17','搬运队安排人员对避难硐室门口垃圾已清理','焦保珍'),(76,121,'2017-12-10 17:58:50','王义彪','2017-12-10 09:00:50','井下运输队安排人员已清理积煤','王文芳'),(77,131,'2017-12-18 15:45:23','原小龙','2017-12-18 07:45:23','搬运队已把废旧材料回收升井','焦保珍'),(78,128,'2017-12-17 17:03:43','王义彪','2017-12-17 08:47:43','已更换2个托辊','王文芳'),(79,129,'2017-12-17 16:49:14','王义彪','2017-12-17 08:16:14','已清理积煤，安排每班清理','王文芳'),(80,132,'2017-12-17 17:02:56','原小龙','2017-12-17 08:54:56','已补充填写','焦保珍'),(81,125,'2017-12-17 17:00:15','王苗红','2017-12-17 07:56:15','已调整','宋志令'),(82,130,'2017-12-17 16:58:32','原小龙','2017-12-17 08:05:32','已整改','焦保珍'),(83,140,'2017-12-24 16:38:06','王苗红','2017-12-24 08:38:06','已重新打设','宋志令'),(84,133,'2017-12-01 20:39:15','冯旭亮','2017-12-24 08:39:15','已整改','宋其林'),(85,149,'2018-01-08 08:00:31','王文芳','2018-01-07 10:00:31','已处理','王义彪'),(86,148,'2018-01-08 08:02:28','焦保珍','2018-01-07 06:02:28','已补充填写，已整改','原小龙'),(87,147,'2018-01-08 08:03:20','焦保珍','2018-01-07 08:03:20','已更换','原小龙'),(88,146,'2018-01-08 08:12:08','焦保珍','2018-01-07 07:04:08','已整改','原小龙'),(89,145,'2018-01-13 08:19:55','焦保珍','2018-01-07 04:04:55','已清理','原小龙'),(90,144,'2018-01-08 08:29:41','宋志令','2018-01-07 07:22:41','已补充全，已增加','崔志兵'),(91,143,'2018-01-08 09:08:55','宋志令','2018-01-07 08:08:55','已加强固定，已调整方向，已更换','崔志兵'),(92,142,'2018-01-08 10:10:05','宋志令','2018-01-07 06:10:05','已更换','崔志兵'),(93,141,'2018-01-13 10:20:47','宋志令','2018-01-07 04:10:47','以固定，已清理完矸石积煤','崔志兵'),(94,150,'2018-01-13 18:01:48','李红权','2018-01-13 07:09:30','已根据工作面实际情况从新补充画图','程晓红'),(95,154,'2018-01-09 18:11:11','李红权','2018-01-09 08:11:11','综采队已接通喷雾装置水管','韩树明'),(96,153,'2018-01-14 10:12:09','李红权','2018-01-10 07:12:09','已增设护网','孟福贵'),(97,152,'2018-01-14 08:12:51','陈金星','2018-01-09 04:12:51','已加强维护','孟福贵'),(98,151,'2018-01-13 18:01:38','陈金星','2018-01-13 08:13:38','已整改','孟福贵'),(99,155,'2018-01-15 13:16:39','督办人','2018-01-14 13:16:22','整改措施','责任人');

UNLOCK TABLES;

/*Table structure for table `spotdispose` */

DROP TABLE IF EXISTS `spotdispose`;

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
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `spotdispose` */

LOCK TABLES `spotdispose` WRITE;

insert  into `spotdispose`(`disposeId`,`dangerId`,`hasSafeMeasure`,`disposeMeasure`,`disposeDate`,`disposePerson`) values (35,90,'1','地面运输队已组织人员对副立井井筒结冰及时进行清除','2017-12-11 08:46:50','王向卫'),(36,91,'1','井下运输队已对副立井井底平台与罐笼间隙及时进行了维修并加固','2018-01-11 09:06:24','王文芳'),(37,94,'1','综采队已对3113综采工作面破碎顶板及时挂网并架单体柱支护，并加强了现场顶帮管理。','2017-12-11 09:17:12','王迅科'),(38,93,'1','机电队已按规定对3113回风顺槽一台QBZ80开关上风侧安装了甲烷断电仪。','2017-12-11 09:19:35','宋其林'),(39,92,'1','综采队已对3113综采工作面初撑力不达24Mp的支架及时进行了调整，出现损坏压力表及时进行了更换，','2017-12-11 09:21:19','王迅科'),(41,99,'1','通风科已对3113综采工作面上隅角瓦斯传感器及时进行更换，经检测对比，传感器显示值误差在规定显示内。','2017-12-14 15:44:46','李强'),(42,101,'1','综采队已对3113综采工作面进风顺槽超前支护单体柱重新进行了编号。','2017-12-18 09:50:34','宋志令'),(43,98,'1','综采队已对3113综采队工作面回风顺槽超前支护外一处折断的钢梁棚腿及时进行了更换。','2017-12-16 09:52:14','宋志令'),(44,97,'1','机电队已对副立井井底信号硐室及时增设照明装置。','2017-12-15 09:54:58','宋其林'),(45,96,'1','综采队已对3113综采工作面28#支架按《作业规程》要求重新打折戗柱，同时做好了防倒措施。','2017-12-15 10:02:11','宋其林'),(46,95,'1','综采队已对3113综采工作面29—40#支架漏矸处进行了挂网，上木头维护，并增强了支护，严格控制漏矸。','2017-12-15 10:04:07','宋志令'),(47,104,'1','通风科已对西皮带运输巷15#密闭及时挂设管理牌板，设置了栅栏。','2017-12-21 10:39:20','郜天发'),(48,103,'1','监控室维护工已及时安装语音报警装置，搬运队已对风门内存放的风筒布等杂物及时进行了清理。','2017-12-24 10:42:25','郜天发'),(49,102,'1','综采队已及时清理架间浮煤，对煤质松软，活矸落煤处进行了挂网打超前支护处理，并加强每班维护，防止活矸伤人。','2017-12-21 10:43:40','宋志令'),(50,105,'1','综采队已对3113综采工作面煤溜机头搭接短进行了整改。','2017-12-03 10:50:55','王苗红'),(51,108,'1','综采队已把3根漏液柱更换完成','2017-12-02 14:52:46','王苗红'),(52,112,'1','搬运队已安排人员处理完毕','2017-12-03 12:55:23','焦保珍'),(53,107,'1','综采队已安排人员加强维护','2017-12-02 13:22:45','王苗红'),(54,110,'1','综采队已清理完积煤，更换了托辊。','2017-12-02 09:39:58','王文芳'),(55,113,'1','综采队已安排人员现场进行了整改','2017-12-09 14:16:36','王苗红'),(56,114,'1','综采队已经更换新液管','2017-12-09 15:17:34','王苗红'),(57,122,'1','井下运输队已及时清理积煤','2017-12-09 16:21:21','王文芳'),(58,115,'1','综采队已清理卫生材料，已对煤尘大的区域洒水降尘。','2017-12-09 14:47:47','王苗红'),(59,123,'1','综采队已及时回撤','2017-12-16 15:26:52','宋志令'),(60,124,'1','综采队人员已清理完架间浮煤','2017-12-16 17:28:11','宋志令'),(61,126,'1','已更换漏液柱','2017-12-16 15:41:31','宋志令'),(62,127,'1','已及时更换','2017-12-16 17:43:13','宋其林'),(63,137,'1','当班已清理','2017-12-23 13:24:45','王文芳'),(64,134,'1','已每班加强管理','2017-12-23 16:28:11','宋志令'),(65,135,'1','已及时更换','2017-12-23 16:30:00','宋志令'),(66,139,'1','已回收','2017-12-23 18:33:49','宋其林'),(67,138,'1','已整改','2017-12-23 12:35:24','焦保珍'),(68,136,'1','已处理','2017-12-23 18:35:54','王文芳');

UNLOCK TABLES;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `role` int(11) DEFAULT NULL COMMENT 'ï¿½ï¿½1ï¿½ï¿½2ï¿½ï¿½3.ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Í¬ï¿½ï¿½È¨ï¿½Þ£ï¿½ï¿½ï¿½Ê¾ï¿½ï¿½Í¬ï¿½Ä²Ëµï¿½',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `user` */

LOCK TABLES `user` WRITE;

UNLOCK TABLES;

/*Table structure for table `danger_siding` */

DROP TABLE IF EXISTS `danger_siding`;

/*!50001 DROP VIEW IF EXISTS `danger_siding` */;
/*!50001 DROP TABLE IF EXISTS `danger_siding` */;

/*!50001 CREATE TABLE  `danger_siding`(
 `dangerId` int(11) NOT NULL  default '0' ,
 `findtime` datetime NULL ,
 `classtype` varchar(40) NULL ,
 `findperson` varchar(40) NULL ,
 `checkunit` varchar(40) NULL ,
 `address` varchar(40) NULL ,
 `content` varchar(1000) NULL ,
 `dangerGrade` varchar(10) NULL ,
 `type` varchar(20) NULL ,
 `unit` varchar(40) NULL ,
 `manager` varchar(40) NULL ,
 `dangerStatusNum` varchar(2) NULL ,
 `dangerStatus` varchar(40) NULL ,
 `dangerReport` varchar(1000) NULL ,
 `sidingid` int(11) NOT NULL  default '0' ,
 `sidingTime` datetime NULL ,
 `supervisor` varchar(40) NULL ,
 `rectificationTime` datetime NULL ,
 `rectificationMeasure` varchar(600) NULL ,
 `dutyPerson` varchar(40) NULL 
)*/;

/*Table structure for table `danger_siding_follow` */

DROP TABLE IF EXISTS `danger_siding_follow`;

/*!50001 DROP VIEW IF EXISTS `danger_siding_follow` */;
/*!50001 DROP TABLE IF EXISTS `danger_siding_follow` */;

/*!50001 CREATE TABLE  `danger_siding_follow`(
 `dangerId` int(11) NOT NULL  default '0' ,
 `findtime` datetime NULL ,
 `classtype` varchar(40) NULL ,
 `findperson` varchar(40) NULL ,
 `checkunit` varchar(40) NULL ,
 `address` varchar(40) NULL ,
 `content` varchar(1000) NULL ,
 `dangerGrade` varchar(10) NULL ,
 `type` varchar(20) NULL ,
 `unit` varchar(40) NULL ,
 `manager` varchar(40) NULL ,
 `dangerStatusNum` varchar(2) NULL ,
 `dangerStatus` varchar(40) NULL ,
 `dangerReport` varchar(1000) NULL ,
 `sidingId` int(11) NOT NULL  default '0' ,
 `sidingTime` datetime NULL ,
 `supervisor` varchar(40) NULL ,
 `rectificationTime` datetime NULL ,
 `rectificationMeasure` varchar(600) NULL ,
 `dutyPerson` varchar(40) NULL ,
 `followId` int(11) NOT NULL  default '0' ,
 `hasSecurity` varchar(2) NULL ,
 `safetyTechnician` varchar(40) NULL ,
 `managerName` varchar(40) NULL ,
 `recheckTime` datetime NULL 
)*/;

/*Table structure for table `danger_siding_follow_recheck` */

DROP TABLE IF EXISTS `danger_siding_follow_recheck`;

/*!50001 DROP VIEW IF EXISTS `danger_siding_follow_recheck` */;
/*!50001 DROP TABLE IF EXISTS `danger_siding_follow_recheck` */;

/*!50001 CREATE TABLE  `danger_siding_follow_recheck`(
 `dangerId` int(11) NOT NULL  default '0' ,
 `findtime` datetime NULL ,
 `classtype` varchar(40) NULL ,
 `findperson` varchar(40) NULL ,
 `checkunit` varchar(40) NULL ,
 `address` varchar(40) NULL ,
 `content` varchar(1000) NULL ,
 `dangerGrade` varchar(10) NULL ,
 `type` varchar(20) NULL ,
 `unit` varchar(40) NULL ,
 `manager` varchar(40) NULL ,
 `dangerStatusNum` varchar(2) NULL ,
 `dangerStatus` varchar(40) NULL ,
 `dangerReport` varchar(1000) NULL ,
 `sidingId` int(11) NOT NULL  default '0' ,
 `sidingTime` datetime NULL ,
 `supervisor` varchar(40) NULL ,
 `rectificationTime` datetime NULL ,
 `rectificationMeasure` varchar(600) NULL ,
 `dutyPerson` varchar(40) NULL ,
 `followId` int(11) NOT NULL  default '0' ,
 `hasSecurity` varchar(2) NULL ,
 `safetyTechnician` varchar(40) NULL ,
 `managerName` varchar(40) NULL ,
 `recheckTime` datetime NULL ,
 `recheckid` int(11) NOT NULL  default '0' ,
 `recheckMan` varchar(40) NULL ,
 `recheckdate` datetime NULL ,
 `recheckresult` varchar(2) NULL ,
 `comment` varchar(200) NULL 
)*/;

/*Table structure for table `danger_spot` */

DROP TABLE IF EXISTS `danger_spot`;

/*!50001 DROP VIEW IF EXISTS `danger_spot` */;
/*!50001 DROP TABLE IF EXISTS `danger_spot` */;

/*!50001 CREATE TABLE  `danger_spot`(
 `dangerId` int(11) NOT NULL  default '0' ,
 `findtime` datetime NULL ,
 `classtype` varchar(40) NULL ,
 `findperson` varchar(40) NULL ,
 `checkunit` varchar(40) NULL ,
 `address` varchar(40) NULL ,
 `content` varchar(1000) NULL ,
 `dangerGrade` varchar(10) NULL ,
 `type` varchar(20) NULL ,
 `unit` varchar(40) NULL ,
 `manager` varchar(40) NULL ,
 `dangerStatusNum` varchar(2) NULL ,
 `dangerStatus` varchar(40) NULL ,
 `dangerReport` varchar(1000) NULL ,
 `hasSafeMeasure` varchar(2) NULL ,
 `disposeMeasure` varchar(500) NULL ,
 `disposeDate` datetime NULL ,
 `disposePerson` varchar(40) NULL 
)*/;

/*View structure for view danger_siding */

/*!50001 DROP TABLE IF EXISTS `danger_siding` */;
/*!50001 DROP VIEW IF EXISTS `danger_siding` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `danger_siding` AS select `d`.`dangerId` AS `dangerId`,`d`.`findTime` AS `findtime`,`d`.`classType` AS `classtype`,`d`.`findPerson` AS `findperson`,`d`.`checkUnit` AS `checkunit`,`d`.`address` AS `address`,`d`.`content` AS `content`,`d`.`dangerGrade` AS `dangerGrade`,`d`.`type` AS `type`,`d`.`unit` AS `unit`,`d`.`manager` AS `manager`,`d`.`dangerStatusNum` AS `dangerStatusNum`,`d`.`dangerStatus` AS `dangerStatus`,`d`.`dangerReport` AS `dangerReport`,`s`.`sidingId` AS `sidingid`,`s`.`sidingTime` AS `sidingTime`,`s`.`supervisor` AS `supervisor`,`s`.`rectificationTime` AS `rectificationTime`,`s`.`rectificationMeasure` AS `rectificationMeasure`,`s`.`dutyPerson` AS `dutyPerson` from (`danger` `d` join `sidingbiao` `s`) where (`d`.`dangerId` = `s`.`dangerId`) */;

/*View structure for view danger_siding_follow */

/*!50001 DROP TABLE IF EXISTS `danger_siding_follow` */;
/*!50001 DROP VIEW IF EXISTS `danger_siding_follow` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `danger_siding_follow` AS select `d`.`dangerId` AS `dangerId`,`d`.`findTime` AS `findtime`,`d`.`classType` AS `classtype`,`d`.`findPerson` AS `findperson`,`d`.`checkUnit` AS `checkunit`,`d`.`address` AS `address`,`d`.`content` AS `content`,`d`.`dangerGrade` AS `dangerGrade`,`d`.`type` AS `type`,`d`.`unit` AS `unit`,`d`.`manager` AS `manager`,`d`.`dangerStatusNum` AS `dangerStatusNum`,`d`.`dangerStatus` AS `dangerStatus`,`d`.`dangerReport` AS `dangerReport`,`s`.`sidingId` AS `sidingId`,`s`.`sidingTime` AS `sidingTime`,`s`.`supervisor` AS `supervisor`,`s`.`rectificationTime` AS `rectificationTime`,`s`.`rectificationMeasure` AS `rectificationMeasure`,`s`.`dutyPerson` AS `dutyPerson`,`f`.`followId` AS `followId`,`f`.`hasSecurity` AS `hasSecurity`,`f`.`safetyTechnician` AS `safetyTechnician`,`f`.`managerName` AS `managerName`,`f`.`recheckTime` AS `recheckTime` from ((`danger` `d` join `sidingbiao` `s`) join `follow` `f`) where ((`d`.`dangerId` = `s`.`dangerId`) and (`s`.`dangerId` = `f`.`dangerId`) and (`s`.`sidingId` = `f`.`sidingId`)) */;

/*View structure for view danger_siding_follow_recheck */

/*!50001 DROP TABLE IF EXISTS `danger_siding_follow_recheck` */;
/*!50001 DROP VIEW IF EXISTS `danger_siding_follow_recheck` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `danger_siding_follow_recheck` AS select `d`.`dangerId` AS `dangerId`,`d`.`findTime` AS `findtime`,`d`.`classType` AS `classtype`,`d`.`findPerson` AS `findperson`,`d`.`checkUnit` AS `checkunit`,`d`.`address` AS `address`,`d`.`content` AS `content`,`d`.`dangerGrade` AS `dangerGrade`,`d`.`type` AS `type`,`d`.`unit` AS `unit`,`d`.`manager` AS `manager`,`d`.`dangerStatusNum` AS `dangerStatusNum`,`d`.`dangerStatus` AS `dangerStatus`,`d`.`dangerReport` AS `dangerReport`,`s`.`sidingId` AS `sidingId`,`s`.`sidingTime` AS `sidingTime`,`s`.`supervisor` AS `supervisor`,`s`.`rectificationTime` AS `rectificationTime`,`s`.`rectificationMeasure` AS `rectificationMeasure`,`s`.`dutyPerson` AS `dutyPerson`,`f`.`followId` AS `followId`,`f`.`hasSecurity` AS `hasSecurity`,`f`.`safetyTechnician` AS `safetyTechnician`,`f`.`managerName` AS `managerName`,`f`.`recheckTime` AS `recheckTime`,`r`.`recheckid` AS `recheckid`,`r`.`recheckMan` AS `recheckMan`,`r`.`recheckdate` AS `recheckdate`,`r`.`recheckresult` AS `recheckresult`,`r`.`comment` AS `comment` from (((`danger` `d` join `sidingbiao` `s`) join `follow` `f`) join `rechecktable` `r`) where ((`d`.`dangerId` = `s`.`dangerId`) and (`s`.`dangerId` = `f`.`dangerId`) and (`s`.`sidingId` = `f`.`sidingId`) and (`r`.`followId` = `f`.`followId`)) */;

/*View structure for view danger_spot */

/*!50001 DROP TABLE IF EXISTS `danger_spot` */;
/*!50001 DROP VIEW IF EXISTS `danger_spot` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `danger_spot` AS select `d`.`dangerId` AS `dangerId`,`d`.`findTime` AS `findtime`,`d`.`classType` AS `classtype`,`d`.`findPerson` AS `findperson`,`d`.`checkUnit` AS `checkunit`,`d`.`address` AS `address`,`d`.`content` AS `content`,`d`.`dangerGrade` AS `dangerGrade`,`d`.`type` AS `type`,`d`.`unit` AS `unit`,`d`.`manager` AS `manager`,`d`.`dangerStatusNum` AS `dangerStatusNum`,`d`.`dangerStatus` AS `dangerStatus`,`d`.`dangerReport` AS `dangerReport`,`s`.`hasSafeMeasure` AS `hasSafeMeasure`,`s`.`disposeMeasure` AS `disposeMeasure`,`s`.`disposeDate` AS `disposeDate`,`s`.`disposePerson` AS `disposePerson` from (`danger` `d` join `spotdispose` `s`) where (`d`.`dangerId` = `s`.`dangerId`) */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
