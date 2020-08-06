SET DATABASE TRANSACTION CONTROL MVCC;

DROP TABLE people IF EXISTS;


CREATE TABLE people  (
    person_id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    email VARCHAR(40)
);

INSERT INTO people(first_name, last_name, email) VALUES
('Farah', 'Ben', 'farahbentest@wanadoo.fr'),
('Pierre', 'Bebon', 'beb97@hotmail.com'),
('Student', 'Ocr', 'test@email.com')
;

CREATE TABLE pret  (
    pret_id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    book_id BIGINT,
    person_id BIGINT,
    due_date DATE
);

INSERT INTO pret(book_id, person_id, due_date) VALUES
(1, 1, TO_DATE('2010-01-30', 'YYYY-MM-DD') ),
(2, 2, TO_DATE('2020-01-30', 'YYYY-MM-DD') ),
(3, 1, TO_DATE('2030-01-30', 'YYYY-MM-DD') )
;