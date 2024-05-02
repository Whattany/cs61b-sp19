public class Body{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public Body(double xP, double yP, double xV,
		double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	public Body(Body b){
		xxPos = b.xxPos;
                yyPos = b.yyPos;
                xxVel = b.xxVel;
                yyVel = b.yyVel;
                mass = b.mass;
                imgFileName = b.imgFileName;  
	}
	public double calcDistance(Body r){
		double distance = Math.sqrt(Math.pow((this.xxPos - r.xxPos),2)
						+Math.pow((this.yyPos - r.yyPos),2));		
		return distance;
	}
	public double calcForceExertedBy(Body r){
		final double G = 6.67e-11;
		double force = (G * this.mass * r.mass)
				/Math.pow((this.calcDistance(r)),2);
		return force;		

	}
	public double calcForceExertedByX(Body r){
		return this.calcForceExertedBy(r)*(r.xxPos - this.xxPos)
			/this.calcDistance(r);
	}
	public double calcForceExertedByY(Body r){
		return this.calcForceExertedBy(r)*(r.yyPos - this.yyPos)
                        /this.calcDistance(r);
        }
	public double calcNetForceExertedByX(Body[] r){
		double Netforce = 0;
		for (int i=0; i<r.length; i++){
			if (!this.equals(r[i])){
				Netforce = Netforce + this.calcForceExertedByX(r[i]);
			}
		}
		return Netforce;
        }
	public double calcNetForceExertedByY(Body[] r){
		double Netforce = 0;
                for (int i=0; i<r.length; i++){
                        if (!this.equals(r[i])){
                        	Netforce = Netforce + this.calcForceExertedByY(r[i]);
                        }

                }
                return Netforce;
        }

	public void update(double dt, double fX, double fY){
		double ax = fX/mass;
		double ay = fY/mass;
		xxVel = this.xxVel + dt*ax;
		yyVel = this.yyVel + dt*ay;
		xxPos = this.xxPos + dt*xxVel;
		yyPos = this.yyPos + dt*yyVel;			
	}
    public void draw(){
        StdDraw.enableDoubleBuffering();
        StdDraw.picture(xxPos,yyPos,"images/"+imgFileName);
        StdDraw.show();
    }


}
	
 
	
