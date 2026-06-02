import greenfoot.*;

public class Vidas extends Actor
{
    private int vidas = 3;

    public Vidas()
    {
        actualizar();
    }

    public void perderVida()
    {
        vidas--;

        if (vidas < 0)
        {
            vidas = 0;
        }

        actualizar();
    }
    public void sumarVida(){
        vidas++;
        actualizar();
    }
    public int getVidas()
    {
        return vidas;
    }

    private void actualizar()
    {
        setImage(new GreenfootImage(
            "Vidas: " + vidas,
            30,
            Color.RED,
            null
        ));
    }
}