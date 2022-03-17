USE CovidCareDB

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