create table additional_details(
user_id UUID not null,
attribute_key VARCHAR(255) not null,
attribute_value VARCHAR(255),
is_encrypted boolean not null default true,
created_at TIMESTAMP default current_timestamp,
updated_at TIMESTAMP default current_timestamp,
PRIMARY KEY (user_id, attribute_key),
FOREIGN key(user_id) references customer(id)
);