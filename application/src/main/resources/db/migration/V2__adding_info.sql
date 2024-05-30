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