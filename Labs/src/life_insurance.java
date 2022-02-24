//enumeration Gender
enum Gender {
	Male,
	Female;
}

//Name class 
class Name {
	String firstName;
	String secondName;
	String lastName;
	
	Name(){		
	}
	
	//Creating Name constructor
	Name(String firstName, String secondName, String lastName){
		this.firstName = firstName;
		this.secondName = secondName;
		this.lastName = lastName;
	}
	
	//Default constructor
	Name(Name n){
	 
	}
	
	//Accessor methods
	String getFirstName() {
		return firstName;
	}
	
	String getSecondName() {
		return secondName;
	}
	
	String getLastName() {
		return lastName;
	}
	
	//Mutator method
	void setInfo(String firstName, String secondName, String lastName) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.lastName = lastName;
	}
	
	//Function to get full name
	String fullName() {
		return getFirstName()+" "+getSecondName()+" "+getLastName();
	}
	
	//Function to get AKA
	String alsoKnownAs() {
		//First element of first name
		char fn = firstName.charAt(0);
		//First element of second name
		char sn = secondName.charAt(0);
		return fn+". "+sn+". "+lastName;
	}
}

//Creating class Customer
class Customer{
	Name n;
	Gender g;
	int birthYear;
	
	//Default constructor
	Customer(){	
	}
	
	//Creating Customer constructor
	Customer(Name n, Gender g, int birthYear){
		this.n = n;
		this.g = g;
		this.birthYear = birthYear;
	}
	
	//Accessor methods
	Name getName() {
		return n;
	}
	
	Gender getGender() {
		return g;
	}

	int getBirthYear() {
		return birthYear;
	}
	
	//Mutator method
	void setInfo(Name n, Gender g, int birthYear) {
		this.n = n;
		this.g = g;
		this.birthYear = birthYear;
	}
}

//Creating class Insurance
class Insurance{
	//Initialize Policy number
	static int NO = 2022001;
	final int VALUE1 = 15;
	final int VALUE2 = 20;
	int policyNo;
	Customer c;
	int currentYear;
	
	//Insurance constructor
	Insurance(Customer c, int currentYear){
		this.c = c;
		this.currentYear = currentYear;
	}
	
	//copy constructor for insurance
	Insurance(Insurance i){ 
		this.c = i.c;
		this.currentYear = i.currentYear;
	}
	
	//Accessor methods
	int getPolicyNo() {
		//Increment policy number by 1 everytime getPolicy is called
		policyNo = NO++;
		return policyNo;
	}
	
	Customer getCustomer() {
		return c;
	}
	
	int getCurrentYear() {
		return currentYear;
	}
	
	int getAge() {
		int age;
		age = currentYear - c.getBirthYear();
		return age;
	}
	
	//method to compute premium
	double computePremium() {
		//Get the first character of int age, e.g if age = 38, decade = 3
		int decade = Integer.parseInt(Integer.toString(getAge()).substring(0, 1));
		//Formula to calculate premium: (decade + 15) * 20
		int premium = (decade + VALUE1) * VALUE2;
		return premium;
	}
	
	
	void displayInfo() {
		System.out.println("Policy No: " + getPolicyNo());
		System.out.println("Full Name: " + c.n.fullName());
		System.out.println("Also known as: " + c.n.alsoKnownAs());
		System.out.println("Gender: " + c.getGender());
		System.out.println("Year of birth: " + c.getBirthYear());
		System.out.println("Current Year: " + getCurrentYear());
		System.out.println("Age: " + getAge() + " years old");
		System.out.println("Premium: $ " + computePremium()+"0");
		System.out.println("---------------------------------------------------------");
	}
}


//Main class
public class life_insurance {

	public static void main(String[] args) {
		
		
		//Creating objects for first profile
		Name name1 = new Name("Boon", "Lieng", "Kong"); 
		Customer customer1 = new Customer(name1, Gender.Male, 1956);
		Insurance insurer1 = new Insurance(customer1, 2018);
		insurer1.displayInfo();
		
		//Creating objects for second profile
		Name name2 = new Name("Bei", "Lun", "Fiora"); 
		Customer customer2 = new Customer(name2, Gender.Female, 1988);
		Insurance insurer2 = new Insurance(customer2, 2022);
		insurer2.displayInfo();
		
		//Creating objects for third profile
		Name name3 = new Name("Toh", "Lee", "Jet"); 
		Customer customer3 = new Customer(name3, Gender.Male, 1999);
		Insurance insurer3 = new Insurance(customer3, 2022);
		insurer3.displayInfo();
		
		//Creating objects for fourth profile (copy constructor of third profile, just switched a few attributes around)
		Insurance insurer4 = new Insurance(insurer3);
		insurer4.getCustomer().birthYear = 2001;
		insurer4.getCustomer().n.secondName = "Wei";
		insurer4.displayInfo();
	}

}
