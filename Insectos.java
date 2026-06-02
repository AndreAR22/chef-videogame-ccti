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
        died();
    
        }
    }
    public void died(){
            Actor rodillo = getOneIntersectingObject(Rodillo.class);
            getWorld().removeObject(rodillo);
            getWorld().removeObject(this);
            return;
        
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
                
            // Reinicia el score
            mundo.getMarcador().reiniciar();
            
            // Quita una vida
            mundo.getVidas().perderVida();
            
            // Elimina la mosca
            getWorld().removeObject(this);
        }
    }
    public void spawner (){
        
    }
    public void aumentarVelocidad()
    {
        velocidad++;
    }
}
