import greenfoot.*;

public class Insectos extends Actor
{
    private int velocidad = 2;

    public void act()
    {
        moverHaciaChef();
        revisarColision();
        if(getWorld() == null)
        return;
        if(isTouching(Rodillo.class)){
            Actor rodillo = getOneIntersectingObject(Rodillo.class);
            getWorld().removeObject(rodillo);
            Greenfoot.playSound("freesound_community-wrong-buzzer-6268.wav");
            MyWorld mundo = (MyWorld)getWorld();
            mundo.getVidas().perderVida();
            mundo.getMarcador().reiniciar();
            getWorld().removeObject(this);
            return;
        }
        if(isTouching(Repelente.class)){
            Actor repelente = getOneIntersectingObject(Repelente.class);
            getWorld().removeObject(repelente);
            Greenfoot.playSound("freesound_community-correct-choice-43861.wav");
            getWorld().removeObject(this);
            return;
        }
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
            
            // Avisar que perdio una vida
                mundo.addObject(new lostLife(), 0, 0);
                
            Greenfoot.playSound("freesound_community-grunt2.wav");
                
            // Reinicia el score
            mundo.getMarcador().reiniciar();
            
            // Quita una vida
            mundo.getVidas().perderVida();
            
            // Elimina la mosca
            getWorld().removeObject(this);
            return;
        }
    }
    
    public void aumentarVelocidad()
    {
        velocidad++;
    }
}
