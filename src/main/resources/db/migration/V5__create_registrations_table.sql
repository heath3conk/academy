CREATE TABLE `registrations` (
  `id`         INT            NOT NULL  AUTO_INCREMENT,
  `version`    INT            NOT NULL  DEFAULT 0,
  `student_id` INT            NOT NULL,
  `course_id`   INT            NOT NULL,
  `created`    TIMESTAMP      NOT NULL  DEFAULT NOW(),
  `modified`   TIMESTAMP      NOT NULL  DEFAULT NOW(),
  PRIMARY KEY (`id`),

  CONSTRAINT `fk_student_id`
  FOREIGN KEY (`student_id`)
    REFERENCES `students` (`id`),

  CONSTRAINT `fk_course_id`
  FOREIGN KEY (`course_id`)
    REFERENCES `courses` (`id`)
);