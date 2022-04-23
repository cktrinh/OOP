import java.util.ArrayList;
import java.util.List;

public class Hand 
{
    /**A List<Card> named cards to maintain the Card instances in this deck */
    private List<Card> cards;
    
    /**There should be a constructor that: Requires no parameters, 
     * Should initialize the instance property 
     * by constructing a new instance of an ArrayList<Card> that is empty */
    public Hand()
    {
        //initialize an instance property of ArrayList<Card>
        cards = new ArrayList<Card>();
    }



    /**There should be an instance method called add that: 
     * Requires one parameter of type Card
     * Has a return type of void 
     * Should add the card to the hand */
    public void add(Card newCard) 
    {
        //add the card to the hand
        cards.add(newCard); 
    }



    /**There should be an instance method called revealCards that:
     * Requires no parameters
     * Has a return type of void 
     * Should reveal all cards by making sure they are all set as face up
     * Iterate over the list of cards and flip any that are face down */
    public void revealCards()
    {
        // Iterate over list of cards
        for (Card anyCard : cards)
        {
            // if any cards face down
            if(!anyCard.isFaceUp()) 
            {
            // flip back up
                anyCard.flip();
            }
        }
    }



    /**There should be an instance method called busted that:
     * Requires no parameters
     * Has a return type of boolean 
     * Should check if the hand is busted 
     * -- return true if it has a value of more than 21.
     * Relies on the helper instance method: 
     * determineValue, described below */
    public boolean busted()
    {
       //relies on determineValue(), return true if has value > 21
       return determineValue() > 21;

    }



    /**
     * There should be an instance method called determineValue that:
     * Requires no parameters
     * Has a return type of int 
     * Should determine the best (Blackjack) value of the hand
     * If there is an ace and treating it as an 11 keeps the sum <= 21 (inclusive), returns that value. 
     * Otherwise, treats the ace as a 1.
     * Relies on the helper instance method: 
     * containsRank, described below 
     */

    public int determineValue()
    {
        // first set the sum to 0
        int value = 0;
      
        // iterate over cards
        for (Card anyCard : cards)
        {
        
            //for each card, add the value of the card to sum, invoke getValue()
            value += anyCard.getValue();
        }
        
        //if the hand has an Ace card
        // relies on containsRank
        if(containsRank("A"))  
        {
            // Plus 10 to value (because the sum already has the
            // 1 from the Ace) (Which will make the Ace has the 
            // value of 11)
            value += 10;
        }
       
        //(If the sum <= 21 with the value of the Ace is 11)
        if(value <= 21)
        {
            //return that value
            return value;
        }
        //If the sum > 21 with the value of the Ace is 11
        // relies on containsRank
        else if (value > 21 && containsRank("A"))
        {
            //Turn the Ace value back to 1
            value -= 10;
            return value;
        }
        //otherwise return sum
        return value;
       
    }



    /**There should be an instance method called containsRank that:
     * Requires a single parameter of type String
     * Has a return type of boolean 
     * Should checks if this hand has a card with the given rank and returns true if so. */
    
     public boolean containsRank(String givenRank)
    {
        // iterate over cards
        for(Card anyCard : cards)
        {
            // if this hand has a card with the given rank:
            if(anyCard.getRank() == givenRank)
            {
                return true;
            }   
        }
        return false;
    }


    /**There should be an instance method called toString that:
     * Requires no parameters
     * Has a return type of String
     * Should return a String representation of the deck by invoking the List's built-in toString method */
    public String toString()
    {
        // set the result as an empty string
        String result = "";
        // iterate over cards
        for (Card anyCard : cards) 
        {
            // invoke the List's built-in toString method
            // add anyCard.toString() and the comma to results   
            result +=  anyCard.toString() + ", ";
        }
        // return the result
        return result;
    }

}
