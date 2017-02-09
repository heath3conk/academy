ALTER TABLE courses ADD teacher_id INT NOT NULL;
ALTER TABLE courses ADD CONSTRAINT fk_teacher_id FOREIGN KEY (teacher_id) REFERENCES teachers(id);