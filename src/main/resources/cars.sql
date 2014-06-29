create table cars (
    car_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    employee_id BIGINT NOT NULL,
    brand_name VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    foreign key (employee_id) references employees(employee_id)
);

insert into cars (employee_id, brand_name, model) values (1, 'Honda', 'Accord');
insert into cars (employee_id, brand_name, model) values (1, 'Toyota', 'Camry');
insert into cars (employee_id, brand_name, model) values (2, 'Subaru', 'Impreza WRX STI');
insert into cars (employee_id, brand_name, model) values (3, 'BMW', '330i');