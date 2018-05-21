import java.lang.Math;
/**
 * This class contains the basic information that is held by Monsters. Also contains
 * constructors for Monsters, methods that calculate data used for moves, and a few other
 * calculators.
 * 
 * @author (Butternubbs)
 * @version (0.1)
 */
public class Monster
{
    //Stats that are set by constructor and stats that are directly tied to those stats:
    public String name;
    public String type1;
    public String type2;
    public int hp, maxHP, hpBefore;
    public int attack, attackConstant;
    public int defense, defenseConstant;
    public int spAttack, spAttackConstant;
    public int spDefense, spDefenseConstant;
    public int speed, speedConstant;
    public String move1, move2, move3, move4;
    public int level;
    private boolean criticalHit;
    double accuracy = 1;
    double evasion = 1;
    public int attackStage = 0, defenseStage = 0, spAttackStage = 0, spDefenseStage = 0, speedStage = 0, evasionStage = 0, accuracyStage = 0;
    //Status effects:
    boolean poisoned, burned, confused, asleep;
    boolean flinching;
    boolean bind;
    boolean leechSeed;
    boolean rage = false;
    //Stats that affect the turn system and turncounts:
    boolean skipTurn = false;
    int turnCount = 0;
    int confusedTurnCount = 0;
    int asleepTurnCount = 0;
    boolean flying;
    boolean protection = false;
    double protectChance;

    public Monster()
    {
        name = "???";
        type1 = "normal";
        type2 = "none";
        hp = 1;
        attack = 1;
        defense = 1;
        spAttack = 1;
        spDefense = 1;
        speed = 1;
        move1 = "Tackle";
        move2 = "none";
        move3 = "none";
        move4 = "none";
        level = 1;
    }

    public Monster(String n, String t1, String t2, int h, int a, int d, int sa, int sd, int s, String m1, String m2, String m3, String m4, int l)
    {
        name = n;
        type1 = t1;
        type2 = t2;
        hp = h;
        maxHP = h;
        attack = a;
        attackConstant = a;
        defense = d;
        defenseConstant = d;
        spAttack = sa;
        spAttackConstant = sa;
        spDefense = sd;
        spDefenseConstant = sd;
        speed = s;
        speedConstant = s;
        move1 = m1;
        move2 = m2;
        move3 = m3;
        move4 = m4;
        level = l;
    }

    public boolean critHit()
    {
        if ((int)(Math.floor(Math.random() * (512.0 / this.speedConstant ))) == 0)
        {
            System.out.println("It's a critical hit!");
            return true;
        }
        else return false;
    }

    public int tackle(Monster def)
    {
        if (Math.random() < (this.accuracy/def.evasion) * 1)
        {
            double damage = ((((((2.0 * (double)this.level) / 5.0) + 2.0) * 40.0 * ((double)this.attack/(double)def.defense)) / 50.0) + 2.0);
            damage = MoveMethods.NormalTypeDamage(damage, this, def);
            if (critHit() == true) 
            {
                int cDamage = (int)(damage * ((2.0 * (double)level + 5.0) / ((double)level + 5.0)));
                return cDamage;
            }
            else return (int)damage;
        }
        else return 0;
    }

    public int growl(Monster def)
    {
        if (Math.random() < (this.accuracy/def.evasion) * 1)
        {
            boolean tf = MoveMethods.LowerStage("attack", def);
            if (tf = true) return 1;
            else return 2;
        }
        else return 0;
    }

    public int vineWhip(Monster def)
    {
        if (Math.random() < (this.accuracy/def.evasion) * 1)
        {
            double damage = ((((((2.0 * (double)this.level) / 5.0) + 2.0) * 45.0 * ((double)this.attack/(double)def.defense)) / 50.0) + 2.0);
            damage = MoveMethods.GrassTypeDamage(damage, this, def);
            if (critHit() == true) 
            {
                int cDamage = (int)(damage * ((2.0 * (double)level + 5.0) / ((double)level + 5.0)));
                return cDamage;
            }
            else return (int)damage;
        }
        else return 0;
    }

