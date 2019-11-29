drop table Ingredient;

create table if not exists Ingredient (
  id bigint  NOT NULL AUTO_INCREMENT,
  name varchar(25) not null,
  type varchar(10) not null,
  PRIMARY KEY (`id`)
);
-- Error Code: 1046. No database selected Select the default DB to be used by double-clicking its name in the SCHEMAS list in the sidebar.

-- Error Code: 1064. You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'id varchar(4) not null,   name varchar(25) not null,   type varchar(10) not null' at line 1

create table if not exists Taco (
  id bigint NOT NULL AUTO_INCREMENT,
  name varchar(50) not null,
  createdAt timestamp not null,
   PRIMARY KEY (`id`)
);

drop table Taco_Ingredients;

create table if not exists Taco_Ingredients (
  taco bigint not null,
  ingredient_id bigint not null
);

alter table Taco_Ingredients
    add constraint foreign key (taco) references Taco(id);
    
alter table Taco_Ingredients
    add constraint foreign key (ingredient_id) references Ingredient(id);

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

create table if not exists Taco_Order_Tacos (
	tacoOrder bigint not null,
	taco bigint not null
);

alter table Taco_Order_Tacos
    add constraint tco_order foreign key (tacoOrder) references Taco_Order(id);
alter table Taco_Order_Tacos
    add constraint tco_ord_tcos_cons foreign key (taco) references Taco(id);

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