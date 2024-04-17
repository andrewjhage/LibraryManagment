-- liquibase formatted sql

-- changeset a.hage:1713391814057-1
CREATE TABLE book
(
    id               INTEGER NOT NULL,
    title            VARCHAR(255),
    author           VARCHAR(255),
    year             INTEGER NOT NULL,
    quantity         INTEGER NOT NULL,
    status           SMALLINT,
    isbn             VARCHAR(255),
    late_fee_per_day DECIMAL,
    member_id        INTEGER,
    CONSTRAINT pk_book PRIMARY KEY (id)
);

-- changeset a.hage:1713391814057-2
CREATE TABLE journal
(
    id               INTEGER NOT NULL,
    title            VARCHAR(255),
    author           VARCHAR(255),
    year             INTEGER NOT NULL,
    quantity         INTEGER NOT NULL,
    status           SMALLINT,
    issue_number     INTEGER NOT NULL,
    late_fee_per_day DECIMAL,
    CONSTRAINT pk_journal PRIMARY KEY (id)
);

-- changeset a.hage:1713391814057-3
CREATE TABLE member
(
    id        INTEGER          NOT NULL,
    member_id VARCHAR(255),
    name      VARCHAR(255),
    email     VARCHAR(255),
    late_fees DOUBLE PRECISION NOT NULL,
    CONSTRAINT pk_member PRIMARY KEY (id)
);

-- changeset a.hage:1713391814057-4
CREATE TABLE multi_media
(
    id               INTEGER NOT NULL,
    title            VARCHAR(255),
    author           VARCHAR(255),
    year             INTEGER NOT NULL,
    quantity         INTEGER NOT NULL,
    status           SMALLINT,
    format           VARCHAR(255),
    late_fee_per_day DECIMAL,
    CONSTRAINT pk_multimedia PRIMARY KEY (id)
);

-- changeset a.hage:1713391814057-5
ALTER TABLE book
    ADD CONSTRAINT FK_BOOK_ON_MEMBER FOREIGN KEY (member_id) REFERENCES member (id);

