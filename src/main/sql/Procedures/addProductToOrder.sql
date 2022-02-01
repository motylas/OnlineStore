DELIMITER $$
CREATE PROCEDURE addProductToOrder(oid int unsigned, prod_desc varchar(30),
                                   cntry varchar(30), qtty int, cost float)
BEGIN
    DECLARE pid int unsigned;
    DECLARE cid int unsigned;
    SET cid = (SELECT id
               FROM country
               WHERE name = cntry);
    SET pid = (SELECT id
               FROM products
               WHERE country_id = cid
                 AND name = prod_desc);
    IF pid IS NOT NULL
    THEN
        IF pid IN (SELECT items_id FROM ordered_items WHERE order_id = oid)
        THEN UPDATE ordered_items
        SET quantity=quantity + qtty,
            price=cost
            WHERE items_id = pid AND order_id = oid;
        ELSE
            INSERT INTO ordered_items(order_id, items_id, quantity, price)
            VALUES (oid,pid,qtty,cost);
        end if;
    end if ;
end $$
DELIMITER ;