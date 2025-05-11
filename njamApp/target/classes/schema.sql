CREATE TABLE radno_vrijeme (
    id          BIGINT      PRIMARY KEY AUTO_INCREMENT,
    naziv       VARCHAR(50) NOT NULL,
    pocetak     TIME,
    kraj        TIME,
    zatvoreno   BOOLEAN     DEFAULT FALSE
);

CREATE TABLE restoran (
    id                          BIGINT PRIMARY KEY AUTO_INCREMENT,
    ime                         VARCHAR(255) NOT NULL,
    adresa                      VARCHAR(255) NOT NULL,
    broj_telefona               VARCHAR(50),
    email                       VARCHAR(255),
    trenutno_otvoren            BOOLEAN DEFAULT FALSE,
    prosjecno_vrijeme_dostave   INT,
    prosjecna_ocjena            INT,
    maksimalan_broj_narudzbi    INT,
    michelin_star               INT,
    kratak_opis                 TEXT,
    web_stranica                VARCHAR(255),
    vlastita_dostava            BOOLEAN DEFAULT FALSE
);

CREATE TABLE restoran_radno_vrijeme (
    id                  BIGINT      PRIMARY KEY AUTO_INCREMENT,
    restoran_id         BIGINT      NOT NULL REFERENCES restoran(id) ON DELETE CASCADE,
    dan                 VARCHAR(20) NOT NULL,
    radno_vrijeme_id    BIGINT      NOT NULL REFERENCES radno_vrijeme(id)
);
