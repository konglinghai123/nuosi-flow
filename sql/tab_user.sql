create table TAB_USER
(
   USER_ID              bigint(20) not null auto_increment comment '用户标识',
   USER_NAME            varchar(256) comment '用户名称',
   GENDER               varchar(2) comment '性别',
   EMAIL                varchar(256) comment '邮箱',
   LINK_PHONE           varchar(256) comment '手机号码',
   PASSWORD             varchar(256) comment '密码',
   PWD_RESET_TIME       varchar(2) comment '重置密码的时间',
   VALID_DATE           datetime comment '生效日期',
   EXPIRE_DATE          datetime comment '失效日期',
   DATA_STATUS          varchar(8) comment '数据状态',
   CREATE_DATE          datetime comment '创建日期',
   CREATE_OP_ID         varchar(32) comment '创建操作员编码',
   CREATE_ORG_ID        varchar(32) comment '创建组织编码',
   DONE_DATE            datetime comment '操作日期',
   OP_ID                varchar(32) comment '操作员编码',
   ORG_ID               varchar(32) comment '操作组织编码',
   TENANT_CODE          varchar(32) comment '租户编码',
   primary key (USER_ID)
);
