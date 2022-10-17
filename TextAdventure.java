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
      enterZone1();
    }
    // ADD CODE HERE

  }

  public void forestEncounter()
  {
    encounter owlBear = new encounter("OwlBear", 37, 10, 5, 14);
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

  public void pumpkinEncounter()
  {
    encounter pumpkins = new encounter("Pumpkins", 63, 10, 3, 12);
    while(pumpkins.getMonsterHealth() > 0 && ourHero.getHealth() > 0)
    {
      pumpkins.startRound(ourHero.getName(), ourHero.getHealth(), ourHero.getMaxHP(), ourHero.getMana(), ourHero.getMaxMana());
      pumpkins.subtractHP(pumpkins.playerTurn(ourHero.getWeapon(), ourHero.getMana(), ourHero.getHealth(), ourHero.getMaxHP(), ourHero.getPhysicalLvl(), ourHero.getMagicLvl()));
      if(pumpkins.usedMagic == true)
      {
        ourHero.removeMana((pumpkins.manaUsed()));
      }
      ourHero.setHealth(ourHero.getHealth()-pumpkins.monsterTurn());
      ourHero.addMana(3);
    }
  }

  private void enterZone1() //city
  {
    // change image
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE
    Scanner shop = new Scanner(System.in);
    String shopChoice;
    System.out.println("As you enter into the city you are greeted by the sound of many people working their trade in shops that line the street\nWhile you have no money to buy anything with you feel inclined to speak with one of these people\n");
    System.out.println("[1]The Item shopkeep\n[2]The blacksmith\n[3]The magic shopkeep\n");
    
    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    shopChoice = shop.nextLine();
    if(shopChoice.equals("1"))
    {
      System.out.println("The item shopkeep greets you with a big smile as he shows off his wares, A sword that is in a display case catches your eye but you still have no money");
      System.out.println("The shopkeep agrees to let you take the sword if you complete a mission for him, he asks you to go to the mountain and kill the young dragon that lives there as it has been terrorising the city recently.");
    }
    else if(shopChoice.equals("2"))
    {
      System.out.println("The blacksmith greets you as he hammers a longsword into shape, A sword that is in a display case catches your eye but you still have no money");
      System.out.println("The blacksmith agrees to let you take the sword if you complete a mission for him, he asks you to go to the mountain and kill the young dragon that lives there as it has been terrorising the city recently.");
    }
    else if(shopChoice.equals("3"))
    {
      System.out.println("The magic shopkeep greets you with a big smile as he is enchanting a dagger to have magical properties, A sword that is in a display case catches your eye but you still have no money");
      System.out.println("The shopkeep agrees to let you take the sword if you complete a mission for him, he asks you to go to the mountain and kill the young dragon that lives there as it has been terrorising the city recently.");
    }
    System.out.println("Before you leave they hand you a small dagger to use as a weapon");
    ourHero.swapWeapon("dagger");

    enterZone2();
  }

  private void enterZone2() //forest
  {
    Scanner fork = new Scanner(System.in);
    String forkChoice;
    // change image
    console.setImage("forest.jpg");
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE
    System.out.println("As you make your way through the rest of the forest to go to the city, you hear a russling in the bushes");
    System.out.println("Moments later a large creature known as an owlbear jumps from the bushes and attacks you");
    forestEncounter();

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    System.out.println("The path forks here, you could explore a little more or you could go stright to the mountains");
    System.out.println("[1]Explore more\n[2]Continue to the mountain\n");
    forkChoice = fork.nextLine();
    if(forkChoice.equals("1"))
      enterZone3();
    else 
    {
      System.out.println("You head over to the mountain");
      enterZone4();
    }
  }

  private void enterZone3() //pumpkins
  {
    // change image
    // ADD CODE HERE
    console.setImage("pumpkintrio.png");

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE
    System.out.println("Deciding that you want to do some more exploring, you head to the right.");
    System.out.println("After a bit of walking down the path a small shine within a small pile of leaves catches your eyes");
    System.out.println("You brush it off and reveal a great axe");
    ourHero.swapWeapon("axe");
    System.out.println("As you grab your new weapon you cast aside your old weapon and smash a nearby pumpkin to test this new one");
    System.out.println("Once you have finished smashing a pumpkin you see two other pumpkins grow glowing eyes");
    pumpkinEncounter();
    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    System.out.println("Now that thoes pumpkins have been delt with you move onto the mountains, now feeling more confidant with your new weapon");
    enterZone4();
  }

  private void enterZone4() //mountains
  {
    // change image
    // ADD CODE HERE
    console.setImage("mountains.png");

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE
    Scanner path = new Scanner(System.in);
    String pathway;
    System.out.println("As you aproach the mountain You see a young white dragon sitting atop it");
    System.out.println("You can see two paths that lead to peak of the mountain, one through the caves and another following a path up the mountain");
    System.out.println("[1]Caves\n[2]Path\n");
    pathway = path.nextLine();
    if(pathway.equals("1"))
      enterZone5();
    else
      enterZone6();


    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void enterZone5() //cave
  {
    // change image
    // ADD CODE HERE
    console.setImage("caves.jpg");

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE
    Scanner sneak = new Scanner(System.in);
    String sneakPass;
    System.out.println("As you enter into the caves you see a sleeping wyrmling and what looks like a sword in the distance");
    System.out.println("[1]Grab the sword\n[2]Ignore it and keep walking\n");
    sneakPass = sneak.nextLine();
    
    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void enterZone6() //dragon
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