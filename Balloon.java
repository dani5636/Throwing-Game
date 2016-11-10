
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
    
    public Balloon()
    {
        createImage();
    }

    public void act(){
        super.act();
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
