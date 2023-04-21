drop table Students cascade constraints;
drop table Courses cascade constraints;
drop table Sessions cascade constraints;
drop table Instructors cascade constraints;
drop table Enrollment cascade constraints;

CREATE TABLE Students (
  GlobalId varchar(8) PRIMARY KEY,
  FirstName VARCHAR(50) NOT NULL,
  LastName VARCHAR(50) NOT NULL
);

CREATE TABLE Courses (
  CourseId INT check (CourseId > 99 and CourseId < 1000),
  Department VARCHAR(3),
  Title VARCHAR(100) NOT NULL,
  IsWritingIntensive int,
  CreditHours int not null,
  constraint PK_Courses primary key (department, courseid)
);

CREATE TABLE Instructors (
  GlobalId varchar(8) PRIMARY KEY,
  FirstName VARCHAR(50) NOT NULL,
  LastName VARCHAR(50) NOT NULL,
  Salary DECIMAL(10,2) NOT NULL CHECK (Salary >= 0)
);

CREATE TABLE Sessions (
  SessionId INT PRIMARY KEY,
  RoomId INT NOT NULL,
  InstructorId varchar(8) not null,
  hour int,
  Days varchar(5) not null,
  CourseId INT,
  Department varchar(3),
  CONSTRAINT FK_Session_Instructor FOREIGN KEY (InstructorID) 
    REFERENCES Instructors (GlobalId),
  CONSTRAINT FK_Session_Course FOREIGN KEY (department, courseid)
    REFERENCES Courses (department, CourseId)
);

CREATE TABLE Enrollment (
  StudentGlobalId varchar(8) NOT NULL,
  SessionId INT NOT NULL,
  CONSTRAINT PK_Enrollment PRIMARY KEY (StudentGlobalId, SessionId),
  CONSTRAINT FK_Enrollment_Student FOREIGN KEY (StudentGlobalId)
    REFERENCES Students (GlobalId),
  CONSTRAINT FK_Enrollment_Section FOREIGN KEY (SessionId)
    REFERENCES Sessions (SessionId)
);