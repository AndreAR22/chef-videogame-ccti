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
        super(1100,750, 1); 
        prepare();
    }
    
      

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        Chef chef = new Chef();
        addObject(chef,548,331);
        Comida comida = new Comida();
        addObject(comida,850,73);
        Comida comida2 = new Comida();
        addObject(comida2,250,62);
        Comida comida3 = new Comida();
        addObject(comida3,170,492);
        Comida comida4 = new Comida();
        addObject(comida4,755,589);
        Comida comida5 = new Comida();
        addObject(comida5,337,684);
        Comida comida6 = new Comida();
        addObject(comida6,1006,384);
        Insectos insectos = new Insectos();
        addObject(insectos,791,250);
        Insectos insectos2 = new Insectos();
        addObject(insectos2,481,61);
        Insectos insectos3 = new Insectos();
        addObject(insectos3,159,304);
        Insectos insectos4 = new Insectos();
        addObject(insectos4,674,647);
        comida6.setLocation(1006,395);
        comida6.setLocation(1005,393);
        removeObject(comida6);
        removeObject(comida4);
        removeObject(comida5);
        removeObject(comida3);
        removeObject(comida2);
        removeObject(comida);
        removeObject(insectos);
        insectos2.setLocation(475,75);
        removeObject(insectos2);
        insectos3.setLocation(163,316);
        removeObject(insectos3);
        removeObject(insectos4);
    }
}