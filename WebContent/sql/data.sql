CREATE TABLE classes(
id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
class_name VARCHAR(10) NOT NULL DEFAULT ''
)

CREATE TABLE users(
id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(10) NOT NULL DEFAULT '',
PASSWORD VARCHAR(10) NOT NULL DEFAULT '',
role TINYINT UNSIGNED NOT NULL DEFAULT 0
)