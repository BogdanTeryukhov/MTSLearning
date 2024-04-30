drop table if exists animals.animal_type CASCADE ;
create table animals.animal_type
(
    id bigint primary key,
    type        text,
    is_wild     bool
);

drop table if exists animals.creature;
create table animals.creature
(
    id bigint primary key,
    name        text,
    type_id     int4 REFERENCES animals.animal_type(id),
    age         smallint
);

drop table if exists animals.habitat cascade ;
create table animals.habitat
(
    id bigint primary key,
    area        text
);

drop table if exists animals.animals_habitats;
create table animals.animals_habitats
(
    id_animal_type bigint REFERENCES animals.animal_type(id),
    id_area        bigint REFERENCES animals.habitat(id),
    PRIMARY KEY (id_animal_type, id_area)
);

drop table if exists animals.provider cascade ;
create table animals.provider
(
    id bigint primary key ,
    name text,
    phone nchar(50)
);

drop table if exists animals.animals_providers;
create table animals.animals_providers
(
    id_animal_type bigint REFERENCES animals.animal_type(id),
    id_provider bigint REFERENCES animals.provider(id),
    PRIMARY KEY (id_animal_type, id_provider)
);

INSERT INTO animals.animal_type(id, type, is_wild)
VALUES (1, 'cat', false), (2, 'dog', false), (3, 'wolf', true), (4, 'shark',true);

INSERT INTO animals.creature(id, name, type_id, age)
VALUES (1, ' barsik', 1, 14), (2, 'bobik', 2, 12), (3, 'wolfik', 3, 145), (4, 'swimmer', 4, 233);

INSERT INTO animals.habitat(id, area)
VALUES (1, 'home'), (2, 'forest'), (3, 'ocean');

INSERT INTO animals.animals_habitats(id_animal_type, id_area)
VALUES (1, 1), (2, 1), (3, 2), (4, 3);

INSERT INTO animals.provider(id, name, phone)
VALUES (1, 'Sanya', '89001001010'), (2, 'Igorek', '89011552626'), (3, 'Petya', '+78994561234');

INSERT INTO animals.animals_providers(id_animal_type, id_provider)
VALUES (1, 1), (2, 2), (3, 2), (4, 3);