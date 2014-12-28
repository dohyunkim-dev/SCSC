public abstract class CardHand
{
  protected Card[] _hand;
  protected int _number;

  CardHand ()
  {
    this._hand = new Card[20];
    this._number = 0;
  }

  public void clear ()
  {
    for (int i = 0; i < this._hand.length; i++)
    {
      this._hand[i] = null;
    }

    this._number = 0;
  }

  public void add (Card card)
  {
    this._hand[this._number++] = card;
  }

  public int getScore ()
  {
    int score = 0;
    
    for (int i = 0; i < this._number; i++)
    {
      score += this._hand[i].getRank ();
    }

    return score;
  }

  public String toString ()
  {
    if (this._number <= 0)
    {
      return "Hand Empty\n";
    }

    String out = "";

    for (int i = 0; i < this._number; i++)
    {
      out += this._hand[i] + "\n";
    }

    return out;
  }
}
