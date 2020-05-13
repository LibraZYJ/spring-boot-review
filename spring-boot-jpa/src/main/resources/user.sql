drop table if exists t_user;
create table t_user
(
    id      LONG         not null auto_increment,
    userName    varchar(32) not null,
    passWord    varchar(32) not null,
    email    varchar(32) default null,
    nickName    varchar(32) not null,
    regTime    varchar(32) default null,
    primary key (id)
) engine = InnoDB
  auto_increment = 1
  default charset = utf8