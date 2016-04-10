/*把SQL语法设置为兼容MYSQL风格, 效果和在JDBC连接上添加sql.syntax_ora=true是一样的，例如
  jdbc:hsqldb:mem:test;sql.syntax_mys=true
*/
SET DATABASE SQL SYNTAX MYS TRUE;
DROP TABLE IF EXISTS user;
CREATE TABLE user(
  id integer IDENTITY PRIMARY KEY ,
  firstname varchar(56),
  lastname varchar(56) ,
  age integer,
  email varchar(100)
);