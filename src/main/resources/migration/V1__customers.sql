create table customer(
id UUID PRIMARY KEY,
name varchar(50),
email varchar(250) not null unique,
is_active BOOLEAN not null default true,
created_at TIMESTAMP default current_timestamp,
updated_at TIMESTAMP default current_timestamp
);