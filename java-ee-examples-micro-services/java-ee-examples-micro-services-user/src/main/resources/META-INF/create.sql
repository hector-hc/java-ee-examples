
CREATE SEQUENCE seq_micro_user
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE micro_user (ID bigint DEFAULT nextval('seq_micro_user'::regclass), EMAIL VARCHAR(255), NAME VARCHAR(255), PRIMARY KEY (ID));

CREATE SEQUENCE seq_mono_user_address
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE mono_user_address (ID bigint DEFAULT nextval('seq_mono_user_address'::regclass), CITY VARCHAR(255), NUMBER VARCHAR(255), STREET VARCHAR(255), ZIP VARCHAR(255), user_id BIGINT, PRIMARY KEY (ID));

ALTER TABLE mono_user_address ADD CONSTRAINT FK_mono_user_address_user_id FOREIGN KEY (user_id) REFERENCES mono_user (ID);