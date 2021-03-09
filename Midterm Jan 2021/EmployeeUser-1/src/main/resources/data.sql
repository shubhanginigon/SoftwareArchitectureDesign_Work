insert into role (name) values ('ROLE_ADMIN');
insert into role (name) values ('ROLE_USER');

insert into user (username, password,  active) values ('shubhi', '$2y$10$uwslZFS.czXR6VE7XzyBTuH.xGtdDmBBnioj2J/KZqJr0cHDEr3fa', true);
insert into user (username, password,  active) values ('User', '$2y$10$uwslZFS.czXR6VE7XzyBTuH.xGtdDmBBnioj2J/KZqJr0cHDEr3fa', true);
--Admin: shubhi pass: 1234
--User: User pass:1234

 insert into USER_ROLES(USERS_ID,ROLES_ID) values (1,1);
 insert into USER_ROLES(USERS_ID,ROLES_ID) values (2,2);