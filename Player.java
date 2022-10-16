public class Player
{
  String name, weapon;
  int health, maxHealth;
  double gold;
  int monstersDefeated;
  int mana, maxMana;
  int physicalLvl = 1, magicLvl = 1;

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

  public String getWeapon()
  {
    return weapon;
  }

  public void swapWeapon(String w)
  {
    weapon = w;
  }

  public int getMaxHP()
  {
    return maxHealth;
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

  public int getMana()
  {
    return mana;
  }

  public void removeMana(int x)
  {
    mana -= x;
  }

  public void addMana(int x)
  {
    mana += x;
    if(mana > maxMana)
    {
      mana = maxMana;
    }
  }

  public int getMaxMana()
  {
    return maxMana;
  }

  public int getPhysicalLvl()
  {
    return physicalLvl;
  }

  public int getMagicLvl()
  {
    return magicLvl;
  }

  public int increasePhys()
  {
    monstersDefeated -= 1;
    physicalLvl += 1;
    return physicalLvl;
  }

  public int increaseMagic()
  {
    monstersDefeated -= 1;
    magicLvl += 1;
    return magicLvl;
  }
}