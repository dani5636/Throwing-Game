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
<<<<<<< Updated upstream
    ArrayList<Bubble> bubbles = new ArrayList<>();
    int speed = 130;
    int framerate = 60;
    int spawnrate=320;
    int lastSpawn=1;
    Duck myDuck = new Duck();
    public myWorld()
    {    
        // Create a new world with 20x20 cells with a cell size of 10x10 pixels.
        super(1500,800,1); 
        setBackground(new GreenfootImage("BG.png"));
        addObject(new ThrowArea(), 233, 371);

        addObject(myDuck,123,371);

        for(int i=0; i<30; i++){
            bubbles.add(i, new Bubble());
        }
=======
    ArrayList<bubbles> bubble = new ArrayList<>();
    int spawnrate;
>>>>>>> Stashed changes

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        populate();

<<<<<<< Updated upstream
    public void act(){
        //spawning();
        setBackground(new GreenfootImage("BG.png"));
        getBackground().setColor(Color.green);
        spawning();
        List duckes = getObjects(Duck.class);
        for(int j=0;j<speed;j++){
            myDuck.simulate(1);
            myDuck.act();
        }
        /*if(duckes.size()>0){
        for(int j=0;j<speed;j++){
        for(int i=0;i<duckes.size();i++){
        ((Duck)duckes.get(i)).simulate(1);
        }
        for(int i=0;i<duckes.size();i++){
        ((Duck)duckes.get(i)).act();
        }
        }
        }*/
=======
        
>>>>>>> Stashed changes
    }
    public void populate()
    {
        addObject(new bubbles(), 550,550);

    }

<<<<<<< Updated upstream
    public void ThrowArea(){
        GreenfootImage area = new GreenfootImage("TArea.png");

    }
    //does a spawn of ducks
    public void spawning(){
        if(spawnrate==400){
            if(lastSpawn<bubbles.size()){
                addObject(bubbles.get(bubbles.size()-lastSpawn),1431,700);
                spawnrate=0;
                lastSpawn++;
            }
=======
    public void spawning()
    {
        for( int i = 0; i < bubble.size(); i++)
        {
            spawnrate = 500;
            bubble.add(i, new bubbles());
>>>>>>> Stashed changes
        }
        

    }

<<<<<<< Updated upstream
    public void dieDuck(){
        removeObject(myDuck);
        myDuck = new Duck();
        addObject(myDuck,233,371);
    }
=======
    
>>>>>>> Stashed changes
}
