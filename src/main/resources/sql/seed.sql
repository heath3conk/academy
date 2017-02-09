use academyd;

set FOREIGN_KEY_CHECKS = 0;
truncate table students;
truncate table courses;
truncate table teachers;
set FOREIGN_KEY_CHECKS = 1;

insert into students (email) VALUES
  ('aaa@aol.com'),
  ('bbb@bol.com'),
  ('ccc@col.com'),
  ('ddd@dol.com'),
  ('eee@eol.com');

insert into teachers(name, age, gender) VALUES
  ('t1', 35, 'CENTAUR'),
  ('t2', 24, 'FEMALE'),
  ('t3', 52, 'CENTAUR');

insert into courses (credits, department, fee, name, semester, teacher_id) values
  (4, 'PHYSICS', 500.0, 'Physics 101', '2017-01-25 00:00:00', 2),
  (3, 'ENGINEERING', 550.0, 'Electrical Engineering 237', '2018-01-25 00:00:00', 2),
  (2, 'BASKETWEAVING', 430.0, 'Basket Beanies 401', '2019-01-25 00:00:00', 3);

insert into registrations (course_id, student_id) VALUES
  (1, 5),
  (1, 2),
  (1, 4),
  (3, 1),
  (3, 3);