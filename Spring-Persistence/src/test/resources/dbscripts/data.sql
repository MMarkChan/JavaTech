/*把SQL语法设置为兼容MYSQL风格, 效果和在JDBC连接上添加sql.syntax_ora=true是一样的，例如
  jdbc:hsqldb:mem:test;sql.syntax_mys=true
*/
SET DATABASE SQL SYNTAX MYS TRUE;
insert into user(id,firstname,lastname,age,email) values (1,'chen','tom',30,'passeam@gmail.com');
insert into user(id,firstname,lastname,age,email) values (2,'dongming','tom',33,'passeam@gmail.com');
insert into user(id,firstname,lastname,age,email) values (3,'chen','tom',33,'passeam@qq.com');
insert into user(id,firstname,lastname,age,email) values (4,'chen','dongming',33,'passeam@163.com');
insert into user(id,firstname,lastname,age,email) values (5,'chen','tom',5,'passeam@gmail.com');
insert into user(id,firstname,lastname,age,email) values (6,'chen','tom',6,'passeam@gmail.com');
insert into user(id,firstname,lastname,age,email) values (7,'dongming','tom',6,'passeam@gmail.com');
insert into user(id,firstname,lastname,age,email) values (8,'chen','tom',6,'passeam@gmail.com');
insert into user(id,firstname,lastname,age,email) values (9,'chen','tom',6,'passeam@gmail.com');
insert into user(id,firstname,lastname,age,email) values (10,'chen','tom',6,'passeam@gmail.com');
insert into user(id,firstname,lastname,age,email) values (11,'fan','donGming',33,'passeam@gmail.com');
insert into user(id,firstname,lastname,age,email) values (12,'Elite','dongming',33,'passeam@gmail.com');
insert into user(id,firstname,lastname,age,email) values (13,'Elite','dongming',33,'passeam@gmail.com');
insert into user(id,firstname,lastname,age,email) values (14,'fan','dongming',33,'passeam@gmail.com');
insert into user(id,firstname,lastname,age,email) values (15,'fan','dongming',33,'passeam@gmail.com');
insert into user(id,firstname,lastname,age,email) values (16,'fan','dongming',33,'passeam@gmail.com');
insert into user(id,firstname,lastname,age,email) values (17,'Tom',NULL,33,'passeam@gmail.com');
insert into user(id,firstname,lastname,age,email) values (18,'Tom',NULL,33,'passeam@gmail.com');
insert into user(id,firstname,lastname,age,email) values (19,'Tom',NULL,33,'passeam@gmail.com');
insert into user(id,firstname,lastname,age,email) values (20,'Tom',NULL,33,'passeam@gmail.com');
insert into user(id,firstname,lastname,age,email) values (21,'Tom',NULL,33,NULL);
insert into user(id,firstname,lastname,age,email) values (22,'Tom',NULL,33,NULL);
insert into user(id,firstname,lastname,age,email) values (23,'Tom',NULL,33,NULL);
insert into user(id,firstname,lastname,age,email) values (24,'Tom',NULL,33,NULL);