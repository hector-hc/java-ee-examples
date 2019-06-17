CREATE SEQUENCE seq_batch_simple_user
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE "public"."batch_simple_user" (
    "id" bigint DEFAULT nextval('seq_batch_simple_user'::regclass),
    "name" varchar(250) NOT NULL,
    "email" varchar(250) NOT NULL,
    PRIMARY KEY ("id")
);
