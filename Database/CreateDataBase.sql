
CREATE SEQUENCE public.role_role_id_seq;

CREATE TABLE public.role (
                role_id INTEGER NOT NULL DEFAULT nextval('public.role_role_id_seq'),
                role_name VARCHAR(25) NOT NULL,
                CONSTRAINT role_pk PRIMARY KEY (role_id)
);


ALTER SEQUENCE public.role_role_id_seq OWNED BY public.role.role_id;

CREATE SEQUENCE public.address_address_id_seq;

CREATE TABLE public.address (
                address_id INTEGER NOT NULL DEFAULT nextval('public.address_address_id_seq'),
                line1 VARCHAR(200) NOT NULL,
                line2 VARCHAR(200),
                line3 VARCHAR(200),
                city VARCHAR(100) NOT NULL,
                zip_code VARCHAR(5) NOT NULL,
                CONSTRAINT address_pk PRIMARY KEY (address_id)
);


ALTER SEQUENCE public.address_address_id_seq OWNED BY public.address.address_id;

CREATE SEQUENCE public.users_user_id_seq;

CREATE TABLE public.users (
                user_id INTEGER NOT NULL DEFAULT nextval('public.users_user_id_seq'),
                password VARCHAR(100) NOT NULL,
                email VARCHAR(100) NOT NULL,
                login VARCHAR(30) NOT NULL,
                phone VARCHAR(10),
                address_id INTEGER NOT NULL,
                CONSTRAINT users_pk PRIMARY KEY (user_id)
);


ALTER SEQUENCE public.users_user_id_seq OWNED BY public.users.user_id;

CREATE TABLE public.user_roles (
                role_id INTEGER NOT NULL,
                user_id INTEGER NOT NULL,
                CONSTRAINT user_roles_pk PRIMARY KEY (role_id, user_id)
);


CREATE SEQUENCE public.publisher_publisher_id_seq;

CREATE TABLE public.publisher (
                publisher_id INTEGER NOT NULL DEFAULT nextval('public.publisher_publisher_id_seq'),
                name VARCHAR(100) NOT NULL,
                CONSTRAINT publisher_pk PRIMARY KEY (publisher_id)
);


ALTER SEQUENCE public.publisher_publisher_id_seq OWNED BY public.publisher.publisher_id;

CREATE SEQUENCE public.genre_genre_id_seq;

CREATE TABLE public.genre (
                genre_id INTEGER NOT NULL DEFAULT nextval('public.genre_genre_id_seq'),
                name VARCHAR(50) NOT NULL,
                CONSTRAINT genre_pk PRIMARY KEY (genre_id)
);


ALTER SEQUENCE public.genre_genre_id_seq OWNED BY public.genre.genre_id;

CREATE SEQUENCE public.author_author_id_seq;

CREATE TABLE public.author (
                author_id INTEGER NOT NULL DEFAULT nextval('public.author_author_id_seq'),
                first_name VARCHAR(50) NOT NULL,
                last_name VARCHAR(50) NOT NULL,
                CONSTRAINT author_pk PRIMARY KEY (author_id)
);


ALTER SEQUENCE public.author_author_id_seq OWNED BY public.author.author_id;

CREATE SEQUENCE public.book_book_id_seq;

CREATE TABLE public.book (
                book_id INTEGER NOT NULL DEFAULT nextval('public.book_book_id_seq'),
                title VARCHAR(150) NOT NULL,
                ISBN13 VARCHAR(17) NOT NULL,
                EAN13 VARCHAR(13) NOT NULL,
                publishing_date DATE NOT NULL,
                resume VARCHAR(5000) NOT NULL,
                genre_id INTEGER NOT NULL,
                publisher_id INTEGER NOT NULL,
                CONSTRAINT book_pk PRIMARY KEY (book_id)
);


ALTER SEQUENCE public.book_book_id_seq OWNED BY public.book.book_id;

CREATE TABLE public.book_borrowed (
                user_id INTEGER NOT NULL,
                book_id INTEGER NOT NULL,
                end_date DATE NOT NULL,
                borrow_date DATE NOT NULL,
                extension BOOLEAN DEFAULT false NOT NULL,
                nb_reminder INTEGER DEFAULT 0 NOT NULL,
                returned BOOLEAN NOT NULL,
                last_reminder DATE,
                CONSTRAINT book_borrowed_pk PRIMARY KEY (user_id, book_id)
);


CREATE TABLE public.book_authors (
                book_id INTEGER NOT NULL,
                author_id INTEGER NOT NULL,
                CONSTRAINT book_authors_pk PRIMARY KEY (book_id, author_id)
);


CREATE SEQUENCE public.stock_stock_id_seq;

CREATE TABLE public.stock (
                stock_id INTEGER NOT NULL DEFAULT nextval('public.stock_stock_id_seq'),
                book_id INTEGER NOT NULL,
                amount_available INTEGER NOT NULL,
                amount INTEGER NOT NULL,
                CONSTRAINT stock_pk PRIMARY KEY (stock_id)
);


ALTER SEQUENCE public.stock_stock_id_seq OWNED BY public.stock.stock_id;

ALTER TABLE public.user_roles ADD CONSTRAINT role_user_roles_fk
FOREIGN KEY (role_id)
REFERENCES public.role (role_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.users ADD CONSTRAINT adress_user_fk
FOREIGN KEY (address_id)
REFERENCES public.address (address_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.user_roles ADD CONSTRAINT user_user_roles_fk
FOREIGN KEY (user_id)
REFERENCES public.users (user_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.book_borrowed ADD CONSTRAINT user_book_borrowed_fk
FOREIGN KEY (user_id)
REFERENCES public.users (user_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.book ADD CONSTRAINT publisher_book_fk
FOREIGN KEY (publisher_id)
REFERENCES public.publisher (publisher_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.book ADD CONSTRAINT genre_book_fk
FOREIGN KEY (genre_id)
REFERENCES public.genre (genre_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.book_authors ADD CONSTRAINT author_book_authors_fk
FOREIGN KEY (author_id)
REFERENCES public.author (author_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.stock ADD CONSTRAINT book_stock_fk
FOREIGN KEY (book_id)
REFERENCES public.book (book_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.book_authors ADD CONSTRAINT book_book_authors_fk
FOREIGN KEY (book_id)
REFERENCES public.book (book_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.book_borrowed ADD CONSTRAINT book_book_borrowed_fk
FOREIGN KEY (book_id)
REFERENCES public.book (book_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
