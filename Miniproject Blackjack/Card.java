/*Define a class that represents an playing card with a suit and rank that can be flipped over (or not).
The class should be named Card.*/
public class Card
{
    /**A String to track the suit*/
    private String suit; 
    /**A String to track the rank*/
    private String rank;
    /**A boolean to track if the card is face up showing the suit/rank (true) 
     * or face down showing the back with unicode character 🂠 (false) */
    private Boolean faceUp;
    
    
    /**There should be a constructor that:
    Requires two parameters for the suit and rank
    Should initialize the instance properties; the card should start face down */
    public Card (String suit, String rank)
    {
        this.suit = suit;
        this.rank = rank;
        this.faceUp = false;
    }

    /**Getter for the Suit*/
    public String getSuit()
    {
        return suit;
    }

    /**Getter for the rank */
    public String getRank()
    {
        return rank;
    }

    /**Getter for whether card is face up */
    public boolean isFaceUp()
    {
        return faceUp;
    }


    /**Instance method called getValue which requires no parameters, return type int, 
     * return value of the card*/
    public int getValue()
    {
        /**An ace will default to the value 1 */
        if(this.rank.equals("A"))
        {
            return 1;
        }
        if (this.rank.equals("2"))
        {
            return 2;
        }
        if (this.rank.equals("3"))
        {
            return 3;
        }
        if (this.rank.equals("4"))
        {
            return 4;
        }
        if (this.rank.equals("5"))
        {
            return 5;
        }
        if (this.rank.equals("6"))
        {
            return 6;
        }
        if (this.rank.equals("7"))
        {
            return 7;
        }
        if (this.rank.equals("8"))
        {
            return 8;
        }
        if (this.rank.equals("9"))
        {
            return 9;
        }
        
        /**10, Jack, Queen, King are valued at 10 */
        else
        {
            return 10;
        }
    }

    /**Instance method called flip, requires no parameters, return type void
     * flip the card (face up -> down; face down -> up)
     */
    public void flip() 
    {
    
        /**if the card faces down*/
        if(this.faceUp==false) 
        {
            /**flip up */
            this.faceUp = true; 
        } 
        /**if the card faces up*/
        else
        {
            /**flip down */
            this.faceUp = false;
        }
    }

    /**instance method toString, requires no parameters, return type String
     * return String representation of the card
     * If the card is face up, return the suit and the rank
     * If the card is face down, return the unicode character for the back of a card 
     */
    public String toString()
    {
        if(faceUp == true)
        {
            /**If the card is face up, return the suit and the rank */
            return suit + rank;
        }
        else
        {
            /**If the card is face down, return the unicode character for the back of a card */
            return "🂠";
        }
    }
}