insert into students(name, surname, course, date_of_birthday)
VALUES ('Evgeniy', 'Dydkin', 'java', '19-05-2000'),
       ('Elena', 'Smirnova', 'php', '21-01-1993'),
       ('Dmitry', 'Egorov', 'javascript', '10-03-2001'),
       ('Viktoriya', 'Ivanova', 'java', '01-01-1996'),
       ('Ekaterina', 'Sidorova', 'python', '30-07-1991')
       ON CONFLICT ON CONSTRAINT unique_students DO NOTHING