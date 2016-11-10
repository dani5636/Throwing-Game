import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Write a description of class Target here.
 * 
 * @author Daniel   
 * @version 
 */
public abstract class Target extends Actor
{

    private int speed= 1;
    private int x, y;
    private int rWind=1;
    private boolean isHit=false;
    public Target(){
    }

    public void act() 
    {

        move();
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
        if(!isHit){
            gState.addScore(1);
            isHit=true;
        }
        System.out.println("it works!" + gState.getScore());
        getImage().setTransparency(0);
    }

    public void move(){
        Random rand = new Random();

        if(5 > Greenfoot.getRandomNumber(100)+1)
        {
            rWind=-rWind;
        }

        this.setLocation(getX()+rWind, getY()-speed);
    }
}
