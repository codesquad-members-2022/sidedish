drop table if exists members cascade;
create table members (
    member_id bigint auto_increment,
    member_name varchar(10) not null,
    district varchar(10),
    mileage integer,
    primary key (member_id)
);

