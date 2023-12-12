
use mms;

-- Prepare user table
DROP TABLE IF EXISTS log;

DROP TABLE IF EXISTS cart;

DROP TABLE IF EXISTS User;

DROP TABLE IF EXISTS product;

CREATE TABLE
    user (
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
    ),
    (
        '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92',
        'user1',
        '12345678@qq.com',
        '12345678910',
        '0.0.0.0',
        false
    );

-- Prepare product table

CREATE TABLE
    product (
        productid INT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(255) NOT NULL,
        price DECIMAL(10, 2) NOT NULL,
        imageurl VARCHAR(255),
        quantity INT
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

-- Prepare cart table

CREATE TABLE
    cart (
        cartid INT PRIMARY KEY AUTO_INCREMENT,
        userid INT,
        productid INT,
        quantity INT,
        FOREIGN KEY (userid) REFERENCES user(UserID),
        FOREIGN KEY (productid) REFERENCES product(productid)
    );

CREATE TABLE
    log (
        logid INT PRIMARY KEY AUTO_INCREMENT,
        userid INT,
        productid INT,
        updatetime timestamp,
        actionid INT,
        FOREIGN KEY (userid) REFERENCES user(UserID),
        FOREIGN KEY (productid) REFERENCES product(productid)
    );