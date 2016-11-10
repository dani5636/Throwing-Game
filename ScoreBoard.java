import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class ScoreBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreBoard extends Actor
{
    /**
     * Act - do whatever the ScoreBoard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private String prefix = "Score: ";
    private final static Color transparent = new Color(0,0,0,0);
    private static ScoreBoard sBoard= null;
    
    protected ScoreBoard()
    {
    }
    public static ScoreBoard getSBoard(){
        if(sBoard==null){
        sBoard=new ScoreBoard();
        }
        return sBoard;
    }
    
    public void act() 
    {
        updateImage();
    }    
    private void updateImage()
    {
        GameState gState = ((MyWorld)getWorld()).getGameState();
        GreenfootImage image = new GreenfootImage(20, 20);
        GreenfootImage text = new GreenfootImage(gState.toString(), 32, Color.BLACK, transparent);
        
        if (text.getWidth() > image.getWidth() - 20)
        {
            image.scale(text.getWidth() + 20, image.getHeight());
        }
        if (text.getHeight() > image.getHeight() - 20)
        {
            image.scale(text.getWidth(), image.getHeight()+80);
        }
        
        image.drawImage(text,(image.getWidth()-text.getWidth())/2,(image.getHeight()-text.getHeight())/2);
        setImage(image);
    }
}
