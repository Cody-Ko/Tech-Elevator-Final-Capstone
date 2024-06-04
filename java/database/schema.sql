BEGIN TRANSACTION;

DROP TABLE IF EXISTS user_form;
DROP TABLE IF EXISTS posts;
DROP TABLE IF EXISTS forum;
DROP TABLE IF EXISTS comments;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS user_favorite_forum;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	location varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE comments (
	comment_id SERIAL PRIMARY KEY,
    	user_id INT NOT NULL,
    	message VARCHAR(1000) NOT NULL,
    	time_stamp TIMESTAMP NOT NULL,
    	FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE forum (
	forum_id SERIAL PRIMARY KEY,
    	user_id INT NOT NULL,
    	forum_name VARCHAR(50) NOT NULL UNIQUE,
    	time_stamp TIMESTAMP NOT NULL,
    	FOREIGN KEY (user_id) REFERENCES users(user_id)
);
CREATE TABLE posts (
	post_id SERIAL PRIMARY KEY,
    	user_id INT NOT NULL,
    	forum_id INT NOT NULL,
    	title VARCHAR(50) NOT NULL,
    	message VARCHAR(1000) NOT NULL,
    	up_votes INT NOT NULL,
    	down_votes INT NOT NULL,
    	time_stamp TIMESTAMP NOT NULL,
    	FOREIGN KEY (forum_id) REFERENCES forum(forum_id),
    	FOREIGN KEY (user_id) REFERENCES users(user_id)
);
CREATE TABLE user_forum (
	user_id INT NOT NULL,
    	forum_id INT NOT NULL,
    	PRIMARY KEY (user_id, forum_id),
    	FOREIGN KEY (user_id) REFERENCES users(user_id),
    	FOREIGN KEY (forum_id) REFERENCES forum(forum_id)
);

CREATE TABLE user_favorite_forum (
    forum_id INT NOT NULL,
    forum_user_id INT NOT NULL,
    PRIMARY KEY (forum_id, forum_user_id),
    FOREIGN KEY (forum_user_id) REFERENCES users(user_id),
    FOREIGN KEY (forum_id) REFERENCES forum(forum_id)
)

COMMIT TRANSACTION;
