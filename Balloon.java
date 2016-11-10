
import greenfoot.*;
import java.util.Random;
/**
 * Write a description of class Ballon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Balloon extends Target
{
    private int speed= 1;
    private int x, y;
    private int rwind=1;
    public Balloon()
    {
        createImage();
    }

    public void act(){
        super.act();
        move();
        

    }
    public void move()
    {
        Random rand = new Random();
        y=getY();
        y=y-speed;
        x=getX();
        if(5 > Greenfoot.getRandomNumber(100)+1)
        {
            rwind=-rwind;
        }
        x=x+rwind;
        this.setLocation(x,y);
        
    }
    private void removeThisBubble()
    {
        if(isTouchingCeiling())
        {
            getWorld().removeObject(this);
        }
    }
    public boolean isTouchingCeiling()
    {
        return (getY() <= 10);
    }
    private void createImage()
    {
        setImage("balloon1.png");
        int percentage = 15;
        GreenfootImage image = getImage();
        //image.scale(image.getWidth()*percentage/,image.getHeight()*percentage/100);

    }
    
}
