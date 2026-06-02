import greenfoot.*;

public class Score extends Actor
{
    public int puntos = 0;

    public Score()
    {
        actualizarImagen();
    }

    public void sumarPunto()
    {
        puntos++;
        actualizarImagen();
    }
    public void restarPunto()
    {
        puntos--;
        if (puntos < 0) puntos = 0;
        actualizarImagen();
    }

    public void reiniciar()
    {
        puntos = 0;
        actualizarImagen();
    }
    public int getPuntos(){
    return puntos;
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