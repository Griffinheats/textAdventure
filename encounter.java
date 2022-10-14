import java.util.*;

public class encounter 
{
    String name, choice;
    int health, atk1, atk2, meleMod, rangeMod;
    public encounter(String monsterName, int monsterHealth, int atkOne, int atkTwo, int mod1, int mod2)//atkOne and atkTwo should be equal to the highest base damage that can be delt before adding modifier
    {
        name = monsterName;
        health = monsterHealth;
        atk1 = atkOne;
        atk2 = atkTwo;
        meleMod = mod1;
        rangeMod = mod2;
    }

    public void startRound(String playerName, String playerHealth, String playerMaxHP)
    {
        Scanner input = new Scanner(System.in);
        System.out.println(name + "\t\t" + playerName);
        System.out.println(health + "\t\t" + playerHealth + "/" + playerMaxHP);
        System.out.println("\nWhat do you do?\n[1]nAttack\n[2]Item\n[3]Magic\n[4]Run");
        if(choice.equals("1"))
        {
            
        }

        input.close();
    }
}
