import greenfoot.*;

public class Comida extends Actor
{
    private int velocidad = 2;

    public Comida()
    {
        // Dirección aleatoria al aparecer
        setRotation(Greenfoot.getRandomNumber(360));
    }

    public void act()
    {
        move(velocidad);

        // Si sale de la pantalla, desaparece
        if (isAtEdge())
        {
            getWorld().removeObject(this);
            return;
        }

        // Si toca al chef
        if (isTouching(Chef.class))
        {
            MyWorld mundo = (MyWorld)getWorld();

            mundo.getMarcador().sumarPunto();

            getWorld().removeObject(this);
            return;
        }
    }

    public void aumentarVelocidad()
    {
        velocidad++;
    }
}