import java.util.Scanner;

class WeeklyPay {
	String employeeId;
	String employeeName;
	int hoursWorked;
	int hourlyRate;
	
	//Constructor
	public WeeklyPay(String employeeId, String employeeName, int hoursWorked, int hourlyRate) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.hoursWorked = hoursWorked;
		this.hourlyRate = hourlyRate;
	}
		
	private double getPay(){
		if(hoursWorked > 40) {
			double overtime = (hoursWorked - 40) * hourlyRate * 2;
			double weeklyPay = 40 * hourlyRate;
			return overtime + weeklyPay;
		}
		double weeklyPay = hoursWorked * hourlyRate;
		return weeklyPay;
	}
	
	
	public void printInfo() {
		System.out.println(employeeId + " " + employeeName + " $" + getPay());
	}
}


public class T01F_KongBoonLieng_Lab1 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		String employeeId;
		String employeeName;
		int hoursWorked;
		int hourlyRate;

		
		System.out.println("Please enter your employee id:");
		employeeId = scanner.nextLine();
		
		System.out.println("Please enter your employee name:");
		employeeName = scanner.nextLine();
		
		System.out.println("Please enter hours worked:");
		hoursWorked = scanner.nextInt();
		
		System.out.println("Please enter hourly rate:");
		hourlyRate = scanner.nextInt();
		
		
		WeeklyPay e1 = new WeeklyPay(employeeId, employeeName, hoursWorked, hourlyRate);
		
		e1.printInfo();
		
	}

}
