CREATE TABLE `courses` (
  `id`         INT            NOT NULL  AUTO_INCREMENT,
  `version`    INT            NOT NULL  DEFAULT 0,
  `name`       VARCHAR(255)   NOT NULL,
  `semester`   DATE           NOT NULL,
  `credits`    INT            NOT NULL DEFAULT 1,
  `department` ENUM('PHYSICS', 'ENGINEERING', 'AERONAUTICS', 'BASKETWEAVING', 'CARPENTRY') NOT NULL,
  `fee`        DECIMAL(12, 2) NOT NULL,
  `created`    TIMESTAMP      NOT NULL  DEFAULT NOW(),
  `modified`   TIMESTAMP      NOT NULL  DEFAULT NOW(),
  PRIMARY KEY (`id`));