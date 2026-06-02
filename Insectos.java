import greenfoot.*;

public class Insectos extends Actor
{
    private int velocidad = 2;

    public void act()
    {
        moverHaciaChef();
        revisarColision();
    }

    public void moverHaciaChef()
    {
        if (getWorld().getObjects(Chef.class).size() > 0)
        {
            Actor chef = getWorld().getObjects(Chef.class).get(0);

            turnTowards(chef.getX(), chef.getY());

            move(velocidad);
        }
    }

    public void revisarColision()
    {
        if (isTouching(Chef.class))
        {
            MyWorld mundo = (MyWorld)getWorld();

            // Reinicia el score
            mundo.getMarcador().reiniciar();

            // Quita una vida
            mundo.getVidas().perderVida();

            // Elimina la mosca
            getWorld().removeObject(this);
        }
    }

    public void aumentarVelocidad()
    {
        velocidad++;
    }
}
