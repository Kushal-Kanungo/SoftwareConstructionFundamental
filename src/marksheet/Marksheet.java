package marksheet;

/**
 * class = "Marksheet" Desciption = This class will find different things
 * regarding different the classroom grades.
 * 
 * @author Kushal
 * @since 17 Oct 2022 03:00 PM
 */
public class Marksheet {
	private int[] studentGrades;
	private int totalStudents;

	/**
	 * 
	 * Description = Constructor for Marksheet class
	 * 
	 * @param totalStudents total number of student class
	 * @param gradesList    array of grades of students in class
	 */
	public Marksheet(int totalStudents, int[] gradesList) throws ArithmeticException {
		this.studentGrades = gradesList;
		this.totalStudents = totalStudents;
	}

	/**
	 * Description = Iterate over the grades of student and find maximum grade.
	 * 
	 * 
	 * @author Kushal
	 * @return maximumGrade in class
	 */
	public int calculateMaxGrade() {

		int maximumGrade = 0;
		for (int grade : this.studentGrades) {
			if (grade > maximumGrade) {
				maximumGrade = grade;
			}
		}
		return maximumGrade;

	}

	/**
	 * Description = Iterate over the grades of student and find minimum grade.
	 * 
	 * @author Kushal
	 * @return minimum grade in class
	 */
	public int calculateMinGrade() {
		int minimumGrade = 101;
		for (int grade : this.studentGrades) {
			if (grade < minimumGrade) {
				minimumGrade = grade;
			}
		}
		return minimumGrade;
	}

	/**
	 * Description = Find number of students passed and then calculate the
	 * percentage of them
	 * 
	 * @author Kushal
	 * @throws ArithmeticException
	 */
	public double calculatePassedPercent() throws ArithmeticException {
		double totalPassedStudents = 0;
		double passedStudentsPercentage = 0;
		for (int grade : this.studentGrades) {
			if (grade >= 40) {
				totalPassedStudents += 1;
			}
		}
		passedStudentsPercentage = totalPassedStudents / this.totalStudents * 100;
		return passedStudentsPercentage;
	}

	/**
	 * Desciption = First we add all the grades and divide it from total students
	 * 
	 * @author Kushal
	 * @throws ArithmeticException
	 */
	public double calculateAverageGrade() throws ArithmeticException {
		double totalGradeSum = 0;
		double averageGrade = 0;
		for (int grade : this.studentGrades) {
			totalGradeSum += grade;
		}

		averageGrade = totalGradeSum / this.totalStudents;
		return averageGrade;
	}
}