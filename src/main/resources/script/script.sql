CREATE TABLE IF NOT EXISTS instructors(
    instructor_id SERIAL PRIMARY KEY ,
    instructor_name varchar(30),
    email varchar(50)
) ;

CREATE TABLE IF NOT EXISTS courses(
    course_id SERIAL PRIMARY KEY ,
    course_name varchar(30),
    description varchar(100),
    instructor_id int,
    FOREIGN KEY (instructor_id) REFERENCES instructors(instructor_id)
                    ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS students(
                         student_id SERIAL PRIMARY KEY ,
                         student_name varchar(30),
                         email varchar(50),
                         phone_number varchar(15)
);

CREATE TABLE IF NOT EXISTS student_course(
    id SERIAL PRIMARY KEY ,
    student_id int,
    course_id int,
    FOREIGN KEY (student_id) REFERENCES students(student_id)
        ON DELETE CASCADE ON UPDATE CASCADE ,
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

SELECT *
FROM courses c
INNER JOIN instructors i
    ON c.instructor_id = i.instructor_id
INNER JOIN students st
    ON st.student_id = c.course_id;

SELECT * FROM instructors WHERE instructor_id=1;

INSERT INTO instructors VALUES (DEFAULT,'william','william@gmail.com') RETURNING instructor_id;

SELECT s.student_id,s.student_name,sc.course_id
FROM students s
INNER JOIN student_course sc on s.student_id = sc.student_id
WHERE s.student_id = 1;

-- DROP TABLE instructors;
-- DROP TABLE student_course;
-- DROP TABLE courses;
-- DROP TABLE students;
