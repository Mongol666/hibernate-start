create table authors
(
    a_id   integer default nextval('authors_id_seq'::regclass) not null
        constraint authors_pk
            primary key,
    a_name varchar(20)                                         not null
);

alter table authors
    owner to mongol;

create unique index authors_id_uindex
    on authors (a_id);

create table types
(
    t_id   integer default nextval('types_id_seq'::regclass) not null
        constraint types_pk
            primary key,
    t_name varchar(20)                                       not null
);

alter table types
    owner to mongol;

create table printed_products
(
    pr_pr_id   integer default nextval('printed_products_id_seq'::regclass) not null
        constraint printed_products_pk
            primary key,
    pr_pr_name varchar(20)                                                  not null,
    author_id  integer                                                      not null
        constraint author__fk
            references authors,
    type_id    integer                                                      not null
        constraint type__fk
            references types
);

alter table printed_products
    owner to mongol;

create unique index printed_products_id_uindex
    on printed_products (pr_pr_id);

create unique index types_id_uindex
    on types (t_id);

