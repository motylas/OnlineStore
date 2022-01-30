DELIMITER $$
CREATE PROCEDURE register(nick varchar(30), log varchar(30), password varchar(30),
 typ varchar(30), pname varchar(30), plastname varchar(30), pphone_number int, pemail varchar(30))
BEGIN
    DECLARE pid int;
    START TRANSACTION;
    INSERT INTO users(nickname, login, user_password, type) VALUES(nick,log,password,typ);
    SET pid = (
        SELECT id
        FROM users
        WHERE nickname = nick
        );
    IF isnull(pid) THEN ROLLBACK;
    end if ;
    INSERT INTO personal_data VALUES(pid,pname,plastname,pphone_number,pemail);
    COMMIT;

end $$
DELIMITER ;