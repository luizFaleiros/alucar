create table car (id bigint not null auto_increment, created_date date, is_deleted bit, modified_by varchar(255), modified_date date, color integer, is_rented bit, model varchar(255), name varchar(255), port_quantity bigint, rent_value double precision, seats_quantity bigint, shift integer, type integer, year bigint, primary key (id));