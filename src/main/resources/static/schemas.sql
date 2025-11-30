CREATE TABLE shop_owners
(
    id       BIGSERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);



CREATE TABLE shop_categories
(
    id          BIGSERIAL PRIMARY KEY,
    shop_id     BIGINT REFERENCES shops (id),
    name        VARCHAR(100) NOT NULL,
    description text,
    logoUrl     text
);

CREATE TABLE users
(
    id       BIGSERIAL PRIMARY KEY,
    username VARCHAR(150) UNIQUE NOT NULL,
    password VARCHAR(255)        NOT NULL
);

CREATE TABLE shops
(
    id          BIGSERIAL PRIMARY KEY,
    shop_name   VARCHAR(150)        NOT NULL,
    shop_slug   VARCHAR(200) UNIQUE NOT NULL,
    description TEXT                NOT NULL,
    logo_url    TEXT                NOT NULL,
    is_active   BOOLEAN DEFAULT FALSE
);

CREATE TABLE shop_owners
(
    id       BIGSERIAL PRIMARY KEY,
    shop_id  BIGINT       NOT NULL,
    owner_id BIGINT       NOT NULL,
    role     VARCHAR(100) NOT NULL,

    CONSTRAINT fk_shop FOREIGN KEY (shop_id)
        REFERENCES shops (id)
        ON DELETE CASCADE,

    CONSTRAINT fk_owner
        FOREIGN KEY (owner_id)
            REFERENCES users (id)
            ON DELETE CASCADE,

    CONSTRAINT unique_owner_per_shop
        UNIQUE (shop_id, owner_id)
);