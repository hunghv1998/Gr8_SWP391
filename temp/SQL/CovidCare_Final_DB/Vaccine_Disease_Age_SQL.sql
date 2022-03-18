USE CovidCareDB

CREATE TABLE Vaccines (
vaccId int NOT NULL IDENTITY(1,1) PRIMARY KEY,
vaccName nvarchar(50) NULL
)

INSERT INTO Vaccines(vaccName) VALUES (N'Astra Zeneca')
INSERT INTO Vaccines(vaccName) VALUES (N'Pfizer/BioTech')
INSERT INTO Vaccines(vaccName) VALUES (N'SPUTNIK V')
INSERT INTO Vaccines(vaccName) VALUES (N'Moderna')
INSERT INTO Vaccines(vaccName) VALUES (N'Vero Cell')
INSERT INTO Vaccines(vaccName) VALUES (N'Janssen')
INSERT INTO Vaccines(vaccName) VALUES (N'Abdala (Cuba)')

CREATE TABLE Diseases (
diseaseId int NOT NULL IDENTITY(1,1) PRIMARY KEY,
diseaseName nvarchar(MAX) NULL
)

INSERT INTO Diseases(diseaseName) VALUES (N'Đái tháo đường')
INSERT INTO Diseases(diseaseName) VALUES (N'Bệnh phổi tắc nghẽn mãn tính và các bệnh phổi khác')
INSERT INTO Diseases(diseaseName) VALUES (N'Ung thư đặc biệt là các khối u ác tính về huyết học, ung thư phổi và bệnh ung thư di căn khác')
INSERT INTO Diseases(diseaseName) VALUES (N'Bệnh thận mạn tính')
INSERT INTO Diseases(diseaseName) VALUES (N'Ghép tạng hoặc cấy ghép tế bào gốc tạo máu')
INSERT INTO Diseases(diseaseName) VALUES (N'Béo phì, thừa cân')
INSERT INTO Diseases(diseaseName) VALUES (N'Bệnh tim mạch (suy tim, bệnh động mạch vành hoặc bệnh cơ tim)')
INSERT INTO Diseases(diseaseName) VALUES (N'Bệnh lý mạch máu não')
INSERT INTO Diseases(diseaseName) VALUES (N'Hội chứng Down')
INSERT INTO Diseases(diseaseName) VALUES (N'HIV/AIDS')
INSERT INTO Diseases(diseaseName) VALUES (N'Bệnh lý thần kinh, bao gồm cả chứng sa sút trí tuệ')
INSERT INTO Diseases(diseaseName) VALUES (N'Bệnh hồng cầu hình liềm')
INSERT INTO Diseases(diseaseName) VALUES (N'Bệnh hen suyễn')
INSERT INTO Diseases(diseaseName) VALUES (N'Tăng huyết áp')
INSERT INTO Diseases(diseaseName) VALUES (N'Thiếu hụt miễn dịch')
INSERT INTO Diseases(diseaseName) VALUES (N'Bệnh gan')
INSERT INTO Diseases(diseaseName) VALUES (N'Rối loạn sử dụng chất gây nghiện')
INSERT INTO Diseases(diseaseName) VALUES (N'Sử dụng corticosteroid hoặc các thuốc ức chế miễn dịch khác')
INSERT INTO Diseases(diseaseName) VALUES (N'Các loại bệnh hệ thống')
INSERT INTO Diseases(diseaseName) VALUES (N'Các bệnh nền của trẻ em theo hướng dẫn BYT (trẻ đẻ non, cân nặng thấp; trẻ béo phì, thừa cân; đái tháo đường, bệnh tim bẩm sinh, các bệnh lý gene và rối loạn chuyển hóa, hen phế quản; bệnh thalassemia, ung thư, bệnh nhân đang điều trị bằng thuốc corticoid hoặc các thuốc ức chế miễn dịch khác,...)')

CREATE TABLE AgeTypes (
ageId int NOT NULL IDENTITY(1,1) PRIMARY KEY,
ageType nvarchar(MAX) NULL
)

INSERT INTO AgeTypes(ageType) VALUES (N'Bệnh nhi dưới 3 tháng tuổi')
INSERT INTO AgeTypes(ageType) VALUES (N'Dưới 50 tuổi')
INSERT INTO AgeTypes(ageType) VALUES (N'Từ 50 đến 64 tuổi')
INSERT INTO AgeTypes(ageType) VALUES (N'Trên 65 tuổi')

CREATE TABLE VaccineStatus(
id int IDENTITY(1,1) PRIMARY KEY,
detail nvarchar(250) NOT NULL
)

INSERT INTO VaccineStatus(detail) VALUES (N'Chưa tiêm')
INSERT INTO VaccineStatus(detail) VALUES (N'Đã tiêm 1 mũi')
INSERT INTO VaccineStatus(detail) VALUES (N'Đã tiêm 2 mũi, thời gian tiêm mũi 2 dưới 2 tuần')
INSERT INTO VaccineStatus(detail) VALUES (N'Đã tiêm 2 mũi, thời gian tiêm mũi 2 trên 2 tuần')
INSERT INTO VaccineStatus(detail) VALUES (N'Đã tiêm 3 mũi')
