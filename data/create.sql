-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-09-06 07:22:02.973

-- tables
-- Table: answer
CREATE TABLE answer (
    id serial  NOT NULL,
    question_id int  NOT NULL,
    text varchar(255)  NOT NULL,
    is_correct boolean  NOT NULL,
    sequence int  NULL,
    CONSTRAINT answer_pk PRIMARY KEY (id)
);

-- Table: game
CREATE TABLE game (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    CONSTRAINT game_pk PRIMARY KEY (id)
);

-- Table: image
CREATE TABLE image (
    id serial  NOT NULL,
    data bytea  NOT NULL,
    status char(1)  NOT NULL,
    CONSTRAINT image_pk PRIMARY KEY (id)
);

-- Table: player
CREATE TABLE player (
    id serial  NOT NULL,
    image_id int  NOT NULL,
    user_id int  NOT NULL,
    email varchar(255)  NOT NULL,
    CONSTRAINT player_pk PRIMARY KEY (id)
);

-- Table: player_answers
CREATE TABLE player_answers (
    id serial  NOT NULL,
    question_id int  NOT NULL,
    player_game_id int  NOT NULL,
    start_time timestamp  NOT NULL,
    end_time timestamp  NULL,
    CONSTRAINT player_answers_pk PRIMARY KEY (id)
);

-- Table: player_game
CREATE TABLE player_game (
    id serial  NOT NULL,
    game_id int  NOT NULL,
    player_id int  NOT NULL,
    score int  NOT NULL DEFAULT 0,
    status char(1)  NOT NULL,
    start_time timestamp  NOT NULL,
    end_time timestamp  NULL,
    strike_count int  NOT NULL,
    CONSTRAINT player_game_pk PRIMARY KEY (id)
);

-- Table: question
CREATE TABLE question (
    id serial  NOT NULL,
    type_id int  NOT NULL,
    game_id int  NOT NULL,
    image_id int  NULL,
    text varchar(255)  NOT NULL,
    answer_explanation varchar(255)  NOT NULL,
    time_limit int  NOT NULL,
    CONSTRAINT question_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: type
CREATE TABLE type (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    CONSTRAINT type_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
    id serial  NOT NULL,
    role_id int  NOT NULL,
    username varchar(255)  NOT NULL,
    password varchar(255)  NOT NULL,
    status char(1)  NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: answer_question (table: answer)
ALTER TABLE answer ADD CONSTRAINT answer_question
    FOREIGN KEY (question_id)
    REFERENCES question (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: player_answers_player_game (table: player_answers)
ALTER TABLE player_answers ADD CONSTRAINT player_answers_player_game
    FOREIGN KEY (player_game_id)
    REFERENCES player_game (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: player_answers_question (table: player_answers)
ALTER TABLE player_answers ADD CONSTRAINT player_answers_question
    FOREIGN KEY (question_id)
    REFERENCES question (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: player_game_game (table: player_game)
ALTER TABLE player_game ADD CONSTRAINT player_game_game
    FOREIGN KEY (game_id)
    REFERENCES game (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: player_game_player (table: player_game)
ALTER TABLE player_game ADD CONSTRAINT player_game_player
    FOREIGN KEY (player_id)
    REFERENCES player (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: player_image (table: player)
ALTER TABLE player ADD CONSTRAINT player_image
    FOREIGN KEY (image_id)
    REFERENCES image (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: player_user (table: player)
ALTER TABLE player ADD CONSTRAINT player_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: question_game (table: question)
ALTER TABLE question ADD CONSTRAINT question_game
    FOREIGN KEY (game_id)
    REFERENCES game (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: question_image (table: question)
ALTER TABLE question ADD CONSTRAINT question_image
    FOREIGN KEY (image_id)
    REFERENCES image (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: question_type (table: question)
ALTER TABLE question ADD CONSTRAINT question_type
    FOREIGN KEY (type_id)
    REFERENCES type (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_role (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_role
    FOREIGN KEY (role_id)
    REFERENCES role (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

