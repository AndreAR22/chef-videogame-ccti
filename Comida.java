import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class food here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Comida extends Actor
{
    /**
     * Act - do whatever the food wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int velocidad = 1;
    
    public void act()
    {
        MoverHaciaJugador();
    }
    public void MoverHaciaJugador()
    {
        Actor chef = (Actor)getWorld().getObjects(Chef.class).get(0);
        turnTowards(chef.getX(), chef.getY());
        
        move(velocidad);
    }
}
