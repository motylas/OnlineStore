DROP USER IF EXISTS 'admin'@'localhost';

CREATE USER 'admin'@'localhost'
    IDENTIFIED BY '';

GRANT ALL PRIVILEGES ON `online_shop`.* TO 'admin'@'localhost';