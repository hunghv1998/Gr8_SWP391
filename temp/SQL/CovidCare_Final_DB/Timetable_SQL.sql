use CovidCareDB

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