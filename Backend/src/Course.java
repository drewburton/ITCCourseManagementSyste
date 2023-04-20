
public class Course {
	private String title;
	private boolean wi;
	private int creditHours;
	
	public Course(String title, boolean wi, int creditHours) {
		this.title = title;
		this.wi = wi;
		this.creditHours = creditHours;
	}

	public String getTitle() {
		return title;
	}

	public boolean isWi() {
		return wi;
	}

	public int getCreditHours() {
		return creditHours;
	}
}
