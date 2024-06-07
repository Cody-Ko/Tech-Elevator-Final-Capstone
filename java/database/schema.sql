BEGIN TRANSACTION;

DROP TABLE IF EXISTS user_moderator_forum;
DROP TABLE IF EXISTS user_favorite_forum;
DROP TABLE IF EXISTS user_forum;
DROP TABLE IF EXISTS comments;
DROP TABLE IF EXISTS posts;
DROP TABLE IF EXISTS forum;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password_hash VARCHAR(200) NOT NULL,
    role VARCHAR(50) NOT NULL
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
    location VARCHAR(50) NOT NULL,
    FOREIGN KEY (forum_id) REFERENCES forum(forum_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE comments (
    comment_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    message VARCHAR(1000) NOT NULL,
    time_stamp TIMESTAMP NOT NULL,
    post_id INT NOT NULL,
    reply_to INT,
    location VARCHAR(50) NOT NULL,
    FOREIGN KEY (post_id) REFERENCES posts(post_id),
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
);

CREATE TABLE user_moderator_forum (
    forum_id INT NOT NULL,
    moderator_user_id INT NOT NULL,
    PRIMARY KEY (forum_id, moderator_user_id),
    FOREIGN KEY (moderator_user_id) REFERENCES users(user_id),
    FOREIGN KEY (forum_id) REFERENCES forum(forum_id)
);

INSERT INTO users (username, password_hash, role) VALUES ('mattymattmattcat', '$2a$10$Nw1szXQbDHdsZ0UMGwDYuuj11LV.4KadomqE9qGDkTMxwK11x93xa', 'user');
INSERT INTO users (username, password_hash, role) VALUES ('evenstephen', '$2a$10$sNsoK44rCWny3PZhArEAquufjxedqO9wME4NcyjBv2MUj8KNSJhci', 'user');
INSERT INTO users (username, password_hash, role) VALUES ('codythegoat', '$2a$10$C9/OkOaFoKH6PR3nEfy26OTKb4WI3Gxv9tv.QkPaSXiW1ISBDGXwe', 'user');

INSERT INTO forum (user_id, forum_name, time_stamp) VALUES (1, 'Movie Reviews', '2024-06-05 10:00:00');
INSERT INTO forum (user_id, forum_name, time_stamp) VALUES (1, 'Book Recommendations', '2024-06-05 10:29:00');
INSERT INTO forum (user_id, forum_name, time_stamp) VALUES (1, 'Software Things', '2024-06-05 10:36:00');

INSERT INTO user_forum (user_id, forum_id) VALUES (1, 1);
INSERT INTO user_forum (user_id, forum_id) VALUES (1, 2);
INSERT INTO user_forum (user_id, forum_id) VALUES (1, 3);

INSERT INTO posts (user_id, forum_id, title, message, up_votes, down_votes, time_stamp, location)
VALUES (1, 1, 'Welcome to Movie Reviews!', 'This is the first post in Movie Reviews :)', 10, 0, '2024-06-05 11:47:00', 'USA');
INSERT INTO posts (user_id, forum_id, title, message, up_votes, down_votes, time_stamp, location)
VALUES (1, 1, 'Jurassic Park Review', 'Honestly, I''m just here for the dinosaurs', 20, 0, '2024-06-05 11:50:00', 'USA');
INSERT INTO posts (user_id, forum_id, title, message, up_votes, down_votes, time_stamp, location)
VALUES (1, 1, 'Jurassic Park Review: Response', 'TO WHOEVER POSTED SAYING THEY''RE JUST WATCHING JURASSIC PARK FOR THE DINOSAURS CLEARLY ISN''T FULLY APPRECIATING THE ARTISTRY THAT COMES FROM SPIELBERG.', 0, 6, '2024-06-05 11:52:00', 'USA');

INSERT INTO posts (user_id, forum_id, title, message, up_votes, down_votes, time_stamp, location)
VALUES (1, 2, 'Welcome to Book Recommendations!', 'This is the first post in Book Recommendations :)', 10, 3, '2024-06-05 12:04:00', 'USA');
INSERT INTO posts (user_id, forum_id, title, message, up_votes, down_votes, time_stamp, location)
VALUES (1, 2, 'My Favorite Books', 'I actually only reread Meditations by Marcus Aerelius every second of the day. Highly recommend!', 20, 8, '2024-06-05 12:10:00', 'USA');
INSERT INTO posts (user_id, forum_id, title, message, up_votes, down_votes, time_stamp, location)
VALUES (1, 2, 'Recommendations needed!', 'I havent read in 25 years, I need my book fix. Any recs? My favorite genre is horror.', 5, 6, '2024-06-05 12:30:00', 'USA');

INSERT INTO posts (user_id, forum_id, title, message, up_votes, down_votes, time_stamp, location)
VALUES (1, 3, 'Welcome to Software Things!', 'This is the first post in Software Things :)', 12, 3, '2024-06-05 12:13:00', 'USA');
INSERT INTO posts (user_id, forum_id, title, message, up_votes, down_votes, time_stamp, location)
VALUES (1, 3, 'I need help with my code', 'How do I write a for loop? My instructor wont tell me', 5, 8, '2024-06-05 12:10:00', 'USA');
INSERT INTO posts (user_id, forum_id, title, message, up_votes, down_votes, time_stamp, location)
VALUES (1, 3, 'Need Project ideas', 'Seriously guys, I cant think of anything.', 30, 6, '2024-06-05 12:30:00', 'USA');

-- Comments for "Jurassic Park Review: Response"
INSERT INTO comments (user_id, message, time_stamp, post_id, reply_to, location)
VALUES (1, 'I prefer Jaws', '2024-06-07 09:34:00', 3, NULL, 'USA');
INSERT INTO comments (user_id, message, time_stamp, post_id, reply_to, location)
VALUES (1, 'The dinosaurs are why we''re all here bro', '2024-06-07 09:38:00', 3, NULL, 'USA');
INSERT INTO comments (user_id, message, time_stamp, post_id, reply_to, location)
VALUES (1, 'I kinda agree tho', '2024-06-07 09:39:00', 3, NULL, 'USA');

-- Comments for "Welcome to Movie Reviews"
INSERT INTO comments (user_id, message, time_stamp, post_id, reply_to, location)
VALUES (1, 'Make me mod.', '2024-06-07 09:34:00', 1, NULL, 'USA');
INSERT INTO comments (user_id, message, time_stamp, post_id, reply_to, location)
VALUES (1, 'Can you ban the spielberg guy?', '2024-06-07 09:38:00', 1, NULL, 'USA');
INSERT INTO comments (user_id, message, time_stamp, post_id, reply_to, location)
VALUES (1, 'Hi!! Make me admin pls :)', '2024-06-07 09:39:00', 1, NULL, 'USA');

-- Comments for "Jurassic Park Review"
INSERT INTO comments (user_id, message, time_stamp, post_id, reply_to, location)
VALUES (1, 'YESS, SO ARE WE!!!', '2024-06-07 09:34:00', 2, NULL, 'USA');
INSERT INTO comments (user_id, message, time_stamp, post_id, reply_to, location)
VALUES (1, 'DINOSAURS RAHHHHHH ! ! !', '2024-06-07 09:38:00', 2, NULL, 'USA');
INSERT INTO comments (user_id, message, time_stamp, post_id, reply_to, location)
VALUES (1, 'THIS GUY GETS IT.', '2024-06-07 09:39:00', 2, NULL, 'USA');

-- Comments for "Welcome to Book Recommendations!"
INSERT INTO comments (user_id, message, time_stamp, post_id, reply_to, location)
VALUES (1, 'Yay!! It''s like our own little bookclub!', '2024-06-07 09:34:00', 4, NULL, 'USA');
INSERT INTO comments (user_id, message, time_stamp, post_id, reply_to, location)
VALUES (1, 'Can we recommend comics?', '2024-06-07 09:38:00', 4, NULL, 'USA');
INSERT INTO comments (user_id, message, time_stamp, post_id, reply_to, location)
VALUES (1, 'I''m writing a 500 book series with 50 books per arc, would I be allowed to post 3 of my books a day? It''d TECHNICALLY be a recommendation if you think about it.', '2024-06-07 09:39:00', 4, NULL, 'USA');

--Comments for "My Favorite Books"
INSERT INTO comments (user_id, message, time_stamp, post_id, reply_to, location)
VALUES (1, 'Wow! Every second of the day? When do you find the time to sleep??', '2024-06-07 09:34:00', 5, NULL, 'USA');
INSERT INTO comments (user_id, message, time_stamp, post_id, reply_to, location)
VALUES (1, 'Who asked', '2024-06-07 09:38:00', 5, NULL, 'USA');
INSERT INTO comments (user_id, message, time_stamp, post_id, reply_to, location)
VALUES (1, 'I LOVE THAT BOOK!!', '2024-06-07 09:39:00', 5, NULL, 'USA');

--Comments for "Recommendations needed!"
INSERT INTO comments (user_id, message, time_stamp, post_id, reply_to, location)
VALUES (1, 'Seeing as you haven''t read for 25 years, could you provide some context to what your current reading level is?', '2024-06-07 09:34:00', 6, NULL, 'USA');
INSERT INTO comments (user_id, message, time_stamp, post_id, reply_to, location)
VALUES (1, 'House of Leaves by Mark Danielewski', '2024-06-07 09:38:00', 6, NULL, 'USA');
INSERT INTO comments (user_id, message, time_stamp, post_id, reply_to, location)
VALUES (1, 'fix??', '2024-06-07 09:39:00', 6, NULL, 'USA');

--Comments for "Welcome to Software Things!"
INSERT INTO comments (user_id, message, time_stamp, post_id, reply_to, location)
VALUES (1, 'Make me mod :)', '2024-06-07 10:34:00', 7, NULL, 'USA');
INSERT INTO comments (user_id, message, time_stamp, post_id, reply_to, location)
VALUES (1, 'Make me mod :))', '2024-06-07 10:38:00', 7, NULL, 'USA');
INSERT INTO comments (user_id, message, time_stamp, post_id, reply_to, location)
VALUES (1, 'Ban the other two guys :)))', '2024-06-07 10:39:00', 7, NULL, 'USA');

--Comments for "I need help with my code"
INSERT INTO comments (user_id, message, time_stamp, post_id, reply_to, location)
VALUES (1, 'Same issue here, my instructor refuses to rexplain to me arrays for the 46th time :/', '2024-06-07 10:34:00', 8, NULL, 'USA');
INSERT INTO comments (user_id, message, time_stamp, post_id, reply_to, location)
VALUES (1, 'Yeah, I''m not helping you with that.', '2024-06-07 10:38:00', 8, NULL, 'USA');
INSERT INTO comments (user_id, message, time_stamp, post_id, reply_to, location)
VALUES (1, '"for (int i = 0; i < array.length; i++) {System.out.println(i);}" , Hope that helps!', '2024-06-07 10:39:00', 8, NULL, 'USA');

--Comments for "Need Project ideas"
INSERT INTO comments (user_id, message, time_stamp, post_id, reply_to, location)
VALUES (1, 'Maybe try creating a vending machine application', '2024-06-07 10:34:00', 2, NULL, 'USA');
INSERT INTO comments (user_id, message, time_stamp, post_id, reply_to, location)
VALUES (1, 'You should make something like Venmo! But, call it something else.', '2024-06-07 10:38:00', 2, NULL, 'USA');
INSERT INTO comments (user_id, message, time_stamp, post_id, reply_to, location)
VALUES (1, 'You should make a message board or something.', '2024-06-07 10:39:00', 2, NULL, 'USA');


COMMIT TRANSACTION;