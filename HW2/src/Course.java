//Define the Course class with attributes and an enrollment method
public class Course {
	 private String courseCode;
	 private String courseTitle;
	 private String instructorName;
	 private int maximumCapacity;
	 private int currentEnrollment;

	 // Constructor to initialize maximum capacity and current enrollment
	 public Course() {
	     this.maximumCapacity = 30;
	     this.currentEnrollment = 29;
	 }

	 // Enrollment method: Increment enrollment if there's room
	 public boolean enroll1Student() {
	     if (currentEnrollment < maximumCapacity) {
	         currentEnrollment++;
	         return true;
	     }
	     return false;
	 }

	 
	 public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	public void setMaximumCapacity(int maximumCapacity) {
		this.maximumCapacity = maximumCapacity;
	}

	public void setCurrentEnrollment(int currentEnrollment) {
		this.currentEnrollment = currentEnrollment;
	}

	// Getters for course attributes
	 public String getCourseCode() {
	     return courseCode;
	 }

	 public String getCourseTitle() {
	     return courseTitle;
	 }

	 public String getInstructorName() {
	     return instructorName;
	 }

	 public int getMaximumCapacity() {
	     return maximumCapacity;
	 }

	 public int getCurrentEnrollment() {
	     return currentEnrollment;
	 }
	}

