create table employees (
    employee_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    age SMALLINT
);

insert into employees (first_name, last_name, age) values ('Yakov','Treiber',20);
insert into employees (first_name, last_name, age) values ('Sarah','Smith',37);
insert into employees (first_name, last_name, age) values ('Marta','Jeferson',24);