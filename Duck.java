import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.List;

public class Duck extends Actor
{
    double[] x = {-25,25,25,-25};
    double[] y = {-25,-25,25,25};
    double[] xprev = new double[4];
    double[] yprev = new double[4];
    double[] xv = {0,0,0,0};
    double[] yv = {0,0,0,0};
    double a,b,c,d,l,ang;
    int[] conect1 = {0,1,2,3,0,1};
    int[] conect2 = {1,2,3,0,2,3};
    double[] dl = new double[6];
    int animCounter=0;
    int flooredge=58;
    List springs;

    double x1,y1,x2=0,y2=0,r1,r2;
    int p=0;
    int[] points = new int[4];
    int pointer=0;
    boolean drag=false;
    boolean stick=false;
    int mx,my;
    myWorld world;
    boolean animNow= false;
    int type=1;
    GreenfootImage anim1, anim2;
    int point1,point2;

    public Duck(){
        for(int f=0;f<6;f++){
            dl[f] = Math.sqrt(Math.pow((x[conect1[f]] - x[conect2[f]]),2)+Math.pow((y[conect1[f]] - y[conect2[f]]),2));
        }
        //getImage().setTransparency(20);
        
        anim1 = new GreenfootImage("RubberDuck1.png");
        anim2= new GreenfootImage("RubberDuck2.png");
        anim1.scale(anim1.getWidth() - 128, anim1.getHeight() - 128);
        anim2.scale(anim2.getWidth() - 128, anim2.getHeight() - 128);
        anim1.mirrorVertically();
        anim2.mirrorVertically();
        anim1.mirrorHorizontally();
        anim2.mirrorHorizontally();
        setImage(anim1);
    }

    public Duck(boolean s){
        for(int f=0;f<6;f++){
            dl[f] = Math.sqrt(Math.pow((x[conect1[f]] - x[conect2[f]]),2)+Math.pow((y[conect1[f]] - y[conect2[f]]),2));
        }
        anim1 = new GreenfootImage("RubberDuck1.png");
        anim2= new GreenfootImage("RubberDuck2.png");
        anim1.scale(anim1.getWidth() - 128, anim1.getHeight() - 128);
        anim2.scale(anim2.getWidth() - 128, anim2.getHeight() - 128);
        setImage(anim1);
    }

    protected void addedToWorld(World w){
        world = (myWorld)w;
        for(int i=0;i<x.length;i++){
            x[i] += getX();
            y[i] += getY();
        }
        springs = getWorld().getObjects(Duck.class);
        for(int i=0;i<springs.size();i++){
            ((Duck)springs.get(i)).get();
        }
        for(int i=0;i<4;i++){
            xprev[i] = x[i];
            yprev[i] = y[i];
        }
    }
    //*****************************************************************************

    public void get(){
        springs = getWorld().getObjects(Duck.class);
    }

    //*****************************************************************************   
    public void act() 
    {
        //if(stick)return;
        if(animCounter==600){
        
            if (animNow == false){
            setImage(anim2);
            animCounter=0;
            animNow=true;
            }
            else{
            setImage(anim1);
            animCounter=0;
            animNow=false;
            }
        }
        pointer=0;
        for(int i=0;i<springs.size();i++){
            if((Duck)springs.get(i) != this){
                if(collision((Duck)springs.get(i),true)){
                    rebound((Duck)springs.get(i));
                }
            }
        }
        animCounter++;
    }    
    //*****************************************************************************
    public boolean collision(Duck s,boolean record){
        boolean in = false;

        for(int i=0;i<x.length;i++){
            in = in || s.pointIn(x[i],y[i]);
            if(s.pointIn(x[i],y[i])){
                if(record){
                    points[pointer] = i;
                    pointer++;
                }
            }
        }

        return in;
    }

    //******************************************************************************   

    public boolean pointIn(double a,double b){
        int[] testPoints = {0,1,2,3,0};
        boolean in=true;
        double x1,x0,y1,y0;

        for(int i=0;i<x.length;i++){
            x0 = x[testPoints[i]];
            x1 = x[testPoints[i+1]];
            y0 = y[testPoints[i]];
            y1 = y[testPoints[i+1]];
            in = in && ((b-y0)*(x1-x0)-(a-x0)*(y1-y0)>=0);
        }
        return in;
    }
    //******************************************************************************   

