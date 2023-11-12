-- Active: 1681270724843@@127.0.0.1@3306@mms

use mms;
-- Prepare user table
DROP TABLE IF EXISTS User;

CREATE TABLE
    User (
        UserID INT PRIMARY KEY AUTO_INCREMENT,
        Username VARCHAR(50) UNIQUE NOT NULL,
        Password VARCHAR(64) NOT NULL,
        Email VARCHAR(100) NOT NULL,
        Address VARCHAR(255),
        Phone_Number VARCHAR(20),
        IsAdmin BOOLEAN DEFAULT false
    );

INSERT INTO
    `user`(
        `Password`,
        `Username`,
        `Email`,
        `Phone_Number`,
        `Address`,
        `IsAdmin`
    )
VALUES (
        '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92',
        'admin',
        '870245707@qq.com',
        '12345678910',
        '0.0.0.0',
        true
    );

-- Prepare product table
DROP TABLE IF EXISTS product;
CREATE TABLE
    product (
        productid INT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(255) NOT NULL,
        price DECIMAL(10, 2) NOT NULL,
        imageurl VARCHAR(255)
    );

INSERT INTO
    product(name, price, imageurl)
VALUES (
        'iphone_test_1',
        10.00,
        '/image/iphone_test_1.jpg'
    ), (
        'iphone_test_2',
        1111.11,
        '/image/iphone_test_2.jpg'
    ), (
        'iphone_test_3',
        1111.11,
        '/image/iphone_test_3.jpg'
    );