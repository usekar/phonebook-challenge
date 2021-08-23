create database livevox;
use livevox;
 
	
drop table Contacts;

create table Contacts(
   id INT NOT NULL AUTO_INCREMENT,
   first_name VARCHAR(100) NOT NULL,
   last_name VARCHAR(100) NOT NULL,
   phone_number VARCHAR(12) NOT NULL,
   PRIMARY KEY ( id )
);	
 
select  * from  Contacts