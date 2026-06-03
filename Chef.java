import greenfoot.*;

public class Chef extends Actor
{
    private int rate ;
    private int rateScore = 20;
    private int velocityBugSpawn = 90;
    private static GreenfootSound musica = new GreenfootSound("game-music.wav");
    private static boolean movimientoBloqueado = false;
    private int lastPuntosTrigger = 0;
    public void act()
    {
        if (!musica.isPlaying()) {
            musica.playLoop();
        }
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
        if (Greenfoot.mouseClicked(null) && shoot)
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if (mouse != null && mouse.getButton() == 1) {
                rate = rateScore;
                getWorld().addObject(new Rodillo(), getX(), getY());
                Greenfoot.playSound("throw.wav");
            }
        }
        if (Greenfoot.isKeyDown("space") && shoot)
        {
            rate = rateScore;
            getWorld().addObject(new Repelente(), getX(), getY());
            Greenfoot.playSound("homemade_sfx-spray-puff-272431.wav");
        }
        int puntos = mundo.getMarcador().getPuntos();
        if (puntos > 0 && puntos % 2 == 0 && puntos != lastPuntosTrigger) {
            lastPuntosTrigger = puntos;
            if (velocityBugSpawn > 5) velocityBugSpawn -= 5;
            if (rateScore > 10) rateScore -= 10;
        }
    }
    public Chef(){
        GreenfootImage img = getImage();
        img.scale(86, 100);
        setImage(img);
    }
    public static void bloquearMovimiento() {
        movimientoBloqueado = true;
    }

    public static void desbloquearMovimiento() {
        movimientoBloqueado = false;
    }

    public void Movimiento(int vel)
    {
        if (movimientoBloqueado) return;
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

    public static void detenerMusica() {
        if (musica != null) {
            musica.stop();
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
            IngredientType[] tipos = IngredientType.values();
            IngredientType tipo = tipos[Greenfoot.getRandomNumber(tipos.length)];

            int randomX;
            int randomY;

            int width = getWorld().getWidth();
            int height = getWorld().getHeight();
            int margen = 30;

            int lado = Greenfoot.getRandomNumber(4);

            if (lado == 0)
            {
                randomX = Greenfoot.getRandomNumber(width - margen * 2) + margen;
                randomY = margen;
            }
            else if (lado == 1)
            {
                randomX = Greenfoot.getRandomNumber(width - margen * 2) + margen;
                randomY = height - margen;
            }
            else if (lado == 2)
            {
                randomX = margen;
                randomY = Greenfoot.getRandomNumber(height - margen * 2) + margen;
            }
            else
            {
                randomX = width - margen;
                randomY = Greenfoot.getRandomNumber(height - margen * 2) + margen;
            }

            getWorld().addObject(new Comida(tipo), randomX, randomY);
        }
    }
    public void spawnBug()
    {
        if (velocityBugSpawn > 0 && Greenfoot.getRandomNumber(velocityBugSpawn) < 1)
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
