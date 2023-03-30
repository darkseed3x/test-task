CREATE TABLE BUNDLED_PRODUCTS (
    bundled_product_id UUID PRIMARY KEY,
    create_date TIMESTAMP NOT NULL,
    name VARCHAR(128) NOT NULL,
    calls bigint,
    sms bigint,
    internet bigint,
    deleted boolean NOT NULL
);
CREATE TABLE TARIFFS (
    tariff_id UUID PRIMARY KEY,
    create_date TIMESTAMP NOT NULL,
    name VARCHAR(128) NOT NULL,
    archived boolean NOT NULL,
    deleted boolean NOT NULL,
    bundle_id UUID,
    constraint BUNDLE_REFS_PARENT foreign key (bundle_id) references BUNDLED_PRODUCTS (bundled_product_id)
);