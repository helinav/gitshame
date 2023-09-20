INSERT INTO public.role (id, name)
VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, name)
VALUES (DEFAULT, 'player');

INSERT INTO public."user" (id, role_id, username, password, status)
VALUES (DEFAULT, 1, 'admin', 'admin123', 'A');
INSERT INTO public."user" (id, role_id, username, password, status)
VALUES (DEFAULT, 2, 'rasmus', '123', 'A');


INSERT INTO public.player (id, image_id, user_id, email)
VALUES (DEFAULT, 2, 2, 'rasmusvark@gitshame.com');


INSERT INTO public.game (id, name)
VALUES (DEFAULT, 'Java ubade espresso');

INSERT INTO public.type (id, name)
VALUES (DEFAULT, 'radio');
INSERT INTO public.type (id, name)
VALUES (DEFAULT, 'checkbox');
INSERT INTO public.type (id, name)
VALUES (DEFAULT, 'sequence');
INSERT INTO public.type (id, name)
VALUES (DEFAULT, 'textbox');

INSERT INTO public.question (id, type_id, game_id, image_id, status, text, answer_explanation, time_limit)
VALUES (DEFAULT, 1, 1, 1, 'A', 'Java programmeerimiskeele algne nimi oli:',
        'Oak tähendab tammepuud, mis sümboliseerib programmeerimiskeele tugevust ja vastupidavust. Java looja Kanada arvutiteadlane James Gosling (s. 1955) valis selle nime, nähes tamme enda akna taga ning leidis, et see sobib hästi nimeks uuele arendamisel olevale keelele. Oak-i nimi muudeti hiljem Java-ks, kuna Oak oli kaubamärgina kasutusel. Nimi Java tuli omakorda Jaava kohvi järgi, mida keele loojad väidetavalt suurtes kogustes tarbisid.',
        60);
INSERT INTO public.question (id, type_id, game_id, image_id, status, text, answer_explanation, time_limit)
VALUES (DEFAULT, 1, 1, 1, 'A', 'Millele viitab error "I am a teapot" (olen teekann) ehk "HTTP status code 418"?',
        '"I am a teapot" või "HTTP status code 418" on pärit Interneti Tehnikastandardite Töörühma (IETF, Internet Engineering Task Force) poolt. See loodi algselt 1998. aastal aprillinaljana ja on osa Hyper Text Coffee Pot Control Protocol (HTCPCP) kirjeldusest. See on mõeldud huumorina ja ei ole tõsine HTTP staatuse kood veebiserveritele. IETF kasutas seda nalja, et rõhutada, et mitte kõik HTTP staatuskoodid ei ole tehnilised või praktilised, vaid mõnikord võib neil olla ka humoorikas või kujundlik tähendus.',
        60);
INSERT INTO public.question (id, type_id, game_id, image_id, status, text, answer_explanation, time_limit)
VALUES (DEFAULT, 4, 1, 1, 'A',
        'Kirjutage lahtrisse Java kood, mis prindiks konsooli väite: Java oad lõhnavad täna eriti hästi!',
        'Õige vastus on: System.out.print("Java oad lõhnavad hästi!"): Väide tuleb lõpetada semikooloniga! Loodetavasti ei vaevunud sa lauset ümber kirjutama, vaid copy-paste’isid selle mängu küsimusest',
        60);
INSERT INTO public.question (id, type_id, game_id, image_id, status, text, answer_explanation, time_limit)
VALUES (DEFAULT, 2, 1, 1, 'A', 'Abstraktsiooni tähendus programmeerimises? Õigeid vastuseid võib olla mitu!',
        'Õiged on vastusevariandid nr 2 ja 4. Selle all mõeldakse lähenemisviisi, kus mingi nähtuse analüüsimisel jäetakse mängust välja selle ebaolulised küljed, mis ei mängi rolli antud probleemi lahendamise kontekstis.',
        60);
INSERT INTO public.question (id, type_id, game_id, image_id, status, text, answer_explanation, time_limit)
VALUES (DEFAULT, 3, 1, 1, 'A', 'Sea õigesse järjekorda järgnevad muutuja osad:',
        'Õige järjekord on muutuja tüüp, nimi, operaator (=) ja siis väärtus. Näiteks: int myBeans = 100;', 60);
INSERT INTO public.question (id, type_id, game_id, image_id, status, text, answer_explanation, time_limit)
VALUES (DEFAULT, 1, 1, 1, 'A', 'Akronüüm "RTFM" tähendus?',
        'See väljend viitab olukorrale, kus inimesed küsivad küsimusi või vajavad abi millegi kasutamisel, kuigi ilmsed vastused või juhised on juba olemas kasutusjuhendites või dokumentatsioonis. Akronüümi kasutatakse tihti kerge frustratsiooni või huumoriga, et rõhutada vajadust enne küsimist ise juhendit lugeda.',
        60);
