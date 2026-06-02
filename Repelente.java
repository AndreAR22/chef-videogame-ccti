import greenfoot.*;

public class Repelente extends Actor
{
    private int ready = 0;
    private int velocidad = 10;

    public void act()
    {
        if (ready == 0){
            ApuntarAlCursor();
        }
        move(velocidad);
        if (isAtEdge() )
        {
            getWorld().removeObject(this);
            return;
        }
    }
    public Repelente()
    {
        GreenfootImage img = new GreenfootImage("Gemini_Generated_Image_vng327vng327vng3-removebg-preview.png");
        img.scale(100, 40);
        setImage(img);
    }
    public void ApuntarAlCursor()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            turnTowards(mouse.getX(), mouse.getY());
            ready = 1;
        }
    }
}
