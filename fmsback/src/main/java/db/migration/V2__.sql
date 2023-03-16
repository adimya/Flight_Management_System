create table Flight(
    id bigint not null unique,
	fromLoc varchar(255),
	toLoc varchar(255),
	title varchar(255),
	isFull boolean,
	seats int,
	description varchar(5000),
	companyName varchar(255),
	takeOffTime time,
	landingTime time,
	ticketPrice int,
	primary key (id)
);

create table Booking(
id int,
primary key(id)
);