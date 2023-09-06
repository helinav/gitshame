INSERT INTO public.role (id, name) VALUES (1, 'admin');
INSERT INTO public.role (id, name) VALUES (2, 'player');

INSERT INTO public."user" (id, role_id, username, password, status) VALUES (1, 1, 'admin', 'admin123', 'A');
INSERT INTO public."user" (id, role_id, username, password, status) VALUES (2, 2, 'rasmus', '123', 'A');

INSERT INTO public.game (id, name) VALUES (1, 'Front');
INSERT INTO public.game (id, name) VALUES (2, 'Back');
INSERT INTO public.game (id, name) VALUES (3, 'Cyber');

INSERT INTO public.type (id, name) VALUES (1, 'radio');
INSERT INTO public.type (id, name) VALUES (2, 'checkbox');
INSERT INTO public.type (id, name) VALUES (3, 'sequence');
INSERT INTO public.type (id, name) VALUES (4, 'textbox');

INSERT INTO public.question (id, type_id, game_id, image_id, text, answer_explanation, time_limit) VALUES (1, 1, 2, null, 'Mis on abstraktsioon?', 'Abstraktsioon on programmeerimise põhimõte, mille eesmärk on muuta kood lihtsamini mõistetavaks ja hooldatavaks, vähendades keeruliste teostuse detailide nähtavust.', 30);
INSERT INTO public.question (id, type_id, game_id, image_id, text, answer_explanation, time_limit) VALUES (3, 2, 2, null, 'Millised neist on Java raamistikud?', 'Java raamistikke on palju. Antud küsimuse raames on  eed Spring ja Hibernate.', 30);
INSERT INTO public.question (id, type_id, game_id, image_id, text, answer_explanation, time_limit) VALUES (4, 4, 2, null, 'Millist märksõna kasutatakse Javas, et näidata, et meetod ei tagasta mingit väärtust?', 'Näitamaks, et meetod ei tagasta midagi, kasutatakse sõna void.', 30);
INSERT INTO public.question (id, type_id, game_id, image_id, text, answer_explanation, time_limit) VALUES (5, 3, 2, null, 'Pane sõnad õigesse järjekorda, et tekiks meetod', 'Meetod koosneb neljast osast.', 30);

INSERT INTO public.answer (id, question_id, text, is_correct, sequence) VALUES (1, 1, 'Kogenud arendajate tava luua vajadus võimalikult paljude tähemärkidega muutuja nime tekitamiseks. ', false, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence) VALUES (2, 1, e'Meetod keeruliste koodijuppide lihtsustamiseks.
', false, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence) VALUES (3, 1, e'Tarkvaraviga, mis muudab koodi raskesti arusaadavaks.
', false, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence) VALUES (4, 1, e'Koodi keerulisemate üksikasjade kogum, mis on olulisemate osade sees peidus.
', true, null);

INSERT INTO public.answer (id, question_id, text, is_correct, sequence) VALUES (5, 3, 'Spring', true, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence) VALUES (6, 3, 'Hibernate', true, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence) VALUES (7, 3, 'Sky', false, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence) VALUES (8, 3, 'Winter', false, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence) VALUES (9, 4, 'Void', true, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence) VALUES (10, 5, 'Nähtavus', true, 1);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence) VALUES (11, 5, 'Tagastustüüp', true, 2);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence) VALUES (12, 5, 'Nimi', true, 3);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence) VALUES (13, 5, 'Parameetrid', true, 4);

INSERT INTO public.player (id, image_id, user_id, email) VALUES (1, null, 2, 'example@example.com');
