
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
		// TODO: implement
		return "";
	}
	
	public static Session parseSession(String s) {
		// TODO: implement
		return null;
	}
}
