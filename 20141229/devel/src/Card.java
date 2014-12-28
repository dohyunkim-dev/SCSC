public abstract class Card
{
  public static class UnexpectedRankError extends Exception
  {
    UnexpectedRankError (int rank) {
      super ("Rank " + rank + " is an invalid rank");
    }
  }

  protected int _rank;

  public Card (int cardRank)
  {
    this._rank = cardRank;
  }

  private String rankToString (int cardRank) throws UnexpectedRankError
  {
    String rankString = null;

    switch (cardRank)
    {
      case 13:
        rankString = "K";
        break;
      case 12:
        rankString = "Q";
        break;
      case 11:
        rankString = "J";
        break;
      case 10:
        rankString = "10";
        break;
      case 9:
        rankString = "9";
        break;
      case 8:
        rankString = "8";
        break;
      case 7:
        rankString = "7";
        break;
      case 6:
        rankString = "6";
        break;
      case 5:
        rankString = "5";
        break;
      case 4:
        rankString = "4";
        break;
      case 3:
        rankString = "3";
        break;
      case 2:
        rankString = "2";
        break;
      case 1:
        rankString = "A";
        break;
      default:
        throw new UnexpectedRankError (cardRank);        
    }

    return rankString;
  }

  public int getRank ()
  {
    return _rank;
  }

  public String toString ()
  {
    try
    {
      return rankToString(this._rank);
    }
    catch (UnexpectedRankError e)
    {
      return e.toString();
    }
  }
}

class CloverCard extends Card
{
  CloverCard (int rankCard)
  {
    super (rankCard);
  }

  public String toString ()
  {
    return "[Clover]" + super.toString();
  }
}

class SpadeCard extends Card
{
  SpadeCard (int rankCard)
  {
    super (rankCard);
  }

  public String toString ()
  {
    return "[Spade]" + super.toString();
  }
}

class HeartCard extends Card
{
  HeartCard (int rankCard)
  {
    super (rankCard);
  }

  public String toString ()
  {
    return "[Heart]" + super.toString();
  }
}

class DiamondCard extends Card
{
  DiamondCard (int rankCard)
  {
    super (rankCard);
  }

  public String toString ()
  {
    return "[Diamond]" + super.toString();
  }
}
