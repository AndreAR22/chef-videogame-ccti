import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Font;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1500, 800, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Chef chef = new Chef();
        addObject(chef,307,162);
        chef.setLocation(307,194);
        chef.setLocation(742,367);
        chef.setLocation(763,367);
        chef.setLocation(780,375);

        Comida comida = new Comida();
        addObject(comida,1165,665);
        Comida comida2 = new Comida();
        addObject(comida2,295,614);
        Comida comida3 = new Comida();
        addObject(comida3,235,73);
        Comida comida4 = new Comida();
        addObject(comida4,1200,31);
        Comida comida5 = new Comida();
        addObject(comida5,1365,406);
        Insectos insectos = new Insectos();
        addObject(insectos,675,68);
        Insectos insectos2 = new Insectos();
        addObject(insectos2,692,676);
    }
}
