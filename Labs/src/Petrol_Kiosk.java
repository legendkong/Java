import java.util.Scanner;

//Create class for PetrolPurchase
class PetrolPurchase {
	
	//Declare non static private variables (known as instance variables)
	private String station;
	private double quantity;
	private String type;
	private double price;
	private int discount;

	//Setting up constructor
	public PetrolPurchase (String station, double quantity, String type, double price, int discount) {
		this.station = station;
		this.quantity = quantity;
		this.type = type;
		this.price = price;
		this.discount = discount;
	}
	
//Accessor and mutator methods	
	//Getter for station
	String getStation() {
		return station;
	}
	
	//Setter for station
	void setStation(String station) {
		this.station = station;
	}
	
	//Getter for quantity
	double getQuantity() {
		return quantity;
	}
	
	//Setter for quantity
	void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
	//Getter for type
	String getType() {
		return type;
	}
	//Setter for type
	void setType(String type) {
		this.type = type;
	}
	
	//Getter for price
	double getPrice() {
		return price;
	}
	//Setter for price
	void  setPrice(double price) {
		this.price = price;
	}
	
	//Getter for discount
	int getDiscount() {
		return discount;
	}
	//Setter for discount
	void setDiscount(int discount) {
		this.discount = discount;
	}
	
	
//Creating a copy constructor
	PetrolPurchase(PetrolPurchase c) {
		System.out.printf("Duplicate the same object%n");
		this.station = c.station;
		this.quantity = c.quantity;
		this.type = c.type;
		this.price = c.price;
		this.discount = c.discount;
	}
	
	//Creating actualCost method to get actual cost
	private double actualCost() {
		double actualCost = (quantity * price);
		return actualCost;
	}
	
	//Creating discountedPrice method to get discounted price
	private double discountedPrice() {
		double discountprice = discount/100.00 * actualCost();
		return discountprice;
	}
	
	//Creating computePayment method to get net amount
	private double computePayment() {
		double netAmount = actualCost() - discountedPrice();
		return netAmount; 
	}
	
	//Creating a public getPayment method that invokes computePayment method
	public double getPayment() {
		return computePayment();
	}
	
	//Design to a method to display summary of purchase
	public void printInfo() {
		//System.out.printf("%n%n%nSummary of your purchase%n");
		System.out.printf("Station: %s%n", station);
		System.out.printf("Total litre: %.2f%n", quantity);
		System.out.printf("Petrol type: %s%n", type);
		System.out.printf("Price per litre: %.2f%n", price);
		System.out.printf("Actual cost: %.2f%n", actualCost());
		System.out.printf("Discount (%d%%): %.2f%n", discount, discountedPrice());
		System.out.printf("Amount to pay: %.2f%n", computePayment());
	}
}

//Main class
public class Petrol_Kiosk {

	public static void main(String[] args) {
		
		//Scanner input
		Scanner scanner = new Scanner(System.in);
		
		String station;
		double quantity;
		String type;
		double price;
		int discount;
		
		
		System.out.printf("Enter the station: ");
		station = scanner.nextLine();
		
		System.out.printf("Enter quantity in litre: ");
		quantity = scanner.nextDouble();
		
		System.out.printf("Enter type of petrol: ");
		type = scanner.next();
		scanner.nextLine();
		
		System.out.printf("Enter price of petrol: ");
		price = scanner.nextDouble();
		scanner.nextLine();
		
		System.out.printf("Enter discount: ");
		discount = scanner.nextInt();
		
		//Construct an object of using the other constructor
		PetrolPurchase pp = new PetrolPurchase(station, quantity, type, price, discount);
		
		//Display the info
		System.out.printf("%n%n%n");
		System.out.printf("Summary of your purchase%n");
		pp.printInfo();
		
		//Asking user to input additional quantity of petrol
		System.out.printf("%n%n%nEnter additional quantity of petrol: ");
		quantity = scanner.nextDouble();
		//Add additional quantity of petrol to old quantity of petrol
		pp.setQuantity(pp.getQuantity() + quantity);
		
		//Summary of new purchase after additional quantity of petrol
		System.out.printf("%n");
		System.out.printf("Your new purchased price%n");
		pp.printInfo();
		System.out.printf("%n%n%n");
		
		//Invoking copy constructor
		PetrolPurchase copyOfpp = new PetrolPurchase(pp);
		copyOfpp.printInfo();
	}

}

