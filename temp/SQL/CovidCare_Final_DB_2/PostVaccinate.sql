USE [CovidCareDB]
GO

/****** Object:  Table [dbo].[PostVaccinate]    Script Date: 3/28/2022 11:05:37 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[PostVaccinate](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[created_by] [int] NULL,
	[created_date] [date] NULL,
	[vaccId] [int] NULL,
	[expired_date] [date] NULL,
	[place] [nvarchar](50) NULL,
	[wardId] [nvarchar](6) NULL,
	[number_vaccin] [int] NULL,
	[start_date] [date] NULL,
	[note] [nvarchar](max) NULL,
	[status] [bit] NULL,
 CONSTRAINT [PK_PostVaccinate] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

ALTER TABLE [dbo].[PostVaccinate]  WITH CHECK ADD  CONSTRAINT [FK_PostVaccinate_users] FOREIGN KEY([created_by])
REFERENCES [dbo].[users] ([userId])
GO

ALTER TABLE [dbo].[PostVaccinate] CHECK CONSTRAINT [FK_PostVaccinate_users]
GO

ALTER TABLE [dbo].[PostVaccinate]  WITH CHECK ADD  CONSTRAINT [FK_PostVaccinate_Vaccines] FOREIGN KEY([vaccId])
REFERENCES [dbo].[Vaccines] ([vaccId])
GO

ALTER TABLE [dbo].[PostVaccinate] CHECK CONSTRAINT [FK_PostVaccinate_Vaccines]
GO

ALTER TABLE [dbo].[PostVaccinate]  WITH CHECK ADD  CONSTRAINT [FK_PostVaccinate_Wards] FOREIGN KEY([wardId])
REFERENCES [dbo].[Wards] ([wardId])
GO

ALTER TABLE [dbo].[PostVaccinate] CHECK CONSTRAINT [FK_PostVaccinate_Wards]
GO


