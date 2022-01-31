DROP USER IF EXISTS 'customer'@'localhost';

CREATE USER 'customer'@'localhost'
    IDENTIFIED BY '';

GRANT SELECT ON `online_shop`.* TO 'customer'@'localhost';