    public int poisonPowder(Monster def)
    {
        if (Math.random() < (this.accuracy/def.evasion) * 0.75)
        {
            if (def.type1.equals("poison") || def.type2.equals("poison") || def.type1.equals("steel") || def.type2.equals("steel"))
            {
                return 2;
            }
            else return 1;
        }
        else return 0;
    }

    public int takeDown(Monster def)
    {
        if (Math.random() < (this.accuracy/def.evasion) * 0.85)
        {
            double damage = ((((((2.0 * (double)this.level) / 5.0) + 2.0) * 90.0 * ((double)this.attack/(double)def.defense)) / 50.0) + 2.0);
            damage = MoveMethods.NormalTypeDamage(damage, this, def);
            if (critHit() == true) 
            {
                int cDamage = (int)(damage * ((2.0 * (double)level + 5.0) / ((double)level + 5.0)));
                return cDamage;
            }
            else return (int)damage;
        }
        else return 0;
    }

    public int razorLeaf(Monster def)
    {
        if (Math.random() < (this.accuracy/def.evasion) * 1)
        {
            double damage = ((((((2.0 * (double)this.level) / 5.0) + 2.0) * 55.0 * ((double)this.attack/(double)def.defense)) / 50.0) + 2.0);
            damage = MoveMethods.GrassTypeDamage(damage, this, def);
            if ((int)(Math.floor(Math.random() * (64.0 / this.speedConstant))) == 0) 
            {
                System.out.println("It's a critical hit!");
                return (int)(damage * ((2 * level + 5) / (level + 5)));
            }
            else return (int)damage;
        }
        else return 0;
    }

    public int sweetScent(Monster def)
    {
        if (Math.random() < (this.accuracy/def.evasion) * 1)
        {
            boolean tf = MoveMethods.LowerStage("evasion", def);
            if (tf = true) return 1;
            else return 2;
        }
        else return 0;
    }

    public int growth()
    {
        boolean tf = MoveMethods.RaiseStage("spAttack", this);
        boolean ft = MoveMethods.RaiseStage("attack", this);
        if(tf && ft) return 1;
        if (tf == true && ft == false) return 2;
        if (ft == true && tf == false) return 3;
        else return 0;
    }

    public int doubleEdge(Monster def)
    {
        if (Math.random() < (this.accuracy/def.evasion) * 1)
        {
            double damage = ((((((2.0 * (double)this.level) / 5.0) + 2.0) * 120.0 * ((double)this.attack/(double)def.defense)) / 50.0) + 2.0);
            damage = MoveMethods.NormalTypeDamage(damage, this, def);
            if (critHit() == true) 
            {
                int cDamage = (int)(damage * ((2.0 * (double)level + 5.0) / ((double)level + 5.0)));
                return cDamage;
            }
            else return (int)damage;
        }
        else return 0;
    }

    public int synthesis()
    {
        double restore;
        if (Battle.harshSunlight == true)
        {
            restore = (2.0 / 3.0 * this.maxHP);
        }
        else if (Battle.rain == true || Battle.hail == true || Battle.sandstorm == true)
        {
            restore = (1.0 / 4.0 * this.maxHP);
        }
        else restore = (1.0 / 2.0 * this.maxHP);
        return (int)restore;
    }

    public int petalBlizzard(Monster def)
    {
        if (Math.random() < (this.accuracy/def.evasion) * 1)
        {
            double damage = ((((((2.0 * (double)this.level) / 5.0) + 2.0) * 90.0 * ((double)this.attack/(double)def.defense)) / 50.0) + 2.0);
            damage = MoveMethods.GrassTypeDamage(damage, this, def);
            if (critHit() == true) 
            {
                int cDamage = (int)(damage * ((2.0 * (double)level + 5.0) / ((double)level + 5.0)));
                return cDamage;
            }
            else return (int)damage;
        }
        else return 0;
    }

