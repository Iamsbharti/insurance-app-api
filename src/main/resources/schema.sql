DROP TABLE IF EXISTS driver;
CREATE TABLE driver
(
    id               BIGINT AUTO_INCREMENT NOT NULL,
    salutation       VARCHAR(255)          NULL,
    first_name       VARCHAR(255)          NULL,
    last_name        VARCHAR(255)          NULL,
    telephone        INT                   NULL,
    address          VARCHAR(255)          NULL,
    city             VARCHAR(255)          NULL,
    pin_code         VARCHAR(255)          NULL,
    vehicle_type     VARCHAR(255)          NULL,
    engine_size      VARCHAR(255)          NULL,
    drivers_count    VARCHAR(255)          NULL,
    is_commercial    BIT(1)                NULL,
    can_use_out_side BIT(1)                NULL,
    current_value    BIGINT                NULL,
    registered_date  datetime              NULL,
    CONSTRAINT pk_driver PRIMARY KEY (id)
);