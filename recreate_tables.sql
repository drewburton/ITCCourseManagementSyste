drop table Students cascade constraints;
drop table Courses cascade constraints;
drop table Sections cascade constraints;
drop table Professors cascade constraints;
drop table Enrollment cascade constraints;

CREATE TABLE Students (
  GlobalId varchar(8) PRIMARY KEY,
  FirstName VARCHAR(50) NOT NULL,
  LastName VARCHAR(50) NOT NULL
);

CREATE TABLE Courses (
  CourseId INT PRIMARY KEY check (CourseId > 99 and CourseId < 1000),
  Department VARCHAR(3) PRIMARY KEY,
  Title VARCHAR(100) NOT NULL,
  IsWritingIntensive BOOLEAN
);

CREATE TABLE Sections (
  SectionId INT PRIMARY KEY,
  RoomId INT NOT NULL,
  TeacherId varchar(8) not null,
  CreditHours INT NOT NULL,
  SectionTime DATE NOT NULL,
  CourseId INT NOT NULL,
  CONSTRAINT FK_Section_Professor FOREIGN KEY (TeacherID) 
    REFERENCES Professors (GlobalId),
  CONSTRAINT FK_Section_Course FOREIGN KEY (CourseId)
    REFERENCES Courses (CourseId)
);

CREATE TABLE Professors (
  GlobalId varchar(8) PRIMARY KEY,
  FirstName VARCHAR(50) NOT NULL,
  LastName VARCHAR(50) NOT NULL,
  Salary DECIMAL(10,2) NOT NULL CHECK (Salary >= 0)
);

CREATE TABLE Enrollment (
  StudentGlobalId INT NOT NULL,
  SectionId INT NOT NULL,
  CONSTRAINT PK_Enrollment PRIMARY KEY (StudentGlobalId, SectionId),
  CONSTRAINT FK_Enrollment_Student FOREIGN KEY (StudentGlobalId)
    REFERENCES Students (GlobalId),
  CONSTRAINT FK_Enrollment_Section FOREIGN KEY (SectionId)
    REFERENCES Sections (SectionId)
);

--CREATE UNIQUE INDEX UQ_Sections_Room_Time
--  ON Sections (RoomId, Sectiontime);

--CREATE UNIQUE INDEX UQ_Enrollment_Time
--  ON Enrollment (StudentGlobalId, SectionTime);

--CREATE UNIQUE INDEX UQ_Teaching_Time
--  ON Sections (GlobalId, SectionTime);

-- constraint for global id, 5 letters followed by 1 number, then 2 letters
-- two sections can't be taught in the same room at the same time
-- students can't take the same the same course twice
-- teachers can't teach multiple classes taking place at the same time
-- globalid needs to be unique for studnets and professors

--ALTER TABLE Students ADD CONSTRAINT CHK_EnrolledCredits
--  CHECK ((SELECT SUM(CreditHours) FROM Sections s INNER JOIN Enrollment e ON s.SectionId = e.SectionId WHERE e.StudentGlobalId = Students.GlobalId) <= 21);
