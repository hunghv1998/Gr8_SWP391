USE [CovidCareDB]
GO

/****** Object:  Table [dbo].[PostRequest]    Script Date: 3/28/2022 11:07:33 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[PostRequest](
	[post_id] [int] NOT NULL,
	[request_id] [int] NOT NULL,
 CONSTRAINT [PK_PostRequest] PRIMARY KEY CLUSTERED 
(
	[post_id] ASC,
	[request_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[PostRequest]  WITH CHECK ADD  CONSTRAINT [FK_PostRequest_PostVaccinate] FOREIGN KEY([post_id])
REFERENCES [dbo].[PostVaccinate] ([id])
GO

ALTER TABLE [dbo].[PostRequest] CHECK CONSTRAINT [FK_PostRequest_PostVaccinate]
GO

ALTER TABLE [dbo].[PostRequest]  WITH CHECK ADD  CONSTRAINT [FK_PostRequest_RequestVaccinate] FOREIGN KEY([request_id])
REFERENCES [dbo].[RequestVaccinate] ([id])
GO

ALTER TABLE [dbo].[PostRequest] CHECK CONSTRAINT [FK_PostRequest_RequestVaccinate]
GO


