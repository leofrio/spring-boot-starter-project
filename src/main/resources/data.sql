INSERT INTO users(name, email, pword) VALUES('student', 'student@email.com', '123456');

INSERT INTO courses(name, category) VALUES('Spring Boot', 'programming');
INSERT INTO courses(name, category) VALUES('HTML 5', 'Front-end');

INSERT INTO CATEGORIES(title, message, creation_date, status, user_id, course_id) VALUES('Question', 'cant start project', '2019-05-05 18:00:00', 'NOT_ANSWERED', 1, 1);
INSERT INTO CATEGORIES(title, message, creation_date, status, user_id, course_id) VALUES('Question 2', 'help after section 10 no run', '2019-05-05 19:00:00', 'NOT_ANSWERED', 1, 1);
INSERT INTO CATEGORIES(title, message, creation_date, status, user_id, course_id) VALUES('Question 3', 'html tag', '2019-05-05 20:00:00', 'NOT_ANSWERED', 1, 2);