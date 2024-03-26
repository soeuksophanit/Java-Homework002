CREATE TABLE instructors(
    instructor_id SERIAL PRIMARY KEY ,
    instructor_name varchar(30),
    email varchar(50)
) ;

CREATE TABLE courses(
    course_id SERIAL PRIMARY KEY ,
    course_name varchar(30),
    description varchar(100),
    instructor_id int,
    FOREIGN KEY (instructor_id) REFERENCES instructors(instructor_id)
);

CREATE TABLE student_course(
    id SERIAL PRIMARY KEY ,
    student_id int,
    course_id int,
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);

SELECT *
FROM courses c
INNER JOIN instructors i
    ON c.instructor_id = i.instructor_id
INNER JOIN students st
    ON st.student_id = c.course_id;

SELECT * FROM instructors WHERE instructor_id=1;

INSERT INTO instructors VALUES (DEFAULT,'william','william@gmail.com') RETURNING instructor_id
