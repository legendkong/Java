import java.util.Scanner;

public class Triangle {

	public static void main(String[] args) {
		
		Scanner myTriangle = new Scanner(System.in);
		
		System.out.println("Enter the 3 sides of the triangle:");
		
		System.out.print("a = ");
		double a = myTriangle.nextDouble();
		
		System.out.print("b = ");
		double b = myTriangle.nextDouble();
		
		System.out.print("c = ");
		double c = myTriangle.nextDouble();
		
		
		//Compute the perimeter of triangle
		System.out.println("The perimeter of the triangle is :" + (a+b+c));
		
		//Compute the area of triangle using Herons' rule
		double s = (a+b+c)/2;
		double z = s*((s-a)*(s-b)*(s-c));
		
		System.out.println("The area of the triangle is : " + Math.sqrt(z));
		
	}

}
