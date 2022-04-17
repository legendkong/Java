import java.util.Scanner;

class Cylinder {
	
	//Initializing instance variables
	String type;
	int radius;
	int height;
	
	//Constructor
	public Cylinder(String type, int radius, int height) {
		this.type = type;
		this.radius = radius;
		this.height = height;
	}
	
	//Get methods
	public int getRadius() {
		return radius;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getVolume() {
		//Volume = pie x r(square) x h
		int volume = (int) Math.round(Math.PI * (getRadius() * getRadius()) * getHeight());
		return volume;
	}
	
	//Instance method
	public void printString() {
		System.out.println("");
		System.out.println("Container Search: ");
		System.out.println("1 By type");
		System.out.println("2 By volume");
		System.out.println("3 Quit");
		System.out.println("Your selection?");
		
	}
}



public class T01F_KongBoonLieng_Lab2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		//Initalizing variables
		String type;
		int radius;
		int height;
		int input;
		int volume;
		
		//Initializing cylinder array
		Cylinder[] cylinder = new Cylinder[5];
		
		//Store values five times
		for(int i=0; i<5; i++) {
			//Prompting user to enter type, radius and height
			System.out.print("Container type: ");
			type = scanner.next().toLowerCase();
			
			System.out.print("Radius: ");
			radius = scanner.nextInt();
			
			System.out.print("Height: ");
			height = scanner.nextInt();
			
			//Init 5 elements objects of array	
			cylinder[i] = new Cylinder(type, radius, height);	
		}
		
		//Call instance method of cylinder class
		cylinder[0].printString();
		//User to input option
		input = scanner.nextInt();
		
		//Switch cases for option 1 - 3
		switch(input) {
		case 1 : 
			System.out.print("Enter type: ");
			type = scanner.next().toLowerCase();
			//Loop through cylinder array to find whether there's the same type
			for(int i = 0; i < cylinder.length; i++) {
				if(type.equals(cylinder[i].type)) {
					System.out.println(type + " container with volume " + cylinder[i].getVolume());
				}
			}
			break;
		case 2 : 
			//Loop through cylinder array to find elements with volume bigger than user volume input
			System.out.println("Enter volume: ");
			volume = scanner.nextInt();
			for(int i = 0; i < cylinder.length; i++) {
				if(volume <= cylinder[i].getVolume()) {
					System.out.println(cylinder[i].type + " container with volume " + cylinder[i].getVolume());
				}
			}
			break;
		case 3 :
			System.out.println("Goodbye.");
			break;
		}
	}

}
