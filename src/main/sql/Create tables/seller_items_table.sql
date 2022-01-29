Create table Seller_items
(
    product_id int unsigned not null,
    seller_id int unsigned not null,
    quantity int unsigned not null,
    price int unsigned not null,
    PRIMARY KEY (product_id, seller_id),
    FOREIGN KEY(product_id)
        References Products(id),
    FOREIGN KEY(seller_id)
        References Users(id)

);

DROP TABLE Seller_items;