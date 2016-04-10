DROP TABLE IF EXISTS tbl_user;
DROP TABLE IF EXISTS tbl_role_user;
DROP TABLE IF EXISTS tbl_role;
DROP TABLE IF EXISTS tbl_permission_role;
DROP TABLE IF EXISTS tbl_permission;
CREATE TABLE tbl_user(
  USER_ID varchar(56),
  USER_USERNAME varchar(56),
  USER_PASSWORD varchar(56)
);
CREATE TABLE tbl_role_user(
  USER_ID varchar(56),
  ROLE_ID varchar(56),
);
CREATE TABLE tbl_role(
  ROLE_ID varchar(56),
  ROLE_NAME varchar(56)
);
CREATE TABLE tbl_permission_role(
  PERMISSION_ID varchar(56),
  ROLE_ID varchar(56),
);
CREATE TABLE tbl_permission(
  PERMISSION_ID varchar(56) ,
  PERMISSION_NAME varchar(56)
);