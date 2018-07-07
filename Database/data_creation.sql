/* INSERT INTO author TABLE */
INSERT INTO public.author(author_id, first_name, last_name)	
	VALUES 
		(DEFAULT, 'Fred', 'Truics'),
		(DEFAULT, 'Cario', 'Rovelli'),
		(DEFAULT, 'Daniel', 'Whiteson'),
		(DEFAULT, 'Isaac', 'Asimov'),
		(DEFAULT, 'Peter F.', 'Hamilton'),
		(DEFAULT, 'James S.A.', 'Corey');

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
		(DEFAULT, 'La Porte d''Abaddon', '978-2-330-09699-1', '9782330096991', '', ?, ?, ?);