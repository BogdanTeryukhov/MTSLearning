--create database MTSLearning;

create table animals.animal_type
(
    id bigint primary key,
    type        text,
    is_wild     bool
);

create table animals.creature
(
    id bigint primary key,
    name        text,
    type_id     int4 REFERENCES animals.animal_type(id),
    age         smallint,
    creature_id bigint
);

create table animals.habitat
(
    id bigint primary key,
    area        text
);

create table animals.animals_habitats
(
    id_animal_type bigint REFERENCES animals.animal_type(id),
    id_area        bigint REFERENCES animals.habitat(id),
    PRIMARY KEY (id_animal_type, id_area)
);

-- drop table animals.provider;
create table animals.provider
(
    id bigint primary key ,
    name text,
    phone nchar(50)
);

create table animals.animals_providers
(
    id_animal_type bigint REFERENCES animals.animal_type(id),
    id_provider bigint REFERENCES animals.provider(id),
    PRIMARY KEY (id_animal_type, id_provider)
);