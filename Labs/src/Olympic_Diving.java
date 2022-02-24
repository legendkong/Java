//A program that computes Diver's olympic scores
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Random;

//Class country that contains name, player and age
 class Country {
	//Declaring variables
	String name;
	String player;
	int age;
	
	//Setting up constructor
	Country(String name, String player, int age){
		this.name = name;
		this.player = player;
		this.age = age;
	}
	
	//Accessor and mutator methods
	public String getName() {
		return name;
	}
	
	public String getPlayer() {
		return player;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setInfo(String name, String player, int age) {
		this.name = name;
		this.player = player;
		this.age = age;
	}
}


 class Diving {
	 //Declaring variables
	 //total of 7 judges
	 static int SIZE = 7;
	 Country name;
	 double[] score;
	 double difficulty;
	 double cf;
	 double fs;
	 
	 //Setting up constructor
	public Diving(Country name, double[] score, double difficulty, double cf){
		 this.name = name;
		 
		 // initialize the scores array with random scores
	     this.score = new double[SIZE];
	     for (int i = 0; i < SIZE; i++) {
	         // get a random double number
	         double s = 0 + new Random().nextDouble() * (10D - 0D);
	         double s_5 = ((int)(s*2+0.5))/2.0;
	         // round it to 1 decimal place & store in the array
	         String sc = String.format("%.1f", s_5);
	         score[i] = Double.parseDouble(sc);
	        }
		 
		 this.difficulty = difficulty;
		 this.cf = cf;
	 }
	 
	 //Accessor and mutator methods
	public Country getCountry() {
		return name;
	}
	public double getDifficulty() {
		return difficulty;
	}
	public double getCarriedForward() {
		return cf;
	}
	public double getFinalScore() {
		return fs;
	}
	public void setDifficulty(double difficulty) {
		this.difficulty = difficulty;
	}
	
	//Stores scores in a list and sort it in ascending order
	public double[] getSortedList(){
	
		for(int a=0;a<score.length;a++)
		{
			for(int b=a;b<score.length;b++)
			{
				if(score[a]>score[b])
				{
					//swapping the position of elements
					double temp = score[a];
					score[a] = score[b];
					score[b] = temp;
				}
			}
		}
		
		//returns the sorted sc[] array
		return score;
	};
	
	//method to store the highest score
	double highest() {
		double [] score = getSortedList();
		int h = score.length - 1;
		double highest = score[h];
		return highest;
	}
	
	//method to store the second highest score
	double secondHighest() {
		double [] score = getSortedList();
		int sh = score.length - 2;
		double sHighest = score[sh];
		return sHighest;
	}
	
	//method to store the lowest score
	double lowest() {
		double [] score = getSortedList();
		int l = score.length - score.length;
		double lowest = score[l];
		return lowest;
	}
	
	//method to store the second lowest score
	double secondLowest() {
		double [] score = getSortedList();
		int sl = score.length - (score.length - 1);
		double sLowest = score[sl];
		return sLowest;
	}
	
	double finalScore() {
		double [] score = getSortedList();
		fs =0.0;
		for(int i=0;i<score.length;i++)
		{
			fs = fs + score[i];
		}
		
		fs = fs - highest() - secondHighest() - lowest() - secondLowest();
		
		fs = fs * getDifficulty();
		
		return fs;
	}
	
	double getTotalScore() {
		double totalScore = finalScore() + getCarriedForward();
		return totalScore;
	}
	
	public void printInfo() {
		System.out.printf("\n%-12s%-12s%-12d%10.1f", name.getName(), name.getPlayer(), name.getAge(), getDifficulty());
	}
 }


//Main class
public class Olympic_Diving {
	
	//method  to round score to nearest 0.5
	public static double roundToHalf(double d) {
	    return Math.round(d * 2) / 2.0;
	} 
	
	//Create array of 10 countries
	final static String[] Countries = {"Australia", "China", "Dubai", "Singapore", "Malaysia", "Vietnam", "South Korea", "Japan", "North Korea", "Thailand"};
	
	//Create array of 10 players
	final static String[] Players = {"M Oxford", "Xi Z Peng", "Amirulshah", "J Kong", "Tan B B", "L Htat", "Kim KJ", "M. D Luffy", "Kim J U", "Pr. Prom"};
	
	
	public static void main(String[] args) {
	
				double[] score = new double[7];
				
				//cfArray to store carried forward scores 
				double[] cfArray = new double[Countries.length];
				
				//declare and initiate age array to get random age 
				int[] age = {getAge(), getAge(), getAge(), getAge(), getAge(), getAge(), getAge(), getAge(), getAge(), getAge()};
				
				//for loop to generate 5 rounds 
				for(int r=0;r<5;r++)
				{
					//create new Arraylist alist to store diving objects 
					ArrayList<Diving>alist = new ArrayList<Diving>();
					
					//create 10 diving object using for loop
					for(int c=0; c<Countries.length;c++)
					{
						//create country object by invoking 
						Country a = new Country(Countries[c], Players[c], age[c]);
						
						//create diving object 
						Diving diver = new Diving(a, score, getDifficulty(), cfArray[c]);
						
						//call getScore() method to generate random scores
						//getScore(diver.finalScore());
						
						//store diving object in alist 
						alist.add(diver);
					}
				
					//to display round number 
					System.out.printf("\nRound: %d", r+1);
					
					//call displayGameInfo() method using alist
					displayGameInfo(alist);
					
					//call displayResultInfo() method using alist
					displayResultInfo(alist);
					
					//call displaySortedList() method using alist 
					displaySortedList(alist);
					
					//call updateCFArray() method using alist and cfArray
					updateCFArray(alist, cfArray);	
					System.out.println();		
				}				   
	}
	
	public static void getScore(double[] score) {
		//Creating an array of 7 scores for a player
		double[] sc = new double[7];
		sc[0] = roundToHalf(Math.random()*10);
		sc[1] = roundToHalf(Math.random()*10);
		sc[2] = roundToHalf(Math.random()*10);
		sc[3] = roundToHalf(Math.random()*10);
		sc[4] = roundToHalf(Math.random()*10);
		sc[5] = roundToHalf(Math.random()*10);	
		sc[6] = roundToHalf(Math.random()*10);	
		//System.out.println(Arrays.toString(score1));
	}
	
	//Method to display the ranking
	static void displaySortedList(ArrayList<Diving>alist) {
	
		System.out.printf("\n\nThe result is");
		
		//Arraylist to store results and countries
		ArrayList<Double>results = new ArrayList<Double>();
		ArrayList<String>position = new ArrayList<String>();
		
		//for loop to get the results and countries from each diver object stored in alist
				for(int i=0; i<alist.size(); i++)
				{
					Diving diver = alist.get(i);
					position.add(diver.getCountry().name);
					results.add(diver.getTotalScore());
				}

				//for loop to sort the rank of countries
				for(int a=0;a<results.size();a++)
				{
					for(int b=a;b<results.size();b++)
					{
						if(results.get(b)>results.get(a))
						{
							//swap the postions of countries and results in descending order
							String tempc = position.get(a);
							double temp = results.get(a);
							results.set(a, results.get(b));
							position.set(a, position.get(b));
							results.set(b, temp);
							position.set(b, tempc);
						}
					}
					
					//to display the ranking of each country and their score 
		System.out.printf("\n%-4d%-14s%10.2f",a+1, position.get(a), results.get(a));
				}
	}
	
	//Method to get difficulty between 2.0-5.0
	public static double getDifficulty() {
		//random number from 2-5
		double difficulty = Math.random()* (5.0 - 2.0) + 2.0;
		//round difficulty to one decimal place
		double roundedDifficulty = Math.round(difficulty*10.0)/10.0;
		return roundedDifficulty;
	}
	
	//Method to get age between 15-30
	public static int getAge() {
		int age = (int) (Math.random()* (30-15)+15);
		return age;
	}
	
	//Method to display the game info
	public static void displayGameInfo(ArrayList<Diving> alist) {
		System.out.printf("\nStarting Position\n");
		System.out.printf("\n%-12s%-12s%-12s%10s", "Country", "Diver", "Age", "Difficulty");
		
		//for loop to get each diving object from arraylist
		for(int i = 0; i < alist.size(); i++) {
			//Create diver object using arraylist
			Diving diver = alist.get(i);
			diver.printInfo();
		}
	}
	
	//Method to display the result(Display result method tgt with printInfo() from Diving)
	public static void displayResultInfo(ArrayList<Diving> alist) {
		System.out.println();
		System.out.printf("\n%-12s%6s%6s%6s%6s%6s%6s%6s%12s%10s%10s%10s", "Countries", 
				"J1", "J2", "J3", "J4", "J5", "J6", "J7", "Difficulty", "c/f", "Current", "Total");
		
		//for loop to get each diving object from alist
		for(int i = 0; i < alist.size(); i++) {
			//create diver object using alist
			Diving diver = alist.get(i);
			
			//Display name of countries
			System.out.printf("\n%-12s", diver.getCountry().name);
			
			//for loop to get and display judges score
			for( int e = 0; e < diver.score.length; e++)
			{
				System.out.printf("%6.1f", diver.score[e]);
			}
			
			//display the rest of the result information 
			System.out.printf("%12.1f%10.2f%10.2f%10.2f", diver.getDifficulty(), diver.getCarriedForward(), diver.finalScore(), diver.getTotalScore());
		}
	}
	
	//Method to update the Carried Forward array
	static void updateCFArray(ArrayList<Diving> alist, double[] cfArray) {
		//for loop to get each diving object from alist
		for(int i=0; i<alist.size(); i++)
		{
			//create diver object using alist
			Diving diver = alist.get(i);
			
			//update the carried forward score 
			cfArray[i] = diver.getTotalScore();
		}		
	}
	
}
