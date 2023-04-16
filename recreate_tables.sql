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
  StudentGlobalId varchar(8) NOT NULL,
  SectionId INT NOT NULL,
  CONSTRAINT PK_Enrollment PRIMARY KEY (StudentGlobalId, SectionId),
  CONSTRAINT FK_Enrollment_Student FOREIGN KEY (StudentGlobalId)
    REFERENCES Students (GlobalId),
  CONSTRAINT FK_Enrollment_Section FOREIGN KEY (SectionId)
    REFERENCES Sections (SectionId)
);

-- can't take a class in the same room at the same time
CREATE UNIQUE INDEX UQ_Sections_Room_Time
  ON Sections (RoomId, Sectiontime);

-- students can't enroll in two courses at the same time
ALTER TABLE Enrollment ADD CONSTRAINT CHK_EnrolledTime
check ((select count(*)
    from (sections s1 inner join sections s2 on
        s1.SectionTime = s2.SectionTime and s1.SectionId <> s2.SectionId), Enrollment
    where enrollment.SectionId = s1.SectionId or Enrollment.SectionId = s2.SectionId
        group by enrollment.StudentGlobalId) < 2);

-- teachers can't teach two classes at the same time
CREATE UNIQUE INDEX UQ_Teaching_Time
  ON Sections (TeacherId, SectionTime);

-- globalid needs to be unique for both students and professors
alter table Students add constraint CHK_Students_Professors_Id
    check ((select count(*) from (select * from professors p, students s where p.GlobalId = s.GlobalId)) = 0);
alter table Professors add constraint CHK_Professors_Students_Id
    check ((select count(*) from (select * from professors p, students s where p.GlobalId = s.GlobalId)) = 0);

-- students cannot enroll in more than 21 credits at a time
ALTER TABLE Students ADD CONSTRAINT CHK_EnrolledCredits
  CHECK ((SELECT SUM(CreditHours) FROM Sections s INNER JOIN Enrollment e ON s.SectionId = e.SectionId WHERE e.StudentGlobalId = Students.GlobalId) <= 21);
