
USE [PRJ321_FALL_2020]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 10/25/2020 9:00:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[accountid] [varchar](150) NOT NULL,
	[password] [varchar](150) NOT NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[accountid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Certificate]    Script Date: 10/25/2020 9:00:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Certificate](
	[id] [int] NOT NULL,
	[name] [varchar](150) NOT NULL,
 CONSTRAINT [PK_Certificate] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Employee]    Script Date: 10/25/2020 9:00:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Employee](
	[id] [int] NOT NULL,
	[name] [varchar](150) NOT NULL,
	[gender] [bit] NOT NULL,
	[dob] [date] NOT NULL,
	[createdby] [varchar](150) NOT NULL,
 CONSTRAINT [PK_Employee] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Employee_Certificate]    Script Date: 10/25/2020 9:00:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Employee_Certificate](
	[eid] [int] NOT NULL,
	[cid] [int] NOT NULL,
 CONSTRAINT [PK_Employee_Certificate] PRIMARY KEY CLUSTERED 
(
	[eid] ASC,
	[cid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Student]    Script Date: 10/25/2020 9:00:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Student](
	[id] [int] NOT NULL,
	[name] [varchar](150) NOT NULL,
	[dob] [date] NOT NULL,
	[gender] [bit] NOT NULL,
	[createdby] [varchar](150) NOT NULL,
 CONSTRAINT [PK_Student] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Student_Certificate]    Script Date: 10/25/2020 9:00:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Student_Certificate](
	[sid] [int] NOT NULL,
	[cid] [int] NOT NULL,
 CONSTRAINT [PK_Student_Certificate] PRIMARY KEY CLUSTERED 
(
	[sid] ASC,
	[cid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Account] ([accountid], [password]) VALUES (N'mra', N'mra')
INSERT [dbo].[Account] ([accountid], [password]) VALUES (N'mrb', N'mrb')
INSERT [dbo].[Account] ([accountid], [password]) VALUES (N'mrc', N'mrc')
INSERT [dbo].[Certificate] ([id], [name]) VALUES (1, N'Java OOP')
INSERT [dbo].[Certificate] ([id], [name]) VALUES (2, N'Java SE')
INSERT [dbo].[Certificate] ([id], [name]) VALUES (3, N'Java EE')
INSERT [dbo].[Certificate] ([id], [name]) VALUES (4, N'Java ME')
INSERT [dbo].[Employee] ([id], [name], [gender], [dob], [createdby]) VALUES (1001, N'mr X', 1, CAST(N'2000-01-01' AS Date), N'mra')
INSERT [dbo].[Employee] ([id], [name], [gender], [dob], [createdby]) VALUES (1002, N'mr Y', 1, CAST(N'2000-02-01' AS Date), N'mra')
INSERT [dbo].[Employee] ([id], [name], [gender], [dob], [createdby]) VALUES (1003, N'mr Z', 1, CAST(N'2000-02-01' AS Date), N'mrb')
INSERT [dbo].[Employee_Certificate] ([eid], [cid]) VALUES (1001, 1)
INSERT [dbo].[Employee_Certificate] ([eid], [cid]) VALUES (1001, 2)
INSERT [dbo].[Employee_Certificate] ([eid], [cid]) VALUES (1001, 3)
INSERT [dbo].[Employee_Certificate] ([eid], [cid]) VALUES (1002, 1)
INSERT [dbo].[Student] ([id], [name], [dob], [gender], [createdby]) VALUES (1001, N'mr X', CAST(N'2000-01-01' AS Date), 1, N'mra')
INSERT [dbo].[Student] ([id], [name], [dob], [gender], [createdby]) VALUES (1002, N'mr Y', CAST(N'2000-02-01' AS Date), 1, N'mra')
INSERT [dbo].[Student] ([id], [name], [dob], [gender], [createdby]) VALUES (1003, N'mr Z', CAST(N'2000-02-01' AS Date), 1, N'mrb')
INSERT [dbo].[Student_Certificate] ([sid], [cid]) VALUES (1001, 1)
INSERT [dbo].[Student_Certificate] ([sid], [cid]) VALUES (1001, 2)
INSERT [dbo].[Student_Certificate] ([sid], [cid]) VALUES (1001, 3)
INSERT [dbo].[Student_Certificate] ([sid], [cid]) VALUES (1002, 1)
ALTER TABLE [dbo].[Employee]  WITH CHECK ADD  CONSTRAINT [FK_Employee_Account] FOREIGN KEY([createdby])
REFERENCES [dbo].[Account] ([accountid])
GO
ALTER TABLE [dbo].[Employee] CHECK CONSTRAINT [FK_Employee_Account]
GO
ALTER TABLE [dbo].[Employee_Certificate]  WITH CHECK ADD  CONSTRAINT [FK_Employee_Certificate_Certificate] FOREIGN KEY([cid])
REFERENCES [dbo].[Certificate] ([id])
GO
ALTER TABLE [dbo].[Employee_Certificate] CHECK CONSTRAINT [FK_Employee_Certificate_Certificate]
GO
ALTER TABLE [dbo].[Employee_Certificate]  WITH CHECK ADD  CONSTRAINT [FK_Employee_Certificate_Employee] FOREIGN KEY([eid])
REFERENCES [dbo].[Employee] ([id])
GO
ALTER TABLE [dbo].[Employee_Certificate] CHECK CONSTRAINT [FK_Employee_Certificate_Employee]
GO
ALTER TABLE [dbo].[Student]  WITH CHECK ADD  CONSTRAINT [FK_Student_Account] FOREIGN KEY([createdby])
REFERENCES [dbo].[Account] ([accountid])
GO
ALTER TABLE [dbo].[Student] CHECK CONSTRAINT [FK_Student_Account]
GO
ALTER TABLE [dbo].[Student_Certificate]  WITH CHECK ADD  CONSTRAINT [FK_Student_Certificate_Certificate] FOREIGN KEY([cid])
REFERENCES [dbo].[Certificate] ([id])
GO
ALTER TABLE [dbo].[Student_Certificate] CHECK CONSTRAINT [FK_Student_Certificate_Certificate]
GO
ALTER TABLE [dbo].[Student_Certificate]  WITH CHECK ADD  CONSTRAINT [FK_Student_Certificate_Student] FOREIGN KEY([sid])
REFERENCES [dbo].[Student] ([id])
GO
ALTER TABLE [dbo].[Student_Certificate] CHECK CONSTRAINT [FK_Student_Certificate_Student]
GO
