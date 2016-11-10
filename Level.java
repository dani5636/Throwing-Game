
/**
 * Write a description of class level here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Level {
    // instance variables - replace the example below with your own

    private Target t;
    private int numberOfTargets;
    private int targetX;
    private int targetY;
    private int scoreGoal;
    private int maxLife;
    private String bGround;
    
    /**
     * Constructor for objects of class level
     */
   
    public Level(Target t, int numberOfTargets, int targetX, int targetY, int scoreGoal, int maxLife, String bGround) {
        this.t = t;
        this.numberOfTargets = numberOfTargets;
        this.targetX = targetX;
        this.targetY = targetY;
        this.scoreGoal = scoreGoal;
        this.maxLife = maxLife;
        this.bGround = bGround;
    }

    //setters for everything
    public void setT(Target t) {
        this.t = t;
    }

    public void setNumberOfTargets(int numberOfTargets) {
        this.numberOfTargets = numberOfTargets;
    }

    public void setTargetX(int targetX) {
        this.targetX = targetX;
    }

    public void setTargetY(int targetY) {
        this.targetY = targetY;
    }

    public void setScoreGoal(int scoreGoal) {
        this.scoreGoal = scoreGoal;
    }

    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }


    public void setbGround(String bGround) {
        this.bGround = bGround;
    }
    
    
    //getters for all that is needed
    public Target getT() {
        return t;
    }

    public int getNumberOfTargets() {
        return numberOfTargets;
    }

    public int getTargetX() {
        return targetX;
    }

    public int getTargetY() {
        return targetY;
    }

    public int getScoreGoal() {
        return scoreGoal;
    }

    public int getMaxLife() {
        return maxLife;
    }
    
    public String getbGround() {
        return bGround;
    }
}
