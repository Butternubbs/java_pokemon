
/**
 * This class contains a bunch of methods that are often used by move methods.
 *
 * @author (Butternubbs)
 * @version (0.1)
 */
public class MoveMethods
{

    public static boolean LowerStage(String stat, Monster monster)
    {
        if (stat.equals("attack"))
        {
            if (monster.attackStage < -6 || monster.attackStage > 6) return false;
            monster.attackStage--;
            if (monster.attackStage < 0)
            {
                monster.attack = (int)(monster.attackConstant * (2.0/((-1.0 * monster.attackStage) + 2.0)));
                return true;
            }
            else if (monster.attackStage == 0)
            {
                monster.attack = monster.attackConstant;
                return true;
            }
            else 
            {
                monster.attack = monster.attackConstant * ((2 + monster.attackStage)/2);
                return true;
            }
        }
        if (stat.equals("defense"))
        {
            if (monster.defenseStage < -6 || monster.defenseStage > 6) return false;
            monster.defenseStage--;
            if (monster.defenseStage < 0)
            {
                monster.defense = (int)(monster.defenseConstant * (2.0/((-1.0 * monster.defenseStage) + 2.0)));
                return true;
            }
            else if (monster.defenseStage == 0)
            {
                monster.defense = monster.defenseConstant;
                return true;
            }
            else 
            {
                monster.defense = monster.defenseConstant * ((2 + monster.defenseStage)/2);
                return true;
            }
        }
        if (stat.equals("spAttack"))
        {
            if (monster.spAttackStage < -6 || monster.spAttackStage > 6) return false;
            monster.spAttackStage--;
            if (monster.spAttackStage < 0)
            {
                monster.spAttack = (int)(monster.spAttackConstant * (2.0/((-1.0 * monster.spAttackStage) + 2.0)));
                return true;
            }
            else if (monster.spAttackStage == 0)
            {
                monster.spAttack = monster.spAttackConstant;
                return true;
            }
            else 
            {
                monster.spAttack = monster.spAttackConstant * ((2 + monster.spAttackStage)/2);
                return true;
            }
        }
        if (stat.equals("speed"))
        {
            if (monster.speedStage < -6 || monster.speedStage > 6) return false;
            monster.speedStage--;
            if (monster.spAttackStage < 0)
            {
                monster.speed = (int)(monster.speedConstant * (2.0/((-1.0 * monster.speedStage) + 2.0)));
                return true;
            }
            else if (monster.spAttackStage == 0)
            {
                monster.speed = monster.speedConstant;
                return true;
            }
            else 
            {
                monster.speed = monster.speedConstant * ((2 + monster.speedStage)/2);
                return true;
            }
        }
        if (stat.equals("accuracy"))
        {
            if (monster.accuracyStage < -6 || monster.accuracyStage > 6) return false;
            monster.accuracyStage--;
            if (monster.accuracyStage < 0)
            {
                monster.accuracy = (1.0 * (3.0/((-1.0 * (double)monster.accuracyStage) + 3.0)));
                return true;
            }
            else if (monster.accuracyStage == 0)
            {
                monster.accuracy = 1.0;
                return true;
            }
            else 
            {
                monster.accuracy = 1 * ((3 + monster.accuracyStage)/3);
                return true;
            }
        }
        if (stat.equals("evasion"))
        {
            if (monster.evasionStage < -6 || monster.evasionStage > 6) return false;
            monster.evasionStage--;
            if (monster.evasionStage < 0)
            {
                monster.evasion = (1.0 * (3.0/((-1.0 * (double)monster.evasionStage) + 3.0)));
                return true;
            }
            else if (monster.evasionStage == 0)
            {
                monster.evasion = 1;
                return true;
            }
            else 
            {
                monster.evasion = 1 * ((3 + monster.evasionStage)/3);
                return true;
            }
        }
        else return false;
    }

