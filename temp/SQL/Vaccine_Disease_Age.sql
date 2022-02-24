USE CovidCare

CREATE TABLE Vaccine (
vaccId int NOT NULL IDENTITY(1,1) PRIMARY KEY,
vaccName nvarchar(50) NULL
)

INSERT INTO Vaccine(vaccName) VALUES (N'Astra Zeneca')
INSERT INTO Vaccine(vaccName) VALUES (N'Pfizer/BioTech')
INSERT INTO Vaccine(vaccName) VALUES (N'SPUTNIK V')
INSERT INTO Vaccine(vaccName) VALUES (N'Moderna')
INSERT INTO Vaccine(vaccName) VALUES (N'Vero Cell')
INSERT INTO Vaccine(vaccName) VALUES (N'Janssen')
INSERT INTO Vaccine(vaccName) VALUES (N'Abdala (Cuba)')

CREATE TABLE Disease (
diseaseId int NOT NULL IDENTITY(1,1) PRIMARY KEY,
diseaseName nvarchar(MAX) NULL
)

INSERT INTO Disease(diseaseName) VALUES (N'Đái tháo đường')
INSERT INTO Disease(diseaseName) VALUES (N'Bệnh phổi tắc nghẽn mãn tính và các bệnh phổi khác')
INSERT INTO Disease(diseaseName) VALUES (N'Ung thư đặc biệt là các khối u ác tính về huyết học, ung thư phổi và bệnh ung thư di căn khác')
INSERT INTO Disease(diseaseName) VALUES (N'Bệnh thận mạn tính')
INSERT INTO Disease(diseaseName) VALUES (N'Ghép tạng hoặc cấy ghép tế bào gốc tạo máu')
INSERT INTO Disease(diseaseName) VALUES (N'Béo phì, thừa cân')
INSERT INTO Disease(diseaseName) VALUES (N'Bệnh tim mạch (suy tim, bệnh động mạch vành hoặc bệnh cơ tim)')
INSERT INTO Disease(diseaseName) VALUES (N'Bệnh lý mạch máu não')
INSERT INTO Disease(diseaseName) VALUES (N'Hội chứng Down')
INSERT INTO Disease(diseaseName) VALUES (N'HIV/AIDS')
INSERT INTO Disease(diseaseName) VALUES (N'Bệnh lý thần kinh, bao gồm cả chứng sa sút trí tuệ')
INSERT INTO Disease(diseaseName) VALUES (N'Bệnh hồng cầu hình liềm')
INSERT INTO Disease(diseaseName) VALUES (N'Bệnh hen suyễn')
INSERT INTO Disease(diseaseName) VALUES (N'Tăng huyết áp')
INSERT INTO Disease(diseaseName) VALUES (N'Thiếu hụt miễn dịch')
INSERT INTO Disease(diseaseName) VALUES (N'Bệnh gan')
INSERT INTO Disease(diseaseName) VALUES (N'Rối loạn sử dụng chất gây nghiện')
INSERT INTO Disease(diseaseName) VALUES (N'Sử dụng corticosteroid hoặc các thuốc ức chế miễn dịch khác')
INSERT INTO Disease(diseaseName) VALUES (N'Các loại bệnh hệ thống')
INSERT INTO Disease(diseaseName) VALUES (N'Các bệnh nền của trẻ em theo hướng dẫn BYT (trẻ đẻ non, cân nặng thấp; trẻ béo phì, thừa cân; đái tháo đường, bệnh tim bẩm sinh, các bệnh lý gene và rối loạn chuyển hóa, hen phế quản; bệnh thalassemia, ung thư, bệnh nhân đang điều trị bằng thuốc corticoid hoặc các thuốc ức chế miễn dịch khác,...)')

CREATE TABLE AgeType (
ageId int NOT NULL IDENTITY(1,1) PRIMARY KEY,
ageType nvarchar(MAX) NULL
)

INSERT INTO AgeType(ageType) VALUES (N'Bệnh nhi dưới 3 tháng tuổi')
INSERT INTO AgeType(ageType) VALUES (N'Dưới 50 tuổi')
INSERT INTO AgeType(ageType) VALUES (N'Từ 50 đến 64 tuổi')
INSERT INTO AgeType(ageType) VALUES (N'Trên 65 tuổi')