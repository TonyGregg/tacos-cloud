create table if not exists Ingredient (
  id varchar(4) not null,
  name varchar(25) not null,
  type varchar(10) not null
);

create table if not exists Taco (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(50) not null,
  createdAt timestamp not null,
   PRIMARY KEY (`id`)
);

create table if not exists Taco_Ingredients (
  taco bigint not null,
  ingredient varchar(4) not null
);

alter table Taco_Ingredients
    add constraint foreign key (taco) references Taco(id);
alter table Taco_Ingredients
    add constraint foreign key (ingredient) references Ingredient(id);

create table if not exists Taco_Order (
	id bigint(20) NOT NULL AUTO_INCREMENT,
	deliveryName varchar(50) not null,
	deliveryStreet varchar(50) not null,
	deliveryCity varchar(50) not null,
	deliveryState varchar(2) not null,
	deliveryZip varchar(10) not null,
	ccNumber varchar(16) not null,
	ccExpiration varchar(5) not null,
	ccCVV varchar(3) not null,
    placedAt timestamp not null,
     PRIMARY KEY (`id`)
);

create table if not exists Taco_Order_Tacos (
	tacoOrder bigint not null,
	taco bigint not null
);

alter table Taco_Order_Tacos
    add constraint tco_order foreign key (tacoOrder) references Taco_Order(id);
alter table Taco_Order_Tacos
    add constraint tco_ord_tcos_cons foreign key (taco) references Taco(id);