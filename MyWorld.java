import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.awt.Color;
import java.util.ArrayList;

public class myWorld  extends World
{
    ArrayList<Duck> duckies = new ArrayList<>();
    int speed = 130;
    int framerate = 60;
    int spawnrate=0;
    int lastSpawn=1;
    public myWorld()
    {    
        // Create a new world with 20x20 cells with a cell size of 10x10 pixels.
        super(1500,800,1); 
        setBackground(new GreenfootImage("BG.png"));
        addObject(new Duck(),100,475);
        for(int i=0; i<30; i++){
            duckies.add(i, new Duck());
        }

        //addObject(new duck(true),275,250);
        //addObject(new spring(200,0,-.1,0),250,250);
        //Greenfoot.start();

    }

    public void act(){
        String str = Greenfoot.getKey();
        if(str!=null && str.equals("f")){
            framerate += 10;
            if(framerate>50)framerate=30;
            Greenfoot.setSpeed(framerate);
        }
        if(str!=null && str.equals("s")){
            speed += 60;
            if(speed>130)speed=10;
        }
        spawning();
        setBackground(new GreenfootImage("BG.png"));
        getBackground().setColor(Color.red);
        List duckes = getObjects(Duck.class);
        for(int j=0;j<speed;j++){
            for(int i=0;i<duckes.size();i++){
                ((Duck)duckes.get(i)).simulate(1);
            }
            for(int i=0;i<duckes.size();i++){
                ((Duck)duckes.get(i)).act();
            }
        }
        //System.out.println("move");
    }

    public void drawLine(int a,int b,int c,int d){
        getBackground().drawLine(a,b,c,d);
    }

    public void spawning(){
        if(spawnrate==500){
            addObject(duckies.get(duckies.size()-lastSpawn),500,500);
            spawnrate=0;
            lastSpawn++;
        }
        spawnrate++;

    }
}
