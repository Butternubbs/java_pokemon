import java.util.Scanner;
/**
 * The main purpose of this method is to be used to determine the values of a Monster at
 * the start of a match.
 *
 * @author (Butternubbs)
 * @version (0.1)
 */
public class Name
{
    public static Monster name()
    {
        Scanner reader = new Scanner(System.in);
        Monster player = new Monster();
        
        while(true)
        {
            String nameInput = reader.nextLine();
            if (nameInput.equals("custom"))
            {
                System.out.println("Enter name of custom Pokemon.");
                String name = reader.nextLine();
                System.out.println("Enter elemental type 1 of custom Pokemon.");
                String type1 = reader.nextLine();
                System.out.println("Enter elemental type 2 of custom Pokemon. (If none, type 'none'.)");
                String type2 = reader.nextLine();
                System.out.println("Enter HP value for custom Pokemon.");
                int hp = reader.nextInt();
                System.out.println("Enter attack power for custom Pokemon.");
                int attack = reader.nextInt();
                System.out.println("Enter defense power for custom Pokemon.");
                int defense = reader.nextInt();
                System.out.println("Enter Special Attack power for custom Pokemon.");
                int spAttack = reader.nextInt();
                System.out.println("Enter Special Defense power for custom Pokemon.");
                int spDefense = reader.nextInt();
                System.out.println("Enter speed value for custom Pokemon.");
                int speed = reader.nextInt();
                reader.nextLine();
                System.out.println("Enter move 1 for custom Pokemon.");
                String move1 = reader.nextLine();
                System.out.println("Enter move 2 for custom Pokemon.");
                String move2 = reader.nextLine();
                System.out.println("Enter move 3 for custom Pokemon.");
                String move3 = reader.nextLine();
                System.out.println("Enter move 4 for custom Pokemon.");
                String move4 = reader.nextLine();
                System.out.println("Enter level of custom Pokemon.");
                int level = reader.nextInt();
                reader.nextLine();
                player = new Monster(name, type1, type2, hp, attack, defense, spAttack, spDefense, speed, move1, move2, move3, move4, level);
                break;
            }
            else if (nameInput.equalsIgnoreCase("bulbasaur"))
            {
                player = new Monster("Bulbasaur", "grass", "poison", 45, 49, 49, 65, 65, 45, "Tackle", "Growl", "Vine Whip", "Poison Powder", 10);
                break;
            }
            else if (nameInput.equalsIgnoreCase("ivysaur"))
            {
                player = new Monster("Ivysaur", "grass", "poison", 60, 62, 63, 80, 80, 60, "Take Down", "Razor Leaf", "Sweet Scent", "Growth", 25);
                break;
            }
            else if (nameInput.equalsIgnoreCase("venusaur"))
            {
                player = new Monster("Venusaur", "grass", "poison", 80, 82, 83, 100, 100, 80, "Double-Edge", "Synthesis", "Petal Blizzard", "Solar Beam", 50);
                break;
            }
            else if (nameInput.equalsIgnoreCase("charmander"))
            {
                player = new Monster("Charmander", "fire", "none", 39, 52, 43, 60, 50, 65, "Scratch", "Growl", "Ember", "Smokescreen", 10);
                break;
            }
            else if (nameInput.equalsIgnoreCase("charmeleon"))
            {
                player = new Monster("Charmeleon", "fire", "none", 58, 64, 58, 80, 65, 80, "Ember", "Dragon Rage", "Scary Face", "Fire Fang", 25);
                break;
            }
            else if (nameInput.equalsIgnoreCase("charizard"))
            {
                player = new Monster("Charizard", "fire", "flying", 78, 84, 78, 109, 85, 100, "Slash", "Flamethrower", "Flame Burst", "Fly", 50);
                break;
            }
            else if (nameInput.equalsIgnoreCase("squirtle"))
            {
                player = new Monster("Squirtle", "water", "none", 44, 48, 65, 50, 64, 43, "Tackle", "Tail Whip", "Water Gun", "Withdraw", 10);
                break;
            }
            else if (nameInput.equalsIgnoreCase("wartortle"))
            {
                player = new Monster("Wartortle", "water", "none", 59, 63, 80, 65, 80, 58, "Bubble", "Bite", "Rapid Spin", "Protect", 25);
                break;
            }
            else if (nameInput.equalsIgnoreCase("blastoise"))
            {
                player = new Monster("Blastoise", "water", "none", 79, 83, 100, 85, 105, 78, "Water Pulse", "Aqua Tail", "Skull Bash", "Iron Defense", 50);
                break;
            }
            else if (nameInput.equalsIgnoreCase("caterpie"))
            {
                player = new Monster("Caterpie", "bug", "none", 45, 30, 35, 20, 20, 45, "Tackle", "String Shot", "---", "---", 5);
                break;
            }
            else if (nameInput.equalsIgnoreCase("metapod"))
            {
                player = new Monster("Metapod", "bug", "none", 50, 20, 55, 25, 25, 30, "Harden", "---", "---", "---", 8);
                break;
            }
            else if (nameInput.equalsIgnoreCase("butterfree"))
            {
                player = new Monster("Butterfree", "bug", "flying", 60, 45, 50, 80, 80, 70, "Confusion", "Sleep Powder", "Silver Wind", "Gust", 20);
                break;
            }
            else if (nameInput.equalsIgnoreCase("weedle"))
            {
                player = new Monster("Weedle", "bug", "poison", 40, 35, 30, 20, 20, 50, "Poison Sting", "String Shot", "---", "---", 5);
                break;
            }
            else if (nameInput.equalsIgnoreCase("kakuna"))
            {
                player = new Monster("Kakuna", "bug", "poison", 45, 25, 50, 25, 25, 35, "Harden", "---", "---", "---", 8);
                break;
            }
            else if (nameInput.equalsIgnoreCase("beedrill"))
            {
                player = new Monster("Beedrill", "bug", "poison", 65, 80, 40, 45, 80, 75, "Twineedle", "Fury Attack", "Rage", "Focus Energy", 20);
                break;
            }
            else System.out.println("Invalid input.");
        }
        return player;
    }
}
