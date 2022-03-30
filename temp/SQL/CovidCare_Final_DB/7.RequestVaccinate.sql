USE [CovidCareDB]
GO

/****** Object:  Table [dbo].[RequestVaccinate]    Script Date: 3/28/2022 11:07:12 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[RequestVaccinate](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[created_by] [int] NULL,
	[created_date] [date] NULL,
	[phone_number] [nvarchar](50) NULL,
	[status] [nvarchar](3) NULL,
	[note] [nvarchar](max) NULL,
	[image] [nvarchar](50) NULL,
 CONSTRAINT [PK_RequestVaccinate] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

ALTER TABLE [dbo].[RequestVaccinate]  WITH CHECK ADD  CONSTRAINT [FK_RequestVaccinate_users] FOREIGN KEY([created_by])
REFERENCES [dbo].[users] ([userId])
GO

ALTER TABLE [dbo].[RequestVaccinate] CHECK CONSTRAINT [FK_RequestVaccinate_users]
GO


