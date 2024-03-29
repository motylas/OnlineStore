CREATE TABLE Users
    (
        id int unsigned AUTO_INCREMENT not null,
        nickname varchar(30) unique not null,
        login varchar(30) unique not null,
        user_password varchar(30) not null,
        type enum('admin', 'customer', 'seller') not null,
        PRIMARY KEY (id),
        Constraint nickname  Check (LENGTH(nickname) > 3),
        Constraint login Check (LENGTH(login) > 3),
        Constraint user_password Check (LENGTH(user_password) > 5)
    );

DROP Table Users;


