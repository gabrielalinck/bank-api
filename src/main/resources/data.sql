DROP TABLE IF EXISTS checking_account;

CREATE TABLE checking_account (id INT AUTO_INCREMENT PRIMARY KEY, first_name VARCHAR(250), last_name VARCHAR(250), total_savings INT, social_number VARCHAR(250));

INSERT INTO checking_account (first_name, last_name, total_savings, social_number) VALUES ('Aliko', 'Dangote', 15, '028.899.220-20');
INSERT INTO checking_account (first_name, last_name, total_savings, social_number) VALUES ('Bill', 'Gates', 15, '028.899.220-21');
INSERT INTO checking_account (first_name, last_name, total_savings, social_number) VALUES ('Folrunsho', 'Alakija', 15, '028.899.220-22');