import java.util.*;

public class TextAdventure 
{
  FancyConsole console;
  Scanner inScanner;
  Player ourHero;

  public TextAdventure()
  {
    console = new FancyConsole("Great Text Adventure!", 600, 600);
    inScanner = new Scanner(System.in);

    // feel free to change the player's starting values
    ourHero = new Player("Bob", 100, 0, 100);
  }

  public void play()
  {
    String input;
    // start of adventure. You can change this if you like
    console.setImage("distantcity.jpg");

    // ask the user for their name.
    System.out.println("What is your name?\n");
    input = inScanner.nextLine();

    // Change ourHero's name
    // ADD CODE HERE
    ourHero.changeName(input);
    
    // describe the starting situation. Feel free to change this
    System.out.println("You wake up to find yourself on the edge of a shadowy forest with the sun nearly set. \nYou see what looks like a city in the distance. \nWhat would you like to do? \ncity: go towards the city\nforest: turn around and re-enter the forest\nnap: go back to sleep\n" + ourHero.getName() + ": ");
    input = inScanner.nextLine();
    // get user input and go to the appropriate zone based on their input
    if(input.equals("city"))
    {
      forestEncounter();
      enterZone1();
    }
    // ADD CODE HERE

  }

  public void forestEncounter()
  {
    console.setImage("owlbear.png");
    encounter owlBear = new encounter("OwlBear", 37, 10, 5, 14);
    System.out.println("As you make your way through the rest of the forest to go to the city, you hear a russling in the bushes");
    System.out.println("Moments later a large creature known as an owlbear jumps from the bushes and attacks you");
    while(owlBear.getMonsterHealth() > 0 && ourHero.getHealth() > 0)
    {
      owlBear.startRound(ourHero.getName(), ourHero.getHealth(), ourHero.getMaxHP(), ourHero.getMana(), ourHero.getMaxMana());
      owlBear.subtractHP(owlBear.playerTurn(ourHero.getWeapon(), ourHero.getMana(), ourHero.getHealth(), ourHero.getMaxHP(), ourHero.getPhysicalLvl(), ourHero.getMagicLvl()));
      if(owlBear.usedMagic == true)
      {
        ourHero.removeMana((owlBear.manaUsed()));
      }
      ourHero.setHealth(ourHero.getHealth()-owlBear.monsterTurn());
      ourHero.addMana(3);
    }
  }

  private void enterZone1()
  {
    // change image
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE

  }

  private void enterZone2()
  {
    // change image
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void enterZone3()
  {
    // change image
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void enterZone4()
  {
    // change image
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void enterZone5()
  {
    // change image
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void enterZone6()
  {
    // change image
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void gameEnd()
  {
    // ADD CODE HERE

    inScanner.close();
  }
}