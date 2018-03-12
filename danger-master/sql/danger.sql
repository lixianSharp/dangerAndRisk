/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/9/3 23:32:06                            */
/*==============================================================*/


drop table if exists danger;

drop table if exists delay;

drop table if exists department;

drop table if exists dictionary;

drop table if exists follow;

drop table if exists rechecktable;

drop table if exists sidingbiao;

drop table if exists spotDispose;

drop table if exists user;

/*==============================================================*/
/* Table: danger                                                */
/*==============================================================*/
create table danger
(
   dangerId             int not null auto_increment,
   findTime             datetime,
   classType            varchar(40),
   findPerson           varchar(40),
   checkUnit            varchar(40),
   address              varchar(40),
   content              varchar(1000),
   dangerGrade          varchar(10),
   type                 varchar(20),
   unit                 varchar(40),
   manager              varchar(40),
   dangerStatusNum      varchar(2) comment '隐患状态两位，第一位代表状态，第二位代表次数，比如:
            10  代表  第一次已四定
            11  代表第二次已四定',
   dangerStatus         varchar(40),
   dangerReport         varchar(1000),
   primary key (dangerId)
);

alter table danger comment '隐患表';

/*==============================================================*/
/* Table: delay                                                 */
/*==============================================================*/
create table delay
(
   id                   int not null auto_increment,
   sidingId             int,
   delaySeq             int,
   deleayReason         varchar(200),
   delayTime            datetime,
   primary key (id)
);

alter table delay comment '保存每次四定的日期';

/*==============================================================*/
/* Table: department                                            */
/*==============================================================*/
create table department
(
   departmentId         varchar(40) not null,
   upDepartmentId       varchar(40),
   name                 varchar(40),
   manager              varchar(40),
   phone                varchar(40),
   primary key (departmentId)
);

/*==============================================================*/
/* Table: dictionary                                            */
/*==============================================================*/
create table dictionary
(
   dictionaryId         varchar(40) not null,
   name                 varchar(40),
   upDictionaryId       varchar(40),
   isUse                varchar(2),
   description          varchar(200),
   primary key (dictionaryId)
);

alter table dictionary comment '字典表';

/*==============================================================*/
/* Table: follow                                                */
/*==============================================================*/
create table follow
(
   followId             int not null auto_increment,
   sidingId             int,
   dangerId             int,
   hasSecurity          varchar(2),
   safetyTechnician     varchar(40),
   managerName          varchar(40),
   recheckTime          datetime,
   primary key (followId)
);

alter table follow comment '隐患跟踪表';

/*==============================================================*/
/* Table: rechecktable                                          */
/*==============================================================*/
create table rechecktable
(
   recheckid            int not null auto_increment,
   followId             int,
   dangerId             int,
   recheckMan           varchar(40),
   recheckdate          datetime,
   recheckresult        varchar(2),
   comment              varchar(200),
   primary key (recheckid)
);

/*==============================================================*/
/* Table: sidingbiao                                            */
/*==============================================================*/
create table sidingbiao
(
   sidingId             int not null auto_increment,
   dangerId             int,
   sidingTime           datetime,
   supervisor           varchar(40),
   rectificationTime    datetime,
   rectificationMeasure varchar(600),
   primary key (sidingId)
);

/*==============================================================*/
/* Table: spotDispose                                           */
/*==============================================================*/
create table spotDispose
(
   disposeId            int not null auto_increment,
   dangerId             int,
   hasSafeMeasure       varchar(2),
   disposeMeasure       varchar(500),
   disposeDate          datetime,
   disposePerson        varchar(40),
   primary key (disposeId)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   id                   int not null,
   username             varchar(40),
   password             varchar(40),
   role                 int comment '用1，2，3.。。。代表不同的权限，显示不同的菜单',
   primary key (id)
);

alter table delay add constraint FK_Reference_7 foreign key (sidingId)
      references sidingbiao (sidingId) on delete restrict on update restrict;

alter table department add constraint FK_Reference_3 foreign key (upDepartmentId)
      references department (departmentId) on delete restrict on update restrict;

alter table follow add constraint FK_Reference_4 foreign key (sidingId)
      references sidingbiao (sidingId) on delete restrict on update restrict;

alter table follow add constraint FK_Reference_8 foreign key (dangerId)
      references danger (dangerId) on delete restrict on update restrict;

alter table rechecktable add constraint FK_Reference_5 foreign key (followId)
      references follow (followId) on delete restrict on update restrict;

alter table rechecktable add constraint FK_Reference_9 foreign key (dangerId)
      references danger (dangerId) on delete restrict on update restrict;

alter table sidingbiao add constraint FK_Reference_1 foreign key (dangerId)
      references danger (dangerId) on delete restrict on update restrict;

alter table spotDispose add constraint FK_Reference_6 foreign key (dangerId)
      references danger (dangerId) on delete restrict on update restrict;

