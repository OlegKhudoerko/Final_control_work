Итоговая контрольная работа
Информация о проекте
Необходимо организовать систему учета для питомника в котором живут
домашние и вьючные животные.
Как сдавать проект
Для сдачи проекта необходимо создать отдельный общедоступный
репозиторий(Github, gitlub, или Bitbucket). Разработку вести в этом
репозитории, использовать пул реквесты на изменения. Программа должна
запускаться и работать, ошибок при выполнении программы быть не должно.
Программа, может использоваться в различных системах, поэтому необходимо
разработать класс в виде конструктора
Задание
1. Используя команду cat в терминале операционной системы Linux, создать
   два файла Домашние животные (заполнив файл собаками, кошками,
   хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и
   ослы), а затем объединить их. Просмотреть содержимое созданного файла.
   Переименовать файл, дав ему новое имя (Друзья человека).
   ![Task 1](https://github.com/OlegKhudoerko/Final_control_work/blob/master/Images/1.png) 

2. Создать директорию, переместить файл туда.
   
   ![Task 2](https://github.com/OlegKhudoerko/Final_control_work/blob/master/Images/2.png) 

3. Подключить дополнительный репозиторий MySQL. Установить любой пакет
   из этого репозитория.
   
   ![Task 3](https://github.com/OlegKhudoerko/Final_control_work/blob/master/Images/3.png) 
   
4. Установить и удалить deb-пакет с помощью dpkg.
   
   ![Task 4](https://github.com/OlegKhudoerko/Final_control_work/blob/master/Images/4.png) 

5. Выложить историю команд в терминале ubuntu
   
   ![Task 5](https://github.com/OlegKhudoerko/Final_control_work/blob/master/Images/5.png) 

6. Нарисовать диаграмму, в которой есть класс родительский класс, домашние
   животные и вьючные животные, в составы которых в случае домашних
   животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные
   войдут: Лошади, верблюды и ослы).
   
   ![Task 6](https://github.com/OlegKhudoerko/Final_control_work/blob/master/Images/6.png) 

7. В подключенном MySQL репозитории создать базу данных “Друзья
   человека”

```sql

DROP DATABASE IF EXISTS Mans_friends;


CREATE DATABASE Mans_friends;
```
8. Создать таблицы с иерархией из диаграммы в БД

```sql

USE Mans_friends;


CREATE TABLE class_animal (Id INT AUTO_INCREMENT PRIMARY KEY,
                                                         Class_name VARCHAR(20));


INSERT INTO class_animal (Class_name)
VALUES ('домашние'),
       ('вьючные');


CREATE TABLE pack_animals
  (Id INT AUTO_INCREMENT PRIMARY KEY,
                                 Genus_name VARCHAR (20),
                                            Class_id INT,
   FOREIGN KEY (Class_id) REFERENCES class_animal (Id) ON DELETE CASCADE ON UPDATE CASCADE);


INSERT INTO pack_animals (Genus_name, Class_id)
VALUES ('Лошади', 1),
       ('Верблюды', 1),
       ('Ослы', 1);


CREATE TABLE home_animals
  (Id INT AUTO_INCREMENT PRIMARY KEY,
                                 Genus_name VARCHAR (20),
                                            Class_id INT,
   FOREIGN KEY (Class_id) REFERENCES class_animal (Id) ON DELETE CASCADE ON UPDATE CASCADE);


INSERT INTO home_animals (Genus_name, Class_id)
VALUES ('Собаки', 2),
       ('Кошки', 2),
       ('Хомяки', 2);
```

9. Заполнить низкоуровневые таблицы именами(животных), командами
   которые они выполняют и датами рождения

```sql

CREATE TABLE dogs
  (Id INT AUTO_INCREMENT PRIMARY KEY,
                                 Name VARCHAR(20),
                                      Birthdate DATE, Commands VARCHAR(50),
                                                               Genus_id INT,
   FOREIGN KEY (Genus_id) REFERENCES home_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE);


INSERT INTO dogs (Name, Commands, Birthdate, Genus_id)
VALUES ('Шарик', 'Сидеть', '2015-01-01', 2),
       ('Рекс', 'Апорт', '2016-02-02', 2),
       ('Барбос', 'Лежать', '2017-03-03', 2),
       ('Тузик', 'Фас', '2018-04-04', 2);


CREATE TABLE cats
  (Id INT AUTO_INCREMENT PRIMARY KEY,
                                 Name VARCHAR(20),
                                      Birthdate DATE, Commands VARCHAR(50),
                                                               Genus_id INT,
   FOREIGN KEY (Genus_id) REFERENCES home_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE);


INSERT INTO cats (Name, Commands, Birthdate, Genus_id)
VALUES ('Мурка', 'Ловить мышей', '2018-07-01', 1),
       ('Барсик', 'Дрыхнуть', '2019-04-15', 1),
       ('Матроскин', 'Гулять на улице', '2019-05-05', 1),
       ('Рыжик', 'Мурлыкать', '2020-01-20', 1);


CREATE TABLE hamsters
  (Id INT AUTO_INCREMENT PRIMARY KEY,
                                 Name VARCHAR(20),
                                      Birthdate DATE, Commands VARCHAR(50),
                                                               Genus_id INT,
   FOREIGN KEY (Genus_id) REFERENCES home_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE);


INSERT INTO hamsters (Name, Commands, Birthdate, Genus_id)
VALUES ('Хрум', 'Крутиться в колесе', '2019-10-05', 3),
       ('Булька', 'Кушать семечки', '2020-03-20', 3),
       ('Пушок', 'Спать в гнезде', '2021-01-10', 3),
       ('Лора', NULL, '2022-12-06', 3);


CREATE TABLE horses
  (Id INT AUTO_INCREMENT PRIMARY KEY,
                                 Name VARCHAR(20),
                                      Birthdate DATE, Commands VARCHAR(50),
                                                               Genus_id INT,
   FOREIGN KEY (Genus_id) REFERENCES pack_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE);


INSERT INTO horses (Name, Commands, Birthdate, Genus_id)
VALUES ('Булат', 'Бежать', '2015-06-10', 1),
       ('Рыжик', 'Скачки', '2016-03-14', 1),
       ('Гром', 'шагом', '2021-11-11', 1),
       ('Белка', 'Прыгать через препятствия', '2017-12-22', 1);


CREATE TABLE camels
  (Id INT AUTO_INCREMENT PRIMARY KEY,
                                 Name VARCHAR(20),
                                      Birthdate DATE, Commands VARCHAR(50),
                                                               Genus_id INT,
   FOREIGN KEY (Genus_id) REFERENCES pack_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE);


INSERT INTO camels (Name, Commands, Birthdate, Genus_id)
VALUES ('Али', 'Нести грузы', '2018-08-01', 3),
       ('Мухаммед', 'Бежать по пескам', '2019-05-15', 3),
       ('Халид', 'Выдерживать жару', '2020-02-20', 3),
       ('Земфира', 'Давать молоко', '2019-05-05', 3);


CREATE TABLE donkeys
  (Id INT AUTO_INCREMENT PRIMARY KEY,
                                 Name VARCHAR(20),
                                      Birthdate DATE, Commands VARCHAR(50),
                                                               Genus_id INT,
   FOREIGN KEY (Genus_id) REFERENCES pack_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE);


INSERT INTO donkeys (Name, Commands, Birthdate, Genus_id)
VALUES ('Бони', 'Тащить грузы', '2019-11-05', 2),
       ('Ханна', 'Гулять по горам', '2020-04-20', 2),
       ('Дизи', 'Пости овец', '2020-04-20', 2),
       ('Луна', 'Ходить по узким тропам', '2021-02-10', 2);
```
10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
    питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.

```sql

SET SQL_SAFE_UPDATES = 0;


DELETE
FROM camels;


SELECT Name,
       Commands,
       Birthdate
FROM horses
UNION
SELECT Name,
       Commands,
       Birthdate
FROM donkeys;
```

11. Создать новую таблицу “молодые животные” в которую попадут все
    животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
    до месяца подсчитать возраст животных в новой таблице

```sql

CREATE
TEMPORARY TABLE animals AS
SELECT *,
       'Лошади' AS genus
FROM horses
UNION
SELECT *,
       'Верблюды' AS genus
FROM camels
UNION
SELECT *,
       'Ослы' AS genus
FROM donkeys
UNION
SELECT *,
       'Собаки' AS genus
FROM dogs
UNION
SELECT *,
       'Кошки' AS genus
FROM cats
UNION
SELECT *,
       'Хомяки' AS genus
FROM hamsters;


CREATE TABLE yong_animals AS
SELECT Name,
       Commands,
       Birthdate,
       genus,
       TIMESTAMPDIFF(MONTH, Birthdate, CURDATE()) AS Age_in_month
FROM animals
WHERE Birthdate BETWEEN ADDDATE(curdate(), INTERVAL -3 YEAR) AND ADDDATE(CURDATE(), INTERVAL -1 YEAR);


SELECT *
FROM yong_animals;
```
12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
    прошлую принадлежность к старым таблицам.

```sql

SELECT h.Name,
       h.Birthdate,
       h.Commands,
       pa.Genus_name,
       ya.Age_in_month
FROM horses h
LEFT JOIN yong_animals ya ON ya.Name = h.Name
LEFT JOIN pack_animals pa ON pa.Id = h.Genus_id
UNION
SELECT d.Name,
       d.Birthdate,
       d.Commands,
       pa.Genus_name,
       ya.Age_in_month
FROM donkeys d
LEFT JOIN yong_animals ya ON ya.Name = d.Name
LEFT JOIN pack_animals pa ON pa.Id = d.Genus_id
UNION
SELECT c.Name,
       c.Birthdate,
       c.Commands,
       ha.Genus_name,
       ya.Age_in_month
FROM cats c
LEFT JOIN yong_animals ya ON ya.Name = c.Name
LEFT JOIN home_animals ha ON ha.Id = c.Genus_id
UNION
SELECT d.Name,
       d.Birthdate,
       d.Commands,
       ha.Genus_name,
       ya.Age_in_month
FROM dogs d
LEFT JOIN yong_animals ya ON ya.Name = d.Name
LEFT JOIN home_animals ha ON ha.Id = d.Genus_id
UNION
SELECT hm.Name,
       hm.Birthdate,
       hm.Commands,
       ha.Genus_name,
       ya.Age_in_month
FROM hamsters hm
LEFT JOIN yong_animals ya ON ya.Name = hm.Name
LEFT JOIN home_animals ha ON ha.Id = hm.Genus_id;
```
13. Создать класс с Инкапсуляцией методов и наследованием по диаграмме.

    [Решение здесь:](https://github.com/OlegKhudoerko/Final_control_work/tree/master/src/Encapsulation).

14. Написать программу, имитирующую работу реестра домашних животных.
    В программе должен быть реализован следующий функционал:
    14.1 Завести новое животное
    14.2 определять животное в правильный класс
    14.3 увидеть список команд, которое выполняет животное
    14.4 обучить животное новым командам
    14.5 Реализовать навигацию по меню


15. Создайте класс Счетчик, у которого есть метод add(), увеличивающий̆
    значение внутренней̆ int переменной̆на 1 при нажатие “Завести новое
    животное” Сделайте так, чтобы с объектом такого типа можно было работать в
    блоке try-with-resources. Нужно бросить исключение, если работа с объектом
    типа счетчик была не в ресурсном try и/или ресурс остался открыт. Значение
    считать в ресурсе try, если при заведения животного заполнены все поля
