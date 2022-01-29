Create Table Orders
(
    order_id int unsigned NOT NULL AUTO_INCREMENT,
    seller_id int unsigned not null,
    customer_id int unsigned not null,
    status enum ('0','1','-1'),
    Primary Key (order_id),
    Foreign key (seller_id) references Users (id),
    Foreign key (customer_id) references Users (id)
);

DROP Table Orders;