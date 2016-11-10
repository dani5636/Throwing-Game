import java.util.ArrayList;
public class LevelInfo  
{   
    private static LevelInfo myLevelInfo=null;
    private static ArrayList<Level> levelInfo = new ArrayList<>();
    private static int cLevel;
    protected LevelInfo()
    {
        cLevel=0;
        levelInfo.add(new Level(new Bubble(), 30, 1450, 675, 3, 5, "BG.png", "Background.mp3"));
        levelInfo.add(new Level(new Balloon(), 25, 1450, 675, 4, 7, "BG2.png", "Background.mp3"));
        levelInfo.add(new Level(new Balloon(), 25, 1450, 675, 6, 10, "BG.png", "Background.mp3"));
    }

    public static LevelInfo getLevelInfo(){
        if(myLevelInfo==null){
            myLevelInfo= new LevelInfo();
        }
        return myLevelInfo; 
    }

    public Level getCurrentLevel(){
        if(cLevel<levelInfo.size()){
            return levelInfo.get(cLevel);
        }
        else{
            return null;
        }
    }

    public void setNextLevel(){
        if(cLevel+1<(levelInfo.size())){
            cLevel++;
        }
        else{
          
        }
    }

    public void setLastLevel(){
        if (cLevel != 0){
            cLevel--;
      
        }

        else{
         
        }
    }

    public void reset(){
        cLevel=0;
    }
}

 