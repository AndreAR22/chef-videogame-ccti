import greenfoot.*;

public class MyWorld extends World
{
    private Score marcador;
    private Vidas vidas;

    public MyWorld()
    {
        super(1100, 750, 1);

        // Crear marcador
        marcador = new Score();
        addObject(marcador, 100, 30);

        // Crear vidas
        vidas = new Vidas();
        addObject(vidas, 300, 30);

        prepare();
    }

    
    private GreenfootSound music = new GreenfootSound("game-music.wav");
 
    public void started()
    {
        music.playLoop();
    }
     
    public void stopped()
    {
        music.stop();
    }
    
    public Score getMarcador()
    {
        return marcador;
    }

    public Vidas getVidas()
    {
        return vidas;
    }

    private void prepare()
    {
        Chef chef = new Chef();
        addObject(chef, 548, 331);

        // Moscas iniciales
        Insectos insectos = new Insectos();
        addObject(insectos, 791, 250);

        Insectos insectos2 = new Insectos();
        addObject(insectos2, 481, 61);

        Insectos insectos3 = new Insectos();
        addObject(insectos3, 159, 304);

        Insectos insectos4 = new Insectos();
        addObject(insectos4, 674, 647);
    }

    public void act()
    {
        if (vidas.getVidas() <= 0)
        {
            showText("GAME OVER", getWidth() / 2, getHeight() / 2);
            music.stop();
            Greenfoot.stop();
        }

    }
    
}