INSERT INTO public.question (id, type_id, game_id, image_id, status, text, answer_explanation, time_limit)
VALUES (DEFAULT, 2, 1, 1, 'A', 'Millised neist on Java mitte-primitiivsed andmetüübid?',
        'Mitte-primitiivsed on Array ja String. Primitiivsed andmetüübid Java programmeerimiskeeles on baasvormid, mis esindavad lihtsamaid andmeid, nagu numbreid, tähemärke ja tõeväärtusi, samas kui mitte-primitiivsed andmetüübid võimaldavad keerukamate struktuuride loomist, esindades objekte ja nende viiteid, nagu String ja ArrayList.',
        60);
INSERT INTO public.question (id, type_id, game_id, image_id, status, text, answer_explanation, time_limit)
VALUES (DEFAULT, 1, 1, 1, 'A', '"Rubber Duck" debuggimise printsiip?',
        'Rubber duck debugging on tarkvaraarenduse praktika, kus programmeerija selgitab oma koodi või probleemi kummist pardile. See võiks aidata programmeerijal paremini mõista ja leida lahendusi probleemidele, kuna selgitamine sunnib süvenema ja avastama vigu värskema pilgu läbi.',
        60);
INSERT INTO public.question (id, type_id, game_id, image_id, status, text, answer_explanation, time_limit)
VALUES (DEFAULT, 1, 1, 1, 'A', 'Mida tähendab arendajate slängis "YOLO-driven development"?',
        'Riskide võtmine ilma korraliku testimiseta', 60);
INSERT INTO public.question (id, type_id, game_id, image_id, status, text, answer_explanation, time_limit)
VALUES (DEFAULT, 4, 1, 1, 'A',
        'Pildil on Java maskott, kes sai nime Ülikooli järgi, kus Java programmeerimiskeel arendati. Mis on selle 4 tähelise maskoti nimi?',
        'Õige vastus on Duke. Duke''i nimi tuleneb Duke''i Ülikoolist Põhja-Carolinas, kus Java esialgne arendus toimus. Duke on Java arendustiimi üheks sümboliks ja kaubamärgiks. Seda kasutatakse Java sündmustel, konverentsidel ning isegi Java dokumentatsioonis. Kuigi päikesekübaraga antropomorfset kohvitassi kujutav maskott on kasutusel olnud aastakümneid, on selle olemasolu ja tähendus mõistatuseks tihtilugu ka pikaaegsetele Java arendajatele.',
        60);

INSERT INTO public.answer (id, question_id, text, is_correct, sequence)
VALUES (DEFAULT, 1, 'Oak', true, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence)
VALUES (DEFAULT, 1, 'Lisp', false, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence)
VALUES (DEFAULT, 1, 'Ample', false, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence)
VALUES (DEFAULT, 1, 'Coffee', false, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence)
VALUES (DEFAULT, 2, 'See näitab serveri viga, mis on põhjustatud päringu ajalimiidi ületamisest.', false, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence)
VALUES (DEFAULT, 2,
        'Server on ülekoormatud ja olukorra taastumiseni läheb aega. Võid puhata ja endale vahepeal nt teevett keeta.',
        false, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence)
VALUES (DEFAULT, 2, 'Inglismaal päritolu serveri versioon errorist 404 ("Page Not Found").', false, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence)
VALUES (DEFAULT, 2,
        'Viitab, et server on justkui teekann, mis tähendab, et igasugune päring on sobimatu või lihtsalt mõttetu.',
        true, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence)
VALUES (DEFAULT, 3, 'System.out.print("Java oad lõhnavad täna eriti hästi!");', true, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence)
VALUES (DEFAULT, 4,
        'Seenior-arendajate komme luua võimalikult paljude tähemärkidega muutujate nimetusi. Teha isiklikke rekordeid ja üksteist selles osas üle trumbata.',
        false, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence)
VALUES (DEFAULT, 4, 'Olukord, kus koodis loodud mõisteid ja komponente saab korduvalt eri kontekstides kasutada.', true,
        null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence)
