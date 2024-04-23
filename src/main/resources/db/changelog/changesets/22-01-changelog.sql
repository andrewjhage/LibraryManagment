-- liquibase formatted sql

-- changeset a.hage:1713839505320-5
ALTER TABLE book
    ADD due_date VARCHAR(255);
ALTER TABLE book
    ADD subject_area VARCHAR(255);

-- changeset a.hage:1713839505320-6
ALTER TABLE member
    ADD registration_date TIMESTAMP WITHOUT TIME ZONE;

-- changeset a.hage:1713839505320-8
DROP TABLE multi_media CASCADE;

-- changeset a.hage:1713839505320-1
ALTER TABLE journal
    ALTER COLUMN issue_number DROP NOT NULL;

-- changeset a.hage:1713839505320-2
ALTER TABLE member DROP COLUMN late_fees;

-- changeset a.hage:1713839505320-3
ALTER TABLE member
    ADD late_fees DECIMAL;

-- changeset a.hage:1713839505320-4
ALTER TABLE member
    ALTER COLUMN late_fees DROP NOT NULL;

