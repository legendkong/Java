import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class TestResult {
	
	//Initializing instance variables
	String id;
	String name;
	int test1;
	int test2;
	int overallScore;
	String good = "Good";
	String pass = "Pass";
	String fail = "Fail";
	
	//Constructor
	public TestResult(String id, String name, int test1, int test2) {
		this.id = id;
		this.name = name;
		this.test1 = test1;
		this.test2 = test2;
	}
	
	//Get methods
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getTest1() {
		return test1;
	}
	public int getTest2() {
		return test2;
	}
	
	//Set methods
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTest1(int test1) {
		this.test1 = test1;
	}
	public void setTest2(int test2) {
		this.test2 = test2;
	}
	
	//Get overall score method
	public int getOverallScore() {
		overallScore = (int) Math.round(getTest1() * 0.4 + getTest2() * 0.6);
		return overallScore;
	}
	
	//Get grade method
	public String getGrade() {
		if(overallScore >= 75) {
			return good;
		}
		else if(overallScore < 50) {
			return fail;
		}
		else {
			return pass;
		}
	}
	
	//Compare id method
	public boolean compare(String inputId) {
		if(inputId.equals(id)) {
			return true;
		}
		return false;
	}
	
	//Print instructions method
	public void printString() {
		System.out.println("");
		System.out.println("1 Search test result by applicant Id");
		System.out.println("2 Search test result(s) by applicant name");
		System.out.println("3 Search test result(s) by overall score");
		System.out.println("4 Show test result(s) with highest overall score");
		System.out.println("5 Show failure list");
		System.out.println("6 Quit");
		System.out.println("Please choose an option:");
	}
}


public class T01F_KongBoonLieng_Asn1 {

