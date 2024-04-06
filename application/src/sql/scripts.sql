create schema animals;

create table animals.creature
(
    id_creature bigint primary key,
    name        text,
    type_id     int4,
    age         smallint
);

create table animals.animal_type
(
    id_type int primary key,
    type        nchar,
    is_wild     bool
)