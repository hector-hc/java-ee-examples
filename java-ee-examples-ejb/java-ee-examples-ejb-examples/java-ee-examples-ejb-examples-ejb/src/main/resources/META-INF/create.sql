CREATE SEQUENCE seq_cache_country
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE "public"."cache_country" (
    "id" bigint NOT NULL DEFAULT nextval('seq_cache_country'::regclass),
    "name" varchar(100) NOT NULL,
    "iso_code_alpha2" varchar(5) NOT NULL,
    "created_date" timestamp NOT NULL,
    PRIMARY KEY ("id")
);


INSERT INTO cache_country (name, iso_code_alpha2, created_date) values ('Mexico', 'MX', now());
INSERT INTO cache_country (name, iso_code_alpha2, created_date) values ('Nicaragua', 'NI', now());
INSERT INTO cache_country (name, iso_code_alpha2, created_date) values ('El Salvador', 'SV', now());
INSERT INTO cache_country (name, iso_code_alpha2, created_date) values ('Honduras', 'HN', now());
INSERT INTO cache_country (name, iso_code_alpha2, created_date) values ('Costa Rica', 'CR', now());
INSERT INTO cache_country (name, iso_code_alpha2, created_date) values ('Peru', 'PE', now());
INSERT INTO cache_country (name, iso_code_alpha2, created_date) values ('Colombia', 'CO', now());
INSERT INTO cache_country (name, iso_code_alpha2, created_date) values ('Guatemala', 'GT', now());