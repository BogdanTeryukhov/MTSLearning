drop table if exists animals.creature;
create table animals.creature
(
    id_creature bigint primary key,
    name        text,
    type_id     int4 REFERENCES animals.animal_type(id_type),
    age         smallint
);

drop table if exists animals.animal_type CASCADE ;
create table animals.animal_type
(
    id_type bigint primary key,
    type        nchar,
    is_wild     bool
);

drop table if exists animals.habitat;
create table animals.habitat
(
    id_area bigint primary key,
    area        text
);

drop table if exists animals.animals_habitats;
create table animals.animals_habitats
(
    id_animal_type bigint REFERENCES animals.animal_type(id_type),
    id_area        bigint REFERENCES animals.habitat(id_area)
);

drop table if exists animals.provider;
create table animals.provider
(
    id_provider bigint primary key ,
    name text,
    phone nchar(50)
);

drop table if exists animals.animals_providers;
create table animals.animals_providers
(
    id_animal_type bigint REFERENCES animals.animal_type(id_type),
    id_provider bigint REFERENCES animals.provider(id_provider)
)