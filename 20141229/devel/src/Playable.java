import java.util.Scanner;
import java.util.Random;

public interface Playable
{
  public boolean turn () throws CardDeck.EmptyCardDeckException;
}

class Player extends CardHand implements Playable
{
  CardDeck _deck;

  Player (CardDeck deck)
  {
    super ();
    _deck = deck;
  }

  public boolean turn () throws CardDeck.EmptyCardDeckException
  {
    int selection = -1;
    Scanner scanner = new Scanner(System.in);

    while (selection < 0)
    {
      System.out.println("Type \"hit\" or \"stand\"");
      String input = scanner.next().trim();

      if (input.equals ("hit"))
      {
        selection = 1;
      }
      else if (input.equals ("stand"))
      {
        selection = 2;
      }
    }

    boolean stand = true;

    if (selection == 1)
    {
      hit ();
      stand = false;
    }

    return stand;
  }

  public void hit () throws CardDeck.EmptyCardDeckException
  {
    super.add(_deck.draw());
  }

  public String toString ()
  {
    return "----------\n" +
           "Player: " + super.getScore() + " Points \n" +
           super.toString() + "----------";
  }
}

class Dealer extends CardHand implements Playable
{
  CardDeck _deck;

  Dealer (CardDeck deck)
  {
    super ();
    _deck = deck;
  }

  public boolean turn () throws CardDeck.EmptyCardDeckException
  {
    Random rnd = new Random ();

    int decision = rnd.nextInt (21);

    if (decision < 21 - super.getScore ())
    {
      hit ();
      return false;
    }
    else
    {
      return true;
    }
  }

  public void hit () throws CardDeck.EmptyCardDeckException
  {
    super.add(_deck.draw());
  }

  public String toString ()
  {
    return "----------\n" +
           "Dealer: " + super.getScore() + " Points \n" +
           super.toString() +
           "----------";
  }
}
