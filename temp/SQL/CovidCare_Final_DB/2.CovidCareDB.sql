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

CREATE TABLE Patient(
patientId int PRIMARY KEY,
name nvarchar(50),
birthday date,
gender bit,
email nvarchar(50),
address nvarchar(100),
photo nvarchar(50),
wardId nvarchar(6),
ageType int,
covidStatus bit default 0,
covidPhoto nvarchar(50),
firstTimeLogin bit default 1,
CONSTRAINT FK_patientId FOREIGN KEY (patientId)
REFERENCES Users(userId),
CONSTRAINT FK_wardId FOREIGN KEY (wardId)
REFERENCES Wards(wardId),
CONSTRAINT FK_ageType FOREIGN KEY (ageType)
REFERENCES AgeTypes(ageId),
)

CREATE TABLE Patient_diseases(
userId int,
diseaseId int,
CONSTRAINT FK_userId FOREIGN KEY (userId)
REFERENCES Users(userId),
CONSTRAINT FK_diseaseId FOREIGN KEY (diseaseId)
REFERENCES Diseases(diseaseId),
)


CREATE TABLE Patient_Vaccines(
patientId int,
vaccId int,
FOREIGN KEY (patientId) REFERENCES Users(userId),
FOREIGN KEY (vaccId) REFERENCES Vaccines(vaccId)
)

ALTER TABLE Patient
ADD vaccineStatus int,
FOREIGN KEY (vaccineStatus) REFERENCES VaccineStatus(id)

ALTER TABLE Patient
ADD pregnancyStatus bit default 0

ALTER TABLE Patient
ADD emergencyStatus bit default 0

CREATE TABLE Hospital (
userId int PRIMARY KEY,
name nvarchar(100),
photo nvarchar(100),
address nvarchar(250),
wardId nvarchar(6),
CONSTRAINT h_userId FOREIGN KEY (userId) REFERENCES users(userId),
CONSTRAINT h_wardId FOREIGN KEY (wardId) REFERENCES Wards(wardId)
)

CREATE TABLE NewsCategory (
id int identity(1,1) PRIMARY KEY,
description nvarchar(100)
)

INSERT INTO NewsCategory(description) 
VALUES(N'Chỉ đạo chống dịch'),
(N'Dự phòng - Điều trị'),
(N'Tình hình thế giới')

CREATE TABLE News (
id int identity(1,1) PRIMARY KEY,
creator int FOREIGN KEY REFERENCES users(userId),
cateId int FOREIGN KEY REFERENCES NewsCategory(id),
title nvarchar(250),
content nvarchar(MAX),
description nvarchar(250),
photo nvarchar(50),
status bit default(1),
create_date datetime2,
publish_date datetime2,
readCount int
)

CREATE TABLE Timetable(
id int identity(1,1) PRIMARY KEY,
title nvarchar(100),
startTime datetime2,
endTime datetime2,
detail nvarchar(250),
allDay bit default(0),
progress bit default(0),
creator int FOREIGN KEY REFERENCES users(userId),
assignee int FOREIGN KEY REFERENCES users(userId)
)

CREATE TABLE Message(
messageId int identity(1,1) PRIMARY KEY,
fromId int FOREIGN KEY REFERENCES users(userId),
toId int FOREIGN KEY REFERENCES users(userId),
message nvarchar(MAX),
messageDate datetimeoffset(7),
readState int
)