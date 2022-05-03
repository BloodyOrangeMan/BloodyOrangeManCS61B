public class NBody {
    public static double readRadius(String path){
        In in = new In(path);
        in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String path){
        In in = new In(path);
        int numOfPlanets = in.readInt();
        Planet[] planets = new Planet[numOfPlanets];
        in.readDouble();
        int i = 0;
        while(i < numOfPlanets){
            planets[i++] = new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
        }
        return planets;
    }

    public static void main(String[] args) {
        
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        double radius = readRadius(filename);

        StdDraw.setScale(-radius, radius);

        Planet[] planets = readPlanets(filename);

        StdDraw.enableDoubleBuffering();

        double[] xForces = new double[planets.length];
        double[] yForces = new double[planets.length];
        
        double times = 0;
        while(times < T){

            for(int i = 0;i<planets.length;i++){
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }

            for(int i = 0;i<planets.length;i++){
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.picture(1, 1, "images/starfield.jpg", radius * 2, radius * 2);

            for(Planet planet : planets) planet.draw();

            StdDraw.show();

            StdDraw.pause(10);

            times += dt;

        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                        planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                        planets[i].yyVel, planets[i].mass, planets[i].imgFileName);  
                    }
    }
}
