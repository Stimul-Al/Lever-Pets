create schema pets;

create table pets.animals
(
    id          bigserial not null
        constraint animals_pkey
            primary key,
    name        varchar(255),
    type_animal varchar(255)
);

alter table pets.animals
    owner to 063c60194ec7;

create table pets.persons
(
    id       bigserial not null
        constraint persons_pkey
            primary key,
    email    varchar(255),
    name     varchar(255),
    password varchar(255)
);

alter table pets.persons
    owner to 063c60194ec7;

create table pets.persons_animals
(
    person_id bigint not null
        constraint fkenjoksg8t36t5jx2kdf1u3yid
            references pets.persons,
    animal_id bigint not null
        constraint fk5sk1hc7x4v8c1qggvrcrgbas8
            references pets.animals
);

alter table pets.persons_animals
    owner to 063c60194ec7;