    public static boolean RaiseStage(String stat, Monster monster)
    {
        if (stat.equals("attack"))
        {
            if (monster.attackStage < -6 || monster.attackStage > 6) return false;
            monster.attackStage++;
            if (monster.attackStage < 0)
            {
                monster.attack = (int)(monster.attackConstant * (2.0/((-1.0 * monster.attackStage) + 2.0)));
                return true;
            }
            else if (monster.attackStage == 0)
            {
                monster.attack = monster.attackConstant;
                return true;
            }
            else 
            {
                monster.attack = monster.attackConstant * ((2 + monster.attackStage)/2);
                return true;
            }
        }
        if (stat.equals("defense"))
        {
            if (monster.defenseStage < -6 || monster.defenseStage > 6) return false;
            monster.defenseStage++;
            if (monster.defenseStage < 0)
            {
                monster.defense = (int)(monster.defenseConstant * (2.0/((-1.0 * monster.defenseStage) + 2.0)));
                return true;
            }
            else if (monster.defenseStage == 0)
            {
                monster.defense = monster.defenseConstant;
                return true;
            }
            else 
            {
                monster.defense = monster.defenseConstant * ((2 + monster.defenseStage)/2);
                return true;
            }
        }
        if (stat.equals("spAttack"))
        {
            if (monster.spAttackStage < -6 || monster.spAttackStage > 6) return false;
            monster.spAttackStage++;
            if (monster.spAttackStage < 0)
            {
                monster.spAttack = (int)(monster.spAttackConstant * (2.0/((-1.0 * monster.spAttackStage) + 2.0)));
                return true;
            }
            else if (monster.spAttackStage == 0)
            {
                monster.spAttack = monster.spAttackConstant;
                return true;
            }
            else 
            {
                monster.spAttack = monster.spAttackConstant * ((2 + monster.spAttackStage)/2);
                return true;
            }
        }
        if (stat.equals("spDefense"))
        {
            if (monster.spDefenseStage < -6 || monster.spDefenseStage > 6) return false;
            monster.spDefenseStage++;
            if (monster.spDefenseStage < 0)
            {
                monster.spDefense = (int)(monster.spDefenseConstant * (2.0/((-1.0 * monster.spDefenseStage) + 2.0)));
                return true;
            }
            else if (monster.spDefenseStage == 0)
            {
                monster.spDefense = monster.spDefenseConstant;
                return true;
            }
            else 
            {
                monster.spDefense = monster.spDefenseConstant * ((2 + monster.spDefenseStage)/2);
                return true;
            }
        }
        if (stat.equals("speed"))
        {
            if (monster.speedStage < -6 || monster.speedStage > 6) return false;
            monster.speedStage++;
            if (monster.speedStage < 0)
            {
                monster.speed = (int)(monster.speedConstant * (2.0/((-1.0 * monster.speedStage) + 2.0)));
                return true;
            }
            else if (monster.speedStage == 0)
            {
                monster.speed = monster.speedConstant;
                return true;
            }
            else 
            {
                monster.speed = monster.speedConstant * ((2 + monster.speedStage)/2);
                return true;
            }
        }
        else return false;
    }
    
    public static double NormalTypeDamage(double damage, Monster att, Monster def)
    {
        double typeDamage = damage;
        //Normal is not very effective against:
        if (def.type1.equals("rock") || def.type2.equals("rock"))
        {
            damage /= 2.0;
        }
        if (def.type1.equals("steel") || def.type2.equals("steel"))
        {
            damage /= 2.0;
        }
        //Normal has no effect against:
        if (def.type1.equals("ghost") || def.type2.equals("ghost"))
        {
            damage = 0;
        }
        
        if (damage == typeDamage * 2.0 || damage == typeDamage * 4.0)
        {
            System.out.println("It's super effective!");
        }
        else if (damage == typeDamage / 2.0 || damage == typeDamage / 4.0)
        {
            System.out.println("It's not very effective...");
        }
        //STAB:
        if (att.type1.equals("normal") || att.type2.equals("normal"))
        {
            damage *= 1.5;
        }
        return damage; 
    }

