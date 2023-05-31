DROP DATABASE IF EXISTS humans_friends;

CREATE DATABASE humans_friends;

USE humans_friends;

CREATE TABLE animals (
  id SERIAL,
  animal_type VARCHAR(255) NOT NULL
);

/* 
CREATE TABLE pet_animals (
  id SERIAL,

);

CREATE TABLE pack_animals (
  id SERIAL,

);
*/

CREATE TABLE dogs (
  id SERIAL,
  name VARCHAR(255) NOT NULL,
  skill VARCHAR(255) NOT NULL,
  birth_date DATE NOT NULL,
  animal_class_id BIGINT UNSIGNED NOT NULL,
  FOREIGN KEY (animal_class_id) REFERENCES animals(id)
);

CREATE TABLE cats (
  id SERIAL,
  name VARCHAR(255) NOT NULL,
  skill VARCHAR(255) NOT NULL,
  birth_date DATE NOT NULL,
  animal_class_id BIGINT UNSIGNED NOT NULL,
  FOREIGN KEY (animal_class_id) REFERENCES animals(id)
);

CREATE TABLE hamsters (
  id SERIAL,
  name VARCHAR(255) NOT NULL,
  skill VARCHAR(255) NOT NULL,
  birth_date DATE NOT NULL,
  animal_class_id BIGINT UNSIGNED NOT NULL,
  FOREIGN KEY (animal_class_id) REFERENCES animals(id)
);


CREATE TABLE horses (
  id SERIAL,
  name VARCHAR(255) NOT NULL,
  skill VARCHAR(255) NOT NULL,
  birth_date DATE NOT NULL,
  animal_class_id BIGINT UNSIGNED NOT NULL,
  FOREIGN KEY (animal_class_id) REFERENCES animals(id)
);

CREATE TABLE camels (
  id SERIAL,
  name VARCHAR(255) NOT NULL,
  skill VARCHAR(255) NOT NULL,
  birth_date DATE NOT NULL,
  animal_class_id BIGINT UNSIGNED NOT NULL,
  FOREIGN KEY (animal_class_id) REFERENCES animals(id)
);

CREATE TABLE donkeys (
  id SERIAL,
  name VARCHAR(255) NOT NULL,
  skill VARCHAR(255) NOT NULL,
  birth_date DATE NOT NULL,
  animal_class_id BIGINT UNSIGNED NOT NULL,
  FOREIGN KEY (animal_class_id) REFERENCES animals(id)
);

INSERT INTO animals (id, animal_type) VALUES (1, 'pet animal'), (2, 'pack animal'), (3, 'wild animal');
-- yeah, yeah, 'wild animal' is unused, i know ))

-- add some dogs
INSERT INTO dogs (name, skill, birth_date, animal_class_id) VALUES
  ('Sharik', 'Sit', '2020-03-19', 1),
  ('Morda', 'Voice', '2021-01-05', 1);

-- add some cats
INSERT INTO cats (name, skill, birth_date, animal_class_id) VALUES
  ('Murzik', 'Purr', '2006-08-22', 1);

-- add some hamsters
INSERT INTO hamsters (name, skill, birth_date, animal_class_id) VALUES
  ('hamster1', 'Eat', '2021-02-03', 1),
  ('hamster2', 'Eat', '2021-02-04', 1);

-- add some horses
INSERT INTO horses (name, skill, birth_date, animal_class_id) VALUES
  ('Spirit', 'Faster', '2015-03-10', 2);

-- add some camels
INSERT INTO camels (name, skill, birth_date, animal_class_id) VALUES
  ('Moro', 'Lie down', '2020-02-03', 2);

-- add some donkeys
INSERT INTO donkeys (name, skill, birth_date, animal_class_id) VALUES
  ('Ia', 'Stop', '2019-03-11', 2);
  
-- the camels are gone for thw winter ))
  DROP TABLE camels;

-- merge donkeys and horses
CREATE TABLE pack_animals AS (
  SELECT name, skill, birth_date, animal_class_id
    FROM donkeys
  UNION
  SELECT name, skill, birth_date, animal_class_id
    FROM horses);

-- NEW young animals table with added age in month column
CREATE TABLE young_animals AS (
    SELECT name, skill, birth_date, animal_class_id, TIMESTAMPDIFF(MONTH, birth_date, CURDATE()) AS age_in_months
    FROM dogs
    WHERE birth_date <= DATE_SUB(CURDATE(), INTERVAL 1 YEAR) AND birth_date >= DATE_SUB(CURDATE(), INTERVAL 3 YEAR)
  UNION
    SELECT name, skill, birth_date, animal_class_id, TIMESTAMPDIFF(MONTH, birth_date, CURDATE()) AS age_in_months
    FROM cats
    WHERE birth_date <= DATE_SUB(CURDATE(), INTERVAL 1 YEAR) AND birth_date >= DATE_SUB(CURDATE(), INTERVAL 3 YEAR)
  UNION
	  SELECT name, skill, birth_date, animal_class_id, TIMESTAMPDIFF(MONTH, birth_date, CURDATE()) AS age_in_months
	  FROM hamsters
    WHERE birth_date <= DATE_SUB(CURDATE(), INTERVAL 1 YEAR) AND birth_date >= DATE_SUB(CURDATE(), INTERVAL 3 YEAR)
  UNION
	  SELECT name, skill, birth_date, animal_class_id, TIMESTAMPDIFF(MONTH, birth_date, CURDATE()) AS age_in_months
	  FROM horses
    WHERE birth_date <= DATE_SUB(CURDATE(), INTERVAL 1 YEAR) AND birth_date >= DATE_SUB(CURDATE(), INTERVAL 3 YEAR)
  UNION
	  SELECT name, skill, birth_date, animal_class_id, TIMESTAMPDIFF(MONTH, birth_date, CURDATE()) AS age_in_months
	  FROM donkeys
    WHERE birth_date <= DATE_SUB(CURDATE(), INTERVAL 1 YEAR) AND birth_date >= DATE_SUB(CURDATE(), INTERVAL 3 YEAR)
);

-- NEW all animals merged table with added column from which table animal is
CREATE TABLE all_animals AS (
    SELECT name, skill, birth_date, animal_class_id, "Dogs" as "from"
    FROM dogs
  UNION
    SELECT name, skill, birth_date, animal_class_id, "Cats"
    FROM cats
  UNION
	  SELECT name, skill, birth_date, animal_class_id, "Hamsters"
	  FROM hamsters
  UNION
	  SELECT name, skill, birth_date, animal_class_id, "Horses"
	  FROM horses
  UNION
	  SELECT name, skill, birth_date, animal_class_id, "Donkeys"
	  FROM donkeys
);