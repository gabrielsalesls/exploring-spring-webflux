CREATE TABLE IF NOT EXISTS Account (
    id BIGSERIAL PRIMARY KEY,
    userName VARCHAR(255) NOT NULL,
    balance NUMERIC(19, 2) NOT NULL
);

CREATE TABLE IF NOT EXISTS Transfer (
    id BIGSERIAL PRIMARY KEY,
    fromAccountId BIGINT NOT NULL,
    toAccountId BIGINT NOT NULL,
    amount NUMERIC(19, 2) NOT NULL,
    status VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    CONSTRAINT fk_from_account FOREIGN KEY (fromAccountId) REFERENCES Account(id),
    CONSTRAINT fk_to_account FOREIGN KEY (toAccountId) REFERENCES Account(id)
);
