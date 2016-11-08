
import greenfoot.*;
import java.util.Random;
/**
 * Write a description of class Ballon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bubble extends Actor
{
    private int speed= 1;
    private int x, y;
    private int rwind=1;
    public Bubble()
    {
        x = 1400;
        y = 700;
        this.setLocation(x, y);
    }
    public void act(){
     Random rand = new Random();
     y=y-speed;
     
     if(5 > Greenfoot.getRandomNumber(100)+1)
     {
      rwind=-rwind;
      }
     x=x+rwind;
     this.setLocation(x,y);
     
     
    }
   
}
