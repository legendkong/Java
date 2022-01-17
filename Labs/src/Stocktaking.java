import java.util.Scanner;

// Full Name: Kong Boon Lieng
// Student number : 10237962
// Full time student
// Tutorial Group : T04F
// File name : KongBoonLieng_A1.java
// Declaration : This is my own work and I did not copy or plagiarize people's work.


public class Stocktaking {
	
	private static final String LINE = "---------"+"---------"+"---------"+"---------"+"---------"+"-------------";
	public static void main(String[] args) {
		
		//Creating variables
		String phone1, phone2, phone3, address, postal, country;
		int qty1, qty2, qty3;
		double price1, price2, price3;
		
		
		Scanner scanner = new Scanner(System.in);
		
		//Intro
		System.out.println("Welcome to iPhone online service");
		System.out.println(LINE);
		System.out.println("Enter three iPhones to be sold");
		System.out.print("1. ");
		phone1 = scanner.nextLine();
		System.out.print("2. ");
		phone2 = scanner.nextLine();
		System.out.print("3. ");
		phone3 = scanner.nextLine();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		//Some other info
		System.out.println("Some other info");
		System.out.println(LINE);
		System.out.print("Delivery address: ");
		address = scanner.nextLine();
		System.out.print("Postal code: ");
		postal = scanner.nextLine();
		System.out.print("Country: ");
		country = scanner.nextLine();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		//Quantities and prices of phones on sale
		System.out.print("Enter the quantities and price of "+phone1+": ");
		qty1 = scanner.nextInt();
		price1 = scanner.nextDouble();
		System.out.print("Enter the quantities and price of "+phone2+": ");
		qty2 = scanner.nextInt();
		price2 = scanner.nextDouble();
		System.out.print("Enter the quantities and price of "+phone3+": ");
		qty3 = scanner.nextInt();
		price3 = scanner.nextDouble();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		//Summary of stocks
		System.out.println("Summary of iPhones");
		System.out.println(LINE);
		System.out.printf("%-25s"+"%-25s"+"%-25s%n", "iPhone", "Quantity", "Price");
		System.out.println(LINE);
		System.out.printf("%-25s"+"%-25s"+"%-25s%n", phone1, qty1, price1);
		System.out.printf("%-25s"+"%-25s"+"%-25s%n", phone2, qty2, price2);
		System.out.printf("%-25s"+"%-25s"+"%-25s%n", phone3, qty3, price3);
		System.out.println(LINE);
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		//Swap first phone with second phone
		System.out.println("Summary of iPhones after the swaps");
		System.out.println(LINE);
		System.out.printf("%-25s"+"%-25s"+"%-25s%n", "iPhone", "Quantity", "Price");
		System.out.println(LINE);
		System.out.printf("%-25s"+"%-25s"+"%-25s%n", phone2, qty2, price2);
		System.out.printf("%-25s"+"%-25s"+"%-25s%n", phone1, qty1, price1);
		System.out.printf("%-25s"+"%-25s"+"%-25s%n", phone3, qty3, price3);
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		//Customer places order
		int order1, order2, order3;
		
		System.out.println("Please place your order");
		System.out.println(LINE);
		System.out.print("No of "+phone2+": ");
		order1 = scanner.nextInt();
		System.out.print("No of "+phone1+": ");
		order2 = scanner.nextInt();
		System.out.print("No of "+phone3+": ");
		order3 = scanner.nextInt();
		System.out.println();
		System.out.println();
		System.out.println();
		
		//Summary of customer's order
		System.out.println("Summary of your order");
		System.out.println(LINE);
		System.out.printf("%-25s"+"%-25s"+"%-25s%n", "iPhone", "Quantity", "Cost");
		System.out.println(LINE);
		
		double cost1,cost2,cost3,total,gst;
		cost1 = price2*order1;
		cost2 = price1*order2;
		cost3 = price3*order3;
		total = cost1+cost2+cost3;
		gst = 0.07*total;
		
		
		cost1 = Math.round(cost1 * 100);
		cost1 = cost1/100;
		cost2 = Math.round(cost2 * 100);
		cost2 = cost2/100;
		cost3 = Math.round(cost3 * 100);
		cost3 = cost3/100;
		total = Math.round(total * 100);
		total = total/100;
		gst = Math.round(gst * 100);
		gst = gst/100;
		

		System.out.printf("%-25s"+"%-25s"+"%-25s%n", phone2, order1, cost1);
		System.out.printf("%-25s"+"%-25s"+"%-25s%n", phone1, order2, cost2);
		System.out.printf("%-25s"+"%-25s"+"%-25s%n", phone3, order3, cost3);
		System.out.println(LINE);
		System.out.printf("%-50s"+"%-50s%n", "Subtotal:", total);
		System.out.printf("%-50s"+"%-50s%n", "GST (7%):", gst);
		System.out.printf("%-50s"+"%-50s%n", "Total cost:", (total+gst));
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		//Balance report
		System.out.println("Balance report");
		System.out.println(LINE);
		System.out.printf("%-25s"+"%-25s"+"%-25s"+"%-20s%n", "iPhone", "Quantity", "Sold", "Balance");
		System.out.println("--------------------------------------------------------------------------------------------");
		System.out.printf("%-25s"+"%-25s"+"%-25s"+"%-20s%n", phone2, qty2, order1, (qty2-order1));
		System.out.printf("%-25s"+"%-25s"+"%-25s"+"%-20s%n", phone1, qty1, order2, (qty1-order2));
		System.out.printf("%-25s"+"%-25s"+"%-25s"+"%-20s%n", phone3, qty3, order3, (qty3-order3));
		System.out.println("--------------------------------------------------------------------------------------------");
			
	}
}
