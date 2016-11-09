import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.awt.Color;
import java.util.ArrayList;

public class MyWorld  extends World
{
    private static GameState GSTATE = new GameState();
    private ArrayList<Bubble> bubbles = new ArrayList<>();
    private int speed = 130;
    private int framerate = 60;
    private int spawnrate=320;
    private int lastSpawn=1;
    private String prefix = "score: ";
    private Duck myDuck = new Duck();
    private final static Color transparent = new Color(0,0,0,0);
   // private static GreenfootImage BGROUND = new GreenfootImage("BG.png");
    public MyWorld()
    {    
        // Create a new world with 20x20 cells with a cell size of 10x10 pixels.
        super(1500,800,1); 
        setBackground(new GreenfootImage("BG.png"));
        addObject(new ThrowArea(), 233, 371);
        
        addObject(myDuck,233,371);

        for(int i=0; i<30; i++){
            bubbles.add(i, new Bubble());
        }

        //addObject(new duck(true),275,250);
        //addObject(new spring(200,0,-.1,0),250,250);
        //Greenfoot.start();

    }

    public void act(){
        spawning();
        updateImage();
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
    }

    public void drawLine(int a,int b,int c,int d){
        getBackground().drawLine(a,b,c,d);
    }

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
        }
        spawnrate++;

    }

    public void dieDuck(){
        removeObject(myDuck);
        myDuck = new Duck();
        addObject(myDuck,233,371);
    }
    private void updateImage()
    {
        setBackground(new GreenfootImage("BG.png"));
        
        GreenfootImage text = new GreenfootImage(prefix + ": " + GSTATE.getScore(), 22, Color.BLACK, transparent);
        getBackground().drawImage(text , 500, 500);
        getBackground().setColor(Color.green);
    }
}
