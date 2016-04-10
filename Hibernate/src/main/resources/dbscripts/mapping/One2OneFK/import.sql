DROP TABLE IF EXISTS address_one2onefk;
DROP TABLE IF EXISTS person_one2onefk;
CREATE TABLE address_one2onefk(addressid integer IDENTITY PRIMARY KEY,addressdetail varchar(255) DEFAULT NULL);
CREATE TABLE person_one2onefk(personid integer IDENTITY PRIMARY KEY,name varchar(255) DEFAULT NULL,age integer DEFAULT NULL ,addressid integer DEFAULT NULL,CONSTRAINT FK4571AF54A2A3EE48 FOREIGN KEY (addressId) REFERENCES address_one2onefk (addressid));