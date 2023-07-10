CREATE TABLE authority
(
    id   UUID         NOT NULL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_authority PRIMARY KEY (id)
);

CREATE TABLE chat_completition
(
    id                UUID    NOT NULL,
    object            VARCHAR(255),
    created           BIGINT  NOT NULL,
    model             VARCHAR(255),
    prompt_tokens     INTEGER NOT NULL,
    completion_tokens INTEGER NOT NULL,
    total_tokens      INTEGER NOT NULL,
    CONSTRAINT pk_chatcompletition PRIMARY KEY (id)
);

CREATE TABLE cover_letter
(
    id                      UUID NOT NULL,
    name                    VARCHAR(255),
    surname                 VARCHAR(255),
    age                     VARCHAR(255),
    applied_company         VARCHAR(255),
    position                VARCHAR(255),
    current_education_level VARCHAR(255),
    skills                  TEXT[],
    interests               TEXT[],
    weaknesses              TEXT[],
    CONSTRAINT pk_cover_letter PRIMARY KEY (id)
);

CREATE TABLE role
(
    id   UUID         NOT NULL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_role PRIMARY KEY (id)
);

CREATE TABLE role_authority
(
    authority_id UUID NOT NULL,
    role_id      UUID NOT NULL,
    CONSTRAINT pk_role_authority PRIMARY KEY (authority_id, role_id)
);

CREATE TABLE storage_object
(
    id                   UUID NOT NULL,
    cover_letter_id      UUID,
    chat_completition_id UUID,
    CONSTRAINT pk_storageobject PRIMARY KEY (id)
);

CREATE TABLE users
(
    id         UUID         NOT NULL,
    first_name VARCHAR(255),
    last_name  VARCHAR(255),
    email      VARCHAR(255) NOT NULL,
    password   VARCHAR(255),
    CONSTRAINT pk_users PRIMARY KEY (id)
);

CREATE TABLE users_role
(
    role_id UUID NOT NULL,
    user_id UUID NOT NULL,
    CONSTRAINT pk_users_role PRIMARY KEY (role_id, user_id)
);

ALTER TABLE authority
    ADD CONSTRAINT uc_authority_name UNIQUE (name);

ALTER TABLE role
    ADD CONSTRAINT uc_role_name UNIQUE (name);

ALTER TABLE users
    ADD CONSTRAINT uc_users_email UNIQUE (email);

ALTER TABLE storage_object
    ADD CONSTRAINT FK_STORAGEOBJECT_ON_CHAT_COMPLETITION FOREIGN KEY (chat_completition_id) REFERENCES chat_completition (id);

ALTER TABLE storage_object
    ADD CONSTRAINT FK_STORAGEOBJECT_ON_COVER_LETTER FOREIGN KEY (cover_letter_id) REFERENCES cover_letter (id);

ALTER TABLE role_authority
    ADD CONSTRAINT fk_rolaut_on_authority FOREIGN KEY (authority_id) REFERENCES authority (id);

ALTER TABLE role_authority
    ADD CONSTRAINT fk_rolaut_on_role FOREIGN KEY (role_id) REFERENCES role (id);

ALTER TABLE users_role
    ADD CONSTRAINT fk_userol_on_role FOREIGN KEY (role_id) REFERENCES role (id);

ALTER TABLE users_role
    ADD CONSTRAINT fk_userol_on_user FOREIGN KEY (user_id) REFERENCES users (id);