DROP TABLE IF EXISTS queue;

CREATE TABLE queue
(
    queue_id   varchar(36) NOT NULL,
    value      VARCHAR(255) UNIQUE,
    added_date TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_queue PRIMARY KEY (queue_id)
);

INSERT INTO queue
VALUES ('123e4567-e89b-12d3-a456-426655440000', 'a0a0', now())