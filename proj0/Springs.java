public class Springs {
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        double[] rx = new double[n];
        double[] ry = new double[n];
        double[] vx = new double[n];
        double[] vy = new double[n];
        double particleMass = 1.0;
        double drag = 0.1;
        double springStrength = 0.1;
        double springLength = 30;
        double gravity = 1.0;
        double timeStep = 0.5;

        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.setPenRadius(0.0025);
        StdDraw.enableDoubleBuffering();

        for (int i = 0; i < n; i++){
            rx[i] = 100 * Math.random();
            ry[i] = 100 * Math.random();
        }

        while(true){
            double[] fx = new double[n];
            double[] fy = new double[n];

            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    if (i == j) continue;
                    double dx = rx[j] - rx[i];
                    double dy = ry[j] - ry[i];
                    double length = Math.sqrt(dx*dx + dy*dy);
                    double force = springStrength * (length - springLength);
                    double springForceX = force * dx / length;
                    double springForceY = force * dy / length;
                    fx[i] += springForceX;
                    fy[i] += springForceY;
                }
            }

            for (int i = 0; i < n; i++){
                fx[i] += -drag * vx[i];
                fy[i] += -drag * vx[i];
            }

            for (int i = 0; i < n; i++){
                fy[i] += -gravity;
            }

            rx[0] = StdDraw.mouseX();
            ry[0] = StdDraw.mouseY();
            vx[0] = 0.0;
            vy[0] = 0.0;
            fx[0] = 0.0;
            fy[0] = 0.0;

            for(int i = 0; i < n; i++){
                vx[i] += fx[i] * timeStep/particleMass;
                vy[i] += fy[i] * timeStep/particleMass;
                rx[i] += vx[i] * timeStep;
                ry[i] += vy[i] * timeStep;
            }
            StdDraw.clear();
            for (int i = 0; i < n; i++){
                StdDraw.filledCircle(rx[i], ry[i], 1.0);
                for(int j = 0; j < i; j++){
                    StdDraw.line(rx[i], ry[i], rx[j], ry[j]);
                }
            }
            StdDraw.show();
            StdDraw.pause(10);

        }
    }
}
