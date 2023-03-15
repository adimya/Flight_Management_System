create table Flight(
    id bigint not null,
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