    public static double GrassTypeDamage(double damage, Monster att, Monster def)
    {
        double typeDamage = damage;
        //Grass is super effective against:
        if (def.type1.equals("ground") || def.type2.equals("ground"))
        {
            damage *= 2.0;
        }
        if (def.type1.equals("rock") || def.type2.equals("rock"))
        {
            damage *= 2.0;
        }
        if (def.type1.equals("water") || def.type2.equals("water"))
        {
            damage *= 2.0;
        }
        //Grass is not very effective against:
        if (def.type1.equals("bug") || def.type2.equals("bug"))
        {
            damage /= 2.0;
        }
        if (def.type1.equals("dragon") || def.type2.equals("dragon"))
        {
            damage /= 2.0;
        }
        if (def.type1.equals("fire") || def.type2.equals("fire"))
        {
            damage /= 2.0;
        }
        if (def.type1.equals("flying") || def.type2.equals("flying"))
        {
            damage /= 2.0;
        }
        if (def.type1.equals("grass") || def.type2.equals("grass"))
        {
            damage /= 2.0;
        }
        if (def.type1.equals("poison") || def.type2.equals("poison"))
        {
            damage /= 2.0;
        }
        if (def.type1.equals("steel") || def.type2.equals("steel"))
        {
            damage /= 2.0;
        }

        if (damage == typeDamage * 2.0 || damage == typeDamage * 4.0)
        {
            System.out.println("It's super effective!");
        }
        else if (damage == typeDamage / 2.0 || damage == typeDamage / 4.0)
        {
            System.out.println("It's not very effective...");
        }
        //STAB:
        if (att.type1.equals("grass") || att.type2.equals("grass"))
        {
            damage *= 1.5;
        }
        return damage;
    }
    
    public static double FireTypeDamage(double damage, Monster att, Monster def)
    {
        double typeDamage = damage;
        //Fire is super effective against:
        if (def.type1.equals("bug") || def.type2.equals("bug"))
        {
            damage *= 2.0;
        }
        if (def.type1.equals("grass") || def.type2.equals("grass"))
        {
            damage *= 2.0;
        }
        if (def.type1.equals("ice") || def.type2.equals("ice"))
        {
            damage *= 2.0;
        }
        if (def.type1.equals("steel") || def.type2.equals("steel"))
        {
            damage *= 2.0;
        }
        //Fire is not very effective against:
        if (def.type1.equals("dragon") || def.type2.equals("dragon"))
        {
            damage /= 2.0;
        }
        if (def.type1.equals("fire") || def.type2.equals("fire"))
        {
            damage /= 2.0;
        }
        if (def.type1.equals("rock") || def.type2.equals("rock"))
        {
            damage /= 2.0;
        }
        if (def.type1.equals("water") || def.type2.equals("water"))
        {
            damage /= 2.0;
        }

        if (damage == typeDamage * 2.0 || damage == typeDamage * 4.0)
        {
            System.out.println("It's super effective!");
        }
        else if (damage == typeDamage / 2.0 || damage == typeDamage / 4.0)
        {
            System.out.println("It's not very effective...");
        }
        //Weather effect:
        if (Battle.rain == true)
        {
            damage /= 2.0;
        }
        if (Battle.harshSunlight == false)
        {
            damage *= 2.0;
        }
        //STAB:
        if (att.type1.equals("fire") || att.type2.equals("fire"))
        {
            damage *= 1.5;
        }
        return damage;
    }
    
