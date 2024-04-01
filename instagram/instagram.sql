create database instagram;
use instagram;

create table users(
user_id varchar(10) primary key,
email varchar(20),
verified bool,
phnumber varchar(10),
DOB varchar(20),
pwd text
);

create table pages(
page_id varchar(10) primary key,
user_id varchar(10),
page_name text,
page_handle text,
Bio text,
DP text,
Avatar text,
pwd text,
DOB varchar(20),
page_privacy varchar(10),
foreign key(user_id) references users(user_id)
);

create table followdetails(
followers varchar(10),
following varchar(10),
foreign key(followers) references pages(page_id),
foreign key(following) references pages(page_id)
);

create table device(
device_id varchar(10) primary key,
page_id varchar(10),
device_location varchar(50),
login_time time,
logout_time time,
cookie varchar(200),
foreign key(page_id) references pages(page_id)
);

create table Music(
Music_id varchar(10) primary key,
Title varchar(100),
Artist char(40),
Lyrics char(100),
Thumbnail char(100));

create table content(
post_id varchar(10) primary key,
page_id varchar(10),
Post_Media varchar(20),
Media_type varchar(20),
Music_Id varchar(10),
Views int8,
Primary_Poster varchar(20),
Likes int8,
Caption text,
Date_and_Time datetime,
Location varchar(25),
Music_Id_Timestamp timestamp,
foreign key(page_id) references pages(page_id),
foreign key(Music_Id) references Music(Music_id)
);

create table comments(
comment_id varchar(10) primary key,
post_id varchar(10),
content varchar(100),
parent_comment_id varchar(10),
foreign key(post_id) references content(post_id),
foreign key(parent_comment_id) references comments(comment_id)
);

create table collab_post(
post_id varchar(10),
page_id varchar(10),
foreign key(post_id) references content(post_id),
foreign key(page_id) references pages(page_id),
primary key(post_id,page_id)
);

create table likes(
page_id varchar(10),
post_id varchar(10),
comment_id varchar(10),
foreign key(post_id) references content(post_id),
foreign key(page_id) references pages(page_id),
foreign key(comment_id) references comments(comment_id)
);

create table stories(
story_id varchar(10) primary key,
content_id varchar(10),
liked_page_id varchar(10),
foreign key(content_id) references content(post_id),
foreign key(liked_page_id) references pages(page_id)
);

create table ref_stories(
Coordinates text, 
story_id varchar(10),
story_text text,
foreign key(story_id) references stories(story_id)
);

create table Collection(
collection_id varchar(10) primary key,
collection_Name char(100),
page_id varchar(10),
foreign key(page_id) references pages(page_id)
);

create table Collab(
Collab_id varchar(10) primary key,
page_id varchar(10),
Is_Owner bool,
foreign key(page_id) references pages(page_id));

create table Saved(
post_id varchar(10),
Collab_id varchar(10),
collection_id varchar(10),
foreign key(post_id) references content(post_id),
foreign key(Collab_id) references Collab(Collab_id),
foreign key(collection_id) references Collection(collection_id)
);

create table Post(
Media_id varchar(10) primary key,
post_id varchar(10),
Media_Link varchar(100),
foreign key(post_id) references content(post_id)
);

create table Tags(
Tag_id varchar(10) primary key,
coords varchar(100),
Media_id  varchar(10),
page_id  varchar(10),
foreign key(page_id) references pages(page_id),
foreign key(Media_id) references Post(Media_id)
);

create table hashtagcount(
hashtag varchar(40) primary key,
hashcount int
);

create table Hashtags(
post_id varchar(10) ,
hashtag varchar(40),
foreign key(post_id) references Post(post_id),
foreign key(hashtag) references hashtagcount(hashtag),
primary key(post_id,hashtag)
);

create table chat(
chat_id varchar(10) primary key,
chat_type varchar(10),
vanish_mode boolean,
settings varchar(50));


create table message(
message_id varchar(10) primary key,
content varchar(200),
sender varchar(10),
media_link varchar(10),
Time time,
chat_id varchar(10),
isVanishMode boolean,
foreign key(chat_id) references chat(chat_id),
foreign key(sender) references pages(page_id),
foreign key(media_link) references post(media_id)
);

