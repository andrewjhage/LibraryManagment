-- liquibase formatted sql

-- changeset a.hage:1713393929275-1
ALTER TABLE book
    ADD genre VARCHAR(255);

