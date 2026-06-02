import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rodillo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rodillo extends Actor
{
    /**
     * Act - do whatever the Rodillo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int ready = 0;
    private int velocidad = 10;
    
    public void act()
    {
        if (ready == 0){
            ApuntarAlCursor();
        }
        move(velocidad);
        if (isAtEdge() )
        {
            getWorld().removeObject(this);
            return;
        }
    }
    public Rodillo()
    {
        GreenfootImage img = getImage();
        img.scale(86, 54); // prueba distintos tamaños
        setImage(img);
    }
    public void ApuntarAlCursor()
    {
        //Apuntar hacia el mouse
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            turnTowards(mouse.getX(), mouse.getY());
            ready = 1;
        }
    }
}
