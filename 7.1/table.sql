DROP DATABASE IF EXISTS currency_db;
CREATE DATABASE currency_db;

USE currency_db;

DROP TABLE IF EXISTS currencies;

CREATE TABLE currencies (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    code CHAR(3) NOT NULL UNIQUE,        -- e.g. USD, EUR
    name VARCHAR(50) NOT NULL,
    rate_to_eur DECIMAL(12,6) NOT NULL,  -- exchange rate relative to EUR
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

INSERT INTO currencies (code, name, rate_to_eur) VALUES
('EUR', 'Euro', 1.000000),
('USD', 'US Dollar', 1.080000),
('GBP', 'British Pound', 0.850000),
('JPY', 'Japanese Yen', 170.500000),
('AUD', 'Australian Dollar', 1.650000),
('CAD', 'Canadian Dollar', 1.470000),
('CHF', 'Swiss Franc', 0.960000),
('CNY', 'Chinese Yuan', 7.800000);

DROP USER IF EXISTS 'appuser'@'localhost';
CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'securepassword123';

GRANT SELECT, INSERT, UPDATE ON currency_db.currencies TO 'appuser'@'localhost';

-- GRANT DELETE ON currency_db.currencies TO 'appuser'@'localhost';

FLUSH PRIVILEGES;
