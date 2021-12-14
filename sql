create sequence authors_a_id_seq
	as integer;

alter sequence authors_a_id_seq owner to mongol;

create sequence printed_products_pr_pr_id_seq
	as integer;

alter sequence printed_products_pr_pr_id_seq owner to mongol;

create sequence types_t_id_seq
	as integer;

alter sequence types_t_id_seq owner to mongol;

create table if not exists authors
(
	id integer default nextval('authors_a_id_seq'::regclass) not null
		constraint authors_pkey
			primary key,
	name varchar(255)
);

alter table authors owner to mongol;

alter sequence authors_a_id_seq owned by authors.id;

create table if not exists types
(
	id integer default nextval('types_t_id_seq'::regclass) not null
		constraint types_pkey
			primary key,
	name varchar(255)
);

alter table types owner to mongol;

alter sequence types_t_id_seq owned by types.id;

create table if not exists printed_products
(
	id integer default nextval('printed_products_pr_pr_id_seq'::regclass) not null
		constraint printed_products_pkey
			primary key,
	name varchar(255),
	author_id integer
		constraint fkhgweef3cya1go670281kfs3yw
			references authors,
	type_id integer
		constraint fk5s2b3kp96jix1n8an5e3yg3tu
			references types
);

alter table printed_products owner to mongol;

alter sequence printed_products_pr_pr_id_seq owned by printed_products.id;

