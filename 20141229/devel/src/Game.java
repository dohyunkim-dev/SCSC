public class Game
{
  CardDeck _deck;
  Player _player;
  Dealer _dealer;

  Game ()
  {
    _deck = new CardDeck ();
    _player = new Player (_deck);
    _dealer = new Dealer (_deck);
  }

  public void play () throws CardDeck.EmptyCardDeckException
  {
    _deck.clear ();
    _deck.buildAndShuffle ();

    boolean playerStand = false;
    boolean dealerStand = false;
    boolean playerWin = false;

    while (!playerStand || !dealerStand)
    {
      if (!playerStand)
      {
        System.out.println ("<<<--- Player Turn --->>>");
        playerStand = _player.turn ();
        System.out.println (_player);

        if (_player.getScore () > 21)
        {
          System.out.println ("<<<--- Player Lose --->>>");
          playerWin = false;
          break;
        }
        else if (_player.getScore () == 21)
        {
          System.out.println ("<<<--- Player Win --->>>");
          playerWin = true;
          break;
        }
      }

      if (!dealerStand)
      {
        System.out.println ("<<<--- Dealer Turn --->>>");
        dealerStand = _dealer.turn ();
        System.out.println (_dealer);

        if (_dealer.getScore () > 21)
        {
          System.out.println ("<<<--- Player Win --->>>");
          playerWin = true;
          break;
        }
        else if (_dealer.getScore () == 21)
        {
          System.out.println ("<<<--- Player Lose --->>>");
          playerWin = false;
        }
      }
    }

    System.out.println ("<<<--- Game Result --->>>");

    if (_player.getScore () >= 21 || _dealer.getScore () >= 21)
    {
      if (playerWin)
      {
        System.out.println ("Player (" + _player.getScore() + ") won the game");
      }
      else
      {
        System.out.println ("Dealer (" + _dealer.getScore() + ") won the game");
      }
    }
    else
    {
      if (_player.getScore () < _dealer.getScore ())
      {
        System.out.println ("Dealer (" + _dealer.getScore() + ") won the game - Player (" + _player.getScore () + ")");
      }
      else if (_player.getScore () > _dealer.getScore ())
      {
        System.out.println ("Player (" + _player.getScore () + ") won the game = Dealer (" + _dealer.getScore () + ")");
      }
    }

    _player.clear ();
    _dealer.clear ();
  }

  public static void main(String[] args)
  {
    Game game = new Game ();
    try
    {
      game.play ();
      game.play ();
    }
    catch (Exception e)
    {
      System.out.println(e.toString());
    }
  }
}