    public int solarBeam(Monster def)
    {
        if (Math.random() < (this.accuracy/def.evasion) * 1)
        {
            double damage = ((((((2.0 * (double)this.level) / 5.0) + 2.0) * 120.0 * ((double)this.spAttack/(double)def.spDefense)) / 50.0) + 2.0);
            damage = MoveMethods.GrassTypeDamage(damage, this, def);
            if (critHit() == true) 
            {
                int cDamage = (int)(damage * ((2.0 * (double)level + 5.0) / ((double)level + 5.0)));
                return cDamage;
            }
            else return (int)damage;
        }
        else return 0;
    }

    public int scratch(Monster def)
    {
        if (Math.random() < (this.accuracy/def.evasion) * 1)
        {
            double damage = ((((((2.0 * (double)this.level) / 5.0) + 2.0) * 40.0 * ((double)this.attack/(double)def.defense)) / 50.0) + 2.0);
            damage = MoveMethods.NormalTypeDamage(damage, this, def);
            if (critHit() == true) 
            {
                int cDamage = (int)(damage * ((2.0 * (double)level + 5.0) / ((double)level + 5.0)));
                return cDamage;
            }
            else return (int)damage;
        }
        else return 0;
    }

    public int ember(Monster def)
    {
        if (Math.random() < (this.accuracy/def.evasion) * 1)
        {
            double damage = ((((((2.0 * (double)this.level) / 5.0) + 2.0) * 40.0 * ((double)this.spAttack/(double)def.spDefense)) / 50.0) + 2.0);
            damage = MoveMethods.FireTypeDamage(damage, this, def);
            if (def.type1 != "fire" && def.type2 != "fire" && def.burned == false && def.poisoned == false && (int)(Math.floor(Math.random() * 10)) == 0)
            {
                def.burned = true;
                System.out.println(def.name + " was burned!");
            }
            if (critHit() == true) 
            {
                int cDamage = (int)(damage * ((2.0 * (double)level + 5.0) / ((double)level + 5.0)));
                return cDamage;
            }
            else return (int)damage;
        }
        else return 0;
    }

    public int smokescreen(Monster def)
    {
        if (Math.random() < (this.accuracy/def.evasion) * 1)
        {
            boolean tf = MoveMethods.LowerStage("accuracy", def);
            if (tf = true) return 1;
            else return 2;
        }
        else return 0;
    }

    public int dragonRage(Monster def)
    {
        if (Math.random() < (this.accuracy/def.evasion) * 1)
        {
            if (def.type1 != "fairy" && def.type2 != "fairy")
            {
                return 1;
            }
            else return 2;
        }
        else return 0;
    }

    public int scaryFace(Monster def)
    {
        if (Math.random() < (this.accuracy/def.evasion) * 1)
        {
            boolean ft = MoveMethods.LowerStage("speed", def);
            boolean tf = MoveMethods.LowerStage("speed", def);
            if (ft && tf) return 1;
            else return 2;
        }
        else return 0;
    }

    public int fireFang(Monster def)
    {
        if (Math.random() < (this.accuracy/def.evasion) * 0.95)
        {
            double damage = ((((((2.0 * (double)this.level) / 5.0) + 2.0) * 65.0 * ((double)this.attack/(double)def.defense)) / 50.0) + 2.0);
            damage = MoveMethods.FireTypeDamage(damage, this, def);
            if (def.type1 != "fire" && def.type2 != "fire" && def.burned == false && def.poisoned == false && (int)(Math.floor(Math.random() * 10)) == 0)
            {
                def.burned = true;
                System.out.println(def.name + " was burned!");
            }
            if (critHit() == true) 
            {
                int cDamage = (int)(damage * ((2.0 * (double)level + 5.0) / ((double)level + 5.0)));
                return cDamage;
            }
            else return (int)damage;
        }
        else return 0;
    }

