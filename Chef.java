import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Chef extends Actor
{
    public void act()
    {
        final int VELOCIDAD = 5;
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
        if (Greenfoot.isKeyDown("w"))
        {
            setLocation(getX(), getY() - vel);
        }

        if (Greenfoot.isKeyDown("a"))
        {
            setLocation(getX() - vel, getY());
        }

        if (Greenfoot.isKeyDown("s"))
        {
            setLocation(getX(), getY() + vel);
        }

        if (Greenfoot.isKeyDown("d"))
        {
            setLocation(getX() + vel, getY());
        }
    }

    public void ApuntarAlCursor()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();

        if (mouse != null)
        {
            turnTowards(mouse.getX(), mouse.getY());
        }
    }

    public void AparecerComida()
    {
        if (Greenfoot.getRandomNumber(100) < 1)
        {
            int randomX;
            int randomY;

            int width = getWorld().getWidth();
            int height = getWorld().getHeight();

            int lado = Greenfoot.getRandomNumber(4);

            if (lado == 0)
            {
                randomX = Greenfoot.getRandomNumber(width);
                randomY = 0;
            }
            else if (lado == 1)
            {
                randomX = Greenfoot.getRandomNumber(width);
                randomY = height - 1;
            }
            else if (lado == 2)
            {
                randomX = 0;
                randomY = Greenfoot.getRandomNumber(height);
            }
            else
            {
                randomX = width - 1;
                randomY = Greenfoot.getRandomNumber(height);
            }

            getWorld().addObject(new Comida(), randomX, randomY);
        }
    }
}