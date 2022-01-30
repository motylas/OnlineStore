DELIMITER $$
CREATE FUNCTION checkCountry(ctry varchar(50))
    RETURNS boolean
BEGIN
    IF ctry IN (SELECT NAME FROM country)
    THEN
        RETURN true;
    end if ;
    RETURN false;
end $$
DELIMITER ;