DELIMITER $$
CREATE PROCEDURE addProductToProducts(info varchar(30), ctry varchar(50))
BEGIN
    DECLARE ctry_id int unsigned;
    SET ctry_id = (SELECT id
                   FROM country
                   WHERE name = ctry);
    INSERT INTO products(name, country_id) VALUES (info, ctry_id);
end $$
DELIMITER ;