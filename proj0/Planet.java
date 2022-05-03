/**
 * A planet class containing the basic properties of a planet, such as position coordinates, vector coordinates, mass<\n>
 * @author BloodyOrangeMan
 */

public class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    /**
     * Setting the basic properties of the planets
     * @param xP
     * @param yP
     * @param xV
     * @param yV
     * @param m
     * @param img
     */
    public Planet(double xP, double yP, double xV,double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    
    /**
     * Copy a planet p
     * @param p
     */
     public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }
    
    /**
     * Calculating the distance between two planet
     * @param p
     * @return distance
     */
     public double calcDistance(Planet p){
        return Math.sqrt(Math.pow((this.xxPos - p.xxPos),2) + Math.pow((this.yyPos - p.yyPos),2));
    }
    
    /**
     * Calculating the force between two planet
     * @param p 
     * @return force
     */
     public double calcForceExertedBy(Planet p){
        double G = 6.67e-11;
        double distance = this.calcDistance(p);
        return G * this.mass * p.mass / (distance * distance);
    }
    
    /**
     * Calculating the Force Exerted By X
     * @param p
     * @return Force Exerted By X
     */
    public double calcForceExertedByX(Planet p){
        double force = calcForceExertedBy(p);
        double distance = calcDistance(p);
        return force * (p.xxPos - this.xxPos) / distance;
    }

    /**
     * Calculating the Force Exerted By Y
     * @param p
     * @return Force Exerted By Y
     */
    public double calcForceExertedByY(Planet p){
        double force = calcForceExertedBy(p);
        double distance = calcDistance(p);
        return force * (p.yyPos - this.yyPos) / distance;
    }
    
    /**
     * 
     * @param allPlanets
     * @return
     */
    public double calcNetForceExertedByX(Planet[] allPlanets){
        double sum=0;

        for(int i=0;i<allPlanets.length;i++){
            if(this.equals(allPlanets[i])){
                continue;
            }else{
                sum = sum + calcForceExertedByX(allPlanets[i]);
            }
            
        }

        return sum;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets){
        double sum=0;

        for(int i=0;i<allPlanets.length;i++){
            if(this.equals(allPlanets[i])){
                continue;
            }else{
                sum = sum + calcForceExertedByY(allPlanets[i]);
            }
            
        }

        return sum;
    }
    /**
     * Input the forces and update the condition of the planet
     * @param dt
     * @param fx
     * @param fy
     */
    public void update(double dt,double fx,double fy){
        double ax = fx / this.mass;
        double ay = fy / this.mass;
        
        this.xxVel = this.xxVel + (dt * ax);
        this.yyVel = this.yyVel + (dt * ay);

        this.xxPos = this.xxPos + (dt * xxVel);
        this.yyPos = this.yyPos + (dt * yyVel);
    }

    public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}