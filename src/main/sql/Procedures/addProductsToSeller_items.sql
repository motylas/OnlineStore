DELIMITER $$
CREATE PROCEDURE addProductToSeller_items(info varchar(30), ctry varchar(50),
                                          qtty int unsigned, cost float unsigned, sid int unsigned)
BEGIN
    DECLARE ctry_id int unsigned;
    DECLARE prod_id int unsigned;
    SET ctry_id = (SELECT id
                   FROM country
                   WHERE name = ctry);
    IF ctry_id IS NOT NULL
    THEN
        SET prod_id = (SELECT id
                       FROM products
                       WHERE name = info
                         AND country_id = ctry_id);
        IF prod_id IN (SELECT product_id FROM seller_items) AND sid IN (SELECT seller_id FROM seller_items)
        THEN
            UPDATE seller_items
            SET quantity=quantity + qtty,
                price=cost
            WHERE product_id = prod_id AND seller_id = sid;
        ELSE INSERT INTO seller_items VALUES(prod_id, sid, qtty,cost);
        end if;
    end if;
end $$
DELIMITER ;