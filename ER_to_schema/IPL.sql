create database IPL;
use IPL;

create table Player(
player_id int primary key auto_increment,
name varchar(50),
dob date,
no_of_match_played int
);

create table team(
team_id int primary key,
team_owner varchar(50),
team_name varchar(50)
);

create table IPLMatch (
match_id int primary key auto_increment,
place varchar(50),
stadium varchar(50),
date_of_match date,
team1 int,
team2 int,
foreign key(team1) references team(team_id),
foreign key(team2) references team(team_id)
);

create table MatchPlayed (
team_score int,
player_score int,
player_id int,
match_id int,
team_id int,
season varchar(50),
foreign key(player_id) references Player(player_id),
foreign key(team_id) references team(team_id),
foreign key(match_id) references IPLMatch(match_id)
);