package Cards;
import java.util.*;
public class Player 
{
	// Total value of the cards in the player's hand
	private int total; 

	// Number of cards in the player's hand
	private int cardCount;

	// Total amount of money that the player has
	private int money; 

	// ArrayList to represent the player's hand (the cards that they hold)
	private ArrayList<Card> hand = new ArrayList <Card> ();
	
	public Player ()
	{
		this.money = 100;
		this.total = 0;
		this.cardCount = 0;
		this.hand = new ArrayList <Card> ();
	}

	public void getCard (int n)
	{
		total = total + n;
	}
	
	 // Moves a card to a Player object's hand
	public void CardToHand(Card c) 
	{
		hand.add(c); 
		cardCount ++; //increments the card count
		
	}
	
	public ArrayList<Card> returnHand()
	{
		return hand;
	}
	
	public void revealCard()
	{
		for (int i = 0; i < cardCount; i++)
		{
			hand.get(i).setVisible(true);
		}
	}
	
	// Prints the player's hand
	public void getHand ()
	{
		System.out.println(hand);
	}
	
	// Sets the total of the cards in the player's hand
	public void setTotal (int n)
	{
		this.total = n;
	}
	
	// Gets the total value of the cards in the player's hand
	public int getTotal ()
	{
		return this.total;
	}
	
	// Sets the total amount of money that the player has
	public void setMoney (int n)
	{
		this.money = n;
	}
	
	// Returns the total money that the player has
	public int getMoney ()
	{
		return this.money;
	}
	
	// Returns the player's card count
	public int getCardCount ()
	{
		return cardCount;
	}
	
	// Checks if the user is betting an amount that is valid/invalid
	public boolean canBet (int n)
	{
		if (n > this.money)
		{
			System.out.println("Insufficient funds");
			return false;
		}
		else return true;
	}
	
	
	
}
