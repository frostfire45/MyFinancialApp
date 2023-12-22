DROP TABLE Bank_Transaction;
DROP TABLE Bank_Account;

CREATE TABLE Bank_Account (
    bank_account_id BIGINIT IDENTITY NOT NULL PRIMARY KEY,
    account_number VARCHAR(30),
    account_name VARCHAR(30)
)
CREATE TABLE Bank_Transaction (
    bank_transaction_id BIGINIT IDENTITY NOT NULL PRIMARY KEY,
    post_date VARCHAR(10),
    amount DECIMAL(10,2),
    check_number INT,
    payee VARCHAR(30),
    memo VARCHAR(90),
    bank_account_id INT
)