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
  CourseId INT PRIMARY KEY check (CourseId > 99 and CourseId < 1000),
  Department VARCHAR(3) PRIMARY KEY,
  Title VARCHAR(100) NOT NULL,
  IsWritingIntensive BOOLEAN,
  CreditHours int not null
);

CREATE TABLE Sessions (
  SessionId INT PRIMARY KEY,
  RoomId INT NOT NULL,
  StartTime varchar(4) not null,
  EndTime varchar(4) not null,
  Days varchar(5) not null,
  CourseId INT NOT NULL,
  TeacherId varchar(8) not null,
  CONSTRAINT FK_Section_Professor FOREIGN KEY (TeacherID) 
    REFERENCES Instructors (GlobalId),
  CONSTRAINT FK_Section_Course FOREIGN KEY (CourseId)
    REFERENCES Courses (CourseId)
);

CREATE TABLE Instructors (
  GlobalId varchar(8) PRIMARY KEY,
  FirstName VARCHAR(50) NOT NULL,
  LastName VARCHAR(50) NOT NULL,
  Salary DECIMAL(10,2) NOT NULL CHECK (Salary >= 0)
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

-- can't take a class in the same room at the same time
alter table Sessions add constraint CHK_Sessions_Room_Time
    check (not exists(select * from sessions s1, sessions s2 where s1.RoomId = s2.RoomId and s1.StartTime = s2.StartTime));

-- students can't enroll in two courses at the same time
ALTER TABLE Enrollment ADD CONSTRAINT CHK_EnrolledTime
check ((select count(*)
    from (sessions s1 inner join sessions s2 on
        s1.StartTime = s2.StartTime and s1.SessionId <> s2.SessionId), Enrollment
    where enrollment.SessionId = s1.SessionId or Enrollment.SessionId = s2.SessionId
        group by enrollment.StudentGlobalId) < 2);

-- teachers can't teach two classes at the same time
alter table sessions add constraint CHK_Teaching_Time
    check (not exists(select * from Sessions s1, sessions s2 where s1.TeacherId = s2.TeacherId and s1.StartTime = s2.StartTime));

-- globalid needs to be unique for both students and professors
alter table Students add constraint CHK_Students_Professors_Id
    check ((select count(*) from (select * from Instructors p, students s where p.GlobalId = s.GlobalId)) = 0);
alter table Instructors add constraint CHK_Professors_Students_Id
    check ((select count(*) from (select * from Instructors p, students s where p.GlobalId = s.GlobalId)) = 0);

-- students cannot enroll in more than 21 credits at a time
ALTER TABLE Students ADD CONSTRAINT CHK_EnrolledCredits
  CHECK ((SELECT SUM(CreditHours)
          FROM Courses, Sessions s INNER JOIN Enrollment e ON s.SessionId = e.SessionId
            WHERE e.StudentGlobalId = Students.GlobalId and s.CourseId = Courses.CourseId) <= 21);
