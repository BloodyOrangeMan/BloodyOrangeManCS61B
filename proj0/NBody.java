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
        
    }
}
