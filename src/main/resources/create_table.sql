CREATE TABLE IF NOT EXISTS 'fugitives'
(
    'id' INT AUTO_INCREMENT PRIMARY KEY,
    'name' VARCHAR(255) NOT NULL,
    'surname' VARCHAR(255) NOT NULL,
    'birthPlace' VARCHAR(255) NOT NULL,
    'birthDate' VARCHAR(255) NOT NULL,
    'organization' VARCHAR(255) NOT NULL,
    'color' VARCHAR(255) NOT NULL,
    'b64Image' TEXT NOT NULL,
    'createdDate' TIMESTAMP NOT NULL
);