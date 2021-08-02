INSERT INTO pets.persons (id, email, name, password)
VALUES (1, 'bob@gmail.com', 'Bob', '12345678');

INSERT INTO pets.persons (id, email, name, password)
VALUES (2, 'sam@gmail.com', 'Sam', '123123123');

INSERT INTO pets.persons (id, email, name, password)
VALUES (3, 'jack@gmail.com', 'Jack', 'qwerty');

INSERT INTO pets.persons (id, email, name, password)
VALUES (4, 'jhon@gmail.com', 'Jhon', '11112222');

INSERT INTO pets.animals (id, name, type_animal)
VALUES (1, 'Space', 'CAT');

INSERT INTO pets.animals (id, name, type_animal)
VALUES (2, 'Margaret', 'CAT');

INSERT INTO pets.animals (id, name, type_animal)
VALUES (3, 'Tesla', 'CAT');

INSERT INTO pets.animals (id, name, type_animal)
VALUES (4, 'Newton', 'CAT');

INSERT INTO pets.animals (id, name, type_animal)
VALUES (5, 'Einstein', 'DOG');

INSERT INTO pets.animals (id, name, type_animal)
VALUES (6, 'Lincoln', 'DOG');

INSERT INTO pets.animals (id, name, type_animal)
VALUES (7, 'King', 'DOG');

INSERT INTO pets.animals (id, name, type_animal)
VALUES (8, 'Curie', 'DOG');

INSERT INTO pets.persons_animals (animal_id, person_id)
VALUES (1, 1);

INSERT INTO pets.persons_animals (animal_id, person_id)
VALUES (2, 1);

INSERT INTO pets.persons_animals (animal_id, person_id)
VALUES (3, 3);

INSERT INTO pets.persons_animals (animal_id, person_id)
VALUES (4, 4);