DROP DATABASE wildlife_tracker;
CREATE DATABASE wildlife_tracker;

\c wildlife_tacker

CREATE TABLE animals (
 id SERIAL PRIMARY KEY,
 name varchar,
 type varchar
);

CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;
