CREATE TABLE client(
    id SERIAL PRIMARY KEY,
    name VARCHAR (127)
);

CREATE TABLE product(
    id SERIAL PRIMARY KEY,
    description VARCHAR (1270) NOT NULL,
    price DECIMAL NOT NULL
);

CREATE TABLE ordered(
    id SERIAL PRIMARY KEY,
    product_id INTEGER REFERENCES product(id),
    client_id INTEGER REFERENCES client(id)
);