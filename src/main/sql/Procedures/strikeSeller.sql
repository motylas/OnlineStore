DELIMITER $$
CREATE PROCEDURE strikeSeller(nick varchar(30))
BEGIN
    DECLARE sid int unsigned;
    SET sid = (SELECT id FROM users WHERE nickname = nick AND type='seller');
    IF sid NOT IN (SELECT id FROM banned)
    THEN INSERT INTO banned VALUES(sid, 0);
    end if ;
    UPDATE banned
    SET strike = strike + 1
    WHERE id = sid;
end $$
DELIMITER ;