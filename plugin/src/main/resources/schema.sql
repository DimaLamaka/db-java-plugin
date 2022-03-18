create table if not exists students(
    id bigserial primary key,
    name varchar(15),
    surname varchar(20),
    course varchar(20),
    date_of_birthday date,
    constraint unique_students unique (name, surname, course,date_of_birthday)
)