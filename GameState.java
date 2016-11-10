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
    private int scoreGoal, life;

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
        return "Score: " + score + "\nLives: " + life;
    }
    public int getLife(){
        return life;
    }
    public void substractLife(){
        life--;
    }
    public void addLife(){
        life++;
    }
    public void setScoreGoal(int score){
        scoreGoal= score;
    }
    public int getScoreGoal()
    {
    return scoreGoal;
    }
    public void setMaxLife(int life){
        this.life=life;
    }
}
