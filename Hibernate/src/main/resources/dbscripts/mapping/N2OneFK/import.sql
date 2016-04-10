DROP TABLE IF EXISTS address_n1kf;
DROP TABLE IF EXISTS person_n1kf;
CREATE TABLE address_n1kf(
  addressid integer(11) IDENTITY PRIMARY KEY,
  addressdetail varchar(255) DEFAULT NULL
);
CREATE TABLE person_n1kf(
  personid integer IDENTITY PRIMARY KEY,
  name varchar(255) DEFAULT NULL,
  age integer(11) DEFAULT NULL ,
  addressid integer(11) DEFAULT NULL,
  KEY FK4571AF54A2A3EE48 (addressId),
  CONSTRAINT FK4571AF54A2A3EE48 FOREIGN KEY (addressId) REFERENCES address_n1kf (addressid)
);