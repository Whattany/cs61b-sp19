public class NBody{
	public static double readRadius(String S){
		In in = new In(S);
		int N = in.readInt();
		double radius = in.readDouble();
		return radius;
	}
	public static Body[] readBodies(String S){
		In in = new In(S);
		int N = in.readInt();
		in.readDouble();
		Body[] bodys = new Body[5];
		
		for (int i=0; i<N ; i++){
            bodys[i] = new Body(in.readDouble(),in.readDouble(),in.readDouble(),
                            in.readDouble(),in.readDouble(),in.readString());
		}
		return bodys;
	}
    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Body[] bodies = readBodies(filename);
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-radius,radius);
        StdDraw.clear();
        StdDraw.picture(0,0,"images/starfield.jpg");
        StdDraw.show();
        
        for (double t=0; t<=T; t=t+dt ){
                double[] xForces = new double[bodies.length];
                double[] yForces = new double[bodies.length];

            for (int i=0; i<bodies.length; i++){
                xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
                yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
                
            }
            for (int i=0; i<bodies.length; i++){
                bodies[i].update(dt,xForces[i],yForces[i]);
            }

            StdDraw.picture(0,0,"images/starfield.jpg");
            for (int i=0; i<bodies.length; i++){
                bodies[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        //    StdDraw.clear();

        }
        StdOut.printf("%d\n", bodies.length);
        StdOut.printf("%.2e\n",radius);
        for (int i=0; i<bodies.length; i++){
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                    bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);
        }
    }
}
