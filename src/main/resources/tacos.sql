-- User authentication and authorization

select * from users;



alter table users add enabled varchar(10);

update users set enabled = 'True';


SET SQL_SAFE_UPDATES = 0;

select * from UserAuthorities;

create table UserAuthorities(id bigint NOT NULL auto_increment,  user_id varchar(25) not null, authority varchar(35), primary key(id));

insert into UserAuthorities values(1, 'antony1007','ROLE_USER');
insert into UserAuthorities values(2, 'Chris0317','ROLE_USER');
insert into UserAuthorities values(3, 'Eliz0420','ROLE_USER');
insert into UserAuthorities values(4, 'Wawrinka0208','ROLE_USER');


update UserAuthorities set authority = 'USER';

drop table Ingredient;


create table if not exists Ingredient (
  id bigint  NOT NULL AUTO_INCREMENT,
  name varchar(25) not null,
  type varchar(10) not null,
  PRIMARY KEY (`id`)
);

insert into Ingredient values(1,'Tomato','VEGGIES');
insert into Ingredient values(2,'Corn Tortillas','WRAP');
insert into Ingredient values(3,'Ground Beef','PROTEIN');
insert into Ingredient values(4,'Lettuce','VEGGIES');
insert into Ingredient values(5,'Cheddar','VEGGIES');
insert into Ingredient values(6,'Jack','CHEESE');


UPDATE ingredient set type = 'VEGGIES' where id = 1;

select * from ingredient;

-- Error Code: 1046. No database selected Select the default DB to be used by double-clicking its name in the SCHEMAS list in the sidebar.

-- Error Code: 1064. You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'id varchar(4) not null,   name varchar(25) not null,   type varchar(10) not null' at line 1

drop table Taco;

create table if not exists Taco (
  id bigint NOT NULL AUTO_INCREMENT,
  wonderful_name varchar(50) not null,
  createdAt timestamp not null,
  PRIMARY KEY (`id`)
);


drop table Taco_Order;

create table if not exists Taco_Order (
	id bigint NOT NULL AUTO_INCREMENT,
	deliveryName varchar(50) not null,
	deliveryStreet varchar(50) not null,
	deliveryCity varchar(50) not null,
	deliveryState varchar(2) not null,
	deliveryZip varchar(10) not null,
	ccNumber varchar(16) not null,
	ccExpiration varchar(5) not null,
	ccCVV varchar(3) not null,
    placedAt timestamp not null,
     PRIMARY KEY (id)
);

drop table Taco_Order_Tacos;



/*
SQL docker commands used
docker run -p 3306:3306 -d --name mysql -e MYSQL_ROOT_PASSWORD=password123 mysql/mysql-server

docker ps

CONTAINER ID        IMAGE                COMMAND                  CREATED             STATUS                            PORTS                               NAMES
2a7ddb28e587        mysql/mysql-server   "/entrypoint.sh mysq…"   8 seconds ago       Up 7 seconds (health: starting)   0.0.0.0:3306->3306/tcp, 33060/tcp   mysql
Antonys-MacBook-Pro:~ genil$ docker exec -it mysql bash
bash-4.2# mysql -uroot -ppassword123
mysql> CREATE USER 'tacos'@'%' IDENTIFIED BY 'password123';
Query OK, 0 rows affected (0.01 sec)

mysql> GRANT ALL PRIVILEGES ON * . * TO 'tacos'@'%'
    -> ;
Query OK, 0 rows affected (0.00 sec)

*/

delete from Taco_Order_Tacos;
delete from Taco_Ingredients;
delete from Taco;
delete from Taco_Order;

delete from Ingredient;
insert into Ingredient (id, name, type) 
                values ('FLTO', 'Flour Tortilla', 'WRAP');
insert into Ingredient (id, name, type) 
                values ('COTO', 'Corn Tortilla', 'WRAP');
insert into Ingredient (id, name, type) 
                values ('GRBF', 'Ground Beef', 'PROTEIN');
insert into Ingredient (id, name, type) 
                values ('CARN', 'Carnitas', 'PROTEIN');
insert into Ingredient (id, name, type) 
                values ('TMTO', 'Diced Tomatoes', 'VEGGIES');
insert into Ingredient (id, name, type) 
                values ('LETC', 'Lettuce', 'VEGGIES');
insert into Ingredient (id, name, type) 
                values ('CHED', 'Cheddar', 'CHEESE');
insert into Ingredient (id, name, type) 
                values ('JACK', 'Monterrey Jack', 'CHEESE');
insert into Ingredient (id, name, type) 
                values ('SLSA', 'Salsa', 'SAUCE');
insert into Ingredient (id, name, type) 
                values ('SRCR', 'Sour Cream', 'SAUCE');