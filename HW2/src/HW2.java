
public class HW2 {
	 public static void main(String[] args) {
	     // Create instances of Course, Student, and TestScores
	     Course mist352 = new Course();
	     Course cs101 = new Course();
	     Student ashley = new Student();
	     Student ali = new Student();

	     // Task 6: Enroll Ashley Jaber in MIST352 and print details
	     System.out.println("Enrolling Ashley Jaber in MIST352 successful: " + mist352.enroll1Student());
	     System.out.println("Current enrollment: " + mist352.getCurrentEnrollment());

	     // Set course details for MIST352
	     mist352.setCourseCode("MIST352");
	     mist352.setCourseTitle("MIST352 Title");
	     mist352.setInstructorName("Instructor Name");

	     // Set test scores for MIST352 and calculate average GPA
	     TestScores mist352Grades = new TestScores(80, 75, 85);
	     mist352Grades.setScore1(80);
	     mist352Grades.setScore2(75);
	     mist352Grades.setScore3(85);

	     System.out.println("The current GPA is: " + mist352Grades.getAverageScore());

	     // Task 6 repeated for CS101
	     System.out.println("Enrolling Ashley Jaber in CS101 successful: " + cs101.enroll1Student());
	     System.out.println("Current enrollment: " + cs101.getCurrentEnrollment());

	     // Set course details for CS101
	     cs101.setCourseCode("CS101");
	     cs101.setCourseTitle("CS101 Title");
	     cs101.setInstructorName("Instructor Name");

	     // Set test scores for CS101 and calculate average GPA
	     TestScores cs101Grades = new TestScores(85, 90, 75);
	     cs101Grades.setScore1(85);
	     cs101Grades.setScore2(90);
	     cs101Grades.setScore3(75);

	     System.out.println("The current GPA is: " + cs101Grades.getAverageScore());

	     // Task 7
	     System.out.println("Enrolling Ali June in MIST352: " + mist352.enroll1Student());
	     System.out.println("Enrolling Ali June in CS101: " + cs101.enroll1Student());

	     // Task 8: Compare Ashley's GPA in MIST352 and CS101
	     double mist352GPA = mist352Grades.getAverageScore();
	     double cs101GPA = cs101Grades.getAverageScore();

	     if (mist352GPA > cs101GPA) {
	         System.out.println("Ashley's GPA in MIST352 is greater than in CS101.");
	     } else if (cs101GPA > mist352GPA) {
	         System.out.println("Ashley's GPA in CS101 is greater than in MIST352.");
	     } else {
	         System.out.println("Ashley's GPA is the same in both courses.");
	     }

	     // Task 9
	     System.out.println("Enrolling Ali June in MIST352: " + mist352.enroll1Student());
	     System.out.println("Enrolling Ali June in CS101: " + cs101.enroll1Student());

	     // Task 9.c: Ali can't be enrolled in both courses due to maximum capacity.
	     System.out.println("Ali can't be enrolled because both courses are at maximum capacity.");
	 }
	}


