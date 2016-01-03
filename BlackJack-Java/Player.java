package Cards;
import java.util.*;
public class Player 
{
	private int total; //the total value of the cards in the player's hand
	private int cardCount;
	private int money ; 
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
	
	public void CardToHand(Card c)  //moves a card to a Player object's hand
	{
		hand.add(c); 
		cardCount ++; //increments the card count
		//maybe try hand.size ( ) ?
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
	
	public void getHand ()
	{
		System.out.println(hand);
	}
	
	public void setTotal (int n)
	{
		this.total = n;
	}
	
	public int getTotal ()
	{
		return this.total;
	}
	
	public void setMoney (int n)
	{
		this.money = n;
	}
	
	public int getMoney ()
	{
		return this.money;
	}
	
	public int getCardCount ()
	{
		return cardCount;
	}
	
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
