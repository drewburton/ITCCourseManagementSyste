SELECT Title, (Department || courseId) as courseIdentifier 
FROM Courses 
WHERE Courses.courseId in 
(SELECT CourseId FROM Courses, Sessions WHERE Courses.CourseId=Sessions.CourseId and Sessions.SessionId in 
(SELECT SessionId FROM Enrollment WHERE StudentGlobalId = 'nogue1db')

SELECT (FirstName || LastName) as name FROM Students WHERE Students.globalId in ( 
SELECT StudentGlobalId FROM Enrollment WHERE SessionId='id');
