Create Table Ordered_items (
    order_id int unsigned not null,
    items_id int unsigned not null,
    quantity int unsigned not null,
    price int unsigned not null,
    Primary key (order_id, items_id),
    FOREIGN KEY(order_id) REFERENCES Orders(order_id),
    FOREIGN KEY(items_id) REferences Products(id)
);

DROP TABLE Ordered_items;