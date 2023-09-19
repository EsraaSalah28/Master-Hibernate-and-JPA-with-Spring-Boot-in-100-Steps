 create table person
( id integer not null,
name varchar(255) not null,
location varchar(255),
birthDate timestamp,
primary key(id)
);

insert into person (id,name,location,birthDate)

values (1, 'ESRAA','dubai',CURRENT_TIMESTAMP());

insert into person (id,name,location,birthDate)

values (2, 'nehal','dubai',CURRENT_TIMESTAMP());
insert into person (id,name,location,birthDate)

values (3, 'mariam','dubai',null);
insert into person (id,name,location,birthDate)

values (4, 'usef','dubai',null);