enum Type{
	Equilateral, //All three sides are equal, also an Isosceles triangle
	Isosceles, 	 //Any two sides which are equal
	Scalene,	 //All three sides are different
	NotTriangle	 //Not a triangle
}

class PossibleTriangle{
	//Declaring variables
	private int a;
	private int b;
	private int c;
	private Type pt;
	
	//Setting up constructor
	PossibleTriangle(int a, int b, int c, Type pt){
		this.a = a;
		this.b = b;
		this.c = c;
		this.pt = pt;
	}
	
	//Constructing accessor and mutator methods
	public int getA() {
		return a;
	}
	public int getB() {
		return b;
	}
	public int getC() {
		return c;
	}
	public Type getPt() {
		return pt;
	}
	
	public void setA(int a) {
		this.a = a;
	}
	public void setB(int b) {
		this.b = b;
	}
	public void setC(int c) {
		this.c = c;
	}
	public void setPt(Type pt) {
		this.pt = pt;
	}
	
	//A method to test and to return (true or false) if three integers can form a triangle
	private boolean isTriangle() {
		if(a > 0 && b > 0 && c > 0) {
			if((a+b)>c && (a+c)>b && (c+b)>a) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
	
	//A method to check which kind of triangle is it
	private Type getType() {
		if(isTriangle()==true) {
			if(a==b && b==c && a==c ) {
				return Type.Equilateral;
			}
			else if(a==b || b==c || a==c) {
				return Type.Isosceles;
			}
			else if(a!=b && b!=c && a!=c) {
				return Type.Scalene;
			}
		}
		return Type.NotTriangle;
	}
	
	public void displayInfo() {
		System.out.println("a = "+a+", b = "+b+", c = "+c);
		
		switch(getType()) {
			case Equilateral:
				System.out.println("Equilateral triangle");
				System.out.println("Isosceles triangle");
				System.out.println("A triangle");
				Seperator();
				break;
			case Isosceles:
				System.out.println("Isosceles triangle");
				System.out.println("A triangle");
				Seperator();
				break;
			case Scalene:
				System.out.println("A triangle");
				Seperator();
				break;
			case NotTriangle:
				System.out.println("Not a triangle");
				Seperator();
				break;
		}
	}
	
	private void Seperator() {
		System.out.println("--------------------------------------------------");
	}
}

//Main method
public class TypeOfTriangle {

	public static void main(String[] args) {
		
		int a = 4;
		int b = 5;
		int c = 6;
		Type pt = Type.NotTriangle;
		
		//Initializing and creating a triangle object
		PossibleTriangle triangle = new PossibleTriangle(a, b, c, pt);
		triangle.displayInfo();
		
		//Set new values for second triangle info
		triangle.setA(1);
		triangle.setB(2);
		triangle.setC(3);		
		triangle.displayInfo();
		
		//Set new values for third triangle info
		triangle.setA(4);
		triangle.setB(5);
		triangle.setC(5);
		triangle.displayInfo();
		
		//Set new values for fourth triangle info
		triangle.setA(6);
		triangle.setB(6);
		triangle.setC(6);
		triangle.displayInfo();
	}
}
