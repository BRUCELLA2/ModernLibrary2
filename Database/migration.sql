/* User options */
CREATE SEQUENCE public.user_options_user_options_id_seq;

CREATE TABLE public.user_options (
                user_options_id INTEGER NOT NULL DEFAULT nextval('public.user_options_user_options_id_seq'),
                before_reminder BOOLEAN NOT NULL,
                CONSTRAINT user_options_pk PRIMARY KEY (user_options_id)
);

ALTER SEQUENCE public.user_options_user_options_id_seq OWNED BY public.user_options.user_options_id;

/* ajouter le not null plus tard */
ALTER TABLE public.users ADD COLUMN user_options_id INTEGER;

/* Migration */
insert into public.user_options (user_options_id, before_reminder) select user_id, true from users;
select setval('user_options_user_options_id_seq',(select max(user_options_id) from user_options));
update users set user_options_id = user_id;

	


/* Reservation */
CREATE SEQUENCE public.book_reservation_book_reservation_id_seq;

CREATE TABLE public.book_reservation (
                book_reservation_id INTEGER NOT NULL DEFAULT nextval('public.book_reservation_book_reservation_id_seq'),
                book_id INTEGER NOT NULL,
                user_id INTEGER NOT NULL,
                date_reservation TIMESTAMP NOT NULL,
                date_reservation_email_send TIMESTAMP,
                active_reservation BOOLEAN NOT NULL,
                CONSTRAINT book_reservation_pk PRIMARY KEY (book_reservation_id)
);


ALTER SEQUENCE public.book_reservation_book_reservation_id_seq OWNED BY public.book_reservation.book_reservation_id;




ALTER TABLE public.users ADD CONSTRAINT user_options_users_fk
FOREIGN KEY (user_options_id)
REFERENCES public.user_options (user_options_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;


ALTER TABLE public.book_reservation ADD CONSTRAINT users_book_reservation_fk
FOREIGN KEY (user_id)
REFERENCES public.users (user_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;


ALTER TABLE public.book_reservation ADD CONSTRAINT book_book_reservation_fk
FOREIGN KEY (book_id)
REFERENCES public.book (book_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;