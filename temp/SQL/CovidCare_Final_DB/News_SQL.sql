USE CovidCareDB

CREATE TABLE News_category (
id int identity(1,1) PRIMARY KEY,
description nvarchar(100)
)

CREATE TABLE News (
id int identity(1,1) PRIMARY KEY,
creator int FOREIGN KEY REFERENCES users(userId),
cateId int FOREIGN KEY REFERENCES News_category(id),
title nvarchar(250),
content nvarchar(MAX),
description nvarchar(250),
photo nvarchar(50),
status bit default(1),
create_date datetime2,
publish_date datetime2,
readCount int
)