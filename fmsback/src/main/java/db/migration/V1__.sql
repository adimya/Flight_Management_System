-- the first script for migration
create table Article (
    id bigint generated by default as identity,
    content varchar(5000),
    postedAt timestamp,
    title varchar(255),
    primary key (id)
);

create table Article_authorIds (
    Article_id bigint not null,
    authorIds bigint
);
   
create table "user" (
    id bigint unique,
    fullname varchar(255),
    isAdmin boolean not null,
    password varchar(255),
    username varchar(255),
    bookedId varchar(1000),
    primary key (id)
);


alter table Article_authorIds 
add constraint FK_f9ivk719aqb0rqd8my08loev7 
foreign key (Article_id) 
references Article;