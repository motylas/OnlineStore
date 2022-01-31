DROP USER IF EXISTS 'seller'@'localhost';

CREATE USER 'seller'@'localhost'
    IDENTIFIED BY '';

GRANT SELECT ON `online_shop`.* TO 'seller'@'localhost';