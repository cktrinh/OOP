import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/** Represents a deck of 52 cards. */
public class Deck
{
    // class variable (denoted by static) -- for testing purposes!
    public static Random shuffler = new Random(); 
    // use this Random object for shuffling

    /** A List<Card> named cards to maintain the Card instances in this deck*/
    private List<Card> cards;

    /**There should be a constructor that:
     * Requires one parameter for whether to shuffle the deck initially (true) or leave it in order (false)
     * Should initialize the instance property by constructing a new instance of an ArrayList<Card> that is empty
     * Relies on the helper instance methods: 
     * add52Cards, described below 
     * shuffle, given in the starter code */
    
    public Deck (Boolean isShuffler) //paramter: shuffle deck initially (true) or leave in order (false)
    {
        //initialize the instance property by constructing a new instance of an ArrayList<Card> that is empty
        this.cards = new ArrayList<Card>();
        //helper instance methods:
        add52Cards();
        shuffle();
    }

    /**instance method isEmpty requires no parameters, return type boolean, 
     * return true if no cards left in deck
     */
    public boolean isEmpty()
    {
        if(this.cards.isEmpty()) //if there are no cards left
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    public void add52Cards()
    {
        // initalize an array with the 4 suits
        String[] suits = {"S","H","D","C"};       
        // we'll store 13 ranks in an array
        String[] ranks = new String[13];
        // set the first index to hold the ace
        ranks[0] = "A";
        // numbers 2 through 10
        for (int i = 2; i <= 10; i++ )
        {
            ranks[i-1] = Integer.toString( i );
        }   
        // add the jack, queen and king
        ranks[10] = "J";
        ranks[11] = "Q";
        ranks[12] = "K";

        for(int i = 0; i < suits.length; i++)
        {
            for(int k = 0; k < ranks.length; k++)
            {
                Card card = new Card(suits[i], ranks[k]); 
                cards.add(card);
            }
        }
    }
   /**
    * (Instance method to) Shuffle the cards in this deck.
    */
    public Card dealCard()
    {
        /** deal a card by removing it & returning it */
        return this.cards.remove(0); 
    }

    /**instance method toString, requires no parameters, return type of String
     * return String representation of the deck by invoking the List's built-in toString method
     */
    public String toString()
    {
        //invoking the List's built-in toString method
        return cards.toString();

    }
   public void shuffle()
   {
       Collections.shuffle(cards, shuffler);
   }

}
