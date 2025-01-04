public class NBody {
    public static double readRadius(String S){
        In in = new In(S);
        double Radius;
        in.readInt();
        Radius = in.readDouble();
        return Radius;
    }
    public static Planet[] readPlanets(String S){
        In in = new In(S);
        int N = in.readInt();
        in.readDouble();
        Planet[] planets = new Planet[N];
        for(int i = 0; i < planets.length; i++){
            planets[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());

        }
        return planets;
    }
    public static void main(String args[]){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);
        int waitTimeMilliseconds = 10;
        StdDraw.setScale(-radius,radius);
        StdAudio.play("audio/2001.mid");
        for(double t = 0; t <= T; t = t + dt){
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            StdDraw.enableDoubleBuffering();
            StdDraw.clear();
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (int i = 0; i < planets.length; i++){
               planets[i].draw();
               xForces[i] = planets[i].calcNetForceExertedByX(planets);
               yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for (int i = 0; i < planets.length; i++){
              planets[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.show();
            StdDraw.pause(waitTimeMilliseconds);
        }
       StdOut.printf("%d\n", planets.length);
       StdOut.printf("%.2e\n", radius);
       for (int i = 0; i < planets.length; i++){
          StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n", 
              planets[i].xxPos, planets[i].yyPos, planets[i].xxVel, planets[i].yyVel,
                  planets[i].mass, planets[i].imgFileName);
      
       }
    }
}
