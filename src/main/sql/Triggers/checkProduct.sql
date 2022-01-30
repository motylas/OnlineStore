DELIMITER $$
CREATE TRIGGER checkProduct
    BEFORE INSERT
    ON products
    FOR EACH ROW
BEGIN
    IF (NEW.name, NEW.country_id) = (SELECT name, country_id
                                     FROM products
                                     WHERE name = NEW.name
                                       AND country_id = NEW.country_id)
    THEN
        SET NEW.name = '';
    ELSEIF NEW.country_id IS NULL
        THEN signal sqlstate '45000';
    end if;
end $$
DELIMITER ;
