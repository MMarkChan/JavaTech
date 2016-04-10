/*把SQL语法设置为兼容MYSQL风格, 效果和在JDBC连接上添加sql.syntax_ora=true是一样的，例如
  jdbc:hsqldb:mem:test;sql.syntax_mys=true
*/
SET DATABASE SQL SYNTAX MYS TRUE;
CREATE TABLE STUDENTS(
stud_id INTEGER IDENTITY ,
name varchar(50) NOT NULL,
email varchar(50) NOT NULL,
dob date DEFAULT NULL,
PRIMARY KEY (stud_id)
);
insert into students(stud_id,name,email,dob)
values (1,'Student1','student1@gmail.com','1983-06-25');
insert into students(stud_id,name,email,dob)
values (2,'Student2','student2@gmail.com','1983-06-25');