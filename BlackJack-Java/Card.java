package Cards;

public class Card 
{
	//declares a rank and suit for the Card objects
	private int value; 
	private String suit; 
	private String rank;
	private boolean visible;
	 
	
	//constructor the the Card objects
	public Card (int value , String suit)
	{
		
		this.suit = suit;
		this.visible = true;
		switch (value)
		{
		case 1 : this.rank = "Ace"; this.value = 11; break;
		case 2 : this.rank = "2" ; this.value = 2; break;
		case 3 : this.rank = "3"; this.value = 3; break;
		case 4 : this.rank = "4" ; this.value = 4; break;
		case 5 : this.rank = "5" ; this.value = 5; break;
		case 6 : this.rank = "6" ; this.value = 6; break;
		case 7 : this.rank = "7" ; this.value = 7; break;
		case 8 : this.rank = "8" ; this.value = 8; break;
		case 9: this.rank = "9"  ; this.value = 9; break;
		case 10: this.rank = "10"; this.value = 10; break;
		case 11 : this.rank = "Jack" ; this.value = 10; break;
		case 12 : this.rank = "Queen"; this.value = 10; break;
		case 13 : this.rank = "King"; this.value = 10; break;
		
		}
		
	}
	
	public String toString()
	{
		//this.rank = getRank ( ) 
		//this.suit = getSuit ( ) 
		return ( getRank() + " of "+getSuit() + "\n");
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) 
	{
		this.suit = suit;
	}
	
	public void setVisible (boolean t)
	{
		this.visible = t;
	}
	
	public int getValue ()
	{
		return this.value;
	}

}
