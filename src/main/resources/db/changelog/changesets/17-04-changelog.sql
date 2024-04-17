-- liquibase formatted sql

-- changeset a.hage:1713396873341-1
CREATE SEQUENCE IF NOT EXISTS book_id_seq;
ALTER TABLE book
    ALTER COLUMN id SET NOT NULL;
ALTER TABLE book
    ALTER COLUMN id SET DEFAULT nextval('book_id_seq');
ALTER SEQUENCE book_id_seq OWNED BY book.id;

-- changeset a.hage:1713396873341-2
CREATE SEQUENCE IF NOT EXISTS journal_id_seq;
ALTER TABLE journal
    ALTER COLUMN id SET NOT NULL;
ALTER TABLE journal
    ALTER COLUMN id SET DEFAULT nextval('journal_id_seq');
ALTER SEQUENCE journal_id_seq OWNED BY journal.id;

-- changeset a.hage:1713396873341-3
CREATE SEQUENCE IF NOT EXISTS multi_media_id_seq;
ALTER TABLE multi_media
    ALTER COLUMN id SET NOT NULL;
ALTER TABLE multi_media
    ALTER COLUMN id SET DEFAULT nextval('multi_media_id_seq');
ALTER SEQUENCE multi_media_id_seq OWNED BY multi_media.id;

