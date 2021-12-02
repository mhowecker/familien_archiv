DROP TABLE IF EXISTS benutzer CASCADE;
DROP TABLE IF EXISTS partnerschaft CASCADE;
DROP TABLE IF EXISTS objekte CASCADE;
DROP TABLE IF EXISTS biographien CASCADE;
DROP TABLE IF EXISTS personen CASCADE;


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
	trauung_am DATE,
	verstorben_am DATE,
	konfession VARCHAR,
	geschlecht VARCHAR,
	PRIMARY KEY (id)
);

CREATE TABLE biographien(
	nummer SERIAL,
	titel VARCHAR,
	kategorie VARCHAR,
	dokument VARCHAR,
	person INTEGER,
	PRIMARY KEY (nummer, person),
	FOREIGN KEY (person) REFERENCES personen(id)
);

CREATE TABLE objekte(
	nummer SERIAL,
	person INTEGER,
	titel VARCHAR,
	kategorie VARCHAR,
	ablageort VARCHAR,
	PRIMARY KEY (nummer, person),
	FOREIGN KEY (person) REFERENCES personen(id)
);

CREATE TABLE partnerschaft(
	nummer SERIAL,
	person1 INTEGER,
	person2 INTEGER,
	von DATE,
	bis DATE,
	PRIMARY KEY (nummer, person1, person2),
	FOREIGN KEY (person1) REFERENCES personen(id),
	FOREIGN KEY (person2) REFERENCES personen(id)
);

CREATE TABLE benutzer(
	name VARCHAR,
	berechtigung VARCHAR,
	passwort VARCHAR,
	PRIMARY KEY (name)
);