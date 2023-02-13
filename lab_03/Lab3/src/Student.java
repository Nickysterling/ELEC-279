
public class Student extends Person {

	private int numCoursesTaken;
	private String[] courseCodes = new String[2];
	private int[] grades = new int[2];
	private static int maxCourses;

	public Student(String name, String address, int idNum) {
		super(name, address, idNum);

		numCoursesTaken = 0;
		maxCourses = 20;

		for (int i = 0; i < grades.length; i++) {
			grades[i] = 0;
		}

		for (int i = 0; i < courseCodes.length; i++) {
			courseCodes[i] = "";
		}

	}

	public String toString() {
		return "Student: " + super.toString();
	}

	public void addGrade(String courseCode, int grade) {
		for (int i = 0; i < courseCodes.length; i++) {
			if (courseCodes[i] == "") {
				courseCodes[i] = courseCode;
				grades[i] = grade;
				break;
			}
		}
	}
	
	public void printGrades() {
		for(int i = 0; i < courseCodes.length; i++) {
			System.out.println(courseCodes[i] + ":" + grades[i]);
		}
	}

}
