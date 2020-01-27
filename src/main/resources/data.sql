DROP TABLE IF EXISTS checking_account;

CREATE TABLE checking_account (id INT AUTO_INCREMENT PRIMARY KEY, first_name VARCHAR(250), last_name VARCHAR(250), total_savings INT, social_number VARCHAR(250));

INSERT INTO checking_account (first_name, last_name, total_savings, social_number) VALUES ('Aliko', 'Dangote', 15, '028.899.220-20');
INSERT INTO checking_account (first_name, last_name, total_savings, social_number) VALUES ('Bill', 'Gates', 15, '028.899.220-21');
INSERT INTO checking_account (first_name, last_name, total_savings, social_number) VALUES ('Folrunsho', 'Alakija', 0, '028.899.220-22');

CREATE TABLE bank_posting (posting_id INT AUTO_INCREMENT PRIMARY KEY, posting_date VARCHAR(250), origin_account INT, recipient_account INT, total_value INT);

INSERT INTO bank_posting (posting_date, origin_account, recipient_account, total_value) VALUES ('2020-01-01', 1, 2, 20);
INSERT INTO bank_posting (posting_date, origin_account, recipient_account, total_value) VALUES ('2020-01-03', 3, 2, 250);
INSERT INTO bank_posting (posting_date, origin_account, recipient_account, total_value) VALUES ('2020-01-05', 2, 1, 50);