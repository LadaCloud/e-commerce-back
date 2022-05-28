CREATE TABLE category (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    code VARCHAR(255) UNIQUE NOT NULL,
    short_description TEXT,
    study_guide TEXT,
    active BOOLEAN,
    order_visualization SMALLINT UNSIGNED,
    image_url VARCHAR(255),
    color_code VARCHAR(7)
);

CREATE TABLE subcategory (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    code VARCHAR(255) UNIQUE NOT NULL,
    short_description TEXT,
    study_guide TEXT,
    active BOOLEAN,
    order_visualization SMALLINT UNSIGNED,
    category_id BIGINT NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE instructor (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE course (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    code VARCHAR(255) UNIQUE NOT NULL,
    estimated_time_in_hours TINYINT UNSIGNED,
    visibility BOOLEAN,
    target_audience TEXT,
    resume TEXT,
    developed_skills TEXT,
    instructor_id BIGINT NOT NULL,
    subcategory_id BIGINT NOT NULL,
    FOREIGN KEY (instructor_id) REFERENCES instructor(id),
    FOREIGN KEY (subcategory_id) REFERENCES subcategory(id)
);

CREATE TABLE section (
      id BIGINT AUTO_INCREMENT PRIMARY KEY,
      name VARCHAR(255) NOT NULL,
      code VARCHAR(255) UNIQUE NOT NULL,
      order_visualization TINYINT UNSIGNED,
      active BOOLEAN,
      test BOOLEAN,
      course_id BIGINT NOT NULL,
      FOREIGN KEY (course_id) REFERENCES course(id)
);

CREATE TABLE video (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    code VARCHAR(255) UNIQUE NOT NULL,
    url VARCHAR(255) NOT NULL,
    duration_in_minutes SMALLINT,
    transcription TEXT,
    section_id BIGINT NOT NULL,
    FOREIGN KEY (section_id) REFERENCES section(id)
);

CREATE TABLE explanation (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    code VARCHAR(255) UNIQUE NOT NULL,
    text VARCHAR(255) NOT NULL,
    section_id BIGINT NOT NULL,
    FOREIGN KEY (section_id) REFERENCES section(id)
);

CREATE TABLE question (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    code VARCHAR(255) UNIQUE NOT NULL,
    enunciation VARCHAR(255) NOT NULL,
    type ENUM('SINGLE_ANSWER', 'MULTIPLE_ANSWERS', 'TRUE_OR_FALSE') DEFAULT 'SINGLE_ANSWER',
    section_id BIGINT NOT NULL,
    FOREIGN KEY (section_id) REFERENCES section(id)
);

CREATE TABLE alternative (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    text VARCHAR(255) UNIQUE NOT NULL,
    order_visualization TINYINT UNSIGNED,
    is_correct BOOLEAN,
    justification VARCHAR(255),
    question_id BIGINT NOT NULL,
    FOREIGN KEY (question_id) REFERENCES question(id)
);