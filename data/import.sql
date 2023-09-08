INSERT INTO public.role (id, name) VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'player');

INSERT INTO public."user" (id, role_id, username, password, status) VALUES (DEFAULT, 1, 'admin', 'admin123', 'A');
INSERT INTO public."user" (id, role_id, username, password, status) VALUES (DEFAULT, 2, 'rasmus', '123', 'A');

INSERT INTO public.game (id, name) VALUES (DEFAULT, 'Front');
INSERT INTO public.game (id, name) VALUES (DEFAULT, 'Back');
INSERT INTO public.game (id, name) VALUES (DEFAULT, 'Cyber');

INSERT INTO public.type (id, name) VALUES (DEFAULT, 'radio');
INSERT INTO public.type (id, name) VALUES (DEFAULT, 'checkbox');
INSERT INTO public.type (id, name) VALUES (DEFAULT, 'sequence');
INSERT INTO public.type (id, name) VALUES (DEFAULT, 'textbox');

INSERT INTO public.question (id, type_id, game_id, image_id, text, answer_explanation, time_limit) VALUES (DEFAULT, 1, 2, null, 'Mis on abstraktsioon?', 'Abstraktsioon on programmeerimise põhimõte, mille eesmärk on muuta kood lihtsamini mõistetavaks ja hooldatavaks, vähendades keeruliste teostuse detailide nähtavust.', 30);
INSERT INTO public.question (id, type_id, game_id, image_id, text, answer_explanation, time_limit) VALUES (DEFAULT, 2, 2, null, 'Millised neist on Java raamistikud?', 'Java raamistikke on palju. Antud küsimuse raames on  eed Spring ja Hibernate.', 30);
INSERT INTO public.question (id, type_id, game_id, image_id, text, answer_explanation, time_limit) VALUES (DEFAULT, 4, 2, null, 'Millist märksõna kasutatakse Javas, et näidata, et meetod ei tagasta mingit väärtust?', 'Näitamaks, et meetod ei tagasta midagi, kasutatakse sõna void.', 30);
INSERT INTO public.question (id, type_id, game_id, image_id, text, answer_explanation, time_limit) VALUES (DEFAULT, 3, 2, null, 'Pane sõnad õigesse järjekorda, et tekiks meetod', 'Meetod koosneb neljast osast.', 30);

INSERT INTO public.answer (id, question_id, text, is_correct, sequence) VALUES (DEFAULT, 1, 'Kogenud arendajate tava luua vajadus võimalikult paljude tähemärkidega muutuja nime tekitamiseks. ', false, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence) VALUES (DEFAULT, 1, e'Meetod keeruliste koodijuppide lihtsustamiseks.
', false, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence) VALUES (DEFAULT, 1, e'Tarkvaraviga, mis muudab koodi raskesti arusaadavaks.
', false, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence) VALUES (DEFAULT, 1, e'Koodi keerulisemate üksikasjade kogum, mis on olulisemate osade sees peidus.
', true, null);

INSERT INTO public.answer (id, question_id, text, is_correct, sequence) VALUES (DEFAULT, 2, 'Spring', true, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence) VALUES (DEFAULT, 2, 'Hibernate', true, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence) VALUES (DEFAULT, 2, 'Sky', false, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence) VALUES (DEFAULT, 2, 'Winter', false, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence) VALUES (DEFAULT, 3, 'Void', true, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence) VALUES (DEFAULT, 4, 'Nähtavus', true, 1);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence) VALUES (DEFAULT, 4, 'Tagastustüüp', true, 2);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence) VALUES (DEFAULT, 4, 'Nimi', true, 3);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence) VALUES (DEFAULT, 4, 'Parameetrid', true, 4);

