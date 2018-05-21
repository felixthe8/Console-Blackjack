
import java.util.*;
public class Deck 
{
	private static ArrayList <Card> cards = new ArrayList <Card>();
	private static ArrayList <Integer> Existing_Index = new ArrayList <Integer> ();
	private  int index;
	private Random gen = new Random ();
	private int count;

	//constructor for the Deck
	public Deck ()
	{
		count = 0;
		for (int k = 0 ; k < 4 ; k++) // keeps track of the suits
		{
			for (int i = 1; i<14;i++ ) //assigns the value and suit of the card
			{
				switch (k)
				{
				case 0 : cards.add( new Card (i , "Spades")); break;
				case 1 : cards.add( new Card (i , "Clubs")); break;
				case 2 : cards.add( new Card (i , "Diamonds")); break; 
				case 3 : cards.add( new Card (i , "Hearts")); break ;  
				}
				
			}
		}
		count = 51;
	}
	
	// Draws a card from a random spot in the deck
	public Card drawFromDeck()
	{
		 index = gen.nextInt(cards.size());
		return cards.get(index);
	}
	
	// Prints the size of the deck of cards
	public static int getTotalCards ()
	{
		return cards.size();
	}
	
	public  void print()
	{
		for (int i = 0 ; i < cards.size(); i ++)
		{
			System.out.print( cards.get(i) + "\n");
		}
	}
	
	// Shuffle the card deck 10 times
	public void shuffleDeck()
	{
		for (int a = 0 ; a <=10; a++)
		{
			Collections.shuffle(cards);
		}
	}
	
	public ArrayList <Card> getDeck ()
	{
		return Deck.cards;
	}
	
	//returns the top card of the deck without decrementing count
	public Card topCard () 
	{
		return cards.get(count);
	}
	
	public Card dealCard ()
	{
		Card temp = cards.get(count -- );
		cards.remove(cards.indexOf(temp));
		return temp;
	}
	
	//returns the number of cards in the deck
	public int getCount () 
	{
		return (count + 1);
	}
}
