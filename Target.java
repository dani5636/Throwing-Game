import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Target here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Target extends Actor
{
    /**
     * Act - do whatever the Target wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static GameState gState = new GameState();
    public void act() 
    {
        // Add your action code here.
        if(hit()){
         point();
        }
    }
    public boolean hit(){
    Duck duck = (Duck)getOneIntersectingObject(Duck.class);
    return duck!=null;
    }
    public void point(){
    gState.addScore(1);
    System.out.println("it works!" + gState.getScore());
    getWorld().removeObject(this);
    
    }
}
