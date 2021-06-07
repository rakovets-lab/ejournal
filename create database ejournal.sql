DROP DATABASE IF EXISTS ejournal;
CREATE DATABASE ejournal;
USE ejournal;

CREATE TABLE users (
  id INT AUTO_INCREMENT,
  email VARCHAR(80) NOT NULL UNIQUE,
  password VARCHAR(60) NOT NULL,
  first_name VARCHAR(80) NOT NULL,
  last_name VARCHAR(80) NOT NULL,
  mobile VARCHAR(80) NOT NULL UNIQUE,
  role VARCHAR(80) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE parents (
  id INT AUTO_INCREMENT,
  city VARCHAR(80) NOT NULL,
  street VARCHAR(80) NOT NULL,
  house VARCHAR(80) NOT NULL,
  apartment VARCHAR(80),
  user_id INT NOT NULL UNIQUE,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE teachers (
  id INT AUTO_INCREMENT,
  pan INT NOT NULL UNIQUE,
  registration_date DATE NOT NULL,
  city VARCHAR(80) NOT NULL,
  street VARCHAR(80) NOT NULL,
  house VARCHAR(80) NOT NULL,
  apartment VARCHAR(80),
  user_id INT NOT NULL UNIQUE,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE groups (
  id INT AUTO_INCREMENT,
  title VARCHAR(80) NOT NULL UNIQUE,
  PRIMARY KEY (id)
);

CREATE TABLE courses (
  id INT AUTO_INCREMENT,
  title VARCHAR(80) NOT NULL UNIQUE,
  PRIMARY KEY (id)
);

CREATE TABLE groups_courses (
  group_id INT,
  course_id INT,
  FOREIGN KEY (group_id) REFERENCES groups(id),
  FOREIGN KEY (course_id) REFERENCES courses(id)
);

CREATE TABLE themes (
  id INT AUTO_INCREMENT,
  theme VARCHAR(120) NOT NULL,
  homework VARCHAR(80),
  course_id INT,
  PRIMARY KEY (id),
  FOREIGN KEY (course_id) REFERENCES courses(id)
);

CREATE TABLE contracts (
  id INT AUTO_INCREMENT,
  title VARCHAR(80) NOT NULL UNIQUE,
  availability_contract BOOLEAN DEFAULT false,
  availability_statements BOOLEAN DEFAULT false,
  availability_birth_certificate BOOLEAN DEFAULT false,
  availability_contract_photography BOOLEAN DEFAULT false,
  conclusion_date DATE NOT NULL,
  expiry_date DATE NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE payments (
  id INT AUTO_INCREMENT,
  payment_date DATE NOT NULL,
  cash DOUBLE NOT NULL,
  contract_id INT NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE children (
  id INT AUTO_INCREMENT,
  user_id INT NOT NULL,
  parent_id INT NOT NULL,
  birthday DATE NOT NULL,
  contract_id INT NOT NULL,
  group_id INT NOT NULL,
  school VARCHAR(80) NOT NULL,
  class VARCHAR(80) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (parent_id) REFERENCES users (id),
  FOREIGN KEY (contract_id) REFERENCES contracts (id),
  FOREIGN KEY (group_id) REFERENCES groups (id)
);

CREATE TABLE marks (
  id INT AUTO_INCREMENT,
  marking_date DATE NOT NULL,
  mark VARCHAR(80) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE children_marks (
  child_id INT,
  mark_id INT,
  FOREIGN KEY (child_id) REFERENCES children (id),
  FOREIGN KEY (mark_id) REFERENCES marks(id)
);

INSERT users (email, password, first_name, last_name, mobile, role) VALUES ('admin', 'admin','admin', 'admin', 'admin', 'METHODIST');

INSERT courses (title) VALUES ('Small Basic');

INSERT themes (theme, homework, course_id) VALUES ('Что такое робототехника? LEGO MINDSTORM EV3. Сборка первой модели', 'courses/SmallBasic/lesson1/homework1.pdf', 1);
INSERT themes (theme, homework, course_id) VALUES ('Что такое программирование? Язык программирования Microsoft Small Basic.Написание первой программы', 'courses/SmallBasic/lesson2/homework2.pdf', 1);
INSERT themes (theme, homework, course_id) VALUES ('Использование объекта Motor и его методов для работы с сервоприводами', 'courses/SmallBasic/lesson3/homework3.pdf', 1);
INSERT themes (theme, homework, course_id) VALUES ('Переменные. Использование объекта Motor и его методов для работы с сервоприводами', 'courses/SmallBasic/lesson4/homework4.pdf', 1);
INSERT themes (theme, homework, course_id) VALUES ('Использование объекта LCD и его методов для работы с экраном блока управления', 'courses/SmallBasic/lesson5/homework5.pdf', 1);
INSERT themes (theme, homework, course_id) VALUES ('Организация циклов в Small Basic. Цикл с условием. Операторы сравнения', 'courses/SmallBasic/lesson6/homework6.pdf', 1);
INSERT themes (theme, homework, course_id) VALUES ('Использование объекта Motor и его методов для работы с серво приводами', 'courses/SmallBasic/lesson7/homework7.pdf', 1);
INSERT themes (theme, homework, course_id) VALUES ('Датчики. Объект Sensor и его методы. Датчик касания', 'courses/SmallBasic/lesson8/homework8.pdf', 1);
INSERT themes (theme, homework, course_id) VALUES ('Датчик касания. Оператор ветвления', 'courses/SmallBasic/lesson9/homework9.pdf', 1);
INSERT themes (theme, homework, course_id) VALUES ('Кнопки на блоке. Подсветка на блоке. Динамик', 'courses/SmallBasic/lesson10/homework10.pdf', 1);
INSERT themes (theme, homework, course_id) VALUES ('Ультразвуковой датчик', 'courses/SmallBasic/lesson11/homework11.pdf', 1);
INSERT themes (theme, homework, course_id) VALUES ('Гироскопический датчик', 'courses/SmallBasic/lesson12/homework12.pdf', 1);
INSERT themes (theme, homework, course_id) VALUES ('Цветосветовой датчик. Режим определения цвета', 'courses/SmallBasic/lesson13/homework13.pdf', 1);
INSERT themes (theme, homework, course_id) VALUES ('Цветосветовой датчик.Другие режимы', 'courses/SmallBasic/lesson14/homework14.pdf', 1);
INSERT themes (theme, homework, course_id) VALUES ('Повторение ранее изученного материала', 'courses/SmallBasic/lesson15/homework15.pdf', 1);
INSERT themes (theme, homework, course_id) VALUES ('Итоговый экзамен', 'courses/SmallBasic/lesson16/homework16.pdf', 1);

INSERT courses (title) VALUES ('PC');

INSERT themes (theme, homework, course_id) VALUES ('Компьютер: история развития, внутреннее устройство, внешние устройства ', 'courses/PC/lesson1/homework1.pdf', 2);
INSERT themes (theme, homework, course_id) VALUES ('Программное обеспечение: ОС, работа с файлами и папками в Windows', 'courses/PC/lesson2/homework2.pdf', 2);
INSERT themes (theme, homework, course_id) VALUES ('Компьютерные сети: основные понятия интернета, браузеры, электронная почта, месседжеры, социальные сети', 'courses/PC/lesson3/homework3.pdf', 2);
INSERT themes (theme, homework, course_id) VALUES ('Контрольная работа', 'courses/PC/lesson4/homework4.pdf', 2);
INSERT themes (theme, homework, course_id) VALUES ('Антивирусы и архиваторы', 'courses/PC/lesson5/homework5.pdf', 2);
INSERT themes (theme, homework, course_id) VALUES ('Основные принципы работы в программе MS Word', 'courses/PC/lesson6/homework6.pdf', 2);
INSERT themes (theme, homework, course_id) VALUES ('Вставки. Рисунки и таблицы', 'courses/PC/lesson7/homework7.pdf', 2);
INSERT themes (theme, homework, course_id) VALUES ('Списки и диаграммы', 'courses/PC/lesson8/homework8.pdf', 2);
INSERT themes (theme, homework, course_id) VALUES ('Верстка готового документа. Подготовка к печати', 'courses/PC/lesson9/homework9.pdf', 2);
INSERT themes (theme, homework, course_id) VALUES ('Контрольная работа', 'courses/PC/lesson10/homework10.pdf', 2);
INSERT themes (theme, homework, course_id) VALUES ('Основные принципы работы в программе MS Excel', 'courses/PC/lesson11/homework11.pdf', 2);
INSERT themes (theme, homework, course_id) VALUES ('Функции в MS Excel', 'courses/PC/lesson12/homework12.pdf', 2);
INSERT themes (theme, homework, course_id) VALUES ('Форматирование документа', 'courses/PC/lesson13/homework13.pdf', 2);
INSERT themes (theme, homework, course_id) VALUES ('Основные принципы работы в программе MS PowerPoint', 'courses/PC/lesson14/homework14.pdf', 2);
INSERT themes (theme, homework, course_id) VALUES ('Резерв. Обощение. Представление своих собственных проектов', 'courses/PC/lesson15/homework15.pdf', 2);
INSERT themes (theme, homework, course_id) VALUES ('Итоговый экзамен', 'courses/PC/lesson16/homework16.pdf', 2);

INSERT groups (title) VALUES ('Pr2-17-01');
INSERT groups (title) VALUES ('Pr2-17-02');

INSERT users (email, password, first_name, last_name, mobile, role) VALUES ('dmitryivanov@gmail.com','divanov','Дмитрий','Иванов','+375295673467','PARENT');
INSERT parents (city, street, house, apartment, user_id) VALUES ('Минск', 'Голубева','14','34', 2);
INSERT users (email, password, first_name, last_name, mobile, role) VALUES ('dmitrypetrov@gmail.com','dpetrov','Дмитрий','Петров','+375295346345','PARENT');
INSERT parents (city, street, house, apartment, user_id) VALUES ('Минск', 'Ванеева','34','1', 3);
INSERT users (email, password, first_name, last_name, mobile, role) VALUES ('dmitryandreev@gmail.com','dandreev','Дмитрий','Андреев','+375293456781','PARENT');
INSERT parents (city, street, house, apartment, user_id) VALUES ('Минск', 'Гонсалеса','1','344', 4);
INSERT users (email, password, first_name, last_name, mobile, role) VALUES ('dmitrysergeev@gmail.com','dsergeev','Дмитрий','Сергеев','+375295672222','PARENT');
INSERT parents (city, street, house, apartment, user_id) VALUES ('Минск', 'Васильева','2','84', 5);

INSERT users (email, password, first_name, last_name, mobile, role) VALUES ('ivangolubev@gmail.com','igolubev','Иван','Голубев','+375293473467','TEACHER');
INSERT teachers (pan, registration_date, city, street, house, apartment, user_id) VALUES (12362356, '2016-04-22', 'Минск', 'Голубева','1','34', 6);
INSERT users (email, password, first_name, last_name, mobile, role) VALUES ('ivanverobin@gmail.com','iverobin','Иван','Веробьев','+375293098467','TEACHER');
INSERT teachers (pan, registration_date, city, street, house, apartment, user_id) VALUES (24562456,'2017-02-01','Минск', 'Ванеева','3','1', 7);
INSERT users (email, password, first_name, last_name, mobile, role) VALUES ('ivansorokin@gmail.com','isorokin','Иван','Сорокин','+37525433467','TEACHER');
INSERT teachers (pan, registration_date, city, street, house, apartment, user_id) VALUES (24654562,'2015-01-22','Минск', 'Гонсалеса','14','344', 8);
INSERT users (email, password, first_name, last_name, mobile, role) VALUES ('ivanvoronin@gmail.com','ivoronin','Иван','Воронин','+375293444467','TEACHER');
INSERT teachers (pan, registration_date, city, street, house, apartment, user_id) VALUES (24652452,'2013-08-26','Минск', 'Васильева','24','84', 9);

INSERT contracts (title, availability_contract, availability_statements, availability_birth_certificate, availability_contract_photography, conclusion_date, expiry_date) VALUES  ('Contract-1-01', 1, 1, 1, 1, '2011-08-26', '2014-08-26');
INSERT contracts (title, availability_contract, availability_statements, availability_birth_certificate, availability_contract_photography, conclusion_date, expiry_date) VALUES  ('Contract-1-02', 1, 0, 1, 1, '2013-08-22', '2013-08-21');
INSERT contracts (title, availability_contract, availability_statements, availability_birth_certificate, availability_contract_photography, conclusion_date, expiry_date) VALUES  ('Contract-1-03', 1, 1, 0, 1, '2013-05-26', '2013-01-26');
INSERT contracts (title, availability_contract, availability_statements, availability_birth_certificate, availability_contract_photography, conclusion_date, expiry_date) VALUES  ('Contract-1-04', 0, 1, 1, 1, '2013-01-26', '2013-02-26');

INSERT users (email, password, first_name, last_name, mobile, role) VALUES ('olgaivanova@gmail.com','oivanova','Ольга','Иванова','+375295677767','CHILD');
INSERT children (user_id, parent_id, birthday, contract_id, group_id, school, class) VALUES (10, 2, '2000-04-22', 1, 1, 'Гимназия 10', '10');
INSERT users (email, password, first_name, last_name, mobile, role) VALUES ('olegivanov@gmail.com','oivanov','Олег','Иванова','+375295677167','CHILD');
INSERT children (user_id, parent_id, birthday, contract_id, group_id, school, class) VALUES (11, 2, '2002-04-22', 2, 2, 'Гимназия 10', '8');
INSERT users (email, password, first_name, last_name, mobile, role) VALUES ('olgapetrova@gmail.com','opetrova','Ольга','Петрова','+375335677767','CHILD');
INSERT children (user_id, parent_id, birthday, contract_id, group_id, school, class) VALUES (12, 3, '1999-04-22', 3, 1, 'Гимназия 50', '11');
INSERT users (email, password, first_name, last_name, mobile, role) VALUES ('olegpetrov@gmail.com','opetrova','Олег','Петров','+37533337167','CHILD');
INSERT children (user_id, parent_id, birthday, contract_id, group_id, school, class) VALUES (13, 3, '2003-04-22', 4, 2, 'Гимназия 50', '6');