
public class GradStudent extends Student {

	private int numCommittee, numExamsCompleted;
	private final static int maxExamAttempts = 6;
	private String[] gradExamNames = new String[4];
	private String[] gradExamResults = new String[4];
		
	public GradStudent(String name, String address, int idNum) {
		super(name, address, idNum);
		
		numCommittee = 0;
		numExamsCompleted = 0;
		
		for (int i = 0; i < gradExamNames.length; i++) {
			gradExamNames[i] = "";
		}

		for (int i = 0; i < gradExamResults.length; i++) {
			gradExamResults[i] = "";
		}
		
	}

	public void setCommitteeNum(int numCommittee) {
		this.numCommittee = numCommittee;
	}
	
	public int getCommitteeNum() {
		return numCommittee;
	}
	
	public String toString() {
		return "Grad " + super.toString();
	}
	
	public void addGrade(String examName, String examResult) {
		for (int i = 0; i < gradExamNames.length; i++) {
			if (gradExamNames[i] == "") {
				gradExamNames[i] = examName;
				gradExamResults[i] = examResult;
				break;
			}
		}
	}
	
	public void printExamGrades() {
		for(int i = 0; i < gradExamNames.length; i++) {
			System.out.println(gradExamNames[i] + ":" + gradExamResults[i]);
		}
	}
	
}
