create schema animals;

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
    secret_info text
);
