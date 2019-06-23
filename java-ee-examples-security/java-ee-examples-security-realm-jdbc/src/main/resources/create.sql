CREATE SEQUENCE seq_account
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE "public"."account" (
    "id" bigint DEFAULT nextval('seq_account'::regclass),
    "email" character varying(80) NOT NULL,
    "username" character varying(25) NOT NULL,
    "password" character varying(100) NOT NULL,
    "firstname" character varying(100) NOT NULL,
    "active" boolean NOT NULL,
    "created" timestamp NOT NULL,
    "updated" timestamp,
    "lastname" character varying(100) NOT NULL,
    PRIMARY KEY ("id")
);


CREATE SEQUENCE seq_role
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE "public"."role" (
    "id" bigint DEFAULT nextval('seq_role'::regclass),
    "role_name" character varying(100) NOT NULL,
    PRIMARY KEY ("id")
);


CREATE SEQUENCE seq_account_role
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE "public"."account_role" (
    "id" bigint DEFAULT nextval('seq_account_role'::regclass),
    "account_id" bigint,
    "role_id" bigint,
    PRIMARY KEY ("id"),
    FOREIGN KEY ("account_id") REFERENCES "public"."account"("id"),
    FOREIGN KEY ("role_id") REFERENCES "public"."role"("id")
);

CREATE MATERIALIZED VIEW "public"."v_account_role" AS  SELECT account.id AS account_id,
    role.id AS role_id,
    account.username,
    account.password,
    role.role_name
   FROM account
     JOIN account_role ON account_role.account_id = account.id
     JOIN role ON account_role.role_id = role.id;

insert into account (email, username, password, firstname, lastname, active, created) 
values ('admin@gmail.com', 'admin', 'jGl25bVBBBW96Qi9Te4V37Fnqchz/Eu4qB9vKrRIqRg=', 'admin', 'admin', true, now());

insert into account (email, username, password, firstname, lastname, active, created) 
values ('customer01@gmail.com', 'customer01', 'LxhNvRGC3MiAJQcgmSbZOVUbCkxhAjjYuqJ6t8VCRDs=', 'customer01', 'customer01', true, now());

insert into role (role_name) values ('ADMINISTRATOR');
insert into role (role_name) values ('CUSTOMER');

INSERT INTO account_role(account_id, role_id) VALUES (1, 1);
INSERT INTO account_role(account_id, role_id) VALUES (2, 2);

 SELECT account_role.account_id,
    account_role.role_id,
    account.username,
    account.password,
    role.role_name
   FROM account_role
     JOIN account ON account_role.account_id = account.id
     JOIN role ON account_role.role_id = role.id;