    public int slash(Monster def)
    {
        if (Math.random() < (this.accuracy/def.evasion) * 1)
        {
            double damage = ((((((2.0 * (double)this.level) / 5.0) + 2.0) * 70.0 * ((double)this.attack/(double)def.defense)) / 50.0) + 2.0);
            damage = MoveMethods.NormalTypeDamage(damage, this, def);
            if ((int)(Math.floor(Math.random() * (64.0 / this.speedConstant))) == 0) 
            {
                System.out.println("It's a critical hit!");
                return (int)(damage * ((2 * level + 5) / (level + 5)));
            }
            else return (int)damage;
        }
        else return 0;
    }

    public int flamethrower(Monster def)
    {
        if (Math.random() < (this.accuracy/def.evasion) * 1)
        {
            double damage = ((((((2.0 * (double)this.level) / 5.0) + 2.0) * 90.0 * ((double)this.spAttack/(double)def.spDefense)) / 50.0) + 2.0);
            damage = MoveMethods.FireTypeDamage(damage, this, def);
            if (def.type1 != "fire" && def.type2 != "fire" && def.burned == false && def.poisoned == false && (int)(Math.floor(Math.random() * 10)) == 0)
            {
                def.burned = true;
                System.out.println(def.name + " was burned!");
            }
            if (critHit() == true) 
            {
                int cDamage = (int)(damage * ((2.0 * (double)level + 5.0) / ((double)level + 5.0)));
                return cDamage;
            }
            else return (int)damage;
        }
        else return 0;
    }

    public int flameBurst(Monster def)
    {
        if (Math.random() < (this.accuracy/def.evasion) * 1)
        {
            double damage = ((((((2.0 * (double)this.level) / 5.0) + 2.0) * 70.0 * ((double)this.spAttack/(double)def.spDefense)) / 50.0) + 2.0);
            damage = MoveMethods.FireTypeDamage(damage, this, def);
            if (critHit() == true) 
            {
                int cDamage = (int)(damage * ((2.0 * (double)level + 5.0) / ((double)level + 5.0)));
                return cDamage;
            }
            else return (int)damage;
        }
        else return 0;
    }

    public int fly(Monster def)
    {
        if (Math.random() < (this.accuracy/def.evasion) * 0.95)
        {
            double damage = ((((((2.0 * (double)this.level) / 5.0) + 2.0) * 70.0 * ((double)this.attack/(double)def.defense)) / 50.0) + 2.0);
            damage = MoveMethods.FlyingTypeDamage(damage, this, def);
            if (critHit() == true) 
            {
                int cDamage = (int)(damage * ((2.0 * (double)level + 5.0) / ((double)level + 5.0)));
                return cDamage;
            }
            else return (int)damage;
        }
        else return 0;
    }

    public int tailWhip(Monster def)
    {
        if (Math.random() < (this.accuracy/def.evasion) * 1)
        {
            boolean tf = MoveMethods.LowerStage("defense", def);
            if (tf = true) return 1;
            else return 2;
        }
        else return 0;
    }

    public int waterGun(Monster def)
    {
        if (Math.random() < (this.accuracy/def.evasion) * 1)
        {
            double damage = ((((((2.0 * (double)this.level) / 5.0) + 2.0) * 40.0 * ((double)this.spAttack/(double)def.spDefense)) / 50.0) + 2.0);
            damage = MoveMethods.WaterTypeDamage(damage, this, def);
            if (critHit() == true) 
            {
                int cDamage = (int)(damage * ((2.0 * (double)level + 5.0) / ((double)level + 5.0)));
                return cDamage;
            }
            else return (int)damage;
        }
        else return 0;
    }

    public int withdraw()
    {
        boolean tf = MoveMethods.RaiseStage("defense", this);
        if (tf == true) return 1;
        else return 2;
    }

