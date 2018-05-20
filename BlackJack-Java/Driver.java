package Cards;

import java.util.*;

public class Driver 
{

	public static void main(String[] args) 
	{
		// Create a new card deck
		Deck deck1 = new Deck ();
		// Shuffle the card deck
		deck1.shuffleDeck();

		// Create a player object
		Player p1 = new Player ();

		// Create the dealer object
		Player dealer = new Player ();
		
		// Scanners for user input
		Scanner menuInput = new Scanner(System.in);
		Scanner gameInput = new Scanner(System.in);
		Scanner betInput = new Scanner (System.in);
		System.out.println("BlackJack Game");
		System.out.println(Menu());
		
		int choice = menuInput.nextInt();
		while (choice != 5)
		{
			switch (choice)
			{
			// Show the menu	
			case 1 : deck1 = new Deck (); 
					System.out.println("BlackJack Game");
					System.out.println(Menu());
					break;

			// Shuffle the cards
			case 2 : deck1.shuffleDeck(); 
					System.out.println("BlackJack Game");
					System.out.println(Menu());
			break;

			// Print the card deck
			case 3 : deck1.print();    
					System.out.println("BlackJack Game");
					System.out.println(Menu());
			break;

			// Start the blackjack game
			case 4 : 
			        // Starting value of the cards in the player's hand is 0
					p1.setTotal(0);  
					// Starting value of the cards in the dealer's hand is 0
					dealer.setTotal(0);

					if (p1.getMoney() <= 0)
					{
						System.out.println("Player does not have any money left");
					}
					System.out.println("Player has this much money : $"+p1.getMoney() + "\n"+ "How much do you want to bet?" );
					int bI = betInput.nextInt();
					System.out.println(" ");
					
					// If the player is able to bet the amount that they have input
					if (p1.canBet(bI))
					{
						// Dealer's Initial Hand. Sends the top card to the dealer
						dealer.CardToHand(deck1.topCard());    
						System.out.println("Dealer's hand : ");

						// Gets the value of the top most card and goes to the next card after
						dealer.getCard(deck1.dealCard().getValue());
						 // Sends the top card to the dealer   
						dealer.CardToHand(deck1.topCard());   

						// Gets the value of the top most card and goes to the next card after
						dealer.getCard(deck1.dealCard().getValue());   

						 // Prints out what is in the dealer's hand
						dealer.getHand();   
						System.out.println("Total value of these cards : " +dealer.getTotal());
						System.out.println();
						
						//Player's Initial Hand .  Ssends the top card to the player 
						p1.CardToHand(deck1.topCard());     
						 // Gets the value of the top most card and goes to the next card afterwards
						p1.getCard(deck1.dealCard().getValue()); 
						p1.CardToHand(deck1.topCard());      //sends the top card to the player 
						p1.getCard(deck1.dealCard().getValue());  //gets the value of the top most card and goes to the next card afterwards
						System.out.println("Player's Hand : ");
						p1.getHand();
						System.out.println("Total value of these cards : " +p1.getTotal());
					}
					
					while (p1.getTotal() <= 21)
					{
						System.out.println("Player is "+ ( 21 - p1.getTotal() )  +" from victory");
						System.out.println("Would you like to hit?   ( Y / N )"); 
						String gInput = gameInput.next();
						
						if (gInput.equalsIgnoreCase("y") || (gInput.equalsIgnoreCase("yes") ) )
						{
							if((p1.getTotal() + (deck1.topCard().getValue()) <= 21))  
							{	
								// Sends the top card to the player 
								p1.CardToHand(deck1.topCard());      
								 // Gets the value of the top most card and goes to the next card afterwards
								p1.getCard(deck1.dealCard().getValue()); 
								System.out.println("Player's Hand : ");
								p1.getHand();
								System.out.println("Total value of these cards : " +p1.getTotal());
								continue;
							}	
						
							// If the player has gone over 21
							else if ( (p1.getTotal() + deck1.topCard().getValue() ) > 21)
							{
								p1.CardToHand(deck1.topCard());
								p1.getCard(deck1.dealCard().getValue());
								System.out.println("YOU LOSE!!!!");
								System.out.println("You went over 21!\n");
								System.out.println("Player's Hand : ");
								p1.getHand();
								System.out.println("Total value of these cards : " +p1.getTotal());
								 // Subtracts bet loss from the player's starting money
								p1.setMoney(p1.getMoney()-bI); 
								System.out.println("Player now has  $"+p1.getMoney());
								
							}
						
							else{
								if(deck1.topCard().getRank().equalsIgnoreCase("Ace"))
								{
									// If the player draws an Ace and the total value exceeds 21
									if(p1.getTotal() + deck1.topCard().getValue() > 21)
									{
										p1.CardToHand(deck1.topCard());
										p1.getCard(1);  // Sets the value of the Ace to 1 
										System.out.println("Player: Total: " + p1.getTotal());
										p1.getHand();
										continue;
									}
								}
								else
								{
									p1.CardToHand(deck1.topCard());
									p1.getCard(deck1.dealCard().getValue());
									System.out.println("Player: Total: " + p1.getTotal());
									p1.getHand();
									continue;
								}
							}
				
					}
						
						else if ( gInput.equalsIgnoreCase("n") || (gInput.equalsIgnoreCase("no")))	
						{
							 // Dealer must hit until the value in their hand is at least 17
							while (dealer.getTotal() < 17 )  
							{
								 // Sends the top card to the dealer
								dealer.CardToHand(deck1.topCard());   
								// Gets the value of the top most card and goes to the next card after
								dealer.getCard(deck1.dealCard().getValue());   
							}
							
							System.out.println("Dealer stands \n");
							
							if (dealer.getTotal() > 21 )
							{
								p1.setMoney(p1.getMoney()+bI);
								System.out.println("YOU WIN!!!");
								System.out.println("Dealer's hand : ");
								dealer.getHand();
								System.out.println("Total value of these cards : " +dealer.getTotal());
								System.out.println("Player's hand : " );
								p1.getHand();
								System.out.println("Total value of these cards : " +p1.getTotal());
								System.out.println("Player now has  $"+p1.getMoney());
								break;
							}
							
							// Player wins if card total in their hand is greater than or equal to that of what the dealer holds
							else if (dealer.getTotal() <= p1.getTotal())   
							{
								p1.setMoney(p1.getMoney()+bI);
								System.out.println("YOU WIN!!!");
								System.out.println("Dealer's hand : ");
								System.out.println("Total value of these cards : " +dealer.getTotal());
								dealer.getHand();
								System.out.println("Player's hand : " );
								p1.getHand();
								System.out.println("Total value of these cards : " +p1.getTotal());
								System.out.println("Player now has  $"+p1.getMoney());
								break;
							}
							
							 // Player loses if card total in their hand is less than that of what the dealer holds
							else if (dealer.getTotal() > p1.getTotal())  
							{
								p1.setMoney(p1.getMoney()-bI);
								System.out.println("YOU LOSE!!!");
								System.out.println("Dealer's hand : ");
								dealer.getHand();
								System.out.println("Total value of these cards : " +dealer.getTotal());
								System.out.println("Player's hand : " );
								p1.getHand();
								System.out.println("Total value of these cards : " +p1.getTotal());
								System.out.println("Player now has  $"+p1.getMoney());
								break;
							}
				
							else if (dealer.getTotal() == 21)
							{
								// Player wins if their total is 21
								if (p1.getTotal() == 21)
								{
									p1.setMoney(p1.getMoney()+bI);
									System.out.println("YOU WIN!!!");
									System.out.println("Dealer's hand : ");
									dealer.getHand();
									System.out.println("Total value of these cards : " +dealer.getTotal());
									System.out.println("Player's hand : " );
									p1.getHand();
									System.out.println("Total value of these cards : " +p1.getTotal());
									System.out.println("Player now has  $"+p1.getMoney());
									break;
								}
								else
								{
									p1.setMoney(p1.getMoney()-bI);
									System.out.println("YOU LOSE!!!");
									System.out.println("Dealer's hand : ");
									dealer.getHand();
									System.out.println("Total value of these cards : " +dealer.getTotal());
									System.out.println("Player's hand : " );
									p1.getHand();
									System.out.println("Total value of these cards : " +p1.getTotal());
									System.out.println("Player now has  $"+p1.getMoney());
									break;
								}
							}
							
						}
						break ; 
					
			} //end  while  
					
			case 5 : System.exit(0); break ;
			}//end switch
				break ;	
				
				
		} // end while
	
		menuInput.close();
		gameInput.close();
		betInput.close();
	} //end main	
	
	
	public static String Menu ()
	{
		String menu =  "(Be sure to shuffle the deck before you play)\n" + 
				   "1. New Deck" + "\n" +
				   "2. Shuffle cards in Deck" + "\n" +
				   "3. Display all cards remaining in the deck" + "\n" +
				   "4. Play Black Jack" + "\n" + 		   
				   "5. Exit";
		
	return menu;
	}

}
