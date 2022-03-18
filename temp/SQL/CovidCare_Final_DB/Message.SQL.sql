use CovidCareDB

CREATE TABLE Message(
messageId int identity(1,1) PRIMARY KEY,
fromId int FOREIGN KEY REFERENCES users(userId),
toId int FOREIGN KEY REFERENCES users(userId),
message nvarchar(MAX),
messageDate datetimeoffset(7),
readState int
)