    public int bubble(Monster def)
    {
        if (Math.random() < (this.accuracy/def.evasion) * 1)
        {
            if ((int)(Math.floor(Math.random() * 10)) == 0)
            {
                boolean tf = MoveMethods.LowerStage("speed", def);
                if (tf == true)
                {
                    System.out.println(def.name + "'s Speed was lowered!");
                }
                else System.out.println(def.name + "'s Speed could not be lowered any further!");
            }

            double damage = ((((((2.0 * (double)this.level) / 5.0) + 2.0) * 40.0 * ((double)this.spAttack/(double)def.spDefense)) / 50.0) + 2.0);
            damage = MoveMethods.WaterTypeDamage(damage, this, def);
            if (critHit() == true) 
            {
                int cDamage = (int)(damage * ((2.0 * (double)level + 5.0) / ((double)level + 5.0)));
                return cDamage;
            }
            else return (int)damage;
        }
        else return 0;
    }

    public int bite(Monster def)
    {
        if (Math.random() < (this.accuracy/def.evasion) * 1)
        {
            double damage = ((((((2.0 * (double)this.level) / 5.0) + 2.0) * 60.0 * ((double)this.attack/(double)def.defense)) / 50.0) + 2.0);
            damage = MoveMethods.DarkTypeDamage(damage, this, def);
            if (Math.random() < 0.3) 
            {
                def.flinching = true;
                System.out.println(def.name + " flinched!");
            }
            if (critHit() == true) 
            {
                int cDamage = (int)(damage * ((2.0 * (double)level + 5.0) / ((double)level + 5.0)));
                return cDamage;
            }
            else return (int)damage;
        }
        else return 0;
    }

    public int rapidSpin(Monster def)
    {
        if (Math.random() < (this.accuracy/def.evasion) * 1)
        {
            double damage = ((((((2.0 * (double)this.level) / 5.0) + 2.0) * 20.0 * ((double)this.attack/(double)def.defense)) / 50.0) + 2.0);
            damage = MoveMethods.NormalTypeDamage(damage, this, def);
            if (this.bind == true)
            {
                this.bind = false;
                System.out.println(this.name + " broke from its bind!");
            }
            if (this.leechSeed == true)
            {
                this.leechSeed = false;
                System.out.println(this.name + " broke free from Leech Seed!");
            }
            if (critHit() == true) 
            {
                int cDamage = (int)(damage * ((2.0 * (double)level + 5.0) / ((double)level + 5.0)));
                return cDamage;
            }
            else return (int)damage;
        }
        else return 0;
    }

    public int protect()
    {
        if (Math.random() < this.protectChance)
        {
            this.protection = true;
            return 1;
        }
        else return 0;
    }

    public int waterPulse(Monster def)
    {
        if (Math.random() < (this.accuracy/def.evasion) * 1)
        {
            if ((int)(Math.floor(Math.random() * 5)) == 0)
            {
                def.confused = true;
                def.confusedTurnCount = (int)(Math.floor(Math.random() * 4) + 1);
                System.out.println(def.name + " became confused!");
            }

            double damage = ((((((2.0 * (double)this.level) / 5.0) + 2.0) * 60.0 * ((double)this.spAttack/(double)def.spDefense)) / 50.0) + 2.0);
            damage = MoveMethods.WaterTypeDamage(damage, this, def);
            if (critHit() == true) 
            {
                int cDamage = (int)(damage * ((2.0 * (double)level + 5.0) / ((double)level + 5.0)));
                return cDamage;
            }
            else return (int)damage;
        }
        else return 0;
    }

    public int skullBash(Monster def)
    {
        if (Math.random() < (this.accuracy/def.evasion) * 1)
        {
            double damage = ((((((2.0 * (double)this.level) / 5.0) + 2.0) * 40.0 * ((double)this.attack/(double)def.defense)) / 50.0) + 2.0);
            damage = MoveMethods.NormalTypeDamage(damage, this, def);
            if (critHit() == true) 
            {
                int cDamage = (int)(damage * ((2.0 * (double)level + 5.0) / ((double)level + 5.0)));
                return cDamage;
            }
            else return (int)damage;
        }
        else return 0;
    }

