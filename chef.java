import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class chef here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class chef extends Actor
{
    /**
     * Act - do whatever the chef wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    final int VELOCIDAD = 5;
    
    public void act()
    {
        Movimiento(VELOCIDAD);
        ApuntarAlCursor();
    }
    public void Movimiento(int vel)
    {
        if(Greenfoot.isKeyDown("w"))
        {
            // Mover 5 pixeles arriba
            setLocation(getX(), getY() - vel); 
        }
        if(Greenfoot.isKeyDown("a"))
        {
            // Mover 5 pixeles izquierda
            setLocation(getX() - vel, getY()); 
        }
        if(Greenfoot.isKeyDown("s"))
        {
            // Mover 5 pixeles abajo
            setLocation(getX(), getY() + vel); 
        }
        if(Greenfoot.isKeyDown("d"))
        {
            // Mover 5 pixeles derecha
            setLocation(getX() + vel, getY()); 
        }
    }
    public void ApuntarAlCursor()
    {
        //Apuntar hacia el mouse
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            turnTowards(mouse.getX(), mouse.getY());
        }
    }
}
