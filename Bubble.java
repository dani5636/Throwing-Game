import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bubbles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bubble extends Target
{
    private int speed= 1;

    /**
     * Act - do whatever the bubbles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Bubble()
    {  
        createImage();
    }

    public void act()
    {
        setLocation(getX(),getY()-speed);
        super.act();
        removeThisBubble();
    }  
    public boolean isTouchingCeiling()
    {
        return (getY() <= 10);
    }

    private void createImage()
    {
        setImage("transparent-bubble.png");
        int percentage = 15;
        GreenfootImage image = getImage();
        image.scale(image.getWidth()*percentage/100,image.getHeight()*percentage/100);

    }

    private void removeThisBubble()
    {
        if(isTouchingCeiling())
        {
            getWorld().removeObject(this);
        }
    }

}