    public int aquaTail(Monster def)
    {
        if (Math.random() < (this.accuracy/def.evasion) * 1)
        {
            double damage = ((((((2.0 * (double)this.level) / 5.0) + 2.0) * 90.0 * ((double)this.attack/(double)def.defense)) / 50.0) + 2.0);
            damage = MoveMethods.WaterTypeDamage(damage, this, def);
            if (critHit() == true) 
            {
                int cDamage = (int)(damage * ((2.0 * (double)level + 5.0) / ((double)level + 5.0)));
                return cDamage;
            }
            else return (int)damage;
        }
        else return 0;
    }

    public int ironDefense()
    {
        boolean tf = MoveMethods.RaiseStage("defense", this);
        boolean ft = MoveMethods.RaiseStage("defense", this);
        if (tf == true) return 1;
        else return 2;
    }

    public int stringShot(Monster def)
    {
        if (Math.random() < (this.accuracy/def.evasion) * 0.95)
        {
            boolean tf = MoveMethods.LowerStage("speed", def);
            if (tf == true) return 1;
            else return 2;
        }
        else return 0;
    }

    public int harden()
    {
        boolean tf = MoveMethods.RaiseStage("defense", this);
        if (tf == true) return 1;
        else return 2;
    }

    public int confusion(Monster def)
    {
        if (Math.random() < (this.accuracy/def.evasion) * 1)
        {
            double damage = ((((((2.0 * (double)this.level) / 5.0) + 2.0) * 50.0 * ((double)this.spAttack/(double)def.spDefense)) / 50.0) + 2.0);
            damage = MoveMethods.PsychicTypeDamage(damage, this, def);
            if ((int)(Math.floor(Math.random() * 10)) == 0)
            {
                def.confused = true;
                def.confusedTurnCount = (int)(Math.floor(Math.random() * 4) + 1);
                System.out.println(def.name + " became confused!");
            }
            if (critHit() == true) 
            {
                int cDamage = (int)(damage * ((2.0 * (double)level + 5.0) / ((double)level + 5.0)));
                return cDamage;
            }
            else return (int)damage;
        }
        else return 0;
    }

    public int sleepPowder(Monster def)
    {
        if (Math.random() < (this.accuracy/def.evasion) * 0.75)
        {
            if (def.type1.equals("grass") || def.type2.equals("grass"))
            {
                return 2;
            }
            else return 1;
        }
        else return 0;
    }

    public int silverWind(Monster def)
    {
        if (Math.random() < (this.accuracy/def.evasion) * 1)
        {
            double damage = ((((((2.0 * (double)this.level) / 5.0) + 2.0) * 60.0 * ((double)this.spAttack/(double)def.spDefense)) / 50.0) + 2.0);
            damage = MoveMethods.BugTypeDamage(damage, this, def);
            if (Math.random() < 0.1)
            {
                boolean a = MoveMethods.RaiseStage("attack", this);
                boolean b = MoveMethods.RaiseStage("defense", this);
                boolean c = MoveMethods.RaiseStage("spAttack", this);
                boolean d = MoveMethods.RaiseStage("spDefense", this);
                boolean e = MoveMethods.RaiseStage("speed", this);
                if (a == false && b == false && c == false && d == false && e == false)
                {
                    System.out.print(this.name + "'s stats can't go any higher!");
                }
                else System.out.println(this.name + "'s stats were raised!");
            }
            if (critHit() == true) 
            {
                int cDamage = (int)(damage * ((2.0 * (double)level + 5.0) / ((double)level + 5.0)));
                return cDamage;
            }
            else return (int)damage;
        }
        else return 0;
    }

    public int gust(Monster def)
    {
        if (Math.random() < (this.accuracy/def.evasion) * 1)
        {
            double damage;
            if (def.flying == false)
            {
                damage = ((((((2.0 * (double)this.level) / 5.0) + 2.0) * 40.0 * ((double)this.spAttack/(double)def.spDefense)) / 50.0) + 2.0);
            }
            else damage = ((((((2.0 * (double)this.level) / 5.0) + 2.0) * 80.0 * ((double)this.spAttack/(double)def.spDefense)) / 50.0) + 2.0);
            damage = MoveMethods.FlyingTypeDamage(damage, this, def);
            if (critHit() == true) 
            {
                int cDamage = (int)(damage * ((2.0 * (double)level + 5.0) / ((double)level + 5.0)));
                return cDamage;
            }
            else return (int)damage;
        }
        else return 0;
    }

