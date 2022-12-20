CREATE DATABASE hibernate_test;
Create user hibernate_test with password 'hibernate_test';
alter database hibernate_test owner to hibernate_test;

CREATE TABLE emp(
    id SERIAL PRIMARY KEY,
    name VARCHAR(100)
);