create table exchange_rate(
    id varchar(36) not null,
	ccypair varchar(6) not null,
	tick_time timestamp not null,
	spot numeric(2,2),
	primary key (id)
);