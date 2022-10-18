import java.util.*;

public class encounter 
{
    String name, choice;
    int health, atk1, meleMod, rangeMod, damage, ac, subMana;
    
    boolean usedMagic = false;
    public encounter(String monsterName, int monsterHealth, int atkOne, int mod1, int armor)//atkOne and atkTwo should be equal to the highest base damage that can be delt before adding modifier
    {
        name = monsterName;
        health = monsterHealth;
        atk1 = atkOne;
        meleMod = mod1;
        ac = armor;
    }

    public void startRound(String playerName, int playerHealth, int playerMaxHP, int playerMana, int playerMaxMana)
    {
        subMana = 0;
        usedMagic = false;
        System.out.println(playerName + "\t\t" + name);
        System.out.println("HP:" + playerHealth + "/" + playerMaxHP + "\t\t" + health);
        System.out.println("MANA:" + playerMana + "/" + playerMaxMana);
        System.out.println("\nWhat do you do?\n[1]Attack\n[2]Magic\n");
    }

    public int damage(int x)
    {
        return damage;
    }

    public void setHP(int x)
    {
        health -= x;
    }

    public int playerTurn(String weapon, int mana, int hp, int maxHP, int physlvl, int magiclvl)
    {
        Scanner input = new Scanner(System.in);
        choice = input.nextLine();
        //physical attack
        if(choice.equals("1"))
        {
            int hit = (int)((Math.random()*20+1));
            int hitMod = (int)(Math.random()*6+1);
            if(hit + hitMod >= ac)
            {
                if(weapon.equals("fists"))
                {
                    int x = (int)((Math.random()*4+1)+physlvl);
                    if(hit == 20)
                    {
                        x *=2;
                        System.out.println("A critical hit!");
                    }
                    System.out.println("You hit for " + x + " damage");
                    input.close();
                    return x;
                }
                else if(weapon.equals("dagger"))
                {
                    int x = (int)((Math.random()*6+1)+physlvl);
                    if(hit == 20)
                    {
                        x *=2;
                        System.out.println("A critical hit!");
                    }
                    System.out.println("You hit for " + x + " damage");
                    input.close();
                    return x;
                }
                else if(weapon.equals("axe"))
                {
                    int x = (int)((Math.random()*8+1)+physlvl);
                    if(hit == 20)
                    {
                        x *=2;
                        System.out.println("A critical hit!");
                    }
                    System.out.println("You hit for " + x + " damage");
                    input.close();
                    return x;
                }
                else if(weapon.equals("longsword"))
                {
                    int x = (int)((Math.random()*10+1)+physlvl);
                    if(hit == 20)
                    {
                        x*=2;
                        System.out.println("A critical hit!");
                    }
                    System.out.println("You hit for " + x + " damage");
                    input.close();
                    return x;
                }
            }
            else
            {
                System.out.println("Your attack missed");
                input.close();
                return 0;
            }
        }
        //Magic
        else if(choice.equals("2"));
        {
            usedMagic = true;
            int hit = (int)((Math.random()*20+1));
            int hitMod = (int)(Math.random()*6+1);
            System.out.println("What spell are you using\n[1]Fire Bolt - 10 mana"+ "\n[2]Healing Word - 20 mana" + "\n[3]Lightning Bolt - 50 mana" + "\n[4]Cure Wounds - 60 mana\n");
            String spell = input.nextLine();
            if(hit + hitMod >= ac)
            {
                //Firebolt
                if(spell.equals("1") && mana >= 10)
                {
                    int x = (int)(Math.random()*10+2);
                    if(hit == 20)
                    {
                        x *=2;
                        System.out.println("A critical hit!");
                    }
                    subMana = 10;
                    System.out.println("You hit for " + x + " damage");
                    input.close();
                    return x; 
                }
                else if(spell.equals("1") && mana < 10)
                {
                    System.out.println("You do not have enough mana to cast this spell, your turn was skipped");
                    input.close();
                    return 0;
                }
                //Cure wounds
                else if(spell.equals("2") && mana >= 20)
                {
                    subMana = 20;
                    int x = (int)(Math.random()*10+2);
                    if(hp < maxHP)
                    {
                        hp += x;
                        if(hp > maxHP)
                        {
                            hp = maxHP;
                        }
                        System.out.println("You heal yourself for " + x + " health");
                    }
                    input.close();
                    return 0;
                }
                else if(spell.equals("2") && mana < 20)
                {
                    System.out.println("You do not have enough mana to cast this spell, your turn was skipped");
                    input.close();
                    return 0;
                }
                //lightning bolt
                else if(spell.equals("3") && mana >= 50)
                {
                    int x = (int)(Math.random()*29+4);
                    if(hit == 20)
                    {
                        x *=2;
                        System.out.println("A critical hit!");
                    }
                    subMana = 10;
                    System.out.println("You hit for " + x + " damage");
                    input.close();
                    return x; 
                }
                else if(spell.equals("3") && mana < 50)
                {
                    System.out.println("You do not have enough mana to cast this spell, your turn was skipped");
                    input.close();
                    return 0;
                }
                //Cure Wounds
                else if(spell.equals("4") && mana >= 60)
                {
                    subMana = 60;
                    int x = (int)(Math.random()*29+4+magiclvl);
                    if(hp < maxHP)
                    {
                        hp += x;
                        if(hp > maxHP)
                        {
                            hp = maxHP;
                        }
                        System.out.println("You heal yourself for " + x + " health");
                    }
                    input.close();
                    return 0;
                }
                else if(spell.equals("2") && mana < 60)
                {
                    System.out.println("You do not have enough mana to cast this spell, your turn was skipped");
                    input.close();
                    return 0;
                }
            }
            else
            {
                System.out.println("Your spell missed");
                input.close();
                usedMagic = true;
                if(input.equals("1"))
                    subMana = 10;
                else if(input.equals("2"))
                    subMana = 20;
                else if(input.equals("3"))
                    subMana = 50;
                else if(input.equals("4"))
                    subMana = 60;
                return subMana;
            }
        }
        input.close();
        return 0;
    }

    public int monsterTurn()
    {
        int roll = (int)(Math.random()*20+1);
        if(roll >= 10)
        {
            int damage = (int)(Math.random()*atk1+1) + meleMod;
            System.out.println("The " + name + " hit you for " + damage + " damage");
            return damage;
        }
        else
        {
            System.out.println("The " + name + " missed it's attack");
            return 0;
        }
    }

    public int getMonsterHealth()
    {
        return health;
    }

    public int subtractHP(int x)
    {
        return health - x;
    }

    public boolean didMagic()
    {
        return usedMagic;
    }

    public int manaUsed()
    {
        return subMana;
    }
}