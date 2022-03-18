use CovidCareDB

CREATE TABLE Hospital (
userId int PRIMARY KEY,
name nvarchar(100),
photo nvarchar(100),
address nvarchar(250),
wardId nvarchar(6),
CONSTRAINT h_userId FOREIGN KEY (userId) REFERENCES users(userId),
CONSTRAINT h_wardId FOREIGN KEY (wardId) REFERENCES Wards(wardId)
)