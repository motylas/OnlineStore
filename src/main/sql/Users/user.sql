DROP USER IF EXISTS 'user'@'localhost';

CREATE USER 'user'@'localhost'
    IDENTIFIED BY '';

# REVOKE ALL PRIVILEGES ON `online_shop` FROM 'user'@'localhost';
GRANT SELECT, INSERT ON `online_shop`.users TO 'user'@'localhost';
GRANT SELECT ON `online_shop`.banned TO 'user'@'localhost';
GRANT INSERT ON `online_shop`.personal_data TO 'user'@'localhost';
GRANT EXECUTE ON PROCEDURE register TO 'user'@'localhost';
GRANT EXECUTE ON PROCEDURE addNewOrder TO 'user'@'localhost';
GRANT ALL PRIVILEGES ON `online_shop`.* TO 'user'@'localhost';