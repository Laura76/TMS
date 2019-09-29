/*==============================================================*/
/* DBMS name:      ORACLE Version 10g                           */
/* Created on:     2019/9/29 15:22:28                           */
/*==============================================================*/


alter table T_CLASS
   drop constraint FK_T_CLASS_RELATIONS_T_CATEGO;

alter table T_CLASS
   drop constraint FK_T_CLASS_RELATIONS_T_TEACHE;

alter table T_CLASSSTUDENTS
   drop constraint FK_T_CLASSS_RELATIONS_T_STUDEN;

alter table T_CLASSSTUDENTS
   drop constraint FK_T_CLASSS_RELATIONS_T_CLASS;

alter table T_CLASSTIME
   drop constraint FK_T_CLASST_RELATIONS_T_CLASS;

alter table T_SIGNIN
   drop constraint FK_T_SIGNIN_RELATIONS_T_CLASS;

alter table T_SIGNIN
   drop constraint FK_T_SIGNIN_RELATIONS_T_STUDEN;

alter table T_TEACHERS
   drop constraint FK_T_TEACHE_RELATIONS_T_CATEGO;

drop table T_CATEGORY cascade constraints;

drop table T_CLASS cascade constraints;

drop table T_CLASSSTUDENTS cascade constraints;

drop table T_CLASSTIME cascade constraints;

drop table T_SIGNIN cascade constraints;

drop table T_STUDENTS cascade constraints;

drop table T_TEACHERS cascade constraints;

drop table T_USER cascade constraints;

/*==============================================================*/
/* Table: T_CATEGORY                                            */
/*==============================================================*/
create table T_CATEGORY  (
   CAID                 VARCHAR2(32)                    not null,
   CANAME               VARCHAR2(30),
   constraint PK_T_CATEGORY primary key (CAID)
);

comment on column T_CATEGORY.CAID is
'类别ID';

comment on column T_CATEGORY.CANAME is
'类别名称';

/*==============================================================*/
/* Table: T_CLASS                                               */
/*==============================================================*/
create table T_CLASS  (
   CLID                 VARCHAR2(32)                    not null,
   CAID                 VARCHAR2(32),
   TEID                 VARCHAR2(32),
   CLNAME               VARCHAR2(50),
   CLSTARTTIME          DATE,
   CLENDTIME            DATE,
   CLENROLMENT          NUMBER,
   CLDELETE             NUMBER,
   constraint PK_T_CLASS primary key (CLID)
);

comment on column T_CLASS.CLID is
'班级ID';

comment on column T_CLASS.CAID is
'类别ID';

comment on column T_CLASS.TEID is
'教师主键';

comment on column T_CLASS.CLNAME is
'班级名称';

comment on column T_CLASS.CLSTARTTIME is
'开始时间';

comment on column T_CLASS.CLENDTIME is
'结束时间';

comment on column T_CLASS.CLENROLMENT is
'招生人数';

comment on column T_CLASS.CLDELETE is
'1:删除：0：未删除';

/*==============================================================*/
/* Table: T_CLASSSTUDENTS                                       */
/*==============================================================*/
create table T_CLASSSTUDENTS  (
   CSID                 VARCHAR2(32)                    not null,
   STID                 VARCHAR2(32),
   CLID                 VARCHAR2(32),
   constraint PK_T_CLASSSTUDENTS primary key (CSID)
);

comment on table T_CLASSSTUDENTS is
'班级学生中间表';

comment on column T_CLASSSTUDENTS.CSID is
'主键';

comment on column T_CLASSSTUDENTS.STID is
'学员ID';

comment on column T_CLASSSTUDENTS.CLID is
'班级ID';

/*==============================================================*/
/* Table: T_CLASSTIME                                           */
/*==============================================================*/
create table T_CLASSTIME  (
   CTID                 VARCHAR2(32)                    not null,
   CLID                 VARCHAR2(32),
   CTBEGINTIME          DATE,
   CTENDTIME            DATE,
   CTCYCLE              NUMBER,
   constraint PK_T_CLASSTIME primary key (CTID)
);

comment on column T_CLASSTIME.CTID is
'上课时间ID';

comment on column T_CLASSTIME.CLID is
'班级ID';

comment on column T_CLASSTIME.CTBEGINTIME is
'开始时间';

comment on column T_CLASSTIME.CTENDTIME is
'结束时间';

comment on column T_CLASSTIME.CTCYCLE is
'周日~周六分别为0-6';

/*==============================================================*/
/* Table: T_SIGNIN                                              */
/*==============================================================*/
create table T_SIGNIN  (
   SIID                 VARCHAR2(32)                    not null,
   CLID                 VARCHAR2(32),
   STID                 VARCHAR2(32),
   SITIME               DATE,
   SISTATE              NUMBER,
   constraint PK_T_SIGNIN primary key (SIID)
);

comment on table T_SIGNIN is
'学员签到表';

comment on column T_SIGNIN.SIID is
'签到ID';