create table chat_details(
chat_id varchar(10),
page_id varchar(10),
isAdmin boolean,
lastReadMessage_Id int,
foreign key(chat_id) references chat(chat_id),
foreign key(page_id) references pages(page_id)
);
-- drop database instagram;

create index users_index on users(verified);
create fulltext index page_index on pages(page_handle,page_name);
create index hashtag_index on hashtagcount(hashcount);
create index content_index on content(date_and_time,location,Music_Id,Views,Likes);
create index message_ind on message(Time, isVanishMode);


create view contentname as (select post_id, page_id, views, likes from content);
INSERT INTO users (user_id, email, verified, phnumber, DOB, pwd)
VALUES 
('user1', 'user1@example.com', true, '1234567890', '1990-01-01', 'password1'),
('user2', 'user2@example.com', false, '0987654321', '1985-05-15', 'password2'),
('user3', 'user3@example.com', true, '5555555555', '1999-12-25', 'password3'),
('user4', 'user4@example.com', true, '7777777777', '2000-03-10', 'password4'),
('user5', 'user5@example.com', false, '1111111111', '1988-08-20', 'password5');

INSERT INTO pages (page_id, user_id, page_name, page_handle, Bio, DP, Avatar, pwd, DOB, page_privacy)
VALUES 
('page1', 'user1', 'Page One', 'page_one', 'Bio for Page One', 'dp_url_one', 'avatar_url_one', 'page_pwd1', '1990-01-01', 'public'),
('page2', 'user2', 'Page Two', 'page_two', 'Bio for Page Two', 'dp_url_two', 'avatar_url_two', 'page_pwd2', '1985-05-15', 'private'),
('page3', 'user3', 'Page Three', 'page_three', 'Bio for Page Three', 'dp_url_three', 'avatar_url_three', 'page_pwd3', '1999-12-25', 'public'),
('page4', 'user4', 'Page Four', 'page_four', 'Bio for Page Four', 'dp_url_four', 'avatar_url_four', 'page_pwd4', '2000-03-10', 'public'),
('page5', 'user5', 'Page Five', 'page_five', 'Bio for Page Five', 'dp_url_five', 'avatar_url_five', 'page_pwd5', '1988-08-20', 'private');

INSERT INTO followdetails (followers, following)
VALUES 
('page1', 'page2'),
('page1', 'page3'),
('page2', 'page1'),
('page3', 'page1'),
('page3', 'page4');

INSERT INTO chat (chat_id, chat_type, vanish_mode, settings)
VALUES 
('chat1', 'private', false, 'setting1'),
('chat2', 'group', true, 'setting2'),
('chat3', 'private', false, 'setting3'),
('chat4', 'group', true, 'setting4'),
('chat5', 'private', false, 'setting5');

INSERT INTO message (message_id, content, sender, Time, chat_id, isVanishMode)
VALUES 
('message1', 'Hello!', 'page1', '10:00:00', 'chat1', false),
('message2', 'Hi there!', 'page2', '10:15:00', 'chat1', false),
('message3', 'Hey!', 'page1', '10:30:00', 'chat2', false),
('message4', 'What\'s up?', 'page3', '10:45:00', 'chat2', false),
('message5', 'Good morning!', 'page2', '11:00:00', 'chat3', false);

-- drop database instagram;

create table report_details(
reporter_id varchar(10),
reported_id varchar(10),
post_id varchar(10),
reported_content text,
foreign key(reporter_id) references pages(page_id),
foreign key(reported_id) references pages(page_id),
foreign key(post_id) references content(post_id)
);

create table blocked_pages(
blocker_id varchar(10),
blocked_id varchar(10),
foreign key(blocker_id) references pages(page_id),
foreign key(blocker_id) references pages(page_id)
);

create view post_discover_recommendation as(select c.post_id, likes, post_media,location, hashtag from content c inner join hashtags h on c.post_id=h.post_id inner join pages p on p.page_id=c.page_id where p.page_privacy='public'  order by likes desc);
create view device_history as(select device_id, p.page_id,device_location,login_time from device d inner join pages p on d.page_id=p.page_id);
create view storie_details as(select followers,following,post_id from followdetails inner join content on following=page_id where post_media='story');
create view homepage as(select f.followers,f. following,c.post_id ,c.Date_and_Time from followdetails f inner join content c on f.following=c.page_id);
create view linked_pages as(select email,page_id from pages p inner join users u on u.user_id=p.user_id );
select * from linked_pages;