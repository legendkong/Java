
class PlayingCard
{
	private char suit;
	private char rank;
	
	public PlayingCard(char suit, char rank)
	{
		this.suit = suit;
		this.rank = rank;
	}
	
	public PlayingCard(PlayingCard pc)
	{
		this(pc.suit, pc.rank);
		
	}
	
	public char getSuit()
	{
		return suit;
	}
	
	public char getRank()
	{
		return rank;
	}
	
	public void setInfo(char suit, char rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	public void displayInfo()
	{
		System.out.printf("%c%c   ", suit, rank);
	}
}


class PlayingCards
{	
	private static final int NO = 52;
	private static final String Suit = "SHDC";
	private static final String Rank = "23456789TJQKA";
	
	private static void constructArray(PlayingCard [] cardArray) {
		
		int k = 0;
		
		for(int i = 0; i<Suit.length(); i++)
		{
			for(int j = 0; j < Rank.length(); j++)
			{
				cardArray[k] = new PlayingCard(Suit.charAt(i), Rank.charAt(j));
				++k;
			}
		}
	}	

	private static void displayInfo(PlayingCard [] cardArray)
	{
		int k = 0;
		for(int i = 0; i < Suit.length(); i++)
		{
			for (int j = 0; j < Rank.length(); j++)
			{
				cardArray [k].displayInfo();
				++k;
			}
			System.out.println();
		}
	}
	
	private static void shuffle(PlayingCard [] cardArray)
	{
		int i, j;
		for(int k=1; k<=1000; k++) {
			
			do {
				i = (int)(Math.random() * NO);
				j = (int)(Math.random() * NO);
			} while (i==j);
			
			PlayingCard temp = cardArray[i];
			cardArray[i] = cardArray[j];
			cardArray[j] = temp;
		}
	}
		
	public static void main(String [] args)
	{
		//Define an array of playing cards(PlayingCard Array)
		PlayingCard [] cardArray = new PlayingCard[NO];
		
		//Initialize the array 
		constructArray(cardArray);
		
		//Display a deck of playing cards
		displayInfo(cardArray);
		
		System.out.println("\nShuffle the card");
		shuffle(cardArray);
		displayInfo(cardArray);
		
	}
}

