import java.util.Arrays;
import java.util.Scanner;

/*
Name : Kong Boon Lieng, Jonathan
Student number : 10237962
Tutorial group : T04F

File name : BLKong_Lab_2.java
Declaration : This is my own work and I did not copy or plagiarize people's work.
 */

public class BLKong_Lab_2 {

	public static void main(String[] args) {
			
		while(true) {
			System.out.println("Do you want to encrypt or decrypt?");
			Scanner option = new Scanner(System.in);
			System.out.println("Enter <1> for encryption");
			System.out.println("Enter <2> for decryption");
			String userinput = option.next();
			if(userinput.equals("1")) {
				encryption();
			}
			else if(userinput.equals("2")) {
				decryption();
			}
			else{
				System.out.println("Wrong input. Please choose enter either 1 or 2.");
			}
		}
	}
	
		
//-----------------------------------------------------ENCRYPTION--------------------------------------------------------------------//
	static void encryption() {
		Scanner myEncrypt = new Scanner(System.in); 						//Creating a Scanner object
		System.out.println("Enter 4 digits integer to be encrypted: "); 	//Prompt user for 4 digit integer
		String encrypt = myEncrypt.next();									 //Read user input for 4 digit integer
		

		char [] charsEncrypt = encrypt.toCharArray();						//Creating an array of characters for user input(charsEncrypt) which is initially a string
		int index = 0;														//Initialising index as 0
		
		for(char c : charsEncrypt) {										//Creating a char 'c' and Iterating every single character of array charsEncrypt
			int intC = Character.getNumericValue(c);						//Convert every single char of array to intC which is an integer so I can perform math on it 
			intC += 7;														//Add 7 to each intC
			intC = intC % 10;												//Modulus intC
			char C = (char)(intC + '0');									//Convert intC back to char C
			charsEncrypt[index] = C;										//Char C is assigned to the respective indexes in array CharsEncrypt
			index += 1;														//Increment to next index after every loop
		}
		
		char old0 = charsEncrypt[0];									 	//Retain value of index 0 to char 'old0' 
		char old1 = charsEncrypt[1];										//Retain value of index 1 to char'old1' 
		
		charsEncrypt[0] = charsEncrypt[2];									//assign value of index 2 to index 0
		charsEncrypt[2] = old0;												//Assign the old value of index 0 to index 2
		charsEncrypt[1] = charsEncrypt[3];									//assign value of index 3 to index 1
		charsEncrypt[3] = old1;												//Assign the old value of index 1 to index 3
		System.out.print("The encrypted message is: ");
		System.out.println(charsEncrypt);
	
	}
	
//-----------------------------------------------------DECRYPTION----------------------------------------------------------------------//
	static void decryption() {
		Scanner myDecrypt = new Scanner(System.in); //Creating a Scanner object
		System.out.println("Enter 4 digits integer to be decrypted: "); //Prompt user for 4 digit integer
		String decrypt = myDecrypt.next(); //Read user input for 4 digit integer
		
		char [] charsDecrypt = decrypt.toCharArray(); //Create an array of characters for user input which is initially a string
		int newIndex = 0;
		
		for(char b : charsDecrypt) {
			int intB = Character.getNumericValue(b);
			intB += 3;
			intB = intB % 10;
			char B = (char)(intB + '0');
			charsDecrypt[newIndex] = B;
			newIndex += 1;
		}
		
		char old00 = charsDecrypt[0];
		char old01 = charsDecrypt[1];
		
		charsDecrypt[0] = charsDecrypt[2];
		charsDecrypt[2] = old00;
		charsDecrypt[1] = charsDecrypt[3];
		charsDecrypt[3] = old01;
		
		System.out.print("The decrypted message is: ");
		System.out.println(charsDecrypt);
	}
	
}
