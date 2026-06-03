import greenfoot.*;

public class Comida extends Actor
{
    private int velocidad = 2;
    private int ready = 0;
    private IngredientType tipo;

    public Comida(IngredientType tipo)
    {
        this.tipo = tipo;
        String filename = "images/ingredient_" + tipo.getNombre().toLowerCase() + ".png";
        GreenfootImage img = new GreenfootImage(filename);
        img.scale(36, 36);

        GreenfootImage texto = new GreenfootImage(tipo.getNombre(), 14, Color.BLACK, new Color(0, 0, 0, 0));
        int ancho = Math.max(img.getWidth(), texto.getWidth() + 4);
        GreenfootImage finalImg = new GreenfootImage(ancho, img.getHeight() + texto.getHeight() + 2);

        finalImg.drawImage(img, (ancho - img.getWidth()) / 2, 0);
        finalImg.drawImage(texto, (ancho - texto.getWidth()) / 2, img.getHeight() + 2);

        setImage(finalImg);
    }

    public IngredientType getTipo()
    {
        return tipo;
    }

    public void act()
    {
        if (getWorld() == null) return;
        if (MyWorld.juegoTerminado()) return;
        if (ready == 0) {
            MyWorld mundo = (MyWorld)getWorld();
            turnTowards(mundo.getWidth() / 2, mundo.getHeight() / 2);
            setRotation(getRotation() + Greenfoot.getRandomNumber(90) - 45);
            ready = 1;
        }

        move(velocidad);

        if (isAtEdge())
        {
            getWorld().removeObject(this);
            return;
        }

        if (isTouching(Chef.class))
        {
            MyWorld mundo = (MyWorld)getWorld();

            mundo.addObject(new lostLife(), 0, 0);

            Greenfoot.playSound("freesound_community-grunt2.wav");
            Greenfoot.playSound("freesound_community-wrong-buzzer-6268.wav");

            mundo.getMarcador().reiniciar();
            mundo.getVidas().perderVida();

            getWorld().removeObject(this);
            return;
        }

        if(isTouching(Rodillo.class)){
            Actor rodillo = getOneIntersectingObject(Rodillo.class);
            getWorld().removeObject(rodillo);
            MyWorld mundo = (MyWorld)getWorld();
            boolean ok = mundo.recolectarIngrediente(tipo);
            if (ok) {
                Greenfoot.playSound("splat.wav");
            } else {
                Greenfoot.playSound("freesound_community-wrong-buzzer-6268.wav");
                MyWorld mundo2 = (MyWorld)getWorld();
                mundo2.getVidas().perderVida();
            }
            getWorld().removeObject(this);
            return;
        }

        if (isTouching(Repelente.class))
        {
            MyWorld mundo = (MyWorld)getWorld();

            Greenfoot.playSound("freesound_community-wrong-buzzer-6268.wav");
            mundo.getVidas().perderVida();
            Actor repelente = getOneIntersectingObject(Repelente.class);
            getWorld().removeObject(repelente);
            getWorld().removeObject(this);
            return;
        }
    }

    public void aumentarVelocidad()
    {
        velocidad++;
    }
}