    public int poisonSting(Monster def)
    {
        if (Math.random() < (this.accuracy/def.evasion) * 1)
        {
            double damage = ((((((2.0 * (double)this.level) / 5.0) + 2.0) * 15.0 * ((double)this.attack/(double)def.defense)) / 50.0) + 2.0);
            damage = MoveMethods.PoisonTypeDamage(damage, this, def);
            if (Math.random() < 0.1)
            {
                def.poisoned = true;
                System.out.println(def.name + " was poisoned!");
            }
            if (critHit() == true) 
            {
                int cDamage = (int)(damage * ((2.0 * (double)level + 5.0) / ((double)level + 5.0)));
                return cDamage;
            }
            else return (int)damage;
        }
        else return 0;
    }

    public int twineedle(Monster def)
    {
        double damage = 0, damage2 = 0;
        if (Math.random() < (this.accuracy/def.evasion) * 1)
        {
            damage = ((((((2.0 * (double)this.level) / 5.0) + 2.0) * 25.0 * ((double)this.attack/(double)def.defense)) / 50.0) + 2.0);
            damage = MoveMethods.BugTypeDamage(damage, this, def);
            if (Math.random() < 0.2)
            {
                def.poisoned = true;
                System.out.println(def.name + " was poisoned!");
            }
            if (critHit() == true) 
            {
                int cDamage = (int)(damage * ((2.0 * (double)level + 5.0) / ((double)level + 5.0)));
                damage = cDamage;
            }
            damage2 = ((((((2.0 * (double)this.level) / 5.0) + 2.0) * 25.0 * ((double)this.attack/(double)def.defense)) / 50.0) + 2.0);
            damage2 = MoveMethods.BugTypeDamage(damage, this, def);
            if (Math.random() < 0.2)
            {
                def.poisoned = true;
                System.out.println(def.name + " was poisoned!");
            }
            if (critHit() == true) 
            {
                int cDamage = (int)(damage2 * ((2.0 * (double)level + 5.0) / ((double)level + 5.0)));
                damage2 = cDamage;
            }
            System.out.println("Hit 2 time(s)!");
        }
        else System.out.println(this.name + "'s attack missed!");
        return (int)(damage + damage2);
    }

    public int furyAttack(Monster def)
    {
        if (Math.random() < (this.accuracy/def.evasion) * 0.85)
        {
            double damage1 = 0;
            int times;
            int random = (int)(Math.floor(Math.random() * 6));
            if (random < 2) times = 2;
            else if (random < 4) times = 3;
            else times = random;
            int times1 = times;
            while (times > 0)
            {
                double damage = ((((((2.0 * (double)this.level) / 5.0) + 2.0) * 15.0 * ((double)this.attack/(double)def.defense)) / 50.0) + 2.0);
                damage = MoveMethods.NormalTypeDamage(damage, this, def);
                if (critHit() == true) 
                {
                    int cDamage = (int)(damage * ((2.0 * (double)level + 5.0) / ((double)level + 5.0)));
                    return cDamage;
                }
                times--;
                damage1 += damage;
            }
            System.out.println("Hit " + times1 + " time(s)!");
            return (int)damage1;
        }
        else return 0;
    }
    
    public int rage(Monster def)
    {
        if (Math.random() < (this.accuracy/def.evasion) * 1)
        {
            double damage = ((((((2.0 * (double)this.level) / 5.0) + 2.0) * 20.0 * ((double)this.attack/(double)def.defense)) / 50.0) + 2.0);
            damage = MoveMethods.NormalTypeDamage(damage, this, def);
            if (critHit() == true) 
            {
                int cDamage = (int)(damage * ((2.0 * (double)level + 5.0) / ((double)level + 5.0)));
                return cDamage;
            }
            else return (int)damage;
        }
        else return 0;
    }
}
