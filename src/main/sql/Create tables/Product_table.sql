Create table Products
(
    id int unsigned AUTO_INCREMENT not null,
    name varchar(30) not null,
    country_id int unsigned not null,
    PRIMARY KEY(id),
    FOREIGN KEY(country_id)
        REFERENCES Country(id),
    Constraint Product_name Check (name > 3)

);

Drop Table Products;