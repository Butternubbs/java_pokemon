import java.lang.Math;
/**
 * Write a description of class Vinosaur here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Vinosaur
{
    private int attack, originalAttack;
    private String type;
    private int hp;
    private boolean poisoned;
    private int tpp, vwpp, pppp, gpp;
    
    public Vinosaur()
    {
        attack = 10;
        originalAttack = 10;
        type = "grass";
        hp = 20;
        poisoned = false;
    }
    public Vinosaur(int a, String t, int h)
    {
        attack = a;
        originalAttack = a;
        type = t;
        hp = h;
    }
    public int Tackle()
    {
        tpp--;
        return (int)(attack * 0.4);
    }
    public int Vinewhip(String t)
    {
        vwpp--;
        boolean fire = (t.equals("fire"));
        boolean water = (t.equals("water"));
        if (fire = true)
            return (int)(0.5 *(attack * 0.4));
        else if (water = true)
            return (int)(2 *(attack * 0.4));
        else return (int)(attack * 0.4);
    }
    public boolean PoisonPowder()
    {
        pppp--;
        int accuracy = (int) Math.floor(Math.random() * 4);
        if (accuracy < 3) return true;
        else return false;
    }
    public boolean Growl()
    {
        if (originalAttack * 1.3 < attack)
        {
            gpp--;
            attack++;
            return true;
        }
        else return false;
    }
}
