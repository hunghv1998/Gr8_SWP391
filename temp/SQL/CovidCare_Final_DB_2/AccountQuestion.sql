USE [CovidCareDB]
GO

/****** Object:  Table [dbo].[AccountQuestion]    Script Date: 3/28/2022 11:08:06 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[AccountQuestion](
	[userId] [int] NOT NULL,
	[secretQuestionId] [int] NOT NULL,
	[answer] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_AccountQuestion] PRIMARY KEY CLUSTERED 
(
	[userId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[AccountQuestion]  WITH CHECK ADD  CONSTRAINT [FK_AccountQuestion_Question] FOREIGN KEY([secretQuestionId])
REFERENCES [dbo].[Question] ([id])
GO

ALTER TABLE [dbo].[AccountQuestion] CHECK CONSTRAINT [FK_AccountQuestion_Question]
GO


