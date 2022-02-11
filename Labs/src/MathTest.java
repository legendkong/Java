import java.util.Random;
import java.util.Scanner;

//class MyInteger
class MyInteger{
	//Declaring variable 
	private int n;
	
	//Empty constructor to initialize MyInteger
	MyInteger(){	
	}
	
	//Setting up constructor
	MyInteger(int n){
		this.n = n;
	}
	
	//Accessor method
	public int getInteger() {
		return n;
	}
	
	//Mutator method
	public void setInteger(int n) {
		this.n = n;
	}	
}


//Main class
public class MathTest {

	public static void main(String[] args) {
		
		//Initializing variables
		int score = 0;
		int answer;
		char oper;
		char agree;
		
		//Constructing objects m and n by using empty constructor method
		MyInteger m = new MyInteger();
		MyInteger n = new MyInteger();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the world of Math!");
		System.out.println("You will solve 5 difficult Math questions, are you ready?");
		System.out.println();
		System.out.println("Press Y to continue");
		agree = scanner.next().charAt(0);
		
		if(agree == 'y' || agree == 'Y') {		
		
		System.out.println();
		//Looping through the question for 5 times
		for(int i=1 ; i<6; i++) {
			//Calling the getTwoIntegers method that randomizes m and n
			getTwoIntegers(m,n);
			//Calling and storing the getOperator method that randomizes the operator
			oper = getOperator();
			//Calling accessor method to store value into m and n
			//Converting char of variable oper to string via String.valueOf(oper) 
			System.out.println("Question "+i+": "+(m.getInteger() +" ")+(String.valueOf(oper)+" ")+(n.getInteger())+" = ?");
			System.out.print("Your answer: ");
			//Asking user for their answer and storing the value into <answer>
			answer = scanner.nextInt();
			
			//calling checkAnswer method and checking whether it is true or false.
			//if checkAnswer method returns true,
			if(checkAnswer(m.getInteger(), n.getInteger(), oper, answer) == true) {
				System.out.println("Correct answer");
				System.out.println();
				//Add 1 to score for every correct answer per loop
				score++;
			//else if checkAnswer method returns false,
			}else {
				System.out.println("Wrong answer");
				System.out.println();
			}
		}
		
		//if value of score = 5 after 5 loops,
		if(score == 5) {
			System.out.println("Your score is "+ score + "/5, well done! :)");
		//else if value of score < 5 after 5 loops,
		}else {
			System.out.println("Your score is "+ score + "/5, better luck next time! :)");
		}
		scanner.close();
		}else {
			System.out.println();
			System.out.println("Don't be afraid of Math! Math is fun:) Come back next time!");
		}
	}
	
	
	//Creating a method to randomize two integers, m and n
	public static void getTwoIntegers(MyInteger m, MyInteger n) {	
		//Generate a random number from 0.00 - 9.99 and then rounding down to get value of 0 - 9
		//Typecasting to convert long value to int value
		int x = (int) Math.floor(Math.random() * 10);		
		int y = (int) Math.floor(Math.random() * 10);
		//Set x and y into m and n respectively
		m.setInteger(x);
		n.setInteger(y);
	}
	
	
	//Creating a method to randomize the operator
	public static char getOperator() {		
		//new Random creates a Random object, and then .nextInt(3) generates a random number from 1-3
		//.charAt applied to "+-*" with a random location of 0-2 defined by the random number, giving the value of the char at that random index
		char oper = "+-*".charAt((new Random()).nextInt(3));
		return oper;
	}
	
	
	//Creating a boolean method that returns a true or false value based on whether the user's answer is correct or wrong
	public static boolean checkAnswer(int x, int y, char oper, int answer) {
		
		//Creating a switch case with 3 cases of different operators( -, +, *)
		switch (oper) {
			case '-':
				//nested if statement inside switch cases to check whether answer is equal to x - y. If answer is equal, return true
				if(answer == x - y) {
					return true;
				};
				break;
				//nested if statement inside switch cases to check whether answer is equal to x + y. If answer is equal, return true
			case '+':
				if(answer == x + y) {
					return true;
				};
				break;
				//nested if statement inside switch cases to check whether answer is equal to x * y. If answer is equal, return true
			case '*':
				if(answer == x * y) {
					return true;
				};
				break;
		//if answer is wrong, return false 
		}return false;
	}
}

