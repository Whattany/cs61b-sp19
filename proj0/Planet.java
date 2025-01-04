public class Planet {
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;
    static final double G = 6.67e-11;
    public Planet(double xP, double yP, double xV,
                    double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Planet(Planet b){
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }
   public double calcDistance(Planet rocinante){
        double distance;
        distance = Math.sqrt((xxPos - rocinante.xxPos)*
                     (xxPos - rocinante.xxPos) + 
                       (yyPos - rocinante.yyPos)*
                          (yyPos - rocinante.yyPos));
        return distance;
   }
   public double calcForceExertedBy(Planet b){
	double F = G * mass * b.mass/(this.calcDistance(b) * this.calcDistance(b));
        return F;       
   }
   public double calcForceExertedByX(Planet b){
        double Fx = this.calcForceExertedBy(b) * (b.xxPos - xxPos) / this.calcDistance(b);
        return Fx;
   }    
   public double calcForceExertedByY(Planet b){
        double FY = this.calcForceExertedBy(b) * (b.yyPos - yyPos) / this.calcDistance(b);
        return FY;
   }
   public double calcNetForceExertedByX(Planet[] b){
       double fNetX = 0;
       for(int i = 0; i < b.length; i++){
           if (b[i] == this) {
               continue;
           }
           fNetX = fNetX + this.calcForceExertedByX(b[i]);
       }
       return fNetX;
   }
   public double calcNetForceExertedByY(Planet[] b){
       double fNetY = 0;
       for(int i = 0; i < b.length; i++) {
           if (b[i] == this) {
               continue;
           }
           fNetY = fNetY + this.calcForceExertedByY(b[i]);
       }
       return fNetY;
   }
   public void update(double t, double fX, double fY){
       this.xxVel = this.xxVel + t * fX / this.mass;
       this.yyVel = this.yyVel + t * fY / this.mass;
       this.xxPos = this.xxPos + t * this.xxVel;
       this.yyPos = this.yyPos + t * this.yyVel;
   }
   public void draw(){
       StdDraw.picture(xxPos, yyPos, "images/"+imgFileName);
   }
} 
