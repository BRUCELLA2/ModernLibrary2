/* INSERT INTO author TABLE */
INSERT INTO public.author(author_id, first_name, last_name)	
	VALUES 
		(DEFAULT, 'Fred', 'Truics'),
		(DEFAULT, 'Cario', 'Rovelli'),
		(DEFAULT, 'Daniel', 'Whiteson'),
		(DEFAULT, 'Isaac', 'Asimov'),
		(DEFAULT, 'Peter F.', 'Hamilton'),
		(DEFAULT, 'James S.A.', 'Corey'),
		(DEFAULT, 'Jorge', 'Cham');

/* INSERT INTO genre TABLE */
INSERT INTO public.genre(genre_id, name)
	VALUES 
		(DEFAULT, 'Science Fiction'),
		(DEFAULT, 'Policier'),
		(DEFAULT, 'Fantastique'),
		(DEFAULT, 'Romance'),
		(DEFAULT, 'Historique');

/* INSERT INTO publisher TABLE */
INSERT INTO public.publisher(publisher_id, name)
	VALUES 
		(DEFAULT, 'Milady'),
		(DEFAULT, 'Flammarion'),
		(DEFAULT, 'Pocket'),
		(DEFAULT, 'Actes sud');

/* INSERT INTO book TABLE */
INSERT INTO public.book(book_id, title, isbn13, ean13, publishing_date, resume, genre_id, publisher_id)
	VALUES 
		(DEFAULT, 'La Porte d''Abaddon', '978-2-330-09699-1', '9782330096991', '2018-03-07', 'Pendant des générations, le système solaire – Mars, la Lune, la ceinture d’astéroïdes – fut la grande frontière de l’humanité. Jusqu’à maintenant. Un objet non identifié opérant sous les nuages de Vénus est apparu dans l’orbite d’Uranus, où il a construit une porte massive qui mène à un hyperespace désolé.
Jim Holden et l’équipage du Rossinante font partie d’une vaste flotte de navires scientifiques et militaires chargés d’examiner le phénomène. Mais une intrigue complexe se trame dans leur dos, visant à l’élimination pure et simple d’Holden. Les émissaires de la race humaine en sont à devoir décider si la porte est une opportunité ou une menace, sans imaginer que le plus grand danger est peutêtre celui qu’ils ont apporté avec eux.
La Porte d’Abaddon est le troisième volet de la désormais célèbre série The Expanse, plus explosive que jamais.', 1, 4),
		(DEFAULT, 'Pandore abusée', '978-2-8112-0007-7', '9782811200077', '2008-06-05', 'En 2380, l''humanité a colonisé six cents planètes, toutes reliées entre elles par des trous de ver. Le Commonwealth Intersolaire s''est développé en une société tranquille et prospère, dans laquelle la " réjuvénation " permet à chaque citoyen de vivre pendant des siècles. C''est alors qu''un astronome est témoin d''un incroyable événement cosmique : la disparition d''une étoile à un millier d''années-lumière, emprisonnée dans un champ de force d''une taille gigantesque. Le Commonwealth décide d''en savoir plus. Contre l''avis d''une partie de l''opinion, il construit le premier vaisseau spatial plus rapide que la lumière : la Seconde Chance. Sa mission sera de découvrir quelle menace pèse sur l''espèce humaine... L''Etoile de Pandore est un space opera grandiose en quatre volumes, dont voici le premier.', 1, 3),
		(DEFAULT, 'Tout ce que nous ne savons pas encore', '978-2-0814-2225-4', '9782081422254', '2018-03-28', 'Pas une année sans que les prédictions des physiciens ne soient vérifiées, de l''existence du boson de Higgs à celle des ondes gravitationnelles. Cette victoire cache pourtant une surprenante vérité: nous ne savons rien (ou presque) ! Des exemples ? La composition de 95 % de l''Univers reste une énigme, tout comme ce qu''il s''est vraiment passé durant le Big Bang. Et pourquoi est-il impossible d''aller plus vite que la lumière ? Pourquoi la gravitation est-elle 10^36 fois moins intense que les autres interactions ? Quelle est l''origine des rayons cosmiques qui bombardent la Terre en permanence ? Mystère ! Non content d''exposer avec la plus grande clarté le peu que nous savons déjà sur l''infiniment petit et l''infiniment grand, cet ouvrage fait le point sur les grands défis lancés à la science. Il reste tant à découvrir... et c''est heureux !',  5, 2);

/* INSERT INTO book_authors TABLE */
INSERT INTO public.book_authors(book_id, author_id)
	VALUES 
		(1, 6),
		(2, 5),
		(3, 3),
		(3, 7);

/* INSERT INTO address TABLE */
INSERT INTO public.address(address_id, line1, line2, line3, city, zip_code)
	VALUES 
		(DEFAULT, '191 avenue de Villeuneve', 'Bat C', '', 'Montpellier', '34000'),
		(DEFAULT, '235 rue Paul Bringuier', '', '', 'Montpellier', '34080'),
		(DEFAULT, '12 Boulevard de la clarté', 'Résidence du Frêne', '', 'Nimes', '31000');

/* INSERT INTO users TABLE */
INSERT INTO public.users(user_id, password, email, login, phone, address_id)
	VALUES 
		(DEFAULT, 'pass1', 'user1@gmail.com', 'user1', '0102030405', 1),
		(DEFAULT, 'fredpass', 'fred@gmail.com', 'fred', '0504030201', 2),
		(DEFAULT, 'bobpass', 'bob@hotmail.com', 'bob', '0123456789', 3);

/* INSERT INTO role TABLE */
INSERT INTO public.role(role_id, role_name)
	VALUES 
		(DEFAULT, 'Admin'),
		(DEFAULT, 'Employé');

/* INSERT INTO user_roles TABLE */
INSERT INTO public.user_roles(role_id, user_id)
	VALUES 
		(1, 2),
		(2, 2),
		(2, 1);

/* INSERT INTO book_borrowed TABLE */ 
INSERT INTO public.book_borrowed(book_borrowed_id, user_id, book_id, end_date, borrow_date, extension, nb_reminder, returned, last_reminder)
	VALUES 
		(DEFAULT, 1, 2, '2018-08-01', '2018-07-01', true, 0, false, null),
		(DEFAULT, 1, 1, '2018-01-15', '2017-10-03', false, 2, true, '2018-01-10'),
		(DEFAULT, 2, 3, '2018-08-15', '2018-07-10', false, 0, false, null),
		(DEFAULT, 3, 1, '2018-09-04', '2018-07-11', true, 0, false, null),
		(DEFAULT, 3, 2, '2018-07-04', '2018-06-11', true, 1, false, '2018-07-01');

/* INSERT INTO stock TABLE */
INSERT INTO public.stock(stock_id, book_id, amount_available, amount)
	VALUES 
		(DEFAULT, 1, 8, 10),
		(DEFAULT, 2, 4, 5),
		(DEFAULT, 3, 14, 15);