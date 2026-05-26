import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class chef here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Chef extends Actor
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
        AparecerComida();
        if (Greenfoot.isKeyDown("space"))
        {
            getWorld().addObject(new Rodillo(), getX(), getY());
        }
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
    public void AparecerComida()
    {
        if (Greenfoot.getRandomNumber(100) < 1) {
            int randomX, randomY;
            int width = getWorld().getWidth();
            int height = getWorld().getHeight();
        
            //Elegir un lado aleatorio
            int lado = Greenfoot.getRandomNumber(4);
        
            if (lado == 0) {
                randomX = Greenfoot.getRandomNumber(width);
                randomY = 0;
            } else if (lado == 1) {
                randomX = Greenfoot.getRandomNumber(width);
                randomY = height - 1;
            } else if (lado == 2) {
                randomX = 0;
                randomY = Greenfoot.getRandomNumber(height);
            } else {
                randomX = width - 1;
                randomY = Greenfoot.getRandomNumber(height);
            }
        
            getWorld().addObject(new Comida(), randomX, randomY);
        }
    }
}