comment on column T_SIGNIN.CLID is
'班级ID';

comment on column T_SIGNIN.STID is
'学员ID';

comment on column T_SIGNIN.SITIME is
'签到时间';

comment on column T_SIGNIN.SISTATE is
'签到状态0:正常签到 1：请假 ，2：旷课';

/*==============================================================*/
/* Table: T_STUDENTS                                            */
/*==============================================================*/
create table T_STUDENTS  (
   STID                 VARCHAR2(32)                    not null,
   STNAME               VARCHAR2(50),
   STGENDER             NUMBER,
   STIDNUMBER           VARCHAR2(20),
   STBIRTHDAY           DATE,
   STPHONE              VARCHAR2(30),
   STISDELETE           NUMBER,
   STCREATETIME         DATE,
   constraint PK_T_STUDENTS primary key (STID)
);

comment on column T_STUDENTS.STID is
'学员ID';

comment on column T_STUDENTS.STNAME is
'学员姓名';

comment on column T_STUDENTS.STGENDER is
'1:男 1：女';

comment on column T_STUDENTS.STIDNUMBER is
'身份证号码';

comment on column T_STUDENTS.STBIRTHDAY is
'出生日期';

comment on column T_STUDENTS.STPHONE is
'联系电话';

comment on column T_STUDENTS.STISDELETE is
'是否删除 0:未删除 1：已删除';

comment on column T_STUDENTS.STCREATETIME is
'学员添加时间';

/*==============================================================*/
/* Table: T_TEACHERS                                            */
/*==============================================================*/
create table T_TEACHERS  (
   TEID                 VARCHAR2(32)                    not null,
   TENAME               VARCHAR2(50),
   TEGENDER             NUMBER,
   TEIDNUMBER           VARCHAR2(20),
   TEBIRTHDAY           DATE,
   TEPROFESSIONAL       VARCHAR2(50),
   TEEDUCATION          VARCHAR2(20),
   TEWORKDATE           DATE,
   TEPHOTO              VARCHAR2(100),
   TEDELETE             NUMBER,
   CAID                 VARCHAR2(50),
   constraint PK_T_TEACHERS primary key (TEID)
);

comment on table T_TEACHERS is
'教师表';

comment on column T_TEACHERS.TEID is
'教师主键';

comment on column T_TEACHERS.TENAME is
'教师姓名';

comment on column T_TEACHERS.TEGENDER is
'教师性别 1：男 0：女';

comment on column T_TEACHERS.TEIDNUMBER is
'身份证号码';

comment on column T_TEACHERS.TEBIRTHDAY is
'出生日期';

comment on column T_TEACHERS.TEPROFESSIONAL is
'专业';

comment on column T_TEACHERS.TEEDUCATION is
'学历';

comment on column T_TEACHERS.TEWORKDATE is
'入职时间';

comment on column T_TEACHERS.TEPHOTO is
'照片';

comment on column T_TEACHERS.TEDELETE is
'是否删除 1：已删除 0：未删除';

comment on column T_TEACHERS.CAID is
'类别';

/*==============================================================*/
/* Table: T_USER                                                */
/*==============================================================*/
create table T_USER  (
   USERID               VARCHAR2(32)                    not null,
   USERNAME             VARCHAR2(50),
   PASSWORD             VARCHAR2(32),
   ISVALID              NUMBER,
   constraint PK_T_USER primary key (USERID)
);

comment on column T_USER.USERID is
'用户ID，主键';

comment on column T_USER.USERNAME is
'用户名';

comment on column T_USER.PASSWORD is
'密码，以MD5加密';

comment on column T_USER.ISVALID is
'1:有效，其他无效';

alter table T_CLASS
   add constraint FK_T_CLASS_RELATIONS_T_CATEGO foreign key (CAID)
      references T_CATEGORY (CAID);

alter table T_CLASS
   add constraint FK_T_CLASS_RELATIONS_T_TEACHE foreign key (TEID)
      references T_TEACHERS (TEID);

alter table T_CLASSSTUDENTS
   add constraint FK_T_CLASSS_RELATIONS_T_STUDEN foreign key (STID)
      references T_STUDENTS (STID);

alter table T_CLASSSTUDENTS
   add constraint FK_T_CLASSS_RELATIONS_T_CLASS foreign key (CLID)
      references T_CLASS (CLID);

alter table T_CLASSTIME
   add constraint FK_T_CLASST_RELATIONS_T_CLASS foreign key (CLID)
      references T_CLASS (CLID);

alter table T_SIGNIN
   add constraint FK_T_SIGNIN_RELATIONS_T_CLASS foreign key (CLID)
      references T_CLASS (CLID);

alter table T_SIGNIN
   add constraint FK_T_SIGNIN_RELATIONS_T_STUDEN foreign key (STID)
      references T_STUDENTS (STID);

alter table T_TEACHERS
   add constraint FK_T_TEACHE_RELATIONS_T_CATEGO foreign key (CAID)
      references T_CATEGORY (CAID);