    public void rebound(Duck s){

        double time=0;
        boolean in = true;  

        Vector[] normals = new Vector[pointer];
        for(int i=0;i<pointer;i++){
            normals[i] = s.normal(xprev[points[i]],yprev[points[i]]);
            if(normals[i] == null){
                System.out.println("testing:");
                for(int j=0;j<4;j++){
                    System.out.print(xprev[j]+" : ");
                }
                System.out.println();
                for(int j=0;j<4;j++){
                    System.out.print(yprev[j]+" : ");
                }
                System.out.println();
                for(int j=0;j<4;j++){
                    x[j] = xprev[j];
                    y[j] = yprev[j];
                    s.x[j] = s.xprev[j];
                    s.y[j] = s.yprev[j]; 
                }
                System.out.println(collision(s,false));
                return;
            } 
            normals[i] = normals[i].getUnitVector();
        }

        //pause();
        double[] biasA = new double[pointer];
        double[] biasB = new double[pointer];
        double dist;
        for(int i=0;i<pointer;i++){
            dist = Math.sqrt(Math.pow(s.x[s.point1]-s.x[s.point2],2)+Math.pow(s.y[s.point1]-s.y[s.point2],2));
            biasA[i] = Math.sqrt(Math.pow(s.x[s.point1]-x[points[i]],2)+Math.pow(s.y[s.point1]-y[points[i]],2));
            biasB[i] = Math.sqrt(Math.pow(s.x[s.point2]-x[points[i]],2)+Math.pow(s.y[s.point2]-y[points[i]],2));
            biasA[i] = (dist-biasA[i])/dist;
            biasB[i] = (dist-biasB[i])/dist;

            if(biasB[i]>.95 || biasB[i]<.05){
                for(int f=0;f<4;f++){
                    double vx = getX()-s.getX();
                    double vy = getY()-s.getY();
                    xv[f] = .0001*vx;
                    yv[f] = .0001*vy;
                    s.xv[f] = -.0001*vx;
                    s.yv[f] = -.0001*vy;
                }
                while(collision(s,false) && !Greenfoot.isKeyDown("q")){
                    for(int f=0;f<4;f++){
                        x[f] += xv[f];
                        y[f] += yv[f];
                        s.x[f] += s.xv[f];
                        s.y[f] += s.yv[f];
                    }
                }
                return;
            }
        }

        while(in && !Greenfoot.isKeyDown("q")){
            in = false;
            for(int i=0;i<pointer;i++){
                if(!stick){
                    x[points[i]] += normals[i].xPart()/50.0;
                    y[points[i]] += normals[i].yPart()/50.0;
                    xv[points[i]] += normals[i].xPart()/100.0;
                    yv[points[i]] += normals[i].yPart()/100.0;
                }
                s.nudge(-normals[i].xPart()/50.0 , -normals[i].yPart()/50.0, biasA[i], biasB[i]);
                in = in || collision(s,false) || s.collision(this,false);
            }
        }

        for(int i=0;i<pointer;i++){
            //xv[points[i]] = 0;
            //yv[points[i]] = 0;

            /*
            s.normal(xprev[points[i]],yprev[points[i]]);
            x[points[i]] = xprev[points[i]];
            y[points[i]] = yprev[points[i]];

            s.x[s.point1] = s.xprev[s.point1];
            s.y[s.point1] = s.yprev[s.point1];
            s.x[s.point2] = s.xprev[s.point2];
            s.y[s.point2] = s.yprev[s.point2];
            s.xv[s.point1] = 0;
            s.yv[s.point1] = 0;
            s.xv[s.point2] = 0;
            s.yv[s.point2] = 0;
             */
        }

    }
    //******************************************************************************   
    public Vector normal(double a, double b){
        int[] testPoints = {0,1,2,3,0};
        double x1,x0,y1,y0;
        Vector n = null;
        int tries=0;

        for(int i=0;i<x.length;i++){
            x0 = xprev[testPoints[i]];
            x1 = xprev[testPoints[i+1]];
            y0 = yprev[testPoints[i]];
            y1 = yprev[testPoints[i+1]];
            if((b-y0)*(x1-x0)-(a-x0)*(y1-y0)<=0){
                point1 = testPoints[i];
                point2 = testPoints[i+1];
                n = new Vector(y1-y0,x0-x1);//x1-x0);
                tries++;
            }    
        }
        if(n == null)
            System.out.println("error!!!!");
        if(tries>1)
            System.out.println("overload!!");
        return n;
    }
    //******************************************************************************   
    public void pause(){
        for(int f=0;f<6;f++){
            world.drawLine((int)(x[conect1[f]]),(int)(y[conect1[f]]),(int)(x[conect2[f]]),(int)(y[conect2[f]]));
        }
        //world.repaint();
        //while(Greenfoot.isKeyDown("p")){}
        while(!Greenfoot.isKeyDown("p")){}

    }
    //******************************************************************************   
    public void step(double time, int dir){
        for(int i=0;i<4;i++){
            x[i] += dir*time*xv[i];
            y[i] += dir*time*yv[i];
            if(!stick)
                yv[i] += dir*time*.01;
        }
    }
    //******************************************************************************   
    public void nudge(double a, double b,double c, double d){
        //if(stick)return;
        xv[point1] += a*c;
        xv[point2] += a*d;
        yv[point1] += b*c;
        yv[point2] += b*d;
    }

