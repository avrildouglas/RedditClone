create database redditt;
create user 'reddittuser'@'localhost' identified by 'ThePoster';
grant all on redditt.* to 'reddittuser'@'localhost';

