import java.util.*;

public class Player
{
  String name, weapon;
  int health, maxHealth;
  double gold;
  int monstersDefeated;
  int mana, maxMana;

  public Player(String playerName, int startingHealth, double startingGold, int startingMana)
  {
    maxHealth = startingHealth;
    health = maxHealth;
    name = playerName;
    gold = startingGold;
    maxMana = startingMana;
    mana = maxMana;
    weapon = "fists";
  }

  public void swapWeapon(String item)
  {
    weapon = item;
  }
  public String getName()
  {
    return name;
  }

  public void changeName(String newName)
  {
    name = newName;
  }

  public int getHealth()
  {
    return health;
  }

  public void setHealth(int newHealth)
  {
    health = newHealth;
  }

  public double getGold()
  {
    return gold;
  }

  public void setGold(double newAmount)
  {
    gold = newAmount;
  }

  public int getMonstersDefeated()
  {
    return monstersDefeated;
  }

  public void defeatMonster()
  {
     monstersDefeated += 1;
  }
}