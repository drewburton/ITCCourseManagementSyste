import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Session {
	private int sessionId;
	private int roomId;
	private int hour;
	private String days;
	private String teacherFname;
	private String teacherLname;
	
	public Session(int sessionId, int roomId, int hour, String days, String teacherFname, String teacherLname) {
		this.sessionId = sessionId;
		this.roomId = roomId;
		this.hour = hour;
		this.days = days;
		this.teacherFname = teacherFname;
		this.teacherLname = teacherLname;
	}

	public int getSessionId() {
		return sessionId;
	}

	public int getRoomId() {
		return roomId;
	}

	public int getHour() {
		return hour;
	}

	public String getDays() {
		return days;
	}

	public String getTeacherFname() {
		return teacherFname;
	}

	public String getTeacherLname() {
		return teacherLname;
	}
	
	@Override
	public String toString() {
		return "SessionId: " + sessionId + "\nRoom: " + roomId + "\nHour: " + hour + "\nDays: " + days + "\nTeacher: " + teacherFname + " " + teacherLname;
	}
	
	public static Session parseSession(String s) {
		 Matcher m = Pattern.compile("SessionId: (\\d+)\nRoom: (\\d+)\nHour: (\\d+)\nDays: (\\w+)\nTeacher: ([\\w\\ ]+)").matcher(s);
		 if (m.find()) {
			 int sessionId = Integer.parseInt(m.group(1));
			 int roomId = Integer.parseInt(m.group(2));
			 int hour = Integer.parseInt(m.group(3));
			 String days = m.group(4);
			 String[] name = m.group(5).split(" ");
			 return new Session(sessionId, roomId, hour, days, name[0], name[1]);
		 }
		 return null;
	}
}