    public static double WaterTypeDamage(double damage, Monster att, Monster def)
    {
        double typeDamage = damage;
        //Water is super effective against:
        if (def.type1.equals("fire") || def.type2.equals("fire"))
        {
            damage *= 2.0;
        }
        if (def.type1.equals("ground") || def.type2.equals("ground"))
        {
            damage *= 2.0;
        }
        if (def.type1.equals("rock") || def.type2.equals("rock"))
        {
            damage *= 2.0;
        }
        
        //Water is not very effective against:
        if (def.type1.equals("dragon") || def.type2.equals("dragon"))
        {
            damage /= 2.0;
        }
        if (def.type1.equals("grass") || def.type2.equals("grass"))
        {
            damage /= 2.0;
        }
        if (def.type1.equals("water") || def.type2.equals("water"))
        {
            damage /= 2.0;
        }

        if (damage == typeDamage * 2.0 || damage == typeDamage * 4.0)
        {
            System.out.println("It's super effective!");
        }
        else if (damage == typeDamage / 2.0 || damage == typeDamage / 4.0)
        {
            System.out.println("It's not very effective...");
        }
        //Weather effect:
        if (Battle.rain == true)
        {
            damage *= 2.0;
        }
        if (Battle.harshSunlight == false)
        {
            damage /= 2.0;
        }
        //STAB:
        if (att.type1.equals("water") || att.type2.equals("water"))
        {
            damage *= 1.5;
        }
        return damage;
    }
    
    public static double FlyingTypeDamage(double damage, Monster att, Monster def)
    {
        double typeDamage = damage;
        //Flying is super effective against:
        if (def.type1.equals("bug") || def.type2.equals("bug"))
        {
            damage *= 2.0;
        }
        if (def.type1.equals("fighting") || def.type2.equals("fighting"))
        {
            damage *= 2.0;
        }
        if (def.type1.equals("grass") || def.type2.equals("grass"))
        {
            damage *= 2.0;
        }
        //Flying is not very effective against:
        if (def.type1.equals("rock") || def.type2.equals("rock"))
        {
            damage /= 2.0;
        }
        if (def.type1.equals("electric") || def.type2.equals("electric"))
        {
            damage /= 2.0;
        }
        if (def.type1.equals("steel") || def.type2.equals("steel"))
        {
            damage /= 2.0;
        }
        
        if (damage == typeDamage * 2.0 || damage == typeDamage * 4.0)
        {
            System.out.println("It's super effective!");
        }
        else if (damage == typeDamage / 2.0 || damage == typeDamage / 4.0)
        {
            System.out.println("It's not very effective...");
        }
        //STAB:
        if (att.type1.equals("flying") || att.type2.equals("flying"))
        {
            damage *= 1.5;
        }
        return damage;
    }
    
    public static double BugTypeDamage(double damage, Monster att, Monster def)
    {
        double typeDamage = damage;
        //Bug is super effective against:
        if (def.type1.equals("dark") || def.type2.equals("dark"))
        {
            damage *= 2.0;
        }
        if (def.type1.equals("psychic") || def.type2.equals("psychic"))
        {
            damage *= 2.0;
        }
        if (def.type1.equals("grass") || def.type2.equals("grass"))
        {
            damage *= 2.0;
        }
        //Bug is not very effective against:
        if (def.type1.equals("fairy") || def.type2.equals("fairy"))
        {
            damage /= 2.0;
        }
        if (def.type1.equals("fire") || def.type2.equals("fire"))
        {
            damage /= 2.0;
        }
        if (def.type1.equals("fighting") || def.type2.equals("fighting"))
        {
            damage /= 2.0;
        }
        if (def.type1.equals("flying") || def.type2.equals("flying"))
        {
            damage /= 2.0;
        }
        if (def.type1.equals("ghost") || def.type2.equals("ghost"))
        {
            damage /= 2.0;
        }
        if (def.type1.equals("poison") || def.type2.equals("poison"))
        {
            damage /= 2.0;
        }
        if (def.type1.equals("steel") || def.type2.equals("steel"))
        {
            damage /= 2.0;
        }
        
        if (damage == typeDamage * 2.0 || damage == typeDamage * 4.0)
        {
            System.out.println("It's super effective!");
        }
        else if (damage == typeDamage / 2.0 || damage == typeDamage / 4.0)
        {
            System.out.println("It's not very effective...");
        }
        //STAB:
        if (att.type1.equals("bug") || att.type2.equals("bug"))
        {
            damage *= 1.5;
        }
        return damage;
    }
    
