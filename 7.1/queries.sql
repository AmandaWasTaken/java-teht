USE currency_db;

SELECT * FROM currencies;

SELECT * FROM currencies
WHERE code = 'EUR';

SELECT COUNT(*) AS total_currencies
FROM currencies;

SELECT * FROM currencies
ORDER BY rate_to_eur DESC
LIMIT 1;
