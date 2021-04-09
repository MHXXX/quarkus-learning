create table person
(
    id     serial8 primary key,
    name   varchar(64),
    gender int2 default -1,
    birth  date
);
insert into person(name, birth, gender)
values ('peter', '1996-01-01', 0);
insert into person(name, birth, gender)
values ('lisa', '1998-05-01', 1);
insert into person(name, birth, gender)
values ('jack', '1990-12-05', 0);
insert into person(name, birth, gender)
values ('chelsea', '2000-07-15', 1);