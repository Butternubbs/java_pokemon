import java.util.Scanner;
/**
 * This class contains the turn-based battle system that forms the shape of turns. Also 
 * contains the enormous attack method, which carries out the moves of Monsters.
 * 
 * @author (Butternubbs)
 * @version (0.1)
 */
public class Battle
{
    public static boolean harshSunlight = false, rain = false, hail = false, sandstorm = false;
    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);

        System.out.println("Welcome to Pokemon Battle Simulator V1.0\n");

        System.out.println("Enter player Pokemon. (Gen 1 only)");
        System.out.println("Enter 'custom' to create custom fighter");
        Monster player = new Monster();
        Monster opponent = new Monster();
        String moveInput = "";
        int random = 0;

        player = Name.name();
        System.out.println("\nYour Pokemon is: " + player.name + "  Level: " + player.level);
        System.out.println("Types: " + player.type1 + ", " + player.type2);
        System.out.println("Max HP: " + player.hp + "  Attack: " + player.attack + "  Defense: " + player.defense);
        System.out.println("Sp. Attack: " + player.spAttack + "  Sp. Defense: " + player.spDefense + "  Speed: " + player.speed);
        System.out.println("Moves: " + player.move1 + "  " + player.move2 + "  " + player.move3 + "  " + player.move4);

        System.out.println("\nEnter opponent Pokemon. (Gen 1 only)");
        System.out.println("Enter 'custom' to create custom fighter");

        opponent = Name.name();
        System.out.println("\nYour opponent is: " + opponent.name + "  Level: " + opponent.level);
        System.out.println("Types: " + opponent.type1 + ", " + opponent.type2);
        System.out.println("Max HP: " + opponent.hp + "  Attack: " + opponent.attack + "  Defense: " + opponent.defense);
        System.out.println("Sp. Attack: " + opponent.spAttack + "  Sp. Defense: " + opponent.spDefense + "  Speed: " + opponent.speed);
        System.out.println("Moves: " + opponent.move1 + "  " + opponent.move2 + "  " + opponent.move3 + "  " + opponent.move4);
        opponent.name = ("The opposing " + opponent.name);

        //THE BATTLE STARTS HERE!
        System.out.println("\nBattle Start!\n");
        while (player.hp > 0 && opponent.hp > 0)
        {
            if (player.speed >= opponent.speed)
            {
                while(true)
                {
                    if (player.skipTurn == false)
                    {
                        System.out.println("Your known moves are: " + player.move1 + "  " + player.move2 + "  " + player.move3 + "  " + player.move4);
                        moveInput = reader.nextLine();
                    }
                    if(moveInput.equals(player.move1) && !moveInput.equals("---"))
                    {
                        attack(player.move1, player, opponent);
                        break;
                    }
                    else if(moveInput.equals(player.move2) && !moveInput.equals("---"))
                    {
                        attack(player.move2, player, opponent);
                        break;
                    }
                    else if(moveInput.equals(player.move3) && !moveInput.equals("---"))
                    {
                        attack(player.move3, player, opponent);
                        break;
                    }
                    else if(moveInput.equals(player.move4) && !moveInput.equals("---"))
                    {
                        attack(player.move4, player, opponent);
                        break;
                    }
                    else System.out.println("Your Pokemon does not know this move.");
                }
                if (player.hp <= 0 || opponent.hp <= 0) break;
                if (opponent.skipTurn == false)
                {
                    random = (int)Math.floor(Math.random() * 4);
                }
                while(true)
                {
                    if (random == 0 && !opponent.move1.equals("---")) 
                    {
                        attack(opponent.move1, opponent, player);
                        break;
                    }
                    else if (random == 1 && !opponent.move2.equals("---")) 
                    {
                        attack(opponent.move2, opponent, player);
                        break;
                    }
                    else if (random == 2 && !opponent.move3.equals("---")) 
                    {
                        attack(opponent.move3, opponent, player);
                        break;
                    }
                    else if (random == 3 && !opponent.move4.equals("---")) 
                    {
                        attack(opponent.move4, opponent, player);
                        break;
                    }
                    random = (int)Math.floor(Math.random() * 4);
                }
            }
            else
            {
                if (player.skipTurn == false && opponent.skipTurn == false)
                {
                    System.out.println("Your known moves are: " + player.move1 + "  " + player.move2 + "  " + player.move3 + "  " + player.move4);
                    while(true)
                    {
                        moveInput = reader.nextLine();
                        if(moveInput.equals(player.move1) || moveInput.equals(player.move2) || moveInput.equals(player.move3) || moveInput.equals(player.move4) && !moveInput.equals("---"))
                        {
                            random = (int)Math.floor(Math.random() * 4);
                            while(true)
                            {
                                if (random == 0 && !opponent.move1.equals("---")) 
                                {
                                    attack(opponent.move1, opponent, player);
                                    break;
                                }
                                else if (random == 1 && !opponent.move2.equals("---")) 
                                {
                                    attack(opponent.move2, opponent, player);
                                    break;
                                }
                                else if (random == 2 && !opponent.move3.equals("---")) 
                                {
                                    attack(opponent.move3, opponent, player);
                                    break;
                                }
                                else if (random == 3 && !opponent.move4.equals("---")) 
                                {
                                    attack(opponent.move4, opponent, player);
                                    break;
                                }
                                random = (int)Math.floor(Math.random() * 4);
                            }
                            if (player.hp <= 0 || opponent.hp <= 0) break;
                            if(moveInput.equals(player.move1))
                            {
                                attack(player.move1, player, opponent);
                                break;
                            }
                            else if(moveInput.equals(player.move2))
                            {
                                attack(player.move2, player, opponent);
                                break;
                            }
                            else if(moveInput.equals(player.move3))
                            {
                                attack(player.move3, player, opponent);
                                break;
                            }
                            else if(moveInput.equals(player.move4))
                            {
                                attack(player.move4, player, opponent);
                                break;
                            }
                        }
                        else System.out.println("Your Pokemon does not know this move.");
                    }
                    if (player.hp <= 0 || opponent.hp <= 0) break;
                }
                else if (opponent.skipTurn == false)
                {
                    random = (int)Math.floor(Math.random() * 4);
                    while(true)
                    {
                        if (random == 0 && !opponent.move1.equals("---")) 
                        {
                            attack(opponent.move1, opponent, player);
                            break;
                        }
                        else if (random == 1 && !opponent.move2.equals("---")) 
                        {
                            attack(opponent.move2, opponent, player);
                            break;
                        }
                        else if (random == 2 && !opponent.move3.equals("---")) 
                        {
                            attack(opponent.move3, opponent, player);
                            break;
                        }
                        else if (random == 3 && !opponent.move4.equals("---")) 
                        {
                            attack(opponent.move4, opponent, player);
                            break;
                        }
                        random = (int)Math.floor(Math.random() * 4);
                    }
                    if (player.hp <= 0 || opponent.hp <= 0) break;
                    if(moveInput.equals(player.move1))
                    {
                        attack(player.move1, player, opponent);
                        break;
                    }
                    else if(moveInput.equals(player.move2))
                    {
                        attack(player.move2, player, opponent);
                        break;
                    }
                    else if(moveInput.equals(player.move3))
                    {
                        attack(player.move3, player, opponent);
                        break;
                    }
                    else if(moveInput.equals(player.move4))
                    {
                        attack(player.move4, player, opponent);
                        break;
                    }
                }
                else if (player.skipTurn == false)
                {
                    System.out.println("Your known moves are: " + player.move1 + "  " + player.move2 + "  " + player.move3 + "  " + player.move4);
                    while(true)
                    {
                        moveInput = reader.nextLine();
                        if(moveInput.equals(player.move1) || moveInput.equals(player.move2) || moveInput.equals(player.move3) || moveInput.equals(player.move4) && !moveInput.equals("---"))
                        {
                            if (random == 0) attack(opponent.move1, opponent, player);
                            else if (random == 1) attack(opponent.move2, opponent, player);
                            else if (random == 2) attack(opponent.move3, opponent, player);
                            else if (random == 3) attack(opponent.move4, opponent, player);
                            if (player.hp <= 0 || opponent.hp <= 0) break;
                            if(moveInput.equals(player.move1))
                            {
                                attack(player.move1, player, opponent);
                                break;
                            }
                            else if(moveInput.equals(player.move2))
                            {
                                attack(player.move2, player, opponent);
                                break;
                            }
                            else if(moveInput.equals(player.move3))
                            {
                                attack(player.move3, player, opponent);
                                break;
                            }
                            else if(moveInput.equals(player.move4))
                            {
                                attack(player.move4, player, opponent);
                                break;
                            }
                        }
                        else System.out.println("Your Pokemon does not know this move.");
                    }
                }
            }
            if(player.poisoned == true)
            {
                System.out.println(player.name + " is poisoned!");
                player.hp -= (player.maxHP / 8);
                System.out.println(player.name + " lost " + (player.maxHP / 8) + " HP!");
                if (player.hp > 0) System.out.println(player.name + " now has " + player.hp + " HP.\n");
            }
            if(opponent.poisoned == true)
            {
                System.out.println(opponent.name + " is poisoned!");
                opponent.hp -= (opponent.maxHP / 8);
                System.out.println(opponent.name + " lost " + (opponent.maxHP / 8) + " HP!");
                if (opponent.hp > 0) System.out.println(opponent.name + " now has " + opponent.hp + " HP.\n");
            }
            if(player.burned == true)
            {
                System.out.println(player.name + " has a burn!");
                player.hp -= (player.maxHP / 8);
                System.out.println(player.name + " lost " + (player.maxHP / 8) + " HP!");
                if (player.hp > 0) System.out.println(player.name + " now has " + player.hp + " HP.\n");
            }
            if(opponent.burned == true)
            {
                System.out.println(opponent.name + " has a burn!");
                opponent.hp -= (opponent.maxHP / 8);
                System.out.println(opponent.name + " lost " + (opponent.maxHP / 8) + " HP!");
                if (opponent.hp > 0) System.out.println(opponent.name + " now has " + opponent.hp + " HP.\n");
            }
        }

        if (player.hp <= 0)
        {
            System.out.println("\nOh no! Your " + player.name + " fainted!");
        }
        else System.out.println("\nWoo-hoo! " + opponent.name + " fainted!");
    }

    public static void attack(String move, Monster att, Monster def)
    {
        Scanner reader = new Scanner(System.in);
        System.out.println();
        def.hpBefore = def.hp;
        if (att.flinching == true)
        {
            att.flinching = false;
            return;
        }
        if (def.protection == true)
        {
            System.out.println(def.name + " was protected from the attack!");
            def.protection = false;
            return;
        }
        if (def.flying == true)
        {
            System.out.println(att.name + " used " + move + "!");
            System.out.println(att.name + "'s attack missed!\n");
            if (move != "Gust")
            {
                return;
            }
        }
        if (att.confused == true)
        {
            System.out.println(att.name + " is confused!");
            att.confusedTurnCount--;
            if (Math.random() < 0.5)
            {
                System.out.println(att.name + " hurt itself in its confusion!");
                int damage = (int)((((((2.0 * (double)att.level) / 5.0) + 2.0) * 40.0 * ((double)att.attack/(double)att.defense)) / 50.0) + 2.0);
                att.hp -= damage;
                System.out.println(att.name + " lost " + damage + " HP!");
                return;
            }
        }
        if (att.asleep == true)
        {
            att.asleepTurnCount--;
            if (att.asleepTurnCount > 0)
            {
                System.out.println(att.name + " is fast asleep.");
                return;
            }
            else System.out.println(att.name + " woke up!");
        }
        if (! move.equals("Protect")) 
        {
            att.protectChance = 1;
        }
        if (move.equals("Tackle"))
        {
            System.out.println(att.name + " used Tackle!");
            int damage = att.tackle(def);
            if (damage != 0)
            {
                if (att.burned == true) damage /= 2;
                def.hp -= damage;
                System.out.println(def.name + " loses " + damage + " HP!");
                if (def.hp > 0)
                    System.out.println(def.name + " now has " + def.hp + " HP.\n");
            }
            else
                System.out.println(att.name + "'s attack missed!\n");
        }
        if (move.equals("Growl"))
        {
            System.out.println(att.name + " used Growl!");
            int response = att.growl(def);
            if (response == 1)
            {
                System.out.println(def.name + "'s Attack was lowered! \n");
            }
            else if (response == 2) System.out.println("But " + def.name + "'s Attack could not be lowered any further!\n");
            else
                System.out.println(att.name + "'s move missed!\n");
        }
        if (move.equals("Vine Whip"))
        {
            System.out.println(att.name + " used Vine Whip!");
            int damage = att.vineWhip(def);
            if (damage != 0)
            {
                if (att.burned == true) damage /= 2;
                def.hp -= damage;
                System.out.println(def.name + " loses " + damage + " HP!");
                if (def.hp > 0)
                    System.out.println(def.name + " now has " + def.hp + " HP.\n");
            }
            else System.out.println(att.name + "'s attack missed!\n");
        }
        if (move.equals("Poison Powder"))
        {
            System.out.println(att.name + " used Poison Powder!");
            int response = att.poisonPowder(def);
            if (response == 0) System.out.println(att.name + "'s move missed!\n");
            if (response == 1)
            {
                if (def.poisoned == true) 
                {
                    System.out.println(def.name + " is already poisoned!\n");
                }
                else
                {
                    System.out.println(def.name + " is now poisoned!\n");
                    def.poisoned = true;
                }
            }
            else if (response == 2) System.out.println("The move has no effect...\n");
        }
        if (move.equals("Take Down"))
        {
            System.out.println(att.name + " used Take Down!");
            int damage = att.takeDown(def);
            if (damage != 0)
            {
                if (att.burned == true) damage /= 2;
                def.hp -= damage;
                int recoil = (int)((double)damage / 4.0);
                att.hp -= recoil;
                System.out.println(def.name + " loses " + damage + " HP!");
                if (def.hp > 0)
                {   System.out.println(def.name + " now has " + def.hp + " HP.\n");
                    System.out.println(att.name + " is hit by recoil!");
                    System.out.println(att.name + " loses " + recoil + " HP!");
                }
                else System.out.println();
                if (att.hp > 0)
                    System.out.println(att.name + " now has " + att.hp + " HP.\n");
                else System.out.println();
            }
            else System.out.println(att.name + "'s attack missed!\n");
        }
        if (move.equals("Razor Leaf"))
        {
            System.out.println(att.name + " used Razor Leaf!");
            int damage = att.razorLeaf(def);
            if (damage != 0)
            {
                if (att.burned == true) damage /= 2;
                def.hp -= damage;
                System.out.println(def.name + " loses " + damage + " HP!");
                if (def.hp > 0)
                    System.out.println(def.name + " now has " + def.hp + " HP.\n");
            }
            else System.out.println(att.name + "'s attack missed!\n");
        }
        if (move.equals("Sweet Scent"))
        {
            System.out.println(att.name + " used Sweet Scent!");
            int response = att.sweetScent(def);
            if (response == 1)
            {
                System.out.println(def.name + "'s Evasion was lowered! \n");
            }
            else if (response == 2) System.out.println("But " + def.name + "'s Evasion could not be lowered any further!\n");
            else
                System.out.println(att.name + "'s move missed!\n");
        }
        if (move.equals("Growth"))
        {
            System.out.println(att.name + " used Growth!");
            int response = att.growth();
            if (response == 1 || response == 2)
            {
                System.out.println(att.name + "'s Sp. Attack was raised!");
            }
            if (response == 1 || response == 3)
            {
                System.out.println(att.name + "'s Attack was raised!");
            }
            if (response == 0) System.out.println(att.name + "'s Attack and Sp.Attack can't go any higher!");
            System.out.println();
        }
        if (move.equals("Double-Edge"))
        {
            System.out.println(att.name + " used Double-Edge!");
            int damage = att.doubleEdge(def);
            if (damage != 0)
            {
                if (att.burned == true) damage /= 2;
                def.hp -= damage;
                System.out.println(def.name + " loses " + damage + " HP!");
                if (def.hp > 0)
                {   System.out.println(def.name + " now has " + def.hp + " HP.\n");
                    int recoil = (int)((double)damage / 4.0);
                    System.out.println(att.name + " is hit by recoil!");
                    System.out.println(att.name + " loses " + recoil + " HP!");
                    att.hp -= recoil;
                    if (att.hp > 0)
                        System.out.println(att.name + " now has " + att.hp + " HP.\n");
                    else System.out.println();
                }
                else System.out.println();
            }
            else System.out.println(att.name + "'s attack missed!\n");
        }
        if (move.equals("Synthesis"))
        {
            System.out.println(att.name + " used Synthesis!");
            if (att.hp < att.maxHP)
            {
                int restore = att.synthesis();
                if (att.hp + restore < att.maxHP)
                {
                    att.hp += restore;
                    System.out.println(att.name + " restores " + restore + " HP!");
                }
                else 
                {
                    att.hp = att.maxHP;
                    System.out.println(att.name + "'s HP is fully restored!");
                }
                System.out.println(att.name + " now has " + att.hp + " HP.\n");
            }
            else System.out.println(att.name + " already has full HP!\n");
        }
        if (move.equals("Petal Blizzard"))
        {
            System.out.println(att.name + " used Petal Blizzard!");
            int damage = att.petalBlizzard(def);
            if (damage != 0)
            {
                if (att.burned == true) damage /= 2;
                def.hp -= damage;
                System.out.println(def.name + " loses " + damage + " HP!");
                if (def.hp > 0)
                    System.out.println(def.name + " now has " + def.hp + " HP.\n");
            }
            else
                System.out.println(att.name + "'s attack missed!\n");
        }
        if (move.equals("Solar Beam"))
        {
            if (att.turnCount == 0)
            {
                att.skipTurn = true;
                System.out.println(att.name + " is storing energy...\n");
                att.turnCount++;
            }
            else 
            {
                att.skipTurn = false;
                System.out.println(att.name + " used Solar Beam!");
                int damage = att.solarBeam(def);
                if (damage != 0)
                {
                    def.hp -= damage;
                    System.out.println(def.name + " loses " + damage + " HP!");
                    if (def.hp > 0)
                        System.out.println(def.name + " now has " + def.hp + " HP.\n");
                }
                else
                    System.out.println(att.name + "'s attack missed!\n");
                att.turnCount = 0;
            }
        }
        if (move.equals("Scratch"))
        {
            System.out.println(att.name + " used Scratch!");
            int damage = att.scratch(def);
            if (damage != 0)
            {
                if (att.burned == true) damage /= 2;
                def.hp -= damage;
                System.out.println(def.name + " loses " + damage + " HP!");
                if (def.hp > 0)
                    System.out.println(def.name + " now has " + def.hp + " HP.\n");
            }
            else
                System.out.println(att.name + "'s attack missed!\n");
        }
        if (move.equals("Ember"))
        {
            System.out.println(att.name + " used Ember!");
            int damage = att.ember(def);
            if (damage != 0)
            {
                def.hp -= damage;
                System.out.println(def.name + " loses " + damage + " HP!");
                if (def.hp > 0)
                    System.out.println(def.name + " now has " + def.hp + " HP.\n");
            }
            else
                System.out.println(att.name + "'s attack missed!\n");
        }
        if (move.equals("Smokescreen"))
        {
            System.out.println(att.name + " used Smokescreen!");
            int response = att.smokescreen(def);
            if (response == 1)
            {
                System.out.println(def.name + "'s Accuracy was lowered! \n");
            }
            else if (response == 2) System.out.println("But " + def.name + "'s Accuracy could not be lowered any further!\n");
            else
                System.out.println(att.name + "'s move missed!\n");
        }
        if (move.equals("Dragon Rage"))
        {
            System.out.println(att.name + " used Dragon Rage!");
            int response = att.dragonRage(def);
            if (response == 1)
            {
                def.hp -= 40;
                System.out.println(def.name + " loses 40 HP!");
                if (def.hp > 0)
                    System.out.println(def.name + " now has " + def.hp + " HP.\n");
            }
            else if (response == 2) System.out.println("The move has no effect!");
            else System.out.println(att.name + "'s move missed!\n");
        }
        if (move.equals("Scary Face"))
        {
            System.out.println(att.name + " used Scary Face!");
            int response = att.scaryFace(def);
            if (response == 1)
            {
                System.out.println(def.name + "'s Speed was lowered! \n");
            }
            else if (response == 2) System.out.println("But " + def.name + "'s Speed could not be lowered any further!\n");
            else
                System.out.println(att.name + "'s move missed!\n");
        }
        if (move.equals("Fire Fang"))
        {
            System.out.println(att.name + " used Fire Fang!");
            int damage = att.fireFang(def);
            if (damage != 0)
            {
                def.hp -= damage;
                System.out.println(def.name + " loses " + damage + " HP!");
                if (def.hp > 0)
                    System.out.println(def.name + " now has " + def.hp + " HP.\n");
            }
            else
                System.out.println(att.name + "'s attack missed!\n");
        }
        if (move.equals("Slash"))
        {

            System.out.println(att.name + " used Slash!");
            int damage = att.slash(def);
            if (damage != 0)
            {
                def.hp -= damage;
                System.out.println(def.name + " loses " + damage + " HP!");
                if (def.hp > 0)
                    System.out.println(def.name + " now has " + def.hp + " HP.\n");
            }
            else
                System.out.println(att.name + "'s attack missed!\n");
        }
        if (move.equals("Flamethrower"))
        {

            System.out.println(att.name + " used Flamethrower!");
            int damage = att.flamethrower(def);
            if (damage != 0)
            {
                def.hp -= damage;
                System.out.println(def.name + " loses " + damage + " HP!");
                if (def.hp > 0)
                    System.out.println(def.name + " now has " + def.hp + " HP.\n");
            }
            else
                System.out.println(att.name + "'s attack missed!\n");
        }
        if (move.equals("Flame Burst"))
        {

            System.out.println(att.name + " used Flame Burst!");
            int damage = att.flameBurst(def);
            if (damage != 0)
            {

                def.hp -= damage;
                System.out.println(def.name + " loses " + damage + " HP!");
                if (def.hp > 0)
                    System.out.println(def.name + " now has " + def.hp + " HP.\n");
            }
            else
                System.out.println(att.name + "'s attack missed!\n");
        }
        if (move.equals("Fly"))
        {

            if (att.turnCount == 0)
            {
                att.skipTurn = true;
                att.flying = true;
                System.out.println(att.name + " flew high into the sky!\n");
                att.turnCount++;
            }
            else 
            {
                att.skipTurn = false;
                att.flying = false;
                System.out.println(att.name + " used Fly!");
                int damage = att.fly(def);
                if (damage != 0)
                {
                    if (att.burned == true) damage /= 2;
                    def.hp -= damage;
                    System.out.println(def.name + " loses " + damage + " HP!");
                    if (def.hp > 0)
                        System.out.println(def.name + " now has " + def.hp + " HP.\n");
                }
                else
                    System.out.println(att.name + "'s attack missed!\n");
                att.turnCount = 0;
            }
        }
        if (move.equals("Tail Whip"))
        {

            System.out.println(att.name + " used Tail Whip!");
            int response = att.tailWhip(def);
            if (response == 1)
            {
                System.out.println(def.name + "'s Defense was lowered! \n");
            }
            else if (response == 2) System.out.println("But " + def.name + "'s Defense could not be lowered any further!\n");
            else
                System.out.println(att.name + "'s move missed!\n");
        }
        if (move.equals("Water Gun"))
        {
            System.out.println(att.name + " used Water Gun!");
            int damage = att.waterGun(def);
            if (damage != 0)
            {
                if (att.burned == true) damage /= 2;
                def.hp -= damage;
                System.out.println(def.name + " loses " + damage + " HP!");
                if (def.hp > 0)
                    System.out.println(def.name + " now has " + def.hp + " HP.\n");
            }
            else
                System.out.println(att.name + "'s attack missed!\n");
        }
        if (move.equals("Withdraw"))
        {
            System.out.println(att.name + " used Withdraw!");
            int response = att.withdraw();
            if (response == 1)
            {
                System.out.println(att.name + "'s Defense was raised! \n");
            }
            else if (response == 2) System.out.println("But " + att.name + "'s Defense could not be raised any further!\n");
        }
        if (move.equals("Bubble"))
        {
            System.out.println(att.name + " used Bubble!");
            int damage = att.bubble(def);
            if (damage != 0)
            {
                if (att.burned == true) damage /= 2;
                def.hp -= damage;
                System.out.println(def.name + " loses " + damage + " HP!");
                if (def.hp > 0)
                    System.out.println(def.name + " now has " + def.hp + " HP.\n");
            }
            else
                System.out.println(att.name + "'s attack missed!\n");
        }
        if (move.equals("Bite"))
        {
            System.out.println(att.name + " used Bite!");
            int damage = att.bite(def);
            if (damage != 0)
            {
                if (att.burned == true) damage /= 2;
                def.hp -= damage;
                System.out.println(def.name + " loses " + damage + " HP!");
                if (def.hp > 0)
                    System.out.println(def.name + " now has " + def.hp + " HP.\n");
            }
            else
                System.out.println(att.name + "'s attack missed!\n");
        }
        if (move.equals("Rapid Spin"))
        {
            System.out.println(att.name + " used Rapid Spin!");
            int damage = att.rapidSpin(def);
            if (damage != 0)
            {
                if (att.burned == true) damage /= 2;
                def.hp -= damage;
                System.out.println(def.name + " loses " + damage + " HP!");
                if (def.hp > 0)
                    System.out.println(def.name + " now has " + def.hp + " HP.\n");
            }
            else
                System.out.println(att.name + "'s attack missed!\n");
        }
        if (move.equals("Protect"))
        {
            System.out.println(att.name + " used Protect!");
            int response = att.protect();
            if (response == 1)
            {
                System.out.println(att.name + " protected itself!");
                if(att.protectChance > 0.2)att.protectChance /= 2;
            }
            else System.out.println(att.name + "'s move failed!");
        }
        if (move.equals("Water Pulse"))
        {
            System.out.println(att.name + " used Water Pulse!");
            int damage = att.waterPulse(def);
            if (damage != 0)
            {
                if (att.burned == true) damage /= 2;
                def.hp -= damage;
                System.out.println(def.name + " loses " + damage + " HP!");
                if (def.hp > 0)
                    System.out.println(def.name + " now has " + def.hp + " HP.\n");
            }
            else
                System.out.println(att.name + "'s attack missed!\n");
        }
        if (move.equals("Skull Bash"))
        {
            if (att.turnCount == 0)
            {
                att.skipTurn = true;
                System.out.println(att.name + " lowered its head!\n");
                att.turnCount++;
            }
            else 
            {
                att.skipTurn = false;
                System.out.println(att.name + " used Skull Bash!");
                int damage = att.skullBash(def);
                if (damage != 0)
                {
                    def.hp -= damage;
                    System.out.println(def.name + " loses " + damage + " HP!");
                    if (def.hp > 0)
                        System.out.println(def.name + " now has " + def.hp + " HP.\n");
                }
                else
                    System.out.println(att.name + "'s attack missed!\n");
                att.turnCount = 0;
            }
        }
        if (move.equals("Aqua Tail"))
        {
            System.out.println(att.name + " used Aqua Tail!");
            int damage = att.aquaTail(def);
            if (damage != 0)
            {
                if (att.burned == true) damage /= 2;
                def.hp -= damage;
                System.out.println(def.name + " loses " + damage + " HP!");
                if (def.hp > 0)
                    System.out.println(def.name + " now has " + def.hp + " HP.\n");
            }
            else
                System.out.println(att.name + "'s attack missed!\n");
        }
        if (move.equals("Iron Defense"))
        {
            System.out.println(att.name + " used Iron Defense!");
            int response = att.ironDefense();
            if (response == 1)
            {
                System.out.println(att.name + "'s Defense was raised! \n");
            }
            else if (response == 2) System.out.println("But " + att.name + "'s Defense could not be raised any further!\n");
        }
        if (move.equals("String Shot"))
        {
            System.out.println(att.name + " used String Shot!");
            int response = att.stringShot(def);
            if (response == 1)
            {
                System.out.println(def.name + "'s Speed was lowered! \n");
            }
            else if (response == 2) System.out.println("But " + def.name + "'s Speed could not be lowered any further!\n");
            else System.out.println(att.name + "'s move missed!\n");
        }
        if (move.equals("Harden"))
        {
            System.out.println(att.name + " used Harden!");
            int response = att.harden();
            if (response == 1)
            {
                System.out.println(att.name + "'s Defense was raised! \n");
            }
            else if (response == 2) System.out.println("But " + att.name + "'s Defense could not be raised any further!\n");
        }
        if (move.equals("Confusion"))
        {
            System.out.println(att.name + " used Confusion!");
            int damage = att.confusion(def);
            if (damage != 0)
            {
                if (att.burned == true) damage /= 2;
                def.hp -= damage;
                System.out.println(def.name + " loses " + damage + " HP!");
                if (def.hp > 0)
                    System.out.println(def.name + " now has " + def.hp + " HP.\n");
            }
            else
                System.out.println(att.name + "'s attack missed!\n");
        }
        if (move.equals("Sleep Powder"))
        {
            System.out.println(att.name + " used Sleep Powder!");
            int response = att.sleepPowder(def);
            if (response == 0) System.out.println(att.name + "'s move missed!\n");
            if (response == 1)
            {
                if (def.asleep == true) 
                {
                    System.out.println(def.name + " is already asleep!\n");
                }
                else
                {
                    System.out.println(def.name + " fell asleep!\n");
                    def.asleepTurnCount = (int)(Math.floor(Math.random() * 3) + 1);
                    def.asleep = true;
                }
            }
            else if (response == 2) System.out.println("The move has no effect...\n");
        }
        if (move.equals("Silver Wind"))
        {
            System.out.println(att.name + " used Silver Wind!");
            int damage = att.silverWind(def);
            if (damage != 0)
            {
                if (att.burned == true) damage /= 2;
                def.hp -= damage;
                System.out.println(def.name + " loses " + damage + " HP!");
                if (def.hp > 0)
                    System.out.println(def.name + " now has " + def.hp + " HP.\n");
            }
            else
                System.out.println(att.name + "'s attack missed!\n");
        }
        if (move.equals("Gust"))
        {
            System.out.println(att.name + " used Gust!");
            int damage = att.gust(def);
            if (damage != 0)
            {
                if (att.burned == true) damage /= 2;
                def.hp -= damage;
                System.out.println(def.name + " loses " + damage + " HP!");
                if (def.hp > 0)
                    System.out.println(def.name + " now has " + def.hp + " HP.\n");
            }
            else
                System.out.println(att.name + "'s attack missed!\n");
        }
        if (move.equals("Poison Sting"))
        {
            System.out.println(att.name + " used Poison Sting!");
            int damage = att.poisonSting(def);
            if (damage != 0)
            {
                if (att.burned == true) damage /= 2;
                def.hp -= damage;
                System.out.println(def.name + " loses " + damage + " HP!");
                if (def.hp > 0)
                    System.out.println(def.name + " now has " + def.hp + " HP.\n");
            }
            else
                System.out.println(att.name + "'s attack missed!\n");
        }
        if (move.equals("Twineedle"))
        {
            System.out.println(att.name + " used Twineedle!");
            int damage = att.twineedle(def);
            if (att.burned == true) damage /= 2;
            def.hp -= damage;
            System.out.println(def.name + " loses " + damage + " HP!");
            if (def.hp > 0)
                System.out.println(def.name + " now has " + def.hp + " HP.\n");
        }
        if (move.equals("Fury Attack"))
        {
            System.out.println(att.name + " used Fury Attack!");
            int damage = att.furyAttack(def);
            if (damage != 0)
            {
                if (att.burned == true) damage /= 2;
                def.hp -= damage;
                System.out.println(def.name + " loses " + damage + " HP!");
                if (def.hp > 0)
                    System.out.println(def.name + " now has " + def.hp + " HP.\n");
            }
            else
                System.out.println(att.name + "'s attack missed!\n");
        }
        if (move.equals("Rage"))
        {
            System.out.println(att.name + " used Rage!");
            int damage = att.rage(def);
            if (damage != 0)
            {
                if (att.burned == true) damage /= 2;
                def.hp -= damage;
                System.out.println(def.name + " loses " + damage + " HP!");
                if (def.hp > 0)
                    System.out.println(def.name + " now has " + def.hp + " HP.\n");
            }
            else
                System.out.println(att.name + "'s attack missed!\n");
            if (att.rage == false)
            {
               att.rage = true;
               att.skipTurn = true;
            }
            else 
            {
                if (def.hp > 0) System.out.println("End " + att.name + "'s Rage? Y/N");
                else return;
                while(true)
                {
                    String yn = reader.nextLine();
                    if (yn.equalsIgnoreCase("Y") || yn.equalsIgnoreCase("Yes"))
                    {
                        att.rage = false;
                        att.skipTurn = false;
                        break;
                    }
                    else if (yn.equalsIgnoreCase("N") || yn.equalsIgnoreCase("No")) break;
                    else System.out.println("Invalid input.");
                }
            }
        }
        if (def.hp < def.hpBefore && def.rage == true)
        {
            boolean tf = MoveMethods.RaiseStage("attack", def);
            System.out.println(def.name + "'s Rage is building...");
            if (tf == true) System.out.println(def.name + "'s Attack was raised!");
            else System.out.println(att.name + "'s Attack could not be raised any further!\n");
        }
    }
}
