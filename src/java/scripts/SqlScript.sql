
drop table phones;
drop table address;
drop table cityinfos;
DROP TABLE PERSONHOBBY;
drop table persons;
drop table hobbies;
drop table companies;
drop table infoEntities;

CREATE TABLE hobbies(
h_id int(8) not null AUTO_INCREMENT,
h_name varchar(30) not null,
description varchar(200),
primary key (h_id)
);

CREATE TABLE cityinfos(
zipcode int(20) not null,
city varchar(30)not null,
primary key (zipcode)
);

CREATE TABLE ADDRESS(
street varchar (50) not null,
additionalInfo varchar(100),
zipcode int(20)not null,
primary key(street),
foreign key (zipcode) references cityinfos (zipcode)
);


CREATE TABLE infoEntities(
ie_id int(10)not null AUTO_INCREMENT,
email varchar(30) not null,
primary key(ie_id,email)
);

CREATE TABLE persons(
p_id int(10)not null,
email varchar(30)not null,
firstname varchar(20)not null,
lastname varchar(20) not null,
primary key (p_id),
foreign key (p_id,email) references infoEntities (ie_id,email)
-- foreign key (email) references infoEntities (email)
);
CREATE TABLE personhobby(
ph_id int(10)not null AUTO_INCREMENT,
p_id int(10)not null,
h_id int(10)not null,
primary key (ph_id),
foreign key (p_id) references persons (p_id),
foreign key (h_id) references hobbies (h_id)
);

CREATE TABLE companies(
c_id int(10)not null,
email varchar(30)not null,
c_name varchar(30)not null,
description varchar(200),
cvr int(8) not null,
numemployees int(4) not null,
marketvalue int(25)not null,
primary key(c_id,email),
foreign key (c_id,email) references infoentities(ie_id,email)
);

CREATE TABLE phones(
phonenumber int(8)not null,
description varchar(150),
owner int(10) not null,
primary key(phonenumber),
FOREIGN KEY (owner) REFERENCES infoEntities(ie_id) );
commit;
