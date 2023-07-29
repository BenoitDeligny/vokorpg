DROP TABLE IF EXISTS legendary_character;
CREATE TABLE legendary_character
(
    uuid            varchar(36),
    name            varchar(32),
    age             int,
    strength        int,
    agility         int,
    perception      int,
    natural_might   int,
    total_might     int,
    remaining_might int
);