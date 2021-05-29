create table car (id BIGINT,
                    created_date date,
                    is_deleted bit,
                    modified_by varchar(250),
                     modified_date DATETIME,
                     color integer,
                     is_rented bit,
                     model varchar(255),
                     name varchar(255),
                     port_quantity bigint,
                     rent_value double,
                     seats_quantity bigint,
                     shift integer,
                     type integer,
                     year bigint);

create table rent_car (id bigint,
                        created_date date,
                        is_deleted bit,
                        modified_by date,
                         modified_date date,
                         final_date datetime,
                         initial_date datetime,
                         rent_days bigint,
                         value double,
                         car_id bigint);

INSERT INTO Car (id, MODEL, CREATED_DATE, MODIFIED_DATE, MODIFIED_BY, IS_DELETED, NAME, YEAR,TYPE,SEATS_QUANTITY, PORT_QUANTITY,COLOR,SHIFT,RENT_VALUE,IS_RENTED)
        VALUES  (1, 'XYZ', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Teste', false, 'GOL',2000,1,12,8,1,1,1200,1);
INSERT INTO Car (id, MODEL, CREATED_DATE, MODIFIED_DATE, MODIFIED_BY, IS_DELETED, NAME, YEAR,TYPE,SEATS_QUANTITY, PORT_QUANTITY,COLOR,SHIFT,RENT_VALUE,IS_RENTED)
        VALUES  (2, 'XYZ', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Teste', false, 'GOL',2000,1,12,8,1,1,1200,1);