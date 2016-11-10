import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.awt.Color;
import java.util.ArrayList;

public class MyWorld  extends World
{
    private GameState gState;
    private ArrayList<Target> targets = new ArrayList<>();
    private int speed = 120;
    private int spawnrate=0;
    private int lastSpawn=1;
    private String bGround;
    private String prefix = "score: ";
    private Duck myDuck = new Duck();
    private int NumberOfTargets;
    public MyWorld()
    {    
        // Create a new world with 20x20 cells with a cell size of 10x10 pixels.
        super(1500,800,1); 
        bGround="BG.png";
        NumberOfTargets = 30;
        setBackground(new GreenfootImage(bGround));
        addObject(new ThrowArea(), 233, 371);
        addObject(new ScoreBoard(), 233,50);
        addObject(myDuck,233,371);
        gState = new GameState();
        for(int i=0; i< NumberOfTargets ; i++){
            targets.add(i, new Bubble());
        }
        Greenfoot.setSpeed(50);
        //addObject(new duck(true),275,250);
        //addObject(new spring(200,0,-.1,0),250,250);
        //Greenfoot.start();

    }
    
    public MyWorld(Target T, int NumberOfTargets, GameState gState,String bGround){
        super(1500,800,1); 
        this.bGround = bGround;
        this.NumberOfTargets = 30;
        setBackground(new GreenfootImage(bGround));
        addObject(new ThrowArea(), 233, 371);
        addObject(new ScoreBoard(), 233,50);
        addObject(myDuck,233,371);
        gState = gState;
        for(int i=0; i< NumberOfTargets ; i++){
            targets.add(i, T);
        }
        Greenfoot.setSpeed(50);
        
    }
    //acts
    public void act(){
        spawning();
        setBackground(new GreenfootImage(bGround));
        
        //The duck's speed in the game
        for(int j=0;j<speed;j++){
            myDuck.simulate(1);
            myDuck.act();
        }
    }
    //receives information from the duck to draw a line between it and the mouse.
    public void drawLine(int a,int b,int c,int d){
        getBackground().drawLine(a,b,c,d);
    }

    
    //spawns the targets
    public void spawning(){
        if(spawnrate==200){
            if(lastSpawn<targets.size()){
                addObject(targets.get(targets.size()-lastSpawn),1431,700);
                spawnrate=0;
                lastSpawn++;
            }
        }
        spawnrate++;

    }
    // Replaces current duck with a new duck.
    public void dieDuck(){
        removeObject(myDuck);
        myDuck = new Duck();
        addObject(myDuck,233,371);
    }
    
    //returns GameState
    public GameState getGameState(){
    return gState;
    }
    
    
}
