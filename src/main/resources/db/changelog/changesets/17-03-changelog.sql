-- liquibase formatted sql

-- changeset a.hage:1713396640787-1
ALTER TABLE book DROP COLUMN status;

-- changeset a.hage:1713396640787-2
ALTER TABLE book
    ADD status VARCHAR(255);

-- changeset a.hage:1713396640787-3
ALTER TABLE journal DROP COLUMN status;

-- changeset a.hage:1713396640787-4
ALTER TABLE journal
    ADD status VARCHAR(255);

-- changeset a.hage:1713396640787-5
ALTER TABLE multi_media DROP COLUMN status;

-- changeset a.hage:1713396640787-6
ALTER TABLE multi_media
    ADD status VARCHAR(255);

