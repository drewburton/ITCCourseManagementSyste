SELECT Title, (Department || courseId) as course_Identifier 
FROM Courses 
WHERE Courses.CourseId in 
(SELECT Courses.CourseId FROM Courses, Sessions WHERE Courses.CourseId=Sessions.CourseId and Sessions.SessionId in 
(SELECT SessionId FROM Enrollment WHERE StudentGlobalId = 'Davi1AZ'))

SELECT (FirstName || ' ' || LastName) as Full_Name FROM Students WHERE Students.globalId in ( 
SELECT StudentGlobalId FROM Enrollment WHERE SessionId='5');
