import java.util.Scanner;

//Creating a class enum Month containing JAN-DEC
enum Month {
	Jan,
	Feb,
	Mar,
	Apr,
	May,
	Jun,
	Jul,
	Aug,
	Sep,
	Oct,
	Nov,
	Dec
}

// Creating a class Date
class Date {
	int day;
	Month month;
	int year;

	// Setting up constructor
	Date (int day, Month month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	//Setting up default constructor
	Date(Date d) {
		day = 1;
		month = Month.Jan;
		year = 2021;
	}
	
	//Accessor and mutator methods
	//Getter for day, month and year
	int getDay() {
		return day;
	}
	Month getMonth() {
		return month;
	}
	int getYear() {
		return year;
	}
	
	//Setter for day, month and year
	void setDate(int day, Month month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;	
	}
}

//Creating a class HealthProfile
class HealthProfile{
	String firstName;
	String lastName;
	Date dob;
	double height;
	double weight;
	int currentYear;
	
	//Setting up constructor
	HealthProfile (String firstName, String lastName, Date dob, double height, double weight, int currentYear){
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.height = height;
		this.weight = weight;
		this.currentYear = currentYear;
	}
	
	//Accessor and mutator methods
	//Getter
	String getFirstName() {
		return firstName;
	}
	String getLastName() {
		return lastName;
	}
	Date getDob() {
		return dob;
	}
	double getHeight() {
		return height;
	}
	double getWeight() {
		return weight;
	}
	int getCurrentYear() {
		return currentYear;
	}
	int getAge() {
		int getAge;
		getAge = currentYear - getDob().year;
		return getAge;
	}
	//Setter
	void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	void setLastName(String lastName) {
		this.lastName = lastName;
	}
	void setDob(Date dob) {
		this.dob = dob;
	}
	void setHeight(double height) {
		this.height = height;
	}
	void setWeight(double weight) {
		this.weight = weight;
	}
	void setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}
	void setBMIInfo(double height, double weight) {
		this.height = height;
		this.weight = weight;
	}
	
	//Get maximum heart rate method
	int getMaximumHeartRate() {
		int maxHeartRate;
		maxHeartRate = 220 - getAge();
		return maxHeartRate;
	}
	
	//Get minimum target heart rate method
	double getMinimumTargetHeartRate() {
		double minTargetHeartRate;
		minTargetHeartRate = 0.5 * getMaximumHeartRate();
		return minTargetHeartRate;
	}
	
	//Get maximum target heart rate method
	double getMaximumTargetHeartRate() {
		double maxTargetHeartRate;
		maxTargetHeartRate = 0.85 * getMaximumHeartRate();
		return maxTargetHeartRate;
	}
	
	//calculate BMI method
	double getBMI() {
		double BMI;
		BMI = weight / (height*height);
		return BMI;
	}
	
	void printInfo() {
		System.out.println();
		System.out.printf("Name: %s, %s%n", firstName,lastName);
		System.out.println("Date of birth: "+dob.day+" "+dob.month+" "+dob.year);
		System.out.printf("Your weight: %.1f kg%n", weight);
		System.out.printf("Your height: %.2f meter%n", height);
		System.out.printf("Current year: %d%n", currentYear);
		System.out.printf("Your age: %d years old%n", getAge());
		System.out.printf("Clinic analysis, base on your age:%n");
		System.out.printf("\t1. Your maximum heart rate is %d%n", getMaximumHeartRate());
		System.out.printf("\t2. Your minimum target heart rate is %.2f%n", getMinimumTargetHeartRate());
		System.out.printf("\t3. Your maximum target heart rate is %.2f%n", getMaximumTargetHeartRate());
		System.out.printf("Your BMI is %.1f%n", getBMI());
		System.out.printf("\t%-30s"+"%-10s%n", "Weight category", "Range");
		System.out.printf("\t%-30s"+"%-10s%n", "Underweight / too low", "Below 18.5");
		System.out.printf("\t%-30s"+"%-10s%n", "Healthy Range", "18.5 - 25");
		System.out.printf("\t%-30s"+"%-10s%n", "Overweight", "25 - 30");
		System.out.printf("\t%-30s"+"%-10s%n", "Obese", "30 - 35");
		System.out.printf("\t%-30s"+"%-10s%n", "Severe Obesity", "35 - 40");
		System.out.printf("\t%-30s"+"%-10s%n", "Morbid Obesity", "Over 40");
	}
}

//Main class
class PatientAnalysis {

	public static void main(String[] args) {
		
		//Scanner input
		Scanner scanner = new Scanner(System.in);
		
		String firstName;
		String lastName;
		double height;
		double weight;
		int currentYear;
		int day;
		Month month;
		int year;
		
		//Scanner input for first profile
		firstName = scanner.nextLine();		
		lastName = scanner.nextLine();	
		day = scanner.nextInt();	
		month = Month.valueOf(scanner.next());	
		year = scanner.nextInt();	
		height = scanner.nextDouble();	
		weight = scanner.nextDouble();	
		currentYear = scanner.nextInt();
		scanner.nextLine();
		
		//Creating date object for first profile
		Date date1 = new Date(day, month, year);
		//Creating health profile object for first profile
		HealthProfile profile1 = new HealthProfile(firstName, lastName, date1, height, weight, currentYear);
		
		//Scanner input for second profile
		firstName = scanner.nextLine();		
		lastName = scanner.nextLine();	
		day = scanner.nextInt();	
		month = Month.valueOf(scanner.next());	
		year = scanner.nextInt();	
		height = scanner.nextDouble();	
		weight = scanner.nextDouble();	
		currentYear = scanner.nextInt();
		scanner.nextLine();
		
		//Creating date object for second profile
		Date date2 = new Date(day, month, year);
		//Creating health profile object for second profile;
		HealthProfile profile2 = new HealthProfile(firstName, lastName, date2, height, weight, currentYear);
	
		profile1.printInfo();
		profile2.printInfo();
		
	}

}
