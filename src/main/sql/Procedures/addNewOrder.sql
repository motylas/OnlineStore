DELIMITER $$
CREATE PROCEDURE addNewOrder(seller varchar(30), user_id int, OUT oid int unsigned)
BEGIN
    DECLARE sid int unsigned;
    SET sid = (SELECT id
               FROM users
               WHERE nickname = seller);
    IF sid IS NOT NULL
    THEN
        INSERT INTO orders(seller_id, customer_id, status)
        VALUES (sid, user_id, '0');
        SET oid =
                (SELECT order_id
                 FROM orders
                 WHERE seller_id = sid
                 ORDER BY order_id DESC
                 LIMIT 1);
    end if;
end $$
DELIMITER ;