    public static double PoisonTypeDamage(double damage, Monster att, Monster def)
    {
        double typeDamage = damage;
        //Poison is super effective against:
        if (def.type1.equals("fairy") || def.type2.equals("fairy"))
        {
            damage *= 2.0;
        }
        if (def.type1.equals("grass") || def.type2.equals("grass"))
        {
            damage *= 2.0;
        }
        //Poison is not very effective against:
        if (def.type1.equals("poison") || def.type2.equals("poison"))
        {
            damage /= 2.0;
        }
        if (def.type1.equals("ground") || def.type2.equals("ground"))
        {
            damage /= 2.0;
        }
        if (def.type1.equals("rock") || def.type2.equals("rock"))
        {
            damage /= 2.0;
        }
        if (def.type1.equals("ghost") || def.type2.equals("ghost"))
        {
            damage /= 2.0;
        }
        //Poison has no effect against:
        if (def.type1.equals("steel") || def.type2.equals("steel"))
        {
            damage = 0;
        }
        
        if (damage == typeDamage * 2.0 || damage == typeDamage * 4.0)
        {
            System.out.println("It's super effective!");
        }
        else if (damage == typeDamage / 2.0 || damage == typeDamage / 4.0)
        {
            System.out.println("It's not very effective...");
        }
        //STAB:
        if (att.type1.equals("poison") || att.type2.equals("poison"))
        {
            damage *= 1.5;
        }
        return damage;
    }
    
    public static double PsychicTypeDamage(double damage, Monster att, Monster def)
    {
        double typeDamage = damage;
        //Psychic is super effective against:
        if (def.type1.equals("fight") || def.type2.equals("fight"))
        {
            damage *= 2.0;
        }
        if (def.type1.equals("poison") || def.type2.equals("poison"))
        {
            damage *= 2.0;
        }
        //Psychic is not very effective against:
        if (def.type1.equals("psychic") || def.type2.equals("psychic"))
        {
            damage /= 2.0;
        }
        if (def.type1.equals("steel") || def.type2.equals("steel"))
        {
            damage /= 2.0;
        }
        //Psychic has no effect against:
        if (def.type1.equals("dark") || def.type2.equals("dark"))
        {
            damage = 0;
        }
        
        if (damage == typeDamage * 2.0 || damage == typeDamage * 4.0)
        {
            System.out.println("It's super effective!");
        }
        else if (damage == typeDamage / 2.0 || damage == typeDamage / 4.0)
        {
            System.out.println("It's not very effective...");
        }
        //STAB:
        if (att.type1.equals("psychic") || att.type2.equals("psychic"))
        {
            damage *= 1.5;
        }
        return damage;
    }
    
    public static double DarkTypeDamage(double damage, Monster att, Monster def)
    {
        double typeDamage = damage;
        //Dark is super effective against:
        if (def.type1.equals("ghost") || def.type2.equals("ghost"))
        {
            damage *= 2.0;
        }
        if (def.type1.equals("psychic") || def.type2.equals("psychic"))
        {
            damage *= 2.0;
        }
        //Dark is not very effective against:
        if (def.type1.equals("dark") || def.type2.equals("dark"))
        {
            damage /= 2.0;
        }
        if (def.type1.equals("fairy") || def.type2.equals("fairy"))
        {
            damage /= 2.0;
        }
        if (def.type1.equals("fighting") || def.type2.equals("fighting"))
        {
            damage /= 2.0;
        }
        
        if (damage == typeDamage * 2.0 || damage == typeDamage * 4.0)
        {
            System.out.println("It's super effective!");
        }
        else if (damage == typeDamage / 2.0 || damage == typeDamage / 4.0)
        {
            System.out.println("It's not very effective...");
        }
        //STAB:
        if (att.type1.equals("dark") || att.type2.equals("dark"))
        {
            damage *= 1.5;
        }
        return damage;
    }
}