    //******************************************************************************   

    public void simulate(int k){
        if(stick)return;

        for(int i=0;i<4;i++){
            xprev[i] = x[i];
            yprev[i] = y[i];
        }

        for(int f=0;f<6;f++){
            //world.drawLine((int)(x[conect1[f]]),(int)(y[conect1[f]]),(int)(x[conect2[f]]),(int)(y[conect2[f]]));
        }
        if(Greenfoot.mousePressed(this) || (Greenfoot.mousePressed(null) && type==3))
            drag = true;
        if(Greenfoot.mouseClicked(null) || Greenfoot.isKeyDown("q"))
            drag = false;
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null){
            mx = mouse.getX();
            my = mouse.getY();
        }
        if(drag){
            if(type!=2){
                world.drawLine((int)x[0],(int)y[0],mx,my);
                yv[0] += (my - y[0])/1500000.0;
                xv[0] += (mx - x[0])/1500000.0;
            }else{
                for(int f=0;f<4;f++){
                    yv[f] = (my - y[f])/500.0;
                    xv[f] = (mx - x[f])/500.0;
                }
            }
        }

        for(int f=0;f<4;f++){
            //if(Greenfoot.isKeyDown("down"))
            yv[f] = yv[f]+.00001;
            if(Greenfoot.isKeyDown("up"))
                yv[f] = yv[f]-.00001;
            if(Greenfoot.isKeyDown("right"))
                xv[f] = xv[f]+.00001;
            if(Greenfoot.isKeyDown("left"))
                xv[f] = xv[f]-.00001;
        }

        for(int m=0;m<k;m++){

            for(int f=0;f<6;f++){
                l = Math.sqrt(Math.pow((x[conect1[f]] - x[conect2[f]]),2)+Math.pow((y[conect1[f]] - y[conect2[f]]),2));
                l = dl[f]-l;
                l = l/10;

                ang = Math.atan2(y[conect1[f]]-y[conect2[f]],x[conect1[f]]-x[conect2[f]]);
                xv[conect1[f]] = xv[conect1[f]] + l*Math.cos(ang);
                xv[conect2[f]] = xv[conect2[f]] - l*Math.cos(ang);
                yv[conect1[f]] = yv[conect1[f]] + l*Math.sin(ang);
                yv[conect2[f]] = yv[conect2[f]] - l*Math.sin(ang);
            }

        
            for(int f=0;f<4;f++){
                xv[f] = .9999*xv[f];
                yv[f] = .9999*yv[f];

                x[f] = x[f] + xv[f];
                y[f] = y[f] + yv[f];
                if(y[f]>getWorld().getHeight()-flooredge){
                    yv[f] = 0;
                    y[f]=getWorld().getHeight()-flooredge;
                    xv[f]=.9*xv[f];
                }
                if(y[f]<0){
                    yv[f] = 0;
                    y[f]=0;
                    xv[f]=.9*xv[f];
                }
                if(x[f]<0){
                    yv[f]=.9*yv[f];
                    x[f]=0;
                    xv[f]=0;
                }
                if(x[f]>getWorld().getWidth()){
                    yv[f]=.9*yv[f];
                    x[f]=getWorld().getWidth();
                    xv[f]=0;
                }
            }

        }
        x1 = (x[0]+x[1]+x[2]+x[3])/4.0;
        y1 = (y[0]+y[1]+y[2]+y[3])/4.0;
        r1 = 180*Math.atan2(y[0]-y[1],x[0]-x[1])/Math.PI;
        setLocation((int)x2,(int)y2);
        setRotation((int)r2);
        if(Math.abs(x1-x2)>1.5 || Math.abs(y1-y2)>1.5 || Math.abs(r1-r2)>1.5){
            r2 = r1;
            x2 = x1;
            y2 = y1;
        }
        if(Greenfoot.isKeyDown("q")){
            Greenfoot.stop();
        }

    }
}
