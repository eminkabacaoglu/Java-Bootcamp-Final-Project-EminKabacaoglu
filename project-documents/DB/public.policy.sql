CREATE TABLE public.policy (
	id bigint NOT NULL,
	"name" varchar(50) NULL,
	status bool NULL DEFAULT true,
	CONSTRAINT policy_pk PRIMARY KEY (id)
);

insert into public.policy (id, name,status) values (1, 'Health Insurance', true);
insert into public.policy (id, name,status) values (2, 'Life Insurance', true);
insert into public.policy (id, name,status) values (3, 'Accident Insurance', true);
insert into public.policy (id, name,status) values (4, 'Property Insurance', true);
insert into public.policy (id, name,status) values (5, 'Traffic Insurance', false);