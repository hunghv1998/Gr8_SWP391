USE CovidCareDB

CREATE TABLE userRole(
userType int identity(1,1) PRIMARY KEY,
description nvarchar(50) not null
) 

CREATE TABLE users(
userId int identity(1,1) PRIMARY KEY,
username nvarchar(32) not null,
password nvarchar(32) not null,
userType int not null FOREIGN KEY REFERENCES userRole(userType)
)

ALTER TABLE users
ADD activeStatus bit default 1