VALUES (DEFAULT, 4, 'Tarkvaraviga, mis muudab koodi raskesti arusaadavaks.', false, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence)
VALUES (DEFAULT, 4, 'Süsteemi lihtsustatus, kus olulisemat teavet esitades jäetakse varju vähemoluline.', true, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence)
VALUES (DEFAULT, 5, 'Operator', true, 3);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence)
VALUES (DEFAULT, 5, 'Variable Name', true, 2);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence)
VALUES (DEFAULT, 5, 'Variable Type', true, 1);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence)
VALUES (DEFAULT, 5, 'Variable Value', true, 4);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence)
VALUES (DEFAULT, 6, 'Review the Technical Functionality Manual', false, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence)
VALUES (DEFAULT, 6, 'Read the Full Message', false, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence)
VALUES (DEFAULT, 6, 'Read the First Mention', false, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence)
VALUES (DEFAULT, 6, 'Read the Freaking Manual', true, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence)
VALUES (DEFAULT, 7, 'Array', true, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence)
VALUES (DEFAULT, 7, 'boolen', false, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence)
VALUES (DEFAULT, 7, 'int', false, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence)
VALUES (DEFAULT, 7, 'String', true, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence)
VALUES (DEFAULT, 8,
        'Kus tähelepanu süvendatud fokusseerimiseks koodivea leidmisel, asetatakse enda pealaele pehme kummipart. ',
        false, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence)
VALUES (DEFAULT, 8,
        'Tõrkeotsing, kus te selgitate oma koodiprobleeme lauaserval olevale programmeerimise terapeudiks kehastunud kummist pardile. ',
        true, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence)
VALUES (DEFAULT, 8, 'Debuggimise meetod, kus loobitakse kummist parti nii kaua vastu arvutit kuni see tööle hakkab.',
        false, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence)
VALUES (DEFAULT, 8,
        'Tõrkeotsing, mil kummist pardi võetakse kaasa code review koosolekule, et vaikimisi viidata tiimi tagasihoidlikule tulemusele ja õhutada kõiki senisest rohkem pingutama.',
        false, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence)
VALUES (DEFAULT, 9, 'Riskide võtmine ilma korraliku testimiseta.', true, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence)
VALUES (DEFAULT, 9, 'Koodi arendamine puhtalt lõbu pärast.', false, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence)
VALUES (DEFAULT, 9, 'Tugeva dokumentatsiooni loomine koodi arendamise protsessis', false, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence)
VALUES (DEFAULT, 9, 'Kiirendatud tempos koodi loomine, eesmärgiga olla esimene turul.', false, null);
INSERT INTO public.answer (id, question_id, text, is_correct, sequence)
VALUES (DEFAULT, 10, 'Duke', true, null);

INSERT INTO public.player_game (id, game_id, player_id, score, status, start_time, end_time, strike_count) VALUES (DEFAULT, 1, 1, 0, 'A', '2023-09-20 10:11:43.100666', null, 0);



INSERT INTO public.player_answer (id, question_id, answer_id, is_correct, player_game_id, status, start_time, end_time) VALUES (DEFAULT, 4, null, null, 1, 'N', null, null);
INSERT INTO public.player_answer (id, question_id, answer_id, is_correct, player_game_id, status, start_time, end_time) VALUES (DEFAULT, 5, null, null, 1, 'N', null, null);
INSERT INTO public.player_answer (id, question_id, answer_id, is_correct, player_game_id, status, start_time, end_time) VALUES (DEFAULT, 6, null, null, 1, 'N', null, null);
INSERT INTO public.player_answer (id, question_id, answer_id, is_correct, player_game_id, status, start_time, end_time) VALUES (DEFAULT, 7, null, null, 1, 'N', null, null);
INSERT INTO public.player_answer (id, question_id, answer_id, is_correct, player_game_id, status, start_time, end_time) VALUES (DEFAULT, 8, null, null, 1, 'N', null, null);
INSERT INTO public.player_answer (id, question_id, answer_id, is_correct, player_game_id, status, start_time, end_time) VALUES (DEFAULT, 9, null, null, 1, 'N', null, null);
INSERT INTO public.player_answer (id, question_id, answer_id, is_correct, player_game_id, status, start_time, end_time) VALUES (DEFAULT, 10, null, null, 1, 'N', null, null);
INSERT INTO public.player_answer (id, question_id, answer_id, is_correct, player_game_id, status, start_time, end_time) VALUES (DEFAULT, 2, null, null, 1, 'N', null, null);
INSERT INTO public.player_answer (id, question_id, answer_id, is_correct, player_game_id, status, start_time, end_time) VALUES (DEFAULT, 3, null, null, 1, 'N', null, null);
INSERT INTO public.player_answer (id, question_id, answer_id, is_correct, player_game_id, status, start_time, end_time) VALUES (DEFAULT, 1, null, null, 1, 'N', null, null);
