import java.util.Scanner;

public class Triangle {

	private static final String LINE = "---------"+"---------"+"---------"+"---------"+"---------"+"---------";
	public static void main(String[] args) {
		
		double a1, b1, c1, area1, perimeter1;
		double a2, b2, c2, area2, perimeter2;
		
		Scanner input = new Scanner(System.in);
		
		//read 3 sides of triangle 1
		System.out.println("Enter 3 sides of a triangle : ");
		a1 = input.nextDouble();
		b1 = input.nextDouble();
		c1 = input.nextDouble();
		
		//compute area and perimeter
		double s = (a1+b1+c1) / 2.0;
		area1 = Math.sqrt(s * (s-a1) * (s-b1) * (s-c1));
		perimeter1 = a1 + b1 + c1;
		
		//to get rid of input buffer
		//input.nextLine();
		
		//read 3 sides of triangle 2
		System.out.println("Enter 3 sides of a triangle : ");
		a2 = input.nextDouble();
		b2 = input.nextDouble();
		c2 = input.nextDouble();
		
		//compute area and perimeter
		double s2 = (a2+b2+c2) / 2.0;
		area2 = Math.sqrt(s2 * (s2-a2) * (s2-b2) * (s2-c2));
		perimeter2 = a2 + b2 + c2;
		
		//display the table (compiler left justify the output)
		System.out.println(LINE);
		
		System.out.printf("%-5s"+"%-10s"+"%-10s"+"%-10s"+"%-10s"+"%-10s%n",
							"No","a","b","c","area","perimeter");
		System.out.println();
		
		System.out.printf("%-5s"+"%-10.4f"+"%-10.4f"+"%-10.4f"+"%-10.4f"+"%-10.4f%n",
						  "1",a1,b1,c1,area1,perimeter1);
		
		System.out.printf("%-5s"+"%-10.4f"+"%-10.4f"+"%-10.4f"+"%-10.4f"+"%-10.4f%n",
				  "2",a2,b2,c2,area2,perimeter2);
		
		System.out.println(LINE);
	}
}
