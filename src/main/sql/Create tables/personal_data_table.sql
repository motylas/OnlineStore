Create Table Personal_data
(
    id int unsigned not null,
    name varchar(30) not null,
    lastname varchar(30) not null,
    phone_number int unsigned not null,
    email varchar(50) not null,
    FOREIGN KEY(id)
        REFERENCES Users(id),
    Constraint phone_number Check (phone_number >= 100000000 && phone_number <= 999999999)

);

Drop Table Personal_data;