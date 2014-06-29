create table employee_company (
    company_id BIGINT NOT NULL,
    employee_id BIGINT NOT NULL,
    foreign key (company_id) references companies(company_id),
    foreign key (employee_id) references employees(employee_id)
);

insert into employee_company values (1, 1);
insert into employee_company values (1, 2);
insert into employee_company values (1, 3);
insert into employee_company values (2, 1);
insert into employee_company values (2, 2);
insert into employee_company values (3, 3);