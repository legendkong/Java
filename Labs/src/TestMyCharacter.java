//Design a class to describe what a character is?

//It consists of letters, digits and others

enum CharacterType {LETTER, DIGIT, OTHER}

class MyCharacter
{
	private char ch;
	private CharacterType ct;
	
	//Default constructor
	public MyCharacter()
	{
		ch = ' ';
		ct = CharacterType.OTHER;
	}
	
	//Other constructor
	public MyCharacter(char ch, CharacterType ct)
	{
		this.ch = ch;
		this.ct = ct;
	}
	
	//Copy constructor
	public MyCharacter(MyCharacter mc)
	{
		this(mc.ch, mc.ct);
	}
	
	//Accessor method
	public char getCharacter()
	{
		return ch;
	}
	
	public CharacterType getType()
	{
		return ct;
	}
	
	//Mutator method
	public void setInfo(char ch, CharacterType ct)
	{
		this.ch = ch;
		this.ct = ct;
	}
	
	public void displayInfo()
	{
		System.out.printf("Character is \'%c\'. Its type is %s%n", ch, ct);
	}
	
}

public class TestMyCharacter {

	public static void main(String[] args) {
		
		//Construct a few object
		MyCharacter mc0 = new MyCharacter();
		MyCharacter mc1 = new MyCharacter('a', CharacterType.LETTER);
		MyCharacter mc2 = new MyCharacter('4', CharacterType.DIGIT);
		MyCharacter mc3 = new MyCharacter('$', CharacterType.OTHER);
		
		//Display all objects
		mc0.displayInfo();
		mc1.displayInfo();
		mc2.displayInfo();
		mc3.displayInfo();
	}

}
