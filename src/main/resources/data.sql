DROP TABLE IF EXISTS pouet;
DROP TABLE IF EXISTS legendary_character;
CREATE TABLE legendary_character(id int, name varchar(32), age int, strength int, agility int, perception int, totalPower int);
INSERT INTO legendary_character values (1, 'Name', 18, 8, 9, 4, 21);