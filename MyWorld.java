import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    ArrayList<bubbles> bubble = new ArrayList<>();
     int spawnRate = 120;
     int counter = 0;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        //populate(20);
        //spawning();

        
    }
    
    public void act() {
        if (counter < spawnRate){
            counter++;
        }
        else {
            spawnBubble();
            counter = 0;
        }
    }
    public void populate(int howMany)
    {
        for (int i=0; i< howMany; i++) {
            bubble.add(new bubbles());
        }

    }

    public void spawning()
    {
        for( int i = 0; i < bubble.size(); i++)
        {
            int randomX = getWidth() - Greenfoot.getRandomNumber(50);
            //spawnrate = 500;
            addObject(bubble.get(i), randomX, 550);
        }
        
        

    }
    private void spawnBubble() {
            int randomX = getWidth() - Greenfoot.getRandomNumber(100);
            addObject(new bubbles(), randomX, 550);
    }

    
}
