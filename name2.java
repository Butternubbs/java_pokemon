import java.util.Scanner;
/**
 * The main purpose of this method is to be used to determine the values of a Monster at
 * the start of a match.
 *
 * @author (Butternubbs)
 * @version (0.1)
 */
public class name2
{
    public static Monster name2()
    {
        Scanner reader = new Scanner(System.in);
        Scanner textFile = new Scanner("monsters.txt");
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
            else 
            {
                boolean exists = false;
                while(true)
                {
                    String find = textFile.next();
                    if (find.equals(nameInput))
                    {
                        player = new Monster(find, textFile.next(), textFile.next(), textFile.nextInt(), textFile.nextInt(), textFile.nextInt(), textFile.nextInt(), textFile.nextInt(), textFile.nextInt(), textFile.next(), textFile.next(), textFile.next(), textFile.next(), textFile.nextInt());
                        exists = true;
                        break;
                    }
                    else if (find == null || find.equals(""))
                    {
                        System.out.println("That is not the name of any Pokemon.");
                        break;
                    }
                }
                if (exists) break;
            }
        }
        return player;
    }
}