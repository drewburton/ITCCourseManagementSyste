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
  SectionTime DATETIME NOT NULL,
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
