CREATE DATABASE wildlife_tracker;

\c wildlife_tracker

CREATE TABLE animals
(
    id   SERIAL PRIMARY KEY,
    name varchar,
    type varchar
);

CREATE TABLE sightings
(
    id          SERIAL PRIMARY KEY,
    animal_id   int,
    location    varchar,
    ranger_name varchar
);

CREATE TABLE sightings_animals (
    id SERIAL PRIMARY KEY,
    sightingid int,
    animalid int
);

CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;
