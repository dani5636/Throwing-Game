import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
<<<<<<< HEAD

public class MyWorld  extends World
{
    private GameState gState = new GameState();
    private ArrayList<Bubble> bubbles = new ArrayList<>();
    private int speed = 130;
    private int framerate = 60;
    private int spawnrate=0;
    private int lastSpawn=1;
    private String prefix = "score: ";
    private Duck myDuck = new Duck();
    
    public MyWorld()
=======
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
>>>>>>> origin/Development-Branch
    {    
        // Create a new world with 20x20 cells with a cell size of 10x10 pixels.
        super(1500,800,1); 
        setBackground(new GreenfootImage("BG.png"));
        addObject(new ThrowArea(), 233, 371);
        addObject(new ScoreBoard(), 233,100);
        addObject(myDuck,233,371);

        for(int i=0; i<30; i++){
            bubbles.add(i, new Bubble());
        }
=======
    ArrayList<bubbles> bubble = new ArrayList<>();
    int spawnrate;
>>>>>>> Stashed changes

<<<<<<< HEAD
        //addObject(new duck(true),275,250);
        //addObject(new spring(200,0,-.1,0),250,250);
        //Greenfoot.start();

    }
    //acts
=======
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
>>>>>>> origin/Development-Branch
    public void act(){
        spawning();
        setBackground("BG.png");
        //The duck's speed in the game
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
<<<<<<< HEAD
    //receives information from the duck to draw a line between it and the mouse.
    public void drawLine(int a,int b,int c,int d){
        getBackground().drawLine(a,b,c,d);
    }

    
    //spawns the bubbles
=======
    public void populate()
    {
        addObject(new bubbles(), 550,550);

    }

<<<<<<< Updated upstream
    public void ThrowArea(){
        GreenfootImage area = new GreenfootImage("TArea.png");

    }
    //does a spawn of ducks
>>>>>>> origin/Development-Branch
    public void spawning(){
        if(spawnrate==200){
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
<<<<<<< HEAD
    // Replaces current duck with a new duck.
=======

<<<<<<< Updated upstream
>>>>>>> origin/Development-Branch
    public void dieDuck(){
        removeObject(myDuck);
        myDuck = new Duck();
        addObject(myDuck,233,371);
    }
<<<<<<< HEAD
    
    //returns GameState
    public GameState getGameState(){
    return gState;
    }
=======
=======
    
>>>>>>> Stashed changes
>>>>>>> origin/Development-Branch
}
