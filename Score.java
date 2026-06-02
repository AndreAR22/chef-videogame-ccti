import greenfoot.*;

public class Score extends Actor
{
    private int puntos = 0;

    public Score()
    {
        actualizarImagen();
    }

    public void sumarPunto()
    {
        puntos++;
        actualizarImagen();
    }

    public void reiniciar()
    {
        puntos = 0;
        actualizarImagen();
    }

    private void actualizarImagen()
    {
        setImage(new GreenfootImage(
            "Comida: " + puntos,
            30,
            Color.BLACK,
            null
        ));
    }
}