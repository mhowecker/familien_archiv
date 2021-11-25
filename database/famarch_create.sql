DROP DATABASE IF EXISTS famarch;
CREATE DATABASE famarch;
use famarch;

CREATE TABLE personen(
	id SERIAL,
	vorname VARCHAR,
	nachname VARCHAR,
	maedchenname VARCHAR,
	rufname VARCHAR,
	zusaetzliche_profeessionelle_tärigkeit VARCHAR,
	geboren_am DATE,
	begräbnis_am DATE,
	mutter VARCHAR,
	vater VARCHAR,
	titel VARCHAR,
	identifizierung VARCHAR,
	todesursache VARCHAR,
	beruf VARCHAR,
	ausbildung VARCHAR,
	trauung_am VARCHAR,
	verstorben_am VARCHAR,
	konfession VARCHAR,
	geschlecht VARCHAR,
	PRIMARY KEY (id)
);

CREATE TABLE biographien(
	titel VARCHAR,
	nummer SERIAL,
	kategorie VARCHAR,
	dokument VARCHAR,
	person INTEGER,
	PRIMARY KEY (person),
	FOREIGN KEY (person) REFERENCES personen(id)
);

CREATE TABLE objekte(
	nummer SERIAL,
	titel VARCHAR,
	kategorie VARCHAR,
	ablageort VARCHAR,
	person INTEGER,
	PRIMARY KEY (person, nummer),
	FOREIGN KEY (person) REFERENCES personen(id)
);

CREATE TABLE partnerschaft(
	nummer SERIAL,
	von DATE,
	bis DATE,
	person1 INTEGER,
	person2 INTEGER,
	PRIMARY KEY (person1, person2, nummer)
	FOREIGN KEY (person1) REFERENCES personen(id),
	FOREIGN KEY (person2) REFERENCES personen(id)
);

CREATE TABLE benutzer(
	name VARCHAR,
	berechtigung VARCHAR,
	passwort VARCHAR,
	PRIMARY KEY (name)
);