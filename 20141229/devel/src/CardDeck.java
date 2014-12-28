import java.util.Vector;
import java.util.Random;

public class CardDeck
{
  protected Vector<Card> _deck;

  public class EmptyCardDeckException extends Exception
  {
    EmptyCardDeckException ()
    {
      super ();
    }
  }

  CardDeck ()
  {
    this._deck = new Vector<Card>();
  }

  public void clear ()
  {
    _deck.clear ();
  }

  public void buildAndShuffle ()
  {
    int[] intArray = this.build ();
    this.shuffle (intArray);

    Vector<Card> deck = new Vector<Card>(52);

    for (int i = 0; i < 52; i++)
    {
      int suit = intArray[i] / 13;
      int rank = intArray[i] % 13;

      switch (suit)
      {
        case 0:
          deck.add(new CloverCard (rank+1));
          break;
        case 1:
          deck.add(new SpadeCard (rank+1));
          break;
        case 2:
          deck.add(new HeartCard (rank+1));
          break;
        case 3:
          deck.add(new DiamondCard (rank+1));
          break;
      }
    }

    _deck = deck;
  }
  
  private int[] build ()
  {
    int[] intArray = new int[52];

    for (int i = 0; i < 52; i++)
    {
      intArray[i] = i;
    }

    return intArray;
  }

  private void shuffle (int[] intArray)
  {
    Random rnd = new Random ();

    for (int i = intArray.length - 1; i > 0; i--)
    {
      int j = rnd.nextInt(i + 1);

      int temp = intArray[j];
      intArray[j] = intArray[i];
      intArray[i] = temp;
    }
  }

  public Card draw () throws EmptyCardDeckException
  {
    if (this._deck.isEmpty())
    {
      throw new EmptyCardDeckException ();
    }
    else
    {
      return this._deck.remove (0);
    }
  }

  public String toString ()
  {
    return "Card deck should be hidden";
  }
}