	public static void main(String[] args) {
		
		//Opening scanner class
		Scanner scanner = new Scanner(System.in);
		
		//Initializing variables
		String id = null;
		String name = null;
		int test1 = 0;
		int test2 = 0;
		String decision;
		boolean yn = true;
		int input;
		String inputId;
		String inputName;
		int lb;
		int ub;		
		int counter1 = 0;
		int counter2 = 0;
		int counter3 = 0;
		int counter5 = 0;
		
		//Initializing test result array list
		ArrayList<TestResult> testResult = new ArrayList<>();


		//Continue printing if user enters 'y'
		while(yn) {
			System.out.print("Candidate Id: ");
			id = scanner.next();
			System.out.print("Name: ");
			name = scanner.next();
			scanner.nextLine();
			System.out.print("Test 1 score: ");
			test1 = scanner.nextInt();
			System.out.print("Test 2 score: ");
			test2 = scanner.nextInt();
			
			//Initiliazing testresult object p
			TestResult p = new TestResult(id, name, test1, test2);
			
			//Set the variables in object p
			p.setId(id);
			p.setName(name);
			p.setTest1(test1);
			p.setTest2(test2);
			
			//Add object p into arraylist testResult
			testResult.add(p);
			
			//Prompts if user wants to continue entering details, if false then break out of loop
			System.out.print("Enter another record? (y/n) ");
			decision = scanner.next();
			System.out.println("");
			switch(decision) {
			
			case "y":
				yn = true;
				break;
			
			case "n":
				yn = false;
				break;
				
			default:
				System.out.println("Please try again.");
				break;
			}
		}
		
		//Prints out instruction method from TestResult class
		testResult.get(0).printString();	

		input = scanner.nextInt();
		
		//Toggling with the 6 different options
		switch(input) {
		case 1 :
			System.out.print("Enter applicant Id: ");
			inputId = scanner.next();
			for(int i = 0 ; i < testResult.size(); i++) {
				if(testResult.get(i).compare(inputId)) {
					System.out.println("Candidate Id: " + testResult.get(i).getId());
					System.out.println("Name: " + testResult.get(i).getName());
					System.out.println("Test 1 score: " + testResult.get(i).getTest1());
					System.out.println("Test 2 score: " + testResult.get(i).getTest2());
					System.out.println("Overall score: " + testResult.get(i).getOverallScore());
					System.out.println("Grade: " + testResult.get(i).getGrade());
					break;
				}
				else if(!testResult.get(i).compare(inputId)){
					counter1++;
				}
			}
			if(counter1 == testResult.size()) {
				System.out.println("No matching test result. Please try again.");
			}
			break;
			
		case 2 :
			System.out.println("Enter applicant name: ");
			inputName = scanner.next();
			for(int i = 0; i < testResult.size(); i++) {
				if(inputName.equals(testResult.get(i).getName())) {
					System.out.println("Candidate Id: " + testResult.get(i).getId());
					System.out.println("Name: " + testResult.get(i).getName());
					System.out.println("Test 1 score: " + testResult.get(i).getTest1());
					System.out.println("Test 2 score: " + testResult.get(i).getTest2());
					System.out.println("Overall score: " + testResult.get(i).getOverallScore());
					System.out.println("Grade: " + testResult.get(i).getGrade());
					break;
				}	
				else if(!inputName.equals(testResult.get(i).getName())) {
					counter2++;
				}
			}
			if(counter2 == testResult.size()) {
				System.out.println("No matching test result. Please try again.");
			}
			break;
			
		case 3 :
			System.out.println("Enter the two scores indicated below");
			System.out.print("Enter lower bound: ");
			lb = scanner.nextInt();
			System.out.print("Enter upper bound: ");
			ub = scanner.nextInt();
			for(int i = 0; i < testResult.size(); i++) {
				if(lb <= testResult.get(i).getOverallScore() && ub >= testResult.get(i).getOverallScore()) {
					System.out.println("Candidate Id: " + testResult.get(i).getId());
					System.out.println("Name: " + testResult.get(i).getName());
					System.out.println("Test 1 score: " + testResult.get(i).getTest1());
					System.out.println("Test 2 score: " + testResult.get(i).getTest2());
					System.out.println("Overall score: " + testResult.get(i).getOverallScore());
					System.out.println("Grade: " + testResult.get(i).getGrade());
					System.out.println();
				}
				else if(testResult.get(i).getOverallScore() < lb || testResult.get(i).getOverallScore() > ub){
					counter3++;
				}
			}
			if(counter3 == testResult.size()) {
				System.out.println("No matching test result. Please try again.");
			}
			break;
			
		case 4 :
			ArrayList<Integer> overall = new ArrayList<Integer>();
			for(int i = 0; i < testResult.size(); i++) {
				overall.add(testResult.get(i).getOverallScore());
			}
			Integer max = Collections.max(overall);
			
			for(int i = 0; i < testResult.size(); i++) {	
				if( max == testResult.get(i).getOverallScore()) {
					System.out.println("Candidate Id: " + testResult.get(i).getId());
					System.out.println("Name: " + testResult.get(i).getName());
					System.out.println("Test 1 score: " + testResult.get(i).getTest1());
					System.out.println("Test 2 score: " + testResult.get(i).getTest2());
					System.out.println("Overall score: " + testResult.get(i).getOverallScore());
					System.out.println("Grade: " + testResult.get(i).getGrade());
					break;
				}
			}			
			break;
			
		case 5 :
			for(int i = 0 ; i < testResult.size(); i++) {
				if(testResult.get(i).getOverallScore() < 50) {
					System.out.println("Candidate Id: " + testResult.get(i).getId());
					System.out.println("Name: " + testResult.get(i).getName());
					System.out.println("Test 1 score: " + testResult.get(i).getTest1());
					System.out.println("Test 2 score: " + testResult.get(i).getTest2());
					System.out.println("Overall score: " + testResult.get(i).getOverallScore());
					System.out.println("Grade: " + testResult.get(i).getGrade());
					System.out.println("");
				}
				else if(testResult.get(i).getOverallScore() >= 50) {
					counter5++;
				}
			}		
			if(counter5 == testResult.size()){
				System.out.println("There are no failures!");
			}
			break;
			
		case 6 :
			break;
		}

	}
}
