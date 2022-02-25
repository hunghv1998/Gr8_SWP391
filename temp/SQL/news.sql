USE [CovidCare]
GO
/****** Object:  Table [dbo].[news]    Script Date: 2/25/2022 11:03:31 AM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[news]') AND type in (N'U'))
DROP TABLE [dbo].[news]
GO
/****** Object:  Table [dbo].[news]    Script Date: 2/25/2022 11:03:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[news](
	[newsId] [int] IDENTITY(1,1) NOT NULL,
	[content] [nvarchar](max) NULL,
	[uname] [nvarchar](50) NULL,
	[title] [nvarchar](150) NULL,
	[short_des] [nvarchar](max) NULL,
	[created_date] [date] NULL,
	[public_date] [date] NULL,
	[photo] [nvarchar](max) NULL,
 CONSTRAINT [PK_news] PRIMARY KEY CLUSTERED 
(
	[newsId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[news] ON 
GO
INSERT [dbo].[news] ([newsId], [content], [uname], [title], [short_des], [created_date], [public_date], [photo]) VALUES (1, N'Tính từ 16h ngày 23/02 đến 16h ngày 24/02, trên Hệ thống Quốc gia quản lý ca bệnh COVID-19 ghi nhận 69.128 ca nhiễm mới, trong đó 9 ca nhập cảnh và 69.119 ca ghi nhận trong nước (tăng 8.781 ca so với ngày trước đó) tại 62 tỉnh, thành phố (có 48.179 ca trong cộng đồng).

- Các tỉnh, thành phố ghi nhận ca bệnh như sau: Hà Nội (8.864), Bắc Giang (4.171), Hải Dương (2.948), Sơn La (2.860), Phú Thọ (2.596), Nam Định (2.592), TP. Hồ Chí Minh (2.466), Hòa Bình (2.391), Bắc Ninh (2.375), Vĩnh Phúc (2.117), Hưng Yên (1.995), Hải Phòng (1.890), Ninh Bình (1.799), Yên Bái (1.666), Lào Cai (1.655), Nghệ An (1.629), Hà Giang (1.560), Đắk Lắk (1.514), Thái Nguyên (1.497), Lạng Sơn (1.480), Thái Bình (1.456), Khánh Hòa (1.229), Quảng Nam (1.199), Tuyên Quang (1.118), Bình Định (1.016), Quảng Bình (987), Đà Nẵng (981), Thanh Hóa (881), Cao Bằng (848), Điện Biên (738), Lâm Đồng (732), Hà Tĩnh (715), Phú Yên (656), Bà Rịa - Vũng Tàu (627), Bình Phước (610), Gia Lai (579), Bình Dương (577), Hà Nam (530), Lai Châu (438), Cà Mau (422), Quảng Trị (414), Bình Thuận (284), Đắk Nông (253), Thừa Thiên Huế (242), Bắc Kạn (214), Kon Tum (189), Tây Ninh (179), Bến Tre (179), Đồng Nai (148), Quảng Ngãi (145), Vĩnh Long (83), Bạc Liêu (81), Kiên Giang (77), Trà Vinh (74), Cần Thơ (51), Long An (40), Ninh Thuận (17), Sóc Trăng (17), Đồng Tháp (10), An Giang (7), Tiền Giang (7), Hậu Giang (4).

- Các địa phương ghi nhận số ca nhiễm giảm nhiều nhất so với ngày trước đó: Quảng Ninh (-1.868), Hòa Bình (-204), Tuyên Quang (-159).

- Các địa phương ghi nhận số ca nhiễm tăng cao nhất so với ngày trước đó: Hà Nội (+1.445), Bắc Giang (+1.173), TP. Hồ Chí Minh (+1.015).

- Trung bình số ca nhiễm mới trong nước ghi nhận trong 07 ngày qua: 51.968 ca/ngày.

- Đến nay tại Việt Nam đã ghi nhận 205 ca mắc COVID-19 do biến thể Omicron tại TP. Hồ Chí Minh (97), Quảng Nam (27), Hà Nội (18), Khánh Hòa (11), Đà Nẵng (8 ), Kiên Giang (4), Quảng Ninh (20), Thanh Hóa (2), Hải Dương (2), Hải Phòng (1), Long An (2), Bà Rịa - Vũng Tàu (1), Bình Dương (2), Lâm Đồng (1), Ninh Bình (1), Hưng Yên (6), Bình Phước (1), An Giang (1)', NULL, N'Ngày 24/2: Số ca COVID-19 tăng vọt lên 69.128 F0', N'Bản tin phòng chống dịch COVID-19 của Bộ Y tế ngày 24/2 cho biết, cố ca COVID-19 tăng vọt lên 69.128 F0 tại 62 tỉnh, thành; nhiều hơn hôm qua gần 8.800 ca; Trong ngày có gần 20.000 F0 khỏi bệnh; 111 trường hợp tử vong', CAST(N'2022-02-24' AS Date), CAST(N'2022-02-24' AS Date), N'images/news/news1.jpg')
GO
INSERT [dbo].[news] ([newsId], [content], [uname], [title], [short_des], [created_date], [public_date], [photo]) VALUES (2, N'Thống kê trên Cổng thông tin tiêm chủng COVID-19 đến 13h ngày 24/2 cho biết cả nước đã tiêm gần 192,7 triệu liều vaccine phòng COVID-19, trong đó ngày 23/2, cả nước tiêm 273.851 liều vaccine.

Bộ Y tế đề nghị các địa phương triển khai bảo đảm tiến độ tiêm vaccine; tăng cường vận động người dân tiêm vaccine phòng COVID-19, đi từng ngõ, gõ từng nhà, rà từng người để tránh bỏ sót;

Các cơ sở khám bệnh, chữa bệnh rà soát và tổ chức tiêm liều cơ bản và liều bổ sung cho người trên 50 tuổi, người có bệnh nền đến khám bệnh, chữa bệnh tại cơ sở;

Sau khi đã tiêm đủ liều cơ bản thì triển khai tiêm liều bổ sung và liều nhắc lại theo thứ tự ưu tiên;

Bộ Y tế cho biết đã chủ động tiếp cận trước các nguồn vaccine phòng COVID-19 cho trẻ em dưới 12 tuổi (trước mắt là vaccine Pfizer theo đa số quốc gia trên thế giới) và tiêm ngay theo khuyến cáo của Tổ chức Y tế thế giới.', NULL, N'Chiều 24/2: Đã tiêm gần 192,7 triệu liều vaccine phòng COVID-19', N'Đến chiều ngày 24/2, cả nước đã tiêm gần 192,7 triệu liều vaccine phòng COVID-19; Tại Hướng dẫn mới về chẩn đoán và điều trị COVID-19 ở trẻ em do Bộ Y tế vừa ban hành trẻ em mắc COVID-19 mức độ nhẹ có thể lựa chọn phương pháp điều trị không dùng thuốc', CAST(N'2022-02-24' AS Date), CAST(N'2022-02-24' AS Date), N'images/news/news2.jpg')
GO
SET IDENTITY_INSERT [dbo].[news] OFF
GO
