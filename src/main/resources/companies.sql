create table companies (
    company_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    company_name VARCHAR(50) NOT NULL,
    city VARCHAR(50) NOT NULL
);

insert into companies (company_name, city) values ('Akvelon', 'Kharkov');
insert into companies (company_name, city) values ('DataArt', 'Kharkov');
insert into companies (company_name, city) values ('EPAM', 'Kharkov');
insert into companies (company_name, city) values ('Farata Systems', 'NY');
insert into companies (company_name, city) values ('UDev', 'Kharkov');