INSERT INTO radno_vrijeme (naziv, pocetak, kraj, zatvoreno) VALUES
    ('JUTARNJA_SMJENA', '08:00', '12:00', FALSE),
    ('POPODNEVNA_SMJENA', '16:00', '20:00', FALSE),
    ('CIJELI_DAN', '08:00', '20:00', FALSE),
    ('NERADNI_DAN', NULL, NULL, TRUE);


INSERT INTO restoran (id, ime, adresa, broj_telefona, email, trenutno_otvoren, prosjecno_vrijeme_dostave,
                      prosjecna_ocjena, maksimalan_broj_narudzbi, michelin_star, kratak_opis, web_stranica, vlastita_dostava)
VALUES
    (1, 'Markov restoran', 'Adresa 1', '098123456', 'restoran1@email.com', TRUE, 30, 4, 50, 0, 'Ovo je Restoran 1.', 'https://markovrestoran.com', TRUE),
    (2, 'Kod Dide', 'Adresa 2', '097654321', 'restoran2@email.com', FALSE, 25, 2, 30, 1, 'Ovo je Restoran 2.', 'https://koddide.hr', FALSE),
    (3, 'Rooftop', 'Adresa 3', '099111222', 'restoran3@email.com', TRUE, 20, 1, 45, 1, 'Ovo je Restoran 3.', 'https://rooftop.hr', TRUE),
    (4, 'Bistro Šuma', 'Adresa 4', '091333444', 'restoran4@email.com', TRUE, 15, 4, 40, 2, 'Ovo je Restoran 4.', 'https://bistrosuma.hr', FALSE),
    (5, 'Kod Drageca', 'Adresa 5', '095555666', 'restoran5@email.com', FALSE, 18, 5, 35, 4, 'Ovo je Restoran 5.', 'https://koddrageca.hr', TRUE);


-- Restoran 1
INSERT INTO restoran_radno_vrijeme (restoran_id, dan, radno_vrijeme_id) VALUES
    (1, 'PONEDELJAK', 1),
    (1, 'UTORAK', 2),
    (1, 'SRIJEDA', 1),
    (1, 'CETVRTAK', 2),
    (1, 'PETAK', 1),
    (1, 'SUBOTA', 4),
    (1, 'NEDJELJA', 4);

-- Restoran 2
INSERT INTO restoran_radno_vrijeme (restoran_id, dan, radno_vrijeme_id) VALUES
    (2, 'PONEDELJAK', 3),
    (2, 'UTORAK', 2),
    (2, 'SRIJEDA', 3),
    (2, 'CETVRTAK', 2),
    (2, 'PETAK', 4),
    (2, 'SUBOTA', 4),
    (2, 'NEDJELJA', 4);

-- Restoran 3
INSERT INTO restoran_radno_vrijeme (restoran_id, dan, radno_vrijeme_id) VALUES
    (3, 'PONEDELJAK', 2),
    (3, 'UTORAK', 1),
    (3, 'SRIJEDA', 3),
    (3, 'CETVRTAK', 3),
    (3, 'PETAK', 1),
    (3, 'SUBOTA', 2),
    (3, 'NEDJELJA', 4);

-- Restoran 4
INSERT INTO restoran_radno_vrijeme (restoran_id, dan, radno_vrijeme_id) VALUES
    (4, 'PONEDELJAK', 1),
    (4, 'UTORAK', 2),
    (4, 'SRIJEDA', 4),
    (4, 'CETVRTAK', 3),
    (4, 'PETAK', 2),
    (4, 'SUBOTA', 3),
    (4, 'NEDJELJA', 1);

-- Restoran 5
INSERT INTO restoran_radno_vrijeme (restoran_id, dan, radno_vrijeme_id) VALUES
    (5, 'PONEDELJAK', 3),
    (5, 'UTORAK', 3),
    (5, 'SRIJEDA', 3),
    (5, 'CETVRTAK', 2),
    (5, 'PETAK', 2),
    (5, 'SUBOTA', 4),
    (5, 'NEDJELJA', 4);
