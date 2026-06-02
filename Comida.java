import greenfoot.*;

public class Comida extends Actor
{
    private int velocidad = 2;
    private int ready = 0;

    public void act()
    {
        if (getWorld() == null) return;
        if (ready == 0) {
            MyWorld mundo = (MyWorld)getWorld();
            turnTowards(mundo.getWidth() / 2, mundo.getHeight() / 2);
            setRotation(getRotation() + Greenfoot.getRandomNumber(90) - 45);
            ready = 1;
        }

        move(velocidad);

        // Si sale de la pantalla, desaparece
        if (isAtEdge())
        {
            getWorld().removeObject(this);
            return;
        }

       if (isTouching(Chef.class))
        {
        
            MyWorld mundo = (MyWorld)getWorld();
            
            // Avisar que perdio una vida
                mundo.addObject(new lostLife(), 0, 0);
                
            Greenfoot.playSound("freesound_community-grunt2.wav");
            Greenfoot.playSound("freesound_community-wrong-buzzer-6268.wav");
                
            mundo.getMarcador().reiniciar();
            
            // Quita una vida
            mundo.getVidas().perderVida();
            
            // Elimina la fruta
            getWorld().removeObject(this);
            
            return;
        }
        
        if(isTouching(Rodillo.class)){
            Actor rodillo = getOneIntersectingObject(Rodillo.class);
            getWorld().removeObject(rodillo);
            Greenfoot.playSound("splat.wav");
            MyWorld mundo = (MyWorld)getWorld();
            mundo.getMarcador().sumarPunto();
            getWorld().removeObject(this);
            return;
        }
        
        // Si el repelente la golpea, pierde una vida
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
