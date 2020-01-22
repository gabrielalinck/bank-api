DROP TABLE IF EXISTS checking_account;

CREATE TABLE checking_account (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  total_savings DOUBLE(10,2) DEFAULT NULL,
  social_number VARCHAR(250) DEFAULT NULL
);

INSERT INTO checking_account (first_name, last_name, total_savings, social_number) VALUES
  ('Aliko', 'Dangote', 15.5, '028.899.220-22'),
  ('Bill', 'Gates', 15.5, '028.899.220-22'),
  ('Folrunsho', 'Alakija', 15.5, '028.899.220-22');