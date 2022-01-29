Create table Banned
(
    id int unsigned not null,
    strike int unsigned not null,
    FOREIGN KEY(id)
        REFERENCES Users(id)
);

Drop Table Banned;