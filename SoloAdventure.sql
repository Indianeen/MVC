create database if not exists adventure;
 
use adventure;
 
drop table if exists story;
create table story (
   id int,
   body varchar(256),
   storyId int,
   primary key (id));
 
insert into story values (1, 'Du har fått en uppgift att göra',  1);
insert into story values (2, 'Bra jobbat, du går en ljus framtid till mötes!', 2);
insert into story values (3, 'Illa, din framtid ser mörk och dyster ut', 3);
 
select * from story;

drop table if exists links;
create table links (
   id int,
   description varchar(256),
   storyId int,
   storyLink int,
   primary key (id));
 
insert into links values (1, 'Du funderar på vad det är som du inte förstår och frågar om hjälp där det behövs',  1, 2);
insert into links values (2, 'Du börjar genast testa hur den kod du fått fungerar för att lisat ut hur du ska lösa uppgiften',1, 2);
insert into links values (3, 'Du väntar på att något ska hända så att din uppgift blir klar',1, 3);
 
select * from links;