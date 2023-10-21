DROP TABLE IF EXISTS orders_table;
DROP TABLE IF EXISTS consumers_table;
DROP TABLE IF EXISTS role_table;

CREATE TABLE consumers_table (
  id int NOT NULL AUTO_INCREMENT,
  username varchar(15),
  password varchar(15),
  name varchar(15),
  surname varchar(15),
  age int,
  sex varchar(15),
  phone_number varchar(15),
  PRIMARY KEY (id)
);

CREATE TABLE orders_table (
  id int NOT NULL AUTO_INCREMENT,
  weight double,
  filling varchar(25),
  design varchar(25),
  client_id int,
  PRIMARY KEY (id),
  FOREIGN KEY (client_id) REFERENCES consumers_table(id)
);

CREATE TABLE role_table (
	id int NOT NULL AUTO_INCREMENT,
	title varchar(25),
	PRIMARY KEY (id)
)