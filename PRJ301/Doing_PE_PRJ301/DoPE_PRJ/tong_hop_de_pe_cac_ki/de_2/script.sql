USE [PRJ321_SUMMER_2019_B5]
GO
/****** Object:  Table [dbo].[Character_Skill]    Script Date: 8/20/2019 6:46:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Character_Skill](
	[cid] [varchar](50) NOT NULL,
	[sid] [int] NOT NULL,
 CONSTRAINT [PK_Character_Skill] PRIMARY KEY CLUSTERED 
(
	[cid] ASC,
	[sid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Characters]    Script Date: 8/20/2019 6:46:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Characters](
	[cid] [varchar](50) NOT NULL,
	[name] [varchar](150) NOT NULL,
	[gender] [bit] NOT NULL,
	[created_date] [date] NOT NULL,
 CONSTRAINT [PK_Characters] PRIMARY KEY CLUSTERED 
(
	[cid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Roles]    Script Date: 8/20/2019 6:46:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Roles](
	[rid] [int] NOT NULL,
	[name] [varchar](150) NOT NULL,
 CONSTRAINT [PK_Roles] PRIMARY KEY CLUSTERED 
(
	[rid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Skills]    Script Date: 8/20/2019 6:46:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Skills](
	[sid] [int] NOT NULL,
	[name] [varchar](150) NOT NULL,
 CONSTRAINT [PK_Skills] PRIMARY KEY CLUSTERED 
(
	[sid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[User_Role]    Script Date: 8/20/2019 6:46:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[User_Role](
	[uid] [varchar](50) NOT NULL,
	[rid] [int] NOT NULL,
 CONSTRAINT [PK_User_Role] PRIMARY KEY CLUSTERED 
(
	[uid] ASC,
	[rid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Users]    Script Date: 8/20/2019 6:46:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Users](
	[uid] [varchar](50) NOT NULL,
	[name] [varchar](150) NOT NULL,
	[isAdmin] [bit] NOT NULL,
	[created_date] [date] NOT NULL,
 CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED 
(
	[uid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Character_Skill] ([cid], [sid]) VALUES (N'flash', 1)
INSERT [dbo].[Character_Skill] ([cid], [sid]) VALUES (N'superman', 1)
INSERT [dbo].[Character_Skill] ([cid], [sid]) VALUES (N'superman', 5)
INSERT [dbo].[Characters] ([cid], [name], [gender], [created_date]) VALUES (N'flash', N'Barry Allen', 1, CAST(0x0A400B00 AS Date))
INSERT [dbo].[Characters] ([cid], [name], [gender], [created_date]) VALUES (N'mortal', N'Human', 0, CAST(0x0A400B00 AS Date))
INSERT [dbo].[Characters] ([cid], [name], [gender], [created_date]) VALUES (N'superman', N'Clark Kent', 1, CAST(0x0A400B00 AS Date))
INSERT [dbo].[Roles] ([rid], [name]) VALUES (1, N'system admin')
INSERT [dbo].[Roles] ([rid], [name]) VALUES (2, N'database owner')
INSERT [dbo].[Roles] ([rid], [name]) VALUES (3, N'table owner')
INSERT [dbo].[Roles] ([rid], [name]) VALUES (4, N'guest')
INSERT [dbo].[Roles] ([rid], [name]) VALUES (5, N'reviewer')
INSERT [dbo].[Skills] ([sid], [name]) VALUES (1, N'Teleport')
INSERT [dbo].[Skills] ([sid], [name]) VALUES (2, N'Hell fire')
INSERT [dbo].[Skills] ([sid], [name]) VALUES (3, N'Frozen')
INSERT [dbo].[Skills] ([sid], [name]) VALUES (4, N'Migic flame')
INSERT [dbo].[Skills] ([sid], [name]) VALUES (5, N'Tonardo')
INSERT [dbo].[Skills] ([sid], [name]) VALUES (6, N'Edo tense')
INSERT [dbo].[Skills] ([sid], [name]) VALUES (7, N'Rasengan')
INSERT [dbo].[Skills] ([sid], [name]) VALUES (8, N'Chidory')
INSERT [dbo].[Skills] ([sid], [name]) VALUES (9, N'Kage busin no jutsu')
INSERT [dbo].[User_Role] ([uid], [rid]) VALUES (N'flash', 1)
INSERT [dbo].[User_Role] ([uid], [rid]) VALUES (N'superman', 1)
INSERT [dbo].[User_Role] ([uid], [rid]) VALUES (N'superman', 3)
INSERT [dbo].[User_Role] ([uid], [rid]) VALUES (N'superman', 4)
INSERT [dbo].[Users] ([uid], [name], [isAdmin], [created_date]) VALUES (N'flash', N'Barry Allen', 1, CAST(0x09400B00 AS Date))
INSERT [dbo].[Users] ([uid], [name], [isAdmin], [created_date]) VALUES (N'Guest', N'Guest', 0, CAST(0x09400B00 AS Date))
INSERT [dbo].[Users] ([uid], [name], [isAdmin], [created_date]) VALUES (N'superman', N'Clark Kent', 1, CAST(0x09400B00 AS Date))
ALTER TABLE [dbo].[Character_Skill]  WITH CHECK ADD  CONSTRAINT [FK_Character_Skill_Characters] FOREIGN KEY([cid])
REFERENCES [dbo].[Characters] ([cid])
GO
ALTER TABLE [dbo].[Character_Skill] CHECK CONSTRAINT [FK_Character_Skill_Characters]
GO
ALTER TABLE [dbo].[Character_Skill]  WITH CHECK ADD  CONSTRAINT [FK_Character_Skill_Skills] FOREIGN KEY([sid])
REFERENCES [dbo].[Skills] ([sid])
GO
ALTER TABLE [dbo].[Character_Skill] CHECK CONSTRAINT [FK_Character_Skill_Skills]
GO
ALTER TABLE [dbo].[User_Role]  WITH CHECK ADD  CONSTRAINT [FK_User_Role_Roles] FOREIGN KEY([rid])
REFERENCES [dbo].[Roles] ([rid])
GO
ALTER TABLE [dbo].[User_Role] CHECK CONSTRAINT [FK_User_Role_Roles]
GO
ALTER TABLE [dbo].[User_Role]  WITH CHECK ADD  CONSTRAINT [FK_User_Role_Users] FOREIGN KEY([uid])
REFERENCES [dbo].[Users] ([uid])
GO
ALTER TABLE [dbo].[User_Role] CHECK CONSTRAINT [FK_User_Role_Users]
GO
