-- liquibase formatted sql

-- changeset a.hage:1713840544172-1
CREATE SEQUENCE IF NOT EXISTS member_id_seq;
ALTER TABLE member
    ALTER COLUMN id SET NOT NULL;
ALTER TABLE member
    ALTER COLUMN id SET DEFAULT nextval('member_id_seq');
ALTER SEQUENCE member_id_seq OWNED BY member.id;

