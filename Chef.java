import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Chef extends Actor
{
    private int rate ;
    private int rateScore = 20;
    private int velocityBugSpawn = 90;
    public void act()
    {
        final int VELOCIDAD = 5;
        Movimiento(VELOCIDAD);
        ApuntarAlCursor();
        AparecerComida();
        spawnBug();
        boolean shoot = false;
        rate --; 
        MyWorld mundo = (MyWorld)getWorld();
        if(rate <=0){
            shoot = true;
        }
        if (Greenfoot.mouseClicked(null)&& shoot)
        {
            rate =rateScore;
            getWorld().addObject(new Rodillo(), getX(), getY());
        }
        if( velocityBugSpawn>=1 && mundo.getMarcador().getPuntos()>0 && mundo.getMarcador().getPuntos()%50==0  ){
             velocityBugSpawn= velocityBugSpawn-5;
             rateScore = rateScore-10;
        }
    }
    public Chef(){
        GreenfootImage img = getImage();
        img.scale(86, 140); // prueba distintos tamaños
        setImage(img);
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
        if (Greenfoot.getRandomNumber(50) < 1)
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
    public void spawnBug()
    {
        if (Greenfoot.getRandomNumber(velocityBugSpawn) < 1)
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

            getWorld().addObject(new Insectos(), randomX, randomY);
        }
    }
}