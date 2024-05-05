CREATE TABLE IF NOT EXISTS `kitty` (

    `id` BIGINT NOT NULL PRIMARY KEY,
    `name` VARCHAR(40),
    `owner` VARCHAR(40),
    `eye-color` VARCHAR(20),
    `weight` DOUBLE,
    `intelligence` INTEGER,
    `description` TEXT
)
