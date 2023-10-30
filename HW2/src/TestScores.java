//Define the TestScores class to store test scores and calculate the average
public class TestScores {
	 private double score1;
	 private double score2;
	 private double score3;

	 // Constructor to initialize test scores
	 public TestScores(double s1, double s2, double s3) {
	     this.score1 = s1;
	     this.score2 = s2;
	     this.score3 = s3;
	 }

	 // Setters for test scores
	 public void setScore1(double n) {
	     this.score1 = n;
	 }

	 public void setScore2(double n) {
	     this.score2 = n;
	 }

	 public void setScore3(double n) {
	     this.score3 = n;
	 }

	 // Getters for test scores
	 public double getScore1() {
	     return this.score1;
	 }

	 public double getScore2() {
	     return this.score2;
	 }

	 public double getScore3() {
	     return this.score3;
	 }

	 // Calculate and return the average of test scores
	 public double getAverageScore() {
	     return (this.score1 + this.score2 + this.score3) / 3;
	 }
	}