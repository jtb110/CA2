
DROP TABLE PERSONHOBBY;
drop table hobbies;
drop table persons;
drop table companies;
drop table phones;
drop table infoEntities;
drop table address;
drop table cityinfos;

CREATE TABLE cityinfos(
zip int(20) not null,
city varchar(30)not null,
primary key (zip)
);
CREATE TABLE hobbies(
h_id int(8) not null AUTO_INCREMENT,
h_name varchar(30) not null,
description varchar(200),
primary key (h_id)
);


CREATE TABLE ADDRESS(
street varchar (50) not null,
additionalInfo varchar(100),
zipcode int(20)not null,
primary key(street),
foreign key (zipcode) references cityinfos (zip)
);


CREATE TABLE infoEntities(
id int(10)not null AUTO_INCREMENT,
email varchar(30) not null,
DTYPE varchar(100),
street varchar(50) not null,
primary key(id),
foreign key (street) references ADDRESS(street)
);

CREATE TABLE persons(
id int(10)not null,
email varchar(30)not null,
firstname varchar(20)not null,
lastname varchar(20) not null,
primary key (id),
foreign key (id,email) references infoEntities (id,email)
-- foreign key (email) references infoEntities (email)
);
CREATE TABLE personhobby(
ph_id int(10)not null AUTO_INCREMENT,
p_id int(10)not null,
h_id int(10)not null,
primary key (ph_id),
foreign key (p_id) references persons (id),
foreign key (h_id) references hobbies (h_id)
);

CREATE TABLE companies(
id int(10)not null,
email varchar(30)not null,
c_name varchar(30)not null,
description varchar(200),
cvr int(8) not null,
numemployees int(4) not null,
marketvalue int(25)not null,
primary key(id,email),
foreign key (id,email) references infoentities(id,email)
);

CREATE TABLE phones(
phonenumber int(8)not null,
description varchar(150),
owner int(10) not null,
primary key(phonenumber),
FOREIGN KEY (owner) REFERENCES infoEntities(id) );

INSERT INTO CITYINFOS(zip,city) VALUES(20,'LA');
INSERT INTO ADDRESS (street,additionalinfo,zipcode) values('Fiskervej','fisk er godt',20);
INSERT INTO infoentities(email,dtype,street) values ('hej@hej.dk','Person','Fiskervej');
INSERT INTO infoentities(email,dtype,street) values ('hej@hej.dk','Company','Fiskervej');
insert into persons (id,email,firstname,lastname) values (1,'hej@hej.dk','john','ole');
insert into companies (id,email,c_name,description,cvr,numemployees,marketvalue) values(2,'hej@hej.dk','john','john',2,21,21);
insert into hobbies (h_name,description) values ('sne skovler','nedern hobby');
insert into personhobby(p_id,h_id) values (1,1);
commit;
