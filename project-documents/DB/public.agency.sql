CREATE TABLE public.agency (
	id bigint NOT NULL,
	agency_name varchar(50) NULL,
	email varchar(50) NULL,
	address varchar(50) NULL,
	city varchar(50) NULL,
	CONSTRAINT agency_pk PRIMARY KEY (id)
);
insert into public.agency (id, agency_name, email, address, city) values (1, 'McDermott-Reilly', 'pmatieu0@businesswire.com', '4 International Place', 'Sesheke');
insert into public.agency (id, agency_name, email, address, city) values (2, 'Kuhn, Wiegand and Nienow', 'dgosnold1@technorati.com', '97033 Scott Avenue', 'Liugong');
insert into public.agency (id, agency_name, email, address, city) values (3, 'Frami, Bernier and Carter', 'cdelong2@upenn.edu', '57289 Anzinger Drive', 'Klagen');
insert into public.agency (id, agency_name, email, address, city) values (4, 'O''Keefe-Howell', 'lcarbert3@omniture.com', '8 Macpherson Hill', 'Fier');
insert into public.agency (id, agency_name, email, address, city) values (5, 'Rowe, Lebsack and Stamm', 'dkiendl4@businessinsider.com', '385 Caliangt Way', 'Dateng');
insert into public.agency (id, agency_name, email, address, city) values (6, 'Hackett-Sauer', 'hlegen5@domainmarket.com', '51 La Follette Place', 'Baraya');
insert into public.agency (id, agency_name, email, address, city) values (7, 'Durgan, Baumbach and DuBuque', 'gbentham6@slideshare.net', '51487 Meadow Valley Crossing', 'Lanta Timur');
