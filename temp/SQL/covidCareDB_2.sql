USE [master]
GO
/****** Object:  Database [CovidCare]    Script Date: 2/16/2022 3:54:25 AM ******/
CREATE DATABASE [CovidCare]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'CovidCare', FILENAME = N'D:\Program Files\Microsoft SQL Server\MSSQL10_50.SQLEXPRESS\MSSQL\DATA\CovidCare.mdf' , SIZE = 3456KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'CovidCare_log', FILENAME = N'D:\Program Files\Microsoft SQL Server\MSSQL10_50.SQLEXPRESS\MSSQL\DATA\CovidCare_log.ldf' , SIZE = 896KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [CovidCare] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [CovidCare].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [CovidCare] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [CovidCare] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [CovidCare] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [CovidCare] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [CovidCare] SET ARITHABORT OFF 
GO
ALTER DATABASE [CovidCare] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [CovidCare] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [CovidCare] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [CovidCare] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [CovidCare] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [CovidCare] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [CovidCare] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [CovidCare] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [CovidCare] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [CovidCare] SET  ENABLE_BROKER 
GO
ALTER DATABASE [CovidCare] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [CovidCare] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [CovidCare] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [CovidCare] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [CovidCare] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [CovidCare] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [CovidCare] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [CovidCare] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [CovidCare] SET  MULTI_USER 
GO
ALTER DATABASE [CovidCare] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [CovidCare] SET DB_CHAINING OFF 
GO
ALTER DATABASE [CovidCare] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [CovidCare] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [CovidCare] SET DELAYED_DURABILITY = DISABLED 
GO
USE [CovidCare]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 2/16/2022 3:54:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[username] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[cities]    Script Date: 2/16/2022 3:54:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[cities](
	[cityId] [nvarchar](2) NOT NULL,
	[cityName] [nvarchar](50) NULL,
 CONSTRAINT [PK_cities] PRIMARY KEY CLUSTERED 
(
	[cityId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[districts]    Script Date: 2/16/2022 3:54:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[districts](
	[districtId] [nvarchar](4) NOT NULL,
	[districtName] [nvarchar](50) NULL,
	[cityId] [nvarchar](2) NULL,
 CONSTRAINT [PK_districts] PRIMARY KEY CLUSTERED 
(
	[districtId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Feature]    Script Date: 2/16/2022 3:54:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Feature](
	[fid] [int] IDENTITY(1,1) NOT NULL,
	[url] [nvarchar](100) NULL,
 CONSTRAINT [PK_Feature] PRIMARY KEY CLUSTERED 
(
	[fid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Group]    Script Date: 2/16/2022 3:54:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Group](
	[gid] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NULL,
 CONSTRAINT [PK_Group] PRIMARY KEY CLUSTERED 
(
	[gid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[GroupAccount]    Script Date: 2/16/2022 3:54:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GroupAccount](
	[username] [nvarchar](50) NULL,
	[gid] [int] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[GroupFeature]    Script Date: 2/16/2022 3:54:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GroupFeature](
	[gid] [int] NULL,
	[fid] [int] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[health_declaration]    Script Date: 2/16/2022 3:54:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[health_declaration](
	[userId] [int] NOT NULL,
	[status] [bit] NULL,
	[controlled_by] [int] NULL,
 CONSTRAINT [PK_health_declaration] PRIMARY KEY CLUSTERED 
(
	[userId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[hospital_service]    Script Date: 2/16/2022 3:54:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[hospital_service](
	[id] [int] NOT NULL,
	[hospitalId] [int] NULL,
	[userId] [int] NULL,
	[patient_timetable] [int] NULL,
	[action] [nvarchar](50) NULL,
 CONSTRAINT [PK_hospital_service] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[hospitals]    Script Date: 2/16/2022 3:54:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[hospitals](
	[hospitalId] [int] NOT NULL,
	[hospitalName] [nvarchar](50) NULL,
	[wardId] [nvarchar](5) NULL,
 CONSTRAINT [PK_hospitals] PRIMARY KEY CLUSTERED 
(
	[hospitalId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[message]    Script Date: 2/16/2022 3:54:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[message](
	[id] [int] NOT NULL,
	[subject] [nvarchar](100) NULL,
	[creator_body] [nchar](10) NULL,
	[create_date] [nchar](10) NULL,
	[parent_message_id] [int] NOT NULL,
	[expiry_date] [date] NULL,
	[is_reminder] [bit] NULL,
	[next_remind_date] [date] NULL,
	[reminder_frequency_id] [int] NULL,
	[creator_id] [int] NULL,
 CONSTRAINT [PK_message] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[message_recipient]    Script Date: 2/16/2022 3:54:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[message_recipient](
	[id] [int] NOT NULL,
	[recipient_id] [int] NULL,
	[message_id] [int] NULL,
	[is_read] [nchar](10) NULL,
 CONSTRAINT [PK_message_recipient] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[news]    Script Date: 2/16/2022 3:54:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[news](
	[newsId] [int] IDENTITY(1,1) NOT NULL,
	[content] [nvarchar](max) NULL,
	[uname] [nvarchar](50) NULL,
	[title] [nvarchar](50) NULL,
	[created_date] [date] NULL,
	[public_date] [date] NULL,
	[status] [int] NULL,
	[categoryId] [int] NULL,
 CONSTRAINT [PK_news] PRIMARY KEY CLUSTERED 
(
	[newsId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[news_categories]    Script Date: 2/16/2022 3:54:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[news_categories](
	[categoryId] [int] IDENTITY(1,1) NOT NULL,
	[categoryName] [nvarchar](50) NULL,
 CONSTRAINT [PK_news_categories] PRIMARY KEY CLUSTERED 
(
	[categoryId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[patient_timetable]    Script Date: 2/16/2022 3:54:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[patient_timetable](
	[id] [int] NOT NULL,
	[userId] [int] NULL,
	[action] [nvarchar](50) NULL,
	[status] [bit] NULL,
	[time] [date] NULL,
 CONSTRAINT [PK_patient_timetable] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[UserInfo]    Script Date: 2/16/2022 3:54:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserInfo](
	[userId] [int] IDENTITY(1,1) NOT NULL,
	[bday] [date] NULL,
	[sex] [bit] NULL,
	[email] [nvarchar](50) NULL,
	[image] [nvarchar](50) NULL,
	[address] [nvarchar](50) NULL,
	[name] [nvarchar](50) NULL,
	[firstTimeLogin] [bit] NULL DEFAULT ((0)),
	[uname] [nvarchar](50) NULL,
 CONSTRAINT [PK_user] PRIMARY KEY CLUSTERED 
(
	[userId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[wards]    Script Date: 2/16/2022 3:54:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[wards](
	[wardId] [nvarchar](5) NOT NULL,
	[wardName] [nvarchar](50) NULL,
	[districtId] [nvarchar](4) NULL,
 CONSTRAINT [PK_wards] PRIMARY KEY CLUSTERED 
(
	[wardId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Account] ([username], [password]) VALUES (N'Cong123', N'123')
INSERT [dbo].[Account] ([username], [password]) VALUES (N'Manh123', N'123')
GO
INSERT [dbo].[Feature] ([url]) VALUES (N'/Home')
INSERT [dbo].[Feature] ([url]) VALUES (N'/News')
INSERT [dbo].[Feature] ([url]) VALUES (N'/Timetable')
INSERT [dbo].[Feature] ([url]) VALUES (N'/Profile')
GO
INSERT [dbo].[Group] ([name]) VALUES (N'Admin')
INSERT [dbo].[Group] ([name]) VALUES (N'Doctor')
INSERT [dbo].[Group] ([name]) VALUES (N'Patient')
GO
INSERT [dbo].[GroupAccount] ([gid], [username]) VALUES (1, N'Manh123')
INSERT [dbo].[GroupAccount] ([gid], [username]) VALUES (2, N'Cong123')
GO
INSERT [dbo].[GroupFeature] ([gid], [fid]) VALUES (1, 1)
INSERT [dbo].[GroupFeature] ([gid], [fid]) VALUES (1, 2)
INSERT [dbo].[GroupFeature] ([gid], [fid]) VALUES (1, 3)
INSERT [dbo].[GroupFeature] ([gid], [fid]) VALUES (2, 2)
GO
ALTER TABLE [dbo].[districts]  WITH CHECK ADD  CONSTRAINT [FK_districts_cities] FOREIGN KEY([cityId])
REFERENCES [dbo].[cities] ([cityId])
GO
ALTER TABLE [dbo].[districts] CHECK CONSTRAINT [FK_districts_cities]
GO
ALTER TABLE [dbo].[GroupAccount]  WITH CHECK ADD  CONSTRAINT [FK_GroupAccount_Account] FOREIGN KEY([username])
REFERENCES [dbo].[Account] ([username])
GO
ALTER TABLE [dbo].[GroupAccount] CHECK CONSTRAINT [FK_GroupAccount_Account]
GO
ALTER TABLE [dbo].[GroupAccount]  WITH CHECK ADD  CONSTRAINT [FK_GroupAccount_Group] FOREIGN KEY([gid])
REFERENCES [dbo].[Group] ([gid])
GO
ALTER TABLE [dbo].[GroupAccount] CHECK CONSTRAINT [FK_GroupAccount_Group]
GO
ALTER TABLE [dbo].[GroupFeature]  WITH CHECK ADD  CONSTRAINT [FK_GroupFeature_Feature] FOREIGN KEY([fid])
REFERENCES [dbo].[Feature] ([fid])
GO
ALTER TABLE [dbo].[GroupFeature] CHECK CONSTRAINT [FK_GroupFeature_Feature]
GO
ALTER TABLE [dbo].[GroupFeature]  WITH CHECK ADD  CONSTRAINT [FK_GroupFeature_Group] FOREIGN KEY([gid])
REFERENCES [dbo].[Group] ([gid])
GO
ALTER TABLE [dbo].[GroupFeature] CHECK CONSTRAINT [FK_GroupFeature_Group]
GO
ALTER TABLE [dbo].[health_declaration]  WITH CHECK ADD  CONSTRAINT [FK_health_declaration_hospitals] FOREIGN KEY([controlled_by])
REFERENCES [dbo].[hospitals] ([hospitalId])
GO
ALTER TABLE [dbo].[health_declaration] CHECK CONSTRAINT [FK_health_declaration_hospitals]
GO
ALTER TABLE [dbo].[health_declaration]  WITH CHECK ADD  CONSTRAINT [FK_health_declaration_user] FOREIGN KEY([userId])
REFERENCES [dbo].[UserInfo] ([userId])
GO
ALTER TABLE [dbo].[health_declaration] CHECK CONSTRAINT [FK_health_declaration_user]
GO
ALTER TABLE [dbo].[hospital_service]  WITH CHECK ADD  CONSTRAINT [FK_hospital_service_hospitals] FOREIGN KEY([hospitalId])
REFERENCES [dbo].[hospitals] ([hospitalId])
GO
ALTER TABLE [dbo].[hospital_service] CHECK CONSTRAINT [FK_hospital_service_hospitals]
GO
ALTER TABLE [dbo].[hospital_service]  WITH CHECK ADD  CONSTRAINT [FK_hospital_service_user] FOREIGN KEY([userId])
REFERENCES [dbo].[UserInfo] ([userId])
GO
ALTER TABLE [dbo].[hospital_service] CHECK CONSTRAINT [FK_hospital_service_user]
GO
ALTER TABLE [dbo].[hospitals]  WITH CHECK ADD  CONSTRAINT [FK_hospitals_wards] FOREIGN KEY([wardId])
REFERENCES [dbo].[wards] ([wardId])
GO
ALTER TABLE [dbo].[hospitals] CHECK CONSTRAINT [FK_hospitals_wards]
GO
ALTER TABLE [dbo].[message]  WITH CHECK ADD  CONSTRAINT [FK_message_message] FOREIGN KEY([id])
REFERENCES [dbo].[message] ([id])
GO
ALTER TABLE [dbo].[message] CHECK CONSTRAINT [FK_message_message]
GO
ALTER TABLE [dbo].[message]  WITH CHECK ADD  CONSTRAINT [FK_message_user] FOREIGN KEY([creator_id])
REFERENCES [dbo].[UserInfo] ([userId])
GO
ALTER TABLE [dbo].[message] CHECK CONSTRAINT [FK_message_user]
GO
ALTER TABLE [dbo].[message_recipient]  WITH CHECK ADD  CONSTRAINT [FK_message_recipient_message] FOREIGN KEY([message_id])
REFERENCES [dbo].[message] ([id])
GO
ALTER TABLE [dbo].[message_recipient] CHECK CONSTRAINT [FK_message_recipient_message]
GO
ALTER TABLE [dbo].[news]  WITH CHECK ADD  CONSTRAINT [FK_news_news_categories] FOREIGN KEY([categoryId])
REFERENCES [dbo].[news_categories] ([categoryId])
GO
ALTER TABLE [dbo].[news] CHECK CONSTRAINT [FK_news_news_categories]
GO
ALTER TABLE [dbo].[patient_timetable]  WITH CHECK ADD  CONSTRAINT [FK_patient_timetable_user] FOREIGN KEY([userId])
REFERENCES [dbo].[UserInfo] ([userId])
GO
ALTER TABLE [dbo].[patient_timetable] CHECK CONSTRAINT [FK_patient_timetable_user]
GO
ALTER TABLE [dbo].[wards]  WITH CHECK ADD  CONSTRAINT [FK_wards_districts] FOREIGN KEY([districtId])
REFERENCES [dbo].[districts] ([districtId])
GO
ALTER TABLE [dbo].[wards] CHECK CONSTRAINT [FK_wards_districts]
GO
USE [master]
GO
ALTER DATABASE [CovidCare] SET  READ_WRITE 
GO
