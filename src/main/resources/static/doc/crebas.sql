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
'���ID';

comment on column T_CATEGORY.CANAME is
'�������';

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
'�༶ID';

comment on column T_CLASS.CAID is
'���ID';

comment on column T_CLASS.TEID is
'��ʦ����';

comment on column T_CLASS.CLNAME is
'�༶����';

comment on column T_CLASS.CLSTARTTIME is
'��ʼʱ��';

comment on column T_CLASS.CLENDTIME is
'����ʱ��';

comment on column T_CLASS.CLENROLMENT is
'��������';

comment on column T_CLASS.CLDELETE is
'1:ɾ����0��δɾ��';

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
'�༶ѧ���м��';

comment on column T_CLASSSTUDENTS.CSID is
'����';

comment on column T_CLASSSTUDENTS.STID is
'ѧԱID';

comment on column T_CLASSSTUDENTS.CLID is
'�༶ID';

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
'�Ͽ�ʱ��ID';

comment on column T_CLASSTIME.CLID is
'�༶ID';

comment on column T_CLASSTIME.CTBEGINTIME is
'��ʼʱ��';

comment on column T_CLASSTIME.CTENDTIME is
'����ʱ��';

comment on column T_CLASSTIME.CTCYCLE is
'����~�����ֱ�Ϊ0-6';

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
'ѧԱǩ����';

comment on column T_SIGNIN.SIID is
'ǩ��ID';

comment on column T_SIGNIN.CLID is
'�༶ID';

comment on column T_SIGNIN.STID is
'ѧԱID';

comment on column T_SIGNIN.SITIME is
'ǩ��ʱ��';

comment on column T_SIGNIN.SISTATE is
'ǩ��״̬0:����ǩ�� 1����� ��2������';

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
'ѧԱID';

comment on column T_STUDENTS.STNAME is
'ѧԱ����';

comment on column T_STUDENTS.STGENDER is
'1:�� 1��Ů';

comment on column T_STUDENTS.STIDNUMBER is
'���֤����';

comment on column T_STUDENTS.STBIRTHDAY is
'��������';

comment on column T_STUDENTS.STPHONE is
'��ϵ�绰';

comment on column T_STUDENTS.STISDELETE is
'�Ƿ�ɾ�� 0:δɾ�� 1����ɾ��';

comment on column T_STUDENTS.STCREATETIME is
'ѧԱ���ʱ��';

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
'��ʦ��';

comment on column T_TEACHERS.TEID is
'��ʦ����';

comment on column T_TEACHERS.TENAME is
'��ʦ����';

comment on column T_TEACHERS.TEGENDER is
'��ʦ�Ա� 1���� 0��Ů';

comment on column T_TEACHERS.TEIDNUMBER is
'���֤����';

comment on column T_TEACHERS.TEBIRTHDAY is
'��������';

comment on column T_TEACHERS.TEPROFESSIONAL is
'רҵ';

comment on column T_TEACHERS.TEEDUCATION is
'ѧ��';

comment on column T_TEACHERS.TEWORKDATE is
'��ְʱ��';

comment on column T_TEACHERS.TEPHOTO is
'��Ƭ';

comment on column T_TEACHERS.TEDELETE is
'�Ƿ�ɾ�� 1����ɾ�� 0��δɾ��';

comment on column T_TEACHERS.CAID is
'���';

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
'�û�ID������';

comment on column T_USER.USERNAME is
'�û���';

comment on column T_USER.PASSWORD is
'���룬��MD5����';

comment on column T_USER.ISVALID is
'1:��Ч��������Ч';

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

