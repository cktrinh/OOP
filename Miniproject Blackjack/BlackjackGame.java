/* Define a class that implements the game of Blackjack, supporting one player versus the house.
The class should be named BlackjackGame.

There should be a three instance properties:
A Deck instance to maintain the deck of cards
A Hand instance to maintain the house's hand
A Hand instance to maintain the player's hand */
import java.util.Scanner; 


public class BlackjackGame 
{
    /** A Deck instance to maintain the deck of cards*/
    private Deck Deck;
    /** A Hand instance to maintain the house's hand */
    private Hand HouseHand;
    /** A Hand instance to maintain the player's hand */
    private Hand PlayerHand;



    /**There should be a constructor that:
     * Requires no parameters
     * Should initialize the instance properties 
     * by constructing new instances of the appropriate class for each */
    public BlackjackGame()
    {
        // initialize new instance for Deck object
        this.Deck = new Deck(true);
        // initialize new instance for HouseHand object
        this.HouseHand = new Hand();
        // initialize new instance for PlayerHand object
        this.PlayerHand = new Hand();
    }




    /**There should be an instance method called playGame that:
     * Requires no parameters
     * Has a return type of void 
     * Should play the game, printing the status along the way*/
    public void playGame() 
    {
        // instance method "deal" to deal out intial cards
        deal();
        // instance method "toString" to print the current state of the game
        System.out.println(toString());
        // instance method playerTurn to prompt the user hitting/standing
        playerTurn();
        // instance method houseTurn to have the house hit if required
        houseTurn();
        // instance method determineOutcome 
        // to end the game (determining the outcome and printing results)
        determineOutcome();
    }





    /** There should be an instance method called deal that:
     * Requires no parameters
     * Has a return type of void 
     * Should start the game by dealing out the cards */
    public void deal()
    {
        //deal one card to the player, face up
        dealCardTo(PlayerHand,true);
        //deal one card to the house, face up
        dealCardTo(HouseHand, true);
        //deal one card to the player, face up
        dealCardTo(PlayerHand, true);
        //deal one card to the house, face down
        dealCardTo(HouseHand, false);
    }





    /**There should be an instance method called dealCardTo that:
     * Requires two parameters
     * A Hand instance for the hand to deal into
     * A boolean for whether the card should be face up (true) or down (false)
     * Has a return type of void 
     * Should deal a card from the deck to the given hand. 
     * If faceUp is true, flip the card so it's face up. */
    public void dealCardTo(Hand anyHand, boolean faceUp)
    {       
        // Create a new object type Card as given hand
        // and deal the card from the deck to the given hand
        Card newCard = Deck.dealCard();
        // if the card faces down
        if(faceUp)
        {
            // flip it back up
            newCard.flip();
        }
        // add the new card into array anyHand as given hand
        anyHand.add(newCard);
       
    }





    /**There should be an instance method called playerTurn that:
     * Requires no parameters
     * Has a return type of void 
     * Should have the player take their turn.  */
    public void playerTurn()
    {
        
        Scanner sc= new Scanner(System.in);
        // print a prompt
        System.out.print( "(H)it or (S)tand?" );  
        // wait for and accept input  
        // System.in is a standard input stream 
        String input = sc.nextLine();
        

        // While the player hasn't busted and we ignore the case of the input
        while (!PlayerHand.busted() && input.equalsIgnoreCase("h")) {
     
            // if input is "h" = hit
            if(input.equalsIgnoreCase("h"))
            {
                // deal card with instance method dealCardTo
                dealCardTo(PlayerHand, true);
            }
           
            // if the player has busted, we break the loop
            if(PlayerHand.busted()) 
            {
                break;
            }
            
            // if the player hasn't busted
            else
            {
                // print out the string representation of the current state of the game
                System.out.println(toString());
                // print a prompt to hit or stand
                System.out.print( "(H)it or (S)tand? (H/h/S/s)" ); 
                // wait for and accept input  
                // System.in is a standard input stream 
                input = sc.nextLine(); 
            }
     
        }
        // print out the string representation of the current state of the game
        System.out.println(toString());

        // close scanner
        sc.close();
    }







    /**There should be an instance method called houseTurn that:
     * Requires no parameters
     * Has a return type of void 
     * Should execute the house's turn. 
     * While the house's hand is valued < 17, 
     * deal a card with the instance method dealCardTo 
     * and print the current state of the game using toString */
    public void houseTurn() 
    {
        // If there are 2 cards and that value is >= 17
        if(HouseHand.determineValue() >= 17) 
        {
            // House Hand will flip their cards
            HouseHand.revealCards();
            // print out the string representation of the current state of the game
            System.out.println(toString());
        }

        // While the house's hand is valued < 17
        while(HouseHand.determineValue() < 17)
        {
            // deal a card with the instance method dealCardTo 
            dealCardTo(HouseHand, true);
            // flip the cards
            HouseHand.revealCards();
            // print the current state of the game using toString
            System.out.println(toString());

        }
    
       
    }





    /**There should be an instance method called determineOutcome that:
     * Requires no parameters
     * Has a return type of int 
     * Should determine the outcome of the game: 
     * -1 if the player loses, 0 if there is a tie, 1 if the player wins */
    public int determineOutcome()
    {
        // If the player busted
        if(PlayerHand.busted())
        {
            // print out the following
            System.out.println("Your hand's a bust..."
            + "\n" + "Aww, the house won.");
            // return -1
            return -1;
        }

        // If the house busted
        else if (HouseHand.busted())
        {
            // print the following
            System.out.println("The house's hand's a bust!"
            + "\n" + "Congrats, you won!");
            // return 1
            return 1;
        }


        // if it's a tie
        else if ( PlayerHand.determineValue() == HouseHand.determineValue())
        {
            // print the following
            System.out.println("Tie!");
            // return 0
            return 0;
        }

        // if neither hand is a bust, player is closer to 21
        // which means the player hand > house hand
        else if (!PlayerHand.busted() &&
        !HouseHand.busted() && 
        PlayerHand.determineValue() > HouseHand.determineValue())
        {
            //print the following
            System.out.println("Congrats, you won!");
            // return 1
            return 1;
        }

        // else: if neither hand is a bust, house is closer to 21
        else
        {
            // print the following
            System.out.println("Aww, the house won.");
            // return -1
            return -1;
        }



    }

    /**
     * Should return a String reprenstation of the current state of the game.
     * 
     */
    public String toString() 
    {
        return "Player: [" + PlayerHand.toString() + "], House: [" + HouseHand.toString() + "]";
        
    }
    public static void main(String[] args) 

    { 
        BlackjackGame theGame = new BlackjackGame();
        theGame.playGame();
    } 
}