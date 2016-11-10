/**
 * Write a description of class GameState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameState  
{
    // instance variables - replace the example below with your own
    private int time;
    private int score = 0;

    /**
     * Constructor for objects of class GameState
     */
    public GameState()
    {
    }

    public int getScore(){
        return score;
        
    }

    public void setScore(int i){
        score = i ;
    }

    public void addScore(int i){
        score = score+i;
    }

    @Override
    public String toString(){
        return "Score: " + score;
    }

}
