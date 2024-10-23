DROP TABLE IF EXISTS users;

-- 유저 테이블
CREATE TABLE users {
    id INT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    nickname VARCHAR(50),
    address VARCHAR(200),
    age INT,
    gender CHAR(2),
    height INT,
    weight INT,
    email VARCHAR(50),
    role VARCHAR(10),
    created_at TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    login_id VARCHAR(50) NOT NULL,
    password_hash VARCHAR(100) NOT NULL,
    last_login TIMESTAMP NULL,
    is_active BOOLEAN DEFAULT TRUE
}