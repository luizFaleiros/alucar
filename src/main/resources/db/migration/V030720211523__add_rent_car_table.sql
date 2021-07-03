create table rent_car
    (
    ID bigint not null auto_increment,
    CREATED_DATE date,
    IS_DELETED bit,
    MODIFIED_BY varchar(255),
    MODIFIED_DATE date,
    FINAL_DATE datetime,
    INITIAL_DATE datetime,
    RENT_DAYS bigint,
    CAR_ID bigint,
    RENT_VALUE double precision,
    primary key (id)
    );
alter table rent_car add constraint rent_car_constraint foreign key (car_id) references car (id);