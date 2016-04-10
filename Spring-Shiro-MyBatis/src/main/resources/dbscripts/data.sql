insert into tbl_user(USER_ID,USER_USERNAME,USER_PASSWORD) values ('u001','Chen','Chen');
insert into tbl_user(USER_ID,USER_USERNAME,USER_PASSWORD) values ('u002','Tomy','Tomy');
insert into tbl_user(USER_ID,USER_USERNAME,USER_PASSWORD) values ('u003','Mark','Mark');
insert into tbl_user(USER_ID,USER_USERNAME,USER_PASSWORD) values ('u004','John','John');
insert into tbl_user(USER_ID,USER_USERNAME,USER_PASSWORD) values ('u005','Lily','Lily');
insert into tbl_user(USER_ID,USER_USERNAME,USER_PASSWORD) values ('u006','Zark','Zark');

insert into tbl_role_user(USER_ID,ROLE_ID) values ('u001','r001');
insert into tbl_role_user(USER_ID,ROLE_ID) values ('u002','r002');
insert into tbl_role_user(USER_ID,ROLE_ID) values ('u003','r003');
insert into tbl_role_user(USER_ID,ROLE_ID) values ('u004','r004');
insert into tbl_role_user(USER_ID,ROLE_ID) values ('u005','r005');
insert into tbl_role_user(USER_ID,ROLE_ID) values ('u006','r006');

insert into tbl_role(ROLE_ID,ROLE_NAME) values ('r001','Manager');
insert into tbl_role(ROLE_ID,ROLE_NAME) values ('r002','Seller');
insert into tbl_role(ROLE_ID,ROLE_NAME) values ('r003','Broker');
insert into tbl_role(ROLE_ID,ROLE_NAME) values ('r004','Customer');
insert into tbl_role(ROLE_ID,ROLE_NAME) values ('r005','Programmer');
insert into tbl_role(ROLE_ID,ROLE_NAME) values ('r006','Driver');


insert into tbl_permission_role(PERMISSION_ID,ROLE_ID) values ('p001','r001');
insert into tbl_permission_role(PERMISSION_ID,ROLE_ID) values ('p002','r002');
insert into tbl_permission_role(PERMISSION_ID,ROLE_ID) values ('p003','r003');
insert into tbl_permission_role(PERMISSION_ID,ROLE_ID) values ('p004','r004');
insert into tbl_permission_role(PERMISSION_ID,ROLE_ID) values ('p005','r005');
insert into tbl_permission_role(PERMISSION_ID,ROLE_ID) values ('p006','r006');

insert into tbl_permission_role(PERMISSION_ID,ROLE_ID) values ('p006','r001');
insert into tbl_permission_role(PERMISSION_ID,ROLE_ID) values ('p005','r002');
insert into tbl_permission_role(PERMISSION_ID,ROLE_ID) values ('p004','r003');
insert into tbl_permission_role(PERMISSION_ID,ROLE_ID) values ('p003','r004');
insert into tbl_permission_role(PERMISSION_ID,ROLE_ID) values ('p002','r005');
insert into tbl_permission_role(PERMISSION_ID,ROLE_ID) values ('p001s','r006');

insert into tbl_permission(PERMISSION_ID,PERMISSION_NAME) values ('p001','read');
insert into tbl_permission(PERMISSION_ID,PERMISSION_NAME) values ('p002','write');
insert into tbl_permission(PERMISSION_ID,PERMISSION_NAME) values ('p003','delete');
insert into tbl_permission(PERMISSION_ID,PERMISSION_NAME) values ('p004','create');
insert into tbl_permission(PERMISSION_ID,PERMISSION_NAME) values ('p005','update');
insert into tbl_permission(PERMISSION_ID,PERMISSION_NAME) values ('p006','check');