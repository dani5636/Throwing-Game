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
    private int numberOfTargets;
    private int targetX, targetY;
    private MyWorld nextLv;
    private ScoreBoard sBoard;
    public MyWorld()
    {    
        // Create a new world with 20x20 cells with a cell size of 10x10 pixels.
        super(1500,800,1); 
        bGround="BG.png";
        numberOfTargets = 30;
        targetX= 1450;
        targetY=675;
        setBackground(new GreenfootImage(bGround));
        addObject(new ThrowArea(), 233, 371);
        sBoard=new ScoreBoard();
         addObject(sBoard, 233,50);
        addObject(myDuck,233,371);
        gState = new GameState();
        for(int i=0; i< numberOfTargets ; i++){
            targets.add(i, new Bubble());
        }
        Greenfoot.setSpeed(50);
        gState.setMaxLife(5);
        gState.setScoreGoal(3);
        //addObject(new duck(true),275,250);
        //addObject(new spring(200,0,-.1,0),250,250);
        //Greenfoot.start();
    }

    public MyWorld(Target t, int numberOfTargets, int targetX, int targetY, int scoreGoal,int maxLife, GameState gState, String bGround,ScoreBoard scoreBoard){
        super(1500,800,1); 
        this.bGround = bGround;
        this.numberOfTargets = numberOfTargets;
        this.targetX= targetX;
        this.targetY = targetY;
        setBackground(new GreenfootImage(bGround));
        addObject(new ThrowArea(), 233, 371);
        sBoard=scoreBoard;
        addObject(myDuck,233,371);
        gState = gState;
        for(int i=0; i< numberOfTargets ; i++){
            targets.add(i, t);
        }
        Greenfoot.setSpeed(50);
        gState.setMaxLife(maxLife);
        gState.setScoreGoal(scoreGoal);
        gState.setScore(0);
    }
    //acts
    public void act(){
        spawning();
        setBackground(new GreenfootImage(bGround));
        winCheck();
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
                addObject(targets.get(targets.size()-lastSpawn),targetX,targetY);
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
        gState.substractLife();
        if(gState.getLife()==0){
            Greenfoot.stop();
        }
    }
    
    public int getTargetX(){
    return targetX;
    }
    public int getTargetY(){
    return targetY;
    }
    //returns GameState
    public GameState getGameState(){
        return gState;
    }
    public void winCheck(){
     if((nextLv!=null &&gState.getScore()==gState.getScoreGoal()) || (nextLv!=null && Greenfoot.isKeyDown("e"))){
        
        }
    }
}
