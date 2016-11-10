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
    private ScoreBoard sBoard;

    public MyWorld()
    {    
        // Create a new world with 20x20 cells with a cell size of 10x10 pixels.
        super(1500,800,1); 
        gState  = GameState.getGState(); 
        Level iLevel = LevelInfo.getLevelInfo().getCurrentLevel();
        bGround=iLevel.getbGround();
        numberOfTargets = iLevel.getNumberOfTargets();
        targetX= iLevel.getTargetX();
        targetY=iLevel.getTargetY();
        setBackground(new GreenfootImage(bGround));
        sBoard = ScoreBoard.getSBoard();
        addObject(new ThrowArea(), 233, 371);
        addObject(sBoard, 233,50);
        addObject(myDuck,233,371);
        for(int i=0; i< numberOfTargets ; i++){
            targets.add(i, new Bubble());
        }
        Greenfoot.setSpeed(50);
        gState.setMaxLife(iLevel.getMaxLife());
        gState.setScoreGoal(iLevel.getScoreGoal());

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
        winCheck();
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
        if(gState.getLife()==-1){
            
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
        if((gState.getScore()==gState.getScoreGoal()) || (Greenfoot.isKeyDown("e"))){
            LevelInfo iLevel = LevelInfo.getLevelInfo();
            iLevel.getNextLevel();
            if (iLevel.getCurrentLevel()!=null){
                MyWorld w = new MyWorld();
                Greenfoot.setWorld(w);
            }
            else {
                
            }
        }
        if((Greenfoot.isKeyDown("q"))){
            LevelInfo iLevel = LevelInfo.getLevelInfo();
            iLevel.setLastLevel();
            
            if (iLevel.getCurrentLevel()!=null){
                MyWorld w = new MyWorld();
                Greenfoot.setWorld(w);
            }
            else {
            }
        }
    }
}
