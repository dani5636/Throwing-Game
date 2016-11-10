import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Target here.
 * 
 * @author Daniel   
 * @version 
 */
public abstract class Target extends Actor
{
   

    public void act() 
    {
        
        if(hit()){
            point();
        }
    }
    //Hit Collision
    public boolean hit(){
        Duck duck = (Duck)getOneIntersectingObject(Duck.class);
        return duck!=null;
    }
    //adds point to the gamestate that is carried in the world
    public void point(){
        GameState gState = ((MyWorld)getWorld()).getGameState();
        gState.addScore(1);
        System.out.println("it works!" + gState.getScore());
        getWorld().removeObject(this);

    }
}
