import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class lostLife here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class lostLife extends Actor
{
    /**
     * Act - do whatever the lostLife wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        tiempo--;

        if(tiempo <= 0)
        {
            getWorld().removeObject(this);
        }// Add your action code here.
    }
     private int tiempo = 20; // frames

    public lostLife()
    {
        GreenfootImage img = new GreenfootImage(2200,7500);

        img.setColor(new Color(255, 0, 0, 120)); // rojo semitransparente
        img.fill();

        setImage(img);
    }
}
